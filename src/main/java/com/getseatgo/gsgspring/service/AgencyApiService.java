package com.getseatgo.gsgspring.service;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.getseatgo.gsgspring.exceptions.ValidationException;
import com.getseatgo.gsgspring.model.AddBusesRequest;
import com.getseatgo.gsgspring.model.Address;
import com.getseatgo.gsgspring.model.Agent;
import com.getseatgo.gsgspring.model.Bus;
import com.getseatgo.gsgspring.model.BusRoute;
import com.getseatgo.gsgspring.model.CreateAbstractAgencyRequest;
import com.getseatgo.gsgspring.model.CreateAbstractAgencyResponse;
import com.getseatgo.gsgspring.model.UpdateAgencyDetailsRequest;
import com.getseatgo.gsgspring.model.entitymodel.AgencyInfo;
import com.getseatgo.gsgspring.model.entitymodel.BusInfo;
import com.getseatgo.gsgspring.model.entitymodel.BusRouteInfo;
import com.getseatgo.gsgspring.model.entitymodel.BusStop;
import com.getseatgo.gsgspring.model.entitymodel.BusWeeklySchedule;
import com.getseatgo.gsgspring.model.entitymodel.UserInfo;
import com.getseatgo.gsgspring.repository.AgencyInfoRepository;
import com.getseatgo.gsgspring.repository.BusInfoRepository;
import com.getseatgo.gsgspring.repository.BusRouteInfoRepository;
import com.getseatgo.gsgspring.repository.BusStopRepository;
import com.getseatgo.gsgspring.repository.BusWeeklyScheduleRepository;
import com.getseatgo.gsgspring.repository.UserInfoRepository;

import utils.UtilityMethods;

@Service
public class AgencyApiService {

	@Autowired
	private AgencyInfoRepository agencyInfoRepository;
	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private BusInfoRepository busInfoRepository;
	@Autowired
	private BusWeeklyScheduleRepository busWeeklyScheduleRepository;
	@Autowired
	private BusStopRepository busStopRepository;
	@Autowired
	private BusRouteInfoRepository busRouteInfoRepository;
	
	private Random random = new Random();
	
	
	/**Method to Validate Incoming request properties
	 * @param body
	 * @throws Exception
	 */
	public void validateCreateAbstractAgencyRequest(CreateAbstractAgencyRequest body) throws Exception {
		//name, email should not be null or redundant
		UtilityMethods.assertOverload(StringUtils.isEmpty(body.getName()), new ValidationException("Invalid Request Data"));
		UtilityMethods.assertOverload(StringUtils.isEmpty(body.getEamil()), new ValidationException("Invalid Request Data"));
		UtilityMethods.assertOverload(Objects.nonNull(agencyInfoRepository.findByAgencyName(body.getName())), new ValidationException("Agency Name: '"+body.getName()+"' Already Exist!!!"));
		UtilityMethods.assertOverload(Objects.nonNull(agencyInfoRepository.findByEmail(body.getEamil())), new ValidationException("Agency Email: '"+body.getEamil()+"' Already Exist!!!"));
	}

	/**Method to add (minimal agency data) and (default Agents Credentials)
	 * @param body
	 * @return
	 */
	public CreateAbstractAgencyResponse addAbstractAgencyAndAgents(CreateAbstractAgencyRequest body) {
		//if agent list is empty add default user
		AgencyInfo agencyInfo =transformCAARequestToAgencyInfo(body);
    	agencyInfo = agencyInfoRepository.save(agencyInfo);
    	CreateAbstractAgencyResponse response= new CreateAbstractAgencyResponse(body); 
    	
		// may fail with threads
		String randUsername="AU"+(String.format("%06d", random.nextInt(1000000)));
		while(userInfoRepository.existsByUsername(randUsername)) {
			randUsername="AU"+(String.format("%06d", random.nextInt(1000000)));
		}
		String randPassword="agentdefaultpass";
		UserInfo userInfo=new UserInfo(randUsername, 
				new BCryptPasswordEncoder().encode(randPassword), 
				agencyInfo);
		response.setAgent(new Agent(randUsername, randPassword));
		userInfoRepository.save(userInfo);
		return response;
	}

	/**Mapper Method
	 * @param body
	 * @return
	 */
	private AgencyInfo transformCAARequestToAgencyInfo(CreateAbstractAgencyRequest body) {
		AgencyInfo agencyInfo =new AgencyInfo();
    	agencyInfo.setAgencyName(body.getName().toUpperCase());
    	agencyInfo.setEmail(body.getEamil().toLowerCase());
		return agencyInfo;
	}

	/**Method to Update Agency details by Agent
	 * @param body
	 * @param username
	 * @throws Exception
	 */
	public void processAgencyDetailsRequest(UpdateAgencyDetailsRequest body, String username) throws Exception {
		//validate that user is agent 
		AgencyInfo agencyInfo=validateAgentUser(username);	
		
		//Update details
		if (StringUtils.isNotBlank(body.getPhone()))
			agencyInfo.setPhone(body.getPhone());
		if(StringUtils.isNotBlank(body.getBankDetails()))
			agencyInfo.setBankDetails(body.getBankDetails());
		if(Objects.nonNull(body.getAddress())) {
			Address add=body.getAddress();
			if(StringUtils.isNoneBlank(add.getCity()))
				agencyInfo.setCity(add.getCity());
			if(StringUtils.isNoneBlank(add.getState()))
				agencyInfo.setState(add.getState());
			if(StringUtils.isNoneBlank(add.getCountry()))
				agencyInfo.setCountry(add.getCountry());
			if(StringUtils.isNoneBlank(add.getHouseStreet()))
				agencyInfo.setHouseStreet(add.getHouseStreet());
			if(StringUtils.isNoneBlank(add.getPincode()))
				agencyInfo.setPincode(add.getPincode());
		}
		agencyInfoRepository.save(agencyInfo);
//		logger.info("Updated DB Agency Details for Agency : {}", agencyInfo.getAgencyName());
	}

	
	/**Method to validate user from token it should be Agent to make this request
	 * @param username
	 * @return
	 * @throws Exception
	 */
	private AgencyInfo validateAgentUser(String username) throws Exception {
		UserInfo userInfo=userInfoRepository.findByUsername(username);
		UtilityMethods.assertOverload(Objects.isNull(userInfo),new ValidationException("User Doesnot Exists!!!"));
		AgencyInfo agencyInfo=userInfo.getAgency();
		UtilityMethods.assertOverload(Objects.isNull(agencyInfo), new ValidationException("Invalid User Type - Not Linked to any Agency"));
//		logger.info("Validation Successfull for Agency : {}", agencyInfo.getAgencyName());
		return agencyInfo;
	}

	/**Methods to Handle New Bus Addition
	 * @param body
	 * @param username
	 * @throws Exception
	 */
	public void processAddBusRequest(AddBusesRequest body, String username) throws Exception {
		//***validate Agent user
		AgencyInfo agencyInfo = validateAgentUser(username);
		//validate incoming request
		UtilityMethods.assertOverload(Objects.isNull(body.getBuses()) || body.getBuses().isEmpty(), new ValidationException("Error : Incoming Request is Empty"));
		for (Bus bus:body.getBuses()) {
			UtilityMethods.assertOverload(Objects.isNull(bus), new ValidationException("Error : Incoming Request Bus List has Null Object"));
			UtilityMethods.assertOverload(StringUtils.isEmpty(bus.getBusName()), new ValidationException("Error : Incoming Request field, Bus Name is Empty"));
			UtilityMethods.assertOverload(StringUtils.isEmpty(bus.getBusNumber()), new ValidationException("Error : Incoming Request field, Bus Bumber is Empty"));
			UtilityMethods.assertOverload(StringUtils.isEmpty(bus.getStartBusStop()), new ValidationException("Error : Incoming Request field, Starting Bus Stop is Empty"));
			UtilityMethods.assertOverload(Objects.isNull(bus.getTotalSeat()), new ValidationException("Error : Incoming Request field, Total Seats in Bus is Empty"));
			UtilityMethods.assertOverload(StringUtils.isEmpty(bus.getDepartureTime()), new ValidationException("Error : Incoming Request field, Departure Timing of Bus is Empty"));
			UtilityMethods.assertOverload(Objects.isNull(bus.getBusRoutes()) || bus.getBusRoutes().isEmpty(), new ValidationException("Error : Incoming Request List, Bus Route is Empty"));
			for (int i=0; i<bus.getBusRoutes().size(); i++) {
				BusRoute busRoute =bus.getBusRoutes().get(i);
				UtilityMethods.assertOverload(StringUtils.isEmpty(busRoute.getBusStop()), new ValidationException("Error : Incoming Request Routes's Stop Name is Empty at index="+i));
				UtilityMethods.assertOverload(StringUtils.isEmpty(busRoute.getTravelDuration()), new ValidationException("Error : Incoming Request Routes's Travel Duration is Empty at index="+i));
				UtilityMethods.assertOverload(busRoute.getFares().isEmpty() || busRoute.getFares().size()!=(i+1), new ValidationException("Error : Incoming Request Routes's Fares Empty or size Mismatch at index="+i));
			}
			UtilityMethods.assertOverload(!(busInfoRepository.findByBusNameAndBusNumber(bus.getBusName(),bus.getBusNumber()).isEmpty()), new ValidationException("Error : Incoming Request field, Bus Name : '"+bus.getBusName()+"' and Bus Nummber :'"+bus.getBusNumber()+"' Already Exist"));
		}
//		logger.info("Validation Pass for Bus details from Agency: {} ",agencyInfo.getAgencyName());
		
		//***add details
		Map<String,BusStop> cacheBusStopMap=new HashMap<>();
		for (Bus bus:body.getBuses()) {
			//create BusInfo and add agency to it -> save()
			BusInfo busInfo =new BusInfo();
			busInfo.setBusName(bus.getBusName());
			busInfo.setBusNumber(bus.getBusNumber());
			busInfo.setTotalSeat(bus.getTotalSeat());
			busInfo.setAgency(agencyInfo);
			
			busInfo=busInfoRepository.save(busInfo);
			
			boolean[] scheduleArr=new boolean[] {bus.getMonday(),bus.getTuesday(),bus.getWednesday(),bus.getThursday(),bus.getFriday(),
					bus.getSaturday(),bus.getSunday()};
			BusStop beginBusStop=fetchBusStop(bus.getStartBusStop(),cacheBusStopMap);
			Duration departureDuration= parseDuration(bus.getDepartureTime());
			Duration gap= Duration.ZERO;
			char seq='A';
			String sequence=""+seq;
			
			for (int i=0; i<bus.getBusRoutes().size(); i++) {

				//create bus weeklySchedule (for every bus stop as start) & add bus to it ->save()
				BusWeeklySchedule busSchedule=createSchedule(busInfo,beginBusStop,scheduleArr,departureDuration.plus(gap).toDaysPart());
				busSchedule=busWeeklyScheduleRepository.save(busSchedule);
				
				//go in forloop and add route details for the bus -> save()
				for(int j=i;j<bus.getBusRoutes().size();j++) {
					
					BusRoute busRoute =bus.getBusRoutes().get(j);
					BusStop endBusStop = fetchBusStop(busRoute.getBusStop(),cacheBusStopMap);
					
					BusRouteInfo busRouteInfo =new BusRouteInfo();
					busRouteInfo.setBus(busInfo);
					busRouteInfo.setStartBusStop(beginBusStop);
					busRouteInfo.setEndBusStop(endBusStop);
					busRouteInfo.setFare(busRoute.getFares().get(i));
					busRouteInfo.setDepartureTimeInSec(departureDuration.plus(gap).toSeconds());
					busRouteInfo.setTravelDurationInSec(parseDuration(busRoute.getTravelDuration()).minus(gap).toSeconds());
					busRouteInfo.setRouteSeq(sequence);
					sequence+=(char)(seq+1+j);
					
					busRouteInfo=busRouteInfoRepository.save(busRouteInfo);
					
				}
				beginBusStop=fetchBusStop(bus.getBusRoutes().get(i).getBusStop(),cacheBusStopMap);
				gap=parseDuration(bus.getBusRoutes().get(i).getTravelDuration());
				sequence=""+(char)(seq+1+i);
			}
		
		}
	}

	/**Method to fetch busstop by name from dba nd store in map if not in map
	 * @param busStop
	 * @param cacheBusStopMap
	 * @return
	 */
	private BusStop fetchBusStop(String busStop, Map<String, BusStop> cacheBusStopMap) {
		if(!cacheBusStopMap.containsKey(busStop)) {
			BusStop bstop = busStopRepository.findByBusStopName(busStop);
			if (Objects.isNull(bstop))
				bstop=busStopRepository.save(new BusStop(busStop));
			cacheBusStopMap.put(busStop, bstop);
		}
		return cacheBusStopMap.get(busStop);		
	}

	/**Methods to convert String HH:MM:SS into Duration instancs
	 * @param travelDuration
	 * @return
	 */
	private Duration parseDuration(String travelDuration) {
		String[] travelDurationStringArr=travelDuration.split(":");
		Duration td=Duration.ofHours(Long.parseLong(travelDurationStringArr[0]))
				.plusMinutes(Long.parseLong(travelDurationStringArr[1]))
				.plusSeconds(Long.parseLong(travelDurationStringArr[2]));
		return td;
	}

	/** Methods to create Schedule Object with index given 
	 * Index will circulare the schedule, 
	 * like after ondeday monday data will be updated to tuesday
	 * 
	 * @param busInfo
	 * @param beginBusStop
	 * @param scheduleArr
	 * @param index
	 * @return
	 */
	private BusWeeklySchedule createSchedule(BusInfo busInfo, BusStop beginBusStop, boolean[] scheduleArr, long index) {
		BusWeeklySchedule busWeeklySchedule=new BusWeeklySchedule();
		busWeeklySchedule.setBus(busInfo);
		busWeeklySchedule.setStartBusStop(beginBusStop);
		busWeeklySchedule.setMonday(scheduleArr[Math.floorMod((0-index), 7)]);
		busWeeklySchedule.setTuesday(scheduleArr[Math.floorMod((1-index), 7)]);
		busWeeklySchedule.setWednesday(scheduleArr[Math.floorMod((2-index), 7)]);
		busWeeklySchedule.setThursday(scheduleArr[Math.floorMod((3-index), 7)]);
		busWeeklySchedule.setFriday(scheduleArr[Math.floorMod((4-index), 7)]);
		busWeeklySchedule.setSaturday(scheduleArr[Math.floorMod((5-index), 7)]);
		busWeeklySchedule.setSunday(scheduleArr[Math.floorMod((6-index), 7)]);
		
		return busWeeklySchedule;
	}
	
	
}

package com.getseatgo.gsgspring.service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getseatgo.gsgspring.exceptions.ValidationException;
import com.getseatgo.gsgspring.model.QueryRequest;
import com.getseatgo.gsgspring.model.QueryResponse;
import com.getseatgo.gsgspring.model.Result;
import com.getseatgo.gsgspring.model.entitymodel.AgencyInfo;
import com.getseatgo.gsgspring.model.entitymodel.BusDateSeatAvailabilityInfo;
import com.getseatgo.gsgspring.model.entitymodel.BusInfo;
import com.getseatgo.gsgspring.model.entitymodel.BusRouteInfo;
import com.getseatgo.gsgspring.repository.BusDateSeatAvailabilityInfoRepository;
import com.getseatgo.gsgspring.repository.BusStopRepository;

import utils.UtilityMethods;

@Service
public class AppApiService {
	
	private String dateFormat="dd-MM-yyyy";
	private DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired
    private BusStopRepository busStopRepository;
	@Autowired
    private BusDateSeatAvailabilityInfoRepository busDateSeatAvailabilityInfoRepository;
	
	
	public QueryResponse processSearchQuery(QueryRequest queryRequest) throws Exception {
		//***validate
		//date should be valid (not past - not too Future)
		//(src & dest) stops should exist
		UtilityMethods.assertOverload(Objects.isNull(queryRequest), new ValidationException("Request Object is Null"));
		UtilityMethods.assertOverload(StringUtils.isEmpty(queryRequest.getDateOfJourney()), new ValidationException("Date Input is Invalid"));
		Date date=DateUtils.parseDate(queryRequest.getDateOfJourney(), dateFormat);
		Date now=new Date();//use timezone TODO now.compareTo(date)>0
		UtilityMethods.assertOverload(now.after(date), new ValidationException("Date Input is Invalid"));
		UtilityMethods.assertOverload(!busStopRepository.existsByBusStopName(queryRequest.getSource()), 
				new ValidationException("Error : Source Bus Stop is Invalid"));
		UtilityMethods.assertOverload(!busStopRepository.existsByBusStopName(queryRequest.getDestination()), 
				new ValidationException("Error : Destination Bus Stop is Invalid"));
//		logger.info("Passed basic request validations");

		//***Process request
		//search BusDateSeatAVL & filster with date and src and dest 
		// map search result to response and return
		QueryResponse queryResponse=new QueryResponse();
		queryResponse.setResult(new ArrayList<>());
		java.sql.Date dt= new java.sql.Date(date.getTime());
		List<BusDateSeatAvailabilityInfo> searchresults = busDateSeatAvailabilityInfoRepository
				.findAllByJourneyDateAndBusRouteStartBusStopBusStopNameAndBusRouteEndBusStopBusStopName(
						dt, queryRequest.getSource(), queryRequest.getDestination());
			
		for ( BusDateSeatAvailabilityInfo searchresult:searchresults) {
			Result result=new Result();
			BusRouteInfo busRoute = searchresult.getBusRoute();
			BusInfo bus = busRoute.getBus();
			AgencyInfo agency = bus.getAgency();
			
			result.setBusId(bus.getId().toString());
			result.setSource(queryRequest.getSource());
			result.setDestination(queryRequest.getDestination());
			result.setDateOfJourney(queryRequest.getDateOfJourney());
			result.setBusNumber(bus.getBusNumber());
			result.setBusName(bus.getBusName());
			result.setAgencyName(agency.getAgencyName());
			result.setNoOfSeatsAvailable(searchresult.getSeatAvailable());
			
			Date dDate=(Date) date.clone();
			dDate=DateUtils.addSeconds(dDate,  busRoute.getDepartureTimeInSec().intValue()); // error may occur because narrowing down type from long to int
			result.setDepartureTime(dateFormater.format(dDate));
			dDate=DateUtils.addSeconds(dDate,  busRoute.getTravelDurationInSec().intValue()); // error may occur because narrowing down type from long to int
			result.setArrivalTime(dateFormater.format(dDate));
			
			result.setFareForOneSeat(busRoute.getFare());
			
			queryResponse.getResult().add(result);
		}
		
		return queryResponse;
	}
	
	
}

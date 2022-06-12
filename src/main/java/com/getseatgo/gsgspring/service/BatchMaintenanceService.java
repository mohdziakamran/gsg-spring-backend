package com.getseatgo.gsgspring.service;


import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getseatgo.gsgspring.exceptions.ValidationException;
import com.getseatgo.gsgspring.model.entitymodel.BusDateSeatAvailabilityInfo;
import com.getseatgo.gsgspring.model.entitymodel.BusWeeklySchedule;
import com.getseatgo.gsgspring.repository.BusDateSeatAvailabilityInfoRepository;
import com.getseatgo.gsgspring.repository.BusWeeklyScheduleRepository;

import utils.UtilityMethods;

@Service
public class BatchMaintenanceService {
	
	private String dateFormat="dd-MM-yyyy";

	@Autowired
	private BusDateSeatAvailabilityInfoRepository busDateSeatAvailabilityInfoRepository;
	

	@Autowired
	private BusWeeklyScheduleRepository busWeeklyScheduleRepository;
	
	public void startExecution(String date, String username) throws Exception {
		//***validation
		//check Date should not exist already
		//check user must be Super Admin
		validateAdminUser(username);
		//TODO check why date is getting saved one day before
		Date dt=DateUtils.parseDate(date, dateFormat); 
		java.sql.Date sqlDt=new java.sql.Date(dt.getTime());
		List<BusDateSeatAvailabilityInfo> findAllByJourneyDate = 
				busDateSeatAvailabilityInfoRepository.findAllByJourneyDate(sqlDt);
		UtilityMethods.assertOverload(!findAllByJourneyDate.isEmpty(), 
				new ValidationException("Error : Date Already Exist"));
		
		//***Execute
		// extract weekday from date
		//search List<Schedule> based on weekday=true
		// merge List<merged object> - BusRouteInfo & busWeeklySchedule where (busId, StartBusStopId ) matches
		// iterate through list and SAVE()
		String weekday=UtilityMethods.getDayOfWeek(date).toUpperCase();
		List<BusWeeklySchedule> schedules=busWeeklyScheduleRepository.findAllByDay(weekday);
		for (BusWeeklySchedule schedule: schedules) {
			if (Objects.nonNull(schedule) && Objects.nonNull(schedule.getRoute()) && Objects.nonNull(schedule.getRoute().getBus())){
				BusDateSeatAvailabilityInfo bdsai=new BusDateSeatAvailabilityInfo(sqlDt, schedule.getRoute(), schedule.getRoute().getBus().getTotalSeat());
				busDateSeatAvailabilityInfoRepository.save(bdsai);
			}
		}
		
		
	}
	/**Method to validate user from token it should be Agent to make this request
	 * @param username
	 * @return
	 * @throws Exception
	 */
	private void validateAdminUser(String username) throws Exception {
		UtilityMethods.assertOverload(!StringUtils.equalsIgnoreCase(username, "admin"), new ValidationException("Invalid User Type - Not Privillaged user"));
//		logger.info("Validation Successfull for Agency : {}", agencyInfo.getAgencyName());
	}
	
}

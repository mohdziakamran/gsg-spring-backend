package com.getseatgo.gsgspring.service;


import org.springframework.stereotype.Service;

@Service
public class BatchMaintenanceService {
	

	public void startExecution(String date, String username) {
		//TODO
		//***validation
		//check Date should not exist already
		//check user must be Super Admin
		
		//***Execute
		// extract weekday from date
		//search List<Schedule> based on weekday=true
		// merge List<merged object> - BusRouteInfo & busWeeklySchedule where (busId, StartBusStopId ) matches
		// iterate through list and SAVE()
		
	}
	
}

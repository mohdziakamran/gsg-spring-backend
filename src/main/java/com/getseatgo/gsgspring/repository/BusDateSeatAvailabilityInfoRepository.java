package com.getseatgo.gsgspring.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getseatgo.gsgspring.model.entitymodel.BusDateSeatAvailabilityInfo;

@Repository
public interface BusDateSeatAvailabilityInfoRepository extends JpaRepository<BusDateSeatAvailabilityInfo,Long> {
	
	List<BusDateSeatAvailabilityInfo> findAllByJourneyDate(Date journeyDate);
	
	 List<BusDateSeatAvailabilityInfo> findAllByJourneyDateAndBusRouteStartBusStopBusStopNameAndBusRouteEndBusStopBusStopName(Date journeyDate, String startBusStopBusStopName, String endBusStopBusStopName);
}

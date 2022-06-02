package com.getseatgo.gsgspring.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getseatgo.gsgspring.model.entitymodel.BusStop;
import com.getseatgo.gsgspring.repository.BusStopRepository;

@Service
public class BusStopService {
	
	@Autowired
    private BusStopRepository busStopRepository;

	public List<String> fetchAllBusStopNames() throws Exception {
		List<String> allBusStopNames=new ArrayList<>();
		try {
			busStopRepository.findAll().forEach(busStop -> allBusStopNames.add(busStop.getBusStopName()));
		} catch (Exception e) {
//			logger.info("Failed to load data from DB with Error:",e.getMessage());
			throw new Exception("Failed to load Bus Stop List data from DB");
		}
		
		return allBusStopNames;
	}

	public BusStop fetchBusStop(String sourceBusStop) throws Exception {
		BusStop busStop;
		try {
			busStop= busStopRepository.findByBusStopName(sourceBusStop);
		} catch (Exception e) {
//			logger.info("Failed to load data from DB with Error:",e.getMessage());
			throw new Exception("Failed to load Bus Stop data from DB");
		}
		return busStop;
	}
	
	
}

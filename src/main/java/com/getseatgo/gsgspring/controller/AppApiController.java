package com.getseatgo.gsgspring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.getseatgo.gsgspring.model.QueryRequest;
import com.getseatgo.gsgspring.service.BusStopService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "AppApi", description = "App Api Call controller")
public class AppApiController {
	
	@Autowired
	private BusStopService busStopService;
	
	@GetMapping("/all-bus-stops")
	public ResponseEntity<?> getAllBusStops(){
		List<String> allBusStopNames;
		try {
			allBusStopNames=busStopService.fetchAllBusStopNames();
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		return ResponseEntity.ok(allBusStopNames);
	}
	
	@PostMapping("/booking-query")
	public ResponseEntity<?> getQueryResult(@RequestBody QueryRequest queryRequest){
		//TODO Logic to fetch details absed on bate and src and desination
		return null;
	}
	
	@PostMapping("/current-seats-avl")
	public ResponseEntity<?> getSeatsAvl(@RequestBody Object queryRequest){
		//TODO 
		return null;
	}
	
	@PostMapping("/tid-query")
	public ResponseEntity<?> getTicketDetails(@RequestBody Object queryRequest){
		//TODO 
		return null;
	}	
	
}

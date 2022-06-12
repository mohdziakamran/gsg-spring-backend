package com.getseatgo.gsgspring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.getseatgo.gsgspring.exceptions.ValidationException;
import com.getseatgo.gsgspring.model.QueryRequest;
import com.getseatgo.gsgspring.model.QueryResponse;
import com.getseatgo.gsgspring.service.AppApiService;
import com.getseatgo.gsgspring.service.BusStopService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "App-Apis", description = "App Api Call controller")
public class AppApiController {
	
	@Autowired
	private BusStopService busStopService;
	
	@Autowired
	private AppApiService appApiService;
	
	
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
	
	@PostMapping("/search-query")
	public ResponseEntity<?> getQueryResult(@RequestBody QueryRequest queryRequest){
		// Logic to fetch details absed on bate and src and desination
		QueryResponse response=null; 
		try {
			response=appApiService.processSearchQuery(queryRequest);
		} catch (Exception e) {
			//logger.info("Exception occured while Search Query, Error: {}",e.getMessage());
			if (e instanceof ValidationException)
				return ResponseEntity.badRequest().body(e.getMessage());
			return ResponseEntity.badRequest().body("Internal Server Error");
		}
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/current-seats-avl")
	public ResponseEntity<?> getSeatsAvl(@RequestBody Object queryRequest){
		
		return null;
	}
	
	@PostMapping("/tid-query")
	public ResponseEntity<?> getTicketDetails(@RequestBody Object queryRequest){
		//TODO 
		return null;
	}	
	
}

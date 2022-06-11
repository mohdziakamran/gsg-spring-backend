package com.getseatgo.gsgspring.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.getseatgo.gsgspring.config.JwtToken;
import com.getseatgo.gsgspring.service.BatchMaintenanceService;

import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Maintenance-Apis", description = "API for DB Maintenance")
@RestController
public class BatchMaintenanceApiController {

	@Autowired
	private BatchMaintenanceService batchMaintenanceService;
	@Autowired
	private JwtToken jwtToken;


    @PutMapping("/fillinventory")
    public ResponseEntity<?> createAbstractAgency(@RequestParam (value = "for-date", required = true) String date,
    		@RequestHeader(value="Authorization") String bearerToken){
    	try {
    		String username = jwtToken.getUsernameFromToken(bearerToken.split(" ")[1]);
    		batchMaintenanceService.startExecution(date,username);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    	return ResponseEntity.ok("Success");
    }
    
}

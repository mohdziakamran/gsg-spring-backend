package com.getseatgo.gsgspring.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.getseatgo.gsgspring.config.JwtToken;
import com.getseatgo.gsgspring.model.CreateAbstractAgencyRequest;
import com.getseatgo.gsgspring.model.CreateAbstractAgencyResponse;
import com.getseatgo.gsgspring.model.UpdateAgencyDetailsRequest;
import com.getseatgo.gsgspring.service.AgencyApiService;

import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Agency-Apis", description = "API for Agency Users")
@RestController
public class AgencyApiController {

	@Autowired
	private AgencyApiService agencyService;
	@Autowired
	private JwtToken jwtToken;


    /**
     * It (first-step) creates Agency and its agents users with minimal data 
     * @param body
     * @return
     */
    @PostMapping("/create-abstract-agency")
    public ResponseEntity<?> createAbstractAgency(@RequestBody CreateAbstractAgencyRequest body){
    	CreateAbstractAgencyResponse response;
    	try {
    		agencyService.validateCreateAbstractAgencyRequest(body);
    		response=agencyService.addAbstractAgencyAndAgents(body);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    	return ResponseEntity.ok(response);
    }
    
    @PostMapping("/update-agency-details")
    public ResponseEntity<?> updateAgencyDetails(@RequestBody UpdateAgencyDetailsRequest body,
    		@RequestHeader(value="Authorization") String bearerToken){
    	
    	try {
    		String username = jwtToken.getUsernameFromToken(bearerToken.split(" ")[1]);
    		agencyService.validateAndUpdateAgencyDetailsRequest(body,username);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    	return ResponseEntity.ok("Successfully Updated Agency Details");
    }
    
    

}

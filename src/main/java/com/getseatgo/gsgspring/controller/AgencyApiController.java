package com.getseatgo.gsgspring.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.getseatgo.gsgspring.config.JwtToken;
import com.getseatgo.gsgspring.model.AddBusesRequest;
import com.getseatgo.gsgspring.model.Bus;
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

    
    /**Update Agency details endpoint for Agents
     * @param body
     * @param bearerToken
     * @return
     */
    @PostMapping("/update-agency-details")
    public ResponseEntity<?> updateAgencyDetails(@RequestBody UpdateAgencyDetailsRequest body,
    		@RequestHeader(value="Authorization") String bearerToken){
    	
    	try {
    		String username = jwtToken.getUsernameFromToken(bearerToken.split(" ")[1]);
    		agencyService.processAgencyDetailsRequest(body,username);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    	return ResponseEntity.ok("Successfully Updated Agency Details");
    }
    
    @PostMapping("/add-buses")
    public ResponseEntity<?> addBusDetails(@RequestBody AddBusesRequest body,
    		@RequestHeader(value="Authorization") String bearerToken){
    	
    	try {
    		String username = jwtToken.getUsernameFromToken(bearerToken.split(" ")[1]);
    		agencyService.processAddBusRequest(body,username);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    	return ResponseEntity.ok("Successfully Added Bus/Buses Details");
    }
    
    @DeleteMapping("/delete-bus")
    public ResponseEntity<?> removeBus(@RequestParam (value = "busname", required = true) String busName,
    		@RequestParam (value = "busnumber", required = true) String busNumber,
    		@RequestHeader(value="Authorization") String bearerToken){
    	try {
    		String username = jwtToken.getUsernameFromToken(bearerToken.split(" ")[1]);
    		agencyService.processDeleteBusRequest(username,busName,busNumber);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    	return ResponseEntity.ok("success");
    }
    
    @PostMapping("modifybusdetails")
    public ResponseEntity<?> updateBus(@RequestParam (value = "busname", required = true) String busName,
    		@RequestParam (value = "busnumber", required = true) String busNumber,
    		@RequestBody Bus body,
    		@RequestHeader(value="Authorization") String bearerToken){
    	try {
    		String username = jwtToken.getUsernameFromToken(bearerToken.split(" ")[1]);
    		agencyService.processUpdateBusRequest(username,busName,busNumber,body);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    	return ResponseEntity.ok("success");
    }

}

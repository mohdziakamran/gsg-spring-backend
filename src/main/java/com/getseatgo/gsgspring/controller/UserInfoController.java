package com.getseatgo.gsgspring.controller;



import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.getseatgo.gsgspring.config.JwtToken;
import com.getseatgo.gsgspring.exceptions.ValidationException;
import com.getseatgo.gsgspring.model.CreateUserRequest;
import com.getseatgo.gsgspring.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import utils.UtilityMethods;


@Tag(name = "UserInfo", description = "API for userinfo")
@RestController
public class UserInfoController {


	final private UserService userService;
	final private JwtToken jwtToken;
	
//    private HashData hashData = new HashData();

    public UserInfoController(UserService userService, JwtToken jwtToken) {
        this.userService = userService;
		this.jwtToken = jwtToken;
    }

//    @Operation(summary = "Create a new user", description = "Create a new user with username , fullname and password", tags = { "userinfo" })
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "successful operation",
//                    content = @Content(schema = @Schema(implementation = UserInfo.class))) })
    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest body) throws NoSuchAlgorithmException {
    	try {
    		//1. validate the incoming request
    		userService.validateCreateUserIncomingRequest(body);
			
    		//2. pass request to service layer
			UtilityMethods.assertOverload(Objects.isNull(userService.addUser(body)), new ValidationException("Couldnot Add New User!!!"));
    			
		} catch (Exception e) {
			//logger.info("Exception occured while Adding New User, Error: {}",e.getMessage());
			if (e instanceof ValidationException)
				return ResponseEntity.badRequest().body(e.getMessage());
			return ResponseEntity.badRequest().body("Internal Server Error");
		}
    	return ResponseEntity.ok("Successfully Created New User");
    }
    
    @GetMapping("/getuserdetails")
    public ResponseEntity<?> getUserDetailsFromToken(@RequestHeader(value="Authorization") String bearerToken){
    	try {
    		String username = jwtToken.getUsernameFromToken(bearerToken.split(" ")[1]);
        	return ResponseEntity.ok(userService.fetchUserDetailsByUserName(username));
		} catch (Exception e) {
			//logger.info("Exception occured while Adding New User, Error: {}",e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage()); 
		}
    }
    
//    @GetMapping("/home")
//    public ResponseEntity<String> home() {
//    	return ResponseEntity.ok("Welcome HOme");
//    }

}

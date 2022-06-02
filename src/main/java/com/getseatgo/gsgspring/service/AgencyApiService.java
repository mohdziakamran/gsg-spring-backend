package com.getseatgo.gsgspring.service;


import java.util.Objects;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.getseatgo.gsgspring.exceptions.ValidationException;
import com.getseatgo.gsgspring.model.Address;
import com.getseatgo.gsgspring.model.Agent;
import com.getseatgo.gsgspring.model.CreateAbstractAgencyRequest;
import com.getseatgo.gsgspring.model.CreateAbstractAgencyResponse;
import com.getseatgo.gsgspring.model.UpdateAgencyDetailsRequest;
import com.getseatgo.gsgspring.model.entitymodel.AgencyInfo;
import com.getseatgo.gsgspring.model.entitymodel.UserInfo;
import com.getseatgo.gsgspring.repository.AgencyInfoRepository;
import com.getseatgo.gsgspring.repository.UserInfoRepository;

import utils.UtilityMethods;

@Service
public class AgencyApiService {

	@Autowired
	private AgencyInfoRepository agencyInfoRepository;
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	private Random random = new Random();
	
	
	/**Method to Validate Incoming request properties
	 * @param body
	 * @throws Exception
	 */
	public void validateCreateAbstractAgencyRequest(CreateAbstractAgencyRequest body) throws Exception {
		//name, email should not be null or redundant
		UtilityMethods.assertOverload(StringUtils.isEmpty(body.getName()), new ValidationException("Invalid Request Data"));
		UtilityMethods.assertOverload(StringUtils.isEmpty(body.getEamil()), new ValidationException("Invalid Request Data"));
		UtilityMethods.assertOverload(Objects.nonNull(agencyInfoRepository.findByAgencyName(body.getName())), new ValidationException("Agency Name: '"+body.getName()+"' Already Exist!!!"));
		UtilityMethods.assertOverload(Objects.nonNull(agencyInfoRepository.findByEmail(body.getEamil())), new ValidationException("Agency Email: '"+body.getEamil()+"' Already Exist!!!"));
	}

	/**Method to add (minimal agency data) and (default Agents Credentials)
	 * @param body
	 * @return
	 */
	public CreateAbstractAgencyResponse addAbstractAgencyAndAgents(CreateAbstractAgencyRequest body) {
		//if agent list is empty add default user
		AgencyInfo agencyInfo =transformCAARequestToAgencyInfo(body);
    	agencyInfo = agencyInfoRepository.save(agencyInfo);
    	CreateAbstractAgencyResponse response= new CreateAbstractAgencyResponse(body); 
    	
		// may fail with threads
		String randUsername="AU"+(String.format("%06d", random.nextInt(1000000)));
		while(userInfoRepository.existsByUsername(randUsername)) {
			randUsername="AU"+(String.format("%06d", random.nextInt(1000000)));
		}
		String randPassword="agentdefaultpass";
		UserInfo userInfo=new UserInfo(randUsername, 
				new BCryptPasswordEncoder().encode(randPassword), 
				agencyInfo);
		response.setAgent(new Agent(randUsername, randPassword));
		userInfoRepository.save(userInfo);
		return response;
	}

	/**
	 * Mapper Method 
	 * @param body
	 * @return
	 */
	private AgencyInfo transformCAARequestToAgencyInfo(CreateAbstractAgencyRequest body) {
		AgencyInfo agencyInfo =new AgencyInfo();
    	agencyInfo.setAgencyName(body.getName().toUpperCase());
    	agencyInfo.setEmail(body.getEamil().toLowerCase());
		return agencyInfo;
	}

	public void validateAndUpdateAgencyDetailsRequest(UpdateAgencyDetailsRequest body, String username) throws Exception {
		//validate that user is agent 
		UserInfo userInfo=userInfoRepository.findByUsername(username);
		UtilityMethods.assertOverload(Objects.isNull(userInfo),new ValidationException("User Doesnot Exists!!!"));
		AgencyInfo agencyInfo=userInfo.getAgency();
		UtilityMethods.assertOverload(Objects.isNull(agencyInfo), new ValidationException("Invalid User Type - Not Linked to any Agency"));
//		logger.info("Validation Successfull for Agency : {}", agencyInfo.getAgencyName());
		
		//Update details
		if (StringUtils.isNotBlank(body.getPhone()))
			agencyInfo.setPhone(body.getPhone());
		if(StringUtils.isNotBlank(body.getBankDetails()))
			agencyInfo.setBankDetails(body.getBankDetails());
		if(Objects.nonNull(body.getAddress())) {
			Address add=body.getAddress();
			if(StringUtils.isNoneBlank(add.getCity()))
				agencyInfo.setCity(add.getCity());
			if(StringUtils.isNoneBlank(add.getState()))
				agencyInfo.setState(add.getState());
			if(StringUtils.isNoneBlank(add.getCountry()))
				agencyInfo.setCountry(add.getCountry());
			if(StringUtils.isNoneBlank(add.getHouseStreet()))
				agencyInfo.setHouseStreet(add.getHouseStreet());
			if(StringUtils.isNoneBlank(add.getPincode()))
				agencyInfo.setPincode(add.getPincode());
		}
		agencyInfoRepository.save(agencyInfo);
//		logger.info("Updated DB Agency Details for Agency : {}", agencyInfo.getAgencyName());
	}
	
	
}

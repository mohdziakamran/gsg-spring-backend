package com.getseatgo.gsgspring.service;


import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.getseatgo.gsgspring.exceptions.ValidationException;
import com.getseatgo.gsgspring.model.Address;
import com.getseatgo.gsgspring.model.CreateUserRequest;
import com.getseatgo.gsgspring.model.FetchUserDetailsResponse;
import com.getseatgo.gsgspring.model.entitymodel.UserInfo;
import com.getseatgo.gsgspring.repository.UserInfoRepository;

import utils.UtilityMethods;

@Service
public class UserService {

    public UserInfoRepository userInfoRepository;

    public UserService(final UserInfoRepository userInfoRepository){
    	this.userInfoRepository = userInfoRepository;
    }
    
    /**
     * Method to add New User
     * @param body
     * @return
     * @throws Exception
     */
    public UserInfo addUser(CreateUserRequest body) throws Exception {
	//1. check if user exist in db (throw UserAlreadyExist)
    	UtilityMethods.assertOverload(userInfoRepository.existsByUsername(body.getUsername()), new ValidationException("Username already existed"));
	//2. save to DB & return UserInfo
		UserInfo userInfo = transformCreateUserRequestToUserInfo(body);
		return userInfoRepository.save(userInfo);
    }

	/**
	 * Utility Mapper Method CreateUserRequest -> UserInfo  
	 * @param createUserRequest
	 * @return
	 */
	private UserInfo transformCreateUserRequestToUserInfo(CreateUserRequest createUserRequest) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(createUserRequest.getUsername());
		userInfo.setEmail(createUserRequest.getUsername());
		userInfo.setFullname(createUserRequest.getFirstname()+"#"+createUserRequest.getLastname());
		userInfo.setPassword(new BCryptPasswordEncoder().encode(createUserRequest.getPassword()));
		userInfo.setPhone(createUserRequest.getPhone());
		userInfo.setIsactive(false);
		return userInfo;
	}

	/**
	 * Method to fetch User details from db and map to api model
	 * @param username
	 * @return
	 */
	public FetchUserDetailsResponse fetchUserDetailsByUserName(String username) {
		UserInfo userInfo = userInfoRepository.findByUsername(username);
		FetchUserDetailsResponse fetchUserDetailsResponse = transformUserInfoToFetchUserDetailsResponse(userInfo);
		return fetchUserDetailsResponse;
	}

	/**
	 * Utility Mapper Method UserInfo -> FetchUserDetailsResponse
	 * @param userInfo
	 * @return
	 */
	private FetchUserDetailsResponse transformUserInfoToFetchUserDetailsResponse(UserInfo userInfo) {
		FetchUserDetailsResponse fetchUserDetailsResponse = new FetchUserDetailsResponse();
		//TODO-mapping
		String[] names=userInfo.getFullname().split("#");
		if (names.length>0 && StringUtils.isNotEmpty(names[0]))
			fetchUserDetailsResponse.setFirstname(names[0]);
		if (names.length>1 && StringUtils.isNotEmpty(names[1]))
			fetchUserDetailsResponse.setLastname(names[1]);
		fetchUserDetailsResponse.setPhone(userInfo.getPhone());
		Address address=new Address(userInfo.getHouseStreet(), 
				userInfo.getCity(), userInfo.getPincode(), 
				userInfo.getCountry(), userInfo.getState());
		fetchUserDetailsResponse.setAddress(address);
		
		return fetchUserDetailsResponse;
	}

	public void validateCreateUserIncomingRequest(CreateUserRequest body) throws Exception {
		UtilityMethods.assertOverload(Objects.isNull(body) , new ValidationException("Invalid Payload Body Exception"));
		UtilityMethods.assertOverload(StringUtils.isEmpty(body.getUsername()) , new ValidationException("Invalid Payload Email/Username Exception"));
		UtilityMethods.assertOverload(StringUtils.isEmpty(body.getPassword()) , new ValidationException("Invalid Payload Password Exception"));
		UtilityMethods.assertOverload(StringUtils.isEmpty(body.getFirstname()) , new ValidationException("Invalid Payload Firstname Exception"));
		UtilityMethods.assertOverload(StringUtils.isEmpty(body.getLastname()) , new ValidationException("Invalid Payload Lasttname Exception"));
	}

//    @Transactional(readOnly = true)
//    public List<Blog> getAllBlogs(final int count){
//        return this.blogRepository.findAll().stream().limit(count).collect(Collectors.toList());
//    }
//
//    @Transactional(readOnly = true)
//    public Optional<Blog> getBlog(final int id){return this.blogRepository.findById(id);}
}

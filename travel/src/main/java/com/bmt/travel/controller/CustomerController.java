package com.bmt.travel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bmt.travel.Exception.DataNotFoundException;
import com.bmt.travel.common.BMT_EndPoints;
import com.bmt.travel.dto.CommonResponseDto;
import com.bmt.travel.dto.CreateUserRequestDto;
import com.bmt.travel.dto.FindUserRequestDto;
import com.bmt.travel.model.CreateUserModel;
import com.bmt.travel.service.CustomerCreateService;

@RestController
public class CustomerController {
	
	public static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerCreateService customerService;

	@PostMapping(value= "/helloUsers")
	public String getString() {
		return "Hello BMT Users";
	}
	
	@PostMapping(value=BMT_EndPoints.CREATE_USER)
	public ResponseEntity<CommonResponseDto> createUser(@RequestBody CreateUserRequestDto request) 
			throws DataNotFoundException{
		logger.info("Inside the Create User of Customer Controller");
		logger.info("Request: "+request);
		
		String ERROR = "";
		
		if(request.getCustomerName().equalsIgnoreCase("") || null == request.getCustomerName()) {
			ERROR = "Customer Name is blank";
		}
		
		if(request.getEmailId().equalsIgnoreCase("") || null == request.getEmailId()) {
			ERROR = "Email Id is blank";
		}
		
		if(request.getMobileNo().equalsIgnoreCase("") || null == request.getMobileNo()) {
			ERROR = "Mobile number is blank";
		}
		
		if(request.getMobileNo().length()<10 || request.getMobileNo().length()>10 ) {
			ERROR = "Mobile number is not correct";
		}
		
		if(request.getPassword().equalsIgnoreCase("") || null == request.getPassword()) {
			ERROR = "Password is blank";
		}
		
		if(request.getRePassword().equalsIgnoreCase("") || null == request.getRePassword()) {
			ERROR = "Reenter Password is blank";
		}
		
		if(!request.getPassword().equalsIgnoreCase(request.getRePassword())) {
			ERROR = "Password and Reenter Password is not matched";
		}
		
		CreateUserModel response = null;
		CommonResponseDto finalResponse = null;
		finalResponse = new CommonResponseDto();
		try {
			if(ERROR.equalsIgnoreCase("")) {
				response = customerService.storeData(request);
				if(response != null) {
					finalResponse.setId(String.valueOf(response.getId()));
					finalResponse.setCustomerName(response.getCustomerName());
					finalResponse.setUserId(response.getUserId());
					finalResponse.setCode("200");
					finalResponse.setErrorCode(null);
					finalResponse.setRemarks("Saved Successfully!!!\nYour User ID is: "+response.getUserId());
					return new ResponseEntity<CommonResponseDto>(finalResponse, HttpStatus.OK);
				}
				else {
					finalResponse.setId(null);
					finalResponse.setCustomerName(null);
					finalResponse.setUserId(null);
					finalResponse.setCode(null);
					finalResponse.setErrorCode("300");
					finalResponse.setRemarks("Mobile number is already in use.");
					return new ResponseEntity<CommonResponseDto>(finalResponse, HttpStatus.INTERNAL_SERVER_ERROR);

				}
			} else {
				finalResponse.setId(null);
				finalResponse.setCustomerName(null);
				finalResponse.setUserId(null);
				finalResponse.setCode(null);
				finalResponse.setErrorCode("300");
				finalResponse.setRemarks(ERROR);
				return new ResponseEntity<CommonResponseDto>(finalResponse, HttpStatus.INTERNAL_SERVER_ERROR);

			}
		}catch (Exception ex) {
			logger.info(ex.getLocalizedMessage());
			finalResponse.setId(null);
			finalResponse.setCustomerName(null);
			finalResponse.setUserId(null);
			finalResponse.setCode(null);
			finalResponse.setErrorCode("300");
			finalResponse.setRemarks(ex.getLocalizedMessage());
			return new ResponseEntity<CommonResponseDto>(finalResponse, HttpStatus.INTERNAL_SERVER_ERROR);

		}	
	}
	
	@PostMapping(value=BMT_EndPoints.FIND_USER)
	public ResponseEntity<CommonResponseDto> findUserInfo(@RequestBody FindUserRequestDto request){
		
		logger.info("Inside the findUserInfo of Customer Controller");
		logger.info("Request :: "+ request);
		
		String ERROR = "";
		if(request.getSearchBy().isEmpty() || null == request.getSearchBy()) {
			ERROR = "Request Error";
		}
		
		if(request.getSearchValue().isEmpty() || null == request.getSearchValue()) {
			ERROR = "Request Error";
		}
		
		CreateUserModel response = null;
		CommonResponseDto finalResponse = null;
		finalResponse = new CommonResponseDto();
		try {
			if(ERROR.equalsIgnoreCase("")) {
				response = customerService.findUserInfo(request);
			} else {
				finalResponse.setId(null);
				finalResponse.setCustomerName(null);
				finalResponse.setUserId(null);
				finalResponse.setCode(null);
				finalResponse.setErrorCode("300");
				finalResponse.setRemarks(ERROR);
				return new ResponseEntity<CommonResponseDto>(finalResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			if(response != null) {
				finalResponse.setId(String.valueOf(response.getId()));
				finalResponse.setCustomerName(response.getCustomerName());
				finalResponse.setUserId(response.getUserId());
				finalResponse.setCode("200");
				finalResponse.setErrorCode(null);
				finalResponse.setEmailId(response.getEmailId());
				finalResponse.setMobileNo(response.getMobileNo());				
				finalResponse.setRemarks("Found Successfully!!!\nYour User ID is: "+response.getUserId());
				return new ResponseEntity<CommonResponseDto>(finalResponse, HttpStatus.OK);
			} else {
				finalResponse.setId(null);
				finalResponse.setCustomerName(null);
				finalResponse.setUserId(null);
				finalResponse.setCode(null);
				finalResponse.setErrorCode("300");
				finalResponse.setRemarks("Mobile number is NOT exist.");
				return new ResponseEntity<CommonResponseDto>(finalResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch(Exception ex) {
			logger.info(ex.getLocalizedMessage());
			finalResponse.setId(null);
			finalResponse.setCustomerName(null);
			finalResponse.setUserId(null);
			finalResponse.setCode(null);
			finalResponse.setErrorCode("300");
			finalResponse.setRemarks(ex.getLocalizedMessage());
			return new ResponseEntity<CommonResponseDto>(finalResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}

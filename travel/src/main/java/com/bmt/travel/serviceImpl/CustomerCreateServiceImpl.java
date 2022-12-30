package com.bmt.travel.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmt.travel.common.BMT_utils;
import com.bmt.travel.controller.CustomerController;
import com.bmt.travel.dao.CustomerDao;
import com.bmt.travel.dto.CreateUserRequestDto;
import com.bmt.travel.dto.FindUserRequestDto;
import com.bmt.travel.model.CreateUserModel;
import com.bmt.travel.service.CustomerCreateService;

@Service
public class CustomerCreateServiceImpl implements CustomerCreateService{

	public static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public CreateUserModel storeData(CreateUserRequestDto res) {
		// TODO Auto-generated method stub
		String id = getByMobileNo(res.getMobileNo());
		if(!id.equalsIgnoreCase("0")){
			return null;
		}
		CreateUserModel model = new CreateUserModel();
		model.setCustomerName(res.getCustomerName());
		model.setUserId("BMT"+BMT_utils.getValue());
		logger.info("BMT"+BMT_utils.getValue());
		model.setEmailId(res.getEmailId());
		model.setMobileNo(res.getMobileNo());
		model.setPassword(res.getPassword());
		
		return customerDao.save(model);
	}
	
	public String getByMobileNo(String mobileNo) {
		String id = customerDao.findByMobileNo(mobileNo);
		logger.info(id);
		if(id == null)
			return "0";
		else
			return id;
	}

	@Override
	public CreateUserModel findUserInfo(FindUserRequestDto res) {
		// TODO Auto-generated method stub
		logger.info("Inside the findUserInfo of CustomerCreateServiceImpl");
		logger.info("Request :: "+ res);
		
		CreateUserModel model = null;
		if(res.getSearchBy().equalsIgnoreCase("mobile_no")){
			model = customerDao.findUserInfobyMobileNo(res.getSearchValue());
		} else if(res.getSearchBy().equalsIgnoreCase("user_id")) {
			model = customerDao.findUserInfobyUserId(res.getSearchValue());
		}
		
		
		return model;
	}
	
	

}

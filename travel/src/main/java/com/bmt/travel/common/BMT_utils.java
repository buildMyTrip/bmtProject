package com.bmt.travel.common;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bmt.travel.controller.CustomerController;

public class BMT_utils {
	public static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	public static String getValue() {
		// TODO Auto-generated method stub
		  
		LocalDateTime now = LocalDateTime.now();  
		String date = String.valueOf(Math.abs(now.hashCode()));
		logger.info(date);
		return date;
	}
}

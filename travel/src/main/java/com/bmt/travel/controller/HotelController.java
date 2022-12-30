package com.bmt.travel.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

	public static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@PostMapping(value= "/helloHotels")
	public String getString() {
		//return "Hello BMT partners";
		
		
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("dipu", "kundu");
		hm.put("dipu", "roy");
		
		hm.get("dipu");
		System.out.println(hm.get("dipu"));
		
		
		
		return null;
	}
}

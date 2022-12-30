package com.bmt.travel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bmt.travel.model.CreateUserModel;

public interface CustomerDao extends JpaRepository<CreateUserModel, Integer>{

	@Query(value="SELECT t.id from bmt_customer_info t where t.mobile_no = ?1", nativeQuery= true)
	String findByMobileNo(String mobile_no);
	
	@Query(value="SELECT * from bmt_customer_info t where t.mobile_no = ?1", nativeQuery= true)
	CreateUserModel findUserInfobyMobileNo(String searchValue);
	
	@Query(value="SELECT * from bmt_customer_info t where t.user_id = ?1", nativeQuery= true)
	CreateUserModel findUserInfobyUserId(String searchValue);
}

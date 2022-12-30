package com.bmt.travel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bmt_customer_info")
public class CreateUserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID")
	private int id;
	@Column(name = "USER_ID", unique= true)
	private String userId;
	@Column(name ="CUSTOMER_NAME")
	private String customerName;
	@Column(name ="EMAIL_ID")
	private String emailId;
	@Column(name ="MOBILE_NO", unique=true)
	private String mobileNo;
	@Column(name ="PASSWORD")
	private String password;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "CreateUserModel [id=" + id + ", customerName=" + customerName + ", emailId=" + emailId + ", mobileNo="
				+ mobileNo + ", password=" + password + "]";
	}
	
	
}

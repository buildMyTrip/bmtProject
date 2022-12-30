package com.bmt.travel.dto;

public class CreateUserRequestDto {

	private String customerName;
	private String emailId;
	private String mobileNo;
	private String password;
	private String rePassword;
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
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	@Override
	public String toString() {
		return "CreateUserRequestDto [customerName=" + customerName + ", emailId=" + emailId + ", mobileNo=" + mobileNo
				+ ", password=" + password + ", rePassword=" + rePassword + "]";
	}

	
}

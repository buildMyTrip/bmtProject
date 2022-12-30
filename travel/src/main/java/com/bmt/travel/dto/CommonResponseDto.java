package com.bmt.travel.dto;

public class CommonResponseDto {

	private String id;
	private String reponseMsg;
	private String code;
	private String time;
	private String errorCode;
	private String customerName;
	private String userId;
	private String remarks;
	private String mobileNo;
	private String emailId;
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReponseMsg() {
		return reponseMsg;
	}
	public void setReponseMsg(String reponseMsg) {
		this.reponseMsg = reponseMsg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "CommonResponseDto [id=" + id + ", reponseMsg=" + reponseMsg + ", code=" + code + ", time=" + time
				+ ", errorCode=" + errorCode + ", customerName=" + customerName + ", userId=" + userId + ", remarks="
				+ remarks + ", mobileNo=" + mobileNo + ", emailId=" + emailId + "]";
	}
	
	
	
}

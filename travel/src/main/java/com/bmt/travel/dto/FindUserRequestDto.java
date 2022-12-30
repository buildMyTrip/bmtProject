package com.bmt.travel.dto;

public class FindUserRequestDto {

	private String searchBy;
	private String searchValue;
	public String getSearchBy() {
		return searchBy;
	}
	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	@Override
	public String toString() {
		return "FindUserRequestDto [searchBy=" + searchBy + ", searchValue=" + searchValue + "]";
	}
	
	
}

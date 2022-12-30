package com.bmt.travel.service;

import com.bmt.travel.dto.CreateUserRequestDto;
import com.bmt.travel.dto.FindUserRequestDto;
import com.bmt.travel.model.CreateUserModel;

public interface CustomerCreateService {

	CreateUserModel storeData(CreateUserRequestDto res);
	CreateUserModel findUserInfo(FindUserRequestDto res);
}

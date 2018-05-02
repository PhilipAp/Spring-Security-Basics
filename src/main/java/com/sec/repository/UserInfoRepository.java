package com.sec.repository;

import com.sec.entity.UserInfo;

public interface UserInfoRepository {
	
	public UserInfo getActiveUser(String userName);

}

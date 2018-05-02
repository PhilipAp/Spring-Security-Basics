package com.sec.repository.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sec.entity.UserInfo;
import com.sec.repository.UserInfoRepository;


@Repository
@Transactional
public class UserInfoRepositoryImpl implements UserInfoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public UserInfo getActiveUser(String userName) {
		UserInfo userInfo = new UserInfo();
		Integer ENABLED = 1;
		List<?> list = entityManager.createQuery("SELECT u FROM UserInfo u WHERE userName=? and enabled= ?")
				.setParameter(1, userName).setParameter(2, ENABLED).getResultList();
		if(!list.isEmpty()) {
			userInfo = (UserInfo) list.get(0);
		}
		return userInfo;
	}

}

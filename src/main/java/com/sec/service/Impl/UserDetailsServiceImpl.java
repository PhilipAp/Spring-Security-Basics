package com.sec.service.Impl;

import java.util.Collection;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sec.entity.UserInfo;
import com.sec.repository.UserInfoRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserInfoRepository userInfoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo = userInfoRepository.getActiveUser(username);
		GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
		
		@SuppressWarnings("unchecked")
		User user =  new User(userInfo.getUsername(), userInfo.getPasskey(), (Collection<? extends GrantedAuthority>) Arrays.asList(authority));
		
		UserDetails userDetails = (UserDetails)user;
		return userDetails;
	}

}

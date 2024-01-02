package com.example.demo3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo3.config.CustomUserData;
import com.example.demo3.model.UserData;
import com.example.demo3.repository.UserDataRepository;

@Component
public class CustomUserDataService implements UserDetailsService{
	
	@Autowired
	private UserDataRepository userDataRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserData userData=userDataRepository.findByEmail(username);
		if(userData==null) {
			throw new UsernameNotFoundException(username);
		}else {
			return new CustomUserData(userData);
		}
	}

}

package com.example.demo3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo3.model.UserData;
import com.example.demo3.repository.UserDataRepository;

@Service
public class UserDataServiceImpl implements UserDataService{
	
	@Autowired
	private UserDataRepository userDataRepository;
	
	private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

	@Override
	public UserData saveUser(UserData userData) {
		String password=passwordEncoder.encode(userData.getPassword());
		userData.setPassword(password);
		UserData userDatas=userDataRepository.save(userData);
		return userDatas;
	}

}

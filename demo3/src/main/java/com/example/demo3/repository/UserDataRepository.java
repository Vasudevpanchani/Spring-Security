package com.example.demo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo3.model.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long>{
	
	public UserData findByEmail(String email);
	
}

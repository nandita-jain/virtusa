package com.examly.springapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.LoginModel;
import com.examly.springapp.entity.User;

public interface SignupRepository extends JpaRepository<User, String> {
	
}


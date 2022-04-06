package com.examly.springapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.UserModel;
import java.util.*;


import com.examly.springapp.entity.Media;


public interface MediaVaultRepository extends JpaRepository<Media, Integer> {
	List<Media> findByUser_Email(String email);
	
}


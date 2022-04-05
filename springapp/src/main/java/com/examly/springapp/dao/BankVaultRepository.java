package com.examly.springapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.UserModel;
import java.util.*;
import com.examly.springapp.dao.BankVaultRepository;
import com.examly.springapp.entity.Bank;


public interface BankVaultRepository extends JpaRepository<Bank, Integer> {
	List<Bank> findByUser_Email(String email);
}
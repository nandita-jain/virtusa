package com.examly.springapp.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class SignupController{
    
    @Autowired
    private SignupService signupService;

    @RequestMapping(value="/signup", method = RequestMethod.POST, consumes = "application/json")	
	public Boolean checkUser(@RequestBody UserModel user)
	{
		return signupService.saveUser(user);
	}
}
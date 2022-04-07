package com.examly.springapp.controller;

import com.examly.springapp.service.LoginService;
import com.examly.springapp.model.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	public Boolean checkUser(@RequestBody LoginModel data) {
		return loginService.checkUser(data);
	}
}

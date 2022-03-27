package com.examly.springapp.service;


import org.springframework.stereotype.Service;
import com.examly.springapp.entity.User;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.dao.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SignupService {
    @Autowired
    private SignupRepository signupRepository;

    public Boolean saveUser(UserModel userModel){
        
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());
        user.setMobileNumber(userModel.getMobileNumber());
        user.setActive(true);
        user.setRole("user");
        signupRepository.save(user);
		
        return true;
    }
}

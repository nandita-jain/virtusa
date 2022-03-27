package com.examly.springapp.service;
import com.examly.springapp.dao.LoginRepository;
import com.examly.springapp.model.LoginModel;
import com.examly.springapp.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.entity.User;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Boolean checkUser(LoginModel data){
        
        User userModel=loginRepository.findByEmail(data.getEmail().trim());
		
        if(userModel.getPassword().equals(data.getPassword()))
        {
            // if(userModel.getRole().equals("admin"))
            // {
            //     //todo
            // }
                return true;
            
            
        }else{
			return false;
        }
    }
    
}

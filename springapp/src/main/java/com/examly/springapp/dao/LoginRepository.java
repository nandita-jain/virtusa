package com.examly.springapp.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.entity.User;
public interface LoginRepository extends JpaRepository<User, String> {
	User findByEmail(String email);
}

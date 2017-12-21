package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.Entity.User;
import com.springmvc.repository.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers()
    {
        return this.userRepository.getAllUsers();
    }
//    
//    public Integer createUser(User user)
//    {
//        return this.userRepository.createUser(user);
//    }
    public void saveUser(User user) {
    		this.userRepository.saveUser(user);
    }
}

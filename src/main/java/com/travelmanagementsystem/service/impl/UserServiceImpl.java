package com.travelmanagementsystem.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.travelmanagementsystem.entity.User;
import com.travelmanagementsystem.repository.UserRepository;
import com.travelmanagementsystem.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;


	
	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public int Register(User u) {
		
		User savedUser = userRepo.save(u);
		if (savedUser.getId() > 0) {
		    return 1;
		} else {
		    return 0;
		}
	}

	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		User user = userRepo.findByUsername(username);
		if (user != null && passwordEncoder.matches(password, user.getPassword())) {
		    return user;
		} else {
		    // login failed
			return null;
		}
	}

}

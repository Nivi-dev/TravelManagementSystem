package com.travelmanagementsystem.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.travelmanagementsystem.entity.User;

public interface UserService {
	List<User> getAllUsers();
	int Register(User u);
	User findByUsername(String username);
	User login(String username, String password);
}

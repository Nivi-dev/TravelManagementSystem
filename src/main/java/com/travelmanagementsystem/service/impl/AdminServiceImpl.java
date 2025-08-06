package com.travelmanagementsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelmanagementsystem.entity.Admin;
import com.travelmanagementsystem.repository.AdminRepository;
import com.travelmanagementsystem.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
    private AdminRepository adminRepo;
	
	
	@Override
	public Admin login(String username, String password) {
		// TODO Auto-generated method stub
		return adminRepo.findByUsernameAndPassword(username, password);
	}

}

package com.travelmanagementsystem.service;

import com.travelmanagementsystem.entity.Admin;

public interface AdminService {
	Admin login(String username, String password);
}

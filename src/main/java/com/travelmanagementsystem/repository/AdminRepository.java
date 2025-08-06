package com.travelmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelmanagementsystem.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

	Admin findByUsername(String username);

	Admin findByUsernameAndPassword(String username, String password);
}


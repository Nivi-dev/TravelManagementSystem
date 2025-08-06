package com.travelmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelmanagementsystem.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	//User findByUsernameAndPassword(String username, String password);	
	
	User findByUsername(String username);

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);

	boolean existsByPhone(String phone);
}

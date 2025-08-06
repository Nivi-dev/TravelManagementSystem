package com.travelmanagementsystem.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.travelmanagementsystem.entity.Admin;
import com.travelmanagementsystem.repository.AdminRepository;

@Service("customAdminDetailsService")
public class CustomAdminDetailsService implements UserDetailsService {


	@Autowired
    private AdminRepository adminRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepo.findByUsername(username);
        if (admin == null) throw new UsernameNotFoundException("Admin not found");

        return new org.springframework.security.core.userdetails.User(
            admin.getUsername(),
            admin.getPassword(),
            Collections.singleton(new SimpleGrantedAuthority(admin.getRole())));

    }

}

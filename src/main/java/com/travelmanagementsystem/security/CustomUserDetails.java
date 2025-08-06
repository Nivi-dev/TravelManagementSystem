package com.travelmanagementsystem.security;

import java.util.Collection;
import java.util.Collections;

import com.travelmanagementsystem.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.travelmanagementsystem.entity.User;

public class CustomUserDetails implements UserDetails {
	

	 private User user;

	 public CustomUserDetails(User user) {
	     this.user = user;
	 }
	    
	
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Assuming your User has a getRole() method that returns a string like "ROLE_USER"
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword(); // Make sure it's encoded!
    }

    @Override
    public String getUsername() {
        return user.getUsername(); // Or user.getUsername(), depending on your login field
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // You can customize this later
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // You can add a locked field in User if needed
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Same here
    }

    @Override
    public boolean isEnabled() {
        return true; // Or user.isEnabled() if you have that
    }

    public User getUser() {
        return user;
    }
}

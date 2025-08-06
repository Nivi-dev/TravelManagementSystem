package com.travelmanagementsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.travelmanagementsystem.entity.Admin;
import com.travelmanagementsystem.repository.AdminRepository;
import com.travelmanagementsystem.security.CustomAdminDetailsService;
import com.travelmanagementsystem.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    private final CustomAdminDetailsService customAdminDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(CustomUserDetailsService customUserDetailsService,
                          CustomAdminDetailsService customAdminDetailsService,
                          PasswordEncoder passwordEncoder) {
        this.customUserDetailsService = customUserDetailsService;
        this.customAdminDetailsService = customAdminDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    @Order(1)
    public SecurityFilterChain adminSecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .antMatcher("/admin/**")
            .authorizeRequests()
                .antMatchers("/admin/login", "/admin/perform_login", "/admin/reset-password").permitAll()
                .anyRequest().hasRole("ADMIN")
            .and()
            .formLogin()
                .loginPage("/admin/login")
                .loginProcessingUrl("/admin/perform_login")
                .defaultSuccessUrl("/admin/dashboard", true)
                .failureUrl("/admin/login?error=true")
            .and()
            .logout()
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/admin/login?logout")
            .and()
            .userDetailsService(customAdminDetailsService); // ✅ Specific to admin

        return http.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain userSecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .antMatcher("/user/**")
            .authorizeRequests()
                .antMatchers("/user/login", "/user/register", "/user/perform_login").permitAll()
                .anyRequest().hasRole("USER")
            .and()
            .formLogin()
                .loginPage("/user/login")
                .loginProcessingUrl("/user/perform_login")
                .defaultSuccessUrl("/user/dashboard", true)
                .failureUrl("/user/login?error=true")
            .and()
            .logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/user/login?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
            .and()
            .userDetailsService(customUserDetailsService); // ✅ Specific to user

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    CommandLineRunner createDefaultAdmin(AdminRepository adminRepo) {
        return args -> {
            if (adminRepo.findByUsername("nivas") == null) {
                Admin admin = new Admin();
                admin.setUsername("nivas");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setFirstLogin(true);
                admin.setRole("ROLE_ADMIN");
                adminRepo.save(admin);
                System.out.println("✅ Default admin created.");
            }
        };
    }
}

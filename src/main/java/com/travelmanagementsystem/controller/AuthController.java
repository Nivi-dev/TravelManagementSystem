package com.travelmanagementsystem.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.travelmanagementsystem.entity.User;
import com.travelmanagementsystem.repository.UserRepository;

@Controller
public class AuthController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	@Qualifier("customAdminDetailsService") // or "userDetailsService" depending on the context
	private UserDetailsService adminDetailsService;
	
	
	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService userDetailsService;

	
	@GetMapping("/user/login")
	public String showLoginPage(@RequestParam(value = "logout", required = false) String logout,
	                            Model model) {
		System.out.println("---->> userlogin page is hitting");
	    if (logout != null) {
	        model.addAttribute("logoutMessage", "You have been logged out.");
	    }
	    return "userlogin";  // JSP file name
	}
	
	@GetMapping("/user/register")
	public String redirectToRegisterPage(Model model) {
	    model.addAttribute("user", new User());
	    return "userregister"; // This should match your JSP file name
	}

	
	@PostMapping("/user/register")
    public String processRegistration(@ModelAttribute("user") User user
    		, RedirectAttributes redirectAttributes) {
		System.out.println("Saving user: " + user.getUsername());
		
		System.out.println("User object: " + user);

		if (userRepo.existsByUsername(user.getUsername())) {
	        redirectAttributes.addFlashAttribute("error", "username");
	        return "redirect:/register";
	    }
	    if (userRepo.existsByEmail(user.getEmail())) {
	        redirectAttributes.addFlashAttribute("error", "email");
	        return "redirect:/register";
	    }
	    if (userRepo.existsByPhone(user.getPhone())) {
	        redirectAttributes.addFlashAttribute("error", "mobile");
	        return "redirect:/register";
	    }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepo.save(user);
        redirectAttributes.addFlashAttribute("success","Registration successful!");
        return "redirect:/user/register";
    }
	
	@GetMapping("/admin/login")
	public String showAdminLoginPage(@RequestParam(value = "logout", required = false) String logout, Model model) {
		System.out.println("---->> userlogin page is hitting");
	    if (logout != null) {
	        model.addAttribute("logoutMessage", "You have been logged out.");
	    }
	    return "adminlogin";  // JSP file name
	}
	
	@GetMapping("/welcome")
	public String welcome() {
	    return "welcome"; // Add welcome.jsp
	}

}

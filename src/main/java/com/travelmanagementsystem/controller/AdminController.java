package com.travelmanagementsystem.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.travelmanagementsystem.entity.Admin;
import com.travelmanagementsystem.entity.Booking;
import com.travelmanagementsystem.entity.TravelPackage;
import com.travelmanagementsystem.entity.User;
import com.travelmanagementsystem.repository.AdminRepository;
import com.travelmanagementsystem.repository.BookingRepository;
import com.travelmanagementsystem.service.AdminService;
import com.travelmanagementsystem.service.TravelPackageService;
import com.travelmanagementsystem.service.UserService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	
	 @Autowired
	 private AdminService adminService;
	 
	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private TravelPackageService tps;
	 
	 @Autowired
	 private AdminRepository adminRepo;
	 
	  @Autowired
	 private BookingRepository bookingRepo;
	 
	 @Autowired
	 @Qualifier("customAdminDetailsService")
	 private UserDetailsService userDetailsService;


	 @Autowired
	 private PasswordEncoder passwordEncoder;


	 
//	 @PostMapping("/login")
//	 public String login(@RequestParam String username, @RequestParam String password) {
//	     System.out.println(">> username: " + username + ", password: " + password);
//	     Admin admin = adminService.login(username, password);
//	     if (admin != null) {
//	    	 return "admindashboard";
//	     } else {
//	         return "redirect:/adminlogin.html";
//	     }
//	 }
	 
	   @GetMapping("/view-user")
		public String showUsers(Model model) {
		 
			List<User> user=userService.getAllUsers();
			
			model.addAttribute("users",user);
			return "userdetails";	
		}
	   
	   @GetMapping("/packages")
		public String showPackages(Model model) {
			
			List <TravelPackage> packages =tps.getAllPackages();
			
			model.addAttribute("packages", packages);
			
			return "packageview";
			
		}
	   
	   @GetMapping("/new-package")
	   public String addNewPackage() {
		return "travelpackage";
		  
	   }
	   
	 

	    @GetMapping("/bookings")
	    public String viewBookings(Model model) {
	        List<Booking> bookings = bookingRepo.findAll();
	        model.addAttribute("bookings", bookings);
	        return "bookingshistory"; // This will load bookings.jsp
	    }
	   
	   @PostMapping("/add-new-user")
	    public String registerUser(@RequestParam String name,@RequestParam String username,
				@RequestParam String email,@RequestParam String phone,
				@RequestParam String password,@RequestParam String address) {
		 
		 int result=0;
			System.out.println(" >> username : "+ username);
			
			User user = new User();
		    user.setName(name);
		    user.setUsername(username);
		    user.setEmail(email);
		    user.setPhone(phone);
		    user.setPassword(password);
		    user.setAddress(address);
			
			result=userService.Register(user);
			
			if (result != 0) {
		        return "redirect:/api/admin/view-user"; // forward to JSP or controller mapped to this
		    } else {
		    	return "redirect:/api/admin/view-user"; //for static pages
		    } 
		 
	 }
	   
	   
	   @GetMapping("/dashboard")
	    public String showAdminDashboard(Model model, Principal principal) {
	        System.out.println("🔥 Hitting /admin/dashboard");

	        String username = principal.getName();
	        model.addAttribute("username", username);

	        Admin admin = adminRepo.findByUsername(username);
	        model.addAttribute("admin", admin);
	        
	        if (admin.isFirstLogin()) {
	            return "redirect:/admin/reset-password";
	        }

	        return "admindashboard";
	        
	    }
	   
	   
	   @GetMapping("/reset-password")
	   public String showResetPasswordPage() {
		   System.out.println("🔥 Hitting resetpassword page");
	       return "resetpassword"; // Or whatever your JSP/HTML file is
	   }

	 
	   @PostMapping("/reset-password")
	   public String handleResetPassword(@RequestParam("newPassword") String newPassword,
	                                     Principal principal,
	                                     RedirectAttributes redirectAttributes) {
	       String username = principal.getName();
	       Admin admin = adminRepo.findByUsername(username);

	       if (admin != null) {
	           admin.setPassword(passwordEncoder.encode(newPassword));
	           admin.setFirstLogin(false);  // ✅ Mark as completed
	           adminRepo.save(admin);

	           redirectAttributes.addFlashAttribute("success", "Password reset successfully.");
	       }

	       return "redirect:/admin/dashboard";
	   }
	
	
	 
	   
	 
	 @GetMapping("/add-user")
	 public String adminAddingUser() {
		return "adminuserregister";
		 
	 }
	 
	 
	 
	 
}

package com.travelmanagementsystem.controller;


import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.travelmanagementsystem.entity.Booking;
import com.travelmanagementsystem.entity.TravelPackage;
import com.travelmanagementsystem.entity.User;
import com.travelmanagementsystem.repository.BookingRepository;
import com.travelmanagementsystem.repository.UserRepository;
import com.travelmanagementsystem.service.TravelPackageService;
import com.travelmanagementsystem.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private TravelPackageService tps;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BookingRepository bookingRepo;
	
	
//	@PostMapping("/register")
//	public String register(@RequestParam String name,@RequestParam String username,
//			@RequestParam String email,@RequestParam String phone,
//			@RequestParam String password,@RequestParam String address) {
//		
//		int result=0;
//		System.out.println(" >> username : "+ username);
//		
//		User user = new User();
//	    user.setName(name);
//	    user.setUsername(username);
//	    user.setEmail(email);
//	    user.setPhone(phone);
//	    user.setPassword(passwordEncoder.encode(user.getPassword()));
//	    user.setAddress(address);
//		
//		result=userService.Register(user);
//		
//		if (result != 0) {
//			return "redirect:/userdashboard";// forward to JSP or controller mapped to this
//	    } else {
//	    	return "redirect:/userregister.html"; //for static pages
//	    }
//		
//	}
	
	
//	@GetMapping("/dashboard")
//	public String showUserDashboard(Model model, Principal principal) {
//	    String username = principal.getName();
//	    User user = userService.findByUsername(username);
//	    List<TravelPackage> packages = tpa.getAllPackages();
//	    model.addAttribute("user", user);
//	    model.addAttribute("packages", packages);
//
//	    return "userdashboard"; // Resolves to userdashboard.jsp
//	}


	@GetMapping("/dashboard")
	public String showUserDashboard(Model model, Principal principal) {
	    String username = principal.getName();  // logged-in user's username
	    model.addAttribute("username", username);
	    
	    User user = userRepo.findByUsername(username);
	    model.addAttribute("user",user);
	    
	    List<TravelPackage> packages = tps.getAllPackages();
	    model.addAttribute("packages", packages);
	    
	    
	    return "userdashboard"; // This points to userdashboard.jsp
	}

	
	
	@GetMapping("/book")
	public String bookTrip(@RequestParam("packageId") Long packageId, Model model, Principal principal) {
	    // Fetch user, package, save booking etc.
	    return "booking-success"; // JSP name
	}
	
	@PostMapping("/user/book")
	public String bookTrips(@RequestParam("packageId") Long packageId, Model model, Principal principal) {
	    // 1. Get logged-in user
	    String username = principal.getName();
	    User user = userRepo.findByUsername(username);

	    // 2. Get travel package
	    TravelPackage travelPackage = tps.findById(packageId);

	    // 3. Create and save booking
	    if (user != null && travelPackage != null) {
	        Booking booking = new Booking();
	        booking.setUser(user);
	        booking.setTravelPackage(travelPackage);
	        booking.setBookingDate(LocalDate.now());
	        bookingRepo.save(booking);
	    }

	    // 4. Redirect to success page
	    return "booking-success";
	}


 
	   @GetMapping("/test")
	   public String test() {
	       System.out.println("==> /user/test hit");
	       return "test"; // create test.jsp
	   }


	
}

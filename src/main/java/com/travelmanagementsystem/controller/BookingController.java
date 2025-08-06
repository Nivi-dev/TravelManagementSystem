package com.travelmanagementsystem.controller;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.travelmanagementsystem.entity.Booking;
import com.travelmanagementsystem.entity.TravelPackage;
import com.travelmanagementsystem.entity.User;
import com.travelmanagementsystem.repository.BookingRepository;
import com.travelmanagementsystem.repository.TravelPackageRepository;
import com.travelmanagementsystem.repository.UserRepository;

@Controller
public class BookingController {
	
	
	@Autowired
	private TravelPackageRepository tpa;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BookingRepository bookingRepo;
	
	@PostMapping("/user/book")
	public String bookTrip(@RequestParam("packageId") Long packageId, Principal principal, RedirectAttributes redirectAttributes) {
	    String username = principal.getName();
	    User user = userRepo.findByUsername(username);
	    TravelPackage travelPackage = tpa.getById(packageId);

	    Booking booking = new Booking();
	    booking.setUser(user);
	    booking.setTravelPackage(travelPackage);
	    booking.setBookingDate(LocalDate.now());

	    bookingRepo.save(booking);

	    redirectAttributes.addFlashAttribute("msg", "Trip booked successfully!");
	    return "redirect:/user/dashboard";
	    
	}
	
}

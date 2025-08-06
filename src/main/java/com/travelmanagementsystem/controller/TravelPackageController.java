package com.travelmanagementsystem.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travelmanagementsystem.entity.TravelPackage;
import com.travelmanagementsystem.service.TravelPackageService;

@Controller
@RequestMapping("/api/admin/")
public class TravelPackageController {
	
	@Autowired
	private TravelPackageService travelPackageService;
	
	@PostMapping("/tpa")
	public String savePackage(@RequestParam String title,
	                          @RequestParam String description,
	                          @RequestParam String location,
	                          @RequestParam String duration,
	                          @RequestParam String price,
	                          @RequestParam String discount,
	                          @RequestParam String imageUrl,
	                          @RequestParam String availableSlots) {

	    TravelPackage tp = new TravelPackage();
	    tp.setTitle(title);
	    tp.setDescription(description);
	    tp.setLocation(location);
	    tp.setDuration(Integer.parseInt(duration));
	    tp.setPrice(Double.parseDouble(price));
	    tp.setDiscount(Double.parseDouble(discount));
	    tp.setAvailableSlots(Integer.parseInt(availableSlots));
	    tp.setImageUrl(imageUrl);

	    travelPackageService.Save(tp);

	    // ✅ Redirect to GET endpoint to avoid form resubmission
	    return "redirect:/api/admin/packages";
	}

	
	@GetMapping("/packages")
    public String showPackagePage(Model model) {
        List<TravelPackage> packages = travelPackageService.getAllPackages();
        model.addAttribute("packages", packages);
        return "packageview"; // JSP name
        //return "redirect:/api/admin/packages"; // ✅ Sends user to the list page with a fresh GET

    }
	
	
	@GetMapping("/new-package")
	public String showNewPackageForm() {
	    return "travelpackage"; // returns newpackage.jsp
	}

	@GetMapping("/login")
	public String showAdminDashboard() {
	    return "admindashboard"; // returns admindashboard.jsp
	}

}

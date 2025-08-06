package com.travelmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="travel_package")
public class TravelPackage {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long packageId;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private int duration; // in days

    @Column(nullable = false)
    private double price;

    @Column
    private double discount; // in %

    @Column(nullable = false)
    private int availableSlots;
    
    @Column(name="image_Url")
    private String imageUrl;
    
    
	public TravelPackage() {
		super();
	}

	public TravelPackage(Long packageId, String title, String description, String location, int duration,
			double price, double discount, int availableSlots) {
		super();
		this.packageId = packageId;
		this.title = title;
		this.description = description;
		this.location = location;
		this.duration = duration;
		this.price = price;
		this.discount = discount;
		this.availableSlots = availableSlots;
	}

	public TravelPackage(String title, String description, String location, int duration, double price,
			double discount, int availableSlots) {
		super();
		this.title = title;
		this.description = description;
		this.location = location;
		this.duration = duration;
		this.price = price;
		this.discount = discount;
		this.availableSlots = availableSlots;
	}

	public Long getPackageId() {
		return packageId;
	}

	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getAvailableSlots() {
		return availableSlots;
	}

	public void setAvailableSlots(int availableSlots) {
		this.availableSlots = availableSlots;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	
	
	
}

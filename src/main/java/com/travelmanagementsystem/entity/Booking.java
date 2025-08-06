package com.travelmanagementsystem.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	 @ManyToOne
	 @JoinColumn(name = "travel_package_id")
	 private TravelPackage travelPackage;

      private LocalDate bookingDate;

    
	public Booking() {
		super();
	}


	public Booking(Long bookingId, User user, TravelPackage travelPackage, LocalDate bookingDate) {
		super();
		this.bookingId = bookingId;
		this.user = user;
		this.travelPackage = travelPackage;
		this.bookingDate = bookingDate;
	}


	public Booking(User user, TravelPackage travelPackage, LocalDate bookingDate) {
		super();
		this.user = user;
		this.travelPackage = travelPackage;
		this.bookingDate = bookingDate;
	}


	public Long getBookingId() {
		return bookingId;
	}


	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public TravelPackage getTravelPackage() {
		return travelPackage;
	}


	public void setTravelPackage(TravelPackage travelPackage) {
		this.travelPackage = travelPackage;
	}


	public LocalDate getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	
	
}

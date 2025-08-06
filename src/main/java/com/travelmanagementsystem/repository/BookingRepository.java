package com.travelmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelmanagementsystem.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	List<Booking> findAll();
}

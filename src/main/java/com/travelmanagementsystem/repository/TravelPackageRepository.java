package com.travelmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelmanagementsystem.entity.TravelPackage;

public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long> {
	
}

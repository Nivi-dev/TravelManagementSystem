package com.travelmanagementsystem.service;

import java.util.List;

import com.travelmanagementsystem.entity.TravelPackage;

public interface TravelPackageService {
	int Save(TravelPackage tp);
	
	List<TravelPackage> getAllPackages();

	TravelPackage findById(Long packageId);
}

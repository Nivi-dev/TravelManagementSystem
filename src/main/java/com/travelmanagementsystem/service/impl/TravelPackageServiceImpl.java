package com.travelmanagementsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelmanagementsystem.entity.TravelPackage;
import com.travelmanagementsystem.repository.TravelPackageRepository;
import com.travelmanagementsystem.service.TravelPackageService;


@Service
public class TravelPackageServiceImpl implements TravelPackageService {
	
	@Autowired
	private TravelPackageRepository travelpackrepo;
	
	
	@Override
	public int Save(TravelPackage tp) {
		TravelPackage res=travelpackrepo.save(tp);
		if (res.getPackageId() > 0) {
		    return 1;
		} else {
		    return 0;
		}
	}


	@Override
	public List<TravelPackage> getAllPackages() {
		return travelpackrepo.findAll();
		
	}


	@Override
	public TravelPackage findById(Long packageId) {
		// TODO Auto-generated method stub
		return travelpackrepo.getById(packageId);
	}
	
}

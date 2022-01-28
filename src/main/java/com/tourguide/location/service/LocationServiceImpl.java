package com.tourguide.location.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguide.location.model.VisitedLocation;
import com.tourguide.location.repository.VisitedLocationRepository;

@Service("locationService")
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	VisitedLocationRepository visitedLocationRepository;
	
	@Autowired
	GpsUtil gpsUtil;
	
	public VisitedLocation getCurrentLocation(UUID userId) {
		VisitedLocation visitedLocation = gpsUtil.getCurrentLocation(userId);
		
		// Enregistre la position en BD
		visitedLocationRepository.save(visitedLocation); 
		
		return visitedLocation;
	}
	
	public VisitedLocation getLastLocation(UUID userId) {
		VisitedLocation lastVisitedLocation = visitedLocationRepository.findFirstByUserIdOrderByTimeVisitedDesc(userId);
		return lastVisitedLocation;
	}
	

}

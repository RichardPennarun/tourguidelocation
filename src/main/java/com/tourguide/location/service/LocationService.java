package com.tourguide.location.service;

import java.util.UUID;

import com.tourguide.location.model.VisitedLocation;

public interface LocationService {
	
	VisitedLocation getCurrentLocation(UUID userId);
	
	VisitedLocation getLastLocation(UUID userId);

}

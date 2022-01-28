package com.tourguide.location;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tourguide.location.model.VisitedLocation;
import com.tourguide.location.service.LocationService;

@RestController
public class LocationController {
	
	@Autowired
	LocationService locationService;

	/*
	 * Read - Get the current GPS location and save it
	 * @param Id The user id
	 * @return An object VisitedLocation
	 */
	@GetMapping("/getCurrentLocation/{userId}")
	public VisitedLocation getCurrentLocation(@PathVariable("userId") final UUID userId) {
		VisitedLocation visitedLocation = locationService.getCurrentLocation(userId);
		return visitedLocation;
	}

	/*
	 * Read - Get the last saved GPS location 
	 * @param Id The user id
	 * @return An object VisitedLocation
	 */
	@GetMapping("/getLastLocation/{userId}")
	public VisitedLocation getLastLocation(@PathVariable("userId") final UUID userId) {
		VisitedLocation lastVisitedLocation = locationService.getLastLocation(userId);
		return lastVisitedLocation;
	}

}

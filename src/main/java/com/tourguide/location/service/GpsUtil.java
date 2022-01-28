package com.tourguide.location.service;

import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.tourguide.location.model.VisitedLocation;

@Service
public class GpsUtil {

	public VisitedLocation getCurrentLocation(UUID userId) {

		double randomLat = ThreadLocalRandom.current().nextDouble(-180.0D, 180.0D);
		randomLat = Double.parseDouble(String.format(Locale.US,"%.6f", randomLat));
		double randomLong = ThreadLocalRandom.current().nextDouble(-85.05112878D, 85.05112878D);
		randomLong = Double.parseDouble(String.format(Locale.US,"%.6f", randomLong));
		UUID id = UUID.randomUUID();
		VisitedLocation visitedLocation = new VisitedLocation(id, userId, randomLat, randomLong, new Date());
		return visitedLocation;

	}

}

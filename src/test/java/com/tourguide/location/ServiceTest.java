package com.tourguide.location;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tourguide.location.model.VisitedLocation;
import com.tourguide.location.repository.VisitedLocationRepository;
import com.tourguide.location.service.GpsUtil;

@SpringBootTest
public class ServiceTest {
	

	@Autowired
	private GpsUtil gpsUtil;
	
	@Autowired
	private VisitedLocationRepository visitedLocationRepository;
	

	@Test
	public void getLastLocation() {

		final UUID id = UUID.randomUUID();
		final UUID uuid = UUID.randomUUID();
		final Date timeVisited = new Date();
		
		VisitedLocation visitedLocation = new VisitedLocation(id, uuid, -125.808708, 5.64892, timeVisited);
		visitedLocationRepository.save(visitedLocation);
		VisitedLocation lastVisitedLocation = visitedLocationRepository.findFirstByUserIdOrderByTimeVisitedDesc(uuid);
		
		assertThat(lastVisitedLocation.getId()).isEqualTo(visitedLocation.getId());
		
	}

	
	@Test
	public void getCurrentLocationTest() {

		final UUID id = UUID.randomUUID();
		VisitedLocation visitedLocation = gpsUtil.getCurrentLocation(id);
		visitedLocationRepository.save(visitedLocation);
		VisitedLocation lastVisitedLocation = visitedLocationRepository.findFirstByUserIdOrderByTimeVisitedDesc(id);
		assertThat(lastVisitedLocation.getId()).isEqualTo(visitedLocation.getId());
		
	}
	
}

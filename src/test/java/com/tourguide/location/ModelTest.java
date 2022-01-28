package com.tourguide.location;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tourguide.location.model.VisitedLocation;

@SpringBootTest
public class ModelTest {
	

	
	@Test
	public void getVisitedLocationTest() {
		
		VisitedLocation vl = new VisitedLocation();
		//final UUID id = UUID.randomUUID();
		final UUID uuid = UUID.randomUUID();
		final Date timeVisited = new Date();
		//vl.setId(id);
		vl.setUserId(uuid);
		vl.setLatitude(-125.808708);
		vl.setLongitude(5.64892);
		vl.setTimeVisited(timeVisited);

		//assertThat(vl.getId()).isEqualTo(id);
		assertThat(vl.getUserId()).isEqualTo(uuid);
		assertThat(vl.getLatitude()).isEqualTo(-125.808708);
		assertThat(vl.getLongitude()).isEqualTo(5.64892);
		assertThat(vl.getTimeVisited()).isEqualTo(timeVisited);
	}
	
	@Test
	public void setVisitedLocationTest() {

		final UUID id = UUID.randomUUID();
		final UUID uuid = UUID.randomUUID();
		final Date timeVisited = new Date();
		
		VisitedLocation visitedLocation = new VisitedLocation(id, uuid, -125.808708, 5.64892, timeVisited);
		
		assertThat(visitedLocation.getId()).isEqualTo(id);
		assertThat(visitedLocation.getUserId()).isEqualTo(uuid);
		assertThat(visitedLocation.getLatitude()).isEqualTo(-125.808708);
		assertThat(visitedLocation.getLongitude()).isEqualTo(5.64892);
		assertThat(visitedLocation.getTimeVisited()).isEqualTo(timeVisited);
	}

}

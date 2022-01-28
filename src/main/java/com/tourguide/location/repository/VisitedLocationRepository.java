package com.tourguide.location.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourguide.location.model.VisitedLocation;

@Repository
public interface VisitedLocationRepository extends JpaRepository<VisitedLocation, UUID> {
	
	VisitedLocation findFirstByUserIdOrderByTimeVisitedDesc(UUID userId);

}

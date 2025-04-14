package com.example.miniapp.repositories;

import com.example.miniapp.models.Captain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaptainRepository extends JpaRepository<Captain, Long> {
    // Custom query: captains with avg rating above threshold
    List<Captain> findByAvgRatingScoreGreaterThan(Double ratingThreshold);

    // Custom query: find by license number
    Captain findByLicenseNumber(String licenseNumber);
}

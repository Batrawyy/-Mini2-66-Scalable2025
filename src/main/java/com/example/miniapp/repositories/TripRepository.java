package com.example.miniapp.repositories;

import com.example.miniapp.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    // Custom query to retrieve trips within a specified date range
    List<Trip> findByTripDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Custom query to filter trips by captain ID
    List<Trip> findByCaptainId(Long captainId);
}

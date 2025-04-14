package com.example.miniapp.repositories;

import com.example.miniapp.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {

    // Trips within date range
    List<Trip> findByTripDateBetween(LocalDateTime start, LocalDateTime end);

    // Trips by captain ID
    List<Trip> findByCaptainId(Long captainId);
}

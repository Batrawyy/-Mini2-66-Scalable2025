package com.example.miniapp.services;

import com.example.miniapp.models.Trip;
import com.example.miniapp.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    // Add a new trip
    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    // Get all trips
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    // Get trip by ID
    public Trip getTripById(Long id) {
        Optional<Trip> trip = tripRepository.findById(id);
        return trip.orElse(null);
    }

    // Update trip details
    public Trip updateTrip(Long id, Trip trip) {
        Optional<Trip> existingTrip = tripRepository.findById(id);

        if (existingTrip.isPresent()) {
            Trip updatedTrip = existingTrip.get();
            updatedTrip.setTripDate(trip.getTripDate());
            updatedTrip.setOrigin(trip.getOrigin());
            updatedTrip.setDestination(trip.getDestination());
            updatedTrip.setTripCost(trip.getTripCost());

            // Only update relations if they are provided
            if (trip.getCaptain() != null) {
                updatedTrip.setCaptain(trip.getCaptain());
            }

            if (trip.getCustomer() != null) {
                updatedTrip.setCustomer(trip.getCustomer());
            }

            return tripRepository.save(updatedTrip);
        }

        return null;
    }

    // Delete trip
    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    // Find trips within a date range
    public List<Trip> findTripsWithinDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return tripRepository.findByTripDateBetween(startDate, endDate);
    }

    // Find trips by captain ID
    public List<Trip> findTripsByCaptainId(Long captainId) {
        return tripRepository.findByCaptainId(captainId);
    }
}

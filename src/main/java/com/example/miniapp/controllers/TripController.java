package com.example.miniapp.controllers;

import com.example.miniapp.models.Trip;
import com.example.miniapp.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {
    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    // Add a new trip
    @PostMapping("/addTrip")
    public Trip addTrip(@RequestBody Trip trip) {
        return tripService.addTrip(trip);
    }

    // Get all trips
    @GetMapping("/allTrips")
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    // Get specific trip by ID
    @GetMapping("/{id}")
    public Trip getTripById(@PathVariable Long id) {
        return tripService.getTripById(id);
    }

    // Update trip details
    @PutMapping("/update/{id}")
    public Trip updateTrip(@PathVariable Long id, @RequestBody Trip trip) {
        return tripService.updateTrip(id, trip);
    }

    // Delete trip
    @DeleteMapping("/delete/{id}")
    public String deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return "Trip with ID: " + id + " has been deleted successfully";
    }

    // Find trips within a date range
    @GetMapping("/findByDateRange")
    public List<Trip> findTripsWithinDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return tripService.findTripsWithinDateRange(startDate, endDate);
    }

    // Find trips by captain ID
    @GetMapping("/findByCaptainId")
    public List<Trip> findTripsByCaptainId(@RequestParam Long captainId) {
        return tripService.findTripsByCaptainId(captainId);
    }
}

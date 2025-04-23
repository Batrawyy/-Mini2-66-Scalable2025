package com.example.miniapp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table (name="captains")
@Data
public class Captain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String licenseNumber;
    private Double avgRatingScore;

    @OneToMany(mappedBy = "captain", cascade = CascadeType.ALL)
    private List<Trip> trips;

    public Captain() {}

    public Captain(String name, String licenseNumber, Double avgRatingScore) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.avgRatingScore = avgRatingScore;
    }

    public Captain(Long id, String name, String licenseNumber, Double avgRatingScore) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.avgRatingScore = avgRatingScore;
    }



}

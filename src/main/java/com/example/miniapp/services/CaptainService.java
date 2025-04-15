package com.example.miniapp.services;

import com.example.miniapp.models.Captain;
import com.example.miniapp.repositories.CaptainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CaptainService {
    // Dependency Injection
    private final CaptainRepository captainRepository;

    //@Autowired
    public CaptainService(CaptainRepository captainRepository) {
        this.captainRepository = captainRepository;
    }

    public Captain addCaptain(Captain captain){
        return captainRepository.save(captain);
    }

    public List<Captain> getAllCaptains(){
        return captainRepository.findAll();
    }

    public Captain getCaptainById(Long id){
//        Optional<Captain> result = captainRepository.findById(id);
//        return result.orElse(null);
        return captainRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Captain with ID " + id + " not found"
                ));
    }

    public List<Captain> getCaptainsByRating(Double ratingThreshold){
        return captainRepository.findByAvgRatingScoreGreaterThan(ratingThreshold);
    }

    public Captain getCaptainByLicenseNumber(String licenseNumber){
        return captainRepository.findByLicenseNumber(licenseNumber);
    }


}

package com.example.miniapp.repositories;

import com.example.miniapp.models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {

    // Ratings by entity ID and type
    List<Rating> findByEntityIdAndEntityType(Long entityId, String entityType);

    // Ratings above a score
    List<Rating> findByScoreGreaterThan(int minScore);
}

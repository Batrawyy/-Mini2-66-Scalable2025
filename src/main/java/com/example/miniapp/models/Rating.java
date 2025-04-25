package com.example.miniapp.models;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "ratings")
@Data
public class Rating {

    @Id
    private String id;
    private Long entityId;
    private String entityType;
    private Integer score;
    private String comment;
    private LocalDateTime ratingDate;

    public Rating() {}

    public Rating(Long entityId, String entityType, Integer score, String comment, LocalDateTime ratingDate) {
        this.entityId = entityId;
        this.entityType = entityType;
        this.score = score;
        this.comment = comment;
        this.ratingDate = ratingDate;
    }

    public Rating(String id, Long entityId, String entityType, Integer score, String comment, LocalDateTime ratingDate) {
        this.id = id;
        this.entityId = entityId;
        this.entityType = entityType;
        this.score = score;
        this.comment = comment;
        this.ratingDate = ratingDate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public Long getEntityId() {
        return entityId;
    }
    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }
    public String getEntityType() {
        return entityType;
    }
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }
    public LocalDateTime getRatingDate() {
        return ratingDate;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setRatingDate(LocalDateTime ratingDate) {
        this.ratingDate = ratingDate;
    }
}

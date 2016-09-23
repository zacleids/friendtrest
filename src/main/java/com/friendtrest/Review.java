package com.friendtrest;

import java.util.UUID;

public class Review {
    private String objectType;
    private String title;
    private int rating;
    private String review;
    private String uuid;

    public Review(String objectType, String title, int rating, String review){
        this.objectType = objectType;
        this.title = title;
        this.rating = rating;
        this.review = review;
        this.uuid = UUID.randomUUID().toString();
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}

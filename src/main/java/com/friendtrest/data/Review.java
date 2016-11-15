package com.friendtrest.data;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "ReviewTest")
public class Review {

    private double rating;

    private String item_id;
    private String review_text;
    private String user_id;
    private String uuid;

    public Review() { }

    public Review(String item_id, String user_id, double rating, String review_text) {
        this.item_id = item_id;
        this.user_id = user_id;
        this.rating = rating;
        this.review_text = review_text;
    }

    public String getItem_id() { return item_id; }
    public void setItem_id(String item_id) { this.item_id = item_id; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public String getReview_text() { return review_text; }
    public void setReview_text(String review_text) { this.review_text = review_text; }

    public String getUser_id() { return user_id; }
    public void setUser_id(String user_id) { this.user_id = user_id; }

    @DynamoDBHashKey
    public String getUuid() { return uuid; }
    public void setUuid(String uuid) { this.uuid = uuid; }
}

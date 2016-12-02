package com.friendtrest.data;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.ArrayList;
import java.util.List;

@DynamoDBTable(tableName = "Users")
public class User {
	private String name;
	private String email;
	private String pictureURL;
	private String facebookID;
	private List<String> reviewIDs;
	private List<String> friendIDs;

	public User() { }

	public User(String name, String email, String pictureURL, String facebookID,
		List<String> reviewIDs, List<String> friendIDs){
		this.name = name;
		this.email = email;
		this.pictureURL = pictureURL;
        this.facebookID = facebookID;
        this.reviewIDs = reviewIDs;
        this.friendIDs = friendIDs;
	}

	public User(String name, String email, String pictureURL, String facebookID,
		List<String> friendIDs){
		this.name = name;
		this.email = email;
		this.pictureURL = pictureURL;
        this.facebookID = facebookID;
        this.friendIDs = friendIDs;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@DynamoDBAttribute(attributeName = "picture_url")
	public String getPictureURL() {
		return pictureURL;
	}
	public void setPictureURL(String pictureURL) { this.pictureURL = pictureURL; }

	@DynamoDBHashKey(attributeName = "facebook_id")
	public String getFacebookId() {
		return facebookID;
	}
	public void setFacebookId(String facebookID) {
		this.facebookID = facebookID;
	}

	@DynamoDBAttribute(attributeName = "review_ids")
	public List<String> getReviews() {
		return reviewIDs;
	}
	public void setReviews(List<String> reviewIDs) {
		this.reviewIDs = reviewIDs;
	}

	@DynamoDBAttribute(attributeName = "friend_ids")
	public List<String> getFriends() {
		return friendIDs;
	}
	public void setFriends(List<String> friendIDs) {
		this.friendIDs = friendIDs;
	}

	@DynamoDBIgnore
	public void addReview(String review){
		reviewIDs.add(review);
	}

	@DynamoDBIgnore
	public boolean deleteReview(String review){
		if (!reviewIDs.contains(review)){
			return false;
		}
		reviewIDs.remove(review);
		return true;
	}

}

package com.friendtrest;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.ArrayList;

@DynamoDBTable(tableName = "Users")
public class User {
	private String name;
	private String email;
	private String pictureURL;
	private String facebookID;
	private ArrayList<String> reviewIDs = new ArrayList<String>();
	private ArrayList<String> friendIDs = new ArrayList<String>();

	public User() { }

	public User(String name, String email, String pictureURL, String facebookID,
		ArrayList<String> reviewIDs, ArrayList<String> friendIDs){
		this.name = name;
		this.email = email;
		this.pictureURL = pictureURL;
        this.facebookID = facebookID;
        this.reviewIDs = reviewIDs;
        this.friendIDs = friendIDs;
	}

	public User(String name, String email, String pictureURL, String facebookID,
		ArrayList<String> friendIDs){
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

	public String getPictureURL() {
		return pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	@DynamoDBHashKey
	public String getFacebookId() {
		return facebookID;
	}
	public void setFacebookId(String facebookID) {
		this.facebookID = facebookID;
	}

	public ArrayList<String> getReviews() {
		return reviewIDs;
	}

	public ArrayList<String> getFriends() {
		return friendIDs;
	}

	public void setFriends(ArrayList<String> friendIDs) {
		this.friendIDs = friendIDs;
	}

	public void setReviews(ArrayList<String> reviewIDs) {
		this.reviewIDs = reviewIDs;
	}

	public void addReview(String review){
		reviewIDs.add(review);
	}

	public boolean deleteReview(String review){
		if (!reviewIDs.contains(review)){
			return false;
		}
		reviewIDs.remove(review);
		return true;
	}

}

package com.friendtrest;

import java.util.ArrayList;

public class User {
	private String name;
	private String email;
	private String pictureURL;
	private String facebookID;
	private ArrayList<String> reviewsIDs = new ArrayList<String>();
	private ArrayList<String> friendsIDs = new ArrayList<String>();

	public User(String name, String email, String pictureURL){
		this.name = name;
		this.email = email;
		this.pictureURL = pictureURL;
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

	public String getFacebookID() {
		return facebookID;
	}

	public void setFacebookID(String facebookID) {
		this.facebookID = facebookID;
	}

	public ArrayList<String> getReviews() {
		return reviewsIDs;
	}

	public ArrayList<String> getFriends() {
		return friendsIDs;
	}

	public void setFriends(ArrayList<String> friendsIDs) {
		this.friendsIDs = friendsIDs;
	}

	public void setReviews(ArrayList<String> reviewsIDs) {
		this.reviewsIDs = reviewsIDs;
	}

	public void addReview(String review){
		reviewsIDs.add(review);
	}

	public boolean deleteReview(String review){
		if (!reviewsIDs.contains(review)){
			return false;
		}
		reviewsIDs.remove(review);
		return true;
	}

}

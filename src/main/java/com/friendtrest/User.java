package com.friendtrest;

import java.util.ArrayList;

public class User {
	private String name;
	private String email;
	private String pictureURL;
	private String facebookID;
	private ArrayList<String> reviewIDs = new ArrayList<String>();
	private ArrayList<String> friendIDs = new ArrayList<String>();

	public User(String name, String email, String pictureURL, String facebookID,
		ArrayList<String> reviewIDs, ArrayList<String> friendIDs){
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

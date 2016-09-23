package com.friendtrest;

import java.util.ArrayList;
import java.util.UUID;

public class User {
	private String name;
	private String email;
	private String passwordHash;
	private String uuid;
	private ArrayList<String> reviews = new ArrayList<String>();

	public User(String name, String email, String passwordHash){
		this.name = name;
		this.email = email;
		this.passwordHash = passwordHash;
		this.uuid = UUID.randomUUID().toString();
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

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public ArrayList<String> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<String> reviews) {
		this.reviews = reviews;
	}

	public void addReview(String review){
		reviews.add(review);
	}

	public boolean deleteReview(String review){
		if (!reviews.contains(review)){
			return false;
		}
		reviews.remove(review);
		return true;
	}


}

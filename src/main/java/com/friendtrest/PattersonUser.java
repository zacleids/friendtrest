package com.friendtrest;
import java.util.ArrayList;

public class PattersonUser {
	private String username;
	private String password;

	public PattersonUser(String username, String password){
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return (
			"Username: " + getUsername() + "\n" +
			"Password: " + getPassword() + "\n"
		);
	}
}

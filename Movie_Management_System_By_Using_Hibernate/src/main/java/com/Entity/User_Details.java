package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User_Details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_Id",nullable = false)
	private int user_id;
	@Column(name = "User_Name",nullable = false)
	private String userName;
	@Column(name = "User_Email_ID",nullable = false,unique = true)
	private String userEmail;
	@Column(name = "Mobile_Number",nullable = false,unique = true)
	private long mobileNumber;
	@Column(name = "User_Pasword",nullable = false)
	private String user_Password;
	private int movie_id;
	
	
	public User_Details() {
		super();
	}

	public User_Details(int user_id, String userName, String userEmail, long mobileNumber,String user_Password) {
		super();
		this.user_id = user_id;
		this.userName = userName;
		this.userEmail = userEmail;
		this.mobileNumber = mobileNumber;
		this.user_Password=user_Password;
	}

	public int getUser_id() {
		return user_id;
	}
	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUser_Password() {
		return user_Password;
	}

	public void setUser_Password(String user_Password) {
		this.user_Password = user_Password;
	}
	
	
	
	
	
	
	

}

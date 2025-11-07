package com.Entity;

import javax.persistence.*;

@Entity
public class Admin_Details {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "Admin_ID",nullable = false)
	private int admin_Id;
	@Column(name = "Admin_Name",nullable = false)
	private String admin_Name;
	@Column(name = "Admin_Email",nullable = false)
	private String admin_Email;
	@Column(name = "Admin_Password",nullable = false)
	private String admin_password;
	
	
	public Admin_Details() {
		super();
	}

	public Admin_Details(int admin_Id, String admin_Name, String admin_Email, String admin_password) {
		super();
		this.admin_Id = admin_Id;
		this.admin_Name = admin_Name;
		this.admin_Email = admin_Email;
		this.admin_password = admin_password;
	}

	public int getAdmin_Id() {
		return admin_Id;
	}

	public void setAdmin_Id(int admin_Id) {
		this.admin_Id = admin_Id;
	}

	public String getAdmin_Name() {
		return admin_Name;
	}

	public void setAdmin_Name(String admin_Name) {
		this.admin_Name = admin_Name;
	}

	public String getAdmin_Email() {
		return admin_Email;
	}

	public void setAdmin_Email(String admin_Email) {
		this.admin_Email = admin_Email;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

}

package com.Entity;

import javax.persistence.*;

@Entity
public class Theatre_Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
	private int theatre_Id;
    @Column(nullable = false)
	private String theatre_Name;
	@Column(name = "theatre_Address",nullable = false)
	private String theatre_address;
	
	public Theatre_Details() {
		super();
	}

	public Theatre_Details(int theatre_Id, String theatre_Name, String theatre_address) {
		super();
		this.theatre_Id = theatre_Id;
		this.theatre_Name = theatre_Name;
		this.theatre_address = theatre_address;
	}

	public int getTheatre_Id() {
		return theatre_Id;
	}

	public void setTheatre_Id(int theatre_Id) {
		this.theatre_Id = theatre_Id;
	}

	public String getTheatre_Name() {
		return theatre_Name;
	}

	public void setTheatre_Name(String theatre_Name) {
		this.theatre_Name = theatre_Name;
	}

	public String getTheatre_address() {
		return theatre_address;
	}

	public void setTheatre_address(String theatre_address) {
		this.theatre_address = theatre_address;
	}
    
	
}

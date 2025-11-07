package com.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie_details")
public class Movie_Details {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int movieId;
	@Column(name = "Movie_Name",nullable = false)
	private String movieName;
	@Column(name = "Theatre_Id",nullable = false)
	private int theatre_id;
	@Column(name = "Theatre_Name",nullable = false)
	private String theatreName;
	@Column(name = "Movie_duration",nullable = false)
	private String duration;
	@Column(name = "Ticket_Price",nullable = false)
	private double ticketPrice;
	@Column(name ="No_Of_Seats",nullable = false)
	private int noOfSeats;
	
	public Movie_Details() {
		super();
	}

	public Movie_Details(int movieId, String movieName, int theatre_id,String theatreName, String duration, double ticketPrice,int noOfSeats ) {
		
		this.movieId = movieId;
		this.movieName = movieName;
		this.theatre_id = theatre_id;
		this.theatreName=movieName;
		this.duration = duration;
		this.ticketPrice=ticketPrice;
		this.noOfSeats=noOfSeats;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}
	

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getTheatre_id() {
		return theatre_id;
	}

	public void setTheatre_id(int theatre_id) {
		this.theatre_id = theatre_id;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}	

}

package com.Entity;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Ticketdetails")
public class TicketDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
    
    @Column(name = "User_Id",nullable = false)
	private int user_Id;
    
    @Column(name = "Movie_Id",nullable = false)
    private int movie_Id;
    
    @Column(name = "MovieName",nullable = false)
    private String movieName;
    
    @Column(name = "theatre_Id",nullable = false)
	private int theatre_Id;
    
    @Column(name = "user_Name",nullable = false)
	private String user_Name;
    
    @Column(name = "valid_Date",nullable = false)
	private Date date;
    
	@Column(name = "Ticket_Amount",nullable = false)
	private double ticket_amount;
	
	@Column(name = "no_Of_Tickets",nullable = false)
	private int no_Of_tickets;
	
	@Column(name = "Seat_No",nullable = false)
	private String seatNo;
	@ElementCollection
	List<String> BookedSeats;
	
	public TicketDetails() {
		super();
	}
	
	public TicketDetails(int ticketId, int user_Id,int movie_Id, String movieName  ,int theatre_Id, String user_Name, Date date, double ticket_amount,
			int no_Of_tickets, String seatNo) {

		this.ticketId = ticketId;
		this.user_Id = user_Id;
		this.movie_Id=movie_Id;
		this.movieName=movieName;
		this.theatre_Id = theatre_Id;
		this.user_Name = user_Name;
		this.date = date;
		this.ticket_amount = ticket_amount;
		this.no_Of_tickets = no_Of_tickets;
		this.seatNo = seatNo;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public int getTheatre_Id() {
		return theatre_Id;
	}

	public void setTheatre_Id(int theatre_Id) {
		this.theatre_Id = theatre_Id;
	}
	

	public int getMovie_Id() {
		return movie_Id;
	}

	public void setMovie_Id(int movie_Id) {
		this.movie_Id = movie_Id;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTicket_amount() {
		return ticket_amount;
	}

	public void setTicket_amount(double ticket_amount) {
		this.ticket_amount = ticket_amount;
	}

	public int getNo_Of_tickets() {
		return no_Of_tickets;
	}

	public void setNo_Of_tickets(int no_Of_tickets) {
		this.no_Of_tickets = no_Of_tickets;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public List<String> getBookedSeats() {
		return BookedSeats;
	}

	public void setBookedSeats(List<String> bookedSeats) {
		BookedSeats = bookedSeats;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	@Override
	public String toString() {
		return "TicketDetails\n TicketId=" + ticketId + ",\n User_Id=" + user_Id + ",\n Movie_Id=" + movie_Id
				+ ",\n MovieName=" + movieName + ",\n Theatre_Id=" + theatre_Id + ",\n User_Name=" + user_Name + ",\n Date="
				+ date + ",\n Ticket_amount=" + ticket_amount + ",\n No_Of_tickets=" + no_Of_tickets + ",\n SeatNo=" + seatNo
				+ ",\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n";
	}

	
	
}

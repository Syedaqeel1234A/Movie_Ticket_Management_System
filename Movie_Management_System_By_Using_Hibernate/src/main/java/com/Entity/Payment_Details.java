package com.Entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "Payment_Details")
public class Payment_Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
    @Column(name = "movieId",nullable = false)
	private int movieId;
    @Column(name="User_Id",nullable = false)
	private int userId;
    @Column(name = "theatreId",nullable = false)
	private int theatreId;
    @Column(name = "Paid_Amount")
	private double ticket_Price;
    @Column(name="Payment_Type")
	private String paymentType;
	private Date paymentDate;
	
	public Payment_Details() {
		super();
	}

	public Payment_Details(int paymentId, int movieId, int userId, int theatreId, int ticketId, double ticket_Price,
			String paymentType, Date paymentDate) {
		super();
		this.paymentId = paymentId;
		this.movieId = movieId;
		this.userId = userId;
		this.theatreId = theatreId;
		this.ticket_Price = ticket_Price;
		this.paymentType = paymentType;
		this.paymentDate = paymentDate;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public double getTicket_Price() {
		return ticket_Price;
	}

	public void setTicket_Price(double ticket_Price) {
		this.ticket_Price = ticket_Price;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "Payment_Details [paymentId=" + paymentId + ",\n movieId=" + movieId + ",\n UserId=" + userId
				+ ",\n theatreId=" + theatreId + ",\n ticket_Price=" + ticket_Price + ",\n paymentType=" + paymentType
				+ ",\n paymentDate=" + paymentDate + "]";
	}
	
	
	
}

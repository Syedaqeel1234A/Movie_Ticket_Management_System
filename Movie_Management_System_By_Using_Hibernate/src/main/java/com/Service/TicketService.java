package com.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.DAO.TicketDetails_DAO;
import com.Entity.TicketDetails;

import invalid_Details_Exceptions.InvalidTicketSelection;

public class TicketService {

	
	TicketDetails_DAO details_DAO=new TicketDetails_DAO();
	
    Scanner s=new Scanner(System.in);

	public void insertTicketDetails(TicketDetails ticket_Details)
	{
	   details_DAO.insertTicketDetails(ticket_Details);
	   System.out.println("Data inserted Successfully");
	}
	public List<TicketDetails> selectTicketDetailswithoutPrinting(int UserId)
	{
        List<TicketDetails> Allticket_Details =details_DAO.selectTicketDetailsByUserId(UserId);
		return Allticket_Details;
	}
	public List<TicketDetails> selectTicketDetailsUsingUserId(int UserId)
	{
		TicketDetails_DAO details_DAOs=new TicketDetails_DAO();
      List<TicketDetails> AllTickets=details_DAOs.selectTicketDetailsByUserId(UserId);
      if(AllTickets!=null)
      {
    	  int i=1;
			for(TicketDetails ticket_Details: AllTickets)
			{
		    System.out.println("S.No : "+i++);
		    System.out.println("Ticket_id     : "+ticket_Details.getTicketId());
			System.out.println("Movie_Id      : "+ticket_Details.getMovie_Id());
			System.out.println("Movie_Name    : "+ticket_Details.getMovieName());
			System.out.println("User_Name     : "+ticket_Details.getUser_Name());
			System.out.println("Theatre_Id    : "+ticket_Details.getTheatre_Id());
			System.out.println("Ticket_Amount : "+ticket_Details.getTicket_amount());
			System.out.println("Theatre_Seat_No : "+ticket_Details.getSeatNo());
			System.out.println("---------------------------------------------------");
			}
			return AllTickets;
      }else {
    	  return null;
      }
		
	}
	
	public TicketDetails selectTicketByUsingTicketId(int ticketId)
	{
	   TicketDetails ticket_Details =details_DAO.selectTicketDetailsByUsingTicketId(ticketId);
	   return ticket_Details;
	}
	
	public void deleteTicketByUsingTicketId(int ticketId)
	{
		details_DAO.deleteTicketDetailsByTicketId(ticketId);
	}
	
	public List<String> DisplaySeats(int MovieId)
	{
		List<String> displayedSeats=new ArrayList<String>();
		Set<String> AllBookSeats=details_DAO.getBookedSeats(MovieId);
		System.out.println();
		System.out.println("=====+++=====+++=======+++========+++==========+++==========+++======");
	   for(char i='A';i<='E';i++)
	   {
		   for(int j=1;j<=12;j++)
		   {
			   String currentSeat=i+String.valueOf(j);
			   if(AllBookSeats.contains(currentSeat))
				 {
				   System.out.print("[ XXX ] , ");
				 }else{
					
			      System.out.print("[ "+currentSeat+" ] , ");
			      displayedSeats.add(currentSeat);
				 }
		   }
		   System.out.println();
	   }
	  return seatSelection(displayedSeats);
	   
	}
	public List<String> seatSelection(List<String> displayedSeats) 
	{
	
	List<String> SelectedSeat=new ArrayList<String>();
	
	   System.out.print("Please Enter Seat Number : ");
	   boolean seatSeletionloop=true;
	   while(seatSeletionloop)
	   {
	   String seat=s.next().toUpperCase();
	   
	   if(!checkSeatValueFromDisplayedSeat(displayedSeats, seat))
	   {
		   try {
		  throw new InvalidTicketSelection("Please Enter Valid Seat Number");
		   }catch (Exception e) {
			// TODO: handle exception
			 System.out.print("Enter Valid Seat Number Again : ");
		        }
	   }else {
		   seatSeletionloop=false;
		   SelectedSeat.add(seat);
		   System.out.println("Press 1 To Book One More Ticket Or Press Any Other Key to Continue..");
		   if(s.nextInt()==1)
		   {
			   while(true)
			   {
			   System.out.println("Select Another Seat Number : ");
			   String seat2=s.next().toUpperCase();
			   
			   if(!checkSeatValueFromDisplayedSeat(displayedSeats, seat2))
			   {
				   try {
				  throw new InvalidTicketSelection("Invalid Seat ,Please a Valid Seat Number");
				   }catch(Exception e)
				   {
					   System.out.println("Invalid Seat Selected ,Please Enter a Valid Seat Number..");
				   }
				  
			   }else {
				   
				   SelectedSeat.add(seat2);
				   break;
			   }
	
			   }  
		   }
	    }
	   }
	   return SelectedSeat;
	
	}
	
	public boolean checkSeatValueFromDisplayedSeat(List<String>displayedSeats,String seat)
	{
		
		boolean seatFound=false;
		   for(String AllSeats:displayedSeats)
		   {
		   if(AllSeats.contains(seat))
		   {
			   seatFound=true;
		   }
		   }
		   return seatFound;
		   
		  
		   
	}
	
}

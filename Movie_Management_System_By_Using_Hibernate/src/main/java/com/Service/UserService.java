 package com.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.Entity.*;

import invalid_Details_Exceptions.Invalid_User_Details;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

import com.DAO.Theatre_DetailsDAO;
import com.DAO.TicketDetails_DAO;
import com.DAO.UserDAO;


public class UserService {
	
	User_Details user_Details=new User_Details();
	Theatre_Service theatre_Service=new Theatre_Service();
	TicketDetails ticketDetails=new TicketDetails();
	TicketService ticketService=new TicketService();
	MovieService movieService=new MovieService();
	UserDAO userDAO=new UserDAO();
	Payment_Details payment_Details=new Payment_Details();
	PaymentService paymentService=new PaymentService();
	TicketDetails_DAO ticketDetails_DAO=new TicketDetails_DAO();
	Scanner s=new Scanner(System.in);
	
	
	
	public void userRegistration()
	{	
		while(true)
		{
			try {
				System.out.println("Enter Your Name : ");
				String vName=s.nextLine();
				boolean nameStatus=false;
				for(int i=0;i<=vName.length()-1;i++ )
				{
					char ch=vName.charAt(i);
					if(Character.isAlphabetic(ch))
					{
						nameStatus=true;
					}else {
						nameStatus=false;
						throw new Invalid_User_Details("Invalid User Name, It should contain only Alphabets.");
					}
				}
				if(nameStatus)
				{
					user_Details.setUserName(vName);
					break;
				}
			
			}catch(Exception e)
			{
				System.out.println("Invalid UserName ,  Please Try Again ......");
			}
		}
		boolean emailStatus=true;
		while(emailStatus)
		{
		System.out.println("Enter Your Email_Id : ");
		String vEmailID=s.next();
		try {
			if(vEmailID.endsWith("@gmail.com"))
			{
				long count =userDAO.selectAllUsersDetails().stream().filter((userdetails)->userdetails.getUserEmail().equals(vEmailID)).count();
				if(count>0)
				{
					System.err.println("Email Already Exist, You Can Login With this Email ");
					throw new Invalid_User_Details("Email_Already Exits");
				}else {
				user_Details.setUserEmail(vEmailID);
				emailStatus=false;
				}
			}else {
				throw new Invalid_User_Details("Invalid Email Address , It Should End With @gmail.com");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Invalid Email , Please Try Again ....");
		}
		
		}
		while(true)
		{
			System.out.println("Enter Your Mobile_Number : ");
			long vMobileNumber=s.nextLong();
			
			try {
				if(vMobileNumber>6000000000l&&vMobileNumber<=9999999999l)
				{
					user_Details.setMobileNumber(vMobileNumber);
					break;
				}else {
					throw new Invalid_User_Details("Invalid Mobile Number ....");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Invalid Mobile Number , Please Try Again...");
			}
			
		}
		while(true)
		{
			System.out.println("Enter the Password for further login : ");
			String vPassword=s.next();
			
			try {
				if(vPassword.contains("@"))
				{
					user_Details.setUser_Password(vPassword);
					break;
				}else {
					throw new Invalid_User_Details("Invalid Password ......");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Invalid Password , It Should contain '@' Please try Again...");
			}
			
		}
		userDAO.InsertUserDetails(user_Details);
		
	}
	
	public void UserLogin()
	{
		
		System.out.print("Enter Your User_Email : ");
		String userEmailString=s.next();
		
		System.out.print("Enter Your Password : ");
		String userPassword=s.next();
		User_Details user_details=userDAO.userLogin(userEmailString);
	//	try {
		if(user_details.getUser_Password().equals(userPassword))
		{
			System.err.println("****************************Login Successfull*********************");
			System.out.println();
			System.out.println("*********** Welcome "+user_details.getUserName()+" Enjoy Your Bookings 🎬 ****************");
			UserOperations(user_details);
		}
		else {
     	    throw new Invalid_User_Details("You Have Entered Invalid Credentials");

  	     }
     //      }catch(Invalid_User_Details e)	   {
		System.err.println("We Found No data with This Details, Please Register First 🙂 ");
	 //   }catch (Exception e) {
			// TODO: handle exception
	    	System.err.println("Please Enter a Valid Input ,Something went Wrong Try Again");
	//	}
	}
	public void UserOperations(User_Details user_Details)
	{
		boolean userOperation=true;
		while(userOperation)
		{
		
		System.out.println("Enter \n 1.For Start Booking \n 2.For Checking Ticket Details \n 3.For Ticket Cancellation \n 4.For Exit..");
		int userChoice=s.nextInt();
		
		switch (userChoice) {
		case 1:{
			     System.out.println("Please Select Theatre From Below to Continue... "); 
			     System.out.println();
			     
			     System.out.println("Theatres In Your Locality\n");
			     Theatre_Details theatre_Details  =  theatre_Service.selectAllTheatreDetails();
			     
			      List<Movie_Details> AllmovieDetails = movieService.selectAllMovieByTheatreId(theatre_Details.getTheatre_Id());
			      if(AllmovieDetails.isEmpty())
			      {
			    	  System.out.println("No Movies Found");
			      }else{
			    	  System.out.print("Enter The S.No To Select The Movie : ");
			 	     int moviechoice=s.nextInt();
			 	     Movie_Details movie_details=AllmovieDetails.get(moviechoice-1);
			 	     System.out.println("You Have Selected "+AllmovieDetails.get(moviechoice-1).getMovieName()+" Movie ");
			      
			       List<TicketDetails> UserAlltickets=ticketService.selectTicketDetailswithoutPrinting(user_Details.getUser_id());
	
			      if(!UserAlltickets.isEmpty())
			      {
			    	   List<TicketDetails> movieTickets = UserAlltickets.stream().filter((ticketDetails)->ticketDetails.getMovie_Id()==movie_details.getMovieId()).collect(Collectors.toList());
			    	   
			    	 if(movieTickets!=null)
			    	 {
			    		 int numberOfTickets=0;
			    		  for(TicketDetails ticket_Details :movieTickets)  
			    		  { 
			    			  if(numberOfTickets<ticket_Details.getNo_Of_tickets())
			    		       {
			    			  numberOfTickets =ticket_Details.getNo_Of_tickets()+ticket_Details.getNo_Of_tickets();
			    		       }
			    		  }
			    		 if(numberOfTickets>2 )
			    		 {
			    			 System.out.println("You Have Already Reached Maximum booking limit");
			    		 }else {
					    	  System.out.println("You Already have Some tickets ");
                              System.out.println("Enter \n 1.For booking One More Ticket \n 2.For Showing Ticket Details");
                              switch (s.nextInt()) {
							case 1:{
								 
								     List<String> seat =ticketService.DisplaySeats(movie_details.getMovieId());
								     
								    System.out.println("You Have Selected Seat : "+seat);
								    System.out.println("Movie Name : "+movie_details.getMovieName());
							    	System.out.println("Amount Per Ticket : "+movie_details.getTicketPrice());
							    	System.out.println("Total Amount : "+movie_details.getTicketPrice()*seat.size());
								    System.out.println("Please Press 1 to confirm ");
								    int choice=s.nextInt();
								    if(choice==1)
								    {
								    	ticketBooking(user_Details ,movie_details,theatre_Details,seat);
								    }else {
								    	System.out.println("You Have Entered Invalid Key,Please try Again");
								    }
								    
							    }
								break;
							case 2:{
								ticketService.selectTicketDetailsUsingUserId(user_Details.getUser_id());
							}
							break;
							default:
								System.out.println("Please Enter a Valid Option");
								break;
							}
			    		 }
			    	 }else {
			    		 System.out.println("No Movies Found in dataBase");
			    	 }
			    	  
			      }else{
			    	   
			    	    System.out.println("__________________Welcome New User__________________");
			    	    List<String> seat = ticketService.DisplaySeats(movie_details.getMovieId());
			    	    
					    System.out.println("You Have Selected Seat : "+seat);
					    System.out.println("Movie Name : "+movie_details.getMovieName());
				    	System.out.println("Amount Per Ticket : "+movie_details.getTicketPrice());
				    	System.out.println("Total Amount : "+movie_details.getTicketPrice()*seat.size());
					    System.out.println("Please Press 1 to confirm ");
					    int choice=s.nextInt();
					    if(choice==1)
					    {
			               ticketBooking(user_Details, movie_details, theatre_Details, seat);
					         
					    }else {
					    	System.out.println("You Have Entered Invalid Key Please Try Again...");
					    }
			      }
			
		      }
		}
			break;
		case 2:{
			ticketService.selectTicketDetailsUsingUserId(user_Details.getUser_id());
		}
		break;
		case 3:{
			List<TicketDetails> AllticketsOfUser=ticketService.selectTicketDetailsUsingUserId(user_Details.getUser_id());
			    
			    if(!AllticketsOfUser.isEmpty())
			    {
			        
			    	System.out.println("\nEnter S.No for Selecting the Ticket ");
				    int s_choice=s.nextInt();
				    System.out.println("You Have Selected "+AllticketsOfUser.get(s_choice-1).getMovieName()+" Movie Ticket");  
				    
			    	System.err.println("_____________Please Verify Your Details________________\n");
			    	System.out.println("Enter Your Ticket_Id : ");
			    	int ticket_Id=s.nextInt();
			    	
			    
			    	long count=AllticketsOfUser.stream().filter((ticketdetails)->ticketdetails.getTicketId()==ticket_Id).count();
			    	
			    	if(count!=0)
			    	{
			    		ticketService.deleteTicketByUsingTicketId(ticket_Id);
			    	}else {
			    		System.out.println("Please Enter a Valid Ticket ID");
			    	}
			    }else {
			    	System.err.println("You Do Not Booked Any Ticket...Please Book Your Ticket First to Cancel");
			    }
			
			}
		break;
		case 4:{
			System.out.println("------------Thanks For Using-------------");
			userOperation=false;
			}
		break;
		default:
			System.out.println("Enter a Valid Option");
			break;
		}
	  }
	}
		
	public void ticketBooking(User_Details user_Details,Movie_Details movie_details,Theatre_Details theatre_Details,List<String> seat)
	{
		Payment_Details payment_details=new Payment_Details();
		
		payment_details  = paymentService.PaymentProcess(movie_details.getTicketPrice()*seat.size());
		
		 if(payment_details!=null)
		    {
		    	payment_details.setMovieId(movie_details.getMovieId());
		    	payment_details.setPaymentDate(Date.valueOf(LocalDate.now()));
		    	payment_details.setTheatreId(theatre_Details.getTheatre_Id());
		    	payment_details.setTicket_Price(movie_details.getTicketPrice()*seat.size());
		    	payment_details.setUserId(user_Details.getUser_id());
		    	payment_details.setPaymentType(payment_details.getPaymentType());
		    	
		    	movie_details.setNoOfSeats(movie_details.getNoOfSeats()-seat.size());
		    	System.out.println(payment_details);
		    	paymentService.insertPaymentdetails(payment_details);
		    	System.out.println("Ticket Booked, Enjoy the Movie ☺ ☺");
		    	int seatno=0;
		    	
				System.out.println("___________Ticket Details_________________");
				
				for(int i=1;i<=seat.size();i++)
				{
                TicketDetails ticketdetails=new TicketDetails();
                
                ticketdetails.setMovie_Id(movie_details.getMovieId());
                ticketdetails.setMovieName(movie_details.getMovieName());
                ticketdetails.setNo_Of_tickets(seat.size()+ticketdetails.getNo_Of_tickets());
                ticketdetails.setTheatre_Id(theatre_Details.getTheatre_Id());
                ticketdetails.setDate(Date.valueOf(LocalDate.now()));
                ticketdetails.setTicket_amount(movie_details.getTicketPrice());
                ticketdetails.setUser_Id(user_Details.getUser_id());
                ticketdetails.setUser_Name(user_Details.getUserName());
                ticketdetails.setSeatNo(seat.get(seatno++));
			    movie_details.setNoOfSeats(movie_details.getNoOfSeats()-seat.size());
			    ticketdetails.setBookedSeats(seat);
			    
			    
			    ticketService.insertTicketDetails(ticketdetails);
			    
                 System.out.println(ticketdetails);
				}
			   
		}else {
	    	System.out.println("Payment has not Completed , Please Try Again");
		}
	   
	}
}

package com.DAO;

import java.util.HashSet;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.Entity.TicketDetails;

public class TicketDetails_DAO {
	
	public void insertTicketDetails(TicketDetails ticket_Details)
	{ 
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Movie_Management_System_By_Using_Hibernate");
		EntityManager entityManager =entityManagerFactory.createEntityManager();
	    EntityTransaction entityTransaction =entityManager.getTransaction();
	    entityTransaction.begin();
	    entityManager.persist(ticket_ Details);
	    entityTransaction.commit();
	    System.out.println("---------Ticket Has Booked Succuesfully-----------");
	}
	public List<TicketDetails> selectTicketDetailsByUserId(int User_Id)
	{
		String select="select ticketDetails from TicketDetails ticketDetails where ticketDetails.user_Id = :UserId";
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Movie_Management_System_By_Using_Hibernate");
	    EntityManager entityManager =entityManagerFactory.createEntityManager();
	    EntityTransaction entityTransaction = entityManager.getTransaction();
	    entityTransaction.begin();
	    try {
	    List<TicketDetails> AllTicketDetails=entityManager.createQuery(select,TicketDetails.class).setParameter("UserId",User_Id).getResultList();
	   
	    return AllTicketDetails;
	    }catch (Exception e) {
			// TODO: handle exception
	    	return null;
		}
	}
	public Set<String> getBookedSeats(int movieId)
	{
		String bookedSeats="SELECT seat FROM TicketDetails t JOIN t.BookedSeats seat WHERE t.movie_Id = :movieId";
	    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Movie_Management_System_By_Using_Hibernate");
	    EntityManager entityManager  = entityManagerFactory.createEntityManager();
	    EntityTransaction entityTransaction  = entityManager.getTransaction();
	    entityTransaction.begin();
	    List<String> AllbookedSeat = entityManager.createQuery(bookedSeats,String.class).setParameter("movieId", movieId).getResultList();
	    
	    return new HashSet<String>(AllbookedSeat);
	    
	}
	public TicketDetails selectTicketDetailsByUsingTicketId(int ticketId)
	{
		String selectTicket="select ticketdetails from TicketDetails ticketdetails where ticketdetails.ticketId = :ticketId";
	    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Movie_Management_System_By_Using_Hibernate");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    EntityTransaction entityTransaction =entityManager.getTransaction();
	    entityTransaction.begin();
	    javax.persistence.Query query  =entityManager.createQuery(selectTicket,TicketDetails.class);
	    query.setParameter("ticketId",ticketId);
	    try {
	    TicketDetails ticket_Details =(TicketDetails)query.getSingleResult();
	    return ticket_Details;
	    }catch (Exception e) {
			// TODO: handle exception
	    	System.out.println("No Result Found of Ticket");
	    	return null;
		}
	}
	public void deleteTicketDetailsByTicketId(int ticketId)
	{
		String deleteSeats="DELETE FROM ticketdetails_bookedseats WHERE TicketDetails_ticketId = ?";
		String deleteTicket="DELETE FROM TicketDetails ticketdetails where ticketdetails.ticketId = :ticketid";
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Movie_Management_System_By_Using_Hibernate");
		    EntityManager entityManager = entityManagerFactory.createEntityManager();
		    EntityTransaction entityTransaction =entityManager.getTransaction();
		    entityTransaction.begin();
		    Query query =entityManager.createNativeQuery(deleteSeats);
		    query.setParameter(1, ticketId);
		    int resSeat =query.executeUpdate();
		    
		     Query query2  =entityManager.createQuery(deleteTicket);
		     query2.setParameter("ticketid",ticketId);
		     int res2 = query2.executeUpdate();
		    if(resSeat>0 && res2>0)
		    {
		    	System.out.println(".....Ticket Has been Cancelled...");
		    }else {
		    	System.out.println("*********** Server Error ****************");
		    }
		    entityTransaction.commit();
		    entityManager.close();
	}


}


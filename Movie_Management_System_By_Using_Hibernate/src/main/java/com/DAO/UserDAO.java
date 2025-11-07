package com.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.Entity.Admin_Details;
import com.Entity.User_Details;

public class UserDAO {
	
	List<User_Details> listOf_user_details=new ArrayList<User_Details>();
	public void InsertUserDetails(User_Details user_Details) {
		
		    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Movie_Management_System_By_Using_Hibernate");
		    EntityManager entityManager=entityManagerFactory.createEntityManager();
		    EntityTransaction transaction = entityManager.getTransaction();
		    transaction.begin();
		    entityManager.persist(user_Details);
		    transaction.commit();
		    System.out.println("User Details Inserted Successfully");
	}
	public List<User_Details> selectAllUsersDetails()
	{
	   String select="select user_details from User_Details user_details ";
	   EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("Movie_Management_System_By_Using_Hibernate");
	   EntityManager entityManager = entityManagerFactory.createEntityManager();
	   EntityTransaction entityTransaction =entityManager.getTransaction();
	   entityTransaction.begin();
	   TypedQuery<User_Details> userdetails = entityManager.createQuery(select,User_Details.class);
	   listOf_user_details=userdetails.getResultList();
	   
	   return listOf_user_details;
	   
	}
	public User_Details userLogin(String email)
	{
		//select r.f.v from EntityClassName r.f.v where r.f.v variablleName=value
		
		 String login="select user_details from User_Details user_details where user_details.userEmail = :emailId";
		  EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("Movie_Management_System_By_Using_Hibernate");
	      EntityManager entityManager = entityManagerFactory.createEntityManager();
	      EntityTransaction entityTransaction= entityManager.getTransaction();
	      entityTransaction.begin();
	      
	      TypedQuery<User_Details>  query = entityManager.createQuery(login,User_Details.class);
	      query.setParameter("emailId",email);
	      
	      try {
	    	  
	      User_Details user_Details = query.getSingleResult();
	      if(user_Details!=null)
	      {
	    	 return user_Details;
	      }
	      return null;
	      }catch (Exception e) {
			// TODO: handle exception
	    	  System.out.println("..No Data Found..");
	    	 return null;
		} 
	      
	}

}

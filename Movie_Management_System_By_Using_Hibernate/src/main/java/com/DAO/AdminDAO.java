package com.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.Entity.Admin_Details;

public class AdminDAO {
	
	List<Admin_Details> ListOf_admin_Details ;
	
	public void insertAdminDetails(Admin_Details admin_Details)
	{
		EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("Movie_Management_System_By_Using_Hibernate");
	    EntityManager entityManager =entityManagerFactory.createEntityManager();
	    EntityTransaction entityTransaction =entityManager.getTransaction();
	    entityTransaction.begin();
	    entityManager.persist(admin_Details);
	    entityTransaction.commit();
	    System.out.println("Data Inserted Successfully...");
	}
	public List<Admin_Details> SelectAllAdminDetails()
	{
		String select ="select admindetails from  Admin_Details admindetails ";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Movie_Management_System_By_Using_Hibernate");
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
	    ListOf_admin_Details = entityManager.createQuery(select,Admin_Details.class).getResultList();
	    System.out.println(ListOf_admin_Details);
		return ListOf_admin_Details;
	}
	public Admin_Details adminLoginUsingEmailAndPassword(String Email,String Password)
	{
		//select r.f.v from EntityClassName r.f.v where r.f.v variablleName=value
		String select="select admin_details from Admin_Details admin_details where admin_details.admin_Email = :email AND admin_details.admin_password = :password";
		
	    EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("Movie_Management_System_By_Using_Hibernate");
	    
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    EntityTransaction entityTransaction = entityManager.getTransaction();
	    
	    entityTransaction.begin();
	    
	    try {
	    TypedQuery<Admin_Details> query = entityManager.createQuery(select,Admin_Details.class);
	    query.setParameter("email", Email);
	    query.setParameter("password",Password);
	      
	     
	     Admin_Details admin_Detail=query.getSingleResult();
	     return admin_Detail;
	    }catch (Exception e) {
			// TODO: handle exception
	    	System.out.println("No Data Found in DBMS ");
	    	return null;
		}
	    
	  
	}

}

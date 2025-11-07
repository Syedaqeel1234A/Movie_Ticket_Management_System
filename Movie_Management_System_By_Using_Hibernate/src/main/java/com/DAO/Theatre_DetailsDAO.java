package com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.Entity.Theatre_Details;

public class Theatre_DetailsDAO {

	
	public void insertTheatre_Details(Theatre_Details theatre_Details)
	{
		EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("Movie_Management_System_By_Using_Hibernate");
	    EntityManager entityManager =entityManagerFactory.createEntityManager();
	     EntityTransaction entityTransaction = entityManager.getTransaction();
	     entityTransaction.begin();
	     entityManager.persist(theatre_Details);
	     entityTransaction.commit();
	     System.out.println("Data Inserted SuccessFully..");
	}
	public List<Theatre_Details> selectAllTheatres()
	{ 
	String select="select theatreDetails from Theatre_Details theatreDetails ";
	EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("Movie_Management_System_By_Using_Hibernate");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	entityTransaction.begin();
	List<Theatre_Details>  theatre_Details =entityManager.createQuery(select,Theatre_Details.class).getResultList();
	return theatre_Details;
	}
	
	
}

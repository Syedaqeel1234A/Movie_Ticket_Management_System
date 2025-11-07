package com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.Entity.Payment_Details;

public class PaymentDAO {

	public void insertPaymentDetails(Payment_Details payment_Details)
	{
		EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("Movie_Management_System_By_Using_Hibernate");
	    EntityManager entityManager =entityManagerFactory.createEntityManager();
	    EntityTransaction entityTransaction =  entityManager.getTransaction();
	    entityTransaction.begin();
	    try {
	    entityManager.persist(payment_Details);
	    }catch (Exception e) {
			// TODO: handle exception
	    	System.out.println("Error while storing payment details");
		}
	    entityTransaction.commit();
	}
	public List<Payment_Details> selectPaymentDetailsByUserId(int UserId)
	{
		String select="select paymentdetails from Payment_Details paymentdetails where paymentdetails.UserId = :userId";
	    EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("Movie_Management_System_By_Using_Hibernate");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    EntityTransaction entityTransaction =entityManager.getTransaction();
	    entityTransaction.begin();
	    try {
	    List<Payment_Details> AllPaymentDetails =entityManager.createQuery(select,Payment_Details.class).setParameter("userId", UserId).getResultList();
	    return AllPaymentDetails;
	    }catch (Exception e) {
			// TODO: handle exception
	    	System.out.println("No tickets Found from DBMS");
	    	return null;
		}
	    
	}
}

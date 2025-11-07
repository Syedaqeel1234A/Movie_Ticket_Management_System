package com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.Entity.Movie_Details;
import com.Entity.TicketDetails;

public class MovieClass_DAO {

	public void insertmovieDetails(Movie_Details movie_Details)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Movie_Management_System_By_Using_Hibernate");
		EntityManager entityManager =entityManagerFactory.createEntityManager();
	    EntityTransaction entityTransaction =entityManager.getTransaction();
	    entityTransaction.begin();
	    entityManager.persist(movie_Details);
	    entityTransaction.commit();
	    System.out.println("Details Insertion Successfull...");
	    entityManager.close();
	    entityManagerFactory.close();
		
	}
	public List<Movie_Details> selectAllMovies() {
      String select ="select movieDetails from Movie_Details movieDetails ";
	 EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("Movie_Management_System_By_Using_Hibernate");
	 EntityManager  entityManager=entityManagerFactory.createEntityManager();
	 EntityTransaction entityTransaction=entityManager.getTransaction();
	 entityTransaction.begin();
	 
	 List<Movie_Details> allmovieDetails =entityManager.createQuery(select,Movie_Details.class).getResultList();
	 return allmovieDetails;
	}

	public List<Movie_Details> selectMoviesByTheatreId(int theatreId)
	{
		String select="select moviedetails from Movie_Details moviedetails where moviedetails.theatre_id = :theatreId";
		EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("Movie_Management_System_By_Using_Hibernate");
		 EntityManager  entityManager=entityManagerFactory.createEntityManager();
		 EntityTransaction entityTransaction=entityManager.getTransaction();
		 entityTransaction.begin();
		 List<Movie_Details> allmovieDetails =entityManager.createQuery(select,Movie_Details.class).setParameter("theatreId", theatreId).getResultList();
		 return allmovieDetails;
	}
	public Movie_Details selectMovieByMovieId(int Movie_id)
	{
		String select="select movieDetails from Movie_Details movieDetails where movieDetails.movieId = :MovieId";
	    EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("Movie_Management_System_By_Using_Hibernate");
	    EntityManager entityManager =entityManagerFactory.createEntityManager();
	    EntityTransaction entityTransaction =entityManager.getTransaction();
	    entityTransaction.begin();
	    try {
	    Movie_Details movie_Details = entityManager.createQuery(select,Movie_Details.class).setParameter("MovieId", Movie_id).getSingleResult();
	    return movie_Details;
	    }catch (Exception e) {
			// TODO: handle exception
	        System.out.println("Exception Handled....");
	    	return null;
		}
	}
}

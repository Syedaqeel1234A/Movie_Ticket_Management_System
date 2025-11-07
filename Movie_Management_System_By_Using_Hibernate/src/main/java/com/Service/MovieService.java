package com.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.DAO.MovieClass_DAO;
import com.Entity.Movie_Details;

public class MovieService {

	Scanner s=new Scanner(System.in);
	MovieClass_DAO movieClass_DAO=new MovieClass_DAO();
	
	
	public void insertmovieDetails(Movie_Details movie_Details)
	{
		System.out.print("Enter Movie Name : ");
		String mName=s.next();
		
		System.out.print("Enter Movie duration : ");
		String mduration=s.next();
		
		System.out.print("Enter Movie Ticket Price : ");
		double mPrice=s.nextDouble();
		
		movie_Details.setMovieName(mName);
		movie_Details.setDuration(mduration);
		movie_Details.setTicketPrice(mPrice);
		movieClass_DAO.insertmovieDetails(movie_Details);
	}
	
	public List<Movie_Details> selectAllMovieByTheatreId(int theatreId)
	{
	 List<Movie_Details> moviesOftheatre =movieClass_DAO.selectMoviesByTheatreId(theatreId);
	 
	 int i=1;
	 for(Movie_Details movie_Details : moviesOftheatre)
     {
    	 System.out.println("S.No : "+i++);
    	 System.out.println("Movie_Id            : "+movie_Details.getMovieId());
    	 System.out.println("Movie_Name          : "+movie_Details.getMovieName());
    	 System.out.println("Theatre Name        : "+movie_Details.getTheatreName());
    	 System.out.println("Movie_Duration_Time : "+movie_Details.getDuration());
    	 System.out.println("Ticket_Price        : "+movie_Details.getTicketPrice());
    	 System.out.println("###############################################################");
     } 
     return moviesOftheatre;
	}
	public Movie_Details SelectMovieByMovieId(int movieId)
	{
		Movie_Details movie_Details =movieClass_DAO.selectMovieByMovieId(movieId);
		if(movie_Details!=null)
		{
			return movie_Details;
		}else {
			System.out.println("No Movies Found By id ");
			return null;
		}
	}
}

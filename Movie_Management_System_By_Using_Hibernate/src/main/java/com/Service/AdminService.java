package com.Service;

import java.util.List;
import java.util.Scanner;

import com.DAO.AdminDAO;
import com.DAO.MovieClass_DAO;
import com.DAO.Theatre_DetailsDAO;
import com.Entity.Admin_Details;
import com.Entity.Movie_Details;
import com.Entity.Theatre_Details;

import invalid_Details_Exceptions.Admin_Invalid_Details_Exceptions;

public class AdminService {
	
	Admin_Details admin_Details = new Admin_Details();
	AdminDAO adminDAO=new AdminDAO();
	Theatre_Service theatre_Service=new Theatre_Service();
	MovieClass_DAO movieClass_DAO=new MovieClass_DAO();
	Movie_Details movie_Details=new Movie_Details();
	MovieService movieService=new MovieService();
	
	Scanner s=new Scanner(System.in);
	public void adminRegistration()
	{
		boolean nameloop=true;
		while(nameloop)
		{
		System.out.print("Enter Your Name : ");
		String adminName=s.next();
		boolean namestate=false;
		for(int i=0;i<=adminName.length()-1;i++)
		{
			char ch=adminName.charAt(i);
			if(ch>='a'&& ch<='z' || ch>='A' && ch<='z' )
			{
				namestate=true;
			}else {
				namestate=false;
				break;
			}
		}
		try {
		if(namestate)
		{
			admin_Details.setAdmin_Name(adminName);
			nameloop=false;
		}else {
			throw new Admin_Invalid_Details_Exceptions("Invalid Name ");
		}
		}catch(Exception e)
		{
			System.err.println("Invalid Name , It Should contain only Alphabets Please try Again.. ");
		}
		}
		
		boolean emailloop=true;
		while(emailloop)
		{
		System.out.print("Enter Your Email_Id : ");
		String adminEmail=s.next();
		try {
		if(adminEmail.endsWith("@gmail.com"))
		{
		    long count = selectAdminDetails().stream().filter((admindetails)->admindetails.getAdmin_Email().equals(adminEmail)).count();
			if(count>0)
			{
				System.out.println("Email Already Exist , Please Register Using Another Email....");
				throw new Admin_Invalid_Details_Exceptions("Email Already Exist , Please Try Again... ");
			}else {
				
			admin_Details.setAdmin_Email(adminEmail);
			emailloop=false;
			}
		}else {
			throw new Admin_Invalid_Details_Exceptions("Invalid Email_Id");
		}
		}catch (Admin_Invalid_Details_Exceptions e) {
			// TODO: handle exception
			System.out.println("The Email Id Is Already Registered (Or) It Should Contain @gmail.com in it. ");
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Invalid Email, It Should contain @gmail.com in it... please try Again");
		}
		
	}
		boolean passwordloop=true;
		while(passwordloop)
		{
		System.out.print("Enter Your Password  :  ");
		String adminPassword=s.next();
		
		try {
			if(adminPassword.contains("@"))
			{
				admin_Details.setAdmin_password(adminPassword);
				passwordloop=false;
			}else {
				throw new Admin_Invalid_Details_Exceptions("invalid Email_id ");
			}
		} catch (Exception e) {
			System.err.println("Invalid Email_ID , it should contain '@' in it....");
			System.out.println("...Please Try Again...");
		}
	
	   }
		adminDAO.insertAdminDetails(admin_Details);
	}
	public void adminLogin()
	{
		
		int attempts=3;
		boolean status=true;
		while(status)
		{
		System.out.println("----------Welcome to Login Page----------");
		System.out.println();
		System.out.print("Enter your Email_Id : ");
		String email_id=s.next();
		System.out.print("Enter your Password : ");
		String admin_password=s.next();
		
	     Admin_Details admindetails= adminDAO.adminLoginUsingEmailAndPassword(email_id, admin_password);
		 if(admindetails!=null)
		 {
			 if(admindetails.getAdmin_password().equals(admin_password))
			 {
				 System.out.println("****************Login Successfull****************");
				 System.out.println("_________Welcome "+admindetails.getAdmin_Name()+"__________");
				 status=false;
				 adminOperations();
			  }else {
				  System.err.println("Invalid Password.....please Enter valid Details");
				  System.out.println("You Have Only "+attempts--+" chances left");
			 }
		 }else {
			 System.out.println("Invalid Admin Details ...... Please Enter Valid Details");
			 System.out.println("You Have Only "+attempts--+" chances left");
		 }
		 if(attempts==0)
		 {
			 status=false;
		 }
		 
		}
	}
	public List<Admin_Details> selectAdminDetails()
	{
	  List<Admin_Details> Alladmin_Details =adminDAO.SelectAllAdminDetails();
	  System.out.println("in admin :"+ Alladmin_Details);
	  if(Alladmin_Details!=null)
	  {
		  return Alladmin_Details;
	  }else {
		  return null;
	  }
	}
	public void adminOperations()
	{
		boolean adminoperationsloop=true;
		while(adminoperationsloop)
		{
		System.out.println("Enter \n 1.For Adding New Theatre To System  \n 2.For Adding Movies to Existing Theatres \n 3.For Previous Menu");
		switch (s.nextInt()) {
		case 1:{
			  theatre_Service.insertTheatreDetails();
		     }
			break;
		case 2:{
			   Theatre_Details theatre_Details=theatre_Service.selectAllTheatreDetails();
			   movie_Details.setTheatre_id(theatre_Details.getTheatre_Id());
			   movie_Details.setTheatreName(theatre_Details.getTheatre_Name());
			   movieService.insertmovieDetails(movie_Details);
	     }
		  break;
		case 3:{
			  adminoperationsloop=false;
		     }
			break;
		default:
			System.out.println("Please Choose a Valid Option");
			break;
		}
		}
	}

}

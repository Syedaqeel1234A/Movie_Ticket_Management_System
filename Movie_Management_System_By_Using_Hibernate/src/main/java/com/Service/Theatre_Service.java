package com.Service;

import java.util.List;
import java.util.Scanner;

import com.DAO.Theatre_DetailsDAO;
import com.Entity.Theatre_Details;

import invalid_Details_Exceptions.Invalid_User_Details;

public class Theatre_Service {
	
	Theatre_Details theatre_Details=new Theatre_Details();
	Theatre_DetailsDAO theatre_DetailsDAO=new Theatre_DetailsDAO();
	
	
	Scanner s=new Scanner(System.in);
	
	public void insertTheatreDetails()
	{
		while(true)
		{
		System.out.print("Enter Theatre Name : ");
		String tName=s.next();
		boolean t_name=false;
		for(int i=0;i<=tName.length()-1;i++)
		{
			char ch=tName.charAt(i);
			if(!Character.isAlphabetic(ch))
			{
				t_name=true;
				break;
			}
		}
		try {
		if(!t_name)
		{
			theatre_Details.setTheatre_Name(tName);
			break;
		}else {
			throw new Invalid_User_Details("Invalid Name ");
		}
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Invalid Name , It Should contain alphabets only ");
		}
		}
		System.out.println("Enter Theatre Address : ");
		String tAddress=s.next();
		theatre_Details.setTheatre_address(tAddress);
		
	    theatre_DetailsDAO.insertTheatre_Details(theatre_Details);
		
	}
	public Theatre_Details selectAllTheatreDetails()
	{
		List<Theatre_Details> allTheatreDetails=theatre_DetailsDAO.selectAllTheatres();
		int i=1;
		for(Theatre_Details theatre_Details : allTheatreDetails)
		{
			System.out.println("S.NO : "+i++);
			System.out.println("Theatre_Id      : "+theatre_Details.getTheatre_Id());
			System.out.println("Theatre_Name    : "+theatre_Details.getTheatre_Name());
			System.out.println("Theatre_Address : "+theatre_Details.getTheatre_address());
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println();
		}
		System.out.print("Enter the S.No To Select The Theatre : ");
		int t_Sno=s.nextInt();
		Theatre_Details theatre_Detail=allTheatreDetails.get(t_Sno-1);
		System.out.println("Selected "+theatre_Detail.getTheatre_Name()+" Theatre ");
		return theatre_Detail;
	}

}

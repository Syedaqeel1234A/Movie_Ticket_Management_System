
package com.Service;

import java.util.Scanner;

import com.DAO.PaymentDAO;
import com.Entity.Payment_Details;

public class PaymentService {
    
	Payment_Details payment_Details=new Payment_Details();
	PaymentDAO paymentDAO=new PaymentDAO();
	Scanner s=new Scanner(System.in);
	
	public Payment_Details PaymentProcess(double amount)
	{
	
		System.out.println("******************Welcome To Payment Gateway******************************");
		System.out.println();
		System.out.println("Enter \n 1.For UPI \n 2.For DebitCard \n 3.For NetBanking \n 4.For Cancel Payment");
		switch (s.nextInt()) {
		case 1:{
			  if(amountProcess(amount))
			  {
		        payment_Details.setPaymentType("UPI");
		        System.out.println("Payment Successfull Using UPI");
			  }
		      }
			break;
		case 2:{
			if(amountProcess(amount))
			{
	        payment_Details.setPaymentType("Debit_Card");
	        System.out.println("Payment Successfull Using Debit_Card");
			}
	      }
		break;	
		case 3:{
			if(amountProcess(amount))
			{
	        payment_Details.setPaymentType("NetBanking");
	        System.out.println("Payment Successfull Using NetBanking");
			}
	      }
		break;
		case 4:{
	         System.out.println("Payment Has Been Cancel");
	      }
		break;
        
		default:
			System.out.println("Enter a Valid Option");
			break;
		}
		
		if(payment_Details!=null)
		{
			return payment_Details;
		}else {
			return null;
		}
	}
    public boolean amountProcess(double amount)
    {
    	System.out.println("Enter The Amount to Pay : ");
    	double finalamount=s.nextDouble();
    	if(finalamount==amount)
    	{
    		return true;
    	}
    	return false;
    }
	public void insertPaymentdetails(Payment_Details payment_Details)
	{
		paymentDAO.insertPaymentDetails(payment_Details);
		System.out.println("Payment Details inserted");
	}
	
	
}

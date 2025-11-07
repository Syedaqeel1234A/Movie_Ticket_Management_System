package com;

import java.util.Scanner;

import com.Service.AdminService;
import com.Service.UserService;

/**
 * Hello world!
 *
 */
public class App {

	public static void main( String[] args )
    {
 
    	AdminService adminService=new AdminService();
    	UserService userservice=new UserService();	
    	Scanner s=new Scanner(System.in);
    	
    	boolean mainloop=true;
    	while(mainloop)
    	{
        System.out.println();
        System.err.println( "****************WELCOME TO MOVIE MANAGEMENT SYSTEM*****************" );
        System.out.println();
        System.out.println("Enter \n 1.For Admin_Operations \n 2.For User_Operations \n 3.For Exit");
        switch (s.nextInt()) {
		case 1:{
			System.err.println("This feature is only for Theatre Owners, Please Enter Password to Continue : ");
			System.out.println("..Enter Any Number For Previous Menu..");
			int a_choice=s.nextInt();
			if(a_choice==123)
			{
				boolean admin_loop=true;
				while(admin_loop)
				{
				System.out.println("____________________ Admin Operation _________________________");
				System.out.println();
				System.out.println("Enter \n 1.For Admin_Registration \n 2.For Admin Login \n 3.For Exit . ");
				int admin_choice = s.nextInt();
				switch (admin_choice) {
				case 1:{
				    
				    adminService.adminRegistration();
				}
				break;
				case 2:{
					adminService.adminLogin();
				}
				break; 
				case 3:{
				
					admin_loop=false;
				}
				break; 
				default:
					System.err.println("----------Enter a Valid Option--------------");
					break;
				}
			 }
			
			}
		}
		break;
		case 2:{
			boolean userloop=true;
			while(userloop)
			{
			System.out.println("Enter \n 1.For User_Registration \n 2.For User_Login \n 3.For Exit . ");
			int user_choice=s.nextInt();
			switch (user_choice) {
			case 1:{
				
				System.out.println("----------Welcome to Registration Page----------");
				userservice.userRegistration();
				
			     }
				break;
            case 2:{
				
				System.out.println("----------Welcome to Login Page----------");
			    userservice.UserLogin();
				
			     }
                 break;
            case 3:{
				
				System.out.println("----------------Thanks For Using Movie_Management_System😉😉----------------------");
				
			     }
                 break;
			default:
				System.err.println("Please Enter a valid choice... ");
				break;
			}
			}
			
		}
		break;
       case 3:{
    	   System.out.println("------ Thanks for using our service -------");
			mainloop=false;
		}
		break;
		default:
			System.err.println("Enter a valid choice....");
			break;
    	}
    }
}
}

package com.rms;

import java.io.IOException;
import java.util.Scanner;
public class main {
	
	static Integer emp_id;
	static String emp_name;
	static String designation;
	static Double salary ;
	static String organization_name ;
	
	static Integer promo_id;
	static String promo_name;
	static String promo_user;
	static String dateofexpiry;
	
	static Integer rest_id;
	static String rest_name;
	static String street;
	static String city ;
	static String country ;
	static String postel_code ;

	

	static Integer t = 0;
	static Integer value  = 0 ;
	static Scanner sc ;
public static void main (String [] args ) throws IOException
{

	while (value==0)
	{
	
	Scanner sc = new Scanner(System.in);
	System.out.println("###################################################");
	System.out.println("#                                                 #");
	System.out.println("#    Welcome To Restaurant Management System      #");
	System.out.println("#                                                 #");
	System.out.println("#      By: Johnshan | Devinder | Siva Reddy       #");
	System.out.println("#          C0711613 | C0713493 | C0710113         #");
	System.out.println("#                                                 #");
	System.out.println("###################################################");
	System.out.println("\n ****** MAIN MENU ******\n");
    System.out.println("(>) Press 1 To Add  Employee's");
    System.out.println("(>) Press 2 To Show Employee's");
    System.out.println("(>) Press 3 To Show Customers");
    System.out.println("(>) Press 4 To Add  Promocode's");
    System.out.println("(>) Press 5 To Show Promocode's");
    System.out.println("(>) Press 6 To Show Orders");
    System.out.println("(>) Press 7 To Add new Restaurant's");
    System.out.println("(>) Press 8 To Show Restaurant's");

    System.out.println("\n$$$$$$   Press 9 To Exit   $$$$$$");

	value = sc.nextInt();
	
	
	
	switch(value)
	{
	
	case 1 :
		
		employee_info();
		System.out.println("\n$$$$$$   Press 0 For Main Menu   $$$$$$");
		value=sc.nextInt();

					break;
	case 2:
		emplpoyee.showemployee();
		
		System.out.println("\n$$$$$$   Press 0 For Main Menu   $$$$$$");
	    value=sc.nextInt();

		
		break ;
		
	case 3:
		users.showusers();
		
		System.out.println("\n$$$$$$   Press 0 For Main Menu   $$$$$$");
	    value=sc.nextInt();

		break ;
		
	case 4  :
		System.out.println("Add Promo");
		insertpromo_info();		

		System.out.println("\n$$$$$$   Press 0 For Main Menu   $$$$$$");
		value=sc.nextInt();

		break ;

	case 5:
		System.out.println("\n ###   PromoCode Data Search   ###");
		promo.showpromo();	
		
		System.out.println("\n$$$$$$   Press 0 For Main Menu   $$$$$$");
		value=sc.nextInt();
		break;

	case 6:
		System.out.println("\n ###   Orders Data Search   ###");
		orders.showorderds();
		
		System.out.println("\n$$$$$$   Press 0 For Main Menu   $$$$$$");
		  value=sc.nextInt();
		  break;
	case 7:
		add_rest();
		System.out.println("\n$$$$$$   Press 0 For Main Menu   $$$$$$");
		  value=sc.nextInt();
break;
	case 8:
		
		restuarant.showrestaurant();
		System.out.println("\n$$$$$$   Press 0 For Main Menu   $$$$$$");
		  value=sc.nextInt();
		  break;
		
		
	case 9:
		System.out.println("Thank You!");
		System.exit(0);
		break;
		

		default :
			System.out.println("@@ Sorry You Have Typed an Invalid Option @@");
			 
			System.out.println("\n$$$$$$   Press 0 For Main Menu   $$$$$$");
				value=sc.nextInt();

	}
	}

	}
	
	
			
		   
	


public  static void employee_info()
{
	
	Scanner sc1 = new Scanner(System.in);
	
	   System.out.println("### ADD New Employee Data ###\n");
	   
	   System.out.println("\n> Enter Employee ID [eg. 123] : \n");
	   emp_id =sc1.nextInt();
	   

	   System.out.println("\n> Enter Employee Name : \n");
	   emp_name =sc1.next();
	   
	   System.out.println("\n> Enter Employee Designation : \n");
	   designation =sc1.next();
	   
	   System.out.println("\n> Enter Employee salary : \n");
	   salary =sc1.nextDouble();
	   
	   System.out.println("\n> Enter Employee Organization : \n");
	   organization_name =sc1.next();
	   
	   
	   try {
		   
		emplpoyee.insertdataemp(emp_id, emp_name, designation, salary, organization_name);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	   System.out.println("\n%%%%%   Employee Added Successfully  %%%%%");
	   
	   
}

public  static void insertpromo_info()
{
	
	Scanner sc1 = new Scanner(System.in);
	
	   System.out.println("\n###  ADD New Promocode  ###\n");
	   
	   System.out.println("\n > Enter Promocode ID : \n");
	   promo_id =sc1.nextInt();
	   

	   System.out.println("\n > Enter Promocode Name : \n");
	   promo_name =sc1.next();
	   
	   System.out.println("\n > Enter Promocode Users : \n");
	   promo_user =sc1.next();
	   
	   System.out.println("\n Enter Expiry Date [DD/MM/YYYY] : \n");
	   dateofexpiry =sc1.next();
	   
	   
	   
	   try {
		   promo.insertpromo(promo_id, promo_name, promo_user, dateofexpiry);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	   
	   {
	   System.out.println("\n%%%%%   PromoCode Added Successfully  %%%%%");

}
}
public  static void add_rest()
{
	
	Scanner sc1 = new Scanner(System.in);
	
	   System.out.println("###   ADD New Restautrant   ###\n");
	   
	   System.out.println("\n > Enter Restaurant ID : \n");
	   rest_id =sc1.nextInt();
	   

	   System.out.println("\n > Enter Restaurant Name : \n");
	   rest_name =sc1.next();
	   
	   System.out.println("\n > Enter Restaurant Address : \n");
	   street =sc1.next();
	   
	   System.out.println("\n > Enter City : \n");
	   city =sc1.next();
	   
	   System.out.println("\n > Enter Country : \n");
	   country =sc1.next();
	   
	   System.out.println("\n Enter Postal Code : \n");
	   postel_code =sc1.next();
	   
	   
	   
	   try {
		   restuarant.insertrestaurant(rest_id, rest_name, street, city, country, postel_code);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	   System.out.println("\n%%%%%   Restaurant Added Successfully  %%%%%");
	   
	   
}

}

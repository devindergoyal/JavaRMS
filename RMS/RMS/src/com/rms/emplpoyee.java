package com.rms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("serial")
public class emplpoyee extends Exception {
	
	public static Integer emp_id;
	public static String emp_name;
	public static String designation;
	public static Double salary ;
	public static String organization_name ;
	
	public static void insertdataemp(Integer empid , String empname , String des , Double sal , String organization) throws IOException
	{
		
		emp_id = empid ; 
		emp_name = empname;
		designation = des;
		salary = sal;
		organization_name = organization ; 
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String date = df.format(new Date());
		
		String emp_info = "\n"+empid + "  " + empname + "  " + des + "  "+sal + "  " + organization + " "+date;
		
		 File f2 = new File("employee.txt");
		  f2.createNewFile();
		  FileWriter writer = new FileWriter(f2,true);
		  BufferedWriter buffer = new BufferedWriter(writer);  
		   buffer.write(emp_info); 
	        buffer.close(); 
	}
	
	public static void showemployee () throws IOException
	{
		
		
Path path = Paths.get("employee.txt");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n ###   Employee Data Search   ###");
		System.out.println("\n[Eg. Enter Employee ID]\n");
		
		String emp = sc.next();
		
        List<String> stringList = getLinesThatContain(path, emp);

        if (stringList.isEmpty()==false)
        {
        	System.out.println("\n ID | Name | Position | Salary | Location | Joining\n");
        for (int i=0 ;i<=stringList.size()-1;i++)
        {
        	
        	 System.out.println(stringList.get(i));
        	 System.out.println();
        	 

        }
       
        }
        else {
        	System.out.println("Sorry! Wrong Input Try Again");
		}
	}
	
	 public static List<String> getLinesThatContain(Path path, String match) {
	        List<String> filteredList = null;

	        try(Stream<String> stream = Files.lines(path)){
	            // Filtering logic here
	             filteredList = stream.filter(line -> line.contains(match))
	                                  .collect(Collectors.toList());

	        } catch (IOException ioe) {
	            // exception handling here
	        }
	        return filteredList;
	    }
}

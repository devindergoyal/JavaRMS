package com.rms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("serial")
public class users extends Exception {
	
	public static Integer user_id;
	public static String username;
	public static String password;
	public static String user_category ;
	public static String Total_orders ;
	
	public static void showusers () throws IOException
	{
Path path = Paths.get("users.txt");
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("\n[Enter Customer Information | Eg. Customer Name or Customer ID]\n");
		
		
		String user_cat = sc.next();
		
        List<String> stringList = getLinesThatContain(path, user_cat);

        if (stringList.isEmpty()==false)
        {
        	System.out.println("Customer ID | Name | Category | Orders ]\n");
        for (int i=0 ;i<=stringList.size()-1;i++)
        {
        	
        	 System.out.println(stringList.get(i));
        	 System.out.println();

        }
       
        }
        else {
        	System.out.println("No such data found for users");
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

package com.rms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("serial")
public class restuarant extends Exception {
	
	public static Integer rest_id;
	public static String rest_name;
	public static String Street_Adreess;
	public static String City ;
	public static String country ;
	public static String postelcode ;

	
	public static void insertrestaurant(Integer restid , String restname , String street , String city , String countryname ,String postel) throws IOException
	{
		
		rest_id = restid ; 
		rest_name = restname;
		City = city;
		Street_Adreess = street;
		country= countryname ; 
		postelcode = postel;
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String date = df.format(new Date());
		
		String rest_info = "\n"+restid + "  " + restname + "  " + city + "  "+street + "  " + countryname + "  "+postel +"  "+date;
		
		 File f2 = new File("restaurants.txt");
		  f2.createNewFile();
		  FileWriter writer = new FileWriter(f2,true);
		  BufferedWriter buffer = new BufferedWriter(writer);  
		   buffer.write(rest_info); 
	        buffer.close(); 
	}
	
	public static void showrestaurant () throws IOException
	{
		/*File file = new File("restaurants.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer = new StringBuffer();
		String line ;
		while ((line = bufferedReader.readLine()) != null) {
			stringBuffer.append(line);
			stringBuffer.append("\n");
		}
		fileReader.close();
		System.out.println(stringBuffer.toString());*/
		Path path = Paths.get("restaurants.txt");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n ###   Restaurant Data Search   ###");
		System.out.println("\n[Eg. Enter Restaurant ID or Restaurant Name Or Location]\n");
		
		String city = sc.next();
		
        List<String> stringList = getLinesThatContain(path, city);

        if (stringList.isEmpty()==false)
        {
        	
        System.out.println("\n Rest ID | Name | Location |    Address    | Postal Code | Date\n");
       
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

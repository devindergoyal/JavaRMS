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
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("serial")
public class orders extends Exception {
	
	

	
	public static void showorderds () throws IOException
	{
		/*File file = new File("orders.txt");
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
		
		
Path path = Paths.get("orders.txt");
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("\n[Enter Order Information | Eg. Customer Name or Order ID]\n");
		
		String date = sc.next();
		
        List<String> stringList = getLinesThatContain(path, date);

        if (stringList.isEmpty()==false)
        {
        	System.out.println("\nOrder ID | Customer Name | Products | Retail Price | Discount | Location | Date\n");
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



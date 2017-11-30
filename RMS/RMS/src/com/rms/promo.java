package com.rms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("serial")
public class promo extends Exception {
	
	public static Integer promo_id;
	public static String promo_name;
	public static String promo_user ;
	public static String dateofexpiry ;

	public static void insertpromo(Integer promoid , String promoname , String promouser , String date) throws IOException
	{
		
		promo_id = promoid ; 
		promo_name = promoname;
		promo_user = promouser;
		dateofexpiry = date ;
		
		String promo_info = "\n"+promo_id + "  " + promo_name + "  " +promo_user + " "+ dateofexpiry ;
		
		 File f2 = new File("promo.txt");
		  f2.createNewFile();
		  FileWriter writer = new FileWriter(f2,true);
		  BufferedWriter buffer = new BufferedWriter(writer);  
		   buffer.write(promo_info); 
	        buffer.close(); 
	}
	
	public static void showpromo () throws IOException
	{
		File file = new File("promo.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer = new StringBuffer();
		String line ;
		while ((line = bufferedReader.readLine()) != null) {
			stringBuffer.append(line);
			stringBuffer.append("\n");
		}
		fileReader.close();
		System.out.println("\n[Enter Promo Information | Eg. Promo Name or Promo ID]\n");
		System.out.println("[ Promo ID | Promo | Category | Expiry ]");
		System.out.println(stringBuffer.toString());
	}
}

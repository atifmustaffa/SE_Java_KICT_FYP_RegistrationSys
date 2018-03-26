/**
 * 'Atif Mustaffa
 * 1429619
 * 13 Nov 2016
 * SE_Project
 *
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ReadFYPFromFile {
	
	public static FYPCollection main(String[] args) throws FileNotFoundException {
			
		File file = new File("files/fypDatabase.dat");

		Scanner input = new Scanner(file);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		
		FYPCollection f = new FYPCollection();
		while (input.hasNext()) {
			try {
				f.addFYP(
				input.nextLine(), //matricNo
				input.nextLine(), //icPass
				input.nextLine(), //mahallah
				input.nextLine(), //address
				input.nextLine(), //gender
				input.nextLine(), //contactNo
				input.nextLine(), //email
				input.nextLine(), //gpa
				input.nextLine(), //cgpa
				df.parse(input.nextLine()), //startDate
				df.parse(input.nextLine()), //endDate
				input.nextLine(), //title
				input.nextLine(), //spec
				input.nextLine(), //lectID
				input.nextLine() //approval
				);
				input.nextLine(); // divider
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		input.close();
		
		return f;
	}
	
}

/**
 * 'Atif Mustaffa
 * 1429619
 * 14 Nov 2016
 * SE_Project
 *
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadUserFromFile {
	
	public static UserCollection main(String[] args) throws FileNotFoundException {
		
		File file = new File("files/userDatabase.dat");
		
		Scanner input = new Scanner(file);
		
		UserCollection u = new UserCollection();
		while (input.hasNext()) {
			u.addUser(input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine());
			input.nextLine(); //divider
		}
		
		input.close();
		
		return u;
	}
	
}

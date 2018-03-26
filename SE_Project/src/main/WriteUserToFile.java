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
import java.io.PrintWriter;

public class WriteUserToFile {
	
	public static void main(String[] args, UserCollection y) throws FileNotFoundException {
		
		File file = new File("files/userDatabase.dat");

		String divider = "------------------------------------";

		PrintWriter output = new PrintWriter(file);

		int x = 0;
		String text = "";
		y.sortUser();
		while (x < y.getLength()) {
			text += y.getUser(x).getMatricNo() + "\n" // matricNo
					+ y.getUser(x).getName() + "\n" // name
					+ y.getUser(x).getPass() + "\n" // password
					+ y.getUser(x).getUserType() + "\n" // usertype
					+ y.getUser(x).getSpec() + "\n" // specialization
					+ divider + "\n";
			x++;
		}
		
		output.print(text);
		output.close();
	}
	
}

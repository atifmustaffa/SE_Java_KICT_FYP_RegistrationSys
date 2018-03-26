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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class WriteFYPToFile {
	
	public static void main(String[] args, FYPCollection y) throws FileNotFoundException {
		
		File file = new File("files/fypDatabase.dat");

		String divider = "------------------------------------------------------------";
		
		PrintWriter output = new PrintWriter(file);
		
		int x = 0;
		String text = "";
		while (x < y.getLength()) {
			text += y.getFYP(x).getMatricNo() + "\n"
					+ y.getFYP(x).getIcPass() + "\n"
					+ y.getFYP(x).getMahallah() + "\n"
					+ y.getFYP(x).getAddress() + "\n"
					+ y.getFYP(x).getGender() + "\n"
					+ y.getFYP(x).getContactNo() + "\n"
					+ y.getFYP(x).getEmail() + "\n"
					+ new DecimalFormat("#0.00").format(Double.parseDouble(y.getFYP(x).getGpa())) + "\n"
					+ new DecimalFormat("#0.00").format(Double.parseDouble(y.getFYP(x).getCgpa())) + "\n"
					+ new SimpleDateFormat("dd/MM/yyyy").format(y.getFYP(x).getStartDate()) + "\n"
					+ new SimpleDateFormat("dd/MM/yyyy").format(y.getFYP(x).getEndDate()) + "\n"
					+ y.getFYP(x).getTitle() + "\n"
					+ y.getFYP(x).getSpec() + "\n"
					+ y.getFYP(x).getLectID() + "\n"
					+ y.getFYP(x).getApproval() + "\n"
					+ divider + "\n";
			x++;
		}
		
		output.print(text);
		output.close();
	}
		
}

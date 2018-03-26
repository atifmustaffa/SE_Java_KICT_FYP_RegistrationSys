/**
 * 'Atif Mustaffa
 * 1429619
 * 18 Dec 2016
 * SE_Project
 *
 */
package testPack;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import main.*;

public class ReadDataFromFileTest {
	
	@Test
	public void testFileExist() {
		File fileUser = new File("files/userDatabase.dat");
		File fileFYP = new File("files/fypDatabase.dat");
		assertTrue("files not exists", fileUser.exists());
		assertTrue("files not exists", fileFYP.exists());
	}
	
	@Test
	public void testFileData() {
		int usercount = 0;
		int fypcount = 0;
		try {
			usercount = 20; // default initial users 20
			fypcount = 5; // default initial total fyp 5
			assertEquals("Data count is not same", usercount, ReadUserFromFile.main(null).getLength());
			assertEquals("Data count is not same", fypcount, ReadFYPFromFile.main(null).getLength());
		} catch (FileNotFoundException e) {
		}
	}
	
	@Test
	public void testParseDate() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		//String date = "22 Nov 2016";
		String date = "22/11/2016";
		try {
			System.out.println(df.parse(date));
		} catch(ParseException e) {
			System.out.println("Invalid date format");
		}
	}
}

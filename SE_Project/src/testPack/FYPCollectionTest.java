/**
 * 'Atif Mustaffa
 * 1429619
 * 8 Nov 2016
 * SE_Project
 */
package testPack;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;
import main.*;

public class FYPCollectionTest {

	@Test
	public void test() {
		double numb1 = Double.parseDouble("3.5");
		double numb2 = Double.parseDouble("4.0");
		System.out.println(numb1);
		System.out.println(numb2);
		
		FYP fyp1 = new FYP("1429619", "951122115281", "Zubair", "Kg Alor Keladi Jerteh", "Male", "0132646895",
				"aretif95@gmail.com", "3.82", "3.74", new Date(735219876), new Date(735139090), "Registration system", "CS", "1419", "");
		// print single fyp
		System.out.println("SINGLE FYP:\n" + fyp1.toString());
		
		FYPCollection fyps = new FYPCollection();
		
		// add existing created fyp into collection
		fyps.addExistingFYP(fyp1);
		
		// add new fyp
		fyps.addFYP("1426417", "951127075283", "Bilal", "Kg Bemban Melaka", "Male", "0132874493",
				"azfarhamzah@gmail.com", "3.92", "3.88", new Date(735219876), new Date(735139090), "Report system", "CS", "1488", "");
		
		// print collection
		System.out.println("\nCOLLECTION FYP:\n" + fyps.toString());
		
		User[] lect = new User[3];
		lect[0] = new User("1429", "Dr Ahmed", "qwe123", "staff", "IT");
		lect[1] = new User("1419", "Dr Ali", "qwe123", "staff", "CS");
		lect[2] = new User("1488", "Dr Maznah", "qwe123", "staff", "CS");
		
		// test print all fyps in collection with their respective supervisor
		System.out.println("COLLECTION FYP WITH SUPERVISOR NAME:");
		for(int i = 0; i < fyps.getLength(); i++)
			for(int j = 0; j < lect.length; j++)
				if(fyps.getFYP(i).getLectID().equals(lect[j].getMatricNo()))
					System.out.println(fyps.getFYP(i).toString() + "\nsupervised by: " + lect[j].getName());
		
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testDeleteFYP() {
		FYP fyp1 = new FYP("1429619", "951122115281", "Zubair", "Kg Alor Keladi Jerteh", "Male", "0132646895",
				"aretif95@gmail.com", "3.82", "3.74", new Date(735219876), new Date(735139090), "Registration system", "CS", "1419", "");
		FYPCollection fyps = new FYPCollection();
		fyps.addExistingFYP(fyp1);
		fyps.addFYP("1426417", "951127075283", "Bilal", "Kg Bemban Melaka", "Male", "0132874493",
				"azfarhamzah@gmail.com", "3.92", "3.88", new Date(735219876), new Date(735139090), "Report system", "CS", "1488", "");
		

		int totalAfterShudBe = fyps.getLength()-1;
		fyps.deleteFYP(1); // delete 2nd fyp
		int totalAfter = fyps.getLength();
		assertSame("Total is not the same", totalAfterShudBe, totalAfter);
		
		// check fyp should be deleted : excpected error
		System.out.println("should not see this :" +fyps.getFYP(1));
	}
	
	@Test
	public void testFYPArrayEmpty() {
		FYPCollection fyps = new FYPCollection();
		fyps.addFYP("1426417", "951127075283", "Bilal", "Kg Bemban Melaka", "Male", "0132874493",
				"azfarhamzah@gmail.com", "3.92", "3.88", new Date(735219876), new Date(735139090), "Report system", "CS", "1488", "");
		fyps.deleteFYP(0);
		
		assertSame("FYP array not empty", 0, fyps.getLength());
	}
	
	@Test
	public void testFindFYP() {
		FYPCollection fyps = new FYPCollection();
		fyps.addFYP("1426417", "951127075283", "Bilal", "Kg Bemban Melaka", "Male", "0132874493",
				"azfarhamzah@gmail.com", "3.92", "3.88", new Date(735219876), new Date(735139090), "Report system", "CS", "1488", "");
		
		// return -1 for not found
		assertSame("FYP exists", -1, fyps.getIndexByMNO("1400000"));
		// return index 0 for found
		assertSame("FYP not exists", 0, fyps.getIndexByMNO("1426417"));
		
	}
	
	@Test
	public void testSearchFYP() {
		int loggedUserIndex = 0;
		UserCollection uc = new UserCollection();
		uc.addUser("1426417", "Azfar", "qwe123", "student", "");
		
		FYPCollection fyps = new FYPCollection();
		fyps.addFYP("1426417", "951127075283", "Bilal", "Kg Bemban Melaka", "Male", "0132874493",
				"azfarhamzah@gmail.com", "3.92", "3.88", new Date(735219876), new Date(735139090), "Report system", "CS", "1488", "");
		
		//test search found
		assertTrue(uc.getUser(loggedUserIndex).getUserType().equals("student") &&
				uc.getUser(loggedUserIndex).getMatricNo().equals(fyps.getFYP(0).getMatricNo()));
	}
	
}

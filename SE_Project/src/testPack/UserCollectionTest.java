/**
 * 'Atif Mustaffa
 * 1429619
 * 8 Nov 2016
 * SE_Project
 */
package testPack;

import static org.junit.Assert.*;
import org.junit.Test;
import main.*;

public class UserCollectionTest {

	@Test
	public void test() {
		
		// Just testing parameters
		/**Normal Instances**/
		Student student1 = new Student("1492619", "Ahmad", "qwe123");
		Supervisor supervisor1 = new Supervisor("1413", "Dr Ali", "qwe123", "Computer Science");
		Coordinator coordinator1 = new Coordinator("1683", "Dr Abd Wahab", "qwe123");
		Administrator administrator1 = new Administrator("1135", "Br Syazwan", "qwe123");
		System.out.println(student1);
		System.out.println(supervisor1);
		System.out.println(coordinator1);
		System.out.println(administrator1);
		System.out.println("");
		
		/**Instances by using Arrays**/
		User[] users = new User[4];
		users[0] = new User("1492619", "Ahmad", "qwe123", "student", "");
		users[1] = new User("1419", "Dr Ali", "qwe123", "staff", "Computer Science");
		users[2] = new User("1686", "Dr Abd Wahab", "qwe123", "staff", "");
		users[3] = new User("1131", "Br Syazwan", "qwe123", "admin", "");
		for(User user: users)
			System.out.println(user);
		System.out.println("");
		
		UserCollection uc = new UserCollection();
		uc.addUser("1492619", "Ahmad", "qwe123", "student", "");
		uc.addUser("1419", "Dr Ali", "qwe123", "staff", "Computer Science");
		uc.addUser("1686", "Dr Abd Wahab", "qwe123", "staff", "");
		uc.addUser("1139", "Br Syazwan", "qwe123", "admin", "");
		
		uc.sortUser();
		for(User user: uc.getAllUsers())
			System.out.println(user);
	}
	
	@Test
	public void testDataCountAfterInsertNew() {
		UserCollection uc = new UserCollection();
		uc.addUser("1492619", "Ahmad", "qwe123", "student", "");
		int totalBefore = uc.getLength();
		uc.addUser("1494569", "Bashir", "qwe123", "student", "");
		int totalAfterShudBe = totalBefore+1;
		
		assertNotSame("data before and after is same", totalAfterShudBe, totalBefore);
		
	}
	
	@Test
	public void testUserSort() {
		UserCollection uc = new UserCollection();
		uc.addUser("", "", "", "", "");
		uc.addUser("1490008", "Bashir", "qwe123", "student", "");
		uc.addUser("1490001", "Bashir", "qwe123", "student", "");
		uc.sortUser(); // sort user starts from index 1
		assertEquals("1490001", uc.getUser(1).getMatricNo());
		assertEquals("1490008", uc.getUser(2).getMatricNo());
	}

}

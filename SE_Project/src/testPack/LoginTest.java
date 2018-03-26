/**
 * 'Atif Mustaffa
 * 1429619
 * 18 Dec 2016
 * SE_Project
 *
 */
package testPack;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import gui.MenuWindow;
import main.ReadUserFromFile;
import main.User;
import main.UserCollection;

public class LoginTest {

	@Test
	public void testLogin() {
		UserCollection uc = new UserCollection();
		uc.addUser("1492619", "Ahmad", "qwe123", "student", "");
		uc.addUser("1419", "Dr Ali", "qwe123", "staff", "Computer Science");
		uc.addUser("1686", "Dr Abd Wahab", "qwe123", "staff", "");
		
		// ahmad id and pass
		String testId = "1492619", password = "qwe123";
		assertSame("Id not exist", testId, uc.getUser(uc.getIndex(testId)).getMatricNo());
		assertSame("password is not same", password, uc.getUser(uc.getIndex(testId)).getPass());
		
	}
	
	@Test
	public void testOnlyNumbers() {
		UserCollection uc = new UserCollection();
		uc.addUser("1492619", "Ahmad", "qwe123", "student", "");
		//uc.addUser("149we19", "Ahmad", "qwe123", "student", ""); // caontains other than numbes
		
		String matricNo = uc.getUser(0).getMatricNo();
		
		for(int i = 0; i < matricNo.length(); i++)
			if(matricNo.charAt(i) < '0' || matricNo.charAt(i) > '9') {
				fail("MatricNo contains other than numbers");
			}
	}
	
	@Test
	public void testCapitalizeWord() {
		String str1 = "muhamMAd 'aTif bin musTAFFa"; // test with single quote symbol
		String str2 = "tesTinG yaBedaBeDoooo";
		String output1 = "Muhammad 'Atif Bin Mustaffa";
		String output2 = "Testing Yabedabedoooo";
		assertEquals("not capitalizing", output1, CapitalizeEachWord(str1));
		assertEquals("not capitalizing", output2, CapitalizeEachWord(str2));
	}
	
	private String CapitalizeEachWord(String str) {
	    String[] arr = str.toLowerCase().split(" ");
	    StringBuffer sb = new StringBuffer();

	    for (int i = 0; i < arr.length; i++) {
	    	if(Character.isLetter(arr[i].charAt(0)))
	    		sb.append(Character.toUpperCase(arr[i].charAt(0))).append(arr[i].substring(1)).append(" ");
	    	else
	    		sb.append(arr[i].charAt(0)).append(Character.toUpperCase(arr[i].charAt(1))).append(arr[i].substring(2)).append(" ");
	    }          
	    return sb.toString().trim();
	} 
	
}

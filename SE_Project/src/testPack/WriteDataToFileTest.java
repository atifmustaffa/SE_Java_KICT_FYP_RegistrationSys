/**
 * 'Atif Mustaffa
 * 1429619
 * 18 Dec 2016
 * SE_Project
 *
 */
package testPack;

import static org.junit.Assert.*;

import java.io.*;
import org.junit.Test;
import org.junit.rules.*;
import org.junit.Rule;

public class WriteDataToFileTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void testCreateNewFile() throws IOException {
		File createdFile = folder.newFile("dataTest.txt");
		assertTrue("not exists", createdFile.exists());
		
		// test project data
		File file = new File("files/userDatabase.dat");
		//File file = new File("files/fypDatabase.dat");
		System.out.println(file.getAbsolutePath());
		if(!file.exists())
			throw new FileNotFoundException("File not found");
	}
	
	

}

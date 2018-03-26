package exampleLogin;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CheckLoginTest {
	
	private boolean valid;
	private String id;
	private String pass;
	private String CorrectId;
	private String CorrectPass;
	
	public CheckLoginTest(boolean valid, String id, String pass, String CorrectId, String CorrectPass) {
		this.valid = valid;
		this.id = id;
		this.pass = pass;
		this.CorrectId = CorrectId;
		this.CorrectPass = CorrectPass;
	}
	
	@Parameters
	public static Collection<Object[]> getTestParameters() {
		return Arrays.asList(new Object[][] {
			{true, "atif", "atif", "atif", "pass1"},
			{false, "meran", "meran777", "meran1", "pass2"},
			{true, "qaseh", "qaseh", "qaseh", "pass3"},
		});
	}

	@Test
	public void test() {
		assertSame("testing", valid, id.equals(pass));
	}

}

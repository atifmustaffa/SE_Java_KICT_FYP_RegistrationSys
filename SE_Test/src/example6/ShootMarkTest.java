package example6;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)

public class ShootMarkTest {
	
	private int mark;
	private int score1;
	private int score2;
	
	public ShootMarkTest(int mark, int score1, int score2) {
		this.mark = mark;
		this.score1 = score1;
		this.score2 = score2;
		
	}
	
	@Parameters
	public static Collection<Object[]> getTestParameters() {
		return Arrays.asList(new Object[][] {
			{3, 1, 2},
			{3, 2, 1},
			{4, 3, 1}
		});
	}
	

	@Test
	public void sum() {
		assertSame("testing", mark, score1 + score2);
	}

}

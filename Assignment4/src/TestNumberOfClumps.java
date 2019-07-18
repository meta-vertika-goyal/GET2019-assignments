import static org.junit.Assert.*;

import org.junit.Test;
public class TestNumberOfClumps {

	@Test
	public void testNumberOfClumps1()
	{
		int input[]={1,2,2,3,4,4};
		int expected=2;
		assertEquals("Actual Output does not match the expected ouput",expected,ArrOperation.findNumberOfClumps(input));
	}
	@Test
	public void testNumberOfClumps2()
	{
		int input[]={1,1,2,1,1};
		int expected=2;
		assertEquals("Actual Output does not match the expected ouput",expected,ArrOperation.findNumberOfClumps(input));
	}
	@Test
	public void testNumberOfClumpsWereAllElementsEqual()
	{
		int input[]={1,1,1,1,1};
		int expected=1;
		assertEquals("Actual Output does not match the expected ouput",expected,ArrOperation.findNumberOfClumps(input));
	}
	@Test(expected = AssertionError.class) 
	public void testNumberOfClumpsForEmptyArray() { 
		int[] input={};
		ArrOperation.findNumberOfClumps(input);
	      
	}

}

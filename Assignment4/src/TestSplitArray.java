import static org.junit.Assert.*;

import org.junit.Test;

public class TestSplitArray {
	@Test
	public void testSplitArray1()
	{
		int input[]={1,1,1,2,1};
		int expected=3;
		assertEquals("Actual Output does not match the expected ouput",expected,ArrOperation.splitArray(input));
	}
	@Test
	public void testSplitArrayWhenCannotSplit()
	{
		int input[]={2,1,1,2,1};
		int expected=-1;
		assertEquals("Actual Output does not match the expected ouput",expected,ArrOperation.splitArray(input));
	}
	@Test
	public void testSplitArrayWithTwoElements()
	{
		int input[]={10,10};
		int expected=1;
		assertEquals("Actual Output does not match the expected ouput",expected,ArrOperation.splitArray(input));
	}
	@Test(expected=AssertionError.class)
	public void testSplitArrayForEmptyArray()
	{
		int input[]={};
		ArrOperation.splitArray(input);
	}
}

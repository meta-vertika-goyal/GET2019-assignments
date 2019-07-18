import static org.junit.Assert.*;

import org.junit.Test;
public class TestFixXY {
	@Test
	public void testFixXY1()
	{
		int input[]={5,4,9,4,9,5};
		int expected[]={9,4,5,4,5,9};
		assertArrayEquals("Actual Output does not match the expected ouput",expected,ArrOperation.fixXY(input,4,5));
	}
	@Test
	public void testFixXY2()
	{
		int input[]={1,4,1,5};
		int expected[]={1,4,5,1};
		assertArrayEquals("Actual Output does not match the expected ouput",expected,ArrOperation.fixXY(input,4,5));
	}
	@Test
	public void testFixXY3()
	{
		int input[]={1,4,1,5,5,4,1};
		int expected[]={1,4,5,1,1,4,5};
		assertArrayEquals("Actual Output does not match the expected ouput",expected,ArrOperation.fixXY(input,4,5));
	}
	@Test(expected=AssertionError.class)
	public void testFixXYForEmptyArray()
	{
		int input[]={};		
		int result[]=ArrOperation.fixXY(input,4,5);
	}
	@Test(expected=AssertionError.class)
	public void testFixXYForAdjacentX()
	{
		int input[]={1,4,1,5,5,4,4};		
		int result[]=ArrOperation.fixXY(input,4,5);	
	}
	@Test(expected=AssertionError.class)
	public void testFixForXAtLastIndex()
	{
		int input[]={1,4,1,5,5,1,4};
		int result[]=ArrOperation.fixXY(input,4,5);
	}
	@Test(expected=AssertionError.class)
	public void testFixXYForUnequalXY()
	{
		int input[]={1,4,5,5,5,1,4};
		int result[]=ArrOperation.fixXY(input,4,5);	
	}
}

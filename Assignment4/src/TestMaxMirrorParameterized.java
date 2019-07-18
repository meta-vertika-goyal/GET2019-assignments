import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestMaxMirrorParameterized {
	private int inputArray[];
	private int expectedResult;
	public TestMaxMirrorParameterized(int inputArray[],int expectedResult)
	{
		this.inputArray=inputArray;
		this.expectedResult=expectedResult;
	}
	@Parameters
	public static Collection<Object[]> data()
	{
		return Arrays.asList(new Object[][]{
				{new int[]{1,2,3,8,9,3,2,1},3},
				{new int[]{7,1,4,9,7,4,1},2},
				{new int[]{1,2,1,4},3},
				{new int[]{1,4,5,3,5,4,1},7},});
	}
	@Test
	public void testMaxMirror()
	{
		int actualResult=ArrOperation.findLargestMirrorSection(inputArray);
		assertEquals("Actual and Expected Results do not match",expectedResult,actualResult);
	}
	@AfterClass
	public static void testMaxMirrorForEmptyArray() { 
		int[] input={};
		try
		{
			ArrOperation.findLargestMirrorSection(input);
		}
		catch(AssertionError e)
		{
			System.out.println(e.getMessage());
		}
	}
}

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestSplitArrayParameterized {
	private int inputArray[];
	private int expectedResult;
	public TestSplitArrayParameterized(int inputArray[],int expectedResult)
	{
		this.inputArray=inputArray;
		this.expectedResult=expectedResult;
	}
	@Parameters
	public static Collection<Object[]> data()
	{
		return Arrays.asList(new Object[][]{
				{new int[]{1,1,1,2,1},3},
				{new int[]{2,1,1,2,1},-1},
				{new int[]{10,10},1},
		});
	}
	@Test
	public void testSplitArray()
	{

		int actualResult=ArrOperation.splitArray(inputArray);
		assertEquals("Actual and Expected Results do not match",expectedResult,actualResult);
	}
	@AfterClass
	public static void testSplitArrayForEmptyArray() { 
		int[] input={};
		try
		{
			ArrOperation.splitArray(input);
		}
		catch(AssertionError e)
		{
			System.out.println(e.getMessage());
		}
	}
}

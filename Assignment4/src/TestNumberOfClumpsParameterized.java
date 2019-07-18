import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class TestNumberOfClumpsParameterized {
	private int inputArray[];
	private int expectedResult;
	public TestNumberOfClumpsParameterized(int inputArray[],int expectedResult)
	{
		this.inputArray=inputArray;
		this.expectedResult=expectedResult;
	}
	@Parameters
	public static Collection<Object[]> data()
	{
		return Arrays.asList(new Object[][]{
				{new int[]{1,2,2,3,4,4},2},
				{new int[]{1,1,2,1,1},2},
				{new int[]{1,1,1,1,1},1},
		});
	}
	@Test
	public void testNumberOfClumps()
	{
		int actualResult=ArrOperation.findNumberOfClumps(inputArray);
		assertEquals("Actual and Expected Results do not match",expectedResult,actualResult);
	}

	@AfterClass
	public static void testNumberOfClumpsForEmptyArray() { 
		int[] input={};
		try
		{
			ArrOperation.findNumberOfClumps(input);
		}
		catch(AssertionError e)
		{
			System.out.println(e.getMessage());
		}
	}
}

import static org.junit.Assert.*;

import org.junit.Test;
public class StringOperationTest {
	@Test
	public void testCountUniqueElements() 
	{
		String[] stringArray={"vertika","vertikagoyal","vvertika"};
		int[] countCharacters={7,11,7};
		for(int i=0;i<stringArray.length;i++)
		{
			assertEquals(countCharacters[i],StringOperation.countUniqueCharacters(stringArray[i]));
		}

	}
	@Test(expected=AssertionError.class)
	public void testCountUniqueElementsForEmptyString()
	{
		StringOperation.countUniqueCharacters("");
	}
}




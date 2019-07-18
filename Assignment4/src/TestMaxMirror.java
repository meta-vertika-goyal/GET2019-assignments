import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class TestMaxMirror
{
	@Test
	public void testMaxMirror1()
	{
		int input[]=new int[]{1,2,3,8,9,3,2,1};
		int expected=3;
		assertEquals("Actual Output does not match the expected ouput",expected,ArrOperation.findLargestMirrorSection(input));
	}
	@Test
	public void testMaxMirror2()
	{
		int input[]={7,1,4,9,7,4,1};
		int expected=2;
		assertEquals("Actual Output does not match the expected ouput",expected,ArrOperation.findLargestMirrorSection(input));
	}
	@Test
	public void testMaxMirrorForFullMirror1()
	{
		int input[]={1,2,1,4};
		int expected=3;
		assertEquals("Actual Output does not match the expected ouput",expected,ArrOperation.findLargestMirrorSection(input));
	}
	@Test
	public void testMaxMirrorForFullMirror2()
	{
		int input[]={1,4,5,3,5,4,1};
		int expected=7;
		assertEquals("Actual Output does not match the expected ouput",expected,ArrOperation.findLargestMirrorSection(input));
	}

	@Test(expected = AssertionError.class) 
	public void testMaxMirrorForEmptyArray() { 
		int[] input={};
		ArrOperation.findLargestMirrorSection(input);
	}
}

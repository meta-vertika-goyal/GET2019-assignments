import static org.junit.Assert.*;

import org.junit.Test;


import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class TestNQueens2DArray
{
@Test
public void testNQueens1()
{
	int dimensionOfMatrix=4;
	boolean actual=NQueens2DArray.placeQueens(dimensionOfMatrix);	
	boolean expected=true;	
	assertEquals("Actual output does not match expected output",expected,actual);
}
@Test
public void testNQueens2()
{
	int dimensionOfMatrix=8;
	boolean actual=NQueens2DArray.placeQueens(dimensionOfMatrix);	
	boolean expected=true;	
	assertEquals("Actual output does not match expected output",expected,actual);
}
@Test
public void testNQueensDimensionLessThan4()
{
	int dimensionOfMatrix=3;
	boolean actual=NQueens2DArray.placeQueens(dimensionOfMatrix);	
	boolean expected=false;	
	assertEquals("Actual output does not match expected output",expected,actual);
}
@Test
public void testNQueensDimensionNotMultipleOf4()
{
	int dimensionOfMatrix=6;
	boolean actual=NQueens2DArray.placeQueens(dimensionOfMatrix);	
	boolean expected=true;	
	assertEquals("Actual output does not match expected output",expected,actual);
}

}
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class TestFindLCM
{
@Test
public void testFindLCM1()
{
	int num1=1,num2=5;
	int actual=LCM_HCF.findLCM(num1,num2);
	int expected=5;
	assertEquals("Actual output does not match expected output",expected,actual);
}
@Test
public void testFindLCM2()
{
	int num1=12,num2=32;
	int actual=LCM_HCF.findLCM(num1,num2);
	int expected=96;
	assertEquals("Actual output does not match expected output",expected,actual);
}
@Test(expected=AssertionError.class)
public void testFindLCM3()
{
	int num1=0,num2=32;
	int actual=LCM_HCF.findLCM(num1,num2);
	
}
@Test(expected=AssertionError.class)
public void testFindLCM4()
{
	int num2=0,num1=32;
	int actual=LCM_HCF.findLCM(num1,num2);	
}
}
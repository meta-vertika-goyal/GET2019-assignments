import static org.junit.Assert.*;

import org.junit.Test;


import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class TestFindHCF
{
@Test
public void testFindHCF1()
{
	int num1=12,num2=64;
	int actual=LCM_HCF.findHCF(num1,num2);
	int expected=4;
	assertEquals("Actual output does not match expected output",expected,actual);
}
@Test
public void testFindHCF2()
{
	int num1=1,num2=5;
	int actual=LCM_HCF.findHCF(num1,num2);
	int expected=1;
	assertEquals("Actual output does not match expected output",expected,actual);
}
@Test
public void testFindHCF3()
{
	int num1=0,num2=5;
	int actual=LCM_HCF.findHCF(num1,num2);
	int expected=5;
	assertEquals("Actual output does not match expected output",expected,actual);
	
}
@Test
public void testFindHCF4()
{
	int num1=1,num2=0;
	int actual=LCM_HCF.findHCF(num1,num2);
	int expected=1;
	assertEquals("Actual output does not match expected output",expected,actual);
	
}
}
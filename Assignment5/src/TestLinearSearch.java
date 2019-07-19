import static org.junit.Assert.*;

import org.junit.Test;
public class TestLinearSearch {
	@Test
	public void testLinearSearch1() {
		int array[]={12,32,34,56,78,96};
		int length=array.length;
		int numSearch=56;
		int expected=3;
		int actual=Search.applyLinearSearch(array,numSearch);
		assertEquals("Expected Results do not match Actual Results",expected,actual);
	}
	@Test
	public void testLinearSearch2() {
		int array[]={12,32,34,56,78,96};
		int length=array.length;
		int numSearch=32;
		int expected=1;
		int actual=Search.applyLinearSearch(array,numSearch);
		assertEquals("Expected Results do not match Actual Results",expected,actual);
	}
	@Test
	public void testLinearSearch3() {
		int array[]={12,32,34,56,78,96};
		int length=array.length;
		int numSearch=8;
		int expected=-1;
		int actual=Search.applyLinearSearch(array,numSearch);
		assertEquals("Expected Results do not match Actual Results",expected,actual);
	}
	@Test(expected=AssertionError.class)
	public void testLinearSearch4() {
		int array[]={};
		int length=array.length;
		int numSearch=8;
		int actual=Search.applyLinearSearch(array,numSearch);
	}
}

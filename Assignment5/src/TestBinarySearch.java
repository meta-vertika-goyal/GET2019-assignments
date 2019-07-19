
import static org.junit.Assert.*;
import org.junit.Test;
public class TestBinarySearch {
	@Test
	public void testBinarySearch1() {
		int array[]={12,32,34,56,78,96};
		int length=array.length;
		int numSearch=56;
		int expected=3;
		int actual=Search.applyBinarySearch(array,numSearch);
		assertEquals("Expected Results do not match Actual Results",expected,actual);
	}
	@Test
	public void testBinarySearch2() {

		int array[]={12,32,34,56,78,96};
		int length=array.length;
		int numSearch=32;
		int expected=1;
		int actual=Search.applyBinarySearch(array,numSearch);
		assertEquals("Expected Results do not match Actual Results",expected,actual);
	}
	@Test
	public void testBinarySearch() {

		int array[]={12,32,34,56,78,96};
		int length=array.length;
		int numSearch=8;
		int expected=-1;
		int actual=Search.applyBinarySearch(array,numSearch);
		assertEquals("Expected Results do not match Actual Results",expected,actual);
	}
	@Test(expected=AssertionError.class)
	public void testBinarySearch4() {

		int array[]={};
		int length=array.length;
		int numSearch=8;
		int actual=Search.applyBinarySearch(array,numSearch);
	}
}

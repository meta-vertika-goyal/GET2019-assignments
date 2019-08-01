import static org.junit.Assert.*;

import org.junit.Test;
public class TestInsert {
	@Test
	public void testInsert() {
		int queueArray[]=new int[10];
		QueueByArray queue=new QueueByArray(queueArray,10);
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		int expectedQueue[]={1,2,3,0,0,0,0,0,0,0};
		assertArrayEquals(expectedQueue,queue.getQueue());
	}
	@Test(expected=AssertionError.class)
	public void testInsertForOverflow() {
		int queueArray[]=new int[10];
		QueueByArray queue=new QueueByArray(queueArray,10);
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
		queue.insert(5);
		queue.insert(6);
		queue.insert(7);
		queue.insert(8);
		queue.insert(9);
		queue.insert(10);
		queue.insert(11);
	}
	@Test
	public void testInsertForCircularInsertion() {
		int queueArray[]=new int[10];
		QueueByArray queue=new QueueByArray(queueArray,10);
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
		queue.insert(5);
		queue.insert(6);
		queue.insert(7);
		queue.insert(8);
		queue.insert(9);
		queue.insert(10);
		queue.delete();
		queue.insert(11);
		int[] expectedQueue={11,2,3,4,5,6,7,8,9,10};
		assertArrayEquals(expectedQueue,queue.getQueue());
	}
}

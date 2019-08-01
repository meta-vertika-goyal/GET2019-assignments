import static org.junit.Assert.*;

import org.junit.Test;


public class TestDelete {
	@Test
	public void testDelete() {
		int queueArray[]=new int[10];
		QueueByArray queue=new QueueByArray(queueArray,10);
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
		queue.insert(5);
		int removedElement=queue.delete();
		assertEquals(1,removedElement);
	}
	@Test(expected=AssertionError.class)
	public void testDeleteForUnderflow() {
		int queueArray[]=new int[10];
		QueueByArray queue=new QueueByArray(queueArray,10);
		queue.insert(1);
		queue.insert(2);
		queue.delete();
		queue.delete();
		queue.delete();
	}

}

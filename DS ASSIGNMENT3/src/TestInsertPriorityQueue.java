import static org.junit.Assert.*;

import org.junit.Test;
public class TestInsertPriorityQueue {
	@Test
	public void testInsertPriorityQueue() {
		Item item1=new Item(2,3);
		Item item2=new Item(5,1);
		Item item3=new Item(6,2);
		PriorityQueue priorityQueue=new PriorityQueue(5);
		assertTrue(priorityQueue.insert(item1));
		assertTrue(priorityQueue.insert(item2));
		assertTrue(priorityQueue.insert(item3));
	}
	@Test
	public void testInsertPriorityQueueForOverflow() {
		Item item1=new Item(2,3);
		Item item2=new Item(5,1);
		Item item3=new Item(6,2);
		Item item4=new Item(9,4);
		Item item5=new Item(11,5);
		Item item6=new Item(6,2);
		PriorityQueue priorityQueue=new PriorityQueue(5);
		priorityQueue.insert(item1);
		priorityQueue.insert(item2);
		priorityQueue.insert(item3);
		priorityQueue.insert(item4);
		priorityQueue.insert(item5);
		assertFalse(priorityQueue.insert(item6));
	}
	@Test
	public void testDeletePriorityQueue() {
		Item item1=new Item(2,3);
		Item item2=new Item(5,1);
		Item item3=new Item(6,2);
		Item item4=new Item(9,4);
		Item item5=new Item(11,5);
		PriorityQueue priorityQueue=new PriorityQueue(5);
		priorityQueue.insert(item1);
		priorityQueue.insert(item2);
		priorityQueue.insert(item3);
		priorityQueue.insert(item4);
		priorityQueue.insert(item5);
		assertEquals(5,priorityQueue.delete().priority);
		assertEquals(4,priorityQueue.delete().priority);
	}
}

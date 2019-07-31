import static org.junit.Assert.*;

import org.junit.Test;
public class TestDetectLoop {
	@Test
	public void testDetectLoopForTrueAssertion() {
		LinkedList list = new LinkedList(); 
		list = LinkedList.insert(list, 1); 
		list = LinkedList.insert(list, 2); 
		list = LinkedList.insert(list, 3); 
		list = LinkedList.insert(list, 4); 
		list = LinkedList.insert(list, 5); 
		list = LinkedList.insert(list, 6); 
		list = LinkedList.insert(list, 7); 
		list = LinkedList.insert(list, 8);
		LinkedList.Node currentNode=list.head;
		while(currentNode.next.next!=null)
		{
			currentNode=currentNode.next;
		}
		currentNode.next=list.head;
		assertTrue(LinkedList.detectLoop(list));

	}
	@Test
	public void testDetectLoopForFalseAssertion() {
		LinkedList list = new LinkedList(); 
		list = LinkedList.insert(list, 1); 
		list = LinkedList.insert(list, 2); 
		list = LinkedList.insert(list, 3); 
		list = LinkedList.insert(list, 4); 
		list = LinkedList.insert(list, 5); 
		list = LinkedList.insert(list, 6); 
		list = LinkedList.insert(list, 7); 
		list = LinkedList.insert(list, 8);
		assertFalse(LinkedList.detectLoop(list));
	}
	@Test(expected=AssertionError.class)
	public void testDetectLoopForEmptyList() {
		LinkedList list = new LinkedList(); 
		assertFalse(LinkedList.detectLoop(list));
	}


}

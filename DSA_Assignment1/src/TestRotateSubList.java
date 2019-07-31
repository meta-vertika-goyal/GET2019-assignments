import static org.junit.Assert.*;

import org.junit.Test;
public class TestRotateSubList {
	@Test
	public void testRotateSublist() {
		LinkedList list = new LinkedList(); 
		list = LinkedList.insert(list, 1); 
		list = LinkedList.insert(list, 2); 
		list = LinkedList.insert(list, 3); 
		list = LinkedList.insert(list, 4); 
		list = LinkedList.insert(list, 5); 
		list = LinkedList.insert(list, 6); 
		list = LinkedList.insert(list, 7); 
		list = LinkedList.insert(list, 8);
		LinkedList listAfterRotation = new LinkedList(); 
		listAfterRotation = LinkedList.insert(listAfterRotation, 1); 
		listAfterRotation = LinkedList.insert(listAfterRotation, 3); 
		listAfterRotation = LinkedList.insert(listAfterRotation, 4); 
		listAfterRotation = LinkedList.insert(listAfterRotation, 5);
		listAfterRotation = LinkedList.insert(listAfterRotation, 2); 
		listAfterRotation = LinkedList.insert(listAfterRotation, 6); 
		listAfterRotation = LinkedList.insert(listAfterRotation, 7); 
		listAfterRotation = LinkedList.insert(listAfterRotation, 8);
		int left=2,right=5,N=3;
		LinkedList actualList=LinkedList.rotateSubList(list, left, right, N);
		LinkedList.Node expectedListNode=listAfterRotation.head;
		LinkedList.Node actualListNode=actualList.head;
		while(expectedListNode!=null)
		{
			assertEquals(expectedListNode.data,actualListNode.data);
			expectedListNode=expectedListNode.next;
			actualListNode=actualListNode.next;
		}
	}
	@Test(expected=AssertionError.class)
	public void testRotateSublistForEmptyList()
	{
		LinkedList list = new LinkedList(); 
		int left=2,right=5,N=3;
		LinkedList actualList=LinkedList.rotateSubList(list, left, right, N);
	}
	@Test(expected=AssertionError.class)
	public void testRotateSublistForLeftGreaterThanRight()
	{
		LinkedList list = new LinkedList(); 
		int left=6,right=5,N=3;
		LinkedList actualList=LinkedList.rotateSubList(list, left, right, N);
	}
}

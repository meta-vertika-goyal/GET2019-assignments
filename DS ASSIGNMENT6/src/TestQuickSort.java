import static org.junit.Assert.*;

import org.junit.Test;


public class TestQuickSort {
	@Test
	public void testQuickSort() {
		LinkedList linkedlist=new LinkedList();
		linkedlist.add(2);
		linkedlist.add(6);
		linkedlist.add(3);
		linkedlist.add(10);
		linkedlist.add(4);
		linkedlist.add(16);
		linkedlist.add(11);
		linkedlist.quickSort(linkedlist.head,linkedlist.rear);
		LinkedList expectedLinkedlist=new LinkedList();
		expectedLinkedlist.add(2);
		expectedLinkedlist.add(3);
		expectedLinkedlist.add(4);
		expectedLinkedlist.add(6);
		expectedLinkedlist.add(10);
		expectedLinkedlist.add(11);
		expectedLinkedlist.add(16);
		Node currentNodeExpected=expectedLinkedlist.head;
		Node currentNodeActual=linkedlist.head;
		while(currentNodeExpected!=null)
		{
			System.out.println(currentNodeExpected.data+"  "+currentNodeActual.data);
			assertEquals(currentNodeExpected.data,currentNodeActual.data);
			currentNodeExpected=currentNodeExpected.next;
			currentNodeActual=currentNodeActual.next;
		}
	}
	@Test(expected=AssertionError.class)
	public void testQuickSortForEmptyList() {
		LinkedList linkedlist=new LinkedList();
		linkedlist.quickSort(linkedlist.head,linkedlist.rear);
	}

}

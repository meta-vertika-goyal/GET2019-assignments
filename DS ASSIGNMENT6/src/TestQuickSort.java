import static org.junit.Assert.*;

import org.junit.Test;


public class TestQuickSort {
	@Test
	public void testQuickSort() {
		LinkedList linkedlist=new LinkedList();
		Employee employee1=new Employee("Vertika",22,15000);
		Employee employee2=new Employee("Riya",22,32000);
		Employee employee3=new Employee("Sachet",22,25000);
		Employee employee4=new Employee("Vanshaj",21,25000);
		linkedlist.add(employee1);
		linkedlist.add(employee2);
		linkedlist.add(employee3);
		linkedlist.add(employee4);
		linkedlist.quickSort(linkedlist.head,linkedlist.rear);
		LinkedList expectedLinkedlist=new LinkedList();
		expectedLinkedlist.add(employee2);
		expectedLinkedlist.add(employee4);
		expectedLinkedlist.add(employee3);
		expectedLinkedlist.add(employee1);
		
		Node currentNodeExpected=expectedLinkedlist.head;
		Node currentNodeActual=linkedlist.head;
		while(currentNodeExpected!=null)
		{
			assertEquals(currentNodeExpected.data.empName,currentNodeActual.data.empName);
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

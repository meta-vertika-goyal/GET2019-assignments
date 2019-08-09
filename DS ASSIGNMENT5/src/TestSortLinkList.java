import static org.junit.Assert.*;

import org.junit.Test;


public class TestSortLinkList {

	@Test
	public void testSortLinkList() {
		Employee employee1=new Employee("Vertika",22,15000);
		Employee employee2=new Employee("Riya",22,32000);
		Employee employee3=new Employee("Sachet",22,25000);
		Employee employee4=new Employee("Vanshaj",21,25000);
		SortLinkList linkedList=new SortLinkList();
		linkedList.insert(employee1);
		linkedList.insert(employee2);
		linkedList.insert(employee3);
		linkedList.insert(employee4);
		linkedList.insertionSort(linkedList.head);
		SortLinkList expectedLinkedList=new SortLinkList();
		expectedLinkedList.insert(employee2);
		expectedLinkedList.insert(employee4);
		expectedLinkedList.insert(employee3);
		expectedLinkedList.insert(employee1);
		Node currentNodeActual=linkedList.head;
		Node currentNodeExpected=expectedLinkedList.head;
		while(currentNodeActual!=null)
		{
			assertEquals(currentNodeActual.data.empName,currentNodeExpected.data.empName);
			currentNodeActual=currentNodeActual.next;
			currentNodeExpected=currentNodeExpected.next;
		}
		
	}
}


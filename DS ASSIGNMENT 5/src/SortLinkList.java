/**
 * This is the class to implement insertion sort on linked list
 * @author Vertika
 *
 */
public class SortLinkList {
	Node head;
	Node lastNode;
	Node sorted;
	/**
	 * This is the method that traverse the linked list and calls the sort method for every node
	 * @param temp is the head of the linked list
	 */
	public void insertionSort(Node temp) {
		sorted = null;
		Node current = temp;
		while (current != null) {
			Node next = current.next;
			sort(current);
			current = next;
		}
		head = sorted;
	}
	
	private void sort(Node temp) {
		if (sorted == null || compare(sorted.data, temp.data)) {
			temp.next = sorted;
			sorted = temp;
		}
		else {
			Node current = sorted;
			while (current.next != null && (current.next.data.salary >  temp.data.salary)) {
				current = current.next;
			}
			temp.next = current.next;
			current.next = temp;
		}
	}
	/**
	 * It is method used to insert an element at the starting of linked list.
	 * @param data element to be inserted.
	 */
	public void insert(Employee data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			lastNode = head;
			return;
		}
		lastNode.next = newNode;
		lastNode = newNode;
	}
	
	/**
	 * It is a method to return head.
	 * @return head of linked list.
	 */
	public Node getHead() {
		return head;
	}
	
	/**
	 * It is a method used to show elements of a linked list.
	 * @param temp is the head of the linked list
	 */
	public void show(Node temp) {
		if (temp != null){
			System.out.println(temp.data.empName + "\t\t" + temp.data.age + "\t\t" + temp.data.salary);
			temp = temp.next;
			show(temp);
		}
	}
	
	/**
	 * It is a method to compare 2 employees salary and age,
	 * @param e1 Employee object
	 * @param e2 Employee Object
	 * @return boolean value
	 */
	private boolean compare (Employee e1, Employee e2) {
		boolean result =  (e1.salary < e2.salary ||
				(e1.salary == e2.salary && e1.age > e2.age));
		System.out.println(result);
		return result;
	}
}
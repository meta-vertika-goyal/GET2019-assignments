/**
 * Linked list implementation
 * @author Vertika
 *
 */
public class LinkedList { 
	Node head; // head of list 

	/**
	 * Linked list Node. 
	 * @author Vertika
	 *
	 */
	static class Node { 

		int data; 
		Node next; 

		// Constructor 
		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 

	/**
	 * Method to insert a new node in the list
	 * @param list is the input linked list in which the node is to be inserted
	 * @param data is the value to be inserted in the linked list
	 * @return void
	 */
	public static LinkedList insert(LinkedList list, int data) 
	{ 
		// Create a new node with given data 
		Node new_node = new Node(data); 
		new_node.next = null; 

		// If the Linked List is empty, 
		// then make the new node as head 
		if (list.head == null) { 
			list.head = new_node; 
		} 
		else { 
			// Else traverse till the last node 
			// and insert the new_node there 
			Node last = list.head; 
			while (last.next != null) { 
				last = last.next; 
			} 

			// Insert the new_node at last node 
			last.next = new_node; 
		} 

		// Return the list by head 
		return list; 
	} 
	/**
	 * This method is used to rotate the sublist between the given left and right indices by N rotations
	 * @param list is the input linked list on which the operation is to be performed
	 * @param left is the left position of the sublist
	 * @param right is the right position of the sublist
	 * @param N is the number of times by which the list is to be rotated
	 */
	public static LinkedList rotateSubList(LinkedList list,int left,int right,int N)
	{
		if(left<0||right<0)
			throw new AssertionError("Negative values of left ot right position");
		if(list.head==null)
			throw new AssertionError("Empty input list");
		int length=countNumberOfNodes(list);
		if(left>length||right>length)
			throw new AssertionError("Valued of left or right index greater than the length of list");
		if(left>right)
			throw new AssertionError("Invalid input:left index>right index");
		if(N>(right-left+1))
			throw new AssertionError("The value of N should be smallet than or equal to length of subList");
		Node currentNode=list.head;
		Node previous=null;;
		int i=1;
		Node subListStart=null;
		Node subListEnd=null;
		Node subListStartPrevious=null;
		while(currentNode.next!=null)
		{
			if(i==left)
			{
				subListStartPrevious=previous;
				subListStart=currentNode;
			}

			if(i==right)
			{
				subListEnd=currentNode;
				System.out.println(subListEnd.data);
			}
			previous=currentNode;
			currentNode=currentNode.next;
			i++;
		}
		Node NthNode=subListStart;
		int k=(right-left-N);
		while(NthNode!=subListEnd&&k>0)
		{
			NthNode=NthNode.next;
			k++;
		}
		subListStartPrevious.next=NthNode.next;
		NthNode.next=subListEnd.next;
		subListEnd.next=subListStart;
		printList(list);
		return list;
	}
	public static int countNumberOfNodes(LinkedList list)
	{
		int count=0;
		Node currentNode=list.head;
		while(currentNode!=null)
		{
			count++;
			currentNode=currentNode.next;
		}
		return count;
	}
	/**
	 * Method to print the LinkedList. 
	 * @param list is the input linked list
	 */
	public static void printList(LinkedList list) 
	{ 
		Node currNode = list.head; 
		System.out.print("LinkedList: "); 
		// Traverse through the LinkedList 
		while (currNode != null) { 
			// Print the data at current node 
			System.out.print(currNode.data + " "); 
			// Go to next node 
			currNode = currNode.next; 
		} 
	} 
	/**
	 * This method is used to check whether there exists a loop in the linked list or not
	 * @param list is the input list which is to be checked
	 * @return boolean true if there exists a loop else returns false
	 */
	public static boolean detectLoop(LinkedList list)
	{
		boolean flag=false;
		if(list.head==null)
		{
			System.out.println("Empty list");
			throw new AssertionError();
		}
		Node slowPointer=list.head;
		Node fastPointer=list.head;
		while(fastPointer.next.next!=null)
		{
			slowPointer=slowPointer.next;
			fastPointer=fastPointer.next.next;
			if(slowPointer==fastPointer)
			{
				flag=true;
				break;
			}
		}
		return flag;
	}

}
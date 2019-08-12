/**
 * This is a class to implement quick sort on linked list
 * @author Vertika
 *
 */
public class LinkedList {
	Node head;
	Node rear;
	/**
	 * default constructor for linked list
	 */
	LinkedList()
	{
		head=rear=null;
	}
	/**
	 * This is a method to add a new data into the linked list
	 * @param data is the value of the new node to be added
	 */
	public void add(int data)
	{
		Node newNode=new Node(data);
		if(head==null)
			head=rear=newNode;
		else
		{
			rear.next=newNode;
			rear=newNode;
		}
	}
	/**
	 * This method returns the correct position of the pivot element
	 * @param front is the first node of the list
	 * @param last is the last node of the list
	 * @return returns the pivot node that partitions the list
	 */
	public Node partition(Node front,Node last)
	{
		Node currentNode;
		int temp;
		if(this.head==front)
			currentNode=null;
		else 
		{
			currentNode=this.head;
			while(currentNode.next!=front)
			{
				currentNode=currentNode.next;
			}
		}
		Node i=currentNode;
		int pivot=last.data;
		Node j=front;
		while(j!=last)
		{
			if(j.data<pivot)
			{
				if(i==null)
					i=front;
				else
					i=i.next;
				temp =i.data;
				i.data=j.data;
				j.data=temp;
			}
			j=j.next;
		}
		if(i==null)
			i=front;
		else
			i=i.next;
		temp=i.data;
		i.data=last.data;
		last.data=temp;
		return i;
	}
	/**
	 * This method is used to print the linked list
	 * @param front is the first node of the list
	 * @param last is the last node of the list
	 */
	public void showLinkedList(Node front,Node last)
	{
		Node currentNode=front;
		while(currentNode!=last)
		{ 
			System.out.print(currentNode.data+"-->");
			currentNode=currentNode.next;
		}
		System.out.println(currentNode.data);
	}
	/**
	 * This is the recursive method to perform quick sort
	 * @param front is the first element of the list
	 * @param last is the last element of the list
	 */
	public void recursiveQuickSort(Node front,Node last)
	{
		if(last==front.next)
		{
			if(front.data>last.data)
			{
				int temp=front.data;
				front.data=last.data;
				last.data=temp;
			}
		}
		else if(front!=null && last!=front ){ 
			Node partition = partition(front,last); 
			Node currentNode=front;
			while(currentNode.next!=partition)
			{
				currentNode=currentNode.next;
			}
			recursiveQuickSort(front,currentNode); 
			recursiveQuickSort(partition.next,last); 
		} 
	}
	/**
	 * This method is used to call the recursive quicksort method
	 * @param front is the first element of the list
	 * @param last is the last element of the list
	 */
	public void quickSort(Node front,Node last)
	{
		if(front==null)
			throw new AssertionError("Empty linked list");
		else
			recursiveQuickSort(front, last);
	}
	public static void main(String[] args)
	{
		LinkedList linkedlist=new LinkedList();
		linkedlist.add(2);
		linkedlist.add(6);
		linkedlist.add(3);
		linkedlist.add(10);
		linkedlist.add(4);
		linkedlist.add(16);
		linkedlist.add(11);
		linkedlist.showLinkedList(linkedlist.head,linkedlist.rear);
		linkedlist.quickSort(linkedlist.head,linkedlist.rear);
		linkedlist.showLinkedList(linkedlist.head,linkedlist.rear);
	}
}

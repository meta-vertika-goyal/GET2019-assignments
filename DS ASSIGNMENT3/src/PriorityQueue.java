/**
 * class representing the priority queue
 * @author Vertika
 *
 */
public class PriorityQueue implements Queue {
	int rear;
	int front;
	int maxSize;
	Item priorityQueue[];
	/**
	 * parameterized constructor for priority queue
	 * @param maxSize is the maximum size of the priorit queue
	 */
	PriorityQueue(int maxSize)
	{
		this.maxSize=maxSize;
		priorityQueue=new Item[maxSize];
		front=-1;
		rear=-1;
	}
	/**
	 * This is a getter to get the queue array
	 * @return integer array of queue
	 */
	public Item[] getQueue()
	{
		return priorityQueue;
	}
	/**
	 * This method is used to insert an item in the priority queue
	 * @param item is the item to be inserted
	 * @return boolean returns true if item is successfully inserted else returns false
	 */
	@Override
	public boolean insert(Item item) {

		if (rear + 1 == maxSize)  
		{   
			return false;

		}  
		else  
		{  
			if(front == -1 && rear == -1)  
			{  
				front = 0;  
				rear = 0;  
			}  
			else  
			{  
				rear = rear + 1;   
			}  
			priorityQueue[rear]=item;  
			return true;
		}  

	}
	/**
	 * This method is used to delete an item from the priority queue
	 * @param item is the item to be deleted
	 * @return Item returns the item deleted
	 */
	@Override
	public Item delete() {
		int highestPriority=0; 
		int highesPriorityIndex=-1;
		Item deletedItem;
		if (front == -1 || front > rear)   

		{  
			throw new AssertionError("underflow"); 
		}  
		else   
		{  
			for(int i=front;i<=rear;i++)
			{
				Item item=priorityQueue[i];
				if(item.priority>highestPriority)
				{
					highesPriorityIndex=i;
					highestPriority=item.priority;
				}

			}
			deletedItem = priorityQueue[highesPriorityIndex];
			if(front == rear)  
			{  
				front = rear = -1;  
			}
			else if(highesPriorityIndex==front)
				front=front+1;

			else 
			{

				for(int j=highesPriorityIndex;j<maxSize-1;j++)
				{
					priorityQueue[j]=priorityQueue[j+1];
				}
				rear=rear-1;

			}  
			return deletedItem;  
		}  

	}

}

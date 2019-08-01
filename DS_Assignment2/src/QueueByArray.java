
public class QueueByArray implements Queue {
	int front=-1;
	int rear=-1;
	int maxSize;
	int queue[];
	/**
	 * This is a constructor to set the initial values of the queue
	 * @param queue is the queue array that stores the elements
	 * @param maxSize is the maximum size of the array
	 */
	QueueByArray(int queue[],int maxSize)
	{
		this.queue=queue;
		this.maxSize=maxSize;
	}
	/**
	 * This is a getter to get the queue array
	 * @return integer array of queue
	 */
	public int[] getQueue()
	{
		return queue;
	}
	/**
	 * This is a method to insert an element into the queue
	 */
	public void insert(int data) {
		if((rear+1)%maxSize == front)  
		{  
			throw new AssertionError("Overflow");
		}  
		else if(front == -1 && rear == -1)  
		{  
			front = 0;  
			rear = 0;  
		}  
		else if(rear == maxSize -1 && front != 0)   
		{  
			rear = 0;  
		}  
		else   
		{  
			rear = (rear+1)%maxSize;  
		}  
		queue[rear] = data;  
	}
	/**
	 * This is a method to delete an element from the queue
	 * @return returns the element that is deleted from the queue
	 */
	@Override
	public int delete() {
		int result;
		if(front == -1 & rear == -1)  
		{  
			throw new AssertionError("Underflow");
		}  
		else 
		{
			result=queue[front];
			if(front == rear)  
			{  
				front = -1;  
				rear = -1;  
			}  
			else if(front == maxSize -1)  
			{  
				front = 0;  
			}  
			else   
				front = front + 1;  
		}
		return result;
	}
}





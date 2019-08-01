
public interface QueueStudent 
{
  Student delete(); // removes an item from the front of the queue
  void insert(Student student); // adds an item to the rear end of the queue
  boolean isEmpty(); // returns true if queue is empty, false otherwise
  int size();  // returns the number of items in the queue right now
}
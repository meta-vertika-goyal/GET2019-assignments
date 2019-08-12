
public class Node {
	int data;
	Node next = null;

	/**
	 * It is default constructor of class.
	 */
	Node() {}

	/**
	 * It is a constructor used to initialize a node.
	 * @param data value of data field of node.
	 */
	Node(int data) {
		this.data = data;
		next = null;
	}
}

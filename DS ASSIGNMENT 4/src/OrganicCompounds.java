/**
 * class to implement the molecular mass calculation of an organic compound
 * @author Vertika
 *
 */
public class OrganicCompounds {
	static Node front;
	public static final int CARBON=12;
	public static final int OXYGEN=16;
	public static final int HYDROGEN=1;
	/**
	 * Node class representing the node of a linked list implementing a stack
	 * @author Vertika
	 *
	 */
	static class Node
	{
		String value;
		Node next;
		/**
		 * parameterized constructor to create a node
		 * @param value is the value assigned to the node
		 */
		Node(String value)
		{
			this.value=value;
			this.next=null;
		}
	}
	/**
	 * This method is used to push an element into the stack
	 * @param value is the value to be pushed into the stack
	 */
	public static void push(String value)
	{
		Node newNode=new Node(value);
		if(front==null)
			front=newNode;
		else
		{
			newNode.next=front;
			front=newNode;
		}
	}
	/**
	 * This method is used to pop an element from the stack
	 * @return String value of the element popped
	 */
	public static String pop()
	{
		String poppedElement="";
		if(front==null)
		{ System.out.println("The stack is empty");
		return null;
		}
		else
		{
			poppedElement=front.value;
			front=front.next;
		}
		return poppedElement;
	}
	/**
	 * This method returns the element at the top of the stack
	 * @return String value of the element at the top of the stack
	 */
	public static String peek()
	{
		return front.value;
	}
	/**
	 * This is a helper method returning the weight corresponding the input symbol of the element
	 * @param element is the symbol of the element whose atomic mass is to be returned
	 * @return integer value of the atomic mass of the input element
	 */
	public static int weightOfElement(String element)
	{
		if(element.equalsIgnoreCase("C"))
			return CARBON;
		else if(element.equalsIgnoreCase("H"))
			return HYDROGEN;
		else if(element.equalsIgnoreCase("O"))
			return OXYGEN;
		else return 0;
	}
	/**
	 * This method is used to check whether the stack is empty or not
	 * @return boolean value true if the stack is empty else returns false
	 */
	public static boolean isEmpty()
	{
		if(front==null)
			return true;
		else return false;
	}
	/**
	 * This method is used to calculate the molecular mass of an organic compound
	 * @param chemicalFormula is the String of the chemical formula of the organic compound
	 * @return integer value of the molecular mass of the element
	 */
	public static int calculateMolarMass(String chemicalFormula)
	{
		char elementScanned=' ';
		String number="",elementAtTop="",elementPopped="";
		int sum=0;
		chemicalFormula=chemicalFormula.toUpperCase();
		for(int i=0;i<chemicalFormula.length();i++)
		{   number="";
		elementScanned=chemicalFormula.charAt(i);
		if(elementScanned=='('||Character.isLetter(elementScanned))
			push(Character.toString(elementScanned));
		else if(Character.isDigit(elementScanned))
		{ 
			elementAtTop=peek();
			while(Character.isDigit(elementScanned))
			{

				number+=elementScanned;
				if((i+1)<chemicalFormula.length())
					elementScanned=chemicalFormula.charAt((++i));
				else
					break;
			}
			if(i!=chemicalFormula.length()-1)
				i--;
			System.out.println(number);
			if(Character.isLetter(elementAtTop.charAt(0)))
			{
				number=Integer.toString((Integer.parseInt(number))*weightOfElement(elementAtTop));
			}
			else if(Character.isDigit(elementAtTop.charAt(0)))
			{
				number=Integer.toString((Integer.parseInt(number))* (Integer.parseInt(elementAtTop)));   
			}
			pop();
			push(number);
		}
		else if(elementScanned==')')
		{ 
			elementAtTop=peek();
			sum=0;
			while(elementAtTop.charAt(0)!='(')
			{

				elementPopped=pop();

				if(Character.isLetter(elementAtTop.charAt(0)))
				{
					sum+=weightOfElement(elementPopped);
				}
				else if(Character.isDigit(elementPopped.charAt(0)))
				{
					sum+=Integer.parseInt(elementPopped);   
				}
				if(front==null)
					throw new AssertionError("Invalid chemical Formula");
				elementAtTop=peek();
			}
			pop();
			push(Integer.toString(sum));
		}
		}
		int molecularMass=0;
		while(!isEmpty())
		{
			elementPopped=pop();
			System.out.println(elementPopped);
			if(Character.isLetter(elementPopped.charAt(0)))
			{
				molecularMass+=weightOfElement(elementPopped);
			}
			else if(Character.isDigit(elementPopped.charAt(0)))
			{
				molecularMass+=Integer.parseInt(elementPopped);
			}
			else
				throw new AssertionError("Invalid chemical formula");
		}
		return molecularMass;
	}
	public static void main(String[] args)
	{
		System.out.println(OrganicCompounds.calculateMolarMass("COH)2"));
	}
}



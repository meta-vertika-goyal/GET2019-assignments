/**
 * This class is to implement a stack for the evaluation of expression
 * @author Vertika
 *
 */
public class EvaluateExpression implements Stack{
	int maxSize;                              //maximum size of available stack
	String postFixStack[];                    
	int top;                                  //pointer to the top of the stack   
	/**
	 * This is a constructor to initialise the stack
	 * @param postFixStack is the input array of stack
	 */
	EvaluateExpression(String postFixStack[])
	{
		maxSize=100;
		this.postFixStack=postFixStack;
		top=-1;
	}
	/**
	 * This method is used to convert the input infix expression to a postfix expression
	 * @param infixExpression is the input expression as a String
	 * @return returns the postfix form of the input expression as a String
	 */
	public String convertInfixToPostfix(String infixExpression)
	{
		String postfixExpression="",elementAtTop="";
		String expressionArray[]=infixExpression.split(" ");
		for(int i=0;i<expressionArray.length;i++)
		{
			String element=expressionArray[i];
			if(element.equals("("))
				this.push(element);
			else if(element.equals(")"))
			{
				while(!peek().equals("("))
				{
					postfixExpression+=(pop()+" ");
				}
				pop();
			}
			else if(Character.isLetterOrDigit(element.charAt(0)))
				postfixExpression+=(element+" ");
			else
			{
				elementAtTop=peek();
				if(getPrecedence(element)>getPrecedence(elementAtTop)||isEmpty()||elementAtTop.equals("("))
				{
					push(element);
				}
				else
				{
					while(getPrecedence(element)<=getPrecedence(elementAtTop)&&(!elementAtTop.equals("(")))
					{
						postfixExpression+=(pop()+" ");
						elementAtTop=peek();
					}
					push(element);
				}
			}
		}
		while(!this.isEmpty())
		{
			postfixExpression+=(pop()+" ");
		}
		return postfixExpression;
	}
	/**
	 * This method checks whether the stack is empty or not
	 * @return true if the stack is empty else returns false
	 */
	boolean isEmpty() 
	{ 
		return (top < 0); 
	} 
	/**
	 * This method is used to evaluate a postfix expression 
	 * @return String returns the evaluated result in the form of string
	 */
	public Result evaluatePostFixExpression()
	{
		
		boolean isBoolean=false;
		double result=0;
		for(int i=0;i<postFixStack.length;i++)
		{
			String elementScanned=postFixStack[i];
			if(Character.isLetterOrDigit(elementScanned.charAt(0)))
				this.push(elementScanned);
			else
			{
				double value1 = Double.parseDouble(this.pop()); 
				double value2 = Double.parseDouble(this.pop()); 
				switch(elementScanned)
				{
				case "*":
					result=value2*value1;
					break;
				case "/":
					result=value2/value1;
					break;
				case "%":
					result=value2%value1;
					break;
				case "+":
					result=value2+value1;
					break;
				case "-":
					result=value2-value1;
					break;
				case "<":
					if(value2<value1)
						result=1;
					else
						result=0;
					isBoolean=true;
					break;
				case "<=":
					if(value2<=value1)
						result=1;
					else
						result=0;
					isBoolean=true;
					break;
				case ">":
					if(value2>value1)
						result=1;
					else
						result=0;
					isBoolean=true;
					break;
				case ">=":
					if(value2>=value1)
						result=1;
					else
						result=0;
					isBoolean=true;
					break;
				case "==":
					if(value2==value1)
						result=1;
					else
						result=0;
					isBoolean=true;
					break;
				case "!=":
					if(value2!=value1)
						result=1;
					else
						result=0;
					isBoolean=true;
					break;
				case "&&":
					if(value1==0||value2==0)
						result=0;
					else result=1;
					isBoolean=true;
					
					break;
				case "||":
					if(value1==0&&value2==0)
						result=0;
					else result=1;
					isBoolean=true;
					break;
				}
				this.push(Double.toString(result));
			}
		}
		Result finalResult=new Result(Double.toString(result),isBoolean);
		return finalResult;
	}
	/**
	 * This method returns the precedence of the operator represented as an
	 * integer,highest number corresponding to the highest precedence
	 * @param operator is the input operator whose precedence is to be returned
	 * @return integer value of precedence
	 */
	private int getPrecedence(String operator)
	{
		int precedence=0;
		switch(operator)
		{
		case "*":
		case "/":
		case "%":
			precedence=6;
			break;
		case "+":
		case "-":
			precedence=5;
			break;
		case "<":
		case "<=":
		case ">":
		case ">=":
			precedence=4;
			break;
		case "==":
		case "!=":
			precedence=3;
			break;
		case "&&":
			precedence=2;
			break;
		case "||":
			precedence=1;
			break;
		}
		return precedence;
	}
	/**
	 * This method pushes the input string at the top of the stack
	 * @param character is the input string
	 * @return true if the string is pushed else assertion error
	 */
	@Override
	public boolean push(String character) {
		if (top >= (maxSize - 1)) 
			throw new AssertionError("Overflow");
		else { 
			postFixStack[++top] = character; 
			System.out.println(character + " pushed into stack"); 
			return true; 
		} 
	}
	/**
	 * This method is used to remove the element at the top of the stack
	 * @return String is the element popped out of the stack 
	 */
	@Override
	public String pop() {
		if (top < 0) 
			throw new AssertionError("Underflow");
		else 
			return postFixStack[top--]; 
	}
	/**
	 * This method is used to return the element at the top of the stack
	 * @return String is the element at the top of the stack
	 */
	@Override
	public String peek() {
		if (top < 0) 
			throw new AssertionError("Underflow");
		else 
			return postFixStack[top]; 
	} 
	/**
	 * This method calls the other functions and returns the final result after evaluating the expression
	 * @param infixExpression is the input infix expression to be evaluated
	 * @return double value of the result after evaluating the infix expression
	 */
	public  static String findResult(String infixExpression)
	{
		String[] postfixStack=new String[100];
		String result=new EvaluateExpression(postfixStack).convertInfixToPostfix(infixExpression);
		String[] postfixArray=result.split(" ");
		Result evaluation=new EvaluateExpression(postfixArray).evaluatePostFixExpression();
		String answer;
		if(evaluation.isBoolean)
		{
			if(evaluation.value.equals("1.0"))
				answer="true";
			else
				answer="false";
				
		}
		else
			answer=evaluation.value;
		return answer;
	}
}

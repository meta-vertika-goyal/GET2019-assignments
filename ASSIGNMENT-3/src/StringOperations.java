import java.util.*;
public class StringOperations {
	/*
	 * This method is used to compare two strings
	 * @param string1 is the first string
	 * @param string 2 is the second string which is to be compared
	 * @return integer 1 or 0 depending on whether the strings are equal or unequal respectively
	 */
	public static int compareTwoStrings(String string1,String string2)
	{
		char character1,character2;
		string1=string1.trim();
		string2=string2.trim();
		int length1=string1.length();
		int length2=string2.length();
		if(length1!=length2)
			return 0;
		else
		{
			for(int i=0;i<length1;i++)
			{
				character1=string1.charAt(i);
				character2=string2.charAt(i);
				if(character1!=character2)
					return 0;
			}
		}
		return 1;
			
	}
	/*
	 * This method computes the reverse of the string
	 * @param text is the input string
	 * @return String is returned which is the reverse of the input string
	 */
	public static String reverseString(String text)
	{
		String reverse="";
		for(int i=text.length()-1;i>=0;i--)
		{
			char character=text.charAt(i);
			reverse+=character;
		}
		return reverse;
	}
	
	/*
	 * This method computes the reverseCase string of the input string
	 * @param text is the input string
	 * @return String with its characters in the opposite case
	 */
	
	public static String reverseCase(String text)
	{
		String reverseCaseText="";
		for(int i=0;i<text.length();i++)
		{
			char character=text.charAt(i);
			if(Character.isUpperCase(character))
				character=Character.toLowerCase(character);
			else
				character=Character.toUpperCase(character);
			reverseCaseText+=character;
		}
		return reverseCaseText;
	}
	/*
	 * This method computes the largest word of the input string
	 * @param text is the input string
	 * @return String which is the largest word of the input text
	 */
	public static String largestWord(String text)
	{
		String word[]=text.split(" ");
		int largestLength=0;
		int largestWordIndex=0;
		for(int i=0;i<word.length;i++)
		{
			int length=word[i].length();
			if(length>=largestLength)
			{
				largestLength=length;
				largestWordIndex=i;
			}
		}
		return word[largestWordIndex];
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a string");
		String text=sc.nextLine();
		int choice;
		do
		{
		
		System.out.println("Press 1 to compare two Strings");
		System.out.println("Press 2 to reverse String");
		System.out.println("Press 3 to reverse Case");
		System.out.println("Press 4 to print the largest word of the string");
		System.out.println("Press 5 to exit");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Enter the second string to compare");
			sc.nextLine();
			String string2=sc.nextLine();
			int result=compareTwoStrings(text,string2);
					if(result==1)
						System.out.println("Both the strings are equal");
					else
						System.out.println("Both the strings are unequal");
					break;
		case 2:
			String reverse=reverseString(text);
			System.out.println("Reverse of the input string is "+reverse);
			break;
		case 3:
			String reverseCase=reverseCase(text);
			System.out.println("String after reversing Case is "+reverseCase);
			break;
		case 4:
			String largestWord=largestWord(text);
			System.out.println("Largest Word of the input string is "+largestWord);
			break;
		case 5:
			System.out.println("Exiting...");
			break;
			default:
				System.out.println("Invalid choice");
				
				
			
		}
	}while(choice!=5);
	}
}

import java.util.HashMap;
import java.util.HashSet;

import java.util.Scanner;
/**
 * This class is used to implement String operation
 * @author Vertika
 *
 */
public class StringOperation {
	static HashMap<String,Integer> stringToUniqueCount=new HashMap<String,Integer>();
	/**
	 * This method is used to count the number of unique characters in the string
	 * @param string is the input string
	 * @return integer value of the number of unique elements
	 */
	public static int countUniqueCharacters(String word)
	{
		if(word.length()==0)
			throw new AssertionError("The string is empty");
		Scanner sc=new Scanner(System.in);
		HashSet<Character> uniqueString=new HashSet<Character>();
		int count=0;
		word=word.toLowerCase();
		if(stringToUniqueCount.containsKey(word))
			count=stringToUniqueCount.get(word);
		else
		{
			for(int i=0;i<word.length();i++)
			{
				uniqueString.add(word.charAt(i));
			}
			count+=uniqueString.size();
			stringToUniqueCount.put(word,count);
			System.out.println("Number of unique characters in "+word+" are "+count);
		}
		sc.close();
		return count;
	}
}
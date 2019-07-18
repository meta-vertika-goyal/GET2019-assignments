import java.util.*;
public class ArrOperation {
	/*
	 * This method returns the size of the largest mirror section found in the input array
	 * @param inputArray is the input array on which the operations are to be performed
	 * @return int the size of the largest mirror section found in the input array
	 */
	public static int findLargestMirrorSection(int[] inputArray)
	{
		int length=inputArray.length;
		int largestLength=0,count;
		boolean fullMirror=false;
		if(length==0)
		{
			throw new AssertionError("Array is empty");
		}

		else
		{		
			for(int i=0;i<length-1;i++)
			{
				count=0;			
				for(int j=i+1;j<length;j++)
				{
					if(inputArray[i]==inputArray[j])
					{
						int index=j;
						while(inputArray[i++]==inputArray[index--])
						{
							count++;
							if((i-1)==(index-1))
							{
								fullMirror=true;
								break;
							}
						}
						if(fullMirror)
						{
							count=2*count+1;
						}
						if(count>largestLength)
							largestLength=count;					
					}
				}
			}		
			return largestLength;
		}
	}
	/*
	 * This method returns the number of clumps in the input array.
	 * @param inputArray is the input array on which the operations are to be performed
	 * @return int the number of clumps in the input array
	 */
	public static int findNumberOfClumps(int[] inputArray)
	{

		int length=inputArray.length,index=0,count,numberOfClumps=0;
		if(length==0)
		{
			throw new AssertionError("Array is empty");
		}

		else
		{
			for(int i=0;i<length-1;i=index+1)
			{

				count=1;
				index=i;
				while((index<length-1)&&(inputArray[index+1]==inputArray[index]))
				{
					count++;
					index++;				
				}
				if(count>=2)
					numberOfClumps++;			
			}
			return numberOfClumps;
		}
	}

	/*
	 * This method returns an array that contains exactly the same numbers as the input array,
	 * but rearranged so that every X is immediately followed by a Y.
	 * @param inputArray is the input array on which the operations are to be performed
	 * @return int[] the output array after rearrangement
	 */ 
	public static int[] fixXY(int[] inputArray,int x,int y)
	{
		int xTrack=0,yTrack=0,length=inputArray.length,countX=0,countY=0;
		if(length==0)
			throw new AssertionError("Array empty");
		ArrayList<Integer> yIndex=new ArrayList<Integer>();
		for(int i=0;i<length;i++)
		{
			if(inputArray[i]==x)
			{
				countX++;
			}
			if(inputArray[i]==y)
				countY++;
		}
		if(countX!=countY)
			throw new AssertionError("Unequal number of X and Y");
		for(int i=0;i<length-1;i++)
		{
			if(inputArray[i]==x)
			{
				if(inputArray[i+1]==x)
					throw new AssertionError("X values adjacently placed ");
			}				
		}
		for(int i=xTrack;i<length;i++)
		{
			if(inputArray[i]==x)
			{
				if(i==length-1)
					throw new AssertionError("Value of X at last index");
				for(int j=yTrack;j<length;j++)
				{
					if(inputArray[j]==y)
					{
						yIndex.add(i+1);
						inputArray[j]=inputArray[i+1];
						xTrack=i;
						yTrack=j+1;
						break;
					}
				}
			}
		}
		for(int index:yIndex)
			inputArray[index]=y;
		return inputArray;
	}
	/*
	 * This method returns the index if there is a place to split the input array so that the sum of the numbers
	 * on one side is equal to the sum of the numbers on the other side else return -1.
	 * @param inputArray is the input array on which the operations are to be performed
	 * @return int the index from where the array can be split
	 */
	public static int splitArray(int inputArray[])
	{
		int length=inputArray.length,index=-1,sum1=0,sum2=0,start=0,end=length-1;
		if(length==0)
			throw new AssertionError("Array is empty");
		sum1+=inputArray[start];
		sum2+=inputArray[end];
		while(start<=end)
		{
			if(sum1<sum2)
				sum1+=inputArray[++start];
			else if(sum2<sum1)
				sum2+=inputArray[--end];
			else if(sum1==sum2)
			{
				if(start==(end-1))
				{
					index=start+1;
					break;
				}
				else
				{
					sum1+=inputArray[++start];
					sum2+=inputArray[--end];
				}
			}
		}
		return index;		
	}
}	

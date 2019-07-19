
public class Search {
	/*
	 * This method is validates the length of the input array and calls the recursive function for linear search
	 * @param inputArray[] is the array on which the linear search is to be performed
	 * @param numSearch is the number to be searched in the input array
	 * @return int returns the index at which the number is found in the input array else returns -1
	 */
	public static int applyLinearSearch(int inputArray[],int numSearch)
	{
		if(inputArray.length==0)
			throw new AssertionError("Array is empty");
		int index=linearSearch(inputArray,numSearch,0);
		return index;
	}
	/*
	 * This method is a recursive function to apply linear search
	 * @param inputArray[] is the one dimensional array on which linear search is to be applied
	 * @param numSearch is the number to be searched in the input array
	 * @param index is the initial index at which the search will start
	 * @return int returns the index at which the number is found in the input array else returns -1
	 */
	public static int linearSearch(int inputArray[],int numSearch,int index)
	{

		if(index==inputArray.length)
			return -1;
		else if(inputArray[index]==numSearch)
			return index;
		else 
			return linearSearch(inputArray,numSearch,index+1);

	}
	/*
	 * This method is validates the length of the input array and calls the recursive function for binary search
	 * @param inputArray[] is the array on which the binary search is to be performed
	 * @param numSearch is the number to be searched in the input array
	 * @return int returns the index at which the number is found in the input array else returns -1
	 */
	public static int applyBinarySearch(int inputArray[],int numSearch)
	{
		if(inputArray.length==0)
			throw new AssertionError("Array is empty");
		int index=binarySearch(inputArray,numSearch,0,inputArray.length-1);
		return index;
	}

	/*
	 * This method is a recursive function to apply binary search
	 * @param inputArray[] is the one dimensional array on which binary search is to be applied
	 * @param numSearch is the number to be searched in the input array
	 * @param start is the starting index of the input array from where the search is to be done
	 * @param end is the ending index of the input array till where the search is to be done
	 * @return int returns the index at which the number is found in the input array else returns -1
	 */
	public static int binarySearch(int inputArray[],int numSearch,int start,int end)
	{
		if(start>end)
			return -1;
		else
		{
			int mid=(start+end)/2;
			if(inputArray[mid]==numSearch)
				return mid;
			else if(inputArray[mid]>numSearch)
				end=mid-1;
			else
				start=mid+1;
			return binarySearch(inputArray,numSearch,start,end);
		}

	}
	public static void main(String[] args)
	{
		int array[]={12,32,34,56,78,96};
		int length=array.length;
		int numSearch=56;
		int result=binarySearch(array,numSearch,0,length-1);
		System.out.println(result);

	}
}

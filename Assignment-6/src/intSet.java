import java.util.Arrays;
import java.util.List;
final class intSet {
	private int[] set;
	private int size;
	/*
	 * This is a constructor to set the field with the initial values
	 */
	intSet(int[] inputSet,int size)
	{
		set=inputSet;
		this.size=size;		
	}
	/*
	 * This is a getter to obtain the private field set[]
	 * @return int[] a set of integers 
	 */
	public int[] getSet()
	{
		return this.set;
	}
	/*
	 * This method checks if the input Set values follows property of a set(elements lie between 1 and 1000)
	 * @return boolean returns true if the set values are valid else returns false
	 */
	public boolean checkValid()
	{
		for(int i=0;i<this.set.length;i++)
		{
			if(this.set[i]<1||this.set[i]>1000)
				return false;

		}
		return true;
	}
	/*
	 * This method checks whether x is a member of the set and return a boolean value
	 * @param x is the value that has to be checked in the set
	 * @return boolean returns true if x lies in the set else returns false
	 */
	public boolean isMember(int x)
	{
		for(int i=0;i<size;i++)
		{
			if(set[i]==x)
				return true;
		}
		return false;
	}
	/*
	 * This methos returns the size of the set
	 * @return int returns the private field size of the set
	 */
	public int size()
	{
		return size;
	}
	/*
	 *  This method checks whether input set is a subset of the set
	 *  @param the set which is to be checked 
	 *  @return boolean returns true if the input set is a subset of the given set else returns false
	 */
	public boolean isSubset(intSet x)
	{
		if(!x.checkValid())
			throw new AssertionError("Invalid values");
		if(!this.checkValid())
			throw new AssertionError("Invalid values");
		boolean flag=true;
		for(int i=0;i<x.size();i++)
		{
			if(!this.isMember(x.set[i]))  //checks if every member of the input set lies in the given set
				flag=false;
		}
		return flag;
	}
	/*
	 *  This method returns the complement set, you can assume that 1..1000 is the universal set
	 *  @return intSet returns the complement set which is an object of the int set class
	 */
	public intSet getComplement()
	{
		if(!this.checkValid())
			throw new AssertionError("Invalid values");
		int complementSize=1000-this.size;
		int[] complementArray=new int[complementSize];
		int k=0;

		//all those values from the universal set(1-1000) that do not belong to the input set are put in the result set
		for(int i=1;i<=1000;i++)
		{
			if(this.isMember(i)==false)
			{
				complementArray[k++]=i;

			}
		}
		intSet complementSet=new intSet(complementArray,complementSize);
		return complementSet;
	}
	/*
	 * This method returns the union of the two input sets
	 * @param set1 is the first input Set
	 * @param set2 is the second input set
	 * @return intSet returns object of the intSet class containing the union of both the sets set1 and set2 
	 */
	public intSet getUnion(intSet set1,intSet set2)
	{
		if(!set1.checkValid())
			throw new AssertionError("Invalid values");
		if(!set2.checkValid())
			throw new AssertionError("Invalid values");
		int[] union=new int[set1.size+set2.size];
		int k=0;
		//first enter all the elements of set 1 in the result set
		for(int i=0;i<set1.size;i++)
		{
			union[k++]=set1.set[i];
		}
		//then enter all those elements of set 2 that are not the part of set 1 in the result set
		for(int j=0;j<set2.size;j++)
		{
			if(set1.isMember(set2.set[j])==false)
			{
				union[k++]=set2.set[j];
			}
		}
		int[] unionSetArray=Arrays.copyOf(union,k);
		intSet unionSet=new intSet(unionSetArray,k);
		return unionSet;
	}
}



public class LCM_HCF {
	/*
	 * This method returns the LCM of two numbers
	 * @param num1 is the first number
	 * @param num2 is the second number
	 * @return int LCM of the two input numbers
	 */
	public static int findLCM(int num1,int num2)
	{
		if(num1==0||num2==0)
			throw new AssertionError("Cannot find LCM");
		return ((num1*num2)/(findHCF(num1,num2)));
		
	}
	/*
	 * This method returns the HCF of two numbers
	 * @param num1 is the first number
	 * @param num2 is the second number
	 * @return int HCF of the two input numbers
	 */
	public static int findHCF(int num1,int num2)
	{
		if(num1==0||num2==0)
			throw new AssertionError("Cannot find HCF");
		if(num1==num2)
			return num1;
		else if(num1>num2)
			return findHCF(num1-num2,num2);
		else
			return findHCF(num1,num2-num1);
	}
	
}

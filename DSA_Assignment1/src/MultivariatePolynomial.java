import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * This class is to implement a multivariate polynomial using nested list
 * @author Vertika
 *
 */
public class MultivariatePolynomial {
	//nested list of polynomial where each index itself stores 
	//a list of the coefficients and the values of exponents of every variable of each term
	static ArrayList<ArrayList<Integer>> polynomial=new ArrayList<ArrayList<Integer>>();
	/**
	 * This method is to input the required parameters for the polynomial
	 */
	public static void createPolynomial()
	{
		int coefficient,exponent;
		System.out.println("Enter number of terms");
		int numberOfTerms=new Scanner(System.in).nextInt();
		System.out.println("Enter number of variables");
		int numberOfVariables=new Scanner(System.in).nextInt();
		for(int i=1;i<=numberOfTerms;i++)
		{
			ArrayList<Integer> term=new ArrayList<Integer>();
			System.out.println("Enter coefficient"+i);
			coefficient=(new Scanner(System.in)).nextInt();
			term.add(coefficient);
			for(int j=1;j<=numberOfVariables;j++)
			{
				System.out.println("Enter exponent for variable "+j+" of term "+i);
				exponent=(new Scanner(System.in)).nextInt();
				term.add(exponent);				 
			}
			polynomial.add(term);
		}
	}
	/**
	 * This method is used to find the degree of the polynomial
	 * @return int returns the degree of the polynomial
	 */
	public static int findDegree()
	{
		int degree=0;
		for(ArrayList<Integer> term:polynomial)
		{
			int sum=0;
			boolean isCoefficient=true;
			for(Integer exponent:term)
			{
				if(isCoefficient)
				{
					isCoefficient=false;
				}
				else if(!isCoefficient)
				{
					sum+=exponent;
				}
			}
			if(sum>degree)
				degree=sum;
		}
		return degree;
	}
	/**
	 * This method is used to print the polynomial
	 */
	public static void printPolynomial()
	{
		for(ArrayList<Integer> term:polynomial)
		{
			char variable='a';
			boolean isCoefficient=true;
			for(Integer exponent:term)
			{
				if(isCoefficient)
				{
					isCoefficient=false;
					System.out.print("("+exponent+")");
				}
				else if(!isCoefficient)
				{
					System.out.print((variable++)+"^"+exponent);

				}
			}
			if(!(polynomial.indexOf(term)==polynomial.size()-1))
				System.out.print("+");
		}
	}
	public static void main(String[] args)
	{
		createPolynomial();
		printPolynomial();
		System.out.println(findDegree());
	}
}


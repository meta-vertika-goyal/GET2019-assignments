import static org.junit.Assert.assertEquals;

import java.util.Arrays;

public class Poly {
	Term[] polynomial;
	
	int numberOfTerms;
	/*
	 * This is a constructor to set the initials field values
	 */
	Poly(Term[] polynomial,int numberOfTerms)
	{
		this.polynomial=polynomial;		
		this.numberOfTerms=numberOfTerms;
	}
	/*
	 * This method returns the degree of the polynomial
	 * @return integer degree of the polynomial
	 */
	public int degree()
	{
		int degree=0;
		for(Term term:polynomial)
		{
			if(term.exponent>degree)
				degree=term.exponent;
			
		}
		return degree;
	}
	/*
	 * This method returns the value of the polynomial for the given value of the variable
	 * @param x is the point at which the value of the olynomial is to be evaluated
	 * @return double value of the polynomial returned 
	 */
	public double evaluate(double x)
	{
		int length=polynomial.length;
		double result=0;
		for(int i=0;i<length;i++)
		{
			Term term=polynomial[i];
			result+=term.coefficient*Math.pow(x, term.exponent);
			
		}
		return result; 
	}
	/*
	 * return the sum of the two input polynomials
	 * @param p1 is the first input polynomial
	 * @param p2 is the second input polynomial
	 * @return Poly object of class Poly containing the sum of both the polynomials
	 */
	public Poly addPoly(Poly p1,Poly p2)
	{
		int length1=p1.polynomial.length;
		int length2=p2.polynomial.length;
		int i=0,j=0,k=0;
		int resultDegree=p1.numberOfTerms+p2.numberOfTerms;
		Term[] resultPolynomial=new Term[resultDegree];
		Term term;
		
		while(i<length1&&j<length2)
		{
			//the term with the higher exponent of the two polynomials stored in the result
			if(p1.polynomial[i].exponent>p2.polynomial[j].exponent)
			{
				term=new Term(p1.polynomial[i].coefficient,p1.polynomial[i++].exponent);
				resultPolynomial[k++]=term;
			}
			else if(p1.polynomial[i].exponent<p2.polynomial[j].exponent)
			{
				
				term=new Term(p2.polynomial[j].coefficient,p2.polynomial[j++].exponent);
				resultPolynomial[k++]=term;
			}
			//when the exponents are equal the terms are added and stored in the result
			else if(p1.polynomial[i].exponent==p2.polynomial[j].exponent)
			{
				term=new Term(p1.polynomial[i].coefficient+p2.polynomial[j].coefficient,p1.polynomial[i].exponent);
				i++;
				j++;
				resultPolynomial[k++]=term;
			}			
		}
		//remaining terms stored in the result
		while(i<length1)
		{
			term=p1.polynomial[i++];
			resultPolynomial[k++]=term;
		}
		while(j<length2)
		{
			term=p2.polynomial[j++];
			resultPolynomial[k++]=term;
		}
		Term[] finalResult=Arrays.copyOf(resultPolynomial,k);
		Poly p3=new Poly(finalResult,k);
		return p3;		
	}
	public Poly multiplyPoly(Poly p1,Poly p2)
	{
		int resultNumberOfTerms=p1.numberOfTerms*p2.numberOfTerms,k=0;
		Term[] resultPoly=new Term[resultNumberOfTerms];
		Term term;
		//every term of polynomial1 multplied with every term of polynomial2
		for(int i=0;i<p1.polynomial.length;i++)
		{			
			for(int j=0;j<p2.polynomial.length;j++)
			{
				term=new Term(p1.polynomial[i].coefficient*p2.polynomial[j].coefficient,p1.polynomial[i].exponent+p2.polynomial[j].exponent);
				
				resultPoly[k++]=term;
			}
		}
		//for the terms with equal exponents,the terms are added 
		for(int i=0;i<k-1;i++)
		{
			for(int j=i+1;j<k;j++)
			{
				if(resultPoly[i].exponent==resultPoly[j].exponent)
				{
					resultPoly[i].coefficient=resultPoly[i].coefficient+resultPoly[j].coefficient;
					for(int z=j;z<k-1;z++)
					{
						resultPoly[z]=resultPoly[z+1];
					}
					k--;  //when a term is removed,the number od terms are reduced by 1
				}
			}
		}
		Term[] finalResult=Arrays.copyOf(resultPoly,k);
		//the terms are sorted on the basis of their exponent values
		for(int i=0;i<finalResult.length-1;i++)
		{
			for(int j=0;j<finalResult.length-1-i;j++)
			{
				if(finalResult[j].exponent<finalResult[j+1].exponent)
				{
					Term temp=finalResult[j];
					finalResult[j]=finalResult[j+1];
					finalResult[j+1]=temp;
				}
			}
		}		
		Poly p3=new Poly(finalResult,k);
		p3.numberOfTerms=k;
		return p3;
	}
}
class Term
{
	int coefficient;
	int exponent;
	Term(int coefficient,int exponent)
	{
		this.coefficient=coefficient;
		this.exponent=exponent;
	}
}
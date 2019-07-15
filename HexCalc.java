package com.metacube.get2019;
import java.util.*;
public class HexCalc
{
	
	static int base=16;
	
	public static long hex_to_decimal(String hex)
    {
		String digits = "0123456789ABCDEF";  
        hex = hex.toUpperCase();  
        int k=0;
        long val = 0;  
        for (int i = hex.length()-1;i>=0;i--)  
        {  
            char c = hex.charAt(i);  
            int d = digits.indexOf(c);  
            val +=d*Math.pow(base,k++);  
        }  
        return val;  
    }
	
	public static String decimal_to_hex(long decimal){ 
		
	     int rem;  
	     String hex="";   
	     char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
	    while(decimal>0)  
	     {  
	       rem=(int)decimal%base;   
	       hex=hexchars[rem]+hex;   
	       decimal=decimal/base;  
	     }  
	    return hex;  
	}   
	
	public static String add(String hexnum1,String hexnum2)
	{
		long inthex1=hex_to_decimal(hexnum1);
		long inthex2=hex_to_decimal(hexnum2);
		long sum=inthex1+inthex2;
		String resulthex=decimal_to_hex(sum);
		return resulthex;		
		
	}
	public static String subtract(String hexnum1,String hexnum2)
	{
		
		String larger,smaller;
		if(checkgreater(hexnum1,hexnum2))
			{
				larger=hexnum1;
				smaller=hexnum2;
			}
		else
		{
			larger=hexnum2;
			smaller=hexnum1;
		}
		long intHex1=hex_to_decimal(larger);
		long intHex2=hex_to_decimal(smaller);
		
		
		long difference=intHex1-intHex2;
		String resulthex=decimal_to_hex(difference);
		return resulthex;		
		
	}
	public static String multiply(String hexnum1,String hexnum2)
	{
		long inthex1=hex_to_decimal(hexnum1);
		long inthex2=hex_to_decimal(hexnum2);
		long product=inthex1*inthex2;
		String resulthex=decimal_to_hex(product);
		return resulthex;		
		
	}
	public static String divide(String hexnum1,String hexnum2)
	{
		long inthex1=hex_to_decimal(hexnum1);
		long inthex2=hex_to_decimal(hexnum2);
		
		long quotient=inthex1/inthex2;
		String resulthex=decimal_to_hex(quotient);
		return resulthex;		
		
	}
	public static String removeleadingzeroes(String hexnum)
	{
		while (hexnum.indexOf("0")==0)
	         hexnum = hexnum.substring(1);
		return hexnum;
		
	}
	public static boolean comparehex(String hexnum1,String hexnum2)
	{
		hexnum1=removeleadingzeroes(hexnum1);
		hexnum2=removeleadingzeroes(hexnum2);
		int check=hexnum1.compareTo(hexnum2);
		if(check==0)
			return true;
		else
			return false;
	}
	public static boolean checkgreater(String hexnum1,String hexnum2)
	{
		hexnum1=removeleadingzeroes(hexnum1);
		hexnum2=removeleadingzeroes(hexnum2);
		int check=hexnum1.compareTo(hexnum2);
		if(check>0)
			return true;
		else
			return false;
	}
	public static boolean checksmaller(String hexnum1,String hexnum2)
	{
		hexnum1=removeleadingzeroes(hexnum1);
		hexnum2=removeleadingzeroes(hexnum2);
		int check=hexnum1.compareTo(hexnum2);
		if(check<0)
			return true;
		else
			return false;
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any two hexadecimal numbers");
		String hex1=sc.nextLine();
		String hex2=sc.nextLine();
		int choice;
		do
		{
		System.out.println("Select any of the following operations");
		System.out.println("1.Add\n2.Subtract\n3.Multiply\n4.Divide\n"
				+ "5.Compare for equality\n6.Compare if first number is larger\n"
				+ "7.Compare if first number is smaller\n8.Exit");
		choice=sc.nextInt();
		hex1=hex1.toUpperCase();
		hex2=hex2.toUpperCase();
		if(choice<=1&&choice>=7)
			System.out.println("Invalid choice");
		
		else
		{
		switch(choice)
		{
		case 1:
			String sum=add(hex1,hex2);
			System.out.println("Sum is : "+sum);
			break;
		case 2:
			String difference=subtract(hex1,hex2);
			System.out.println("Difference is : "+difference);
			break;
		case 3:
			String product=multiply(hex1,hex2);
			System.out.println("Product is : "+product);
			break;
		case 4:
			String quotient=divide(hex1,hex2);
			System.out.println("Quotient is : "+quotient);
			break;
		case 5:
			if(comparehex(hex1,hex2))
			    System.out.println("Numbers are equal");
			else
				System.out.println("Numbers are unequal");
		break;
		case 6:
			if(checkgreater(hex1,hex2))
			System.out.println("First number is larger");
			else
				System.out.println("Second number is larger");
			break;
		case 7:
			if(checksmaller(hex1,hex2))
				System.out.println("First number is smaller");
				else
					System.out.println("Second number is smaller");
				break;
		case 8:
			System.out.println("Exiting...");
			break;
			
			}
		}
		}while(choice!=8);
	}
		
	
	
	}



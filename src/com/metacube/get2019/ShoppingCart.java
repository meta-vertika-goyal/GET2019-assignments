package com.metacube.get2019;


import java.util.*;
class Item
{
	
	String name;
	double price;
	int quantity;
	Item(String nm,double pz,int qy)
	{
		
		name=nm;
		price=pz;
		quantity=qy;
	}
}
public class ShoppingCart {
	 HashMap<Integer,Item> cart=new HashMap<Integer,Item>(); 
	 HashMap<Integer,Item> availitems=new HashMap<Integer,Item>();
	
	
	void addToCart()
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the serial number");//fetching item by its serial number
		int sn=sc.nextInt();
		Item result=availitems.get(sn);
		System.out.println("How many?");              
		int num=sc.nextInt();
		if(num<result.quantity)						 //checks of the quantity demanded is available
			{
			result.quantity=result.quantity-num;     //if yes,the new available quantity is updated
			availitems.put(sn,result);
			result.quantity=num;                    
			cart.put(sn,result);
			System.out.println("Added!!");
			
			}
		
		else
			System.out.println("Unavailable");       //user prompted that the demanded quantity is unavailable
		
		
		
		
		
	}
	
	void updateCart()
	{
		Scanner sc=new Scanner(System.in);
		try
		{
		System.out.println("Enter the serial number"); //fetching item by its serial number
		int sn=sc.nextInt();
		if(sn>=1&&sn<=5)                               //checks if valid serial number is given
		{
		Item result=cart.get(sn);
		System.out.println("Press 1 to add");         
		System.out.println("Press 2 to remove");
		int choice=sc.nextInt();
		System.out.println("How many?");               //entering the number of quantities to be added or removed
		int num=sc.nextInt();
		switch(choice)
		{
		case 1:
			result.quantity=result.quantity+num;  
			break;
		case 2:
			result.quantity=result.quantity-num;
			
			break;
		}
		cart.put(sn,result);    //demanded quantity updated in the cart
		if(result.quantity==0)
			cart.remove(sn);
		
			
			
		
		
		}
		else
			System.out.println("Invalid Serial Number");
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("You have not added this to your cart"); //user is prompted if the demanded item is not yet in the cart
		}
		
		
	}
	void generateBill()
	{
		double total=0;     
		for(Map.Entry m:cart.entrySet())  
	     {  
	        Item itm=(Item)m.getValue();   
	       
			 System.out.println("S.No of the item");
			 System.out.println(m.getKey());
			 System.out.println("Name of the item");
			 System.out.println(itm.name);
			 System.out.println("Price of the item");
			 System.out.println(itm.price);
			 System.out.println("Quantity of the item");
			 System.out.println(itm.quantity);
			 total+=(itm.price*itm.quantity);   //total bill calculated by the sum of product of quantity and price
			 
			 
			 


	      } 
		 System.out.println("Total amount: "+total);
	
	}
	void viewCart()
	{
		for(Map.Entry m:cart.entrySet())  
	     {  
		Item itm=(Item)m.getValue();   
	       
		 System.out.println("S.No of the item");
		 System.out.println(m.getKey());
		 System.out.println("Name of the item");
		 System.out.println(itm.name);
		 System.out.println("Price of the item");
		 System.out.println(itm.price);
		 System.out.println("Quantity of the item");
		 System.out.println(itm.quantity);
			 
			 


	      } 
		
	}
	
	
	
	
	public static void main(String[] args)
	{
		
		ShoppingCart shop=new ShoppingCart();
		
		Scanner sc=new Scanner(System.in);
		//list of available items is displayed to the user
		System.out.println("List of Available Items");
		System.out.println("1.Notebook\n2.Pen\n3.Colors\n4.Files\n5.A4 sheets");
		Item itm1=new Item("Notebook",60,100);
		Item itm2=new Item("Pen",10,100);
		Item itm3=new Item("Colors",120,100);
		Item itm4=new Item("Files",60,100);
		Item itm5=new Item("A4 sheets",2,100);	
		//array list of available items created
		shop.availitems.put(1,itm1);
		shop.availitems.put(2,itm2);
		shop.availitems.put(3,itm3);
		shop.availitems.put(4,itm4);
		shop.availitems.put(5,itm5);
		int choice;
		
		do
		{
			
		//displaying the operations the user can perform
			
		System.out.println("Press 1 to Add to Cart");
		System.out.println("Press 2 to Update Cart");
		System.out.println("Press 3 to Generate Bill");
		System.out.println("Press 4 to View Cart");
		System.out.println("Press 5 to Exit");
		choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:
			shop.addToCart();
			break;
		case 2:
			shop.updateCart();
			break;
		case 3:
			shop.generateBill();
			break;
		case 4:
			shop.viewCart();
			break;
		case 5:
			System.out.println("Exiting....");
			break;
			default:
				System.out.println("Invalid Choice");
		}
		}while(choice!=5);
		}
				
			
			
		}
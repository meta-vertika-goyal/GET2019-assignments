package com.metacube.get2019;
import java.util.*;
class Item
{
	String name;
	double price;
	int quantity;
	Item(String itemname,double itemprice,int itemquantity)
	{
		
		name=itemname;
		price=itemprice;
		quantity=itemquantity;
	}
}
public class ShoppingCart 
{
	 HashMap<Integer,Item> serialToCartItem=new HashMap<Integer,Item>(); 
	 HashMap<Integer,Item> serialToAvailItem=new HashMap<Integer,Item>();
	
	 /*
	 * Adds the item selected by the user to the cart
	 
	 */	
	void addToCart()
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the serial number");//fetching item by its serial number
		int sn=sc.nextInt();
		Item result=serialToAvailItem.get(sn);
		if(result!=null)
		{
			
			System.out.println("How many?");              
			int num=sc.nextInt();
		
			if(num<result.quantity)						 //checks of the quantity demanded is available
			{
				result.quantity=result.quantity-num;     //if yes,the new available quantity is updated
				serialToAvailItem.put(sn,result);
				result.quantity=num;                    
				serialToCartItem.put(sn,result);
				System.out.println("Added!!");
			
			}
		
			else
			System.out.println("Unavailable");       //user prompted that the demanded quantity is unavailable
		
		}
		else
			System.out.println("No such serial number");
		
		
		
	}
	/*
	 * Updates the item selected by the user to the cart
	 
	 */
	
	void updateCart()
	{
		Scanner sc=new Scanner(System.in);
		
			System.out.println("Enter the serial number"); //fetching item by its serial number
			int serialnum=sc.nextInt();
			if(serialnum>=1&&serialnum<=serialToAvailItem.size())                               //checks if valid serial number is given
			{
				Item result=serialToCartItem.get(serialnum);
				if(result!=null)
				{
				Item availResult=serialToAvailItem.get(serialnum);
				System.out.println("Press 1 to add");         
				System.out.println("Press 2 to remove");
				int choice=sc.nextInt();
				System.out.println("How many?");               //entering the number of quantities to be added or removed
				int num=sc.nextInt();
				switch(choice)
				{
					case 1:
			 
						if(num<availResult.quantity)						 //checks of the quantity demanded is available
						{
							result.quantity=result.quantity-num;     //if yes,the new available quantity is updated
							serialToAvailItem.put(serialnum,result);
							result.quantity=num;                    
							serialToCartItem.put(serialnum,result);
							System.out.println("Added!!");
			
						}
		
						else
							System.out.println("Unavailable");
						break;
					case 2:
						result.quantity=result.quantity-num;
						break;
				}
				serialToCartItem.put(serialnum,result);    //demanded quantity updated in the cart
				if(result.quantity<=0)
					serialToCartItem.remove(serialnum);
				
			}
			else
				System.out.println("Invalid Serial Number");
			}
			else
				
				System.out.println("You have not added this to your cart"); //user is prompted if the demanded item is not yet in the cart
	
		
		
	}
	/*
	 * Generates the bill of  the items selected by the user to the cart
	 
	 */
	void generateBill()
	{
		double total=0;     
		for(Map.Entry getItem:serialToCartItem.entrySet())  
	     {  
			Item item=(Item)getItem.getValue();   
			System.out.println("S.No of the item");
			System.out.println(getItem.getKey());
			System.out.println("Name of the item");
			System.out.println(item.name);
			System.out.println("Price of the item");
			System.out.println(item.price);
			System.out.println("Quantity of the item");
			System.out.println(item.quantity);
			total+=(item.price*item.quantity);   //total bill calculated by the sum of product of quantity and price
			 
	     } 
		 System.out.println("Total amount: "+total);
	
	}
	/*
	 * View the item selected by the user to the cart
	 
	 */
	void viewCart()
	{
		for(Map.Entry getItem:serialToCartItem.entrySet())  
	     {  
			Item item=(Item)getItem.getValue();   
	       
			System.out.println("S.No of the item");
			System.out.println(getItem.getKey());
			System.out.println("Name of the item");
			System.out.println(item.name);
			System.out.println("Price of the item");
			System.out.println(item.price);
			System.out.println("Quantity of the item");
			System.out.println(item.quantity);
			 
	     } 
		
	}
	
	
	
	
	public static void main(String[] args)
	{
		
		ShoppingCart shop=new ShoppingCart();
		
		Scanner sc=new Scanner(System.in);
		//list of available items is displayed to the user
		System.out.println("List of Available Items");
		System.out.println("1.Notebook\n2.Pen\n3.Colors\n4.Files\n5.A4 sheets");
		Item item1=new Item("Notebook",60,100);
		Item item2=new Item("Pen",10,100);
		Item item3=new Item("Colors",120,100);
		Item item4=new Item("Files",60,100);
		Item item5=new Item("A4 sheets",2,100);	
		//array list of available items created
		shop.serialToAvailItem.put(1,item1);
		shop.serialToAvailItem.put(2,item2);
		shop.serialToAvailItem.put(3,item3);
		shop.serialToAvailItem.put(4,item4);
		shop.serialToAvailItem.put(5,item5);
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
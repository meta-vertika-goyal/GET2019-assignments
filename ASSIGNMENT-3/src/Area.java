import java.util.*;
public class Area {
	
	/* This method returns the area of a triangle with given height and width 
	 * @param height is the height of the triangle
	 * @param width is the base width of the triangle
	 * @return double area of the triangle 
	 */
	public static double areaTriangle(double height,double width)
	{
		double area=0.5*width*height;
		return area;
	}
	
	/* This method returns the area of a rectangle with given height and width 
	 * @param height is the height of the rectangle
	 * @param width is the base width of the rectangle
	 * @return double area of the rectangle 
	 */
	public static double areaRectangle(double width,double height)
	{
		double area;
		area=width*height;
		return area;
	}

	/* This method returns the area of a square with given width 
	 * @param width is the base width of the square
	 * @return double area of the square
	 */
	
	public static double areaSquare(double width)
	{
		double area;
		area=width*width;
		return area;
	}
	
	/* This method returns the area of a circle with given radius 
	 * @param width is the radius of the circle
	 * @return double area of the circle
	 */
	public static double areaCircle(double radius)
	{
		double area;
		area=3.14*radius*radius;
		return area;
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int choice;
		double height,width;
		double area;
		do
		{
			System.out.println("Press 1 to compute Area of Rectangle");
			System.out.println("Press 2 to compute Area of Triangle");
			System.out.println("Press 3 to compute Area of Square");
			System.out.println("Press 4 to compute Area of Circle");
			System.out.println("Press 5 to exit");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter height and width");
				height=sc.nextDouble();
				width=sc.nextDouble();
				area=areaRectangle(height,width);
				System.out.println(area);
				break;
			case 2:
				System.out.println("Enter height and width");
				height=sc.nextDouble();
				width=sc.nextDouble();
				area=areaTriangle(height,width);
				System.out.println(area);
				break;
			case 3:
				System.out.println("Enter width");
				width=sc.nextDouble();
				area=areaSquare(width);
				System.out.println(area);
				break;
			case 4:
				System.out.println("Enter radius");
				double radius=sc.nextDouble();
				area=areaCircle(radius);
				System.out.println(area);
				break;
			case 5:
				System.out.println("Exiting...");
				break;
				default:
					System.out.println("Invalid choice");
					break;
			}
		}while(choice!=5);
		
	}

}

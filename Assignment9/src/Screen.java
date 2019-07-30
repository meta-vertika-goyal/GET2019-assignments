import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class Screen {
	//List of shapes on the screen
	List<Shape> shapeList=new ArrayList<Shape>();
	ArrayList<Date> timestamp=new ArrayList<Date>();
	/**
	 * This method is used to add a Shape to the ShapeList on the screen
	 */
	public void addShape()
	{
		System.out.println("Add shape name to be added from circle triangle rectange and square");
		String shapeName=new Scanner(System.in).nextLine();
		shapeName=shapeName.toUpperCase();
		List<Integer> parameterList=getInputParameters(shapeName);
		System.out.println("Enter origin x and y coordinates");
		int x=new Scanner(System.in).nextInt();
		int y=new Scanner(System.in).nextInt();
		Point origin=new Point(x,y);
		Shape shape = ShapeFactory.createShape(shapeName,origin, parameterList);
		shapeList.add(shape);
		Date time=new Date();
		timestamp.add(time);	
	}
	/*This method is used to delete a shape from the shape list 
	 *@param id is the id of the shape to be deleted
	 *@return Boolean returns try is the shape corresponding to the input id is deleted else returns false
	 */
	public boolean deleteObject(int id) {
		System.out.println("---------------------------------- ");
		System.out.println("ID             SHAPE NAME");
		System.out.println("---------------------------------- ");

		for(Shape shape:shapeList)
		{
			System.out.println(shapeList.indexOf(shape)+1+"          "+shape.getShapeType());
		}
		if (shapeList.size() == 0) {
			throw new AssertionError("List is empty i.e. there is no object.");
		}
		for (int i = 0; i < shapeList.size(); i++) {
			if (i== id-1) {
				shapeList.remove(i);
				return true;
			}
		}
		return false;
	}
	/*This method is used to remove all shapes corresponding to a specific shape type
	 *@param shapeName is the type of the shape to be deleted
	 *@return Boolean returns true if objects of he given shapetype are deleted else returns false
	 */
	public boolean deleteAllObj(String shapeName) {
		shapeName = shapeName.toUpperCase();
		Shape.ShapeType ShapeEnum = Shape.ShapeType.valueOf(shapeName);
		if (shapeList.size() == 0) {
			throw new AssertionError("List is empty i.e. there is no object.");
		}
		for (int i = 0; i < shapeList.size(); i++) {
			if (shapeList.get(i).getShapeType() == ShapeEnum) {
				shapeList.remove(i);
				timestamp.remove(i);
			}
		}
		return true;
	}
	/**
	 * It is a method used to return shape object list based on area.
	 * @return sorted list of shape objects
	 */
	public List<Shape> sortByArea() {
		for (int i = 0; i < shapeList.size(); i++) {
			for (int j = 0; j < (shapeList.size() - i - 1); j++) {
				if (shapeList.get(j).getArea() > shapeList.get(j + 1).getArea()) {
					Shape temp = shapeList.get(j);
					shapeList.set(j, shapeList.get(j + 1));
					shapeList.set(j + 1, temp);
				}
			}
		}
		return shapeList;
	}
	/**
	 * It is a method used to return shape object list based on perimeter.
	 * @return sorted list of shape objects
	 */
	public List<Shape> sortByPerimeter() {
		for (int i = 0; i < shapeList.size(); i++) {
			for (int j = 1; j < (shapeList.size() - i); j++) {
				if (shapeList.get(j - 1).getPerimeter() > shapeList.get(j).getPerimeter()) {

					Shape temp = shapeList.get(j - 1);
					shapeList.set(j - 1, shapeList.get(j));
					shapeList.set(j, temp);
				}
			}
		}
		return shapeList;
	}
	/**
	 * It is a method used to return shape object list based on timestamp.
	 * @return sorted list of shape objects
	 */
	public List<Shape> sortByTimestamp()
	{
		for (int i = 0; i < shapeList.size(); i++) {
			for (int j = 1; j < (shapeList.size() - i); j++) {
				if (timestamp.get(j - 1).getTime() > timestamp.get(j).getTime()) {
					Date d=timestamp.get(j);
					timestamp.set(j,timestamp.get(j+1));
					timestamp.set(j+1,d);


					Shape temp = shapeList.get(j - 1);
					shapeList.set(j - 1, shapeList.get(j));
					shapeList.set(j, temp);
				}
			}
		}
		return shapeList;
	}
	/**
	 * It is a method used to return shape object list based on distance from origin.
	 * @return sorted list of shape objects
	 */
	public List<Shape> sortByOriginDistance()
	{
		List<Double> distanceFromOriginList=new ArrayList<Double>();
		Point origin;
		double distance;
		for(Shape shape:shapeList)
		{
			origin=shape.getOrigin();
			distance=getDistanceFromOrigin(origin);
			if(shape.getShapeType()==Shape.ShapeType.CIRCLE)
			{
				distance=distance-shape.getParameterList().get(0);
			}


			distanceFromOriginList.add(distance);
		}
		for (int i = 0; i < distanceFromOriginList.size(); i++) {
			for (int j = 1; j < (distanceFromOriginList.size() - i); j++) {
				if (distanceFromOriginList.get(j - 1) > distanceFromOriginList.get(j)) {
					distance=distanceFromOriginList.get(j);
					distanceFromOriginList.set(j,distanceFromOriginList.get(j+1));
					distanceFromOriginList.set(j+1,distance);
					Shape temp = shapeList.get(j - 1);
					shapeList.set(j - 1, shapeList.get(j));
					shapeList.set(j, temp);
				}
			}
		}
		return shapeList;
	}
	/**
	 * This is a helper method to get distance of a point from origin
	 * @param A is the point whose distance from the origin is to be calculated
	 * @return double value of the distance of the point from the origin
	 */
	public double getDistanceFromOrigin(Point A)
	{
		double distance=Math.sqrt(Math.pow(A.x,2)+Math.pow(A.y,2));
		return distance;
	}
	/**
	 * It is a method used to return a list of shape objects which enclosed given point.
	 * @param p point which we have to check
	 * @return list of shape object.
	 */
	public List<Shape> isPointEnclosedInShape(Point point) {
		List<Shape> isEnclose = new ArrayList<>();

		for (int i = 0; i < shapeList.size(); i++) {
			Shape shape = shapeList.get(i);
			if (shape.isPointEnclosed(point)) {
				isEnclose.add(shape);
			}
		}
		return isEnclose;
	}
	/*This method is used to input the required parameters based on their shapetype.
	 *@param shapeName is the type of shape whose parameters are to be added
	 *@return List<Integer> is the list of parameters that are input for the specified shapetype.
	 */
	public List<Integer> getInputParameters(String shapeName)
	{
		Scanner sc=new Scanner(System.in);
		List<Integer> parameterList=new ArrayList<Integer>();
		Shape.ShapeType shapeTypeEnum=null;
		shapeName = shapeName.toUpperCase();
		try
		{
			shapeTypeEnum=Shape.ShapeType.valueOf(shapeName);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("The shape name added is invalid");
		}
		switch (shapeTypeEnum) {
		case CIRCLE:
			System.out.print("Enter radius of circle : ");
			int radius = sc.nextInt();
			parameterList.add(0, radius);
			break;
		case RECTANGLE:
			System.out.print("Enter length and breadth of rectangle respectively : ");
			int length = sc.nextInt();
			int breadth= sc.nextInt();
			parameterList.add(0, length);
			parameterList.add(1, breadth);
			break;
		case TRIANGLE:
			System.out.print("Enter side1, side2 and side3 of triangle respectively : ");
			int side1 = sc.nextInt();
			int side2 = sc.nextInt();
			int side3 = sc.nextInt();
			parameterList.add(0, side1);
			parameterList.add(1, side2);
			parameterList.add(2, side3);
			break;
		case SQUARE:
			System.out.print("Enter the width of square: ");
			int side = sc.nextInt();
			parameterList.add(0, side);
			break;

		default :
			System.out.println("Shape invalid");
		}
		return parameterList;
	}


}
import java.util.ArrayList;
import java.util.List;

public class Circle implements Shape{
	int radius;
	Point center;
	List<Integer> parameterList=new ArrayList<Integer>();
	final Shape.ShapeType shapeType = ShapeType.CIRCLE;
	/*This is a parameterized constructor to set the initial values of the circle
         *@param radius is the radius of the circle
         *@param center is the center point of the circle
         */
	Circle(int radius,Point center)
	{
		this.radius=radius;
		this.center=center;
		parameterList.add(radius);
		
	}
	@Override
	public List<Integer> getParameterList() {
		
		return parameterList;
	}
	
        /*This method is used to get the shape type of the circle
         *@return Shape ShapeType enum constant representing the shape type is returned
         */
        public Shape.ShapeType getShapeType()
	{
		return shapeType;
	}
        /*This method is used to get the area of the circle
         *@return double value of area of the circle
         */
	@Override
	public double getArea() {
		
		return (3.14*radius*radius);
	}
        /*This method is used to get the perimeter of the circle
         *@return double value of the perimeter of circle
         */
        @Override
	public double getPerimeter() {
		
		return (2*3.14*radius);
	}
        /*This method is used to return the origin of the circle which is the centre
         *@return center point i.e the x and y coordinates of the circle
         */
        @Override
	public Point getOrigin() {
		
		return center;
	}
        /*This method is used to check if the input point lies within the circle or not
         *@param point to be checked
         *@return Boolean returns true if point lies inside the shape else returns false
         */
        @Override
	public boolean isPointEnclosed(Point point) {
		double evaluate;
		evaluate=Math.pow(point.x-center.x,2)+Math.pow(point.y-center.y,2)-Math.pow(radius, 2);
		if(evaluate<=0)
			return true;
		else
			return false;
		
	}
		

}

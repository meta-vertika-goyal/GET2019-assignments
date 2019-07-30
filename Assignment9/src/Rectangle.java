import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Shape{
double length;
double breadth;
List<Integer> parameterList=new ArrayList<Integer>();
final Shape.ShapeType shapeType = ShapeType.RECTANGLE;
@Override
public List<Integer> getParameterList() {
	
	return parameterList;
}

Point origin;
/*This method is a constructor to set the initial values of the rectangle
 *@param length is the length of the rectangle
 *@param breadth is the breadth of the rectangle 
 */
Rectangle(int length,int breadth,Point origin)
{
	this.length=length;
	this.breadth=breadth;
	this.origin=origin;
	parameterList.add(length);
	parameterList.add(breadth);
	}
/*This method returns the shape type of the rectangle
 *@return the shape type of the rectangle is returned as an enum constant
 */
public Shape.ShapeType getShapeType()
{
	return shapeType;
}
/*This method is used to find the area of the rectangle
 *@return double value of the area of the rectangle
 */
@Override
public double getArea() {
	return (length*breadth);
}

/*This method is used to find the perimeter of the rectangle
 *@return double value of the perimeter of the rectangle
 */
@Override
public double getPerimeter() {
	
	return 2*(length+breadth);
}
/*This point is used to find the origin of the rectangle
 *@return origin point of the rectangle
 */
@Override
public Point getOrigin() {
	return origin;
}
/*This method is used to check if the input point lies inside or outside the rectangle
 *@param point is the point which is to be checked
 *@return Boolean returns true if the point lies inside the rectangle else returns false
 */
@Override
public boolean isPointEnclosed(Point point) {
	double pointX=point.x;
	double pointY=point.y;
	double xMax=origin.x+length;
	double yMax=origin.y+breadth;
	if((pointX<=xMax&&pointX>=origin.x)&&(pointY<=yMax&&pointY>=origin.y))
		return true;
	else 
		return false;
}


}
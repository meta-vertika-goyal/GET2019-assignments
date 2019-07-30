import java.util.ArrayList;
import java.util.List;

public class Triangle implements Shape{
	int base;
	int side1;
	int side2;
	Point origin;
	final Shape.ShapeType shapeType = ShapeType.TRIANGLE;
	List<Integer> parameterList=new ArrayList<Integer>();
	public Shape.ShapeType getShapeType()
	{
		return shapeType;
	}
	Triangle(int base,int side1,int side2,Point origin)
	{
		this.base=base;
		this.side1=side1;
		this.side2=side2;
		this.origin=origin;
		parameterList.add(base);
		parameterList.add(side1);
		parameterList.add(side2);
	}
	@Override
	public double getArea() {
		
	return getScaleneArea(base,side1,side2);
	}
	@Override
	public double getPerimeter() {
		
		return side1+side2+base;
	}
	@Override
	public Point getOrigin() {		
		return origin;
	}
	@Override
	public boolean isPointEnclosed(Point point) {
		Point A=new Point(origin.x+base,origin.y);
		Point B = new Point();
		B.x = ((side1 * side1) - (side2 * side2) - (origin.x) + (A.x)) / (2 * (A.x) - (origin.x));
		B.y = ((int)(Math.sqrt((side2 * side2) - ((B.x - origin.x) * (B.x - origin.x))))) + origin.y;
		double areaOAB=this.getArea();
		double AP=getSideLength(point,A);
		double BP=getSideLength(point,B);
		double OP=getSideLength(point,origin);
		double areaOBP=getScaleneArea(side1,OP,BP);
		double areaOAP=getScaleneArea(base,OP,AP);
		double areaABP=getScaleneArea(side2,BP,AP);
		if(areaOAB==(areaOBP+areaOAP+areaABP))
			return true;
		else
			return false;
	}
	public double getSideLength(Point A,Point B)
	{
		double sideWidth=Math.sqrt(Math.pow(B.x-A.x,2)+Math.pow(B.y-A.y,2));
		return sideWidth;
	}
	public double getScaleneArea(double side1,double side2,double side3)
	{
		double s=(side1+side2+side3)/2;
		double area=Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
		return area;
	}
	@Override
	public List<Integer> getParameterList() {
		
		return parameterList;
	}
	   }

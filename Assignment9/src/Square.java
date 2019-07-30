import java.util.ArrayList;
import java.util.List;

public class Square implements Shape{
	int width;
	Point origin;
	List<Integer> parameterList=new ArrayList<Integer>();
	final Shape.ShapeType shapeType = ShapeType.SQUARE;
	
	@Override
	public List<Integer> getParameterList() {
		
		return parameterList;
	}
	public Shape.ShapeType getShapeType()
	{
		return shapeType;
	}
	Square(int width,Point origin)
	{
		this.origin=origin;
		this.width=width;	
		parameterList.add(width);
	}
	@Override
	public double getArea() {
		return width*width;
	}

	@Override
	public double getPerimeter() {
		return 4*width;

	}

	@Override
	public Point getOrigin() {
		return origin;
		
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		double pointX=point.x;
		double pointY=point.y;
		double xMax=origin.x+width;
		double yMax=origin.y+width;
		if((pointX<=xMax&&pointX>=origin.x)&&(pointY<=yMax&&pointY>=origin.y))
			return true;
		else 
			return false;
	}
	
}
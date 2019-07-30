import java.util.ArrayList;
import java.util.List;

public interface Shape {
	
	enum ShapeType
	{
		SQUARE,RECTANGLE,TRIANGLE,CIRCLE
	}
	
	double getArea();
	double getPerimeter();
	Point getOrigin();
	boolean isPointEnclosed(Point point);
	public Shape.ShapeType getShapeType();
	public List<Integer> getParameterList();

}

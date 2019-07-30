import java.util.List;


public class ShapeFactory {
	/*
	 * It is a method used to get object of type shape.
	 * @param shapeType type of shape
	 * @param origin is the origin of the shape
	 * @param list list of parameters
	 * @return shape type object
	 */
	public static Shape createShape(String shapeType, Point origin, List<Integer> list) {
	Shape.ShapeType shapeTypeEnum=Shape.ShapeType.valueOf(shapeType);
		switch(shapeTypeEnum)
		{
		case CIRCLE:
			return new Circle(list.get(0),origin);
			
		case SQUARE:
			return new Square(list.get(0),origin);
			
		case RECTANGLE:
			return new Rectangle(list.get(0),list.get(1),origin);
			
		case TRIANGLE:
			return new Triangle(list.get(0),list.get(1),list.get(2),origin);
			default:
				return null;
		}
		
		
			
	}
}
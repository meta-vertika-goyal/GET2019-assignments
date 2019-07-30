import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class ScreenOfShapes {
	static Scanner sc = new Scanner(System.in);
	/**
	 * It is a main method
	 * @param args unused
	 */
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		List<Integer> parameter = new ArrayList<Integer>();
		List<Integer> parameter1 = new ArrayList<Integer>();
		List<Shape> isEncloseList = new ArrayList<Shape>();
		List<Shape> tempList = new ArrayList<Shape>();
		Screen screen = new Screen();
		boolean isExit = false;
		boolean result;
		Point p;
		int x, y;
		try {
			do {
				System.out.println("--------------------------------");
				System.out.println("1. Add object on screen");
				System.out.println("2. Delete a particular object from the screen");
				System.out.println("3. Delete all objects of specific type from screen");
				System.out.println("4. Show all the objects on the screen sorted on the basis of perimeter");
				System.out.println("5. Show all the objects on the screen sorted on the basis of area");
				System.out.println("6. Show all the objects on the screen sorted on the basis of distance from origin");
				System.out.println("7. Show all the objects on the screen sorted on the basis of timestamp");
				System.out.println("8. Check position of a point relative to the shape ");
				System.out.println("9. Exit");
				System.out.println("--------------------------------");
				System.out.print("Enter your choice : ");
				int choice = sc.nextInt();
				System.out.println("--------------------------------");
				switch (choice) {
				case 1:
					screen.addShape();
					break;
				case 2:
					System.out.print("Enter the id of shape which you want to delete : ");
					int shapeId = sc.nextInt();
					result = screen.deleteObject(shapeId);
					break;
				case 3:
					System.out.print("Enter the name of shape to be deleted from screen among Rectangle, Circle and Square :");
					sc.nextLine();
					String shapeName = sc.nextLine();
					result = screen.deleteAllObj(shapeName);
					break;
				case 4:
					tempList = screen.sortByPerimeter();
					if (tempList.size() == 0) {
						System.out.println("No shapes are in the list!!!");
						break;
					}
					System.out.println("Sorted list according to perimeter : ");
					System.out.println("---------------------------------");
					System.out.println("ID\t\tSHAPETYPE");
					System.out.println("--------------------------------");
					for (int i = 0; i < tempList.size(); i++) {
						System.out.println((i+1)+"\t\t"+tempList.get(i).getShapeType());
					}
					System.out.println("--------------------------------");
					break;
				case 5:
					tempList = screen.sortByArea();
					if (tempList.size() == 0) {
						System.out.println("No shapes are in the list!!!");
						break;
					}
					System.out.println("Sorted list according to area : ");
					System.out.println("---------------------------------");
					System.out.println("ID\t\tSHAPETYPE");
					System.out.println("--------------------------------");
					for (int i = 0; i < tempList.size(); i++) {
						System.out.println((i+1)+"\t\t"+tempList.get(i).getShapeType());
					}
					System.out.println("--------------------------------");
					break;
				case 6:
					tempList = screen.sortByOriginDistance();
					if (tempList.size() == 0) {
						System.out.println("No shapes are in the list!!!");
						break;
					}
					System.out.println("Sorted list according to origin distance : ");
					System.out.println("---------------------------------");
					System.out.println("ID\t\tSHAPETYPE");
					System.out.println("--------------------------------");
					for (int i = 0; i < tempList.size(); i++) {
						System.out.println((i+1)+"\t\t"+tempList.get(i).getShapeType());
					}
					System.out.println("--------------------------------");
					break;
				case 7:
					tempList = screen.sortByTimestamp();
					if (tempList.size() == 0) {
						System.out.println("No shapes are in the list!!!");
						break;
					}
					System.out.println("Sorted list according to timestamp : ");
					System.out.println("---------------------------------");
					System.out.println("ID\t\tSHAPETYPE");
					System.out.println("--------------------------------");
					for (int i = 0; i < tempList.size(); i++) {
						System.out.println((i+1)+"\t\t"+tempList.get(i).getShapeType());
					}
					System.out.println("--------------------------------");
					break;

				case 8:
					System.out.print("Enter co-ordinates of point x and y respectively : ");
					x = sc.nextInt();
					y = sc.nextInt();
					p = new Point(x, y);
					isEncloseList  = screen.isPointEnclosedInShape(p);
					if (isEncloseList.size() == 0) {
						System.out.println("No shapes are in the list!!!");
						break;
					}
					System.out.println("List of shapes which enclosed this list are :  ");
					System.out.println("---------------------------------");
					System.out.println("ID\t\tSHAPETYPE");
					System.out.println("---------------------------------");
					for (int i = 0; i < isEncloseList.size(); i++) {
						System.out.println((i+1)+"\t\t"+isEncloseList.get(i).getShapeType());
					}
					System.out.println("---------------------------------");
					break;
				case 9:
					isExit = true;
					System.out.println("---------------------------------");
					System.out.println("Exit");
					System.out.println("---------------------------------");
					break;
				default:
					System.out.println("---------------------------------");
					System.out.println("Invalid input");
					System.out.println("---------------------------------");
				}

			} while (!isExit);
		}catch (InputMismatchException e) {
			System.out.println(e.getStackTrace());
		}

	}
}

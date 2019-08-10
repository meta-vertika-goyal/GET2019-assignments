import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * It is a class with main method
 * @author Vertika
 *
 */
public class DictionaryMain {

	/**
	 * It is a main method.
	 * @param args unused
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		boolean isExit = false;
		String key;
		DictionaryImplementation dictObj1 = null;
		List<Value> valueList = new ArrayList<Value>();
		List<Value> rangeValueList = new ArrayList<Value>();
		String JSON_FILEPATH = "C:/Users/Vertika/workspace/DS ASSIGNMENT5/src/data.json";
		try {
			do {
				System.out.println("1. Insert into dictionary.");
				System.out.println("2. Delete a key from dictionary");
				System.out.println("3. Get value of key.");
				System.out.println("4. Get sorted list of key value pair.");
				System.out.println("5. Get sorted list of key value pair within a range.");
				System.out.println("6. Exit");
				System.out.print("Enter your choice : ");
				int choice = sc.nextInt();
				sc.nextLine();
				switch(choice) {
				case 1:
					Object obj = new JSONParser().parse(new FileReader(JSON_FILEPATH)); 
					JSONObject jsonObj = (JSONObject) obj;
					dictObj1 = new DictionaryImplementation(jsonObj);	  
					break;
				case 2 :
					System.out.print("Enter the key which you want to delete : ");
					key = sc.nextLine();
					if(dictObj1.delete(key))
						System.out.println("Key Value Pair deleted");
					else
						System.out.println("Could not delete!!");
					break;
				case 3 :
					System.out.print("Enter the key whose value you want to find : ");
					key = sc.nextLine();
					String value = dictObj1.getValue(key);
					if(value!=null)
					System.out.println("Value of key "+ key + " : "+value);
					else
						System.out.println("Could not find the key value pair");
					break;
				case 4 :
					valueList = dictObj1.getAll();
					dictObj1.showList(valueList);
					break;
				case 5 :
					System.out.print("Enter the starting key of range : ");
					String key1 = sc.nextLine();
					System.out.print("Enter the ending key of range : ");
					String key2 = sc.nextLine();
					rangeValueList = dictObj1.getBetween(key1, key2);
					if(rangeValueList.size()!=0)
					dictObj1.showList(rangeValueList);
					else
						System.out.println("No such key value pairs found");
					break;
				case 6 :
					isExit = true;
					System.out.println("Successfully Exit!!!");
					break;
				default :
					System.out.println("Invalid choice.");
				}

			} while (!isExit);

		} catch (InputMismatchException e) {
			System.out.println(e.getStackTrace());
		}finally {
			sc.close();
		}
	}
}
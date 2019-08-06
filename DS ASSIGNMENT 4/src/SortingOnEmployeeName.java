import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * The class is used to implement sorting on the basis of employee name
 * @author Vertika
 *
 */
public class SortingOnEmployeeName {
	int empId;
	String name;
	String address;
	SortingOnEmployeeName(int empId,String name,String address)
	{
		this.empId=empId;
		this.name=name;
		this.address=address;
	}
	/**
	 * This is the overridden method of the Object class which is called by the System.out.println function
	 * @return String to be printed by the System.out.println function
	 */
	@Override
	public String toString()
	{
		return (empId+" "+name+" "+address);
	}
	// comparator object created for sorting on the basis of the employee name
	public static Comparator<SortingOnEmployeeName> sortingOnEmployeName=new Comparator<SortingOnEmployeeName>() {
		@Override
		public int compare(SortingOnEmployeeName employee1, SortingOnEmployeeName employee2) {
			return employee1.name.compareTo(employee2.name);
		}
	};
	public static void main(String[] args)
	{
		ArrayList<SortingOnEmployeeName> employeeList=new ArrayList<SortingOnEmployeeName>();
		SortingOnEmployeeName employee1=new SortingOnEmployeeName(1221,"Pranav Sudhakar","K.K Nagar");
		SortingOnEmployeeName employee2=new SortingOnEmployeeName(1222,"Riya Goyal","Kamla Nagar");
		SortingOnEmployeeName employee3=new SortingOnEmployeeName(1223,"Vertika Goyal","Vibhav Nagar");
		SortingOnEmployeeName employee4=new SortingOnEmployeeName(1224,"Sachet Kumar Mathur","Kaveri Vihar");
		SortingOnEmployeeName employee5=new SortingOnEmployeeName(1225,"Vanshaj Singh","Sikandra");
		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);
		employeeList.add(employee4);
		employeeList.add(employee5);
		Collections.sort(employeeList,SortingOnEmployeeName.sortingOnEmployeName);
		for(SortingOnEmployeeName employee:employeeList)
		{
			System.out.println(employee);
		}
	}
}
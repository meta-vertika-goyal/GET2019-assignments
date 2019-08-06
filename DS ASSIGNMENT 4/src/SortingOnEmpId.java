import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * The class is used to implement sorting on the basis of employee id
 * @author Vertika
 *
 */
public class SortingOnEmpId {
	int empId;
	String name;
	String address;
	/**
	 * parameterized constructor of class 
	 * @param empId is the unique id of the employee
	 * @param name is the name of the employee
	 * @param address is the address of the employee
	 */
	SortingOnEmpId(int empId,String name,String address)
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
	// comparator object created for sorting on the basis of the employee id
	public static Comparator<SortingOnEmpId> sortingOnEmpId=new Comparator<SortingOnEmpId>(){
		@Override
		public int compare(SortingOnEmpId employee1, SortingOnEmpId employee2) {

			return employee1.empId-employee2.empId;
		}
	};
	public static void main(String[] args)
	{
		ArrayList<SortingOnEmpId> employeeList=new ArrayList<SortingOnEmpId>();
		SortingOnEmpId employee3=new SortingOnEmpId(1223,"Vertika Goyal","Vibhav Nagar");
		SortingOnEmpId employee4=new SortingOnEmpId(1224,"Sachet Kumar Mathur","Kaveri Vihar");
		SortingOnEmpId employee5=new SortingOnEmpId(1225,"Vanshaj Singh","Sikandra");
		SortingOnEmpId employee1=new SortingOnEmpId(1221,"Pranav Sudhakar","K.K Nagar");
		SortingOnEmpId employee2=new SortingOnEmpId(1222,"Riya Goyal","Kamla Nagar");
		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);
		employeeList.add(employee4);
		employeeList.add(employee5);
		Collections.sort(employeeList,SortingOnEmpId.sortingOnEmpId);
		for(SortingOnEmpId employee:employeeList)
		{
			System.out.println(employee);
		}
	}
}

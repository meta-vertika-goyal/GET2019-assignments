import java.util.HashSet;
/**
 * This class is used to implement an Employee set
 * @author Vertika
 *
 */
public class EmployeeSet {
	int empId;
	String name;
	String address;
     /**
	 * parameterized constructor of class 
	 * @param empId is the unique id of the employee
	 * @param name is the name of the employee
	 * @param address is the address of the employee
	 */
	EmployeeSet(int empId,String name,String address)
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

	public static void main(String[] args)
	{
		HashSet<Employee> employeeSet=new HashSet<Employee>();
		Employee employee3=new Employee(1223,"Vertika Goyal","Vibhav Nagar");
		Employee employee4=new Employee(1224,"Sachet Kumar Mathur","Kaveri Vihar");
		Employee employee5=new Employee(1225,"Vanshaj Singh","Sikandra");
		Employee employee1=new Employee(1221,"Pranav Sudhakar","K.K Nagar");
		Employee employee2=new Employee(1222,"Riya Goyal","Kamla Nagar");
		Employee employee6=new Employee(1223,"Vertika Goyal","Vibhav Nagar");
		employeeSet.add(employee1);
		employeeSet.add(employee2);
		employeeSet.add(employee3);
		employeeSet.add(employee4);
		employeeSet.add(employee5);
		employeeSet.add(employee6);
		for(Employee employee:employeeSet)
		{
			System.out.println(employee.empId+" "+employee.name+" "+employee.address);
		}		
	}
	@Override
	public boolean equals(Object employee)
	{
		if(this.empId==((Employee)employee).empId)
			return true;
		else return false;
	}
	

}

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;
public class TestSortingOnEmployeeId {
	@Test
	public void testSortingOnEmployeeId() {
		ArrayList<SortingOnEmpId> employeeList=new ArrayList<SortingOnEmpId>();
		ArrayList<SortingOnEmpId> expectedEmployeeList=new ArrayList<SortingOnEmpId>();
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
		expectedEmployeeList.add(employee1);
		expectedEmployeeList.add(employee2);
		expectedEmployeeList.add(employee3);
		expectedEmployeeList.add(employee4);
		expectedEmployeeList.add(employee5);
		Collections.sort(employeeList,SortingOnEmpId.sortingOnEmpId);
		for(int i=0;i<5;i++)
		{
			assertEquals(expectedEmployeeList.get(i),employeeList.get(i));
		}
	}
}

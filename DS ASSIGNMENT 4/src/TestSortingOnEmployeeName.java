import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;
public class TestSortingOnEmployeeName {
	@Test
	public void testSortingOnEmployeeName() {
		ArrayList<SortingOnEmployeeName> employeeList=new ArrayList<SortingOnEmployeeName>();
		ArrayList<SortingOnEmployeeName> expectedEmployeeList=new ArrayList<SortingOnEmployeeName>();
		SortingOnEmployeeName employee3=new SortingOnEmployeeName(1223,"Vertika Goyal","Vibhav Nagar");
		SortingOnEmployeeName employee4=new SortingOnEmployeeName(1224,"Sachet Kumar Mathur","Kaveri Vihar");
		SortingOnEmployeeName employee5=new SortingOnEmployeeName(1225,"Vanshaj Singh","Sikandra");
		SortingOnEmployeeName employee1=new SortingOnEmployeeName(1221,"Pranav Sudhakar","K.K Nagar");
		SortingOnEmployeeName employee2=new SortingOnEmployeeName(1222,"Riya Goyal","Kamla Nagar");
		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);
		employeeList.add(employee4);
		employeeList.add(employee5);
		expectedEmployeeList.add(employee1);
		expectedEmployeeList.add(employee2);
		expectedEmployeeList.add(employee4);
		expectedEmployeeList.add(employee5);
		expectedEmployeeList.add(employee3);
		Collections.sort(employeeList,SortingOnEmployeeName.sortingOnEmployeName);
		for(int i=0;i<5;i++)
		{
			assertEquals(expectedEmployeeList.get(i),employeeList.get(i));
		}
	}
}

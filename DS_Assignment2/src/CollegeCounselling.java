import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
/**
 * This class  performs the counselling on the data given as input via two excel sheets
 * @author Vertika
 *
 */
class CollegeCounselling implements QueueStudent
{
	private Node front, rear; //begin and end nodes
	private int size; // number of students
	Map<String,Program> idToProgram=new HashMap<String,Program>();
	private static final String EXCEL_FILE_LOCATION1 = "C:\\Users\\Vertika\\Desktop\\Student Preference List.xls";
	private static final String EXCEL_FILE_LOCATION2 = "C:\\Users\\Vertika\\Desktop\\List of programs.xls";
	private static final String DESTINATION_FILE_LOCATION="C:\\Users\\Vertika\\Desktop\\List of Allotted programs.xls";
	//nested class to define node
	private class Node
	{ 
		Student student;
		Node next;
	}
	//Zero argument constructor
	public CollegeCounselling() 
	{
		front = null;
		rear = null;
		size = 0;
	}
	public boolean isEmpty()
	{
		return (size == 0);
	}
	//Remove student from the beginning of the list.
	public Student delete()
	{
		Student student = front.student;
		front = front.next;
		if (isEmpty()) 
		{
			rear = null;
		}
		size--;
		return student;
	}
	//Add student to the end of the list.
	public void insert(Student student)
	{
		Node oldRear = rear;
		rear = new Node();
		rear.student = student;
		rear.next = null;
		if (isEmpty()) 
		{
			front = rear;
		}
		else 
		{
			oldRear.next = rear;
		}
		size++;
	}
	public int size()
	{
		return size;
	}
/**
 * This method applies the algorithm for counselling for the data given in the excel sheets
 */
	public void performCounselling()
	{
		Node currentStudent=front;
		String programId;
		while(currentStudent!=rear)
		{
			boolean allotted=false;
			Student student=currentStudent.student;
			for(int i=0;i<=4;i++)
			{
				programId=student.preferenceList[i];
				if(idToProgram.containsKey(programId))
				{
					Program program=idToProgram.get(programId);
					if(program.capacity>0)
					{
						program.capacity--;
						allotted=true;
						student.program=program.programId;

						break;
					}
				}
				else
					continue;
			}
			if(!allotted)
				student.program="NOT ALLOTTED";
			currentStudent=currentStudent.next;
		}
	}
	/**
	 * This method can be used to display the student list
	 */
	public void display()
	{
		Node currentStudent=front;
		while(currentStudent!=rear)
		{
			Student student=currentStudent.student;
			System.out.println(student.studentID+" "+student.name+" "+student.program);
			currentStudent=currentStudent.next;
		}
	}
	/**
	 * This method can be used to print the program list
	 */
	public void displayProgramList()
	{
		for (Map.Entry<String,Program> entry : idToProgram.entrySet())  

		{System.out.println(entry.getKey() + " "+ entry.getValue().programName); 
		}
	}
	public void createExcelSheet()
	{
		WritableWorkbook allottedList=null;
		try
		{ allottedList=Workbook.createWorkbook(new File(DESTINATION_FILE_LOCATION));
		// create an Excel sheet
		WritableSheet excelSheet = allottedList.createSheet("Sheet 1", 0);
		// add something into the Excel sheet
		Label label = new Label(0, 0, "STUDENT ID");
		excelSheet.addCell(label);
		label = new Label(1, 0, "STUDENT NAME");
		excelSheet.addCell(label);
		label = new Label(2, 0, "PROGRAM ID");
		excelSheet.addCell(label);
		label = new Label(3,0, "PROGRAM NAME");
		excelSheet.addCell(label);
		Node currentNode=front;
		int i=1;
		while(currentNode!=rear)
		{
			Student student=currentNode.student;
			label = new Label(0, i,student.studentID);
			excelSheet.addCell(label);
			label = new Label(1, i,student.name);
			excelSheet.addCell(label);
			if(idToProgram.containsKey(student.program))
			{
				label = new Label(2, i,idToProgram.get(student.program).programId);
				excelSheet.addCell(label);
				label = new Label(3, i,idToProgram.get(student.program).programName);
				excelSheet.addCell(label);
			}
			else
			{
				label = new Label(2, i,"NOT ALLOTTED");
				excelSheet.addCell(label);
				label = new Label(3, i,"NOT ALLOTTED");
				excelSheet.addCell(label);
			}
			i++;
			currentNode=currentNode.next;
		}
		allottedList.write();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("The given file location does not exist");	
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} 
		finally {
			if (allottedList != null) {
				try {
					allottedList.close();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (WriteException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * This is the main method that inputs the number of students and the number of programs in the college from the user
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of students");
		int numberOfStudents=sc.nextInt();
		System.out.println("Enter number of programs");
		int numberOfPrograms=sc.nextInt();
		CollegeCounselling collegeCounsel=new CollegeCounselling();
		String preferenceList[];
		Student student;
		String studentID,studentName,programID,programName;
		int programCapacity;
		Program program;
		Workbook workbook1 = null;
		Workbook workbook2 = null;
		try {
			workbook1 = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION1));
			Sheet sheet1 = workbook1.getSheet(0);
			for(int i=1;i<=numberOfStudents;i++)
			{
				Cell cell1=sheet1.getCell(0,i);
				studentID=cell1.getContents();
				cell1=sheet1.getCell(1,i);
				studentName=cell1.getContents();
				preferenceList=new String[5]; 
				for(int j=2;j<=6;j++)
				{
					cell1=sheet1.getCell(j,i);
					String content=cell1.getContents();
					preferenceList[j-2]=content;
				}
				student=new Student(studentID,studentName,preferenceList,"");
				collegeCounsel.insert(student);
			}
			workbook2 = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION2));
			Sheet sheet2 = workbook2.getSheet(0);
			for(int i=1;i<=numberOfPrograms;i++)
			{
				Cell cell2=sheet2.getCell(0,i);
				programID=cell2.getContents();
				System.out.println(programID);
				cell2=sheet2.getCell(1,i);
				programName=cell2.getContents();
				System.out.println(programName);
				cell2=sheet2.getCell(2,i);
				programCapacity=Integer.parseInt(cell2.getContents());
				System.out.println(programCapacity);
				program=new Program(programID,programName,programCapacity);
				collegeCounsel.idToProgram.put(programID,program);
			}
			collegeCounsel.performCounselling();
			collegeCounsel.createExcelSheet();
			//collegeCounsel.display();
			//collegeCounsel.displayProgramList();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} finally {
			if (workbook1 != null) {
				workbook1.close();
			}
			if (workbook2 != null) {
				workbook2.close();
			}
		}
		sc.close();
	}
}



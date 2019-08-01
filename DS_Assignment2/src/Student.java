
public class Student {
String studentID;
String name;
String program;
String preferenceList[]=new String[5];
Student(String studentID,String name,String[] preferenceList,String program)
{
	this.studentID=studentID;
	this.name=name;
	this.program=program;
	this.preferenceList=preferenceList;
}
}

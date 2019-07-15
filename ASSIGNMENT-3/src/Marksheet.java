import java.util.*;
public class Marksheet {
	/*
	 * This method is used to compute average of all the grades of the students
	 * @param grades double type array of grades
	 * @param numOfStudents number of students
	 */
	public static double averageGrades(double grades[],int numOfStudents)
	{
		double average=0.0,sum=0;
		try
		{
			
			for(int i=0;i<numOfStudents;i++)
			{
				sum+=grades[i];
			}
			average=sum/numOfStudents;
			
	
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());
		}
		return average;
	}
	/*
	 * This method is used to compute maximum of all the grades of the students
	 * @param grades double type array of grades
	 * @param numOfStudents number of students
	 */
	public static double maxGrades(double grades[],int numOfStudents)
	{
		double maxGrade=0;
		for(int i=0;i<numOfStudents;i++)
		{
			if(grades[i]>maxGrade)
				maxGrade=grades[i];
		}
		return maxGrade;
		
	}
	/*
	 * This method is used to compute minimum of all the grades of the students
	 * @param grades double type array of grades
	 * @param numOfStudents number of students
	 */
	public static double minGrades(double grades[],int numOfStudents)
	{
		double minGrade=0;
		for(int i=0;i<numOfStudents;i++)
		{
			if(grades[i]<minGrade)
				minGrade=grades[i];
		}
		return minGrade;
		
	}
	
	/*
	 * This method is used to compute the percentage of students passed
	 * @param grades double type array of grades
	 * @param numOfStudents number of students
	 */
	public static double percentagePass(double grades[],int numOfStudents)
	{
		int studentsPassed=0;
		double percentage=0;;
		try
		{
			for(int i=0;i<numOfStudents;i++)
			{
				if(grades[i]>=40)
					studentsPassed++;
			}
			percentage=(studentsPassed/numOfStudents)*100;
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());
		}
		
		return percentage;
	}


	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Ënter the number of students");
		int numOfStudents=sc.nextInt();
		double grades[]=new double[numOfStudents];
		int choice;
		System.out.println("Enter the grades");
		for(int i=0;i<numOfStudents;i++)
		{
			grades[i]=sc.nextDouble();
		}
		do
		{
			System.out.println("Press 1 to return Average of Grades");
			System.out.println("Press 2 to return Maximum Grade");
			System.out.println("Press 3 to return Minimum Grade");
			System.out.println("Press 4 to return Percentage of Students passed");
			System.out.println("Press 5 to exit");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				double average=averageGrades(grades,numOfStudents);
				System.out.println("Average of Grades is %0.2f"+average);
				break;
			case 2:
				double maxGrade=maxGrades(grades,numOfStudents);
				System.out.println("Maximum Grade is %0.2f"+maxGrade);
				break;
			case 3:
				double minGrade=minGrades(grades,numOfStudents);
				System.out.println("Minimum Grade is %0.2f"+minGrade);
				break;
			case 4:
				double percentage=percentagePass(grades,numOfStudents);
				System.out.println("Percentage of Students Passed :%0.2f"+percentage);
				break;
			case 5:
				System.out.println("Exiting...");
				break;
				default:
					System.out.println("Invalid choice");
			}	
		}while(choice!=5);
		
			
			
		}
				          
	
				               
	}



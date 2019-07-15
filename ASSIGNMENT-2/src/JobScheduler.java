

import java.util.Scanner;

public class JobScheduler {
	/*
	 * This method returns the completion time for the input process list
	 * @param scheduler[][] 2 dimensional array consisting of arrival time and burst time
	 * @param numOfProcesses number of processes to be scheduled
	 * @return int[] integer array consisting of the completion time of each of the processes
	 */
	public static int[] calaculateCompletionTime(int scheduler[][],int numOfProcesses)
	{
		
		int control=0;        //control keeps track of the point from which the next process has to start execution
		int completionTime[]=new int[numOfProcesses];
		completionTime[0]=control+scheduler[0][1];
		control=completionTime[0];
		for(int i=1;i<numOfProcesses;i++)
		{
			
			if(scheduler[i][0]>=control)  /*if the next process arrives after the completion of the prior process
				                            then the control is set to the arrival time of the next process*/
				control=scheduler[i][0];    
			
			completionTime[i]=control+scheduler[i][1]; //completion time=point where the process starts execution plus its burst time
			control=completionTime[i];                 //control set to the point where process completes its execution
			
		}
		return completionTime;
		
	}
	/*
	 * This method returns the Waiting time for the input process list
	 * @param scheduler[][] 2 dimensional array consisting of arrival time and burst time
	 * @param numOfProcesses number of processes to be scheduled
	 * @return int[] integer array consisting of the Waiting time of each of the processes
	 */
	public static int[] calaculateWaitingTime(int scheduler[][],int numOfProcesses)
	{
		int waitingTime[]=new int[numOfProcesses];
		waitingTime[0]=0;
		int completionTime[]=calaculateCompletionTime(scheduler,numOfProcesses);
		for(int i=1;i<numOfProcesses;i++)
		{
			waitingTime[i]=completionTime[i-1]-scheduler[i][0];
			if(waitingTime[i]<0)
				waitingTime[i]=0;
			
		}
		return waitingTime;
	}
	/*
	 * This method returns the completion time for the input process list
	 * @param scheduler[][] 2 dimensional array consisting of arrival time and burst time
	 * @param numOfProcesses number of processes to be scheduled
	 * @return int[] integer array consisting of the turn around time of each of the processes
	 */
	public static int[] calaculateTurnAroundTime(int scheduler[][],int numOfProcesses)
	{
		int turnAroundTime[]=new int[numOfProcesses];
		int waitingTime[]=calaculateWaitingTime(scheduler,numOfProcesses);
		for(int i=0;i<numOfProcesses;i++)
		{
			turnAroundTime[i]=waitingTime[i]+scheduler[i][1]; //turnarountime=waitingtime+burst time
		}
		return turnAroundTime;
		
	}
	/*
	 * This method returns the completion time for the input process list
	 * @param scheduler[][] 2 dimensional array consisting of arrival time and burst time
	 * @param numOfProcesses number of processes to be scheduled
	 * @return double average waiting time of all the processes
	 */
	public static double calaculateAvgWaitingTime(int scheduler[][],int numOfProcesses)
	{
		int waitingTime[]=calaculateWaitingTime(scheduler,numOfProcesses);
		int sumWaitingTime=0;
		for(int i=0;i<numOfProcesses;i++)
		{
			sumWaitingTime+=waitingTime[i];
		}
		double avgWaitingTime=sumWaitingTime/numOfProcesses;
		return avgWaitingTime;
	}
	/*
	 * This method returns the completion time for the input process list
	 * @param scheduler[][] 2 dimensional array consisting of arrival time and burst time
	 * @param numOfProcesses number of processes to be scheduled
	 * @return int maximum waiting time out of all the processes
	 */
	public static int maximumWaitingTime(int scheduler[][],int numOfProcesses)
	{
		int waitingTime[]=calaculateWaitingTime(scheduler,numOfProcesses);
		int maxWaitingTime=0;
		for(int i=0;i<numOfProcesses;i++)
		{
			if(waitingTime[i]>maxWaitingTime)
				maxWaitingTime=waitingTime[i];
		}
		return maxWaitingTime;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of processes");
		int numOfProcesses=sc.nextInt();
		int scheduler[][]=new int[numOfProcesses][2];
		String choice;
		int choice2;

		System.out.println("Enter the arrival time and burst time");
		for(int i=0;i<numOfProcesses;i++)
		{
			System.out.println("Process"+(i+1)+"?");
			scheduler[i][0]=sc.nextInt();         /* scheduler[][] holds arrivaltime in column 1
												   and burst time in column 2*/
			scheduler[i][1]=sc.nextInt();         
			
		}
		do
		{
		System.out.println("What do you want to do?");
		System.out.println("1.Compute completion time");
		System.out.println("2.Compute waiting time");
		System.out.println("3.Compute turnaround time");
		System.out.println("4.Compute average waiting time");
		System.out.println("5.Compute maximum waiting time");
		System.out.println("6.Exit");
		choice2=sc.nextInt();
		switch(choice2)
		{
		case 1:
			int[] completionTimeResult=calaculateCompletionTime(scheduler,numOfProcesses);
			System.out.println("Process    Completion Time");
			printlist(completionTimeResult);
			break;
		case 2:
			
			int[] waitingTimeResult=calaculateWaitingTime(scheduler,numOfProcesses);
			System.out.println("Process   Waiting Time");
			printlist(waitingTimeResult);
			break;
		case 3:
			int[] turnAroundTimeResult=calaculateTurnAroundTime(scheduler,numOfProcesses);
			System.out.println("Process   TurnAround Time");
			printlist(turnAroundTimeResult);
			break;
		case 4:
			double averageWaitingTime=calaculateAvgWaitingTime(scheduler,numOfProcesses);
			System.out.println("Average Waiting Time is : "+averageWaitingTime);
			break;
		case 5:
			double maxWaitingTime=maximumWaitingTime(scheduler,numOfProcesses);
			System.out.println("Maximum Waiting Time : "+maxWaitingTime);
			break;
		case 6:
			System.out.println("Exiting...");
			break;
			default:
				System.out.println("Invalid choice!!");
			
		
			
			
		}
		}
		while(choice2!=6);
		
	}
	public static void printlist(int[] inputList)
	{
		int i=1;
		for(int time:inputList)
			System.out.println(i++ +"   "+ time);
	}


}

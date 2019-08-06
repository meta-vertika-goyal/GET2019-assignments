import java.util.Scanner;


public class VirtualCommandPrompt {
	public static void main(String[] args)
	{
		File directory=new File();
		Scanner sc=new Scanner(System.in);
		
		directory.displayPath(directory.currentDirectory);
		String statement="";
		char space=' ';
		String command,nameOfDirectory;
		while(!statement.equalsIgnoreCase("exit"))
		{
			statement=sc.nextLine();
			statement.trim();
			if(statement.contains(" "))
			{
				command=statement.substring(0,statement.indexOf(space)).toLowerCase();
			
			nameOfDirectory=statement.substring(statement.indexOf(space)+1);
			}
			else
				{
				command=statement;
				nameOfDirectory="";
				}
			switch(command)
			{
			case "mkdir":
				directory.createDirectory(nameOfDirectory);
				break;
			case "cd":
				directory.changeDirectory(nameOfDirectory);
				break;
			case "bk":
				directory.moveBack();
				break;
			case "ls":
				directory.listDirectory();
				break;
			case "find":
				directory.find(directory.currentDirectory,nameOfDirectory);
				break;
			case "tree":
				directory.displayDirectoryStructure(File.Root,1);
				break;
			case "exit":
				break;
				default:
					System.out.println("Invalid command");
					directory.displayPath(File.Root);
				
			}
			
		}
		sc.close();
		
	
	}
}

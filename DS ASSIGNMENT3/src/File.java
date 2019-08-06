import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
/**
 * This class is used to implement the directory structure
 * @author Vertika
 *
 */
public class File{
	File parent;
	ArrayList<File> children;
	String label;
	Timestamp dateOfCreation;
	static final File Root=new File();
	File currentDirectory=Root;
	/**
	 * default constructor
	 */
	File()
	{
		label="HOME";
		parent=null;
		children=new ArrayList<File>();
		dateOfCreation=new Timestamp(new Date().getTime());

	}
	/**
	 * parameterised constructor to create a new directory
	 * @param label is the name of the directory
	 */
	File(String label)
	{
		this.parent=currentDirectory;
		this.children=new ArrayList<File>();
		this.label=label;
		this.dateOfCreation=new Timestamp(new Date().getTime());
	}
	/**
	 * This method is used to create a new directory
	 * @param nameOfDirectory is the name of the directory
	 */
	public void createDirectory(String nameOfDirectory)
	{
		File newDirectory=new File(nameOfDirectory);
		boolean exists=false;
		for(File file:currentDirectory.children)
		{
			if(file.label.equalsIgnoreCase(nameOfDirectory))
				exists=true;
			break;
		}
		if(exists)
			System.out.println("The given directory name already exists");
		else
		{
			currentDirectory.children.add(newDirectory);
			newDirectory.parent=currentDirectory;
			//currentDirectory=newDirectory;
		}
		displayPath(currentDirectory);
	}
	/**
	 * This method is used to change to a new directory
	 * @param nameOfDirectory is the name of the directory to which we have to move
	 */
	public void changeDirectory(String nameOfDirectory)
	{
		ArrayList<File> children=currentDirectory.children;
		boolean found=false;
		for(File subFile:children)
		{
			if(subFile.label.equalsIgnoreCase(nameOfDirectory))
			{
				found=true;
				currentDirectory=subFile;
			}
		}
		if(!found)
			System.out.println("The given directory name does not exist");
		displayPath(currentDirectory);
	}
	/**
	 * This method is used to move to the parent directory from the current directory
	 */
	public void moveBack()
	{
		if(currentDirectory.parent!=null)
		{currentDirectory=currentDirectory.parent;
		}
		else
			System.out.println("Already in the home directory");
		displayPath(currentDirectory);
	}
	/**
	 * This method is used to list all the folders in the current directory
	 */
	public void listDirectory()
	{
		int count=0;
		for(File file:currentDirectory.children)
		{
			System.out.println(file.label +" "+file.dateOfCreation);
			count++;

		}
		System.out.println(count);
		displayPath(currentDirectory);
	}
	/**
	 * This method is used to find a file in the given directory or its subdirectories
	 * @param directory is the current directory
	 * @param nameOfDirectory is the name of the directory which is to be searched for
	 */
	public void find(File directory,String nameOfDirectory)
	{
		if(directory.label.contains(nameOfDirectory))
		{
			currentDirectory=directory;
			displayPath(currentDirectory);
		}
		else if(directory.children.size()==0)
			return;
		else
		{
			for(File file:directory.children)
			{
				find(file,nameOfDirectory);
			}
			displayPath(currentDirectory);
		}
	}
	/**
	 * This method is used to display the entire directory structure
	 * @param directory is the root directory
	 * @param levels is a parameter used to displaying the files in a hierarchial order
	 */
	public void displayDirectoryStructure(File directory,int levels)
	{
		for(int i=1;i<=levels;i++)
		{
			System.out.print(" ");
		}
		System.out.print("\u2514");
		System.out.println(directory.label);
		if(directory.children.size()==0)
		{
			levels=levels-2;
			return;
		}
		else
		{	
			for(File child:directory.children)
			{ 
				displayDirectoryStructure(child,levels+2);
			}
		}
		displayPath(currentDirectory);
	}
	/**
	 * This is a helper method used to display the current path
	 * @param directory is the pointer to the current directory
	 */
	public void displayPath(File directory)
	{
		String filePath=">";
		while(directory!=null)
		{
			filePath=directory.label+"\\"+filePath;
			directory=directory.parent;
		}
		System.out.println(filePath);
	}
	/**
	 * This method is used to exit the command prompt
	 */
	public void exit()
	{
		currentDirectory=Root;
		displayPath(Root);
	}
}

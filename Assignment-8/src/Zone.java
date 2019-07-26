import java.util.ArrayList;

public class Zone {
static int numberOfCages;						//maximum number of cages possible in a zone
ArrayList<Cage> cageList=new ArrayList<Cage>(); //list of cages in a particular zone
String category;
/*
 * Parameterized constructor to initialise the zone properties
 * @param category is the animal category that can be kept in the particular zone 
 */
Zone(String category)
{
	
	this.category=category;
	numberOfCages=2;
}
}

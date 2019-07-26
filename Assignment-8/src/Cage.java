import java.util.ArrayList;
public class Cage {
	int cageCapacity;                                      //maximum number of animals allowed in the cage
	ArrayList<Animal> animalList=new ArrayList<Animal>();  //list of animals is the cage
	String animalType;									   //animal type allowed in the cage
	/*
	 * Parameterized constructor to set the cage attributes
	 * @param animalList is the list of animals is the cage
	 * @param animalType is animal type allowed in the cage
	 */
	Cage(ArrayList<Animal> animalList,String animalType)
	{
		this.cageCapacity=2;
		this.animalList=animalList;
		this.animalType=animalType;
	}
}

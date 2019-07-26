import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Zoo {
	static int numberOfZones=3;         //maximum number of zones allowed in the zoo
	static ArrayList<Zone> zoneList=new ArrayList<Zone>();  //list of zones in the zoo
	/*
	 * This method is used to add a new animal to the zoo
	 * @param animal is the animal to be added to the zoo
	 * @return boolean true if the animal can be added else returns false
	 */
	public static boolean addToZoo(Animal animal)
	{
		int zoneIndex=-1,i=0,k=0,cageIndex=-1;
		//search for zone
		for(Zone zone:zoneList)
		{
			if(zone.category==animal.category)
			{
				zoneIndex=i;
			}
			i++;
		}
		//zone found
		if(zoneIndex!=-1)
		{
			Zone checkZone=zoneList.get(zoneIndex);
			ArrayList<Cage> checkCageList=checkZone.cageList;
			//find cage with same animaltype
			for(Cage checkCage:checkCageList)
			{
				if(checkCage.animalType.equalsIgnoreCase(animal.name))
				{
					cageIndex=k;
				}
				k++;
			}
			Cage foundCage=null;
			//cage found
			if(cageIndex!=-1)
			{
				foundCage=checkCageList.get(cageIndex);
			}
			//cage found and not full
			if((cageIndex!=-1)&&(foundCage.animalList.size()<foundCage.cageCapacity))
			{
				foundCage.animalList.add(animal);
				checkCageList.set(cageIndex,foundCage);	
				return true;
			}
			//cage full then create new cage
			else
			{
				if(addCage(checkZone,animal))
					return true;
				else 
					return false;
			}
		}
		else
		{ //zone not found 
			if(addZone(animal))
				return true;
			else
				return false;
		}
	}
	/*
	 * This method is used to add cage to a given zone for the given animal type
	 * @param checkZone is the zone in which the cage is to be added
	 * @param animal is the animal to be added
	 * @return boolean true if cage added else returns false
	 */
	public static boolean addCage(Zone checkZone,Animal animal)
	{
		ArrayList<Animal> newAnimalList=new ArrayList<Animal>();
		newAnimalList.add(animal);
		Cage newCage=new Cage(newAnimalList,animal.name);
		//check the capacity of the zone
		if(checkZone.cageList.size()<checkZone.numberOfCages)
		{
			checkZone.cageList.add(newCage);
			return true;
		}
		//if zone is full then create new zone
		else
		{
			if(addZone(animal))
				return true;
			else 
				return false;
		}
	}
	/*
	 * This method is used to add a new zone for the given animal type
	 * @param animal is the animal to be added
	 * @return boolean true if new zone added else returns false 
	 */
	public static boolean addZone(Animal animal)
	{
		//check zone limit
		if(zoneList.size()<numberOfZones)
		{
			Zone newZone=new Zone(animal.category);
			if(addCage(newZone,animal))
			{
				zoneList.add(newZone);
				return true;
			}
			else
				return false;
		}
		else
		{
			System.out.println("New entry not possible in the zoo");

			return false;
		}
	}
	/*
	 * This method is used to remove an animal from the zoo
	 * @param animal is the animal to be removed
	 * @return boolean true if animal removed else returns false
	 */
	public static boolean removeAnimal(Animal animal)
	{
		int zoneIndex=-1,i=0,cageIndex=-1,k=0,animalIndex=-1,l=-1;
		for(Zone zone:zoneList)
		{
			//if zone with the given animal category found
			if(zone.category==animal.category)
			{
				zoneIndex=i;
			}
			i++;
		}
		//zone not found 
		if(zoneIndex==-1)
		{
			System.out.println("Zone with the given Animal category not found");
			return false;
		}
		else
		{
			Zone checkZone=zoneList.get(zoneIndex);
			ArrayList<Cage> checkCageList=checkZone.cageList;
			//find cage with same animaltype
			for(Cage checkCage:checkCageList)
			{
				if(checkCage.animalType.equalsIgnoreCase(animal.name))
				{
					cageIndex=k;
				}
				k++;
			}
			Cage foundCage=null;
			//cage found
			if(cageIndex!=-1)
			{
				foundCage=checkCageList.get(cageIndex);
				ArrayList<Animal> cageAnimalList=foundCage.animalList;
				//search animal to be found
				for(Animal checkAnimal:cageAnimalList)
				{
					l++;
					//animal found
					if(checkAnimal.age==animal.age&&checkAnimal.weight==animal.weight)
					{
						cageAnimalList.remove(l);
						if(cageAnimalList.size()==0)
						{
							checkCageList.remove(cageIndex);
							if(checkCageList.size()==0)
								zoneList.remove(zoneList.indexOf(checkZone));
						}

						return true;
					}
					else
					{
						System.out.println("The animal with the given details not found");
						return false;
					}
				}
			}
		}
		return false;
	}
	/*
	 * This method is used to add a new cage to the specified zone
	 * @param animalCategory is the animal category of the zone in which a new cage is to be added
	 * @return boolean true if new cage added else returns false 
	 */
	public static boolean addCageToZone(String animalCategory)
	{
		Cage newCage=new Cage(null,animalCategory);
		int zoneIndex=-1,i=0,k=0,cageIndex=-1;
		boolean result;
		//search for zone
		for(Zone zone:zoneList)
		{
			if(zone.category.equalsIgnoreCase(animalCategory))
			{
				if(zone.cageList.size()<zone.numberOfCages)
					zoneIndex=i;
			}
			i++;
		}
		//zone found
		if(zoneIndex!=-1)
		{
			Zone checkZone=zoneList.get(zoneIndex);
			checkZone.cageList.add(newCage);
			result=true;
		}
		else
		{
			result=false;
		}
		return result;
	}
}



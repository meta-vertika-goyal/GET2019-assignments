import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TestAddAnimal {

	@Test
	public void testAddToZooAssertTrue() {
		Animal crocodile1=new Crocodile(30,1200,5);
		Animal crocodile2=new Crocodile(40,1000,6);
		Animal lion1=new Lion(8,120,false);
		Animal lion2=new Lion(10,150,true);
		Animal ostrich1=new Ostrich(1,45,"Savanna");
		Animal ostrich2=new Ostrich(45,125,"African native");
		Animal snake1=new Snake(1,0.1,1);
		Animal snake2=new Snake(3,0.3,2);
		Animal sparrow1=new Sparrow(1,0.01,"Passeridae");
		Animal sparrow2=new Sparrow(2,0.03,"Passeridae");
		Animal whale1=new Whale(1,135,43);
		Animal whale2=new Whale(4,3200,73);
		ArrayList<Animal> animalList=new ArrayList<Animal>();
		animalList.add(crocodile1);
		animalList.add(crocodile2);
		animalList.add(lion1);
		animalList.add(lion2);
		animalList.add(ostrich1);
		animalList.add(ostrich2);
		animalList.add(snake1);
		animalList.add(snake2);
		animalList.add(sparrow1);
		animalList.add(sparrow2);
		animalList.add(whale1);
		
		for(Animal animal:animalList)
		{
			Zoo.addToZoo(animal);
		}
		assertTrue(Zoo.addToZoo(whale2));
	}
	@Test
	public void testAddToZooAssertFalse() {
		Animal crocodile1=new Crocodile(30,1200,5);
		Animal crocodile2=new Crocodile(40,1000,6);
		Animal crocodile3=new Crocodile(35,1100,5);
		Animal lion1=new Lion(8,120,false);
		Animal lion2=new Lion(10,150,true);
		Animal ostrich1=new Ostrich(1,45,"Savanna");
		Animal ostrich2=new Ostrich(45,125,"African native");
		Animal snake1=new Snake(1,0.1,1);
		Animal snake2=new Snake(3,0.3,2);
		Animal sparrow1=new Sparrow(1,0.01,"Passeridae");
		Animal sparrow2=new Sparrow(2,0.03,"Passeridae");
		Animal whale1=new Whale(1,135,43);
		Animal whale2=new Whale(4,3200,73);
		ArrayList<Animal> animalList=new ArrayList<Animal>();
		animalList.add(crocodile1);
		animalList.add(crocodile2);
		animalList.add(lion1);
		animalList.add(lion2);
		animalList.add(ostrich1);
		animalList.add(ostrich2);
		animalList.add(snake1);
		animalList.add(snake2);
		animalList.add(sparrow1);
		animalList.add(sparrow2);
		animalList.add(whale1);
		
		for(Animal animal:animalList)
		{
			Zoo.addToZoo(animal);
		}
		assertFalse(Zoo.addToZoo(crocodile3));
	}


}

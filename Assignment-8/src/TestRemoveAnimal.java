import static org.junit.Assert.*;

import org.junit.Test;


public class TestRemoveAnimal {

	@Test
	public void testRemoveAnimalAssertTrue() {
		new TestAddAnimal().testAddToZooAssertTrue();
		Animal animal=new Crocodile(30,1200,5);
		Animal animal2=new Crocodile(40,1000,6);
		assertTrue(Zoo.removeAnimal(animal));
		assertTrue(Zoo.removeAnimal(animal2));
		
	}
	@Test
	public void testRemoveAnimalAssertFalse() {
		
		Animal animal=new Crocodile(3,1200,5);
		assertFalse(Zoo.removeAnimal(animal));
	}

}

import static org.junit.Assert.*;

import org.junit.Test;


public class TestAddCage {

	@Test
	public void testAddCageAssertFalse() {
		new TestAddAnimal().testAddToZooAssertTrue();
		assertFalse(Zoo.addCageToZone("Reptile"));
	}
	@Test
	public void testAddCageAssertTrue() {
		
		new TestRemoveAnimal().testRemoveAnimalAssertTrue();
		assertTrue(Zoo.addCageToZone("Reptile"));
	}
	
	

}

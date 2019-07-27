import static org.junit.Assert.*;

import org.junit.Test;


public class TestGetSound {

	@Test
	public void testGetSoundOfCrocodile() {
		Animal animal=new Crocodile();
		assertEquals("bellows",animal.getSound());
	}
	@Test
	public void testGetSoundOfSparrow() {
		Animal animal=new Sparrow();
		assertEquals("chirps",animal.getSound());
	}

}

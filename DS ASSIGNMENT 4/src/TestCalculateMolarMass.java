import static org.junit.Assert.*;

import org.junit.Test;


public class TestCalculateMolarMass {

	@Test
	public void testCalculateMolarMass1() {
		assertEquals(86,OrganicCompounds.calculateMolarMass("CHOC(CH3)3"));
	}
	@Test
	public void testCalculateMolarMass2() {
		assertEquals(46,OrganicCompounds.calculateMolarMass("C(OH)2"));
	}
	@Test(expected=AssertionError.class)
	public void testCalculateMolarMassForInvalidChemicalFormula1() {
		OrganicCompounds.calculateMolarMass("COH)2");
	}
	@Test(expected=AssertionError.class)
	public void testCalculateMolarMassForInvalidChemicalFormula2() {
		OrganicCompounds.calculateMolarMass("CHOC(CH33");
	}


}

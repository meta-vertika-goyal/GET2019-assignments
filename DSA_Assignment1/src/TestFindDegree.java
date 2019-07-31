import static org.junit.Assert.*;

import org.junit.Test;
public class TestFindDegree {
	@Test
	public void testDegree()
	{
		MultivariatePolynomial.createPolynomial();
		MultivariatePolynomial.printPolynomial();
		assertEquals(3,MultivariatePolynomial.findDegree());
	}

}

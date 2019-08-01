import static org.junit.Assert.*;

import org.junit.Test;


public class TestEvaluateExpression {

	@Test
	public void testEvaluateExpressionForArithMetic() {
		String actualResult=EvaluateExpression.findResult("( 2 + 3 * 6 )");
		System.out.println(actualResult);
		
		assertEquals("20.0",actualResult);
	}
	@Test
	public void testEvaluateExpressionForRelational() {
		String actualResult=EvaluateExpression.findResult("( 2 + 3 < 6 )");
		System.out.println(actualResult);
		assertEquals("true",actualResult);
	}
	@Test
	public void testEvaluateExpressionForLogical() {
		String actualResult=EvaluateExpression.findResult("( 2 + 3 || 6 )");
		System.out.println(actualResult);
		assertEquals("true",actualResult);
	}
	@Test
	public void testEvaluateExpressionForParanthesis() {
		String actualResult=EvaluateExpression.findResult("( ( 2 + 3 ) * 6 )");
		System.out.println(actualResult);
		assertEquals("30.0",actualResult);
	}
	

}

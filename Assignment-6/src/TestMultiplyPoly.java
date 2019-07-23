import static org.junit.Assert.*;
import org.junit.Test;
public class TestMultiplyPoly {
	@Test
	public void testAddPoly() {
		Term term1=new Term(5,3);
		Term term2=new Term(2,2);
		Term term3=new Term(8,0);
		Term[] polynomial=new Term[3];
		polynomial[0]=term1;
		polynomial[1]=term2;
		polynomial[2]=term3;		
		Poly poly1=new Poly(polynomial,3);
		Term termTwo1=new Term(8,4);
		Term termTwo2=new Term(4,2);
		Term termTwo3=new Term(5,1);
		Term termTwo4=new Term(16,0);
		Term[] polynomial2=new Term[4];
		polynomial2[0]=termTwo1;
		polynomial2[1]=termTwo2;
		polynomial2[2]=termTwo3;	
		polynomial2[3]=termTwo4;
		Poly poly2=new Poly(polynomial2,4);
		Poly actualSumPoly=poly1.multiplyPoly(poly1,poly2);
		Term termThree1=new Term(40,7);
		Term termThree2=new Term(16,6);
		Term termThree3=new Term(20,5);
		Term termThree4=new Term(97,4);
		Term termThree5=new Term(90,3);
		Term termThree6=new Term(64,2);
		Term termThree7=new Term(40,1);
		Term termThree8=new Term(128,0);
		Term[] expectedResult=new Term[8];
		expectedResult[0]=termThree1;
		expectedResult[1]=termThree2;
		expectedResult[2]=termThree3;
		expectedResult[3]=termThree4;
		expectedResult[4]=termThree5;
		expectedResult[5]=termThree6;
		expectedResult[6]=termThree7;
		expectedResult[7]=termThree8;
		Poly expectedSum=new Poly(expectedResult,8);
        for(int i=0;i<actualSumPoly.polynomial.length;i++)
        {
        	Term temp=actualSumPoly.polynomial[i];
        	Term temp2=expectedResult[i];
        	assertEquals(temp.coefficient,temp2.coefficient);
        	assertEquals(temp.exponent,temp2.exponent);
        }
	}
}

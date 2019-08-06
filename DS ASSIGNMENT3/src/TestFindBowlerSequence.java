import static org.junit.Assert.*;

import org.junit.Test;


public class TestFindBowlerSequence {

	@Test
	public void testFindBowlerSequence() {
		Bowler[] bowlerList=new Bowler[3];
		bowlerList[0]=new Bowler("B01",2);
		bowlerList[1]=new Bowler("B02",3);
		bowlerList[2]=new Bowler("B03",4);
		assertEquals("B03 B02 B03 B02 B03 B01 B03 B01 B02",BowlerHeap.findSequence(bowlerList.length, bowlerList, 9));
	}
	@Test(expected=AssertionError.class)
	public void testFindBowlerSequenceForZeroBalls() {
		Bowler[] bowlerList=new Bowler[3];
		bowlerList[0]=new Bowler("B01",2);
		bowlerList[1]=new Bowler("B02",3);
		bowlerList[2]=new Bowler("B03",4);
		BowlerHeap.findSequence(bowlerList.length, bowlerList, 0);

	}
	@Test(expected=AssertionError.class)
	public void testFindBowlerSequenceForZeroBowlers() {
		Bowler[] bowlerList=new Bowler[3];
		BowlerHeap.findSequence(bowlerList.length, bowlerList, 0);

	}



}

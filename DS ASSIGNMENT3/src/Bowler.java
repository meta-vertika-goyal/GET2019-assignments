/**
 * Bowler is the class representing each bowler
 * @author Vertika
 *
 */
public class Bowler {
	private String id;
	private int ballQuota;
	/**
	 * parameterized constructor for Bowler
	 * @param id unique id of each bowler
	 * @param ballQuota number of balls assigned to each bowler
	 */
	public Bowler(String id, int ballQuota ) {
		this.id = id;
		this.ballQuota = ballQuota;
	}
	/**
	 * getter for id
	 * @return String id
	 */
	public String getId ( ){
		return id;
	}
	/**
	 * getter for ball quota
	 * @return integer value of ball quota of each bowler
	 */
	public int getBallQuota ( ){
		return ballQuota;
	}
	/**
	 * reduces the ball quota by 1 at every ball bowled by that bowler
	 */
	public void setBallQuota(){
		ballQuota--;
	}
}

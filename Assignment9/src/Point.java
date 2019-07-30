public class Point {
	double x;
	double y;
        /**
         * This is a constructor to set the initial values of the point
         *@param x is the x coordinate of the point
         *@param y is the y coordinate of the point
         */
	Point(double x,double y)
	{
		this.x=x;
		this.y=y;
	}
	/**
	 * Default constructor
	 */
	public Point() {
		x=0;
		y=0;
	}

}
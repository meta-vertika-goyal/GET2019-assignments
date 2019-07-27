public class Sparrow extends Bird{
	String family;
	/*
	 * Parameterized constructor to set the attributes of the sparrow
	 * @param age is the age of the sparrow
	 * @param weight is the weight of the sparrow
	 * @param family is the family name to which the sparrow belongs
	 */
	Sparrow(int age,double weight,String family)
	{
		super("Sparrow",age,weight,"chirps",true);
		this.family=family;
	}
	/*
	 * Default constructor 
	 */
	Sparrow()
	{
		super("Sparrow","chirps",true);
	}
}

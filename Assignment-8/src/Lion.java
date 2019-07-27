
public class Lion extends Mammal{
	boolean hasMane;
	/*
	 * Parameterized constructor to set the attributes of the lion
	 * @param age is the age of the lion
	 * @param weight is the weight of the lion
	 * @param hasMane is true is the lion has a mane else is false
	 */
	public Lion(int age, double weight,boolean hasMane){
		super("Lion", age, weight,"roars",true);
		this.hasMane=hasMane;
	}
	/*
	 * Default constructor 
	 */
	Lion()
	{
		super("Lion","roars",true);
	}

}

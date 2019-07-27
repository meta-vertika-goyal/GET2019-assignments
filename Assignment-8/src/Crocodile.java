
public class Crocodile extends Reptile{
	double length;                                  //length of crocodile
	/*
	 * Parameterized constructor to set the attributes of the crocodile
	 * @param age is the age of the crocodile
	 * @param weight is the weight of the crocodile
	 * @param length is the length of the crocodile
	 */
	Crocodile(int age,double weight,double length)
	{
		super("Crocodile",age,weight,"bellows",true);
		this.length=length;
	}
	/*
	 * Default constructor 
	 */
	Crocodile()
	{
		super("Crocodile","bellows",true);
	}
}

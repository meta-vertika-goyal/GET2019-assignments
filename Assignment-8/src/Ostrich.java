
public class Ostrich extends Bird{
	String ostrichCategory;
	/*
	 * Parameterized constructor to set the attributes of the ostrich
	 * @param age is the age of the ostrich
	 * @param weight is the weight of the ostrich
	 * @param ostrichCategory is the category of ostric if savanna or african native
	 */
	Ostrich(int age,double weight,String ostrichCategory)
	{
		super("Ostrich",age,weight,"low hum",false);
		this.ostrichCategory=ostrichCategory;
	}
	/*
	 * Default constructor 
	 */
	Ostrich()
	{
		super("Ostrich","low hum",false);
	}

}

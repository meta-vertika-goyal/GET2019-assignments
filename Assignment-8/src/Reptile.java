
public class Reptile extends Animal{
	boolean hasVision;
	/*
	 * Parameterized Constructor to set the reptile details
	 * @param name is the unique name of the reptile
	 * @param age is the age of the reptile
	 * @param weight is the weight of the reptile
	 * @param sound is the sound made by the reptile
	 * @param hasVision is false if the reptile does not have vision else is true
	 */
	public Reptile(String name, int age, double weight,String sound,boolean hasVision) {
		super("Reptile",name,age,weight,sound);
		this.hasVision=hasVision;
	}
	/*
	 * Parameterized Constructor to set the reptile details
	 * @param name is the unique name of the reptile
	 * @param sound is the sound made by the reptile
	 * @param hasVision is false if the reptile does not have vision else is true
	 */
	Reptile(String name,String sound,boolean hasVision)
	{
		super("Reptile",name,sound);
		this.hasVision=hasVision;
	}
}

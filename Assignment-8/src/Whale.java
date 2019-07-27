
public class Whale extends Mammal{
	double decibelSound;
	/*
	 * Parameterized constructor to set the attributes of the whale
	 * @param age is the age of the whale
	 * @param weight is the weight of the whale
	 * @param decibelSound is the measure of the sound made by the whale in decibels
	 */
	Whale(int age, double weight,double decibelSound)
	{
		super("Whale",age,weight,"clicks",false);
		this.decibelSound=decibelSound;
	}
	/*
	 * Default constructor 
	 */
	Whale()
	{
		super("Whale","clicks",false);
	}
}

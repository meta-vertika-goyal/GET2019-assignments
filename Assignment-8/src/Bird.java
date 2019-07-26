public class Bird extends Animal{
	boolean canFly;
	/*
	 * Parameterized Constructor to set the bird details
	 * @param name is the unique name of the bird
	 * @param age is the age of the bird
	 * @param weight is the weight of the bird
	 * @param sound is the sound made by the bird
	 * @param canFly is false if the bird is flightless else returns true
	 */
	public Bird(String name, int age, double weight,String sound,boolean canFly) {
		super("Bird",name,age,weight,sound);
		this.canFly=canFly;
	}
	/*
	 * Parameterized Constructor to set the bird details
	 * @param name is the unique name of the bird
	 * @param sound is the sound made by the bird
	 * @param canFly is false if the bird is flightless else returns true
	 */
	public Bird(String name, String sound, boolean canFly) {
		super("Bird",name,sound);
		this.canFly=canFly;
	}
}

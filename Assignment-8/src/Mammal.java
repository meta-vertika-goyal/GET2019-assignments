public class Mammal extends Animal {
	boolean hasSweatGlands;
	/*
	 * Parameterized Constructor to set the mammal details
	 * @param name is the unique name of the mammal
	 * @param age is the age of the mammal
	 * @param weight is the weight of the mammal
	 * @param sound is the sound made by the mammal
	 * @param hasSweatGlands is false if the mammal does not have sweat glands else is true
	 */
	public Mammal(String name, int age, double weight,String sound,boolean hasSweatGlands) {
		super("Mammal",name,age,weight,sound);
		this.hasSweatGlands=hasSweatGlands;
	}
	/*
	 * Parameterized Constructor to set the mammal details
	 * @param name is the unique name of the mammal
	 * @param sound is the sound made by the mammal
	 * @param hasSweatGlands is false if the mammal does not have sweat glands else is true
	 */
	public Mammal(String name, String sound, boolean hasSweatGlands) {
		super("Mammal",name,sound);
		this.hasSweatGlands=hasSweatGlands;
	}
}
public class Animal {
	String name;
	String category;
	String sound;
	int age;
	double weight;
	/*
	 * Parameterized Constructor to set the animal details
	 * @param category states whether the animal belongs to mammal,reptile or bird category
	 * @param name is the unique name of the animal
	 * @param age is the age of the animal
	 * @param weight is the weight of the animal
	 * @param sound is the sound made by the animal
	 */
	Animal(String category, String name, int age, double weight, String sound)
	{
		this.category=category;
		this.name=name;
		this.age=age;
		this.weight=weight;
		this.sound=sound;
	}
	/*
	 * Parameterized Constructor to set the animal details
	 * @param category states whether the animal belongs to mammal,reptile or bird category
	 * @param name is the unique name of the animal
	 * @param sound is the sound made by the animal
	 */
	public Animal(String category, String name, String sound) {
		this.category=category;
		this.name=name;
		this.sound=sound;
	}
	public String getSound()
	{
		return this.sound;
	}
}



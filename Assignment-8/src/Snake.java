public class Snake extends Reptile {
	int numberOfHeads;
	/*
	 * Parameterized constructor to set the attributes of the snake
	 * @param age is the age of the snake
	 * @param weight is the weight of the snake
	 * @param numberOfHeads is the number of heads of the snake
	 */
	Snake(int age,double weight,int numberOfHeads)
	{
		super("Snake",age,weight,"hiss",false);
		this.numberOfHeads=numberOfHeads;
	}
	/*
	 * Default constructor 
	 */
	Snake()
	{
		super("Snake","hiss",false);
	}
}

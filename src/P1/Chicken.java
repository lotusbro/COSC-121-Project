package P1;

public class Chicken extends Animal 
{
	static int count=1;
	public Chicken()
	{
		super();
		setName("Chicken"+count);
		setMealAmount(5.0);
		setSpeedX(0.5);
		setSpeedY(0.5);
		count++;
	}
	public void sound()
	{
		if(isAlive()==true)
			System.out.println("Cluck!");
			else
			System.out.println();
	}
	public void swim()
	{
		System.out.println("Special Ability: Swimming");
	}
}

package P1;

public class Llama extends Animal
{
	static int count=1;
	public Llama()
	{
		super();
		setName("Llama"+count);
		setMealAmount(9.0);
		setSpeedX(1);
		setSpeedY(1);
		count++;
	}
	public void sound()
	{
		if(isAlive()==true)
			System.out.println("Hmmm!");
			else
			System.out.println();
	}
	public void jump()
	{
		System.out.println("Special Ability: Jumping");
	}
}

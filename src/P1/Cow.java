package P1;

public class Cow extends Animal
{
static int count=1;
	public Cow()
	{
		super();
		setName("Cow"+count);
		setMealAmount(20.0);
		setSpeedX(2.0);
		setSpeedY(2.0);
		count++;
	}
	public void sound()
	{
		if(isAlive()==true)
		System.out.println("Moo!");
		else
		System.out.println();
	}
	public void milk()
	{
		System.out.println("Special Ability: Milking");
	}
	
}

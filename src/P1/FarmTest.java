package P1;

import java.util.Arrays;

public class FarmTest {

	public static void main(String[] args) 
	{
	Farm myFarm= new Farm();
	for(Animal a: myFarm.getAnimals())
	{
		for(int i=0;i<(int)(Math.random()*1000);i++)
		{
			a.move();
		}
	}
	System.out.println("Before feeding: "+myFarm.getAvailableFood());
	myFarm.feedAnimals();
	System.out.println("After feeding: "+myFarm.getAvailableFood());
	myFarm.makeNoise();
	myFarm.getAnimals()[0].speak("Hello!!");
	System.out.println(Arrays.toString(myFarm.getAnimals()));
	}

}

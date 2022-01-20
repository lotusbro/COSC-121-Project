package P3;

import java.io.Serializable;

public class Chicken extends Animal implements Serializable{
	private static int id;
	public Chicken() {
		setName("Chicken" + ++id);
		setMealAmount(5);
	}
	public void sound(){
		if(isAlive()) System.out.println("Cluck!");
	}
	public void swim(){
		if(isAlive()) System.out.println("Chicken can swim as following:...!");
	}
}

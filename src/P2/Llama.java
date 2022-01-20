package P2;

public class Llama extends Animal{
	private static int id;
	public Llama() {
		setName("Llama" + ++id);
		setMealAmount(3);
	}
	public void sound(){
		if(isAlive()) System.out.println("Hmmm!");
	}
	public void jump(){
		if(isAlive()) System.out.println("Llamas can jump as following:...!");
	}
}

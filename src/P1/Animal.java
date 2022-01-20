package P1;

public class Animal {
	private String name;
	private double energy;
	private boolean alive;
	private double mealAmount;
	private double x, y;
	private double speedX, speedY;

	public Animal() {
		energy = 100;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getEnergy() {
		if (energy >= 0 && energy <= 100)
			return energy;
		else
			return 0;
	}

	public void setEnergy(double energy) {
		if (energy >= 17 && energy <= 50)
			System.out.println(getName() + " is hungry.");
		else
			this.energy = energy;
	}

	public boolean isAlive() {
		if (energy > 0)
			return alive = true;
		else
			return alive = false;
	}

	public double getMealAmount() {
		if (mealAmount >= 0 && mealAmount <= 100)
			return mealAmount;
		else
			return 0;
	}

	public void setMealAmount(double mealAmount) {
		if (mealAmount >= 0 && mealAmount <= 100)
			this.mealAmount = mealAmount;
		else
			mealAmount = 0;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}

	public void move() {
		if (energy >= 0.0) {
			x += speedX;
			y += speedY;
			energy -= 0.1;

		} else {
			System.out.println(getName() + " can't move. It is dead!");
		}
	}

	public void speak(String msg) {
		if (isAlive() == true)
			System.out.println(getName() + " says:" + msg);
		else
			System.out.println(getName() + " is dead");
	}

	public void sound() {
		if (isAlive() == true)
			System.out.println("Unknown");
		else
			System.out.println(getName() + " is dead");
	}

	public double eat() {
		double remainder = getMealAmount();
		if (isAlive() == false)
			System.out.println(getName() + " is dead!");
		else {
			if (getEnergy() == 100)
				System.out.println(getName() + " didn't eat as it is full!");

			else if ((getEnergy() + remainder) <= 100) {
				System.out.println(getName() + " ate " + remainder + " units");
				setEnergy(energy + remainder);
			} else {
				remainder = energy + remainder - 100;
				remainder=Math.round(remainder*100.0)/100.0;
				System.out.println(getName() + " ate " + remainder + " units, now it is full");
				setEnergy(100);
			}
		}
		return remainder;

	}

	public String toString() {
		return getName() + ":" + " alive at (" + getX() + "," + getY() + ")" + "  Energy="
				+ (Math.round(getEnergy() * 100.0) / 100.0);
	}
}

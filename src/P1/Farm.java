package P1;

public class Farm extends Animal {
	private double availableFood;
	private Animal[] animals;

	public Farm() {
		setAvailableFood(1000);
		animals = new Animal[4];
		animals[0] = new Chicken();
		animals[1] = new Cow();
		animals[2] = new Llama();
		animals[3] = new Llama();
	}

	public double getAvailableFood() {
		if (availableFood >= 0 && availableFood <= 1000)
			return Math.round(availableFood*100.0)/100.0;
		else
			return 0;

	}

	public void setAvailableFood(double availableFood) {
		if (this.availableFood >= 0 && this.availableFood <= 1000)
			this.availableFood = Math.round(availableFood*100.0)/100.0;
		else
			this.availableFood = availableFood = 0;
	}

	public Animal[] getAnimals() {
		return animals;
	}

	public void makeNoise() {
		for (int i = 0; i < animals.length; i++) {
			animals[i].sound();
		}
	}

	public void feedAnimals() {
		for (int i = 0; i < animals.length; i++) {
			if (getAvailableFood() >= animals[i].getMealAmount()) {
				double ateFood = animals[i].eat();
				availableFood -= ateFood;
			} else {
				System.out.println("There is not enough food in the farm");
			}
		}
	}
}

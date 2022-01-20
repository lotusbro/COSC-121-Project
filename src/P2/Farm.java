package P2;

import java.util.Arrays;

public class Farm {
	private double availableFood;
	private Animal[] animals = new Animal[100];

	public Farm() {
		setAvailableFood(1000);
		add(new Chicken());
		add(new Cow());
		add(new Llama());
		add(new Llama());
	}

	public boolean add(Animal anim) {
		for (int i = 0; i < animals.length; i++) {
			if ((animals[i] == null)) {
				animals[i] = anim;
				return true;
			}
		}
		return false;
	}

	public void makeNoise() { // all animals make their sound (Moo, Cluck, etc)
		for (Animal animal : animals)
			animal.sound();
	}

	public void feedAnimals() { // restore energy of all animals and deduct amount eaten from availableFood
		for (Animal animal : animals)
			if (availableFood >= Math.min(animal.getMealAmount(), (100 - animal.getEnergy())))
				// no penalty if student uses: if(availableFood >= animal.getMealAmount())
				availableFood -= animal.eat();
			else
				System.out.println("Not enough food for your animals! You need to collect more food items.");
	}

	public double getAvailableFood() {
		return availableFood;
	}

	public void setAvailableFood(double availableFood) {
		if (availableFood >= 0 && availableFood <= 1000)
			this.availableFood = availableFood;
	}

	public Animal[] getAnimals() {
		int count = 0;
		for (int i = 0; i < animals.length; i++) {
			if ((animals[i] != null)) {
				count++;

			}
		}
		Animal[] animal = new Animal[count];
		for (int i = 0; i < animals.length; i++) {
			if ((animals[i] != null)) {
				animal[i] = animals[i];
			}
		}
		return animal;
	}

	public void animSort() {
		Animal[] animalTemp = getAnimals();
		Arrays.sort(animalTemp);
		for (int i = 0; i < animalTemp.length; i++)
			animals[i] = animalTemp[i];
	}

	public boolean addClone(Animal anim) {
		return add(anim);

	}

	public void printAnimals() {
		Animal[] animal = getAnimals();
		for (int i = 0; i < animal.length; i++) {
			if (animal[i].isAlive() == true)
				System.out.println(animal[i].getName() + ":" + "alive at" + "(" + animal[i].getX() + ","
						+ animal[i].getY() + ")" + " Energy=" + (Math.round(animal[i].getEnergy() * 10.0) / 10.0));
			else
				System.out.println(animal[i].getName() + ":" + "dead at" + "(" + animal[i].getX() + ","
						+ animal[i].getY() + ")" + " Energy=" + animal[i].getEnergy());
		}

	}

	public void displaySummary() {
		int total = getNumChicken() + getNumCows() + getNumllamas();
		System.out.println("The farm has:");
		System.out.println("- " + total + "(" + getNumChicken() + " Chicken, " + getNumCows() + " Cows, " + "and "
				+ getNumllamas() + " Llamas" + ")");
		System.out.println("- " + (int) getAvailableFood() + " units of available food");
	}

	public int getNumChicken() {
		int count = 0;
		for (int i = 0; i < animals.length; i++) {
			if (animals[i] instanceof Chicken) {
				count++;
			}
		}
		return count;
	}

	public int getNumCows() {
		int count = 0;
		for (int i = 0; i < animals.length; i++) {
			if (animals[i] instanceof Cow) {
				count++;
			}
		}
		return count;

	}

	public int getNumllamas() {
		int count = 0;
		for (int i = 0; i < animals.length; i++) {
			if (animals[i] instanceof Llama) {
				count++;
			}
		}
		return count;
	}

}

package P4_Soln;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

// This class has many changes compared to P4 because of the use of the linked list. for example:
// - getAnimal simply returns animals since the linkedlist will not have nulls
// - animalCount is not needed - we will track the count in the linked list (AnimalList)
// - addClone and add are now void (no limit on the linkedlist size)
// - Also, do not implement animSort for now. we are going to learn sorting algorithms later in the coure.
public class Farm {
	private double availableFood;
	private AnimalList animals;						// [+1] change: AnimalList instead of arrays
	//private final int MAX_ANIMAL_COUNT = 100;		// change: not needed! should be removed.
	//private int animalsCount = 0;					// change: not needed
	public Farm(String filename) {					// same as P4 starter
		load(filename);
	}
	public void exit(String filename) {				// [+1] almost same as P4 starter, but we don't use animalsCount
		//save data to filename before leaving
		try (ObjectOutput out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(filename)))) {
			
			out.writeDouble(availableFood);
			out.writeObject(animals);
			System.out.println("Data saved successfully to " + filename + ".");
		} catch (FileNotFoundException e) {
			System.err.println("Cannot save you status!" + e.getMessage());
		} catch (IOException e) {
			System.err.println("I/O Error" + e.getMessage());
		}
	}
	public void load(String filename) {				// [+4] many changes due to the use of arraylist
		//load current player status from filename
		File file = new File(filename);
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(file)))) {
			
			availableFood = in.readDouble();
			animals = (AnimalList) in.readObject();
			System.out.println("Data loaded from " + filename + ".");
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open file. Using default values!");
			setAvailableFood(1000);
			animals = new AnimalList();
			animals.add(new Chicken());
			animals.add(new Cow());
			animals.add(new Llama());
			animals.add(new Llama());
			animals.add(new Llama());
		} catch (IOException e) {
			System.err.println("I/O Error" + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println("Internal Error!" + e.getMessage());
		}
	}
	public void makeNoise() {						//same as before			
		for (Animal animal : getAnimals())	
			animal.sound();
	}
	public void feedAnimals(){ 						//same as before	
		for (Animal animal : getAnimals())	
			if(availableFood >= Math.min(animal.getMealAmount(), (100-animal.getEnergy()))) 
				availableFood -= animal.eat();
			else
				System.out.println("Not enough food for your animals! You need to collect more food items.");
	}
	public void animSort(){ 						// TODO later: implement a sorting algorithm. We may also move animSort to AnimalList class - but you don't have to do this now.
		System.out.println("Not supported yet.");	
	}
	public void addClone(Animal anim) throws CloneNotSupportedException { 	// [+0.5] change: returns void
		add( (Animal) anim.clone());		
	}
	public void add(Animal anim){ 					// [+0.5] change: returns void, doesn't check size of animals
		animals.add(anim);
	}
	public void printAnimals() {					// [+1] change: print animals using the list's toString
		System.out.println(animals);
	}
	public int getNumChicken() {					
		int num=0; 
		for(Animal a: getAnimals())
			if(a instanceof Chicken) num++;		
		return num;
	}
	public int getNumCows() {						
		int num=0; 
		for(Animal a: getAnimals())
			if(a instanceof Cow) num++;		
		return num;
	}
	public int getNumLlamas() {						
		int num=0; 
		for(Animal a: getAnimals())
			if(a instanceof Llama) num++;		
		return num;
	}
	public void printSummary() {					// [+1] change: use animals.size() instead of animalsCount
		System.out.println("The farm has:");	
		System.out.printf("- %d animals (%d Chicken, %d Cows, and %d Llamas)\n", animals.size(), getNumChicken(), getNumCows(), getNumLlamas());
		System.out.printf("- %.2f units of available food\n", availableFood);
	}
	public double getAvailableFood() {
		return availableFood;
	}
	public void setAvailableFood(double availableFood) {
		if(availableFood>=0 && availableFood<=1000)
			this.availableFood = availableFood;
	}
	public AnimalList getAnimals() {				// [+2] change: we are returning the whole linkedList here!
		return animals;
	}
}






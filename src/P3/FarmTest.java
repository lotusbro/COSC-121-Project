package P3;

public class FarmTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		Farm myFarm = new Farm("c:/4/stat.dat");
		myFarm.printSummary();
		for(Animal a: myFarm.getAnimals())
			a.setEnergy(Math.random()*100);
		System.out.println("\nAvailable food before feeding: "+myFarm.getAvailableFood()+"\n");
		System.out.println("\nInitial list of animals:\n-------------------------");
		myFarm.printAnimals();
		System.out.println("\nAdding a clone of the second animal\n-----------------------------------");
		myFarm.addClone(myFarm.getAnimals()[1]);
		myFarm.printAnimals();
		myFarm.feedAnimals();
		System.out.println("\nAvailable food after feeding: "+myFarm.getAvailableFood()+"\n");
		System.out.println("\nAfter SORTING:\n--------------");
		myFarm.animSort();
		myFarm.printAnimals();
		System.out.println("\nFarm summary:\n--------------");
		myFarm.printSummary();
		myFarm.exit("c:/4/stat.dat");
		//This happens because we keep overwriting stat.dat multiple times.
		//For example the first time we run the test method at the end we had 5 animals because of cloning which is saved to stat.dat
		//We load from this again the second time we run it begins with 5 animals because it is saved as 5 animals last time we ran it. 
	}
}

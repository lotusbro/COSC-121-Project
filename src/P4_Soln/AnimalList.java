package P4_Soln;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class AnimalList implements Iterable<Animal>, Serializable{
	private int size = 0;
	private AnimalNode head = null, tail = null;

	// STANDARD LIST METHODS:
	public boolean isEmpty() {
		return (size == 0);
	}
	public int size() {
		return size;
	}
	public void addFirst(Animal animal) {
		AnimalNode n = new AnimalNode(animal);
		if (isEmpty())
			head = tail = n;
		else {
			n.next = head;
			head = n;
		}
		size++;
	}
	public void addLast(Animal animal) {
		AnimalNode n = new AnimalNode(animal);
		if (isEmpty())
			head = tail = n;
		else {
			tail.next = n;
			tail = n; // tail = tail.next;
		}
		size++;
	}
	public void add(int index, Animal animal) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		else if (index == 0)
			addFirst(animal);
		else if (index == size)
			addLast(animal);
		else {
			AnimalNode node = new AnimalNode(animal);
			// get a reference to element at index-1
			AnimalNode current = head;
			for (int i = 0; i < index - 1; i++)
				current = current.next;
			node.next = current.next;
			current.next = node;
		}
		size++;
	}
	public void add(Animal animal) {
		addLast(animal);
	}
	public Animal removeFirst() {
		if (isEmpty())
			return null;
		// OR throw new NoSuchElementException();
		else {
			AnimalNode temp = head;
			head = head.next;
			if (head == null)
				tail = null;
			size--;
			return temp.animal;
		}
	}
	public Animal removeLast() {
		if (isEmpty())
			return null;
		// OR throw new NoSuchElementException();
		else if (size == 1)
			return removeFirst();
		else { // more than one element
			// temp save last node in order to return it
			AnimalNode temp = tail;
			// get a reference to node at size-2
			AnimalNode current = head;
			for (int i = 0; i < size - 2; i++)
				current = current.next;
			// move tail to current
			tail = current;
			tail.next = null;
			size--;
			// return last node
			return temp.animal;
		}
	}
	public Animal remove(int index) {
		if (index < 0 || index > size - 1)
			throw new IndexOutOfBoundsException();
		else if (index == 0)
			return removeFirst();
		else if (index == size - 1)
			return removeLast();
		else {
			AnimalNode prev = head;
			for (int i = 0; i < index - 1; i++)
				prev = prev.next;
			AnimalNode current = prev.next;
			prev.next = current.next;
			size--;
			return current.animal;
		}
	}
	public Animal getFirst() {
		if (isEmpty())
			return null;
		else
			return head.animal;
	}
	public Animal getLast() {
		if (isEmpty())
			return null;
		else
			return tail.animal;
	}
	public Animal get(int index) {
		if(index<0||index>=size) return null;
		else if(index==0) return getFirst();
		else if(index==size-1) return getLast();
		else {
			AnimalNode current = head;
			for(int i=0;i<index;i++)
				current = current.next;
			return current.animal;
		}
	}
    public Animal set(int index, Animal animal) {
		if (index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		else{
			AnimalNode current = head;
			for(int i=0;i<index;i++)
				current = current.next;
	        Animal oldVal = current.animal;
	        current.animal = animal;
	        return oldVal;
		}
	}
	public String toString(){
		StringBuffer s = new StringBuffer("");
		AnimalNode current = head;
		for(int i = 0; i < size; i++){
			s.append(current.animal.toString()+"\n");
			current = current.next;
		}
		return s.toString();
	}	
	//CUSTOM METHODS
	//get list of hungry or starving animals 
	public AnimalList getHungryAnimals() {
		AnimalList list = new AnimalList();
		for(Animal a: this)
			if(a.getEnergy()<50)
				list.add(a);
		if(list.size>0)
			return list;
		else
			return null;
	}
	public AnimalList getStarvingAnimals() {
		AnimalList list = new AnimalList();
		for(Animal a: this)
			if(a.getEnergy()<17)
				list.add(a);
		if(list.size>0)
			return list;
		else
			return null;
	}
	//get list of animals that are inside the barn located between (50,150),(50,150)
	public AnimalList getAnimalsInBarn() {
		AnimalList list = new AnimalList();
		for(Animal a: this)
			if(a.getX()>450 && a.getX()<550 && a.getY()>50 && a.getY()<150)
				list.add(a);
		if(list.size>0)
			return list;
		else
			return null;
	}
	
	//get amount of food required to feed all animals
	public double getRequiredFood() {
		double amount = 0;
		for(Animal a: this)
			amount += 100 - a.getEnergy();
		return amount;
	}
	
	//BONUS: getByType where you pass a type (i.e. class) and return a new AnimalList with only specified type
	public AnimalList getByType(Class type) {
		AnimalList list = new AnimalList();
		for(Animal a: this)
			if(a.getClass().equals(type))
				list.add(a);
		if(list.size>0)
			return list;
		else
			return null;
	}

	
	// ITERATOR
	public Iterator<Animal> iterator() {
		return new MyIterator();
	}
	class MyIterator implements Iterator<Animal>, Serializable {
		private AnimalNode current = head;

		public boolean hasNext() {
			return (current != null);
		}

		public Animal next() {
			if(current == null) throw new NoSuchElementException();
			Animal tmp = current.animal;
			current = current.next;
			return tmp;
		}
	}
	//NODE
	class AnimalNode implements Serializable {
		Animal animal;
		AnimalNode next;
		public AnimalNode(Animal animal) {
			this.animal = animal;
		}
	}
}

package P4_Soln;

public class AnimalListTest {
	public static void main(String[] args) {
		AnimalList list = new AnimalList();
		list.add(new Cow());
		list.add(new Chicken());
		list.add(new Chicken());
		list.add(new Llama());

		System.out.println(list);
		System.out.println(list.getByType(Cow.class));
	}
}

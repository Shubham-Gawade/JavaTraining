
public class Cage<E extends Animal & Eat> {

	E animal1;
	E animal2;

	public Cage() {
	}

	public Cage(E animal1, E animal2) {
		this.animal1 = animal1;
		this.animal2 = animal2;
	}

	public Object getAnimal1() {
		return animal1;
	}

	public void setAnimal1(E animal1) {
		this.animal1 = animal1;
	}

	public E getAnimal2() {
		return animal2;
	}

	public void setAnimal2(E animal2) {
		this.animal2 = animal2;
	}
	
	public static <E extends Animal>boolean isCompatible(E animal1, E animal2) {
		return animal1.type.equals(animal2.type);
	}
	
	public void callEat() {
		animal1.eats();
	}
	
	@Override
	public String toString() {
	return animal1 +"   "+animal2;
	}

}

class Monkey extends Animal implements Eat{
	
	@Override
	public String toString() {
		return "I am a Monkey";
	}

	@Override
	public void eats() {
	System.out.println("Monkey Eats");
		
	}

}

class Lion extends Animal implements Eat{
	
	@Override
	public String toString() {
		return "I am a Lion";
	}
	@Override
	public void eats() {
	System.out.println("Lion Eats");
		
	}

}

class Animal{

	protected String type;
}

interface Eat{
	void eats();
}









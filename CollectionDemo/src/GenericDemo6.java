import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GenericDemo6 {
	
	public static void main(String[] args) {
		
		Cage<Monkey> cage=new Cage<>();
		Monkey monkey1=new Monkey();
		monkey1.type="Big";
		Monkey monkey2=new Monkey();
		monkey2.type="Big";
		
		cage.setAnimal1(monkey1);
		cage.setAnimal2(monkey2);
		
		System.out.println(cage.isCompatible(monkey1,monkey2));
		
		monkey1.eats();
		
	}

}

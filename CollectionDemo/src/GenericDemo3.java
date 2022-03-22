import java.util.List;

public class GenericDemo3 {
	
	public static void main(String[] args) {
		
		Cage<Monkey> cage =new Cage<>();
		cage.setAnimal1(new Monkey());
		cage.setAnimal2(new Monkey());
		
		System.out.println(cage);
		
		
		Cage<Lion> cage2 =new Cage<>();
		cage2.setAnimal1(new Lion());
		cage2.setAnimal2(new Lion());
		
		System.out.println(cage2);
		
	}

}

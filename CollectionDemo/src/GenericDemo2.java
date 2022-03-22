import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Summation of integers stored in a collection object
 * 
 * @author Khan_sa
 *
 */
public class GenericDemo2 {
	
		
	public static void main(String[] args) {
		
		//Is generic a compile time construct or runtime construct???
		//Type Erasure
		
		List<Integer> numbers=new ArrayList<>();
		addNumbers(numbers, 20);
		addNumbers(numbers, "Saheer");
		System.out.println(numbers);
		
		
		String []names=new String[2];
		addToArray(names, "Saheer");
		addToArray(names, 10);
		
		
	}

	private static void addToArray(String[] names, String string) {
		names[0]=string;
	}
	
	private static void addToArray(String[] names, Object num) {
		names[1]=(String)num;
	}

	private static void addNumbers(List numbers, String string) {
	numbers.add(string);		
	}

	private static void addNumbers(List<Integer> numbers, int i) {
		numbers.add(i);
	}
	
	

}








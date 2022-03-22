import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * Summation of integers stored in a collection object
 * 
 * @author Khan_sa
 *
 */
public class GenericDemo5 {
	

	
	public static void main(String[] args) {
		
		//Is generic a compile time construct or runtime construct???
		
		List<Number> numbers=new ArrayList<>();
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		print(numbers);
		
		List<Number> numbers1=new ArrayList<>();
		numbers1.add(10.5);
		numbers1.add(20.34);
		numbers1.add(30.12);
		print(numbers1);
		
		List<String> names=new ArrayList<>();
		names.add("abc");
		names.add("def");
		printStr(names);
		
	}

	
	//CEPS ->Consumer extends and Producers super
	//Use of super is going to be a lower bound
	//Use of extends is going to be upper bound
	private static void print(List<? super Number> list) {
		list.add(20);
	}
	
	private static void printStr(List<? extends String> list) {
		System.out.println(list);
		
	}

}








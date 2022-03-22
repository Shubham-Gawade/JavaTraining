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
public class GenericDemo1 {
	
	//Wild card for generic which takes any object you are going to send
	//Only Consumers allowed
	public static void print(List<?> numbers) {
		for(int i=0;i<numbers.size();i++)
		System.out.println(numbers.get(i));
		//numbers.add(10);
	}
	


	
	
	public static void main(String[] args) {
		
		//Is generic a compile time construct or runtime construct???
		
		List<Integer> numbers=new ArrayList<>();
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		print(numbers);
		
		List<Double> numbers1=new ArrayList<>();
		numbers1.add(10.5);
		numbers1.add(20.34);
		numbers1.add(30.12);
		print(numbers1);
		
		
		List<Date> any=new ArrayList<>();
		any.add(new Date());
		
		Date o=any.get(0);
		
		
	}

}








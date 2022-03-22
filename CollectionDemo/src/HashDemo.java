import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HashDemo {
	
	public static void main(String[] args) {	
		
		Set set=new TreeSet();
		
	//	set.add(new Student(104, "Trivia"));
	//	set.add(new Student(102, "Trivia"));
	//	set.add(new Student(101, "Saheer"));
	//	set.add(new Student(103, "Jay"));
	//	set.add(new Student(104, "Trivia"));
	
		

		set.add(new String("Trivia"));
		set.add(new String("Saheer"));	
		
		/*
		 * set.add(10); set.add(5); set.add(10); set.add(1);
		 */
		System.out.println(set);
	}

}

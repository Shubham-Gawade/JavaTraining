import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

public class AlgoDemo {
	
	
	public static void main(String[] args) {
		
		List<Integer> marks=Arrays.asList(10,20,30,40);
		
		ListIterator<Integer>  iterator=marks.listIterator();
		
		while(iterator.hasNext()) {
			int value=iterator.next();
			
			if(value==30) {
				iterator.add(80);;
			}
		}
	}

}

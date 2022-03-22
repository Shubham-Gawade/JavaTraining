import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

/**
 * Remove from list
 * Set the list
 * Reverse Iteration
 * @author Khan_sa
 *
 */
public class TraversingDemo2 {
	
	
	public static void main(String[] args) {
		
		Vector<Integer> list=new Vector<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		Enumeration<Integer> enumeration=list.elements();
		while(enumeration.hasMoreElements()) {
			int value=enumeration.nextElement();
			
			System.out.println(value);
		}
	}

}













import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Remove from list
 * Set the list
 * Reverse Iteration
 * @author Khan_sa
 *
 */
public class TraversingDemo {
	
	
	public static void main(String[] args) {
		
		List<Integer> list=new LinkedList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		//Iterator 
		//hasNext()
		//next() which physically moves the pointer to the next element in the list
		//remove() which removes the object which is being pointing by the iterator
	/*	Iterator<Integer> iterator=list.iterator();
		while(iterator.hasNext()) {
			int value=iterator.next();
			if(value==40) {
				iterator.remove();
			}
			
		}*/
		System.out.println(list);
		//ListIterator
		//set method is used to replace the object the iterator is point to in the list
		//add method is used to add one object to the next location where the iterator is pointing to
		//hasPrevious and previous methods to traverse a list backwards from the mentioned index during listIterator(index) 
		ListIterator<Integer> listIterator=list.listIterator(5);
		while(listIterator.hasNext()) {
			int value=listIterator.next();
			if(value==40) {
				//listIterator.set(80);
				listIterator.add(80);
			}
		}
		
		while(listIterator.hasPrevious()) {
			int value=listIterator.previous();
			System.out.println(value);
		}
		
		//System.out.println(list);
	}

}













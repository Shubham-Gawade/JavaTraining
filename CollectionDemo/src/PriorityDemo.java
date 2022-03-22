import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Queue;

public class PriorityDemo {

	
	public static void main(String[] args) {
		
		Queue queue=new PriorityQueue(new StudentIdComparator());

		queue.add(new Student(102, "Saheer"));
		queue.add(new Student(101, "Saheer"));
		//queue.add(3);
		//queue.add(10);
		//queue.add(1);
		
		
		System.out.println(queue);
		//System.out.println(queue.peek());
	}
}

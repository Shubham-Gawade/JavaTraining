import java.util.ArrayList;
import java.util.Vector;

public class LegacyDemo {
	
	
	public static void main(String[] args) {
		
		ArrayList arrayList=new ArrayList();
		arrayList.add(10);
		Vector vector =new Vector();
		vector.add(10);
		vector.addElement(20);
		
		System.out.println(vector);
		
	}

}

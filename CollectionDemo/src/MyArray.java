import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class MyArray {
	
	int array[]=new int[4];
	int index;
	
	
	void add(int element) {
		validate(index, element);
		array[index++]=element;
	}
	
	
	private void validate(int index, int element) {
		if(index>=array.length){
			//Need to create a new array
			int temp[] = new int[array.length+4];
			//Copy the elements of the existing array to this array
			int pos=0;
			for(int elementToCopy: array) {
				temp[pos++]=elementToCopy;
			}
			temp[pos]=element;
			array=temp;
		}
	}


	void display() {
		System.out.print("[");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+",");
		}
		System.out.print("]");
	}
	
	
	public static void main(String[] args) {
		
		ArrayList array1=new ArrayList();
		array1.add(10);
		array1.add(20);
		array1.add(300);
		
		HashSet array2=new HashSet();
		array2.add(300);
		array2.add(200);
		array2.add(100);
		
		
		
		array1.addAll(array2);
		
		System.out.println(array1);
		
	}

}






















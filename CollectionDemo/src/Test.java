
public class Test {

	int i = 10;
	int j=20;

	public boolean equals(Object obj) {
		if (obj instanceof Test) {
			Test p = (Test) obj;
			if (this.i == p.i && this.j==p.j) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {

		Test t1 = new Test();
		Test t2 = new Test();
		Test t3 = t1;

		// == vs .equals()
		// == checks for the reference or object address equality
		// .equals() is used to check the contents equality between two objects

		System.out.println("t1.equals(t2) " + (t1.equals(t2)));// true
		System.out.println("t1.equals(t3) " + (t1.equals(t3)));// true
		
		
		System.out.println("t1.equals(t2) " + (t1.i==t2.i && t1.j==t2.j));// true
		System.out.println("t1.equals(t3) " + (t1.equals(t3)));// true
		
		

		
		
		
		
		/*
		 * t1==t2 false t1==t3 true t1.equals(t2) false t1.equals(t3) true
		 * 
		 */

	}

}

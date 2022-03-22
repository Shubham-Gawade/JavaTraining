abstract class Person {
	abstract void eat();
}

@FunctionalInterface
interface Vehicle1{
	void run();
}

@FunctionalInterface
interface Vehicle2{
	void run(int wheels);
}

@FunctionalInterface
interface Vehicle3{
	int run(int wheels);
}

public class Outer {
	private int data = 30;

	class Inner {
		void msg() {
			System.out.println("Inner data is " + data);
		}
	}

	void display() {
		class Local {
			void msg() {
				System.out.println("Local data is " + data);
			}
		}
		Local l = new Local();
		l.msg();
	}

	static int staticData = 30;

	static class staticInner {
		void msg() {
			System.out.println("static data is " + staticData);
		}
	}

	public static void main(String args[]) {
		Outer obj = new Outer();
		// Member Inner Class
		Outer.Inner in = obj.new Inner();
		in.msg();

		// Anonymous inner class
		Person p = new Person() {
			void eat() {
				System.out.println("nice fruits");
			}
		};
		p.eat();

		// Local Inner Class
		Outer obj3 = new Outer();
		obj3.display();
		
		//Static Inner class
		Outer.staticInner obj4=new Outer.staticInner();  
		obj4.msg(); 
		
		
		//Lambda Function
		Vehicle1 obj5 = ()->System.out.println("Lambda with no arguments no return type");
		obj5.run();
		
		Vehicle2 obj6 = (int wheels)->System.out.println("Lambda with arguments no return type : "+ wheels);
		obj6.run(4);
		
		Vehicle3 obj7 = (int wheels)->{return wheels*4;};
		//Vehicle3 obj7 = (int wheels)-> wheels*4;
		//Single Statement then return and brackets not required
		System.out.println("Lamda with return type: "+obj7.run(4));
		
	}
}

interface Sayable1 {
	void say();
}

public class StaticMethod {
    static void saySomething() {
		System.out.println("Hello, this is static method.");
	}

	public static void main(String[] args) 
	{
		// Referring static method
		Sayable1 sayable = StaticMethod::saySomething;
		// Calling interface method
		sayable.say();
	}
}
@FunctionalInterface
interface MyFunctionalInterface {
	Student getStudent(String name);
}

//Student class
class Student {
	private String name;

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

public class ParameterizedConstructorMethod 
{
	public static void main(String[] args) 
	{
		MyFunctionalInterface mf = Student::new;
		Student s=mf.getStudent("Adithya");
		System.out.println(s.getName());
	}
}
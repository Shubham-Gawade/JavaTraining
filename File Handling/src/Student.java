import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = -1428002645318248897L;
	
	private int studentId;
	private String studentName;
	private transient float averageMark;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int studentId, String studentName, float averageMark) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.averageMark = averageMark;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public float getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(float averageMark) {
		this.averageMark = averageMark;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", averageMark=" + averageMark
				+ "]";
	}

}

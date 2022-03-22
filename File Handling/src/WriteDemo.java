import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class WriteDemo {
	
	
	void writePrimitive() {
		try {
			File file =new File("D:\\JavaTrg-workspace\\FileHandling\\A.txt");
			OutputStream outputStream = new FileOutputStream(file);
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			
			dataOutputStream.writeByte(10);
			dataOutputStream.writeShort(200);
			dataOutputStream.writeChar('A');
			//dataOutputStream.writeChars("String");
			dataOutputStream.writeFloat(10.5f);
			dataOutputStream.writeDouble(20.567);
			dataOutputStream.writeBoolean(false);
			dataOutputStream.writeLong(11111111);

			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	static void writeObject() {
		try {
			File file =new File("D:\\JavaTrg-workspace\\FileHandling\\student.txt");
			OutputStream outputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			
			Student student=new Student(101, "Vinayak", 67.25f);
			
			objectOutputStream.writeObject(student);
			
			//objectOutputStream.flush();

			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	static void writeCharStream() {
		File file =new File("D:\\JavaTrg-workspace\\FileHandling\\B.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			writer.write("Mayank");
			writer.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(null!=writer) {
				writer.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	public static void main(String[] args) {
		writeCharStream();
	}

}

























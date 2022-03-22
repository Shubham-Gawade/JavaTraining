import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ReadDemo {
		
	static void readByte() {
		try {
			File file =new File("D:\\JavaTrg-workspace\\FileHandling\\A.txt");
			InputStream inputStream = new FileInputStream(file);
			int data =inputStream.read();
			
			while(data!=-1) {
				System.out.print((char)data);
				data =inputStream.read();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void readPrimitive() {
		
		try {
			File file =new File("D:\\JavaTrg-workspace\\FileHandling\\A.txt");
			InputStream inputStream = new FileInputStream(file);
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			
			System.out.println(dataInputStream.readByte());
			System.out.println(dataInputStream.readShort());
			System.out.println(dataInputStream.readChar());
			//System.out.println(dataInputStream.read);
			System.out.println(dataInputStream.readFloat());
			System.out.println(dataInputStream.readDouble());
			System.out.println(dataInputStream.readBoolean());
			System.out.println(dataInputStream.readLong());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void readObject() {
		try {
			File file =new File("D:\\JavaTrg-workspace\\FileHandling\\student.txt");
			InputStream inputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		
			
			Student student =(Student)objectInputStream.readObject();
			
			System.out.println(student);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void useFilePointer() {
		
		byte [] dataBytes="Saheer Ali Khan".getBytes();
		
		ByteArrayInputStream  stream = new ByteArrayInputStream(dataBytes);
		
		print(stream.read());//S
		print(stream.read());//a
		stream.mark(0);
		print(stream.read());//h
		stream.skip(2);
		print(stream.read());//e
		print(stream.read());//e
		print(stream.read());//r
		stream.reset();
		System.out.println();
		print(stream.read());
		print(stream.read());
		print(stream.read());
		print(stream.read());
	
}

private static void print(int read) {
	System.out.print((char)read);
}

static void readCharStream() {
	File file =new File("D:\\JavaTrg-workspace\\FileHandling\\B.txt");
	FileReader reader=null;
	BufferedReader bufferedReader=null;
	try {
		reader = new FileReader(file);
		
		bufferedReader = new BufferedReader(reader);
		String data=bufferedReader.readLine();
		while(data!=null) {
			System.out.println(data);
			data=bufferedReader.readLine();
		}
		
	}catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
	} 
	catch (IOException e) {
		System.out.println(e.getMessage());
	} finally {
		try {
			if(null!=bufferedReader && null!=reader) {
			bufferedReader.close();
			reader.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}

	public static void main(String[] args) {
		readCharStream();
		
	}

}


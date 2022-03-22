import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;


//JDBC or Data base connection
public class MapDemo2 {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		Properties properties=new Properties();
		
		FileInputStream inputStream=new FileInputStream("db.properties");
		properties.load(inputStream);
		String driverName=properties.getProperty("mysql.driver");
		
		System.out.println(driverName);
		
		
		
		
		//Class.forName("com.mysql.jdbc.Drive");
		
		//DriverManager.getConnection("jdbc://192.19.3.5:3306/testDB", "root", "12345");
		
	}
}

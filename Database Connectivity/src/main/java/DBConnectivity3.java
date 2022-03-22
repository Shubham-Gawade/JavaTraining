import java.sql.*;  

public class DBConnectivity3 {

	public static void main(String[] args) {
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanage","root","root");  
			
			System.out.println("Connection Done"); 
			
			//Callable Statement
			//Store Procedure 
			
//			DELIMITER &&  
//			CREATE PROCEDURE getEmployee()  
//			BEGIN    
//			    select * from employee;   
//			END &&  
//			DELIMITER ; 
			
			CallableStatement stmt=connection.prepareCall("call getEmployee()");
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString("empname"));
			}
			
		}catch(Exception e){
			System.out.println(e);
		}  
	}
}

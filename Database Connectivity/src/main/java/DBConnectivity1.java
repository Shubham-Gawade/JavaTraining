import java.sql.*;  

public class DBConnectivity1 {

	public static void main(String[] args) {
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanage","root","root");  

			Statement stmt=connection.createStatement();  
			
			System.out.println("Connection Done");
			
//			String query1="create table employee(empid int,empname varchar(20))";
//			stmt.execute(query1);
		
			//execute() is used for DDL commands
			//CREATE , ALTER , DROP - delete complete table, TRUNCATE - delete only rows structure remains
			
			//----------------------------------------------------------------------------------------------------
			
//			String query1="insert into employee values(101,'Shubham')";
//			stmt.executeUpdate(query1);
			
//			String query1="update employee set empname='Pranav' where empid=101";
//			stmt.executeUpdate(query1);
			
//			String query1="delete from employee where empid=101";
//			stmt.executeUpdate(query1);
			
			//executeUpdate() is used for DML commands
			//INSERT , UPDATE , DELETE - delete can delete all rows or selected rows
			
			//----------------------------------------------------------------------------------------------------
			
//			String query1="insert into employee values(101,'Shubham')";
//			String query2="insert into employee values(102,'Pranav')";
//			String query3="insert into employee values(103,'Sanket')";
//			
//			stmt.addBatch(query1);
//			stmt.addBatch(query2);
//			stmt.addBatch(query3);
//			
//			int rowsAffected[]=stmt.executeBatch();
//			System.out.println("No of rows affected : "+rowsAffected.length);
			
			//----------------------------------------------------------------------------------------------------
			
			String query1="select * from employee";
			String query2="select empname from employee";
			
			ResultSet rs=stmt.executeQuery(query1);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString("empname"));
			}
			//we can get values by index and column name
			
			System.out.println("----------------------------");
			
			ResultSet rs2=stmt.executeQuery(query2);
		
			while(rs2.next()) {
				System.out.println(rs2.getString(1));
			}
			//here index is not column number in table, index is column number in ResultSet
			
		}catch(Exception e){
			System.out.println(e);
		}  
	}
}

import java.sql.*;  

public class DBConnectivity2 {

	public static void main(String[] args) {
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanage","root","root");  
			
			System.out.println("Connection Done");
			
			Statement stmt=connection.createStatement();  
			
			//Parameterized Queries
			
//			String query1="insert into employee values(?,?)";
//			PreparedStatement ps=connection.prepareStatement(query1);
//			ps.setInt(1,104);
//			ps.setString(2, "Stephen");
//			ps.executeUpdate();
			
			//----------------------------------------------------------------------------------------------------
			
			//Normal Queries
			
//			String query1="select * from employee";
//			PreparedStatement ps=connection.prepareStatement(query1);
//			ResultSet rs=ps.executeQuery(query1);
//			
//			while(rs.next()) {
//				System.out.println(rs.getInt(1)+"  "+rs.getString("empname"));
//			}
			
			//----------------------------------------------------------------------------------------------------
			
			try {
				String query1="insert into employee values(105,'Saurabh')";
				String query2="insert into employee values(106,Pranav)";  //Error can be occurred
				String query3="insert into employee values(107,'Manali')";
				
				connection.setAutoCommit(false);
				
				stmt.addBatch(query1);
				stmt.addBatch(query2);
				stmt.addBatch(query3);
				
				int rowsAffected[]=stmt.executeBatch();
				System.out.println("No of rows affected : "+rowsAffected.length);
				
				connection.commit();
				
				//If any exception occurred then before that point executed queries are rollbacked
				
			} catch (Exception e) {
				connection.rollback();
				System.out.println("Rollback Insertion");
			}
			
		}catch(Exception e){
			System.out.println(e);
		}  
	}
}

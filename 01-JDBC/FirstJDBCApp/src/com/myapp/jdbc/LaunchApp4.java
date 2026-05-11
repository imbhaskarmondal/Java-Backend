//DELETE

package com.myapp.jdbc;
import java.sql.*;

public class LaunchApp4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//establish the connection
		String url = "jdbc:mysql://localhost:3306/jdbclearning";
		String user = "root";
		String password = "Mysql@123";
		Connection connect = DriverManager.getConnection(url, user, password);
		
		//create statement
		Statement statement = connect.createStatement();
		
		//execute query
		String sqlQuery = "DELETE FROM studentinfo WHERE id = 2";
		int rowAffected = statement.executeUpdate(sqlQuery);
		
		//process result
		if(rowAffected == 0) {
			System.out.println("Deletion Failed");
		}
		else {
			System.out.println("Recorded Deleted Successfully");
		}
		
		//close
		statement.close();
		connect.close();
		
	}

}

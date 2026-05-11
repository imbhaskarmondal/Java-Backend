//UPDATE

package com.myapp.jdbc;
import java.sql.*;

public class LaunchApp2 {

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
		
		//execute query - UPDATION
		String sqlQuery = "UPDATE studentinfo set sage = 24 WHERE id = 2";
		int rowAffected = statement.executeUpdate(sqlQuery);
		
		//process result
		if(rowAffected == 0) {
			System.out.println("Updation failed");
		}
		else {
			System.out.println("Update successfully");
		}
		
		//close
		statement.close();
		connect.close();
	}

}

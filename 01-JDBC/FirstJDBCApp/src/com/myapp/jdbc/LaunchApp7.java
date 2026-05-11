//using Utility Class
package com.myapp.jdbc;
import java.sql.*;

public class LaunchApp7 {

	public static void main(String[] args) {
		Connection connect = null;
		Statement statement = null;
		try {
			connect = UtilityJdbc.getConnection();
			
			statement = connect.createStatement();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			try {
				UtilityJdbc.closeConnection(statement, connect);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}

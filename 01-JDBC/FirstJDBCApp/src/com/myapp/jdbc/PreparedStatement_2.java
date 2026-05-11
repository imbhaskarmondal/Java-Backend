//Prepared Statement
//UPDATE

package com.myapp.jdbc;
import java.util.*;
import java.sql.*;

public class PreparedStatement_2 {

	public static void main(String[] args) {
		Connection connect = null;
		PreparedStatement ps = null;
		
		try {
			connect = UtilityJdbc.getConnection();
			
			String query = "UPDATE studentinfo SET sage = ? WHERE id = ?";
			ps = connect.prepareStatement(query);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter DB details to Update: ");
			
			System.out.println("Enter id: ");
			int id = sc.nextInt();
			
			System.out.println("Enter age: ");
			int age = sc.nextInt();
			
			ps.setInt(1, age);
			ps.setInt(2, id);
			
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected == 0) {
				System.out.println("No data updated!");
			}
			else {
				System.out.println("Data updated successfully");
			}
			sc.close();
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				UtilityJdbc.closeConnection(ps, connect);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

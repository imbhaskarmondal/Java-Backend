//Batch Update
//Only for non-retrieval operations
package com.myapp.jdbc;
import java.sql.*;

public class BatchUpdate {

	public static void main(String[] args) {
		Connection connect = null;
		PreparedStatement ps = null;
		
		try {
			connect = UtilityJdbc.getConnection();
			
			String query = "UPDATE studentinfo SET sage = ? WHERE id = ?";
			ps = connect.prepareStatement(query);
			
			ps.setInt(1, 20);
			ps.setInt(2, 1);
			ps.addBatch();
			
			ps.setInt(1, 24);
			ps.setInt(2, 2);
			ps.addBatch();
			
			ps.setInt(1, 25);
			ps.setInt(2, 3);
			ps.addBatch();
			
			ps.executeBatch();
			System.out.println("Data updated successfully!");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
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

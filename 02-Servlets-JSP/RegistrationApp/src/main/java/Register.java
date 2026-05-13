

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Control in Servlet...");
		
		String uname = request.getParameter("uname");
		String emailId = request.getParameter("email");
		String upassword = request.getParameter("password");
		String ucity = request.getParameter("ucity");
		
		//JDBC
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = System.getenv("DB_URL");
			String user = System.getenv("DB_USER");
			String password = System.getenv("DB_PASSWORD");
			Connection connect = DriverManager.getConnection(url, user, password);
			
			String query = "INSERT INTO registrationApp (uname, email, upassword, ucity) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = connect.prepareStatement(query);
			
			ps.setString(1, uname);
			ps.setString(2, emailId);
			ps.setString(3, upassword);
			ps.setString(4, ucity);
			
			int rowsAffected = ps.executeUpdate();
			
			PrintWriter writer = response.getWriter();
			
			if (rowsAffected == 0) {
				System.out.println("Data insertion failed...");
				
				writer.println("<h1>Registration Failed!</h1>");
			}
			else {
				System.out.println("Data inserted successfully...");
				
				writer.println("<h1>Registration Successful!</h1>");
			}
			
			ps.close();
			connect.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

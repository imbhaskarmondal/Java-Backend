

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Control in first servlet");
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/SecondServlet");
		
//		reqDispatcher.forward(request, response);
		reqDispatcher.include(request, response);
		
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Response from First Servlet</h1>");
		writer.close();
		
		System.out.println("Control again in First Servlet");
	}

}

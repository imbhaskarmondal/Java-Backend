

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/firstServlet")
public class FirstServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FirstServletApp() {
        System.out.println("The object of Servlet is created internally by container");
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("uname");
		String city = request.getParameter("ucity");
		
		PrintWriter writer = response.getWriter();
		
//		writer.println("Hello " + name);
//		writer.println("You belong from " + city);
		
//		With HTML formatting
		writer.println("<html> <head> <title> Second Web App </title> </head>");
		writer.println("<body bgcolor = 'cyan'> <h1> <marquee> Welcome to our Dynamic App </h1> </marquee> </h1>");
		writer.println("<table>");
		writer.println("<tr><th>NAME</th> <th>CITY</th> </tr>");
		writer.println("<tr><td>" + name + "</td> <td>" + city + " </td> </tr>");
		writer.println("</table></body></html>");
		
		writer.close();
		
	}

}

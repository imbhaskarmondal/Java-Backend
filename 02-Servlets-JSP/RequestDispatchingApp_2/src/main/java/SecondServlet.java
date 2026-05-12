

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Control in Second Servlet");
		
		HttpSession session = request.getSession(false);
		String userName = (String)session.getAttribute("userName");
		String userCity = (String)session.getAttribute("userCity");
		
		PrintWriter out = response.getWriter();
		out.println("User Name: " + userName);
		out.println("User City: " + userCity);
		
	}

}

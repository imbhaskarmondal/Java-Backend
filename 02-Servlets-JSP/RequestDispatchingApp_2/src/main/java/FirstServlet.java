//Taking data from client(form) and passing it to different servlets
//getSession(), setAttribute(), getAttribute()

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Control in First Servlet");
		
		String name = request.getParameter("uname");
		String city = request.getParameter("ucity");
		
//		The session object helps to retain the data throughout the session (persistent; longer time)
//		By using the session object, data can be transferred to multiple servlets for multiple requests
//		Simply using request.setAttribute(), stores the data temporarily for single request
		
		HttpSession session = request.getSession();
		session.setAttribute("userName", name);
		session.setAttribute("userCity", city);
		
		RequestDispatcher rd = request.getRequestDispatcher("/SecondServlet");
		rd.forward(request, response);
	}

}

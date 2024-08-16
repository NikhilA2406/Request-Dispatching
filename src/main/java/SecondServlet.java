

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Control in 2nd Servlet");
		HttpSession session = request.getSession(false);
		String name =(String) session.getAttribute("fullname");
		String email =(String) session.getAttribute("email");
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Response from Servlet Two</h1>"+" "+name+" "+email);
		writer.close();
	}

}

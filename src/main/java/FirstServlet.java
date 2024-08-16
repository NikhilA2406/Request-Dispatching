

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Control in 1st Servlet");
		
		String name = request.getParameter("fullname"); 
		String email = request.getParameter("email"); 
		HttpSession session = request.getSession();
		session.setAttribute("fullname", name);
		session.setAttribute("email", email);
		session.setMaxInactiveInterval(10000);
		RequestDispatcher rqdisp=request.getRequestDispatcher("/SecondServlet");
		
		rqdisp.forward(request, response);
		//rqdisp.include(request, response);
		 
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Response from Servlet one</h1>");
		writer.close();
		//System.out.println("Control again in 1st Servlet");
	}

}

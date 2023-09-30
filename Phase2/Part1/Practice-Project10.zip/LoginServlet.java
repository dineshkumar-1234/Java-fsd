

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String validEmail = "user@gmail.com";
		String validPassword = "password";
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if (email.equals(validEmail) && password.equals(validPassword)) {
		request.getSession().setAttribute("user", "authenticated");
		response.sendRedirect("Dashboard.html");
		} 
		else {
			response.sendRedirect("Err.html");
		}
	}

}

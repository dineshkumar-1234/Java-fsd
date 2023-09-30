import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Cookie[] cookies = request.getCookies();
		boolean isCookiePresent = false;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("sessionCookie")) {
					isCookiePresent = true;
					break;
					}
				}
			}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		if (isCookiePresent) {
			out.println("Session was handled with a cookie.");
		}
		else {
			out.println("Session was not handled with a cookie.");
		
			Cookie cookie = new Cookie("sessionCookie", "exampleCookieValue");
			response.addCookie(cookie);
			}
		out.println("</body></html>");
		}
}

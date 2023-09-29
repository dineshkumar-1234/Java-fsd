

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetServlet
 */
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 /* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramValue = request.getParameter("param");
		response.getWriter().write("GET Request Parameter: " + paramValue );
	}

}

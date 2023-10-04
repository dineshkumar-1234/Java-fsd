import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet

public class JDBCSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbcUrl = "jdbc:mysql://localhost:3306/eshop";
			String username = "root";
			String password = "q1w2e3r4t5y6u7!";
			connection = DriverManager.getConnection(jdbcUrl, username, password);
			out.println("JDBC environment set up successfully!");
			}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			out.println("Error: " + e.getMessage());
			}
		finally {
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
					}
				}
			catch (SQLException e) {
				e.printStackTrace();
				}
			}
		}
}

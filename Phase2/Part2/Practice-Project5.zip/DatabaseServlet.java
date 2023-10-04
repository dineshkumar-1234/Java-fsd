import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/DatabaseServlet")

public class DatabaseServlet extends HttpServlet {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "q1w2e3r4t5y6u7!";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			Statement statement = connection.createStatement();
			String action = request.getParameter("create");
			if (action != null && action.equals("Create Database")) {
				statement.executeUpdate("CREATE DATABASE IF NOT EXISTS mydb");
				out.println("Database 'mydb' created successfully.");
				}
			else if (action != null && action.equals("Select Database")) {
				statement.executeUpdate("USE mydb");
				out.println("Database 'mydb' selected.");
				}
			else if (action != null && action.equals("Drop Database")) {
				statement.executeUpdate("DROP DATABASE IF EXISTS mydb");
				out.println("Database 'mydb' dropped.");
				}
			statement.close();
			connection.close();
			}
		catch (SQLException e) {
			e.printStackTrace();
			out.println("An error occurred: " + e.getMessage());
			}
		}
}

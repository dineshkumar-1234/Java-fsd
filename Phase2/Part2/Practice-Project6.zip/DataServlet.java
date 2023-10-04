import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/DatabaseServlet")

public class DataServlet extends HttpServlet {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "q1w2e3r4t5y6u7!";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			if (request.getParameter("insert") != null) {
				String name = request.getParameter("name");
				String value = request.getParameter("value");
				PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO records (name, value) VALUES (?, ?)");
				insertStatement.setString(1, name);
				insertStatement.setString(2, value);
				insertStatement.executeUpdate();
				insertStatement.close();
				out.println("Data inserted successfully.");
				}
			else if (request.getParameter("update") != null) {
				int updateId = Integer.parseInt(request.getParameter("updateId"));
				String newValue = request.getParameter("newValue");
				PreparedStatement updateStatement = connection.prepareStatement("UPDATE records SET value = ? WHERE id = ?");
				updateStatement.setString(1, newValue);
				updateStatement.setInt(2, updateId);
				int updatedRows = updateStatement.executeUpdate();
				updateStatement.close();
				if (updatedRows > 0) {
					out.println("Data updated successfully.");
					}
				else {
					out.println("No record found for the provided ID.");
					}
				}
			else if (request.getParameter("delete") != null) {
				int deleteId = Integer.parseInt(request.getParameter("deleteId"));
				PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM records WHERE id = ?");
				deleteStatement.setInt(1, deleteId);
				int deletedRows = deleteStatement.executeUpdate();
				deleteStatement.close();
				if (deletedRows > 0) {
					out.println("Data deleted successfully.");
					}
				else {
					out.println("No record found for the provided ID.");
					}
				}
			connection.close();
			}
		catch (SQLException e) {
			e.printStackTrace();
			out.println("An error occurred: " + e.getMessage());
			}
		}
}

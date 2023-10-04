import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/ProductServlet")

public class ProductServlet extends HttpServlet {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/eshop";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "q1w2e3r4t5y6u7!";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String productName = request.getParameter("productName");
		
		try {
			Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			CallableStatement statement = connection.prepareCall("{CALL GetProductByName(?)}");
			statement.setString(1, productName);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int productId = resultSet.getInt("product_id");
				String productNameFromDB = resultSet.getString("product_name");
				String productDescription = resultSet.getString("product_description");
				double productPrice = resultSet.getDouble("product_price");
				int productQuantity = resultSet.getInt("product_quantity");
				out.println("Product ID: " + productId + "<br>");
				out.println("Product Name: " + productNameFromDB + "<br>");
				out.println("Product Description: " + productDescription + "<br>");
				out.println("Product Price: " + productPrice + "<br>");
				out.println("Product Quantity: " + productQuantity + "<br>");
				}
			resultSet.close();
			statement.close();
			connection.close();
			}
		catch (SQLException e) {
			e.printStackTrace();
			out.println("An error occurred: " + e.getMessage());
			}
		}
}

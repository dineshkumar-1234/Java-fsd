import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddDataServlet")
public class AddDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        try {
            String jdbcUrl = "jdbc:mysql://localhost:3306/eshop";
            String dbUser = "root";
            String dbPassword = "q1w2e3r4t5y6u7!";
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

            String sql = "INSERT INTO product (product_name, product_description, product_price, product_quantity) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            String productName = request.getParameter("productName");
            String productDescription = request.getParameter("productDescription");
            String productPriceStr = request.getParameter("productPrice");
            String productQuantityStr = request.getParameter("productQuantity");

            double productPrice;
            int productQuantity;

            try {
                productPrice = Double.parseDouble(productPriceStr);
                productQuantity = Integer.parseInt(productQuantityStr);
            } catch (NumberFormatException e) {
                response.getWriter().println("Error: Invalid price or quantity format.");
                return; 
            }

            preparedStatement.setString(1, productName);
            preparedStatement.setString(2, productDescription);
            preparedStatement.setDouble(3, productPrice);
            preparedStatement.setInt(4, productQuantity);
          
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                response.getWriter().println("Data added successfully!");
            } else {
                response.getWriter().println("Error: Data insertion failed.");
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}

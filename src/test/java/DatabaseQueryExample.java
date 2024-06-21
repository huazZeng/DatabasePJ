import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseQueryExample {

    private static final String URL = "jdbc:mysql://localhost:3306/test_db";
    private static final String USER = "root";
    private static final String PASSWORD = "187415157";
    private static final String QUERY = "SELECT * FROM user WHERE name = ?";

    public static void main(String[] args) {
        String nameToSearch = "Abigail Davis";

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Prepare the statement
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, nameToSearch);

            // Record start time
            long startTime = System.nanoTime();

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Record end time
            long endTime = System.nanoTime();

            // Calculate query duration
            long duration = endTime - startTime;

            // Process the result set
            while (resultSet.next()) {
                // Retrieve data from the result set
                String name = resultSet.getString("name");
                // You can retrieve other columns similarly
                System.out.println("Name: " + name);
            }

            // Print the query duration
            System.out.println("Query executed in: " + duration + " nanoseconds");

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

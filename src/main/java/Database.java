import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "DRAGOS", "DRAGOS");
        }
        return connection;
    }

}

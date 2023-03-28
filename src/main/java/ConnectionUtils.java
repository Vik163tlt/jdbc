import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    static final String USER = "postgres";
    static final String PASSWORD = "dbnfkbqd13";
    static final String URL = "jdbc:postgresql://localhost:5432/skypro";

    public static Connection getConnection() {
        Connection CONNECTION;
        try {
            CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return CONNECTION;
    }
}
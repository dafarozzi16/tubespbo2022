import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class Database {
    static final String DB_URL = "jdbc:mysql://localhost:3306/db_ocid";
    static final String USER = "root";
    static final String PASS = "mysqlrootpass";
    public Connection conn;
    public Statement stmt;
    public Database() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

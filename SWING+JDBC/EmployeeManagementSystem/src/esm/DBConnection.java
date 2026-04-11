package esm;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/employee_db",
                "postgres",
                "123456"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
package esm;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/employee_db",
                "postgres",
                "123456"
            );
            System.out.println("Connected Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
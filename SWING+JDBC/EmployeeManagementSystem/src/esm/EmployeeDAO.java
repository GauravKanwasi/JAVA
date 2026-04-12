package esm;

import java.sql.*;
import java.util.*;

public class EmployeeDAO {

    public static void addEmployee(Employee emp) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO employee(name, department, salary) VALUES (?, ?, ?)");
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getSalary());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                list.add(new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("department"),
                    rs.getDouble("salary")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public static void deleteEmployee(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM employee WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void updateEmployee(Employee emp) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE employee SET name=?, department=?, salary=? WHERE id=?");
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getSalary());
            ps.setInt(4, emp.getId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static List<Employee> searchEmployee(String key) {
        List<Employee> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM employee WHERE name ILIKE ?");
            ps.setString(1, "%" + key + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("department"),
                    rs.getDouble("salary")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}
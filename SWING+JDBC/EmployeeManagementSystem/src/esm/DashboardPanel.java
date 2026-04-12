package esm;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class DashboardPanel extends JPanel {

    JLabel total = new JLabel();
    JLabel avg = new JLabel();

    public DashboardPanel() {
        setLayout(new GridLayout(2,1));
        setBorder(BorderFactory.createTitledBorder("Dashboard"));

        add(total);
        add(avg);

        loadStats();
    }

    public void loadStats() {
        try(Connection conn = DBConnection.getConnection()) {

            ResultSet rs1 = conn.createStatement()
                .executeQuery("SELECT COUNT(*) FROM employee");
            if(rs1.next())
                total.setText("Total Employees: " + rs1.getInt(1));

            ResultSet rs2 = conn.createStatement()
                .executeQuery("SELECT AVG(salary) FROM employee");
            if(rs2.next())
                avg.setText("Average Salary: " + rs2.getDouble(1));

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
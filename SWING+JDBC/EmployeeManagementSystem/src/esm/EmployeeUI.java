package esm;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.List;

public class EmployeeUI extends JFrame {

    JTextField nameField, deptField, salaryField, searchField;
    JTable table;
    DefaultTableModel model;

    public EmployeeUI() {

        setTitle("Employee Management System");
        setSize(900, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // ===== GLOBAL FONT =====
        Font font = new Font("Segoe UI", Font.PLAIN, 14);

        // ===== FORM PANEL =====
        JPanel form = new JPanel(new GridLayout(3, 2, 10, 10));
        form.setBorder(BorderFactory.createTitledBorder("Employee Details"));

        nameField = new JTextField();
        deptField = new JTextField();
        salaryField = new JTextField();

        form.add(new JLabel("Name:"));
        form.add(nameField);

        form.add(new JLabel("Department:"));
        form.add(deptField);

        form.add(new JLabel("Salary:"));
        form.add(salaryField);

        // ===== SEARCH PANEL =====
        JPanel searchPanel = new JPanel(new FlowLayout());
        searchField = new JTextField(20);
        JButton searchBtn = createButton("Search");

        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);

        // ===== TABLE =====
        model = new DefaultTableModel(new String[]{"ID", "Name", "Department", "Salary"}, 0);
        table = new JTable(model);

        table.setRowHeight(25);
        table.setFont(font);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        JScrollPane scroll = new JScrollPane(table);

        // ===== BUTTON PANEL =====
        JPanel btnPanel = new JPanel();

        JButton addBtn = createButton("Add");
        JButton updateBtn = createButton("Update");
        JButton deleteBtn = createButton("Delete");
        JButton refreshBtn = createButton("Refresh");

        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);
        btnPanel.add(refreshBtn);

        // ===== MAIN LAYOUT =====
        setLayout(new BorderLayout(10, 10));
        add(form, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
        add(searchPanel, BorderLayout.WEST);

        // ===== LOAD DATA =====
        loadData();

        // ===== EVENTS =====

        addBtn.addActionListener(e -> {
            EmployeeDAO.addEmployee(new Employee(
                    nameField.getText(),
                    deptField.getText(),
                    Double.parseDouble(salaryField.getText())
            ));
            loadData();
            clearFields();
        });

        deleteBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) return;

            int id = (int) model.getValueAt(row, 0);
            EmployeeDAO.deleteEmployee(id);
            loadData();
        });

        updateBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) return;

            int id = (int) model.getValueAt(row, 0);

            EmployeeDAO.updateEmployee(new Employee(
                    id,
                    nameField.getText(),
                    deptField.getText(),
                    Double.parseDouble(salaryField.getText())
            ));
            loadData();
        });

        searchBtn.addActionListener(e -> {
            model.setRowCount(0);
            List<Employee> list = EmployeeDAO.searchEmployee(searchField.getText());

            for (Employee emp : list) {
                model.addRow(new Object[]{
                        emp.getId(),
                        emp.getName(),
                        emp.getDepartment(),
                        emp.getSalary()
                });
            }
        });

        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                nameField.setText(model.getValueAt(row, 1).toString());
                deptField.setText(model.getValueAt(row, 2).toString());
                salaryField.setText(model.getValueAt(row, 3).toString());
            }
        });

        refreshBtn.addActionListener(e -> loadData());

        setVisible(true);
    }

    // ===== BUTTON STYLE =====
    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(70, 130, 180));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        return btn;
    }

    // ===== LOAD DATA =====
    private void loadData() {
        model.setRowCount(0);
        List<Employee> list = EmployeeDAO.getEmployees();

        for (Employee emp : list) {
            model.addRow(new Object[]{
                    emp.getId(),
                    emp.getName(),
                    emp.getDepartment(),
                    emp.getSalary()
            });
        }
    }

    private void clearFields() {
        nameField.setText("");
        deptField.setText("");
        salaryField.setText("");
    }

    public static void main(String[] args) {
        new EmployeeUI();
    }
}
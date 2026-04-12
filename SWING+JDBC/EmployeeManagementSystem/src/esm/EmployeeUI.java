package esm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class EmployeeUI extends JFrame {

    JTextField name, dept, salary, search;
    JTable table;
    DefaultTableModel model;

    public EmployeeUI() {

        setTitle("Employee Management System");
        setSize(900,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        DashboardPanel dashboard = new DashboardPanel();

        JPanel form = new JPanel(new GridLayout(3,2,10,10));
        name = new JTextField();
        dept = new JTextField();
        salary = new JTextField();

        form.add(new JLabel("Name")); form.add(name);
        form.add(new JLabel("Department")); form.add(dept);
        form.add(new JLabel("Salary")); form.add(salary);

        model = new DefaultTableModel(new String[]{"ID","Name","Dept","Salary"},0);
        table = new JTable(model);

        table.setForeground(Color.WHITE);
        table.setBackground(new Color(50,50,50));

        JScrollPane sp = new JScrollPane(table);

        JPanel btn = new JPanel();

        JButton add = new JButton("Add");
        JButton update = new JButton("Update");
        JButton delete = new JButton("Delete");
        JButton refresh = new JButton("Refresh");
        JButton export = new JButton("Export");
        JButton theme = new JButton("Toggle Theme");

        btn.add(add); btn.add(update); btn.add(delete);
        btn.add(refresh); btn.add(export); btn.add(theme);

        search = new JTextField(15);
        JButton searchBtn = new JButton("Search");

        JPanel searchPanel = new JPanel();
        searchPanel.add(search);
        searchPanel.add(searchBtn);

        setLayout(new BorderLayout());
        add(form, BorderLayout.NORTH);
        add(sp, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);
        add(searchPanel, BorderLayout.WEST);
        add(dashboard, BorderLayout.EAST);

        load();

        add.addActionListener(e -> {
            EmployeeDAO.addEmployee(new Employee(
                name.getText(), dept.getText(),
                Double.parseDouble(salary.getText())
            ));
            load();
        });

        update.addActionListener(e -> {
            int r = table.getSelectedRow();
            if(r==-1) return;
            int id = (int) model.getValueAt(r,0);

            EmployeeDAO.updateEmployee(new Employee(
                id,name.getText(),dept.getText(),
                Double.parseDouble(salary.getText())
            ));
            load();
        });

        delete.addActionListener(e -> {
            int r = table.getSelectedRow();
            if(r==-1) return;
            EmployeeDAO.deleteEmployee((int)model.getValueAt(r,0));
            load();
        });

        refresh.addActionListener(e -> load());

        searchBtn.addActionListener(e -> {
            model.setRowCount(0);
            List<Employee> list = EmployeeDAO.searchEmployee(search.getText());
            for(Employee emp: list)
                model.addRow(new Object[]{emp.getId(),emp.getName(),emp.getDepartment(),emp.getSalary()});
        });

        export.addActionListener(e ->
            ExportUtil.export(EmployeeDAO.getEmployees())
        );

        final boolean[] dark = {true};
        theme.addActionListener(e -> {
            if(dark[0]) AppTheme.lightTheme();
            else AppTheme.darkTheme();
            dark[0] = !dark[0];
            SwingUtilities.updateComponentTreeUI(this);
        });

        setVisible(true);
    }

    void load() {
        model.setRowCount(0);
        for(Employee e: EmployeeDAO.getEmployees())
            model.addRow(new Object[]{e.getId(),e.getName(),e.getDepartment(),e.getSalary()});
    }
}
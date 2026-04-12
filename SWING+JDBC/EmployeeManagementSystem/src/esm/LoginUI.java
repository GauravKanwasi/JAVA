package esm;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame {

    JTextField user;
    JPasswordField pass;

    public LoginUI() {
        setTitle("Login");
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,2,10,10));

        user = new JTextField();
        pass = new JPasswordField();

        add(new JLabel("Username:"));
        add(user);

        add(new JLabel("Password:"));
        add(pass);

        JButton login = new JButton("Login");
        add(new JLabel());
        add(login);

        login.addActionListener(e -> {
            if(user.getText().equals("admin") &&
               new String(pass.getPassword()).equals("1234")) {
                dispose();
                new EmployeeUI();
            } else {
                JOptionPane.showMessageDialog(this,"Wrong login");
            }
        });

        setVisible(true);
    }
}
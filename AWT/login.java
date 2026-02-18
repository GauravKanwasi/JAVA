import java.awt.*;
import java.awt.event.*;

public class login extends Frame implements ActionListener {

    TextField userField, passField;
    Label message;

    login() {
        setLayout(new FlowLayout());

        add(new Label("Username:"));
        userField = new TextField(15);
        add(userField);

        add(new Label("Password:"));
        passField = new TextField(15);
        passField.setEchoChar('*');
        add(passField);

        Button loginBtn = new Button("Login");
        add(loginBtn);

        message = new Label("");
        add(message);

        loginBtn.addActionListener(this);

        setSize(300, 200);
        setTitle("Login Form");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (userField.getText().equals("admin") &&
            passField.getText().equals("1234")) {
            message.setText("Login Successful");
        } else {
            message.setText("Invalid Login");
        }
    }

    public static void main(String[] args) {
        new login();
    }
}

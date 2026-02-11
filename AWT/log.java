import java.awt.*;
import java.awt.event.*;

public class log extends Frame implements ActionListener {
    Label l1, l2, msg;
    TextField t1, t2;
    Button b;

    public log() {
        setLayout(new FlowLayout());

        l1 = new Label("Username:");
        l2 = new Label("Password:");
        msg = new Label("");

        t1 = new TextField(20);
        t2 = new TextField(20);
        t2.setEchoChar('*');

        b = new Button("Login");

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b);
        add(msg);

        b.addActionListener(this);

        setSize(300, 200);
        setTitle("Login Screen");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String user = t1.getText();
        String pass = t2.getText();

        if (user.equals("admin") && pass.equals("1234")) {
            msg.setText("Login Successful");
        } else {
            msg.setText("Invalid Username or Password");
        }
    }

    public static void main(String[] args) {
        new log();
    }
}

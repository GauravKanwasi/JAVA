import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class logindetails extends JFrame {
    private ArrayList<String> userData = new ArrayList<>();
    private JTextField nameField;
    private JPasswordField passField;
    private JTextArea displayArea;

    public logindetails() {
        setTitle("Login Details System");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Username:"));
        nameField = new JTextField(20);
        add(nameField);

        add(new JLabel("Password: "));
        passField = new JPasswordField(20);
        add(passField);

        JButton addButton = new JButton("Add User");
        JButton showButton = new JButton("Show All Users");
        add(addButton);
        add(showButton);

        displayArea = new JTextArea(15, 30);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String pass = new String(passField.getPassword());

                if (!name.isEmpty() && !pass.isEmpty()) {
                    userData.add("User: " + name + " | Pass: " + pass);
                    JOptionPane.showMessageDialog(null, "Data Added!");
                    nameField.setText("");
                    passField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Fill all fields.");
                }
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText("");
                for (String user : userData) {
                    displayArea.append(user + "\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new logindetails().setVisible(true);
        });
    }
}
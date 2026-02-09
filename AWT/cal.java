import java.awt.*;
import java.awt.event.*;

public class cal extends Frame implements ActionListener {

    TextField tf;
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    Button add, sub, mul, div, eq, clr;

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    cal() {
        setLayout(new BorderLayout());

        tf = new TextField();
        tf.setEditable(false);
        tf.setFont(new Font("Arial", Font.BOLD, 18));
        add(tf, BorderLayout.NORTH);

        Panel p = new Panel();
        p.setLayout(new GridLayout(5, 4, 5, 5));

        b7 = new Button("7");
        b8 = new Button("8");
        b9 = new Button("9");
        div = new Button("/");

        b4 = new Button("4");
        b5 = new Button("5");
        b6 = new Button("6");
        mul = new Button("*");

        b1 = new Button("1");
        b2 = new Button("2");
        b3 = new Button("3");
        sub = new Button("-");

        b0 = new Button("0");
        clr = new Button("C");
        eq = new Button("=");
        add = new Button("+");

        Button[] buttons = {
            b7, b8, b9, div,
            b4, b5, b6, mul,
            b1, b2, b3, sub,
            b0, clr, eq, add
        };

        for (Button b : buttons) {
            p.add(b);
            b.addActionListener(this);
        }

        add(p, BorderLayout.CENTER);

        setTitle("AWT Calculator");
        setSize(300, 300);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9]")) {
            tf.setText(tf.getText() + cmd);
        } 
        else if (cmd.equals("C")) {
            tf.setText("");
            num1 = num2 = result = 0;
        } 
        else if (cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/")) {
            num1 = Double.parseDouble(tf.getText());
            operator = cmd.charAt(0);
            tf.setText("");
        } 
        else if (cmd.equals("=")) {
            num2 = Double.parseDouble(tf.getText());

            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num2 != 0 ? num1 / num2 : 0; break;
            }

            tf.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        new cal();
    }
}

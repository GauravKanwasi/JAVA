import java.awt.*;
import java.awt.event.*;

public class SimpleAWTExample extends Frame {

    Label message;

    SimpleAWTExample() {
        message = new Label("Hello, this is a simple AWT program!");
        message.setBounds(60, 80, 220, 30);

        add(message);

        setSize(350, 200);
        setLayout(null);
        setTitle("Simple AWT Example");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new SimpleAWTExample();
    }
}

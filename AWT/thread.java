import java.awt.*;
import java.awt.event.*;

public class thread extends Frame implements Runnable, ActionListener {

    Label l;
    Button b;
    Thread t;
    int count = 0;

    thread() {
        setLayout(new FlowLayout());

        l = new Label("Counter: 0");
        b = new Button("Start");

        add(l);
        add(b);

        b.addActionListener(this);

        setSize(300, 200);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        t = new Thread(this);
        t.start();
    }

    public void run() {
        try {
            while (true) {
                count++;
                l.setText("Counter: " + count);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        new thread();
    }
}

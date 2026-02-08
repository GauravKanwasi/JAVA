import java.awt.*;
import java.awt.event.*;

public class check extends Frame implements ItemListener {
    Checkbox c1, c2, c3;
    Label label;

    check() {
        setLayout(new FlowLayout());

        c1 = new Checkbox("Java");
        c2 = new Checkbox("Python");
        c3 = new Checkbox("C++");

        label = new Label("Select a language");

        c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);

        add(c1);
        add(c2);
        add(c3);
        add(label);

        setSize(300, 150);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void itemStateChanged(ItemEvent e) {
        String result = "Selected: ";
        if (c1.getState()) result += "Java ";
        if (c2.getState()) result += "Python ";
        if (c3.getState()) result += "C++ ";
        label.setText(result);
    }

    public static void main(String[] args) {
        new check();
    }
}

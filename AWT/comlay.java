import java.awt.*;

public class comlay {
    public static void main(String[] args) {
        Frame f = new Frame("Combined Layout");
        f.setLayout(new BorderLayout());

        Panel p1 = new Panel();
        p1.setLayout(new FlowLayout());
        p1.add(new Button("One"));
        p1.add(new Button("Two"));

        Panel p2 = new Panel();
        p2.setLayout(new GridLayout(2, 1));
        p2.add(new Button("Three"));
        p2.add(new Button("Four"));

        f.add(p1, BorderLayout.NORTH);
        f.add(p2, BorderLayout.CENTER);

        f.setSize(300, 200);
        f.setVisible(true);
    }
}

import java.awt.*;

public class CardLayoutDemo {
    public static void main(String[] args) {
        Frame f = new Frame("CardLayout");
        CardLayout cl = new CardLayout();
        f.setLayout(cl);
        f.setSize(300, 200);

        Panel p1 = new Panel();
        Panel p2 = new Panel();

        p1.add(new Button("Card1"));
        p2.add(new Button("Card2"));

        f.add(p1, "1");
        f.add(p2, "2");

        f.setVisible(true);
        cl.show(f, "2");
    }
}

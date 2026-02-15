import java.awt.*;

public class GridLayoutDemo {
    public static void main(String[] args) {
        Frame f = new Frame("GridLayout");
        f.setLayout(new GridLayout(2, 3));
        f.setSize(300, 200);

        for (int i = 1; i <= 6; i++) {
            f.add(new Button("G" + i));
        }

        f.setVisible(true);
    }
}

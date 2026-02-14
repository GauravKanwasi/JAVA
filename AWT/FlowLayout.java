import java.awt.*;

public class FlowLayoutExample extends Frame {
    public FlowLayoutExample() {
        setLayout(new FlowLayout());

        add(new Button("One"));
        add(new Button("Two"));
        add(new Button("Three"));
        add(new Button("Four"));
        add(new Button("Five"));

        setSize(400, 300);
        setTitle("FlowLayout");
        setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutExample();
    }
}

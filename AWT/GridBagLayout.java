import java.awt.*;

public class GridBagLayoutDemo {
    public static void main(String[] args) {
        Frame f = new Frame("GridBagLayout");
        f.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        f.setSize(300, 200);

        gbc.gridx = 0;
        gbc.gridy = 0;
        f.add(new Button("B1"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        f.add(new Button("B2"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        f.add(new Button("B3"), gbc);

        f.setVisible(true);
    }
}

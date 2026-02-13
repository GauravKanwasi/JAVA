import java.awt.*;
import java.awt.event.*;

public class mouse extends Frame implements MouseListener, MouseMotionListener {

    Label status;

    mouse() {
        setTitle("Mouse Event Demo");
        setSize(400, 300);
        setLayout(new FlowLayout());

        status = new Label("Perform a mouse action...");
        add(status);

        addMouseListener(this);
        addMouseMotionListener(this);

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    public void mouseClicked(MouseEvent e) {
        status.setText("Mouse Clicked at: " + e.getX() + ", " + e.getY());
    }

    public void mousePressed(MouseEvent e) {
        status.setText("Mouse Pressed");
    }

    public void mouseReleased(MouseEvent e) {
        status.setText("Mouse Released");
    }

    public void mouseEntered(MouseEvent e) {
        status.setText("Mouse Entered Window");
    }

    public void mouseExited(MouseEvent e) {
        status.setText("Mouse Exited Window");
    }

    public void mouseDragged(MouseEvent e) {
        status.setText("Dragging: " + e.getX() + ", " + e.getY());
    }

    public void mouseMoved(MouseEvent e) {
        status.setText("Moving: " + e.getX() + ", " + e.getY());
    }

    public static void main(String[] args) {
        new mouse();
    }
}

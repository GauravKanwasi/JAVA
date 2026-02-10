import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WL extends Frame implements WindowListener {

    Label label;

    public WL() {
        label = new Label("Perform window actions (open, close, minimize, etc.)");
        add(label);

        addWindowListener(this);

        setSize(400, 200);
        setLayout(null);
        label.setBounds(50, 100, 300, 30);
        setTitle("WindowListener Demo");
        setVisible(true);
    }

    public void windowOpened(WindowEvent e) {
        System.out.println("windowOpened");
    }

    public void windowClosing(WindowEvent e) {
        System.out.println("windowClosing");
        dispose();
    }

    public void windowClosed(WindowEvent e) {
        System.out.println("windowClosed");
    }

    public void windowIconified(WindowEvent e) {
        System.out.println("windowIconified");
    }

    public void windowDeiconified(WindowEvent e) {
        System.out.println("windowDeiconified");
    }

    public void windowActivated(WindowEvent e) {
        System.out.println("windowActivated");
    }

    public void windowDeactivated(WindowEvent e) {
        System.out.println("windowDeactivated");
    }

    public static void main(String[] args) {
        new WL();
    }
}

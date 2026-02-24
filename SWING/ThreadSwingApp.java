import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadSwingApp extends JFrame {
    private final JLabel label;
    private final JButton startButton;
    private final JButton stopButton;
    private final AtomicBoolean running = new AtomicBoolean(false);
    private Thread worker;

    public ThreadSwingApp() {
        setTitle("Swing Thread Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        label = new JLabel("Counter: 0", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");

        startButton.addActionListener(e -> startThread());
        stopButton.addActionListener(e -> stopThread());

        JPanel panel = new JPanel();
        panel.add(startButton);
        panel.add(stopButton);

        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
    }

    private void startThread() {
        if (running.get()) return;
        running.set(true);

        worker = new Thread(() -> {
            int count = 0;
            while (running.get()) {
                int value = count++;
                SwingUtilities.invokeLater(() ->
                        label.setText("Counter: " + value)
                );
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        worker.start();
    }

    private void stopThread() {
        running.set(false);
        if (worker != null) {
            worker.interrupt();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ThreadSwingApp app = new ThreadSwingApp();
            app.setVisible(true);
        });
    }
}

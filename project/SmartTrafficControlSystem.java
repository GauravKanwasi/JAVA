import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * SmartTrafficControlSystem.java
 *
 * Single-file Java prototype for a Smart Traffic Control System with Swing GUI.
 *
 * Demonstrates:
 * - Abstraction: abstract TrafficSignal defines core methods
 * - Inheritance: StandardSignal, SmartSignal, PedestrianSignal
 * - Polymorphism: overriding controlMode(), overloading displaySignalStatus(...)
 * - Encapsulation: private fields with getters/setters
 * - Constructors: default & parameterized, constructor chaining
 * - this / super usage
 * - Static member: totalSignals counter
 *
 * GUI: displays signal panels for intersections, automatic simulation, manual override buttons
 *
 * Notes: simple simulation; can be extended to use sensors, files, threads per intersection, etc.
 */

abstract class TrafficSignal {
    // Encapsulated properties
    private String signalColor; // "GREEN", "YELLOW", "RED"
    private int timerDuration;  // seconds for current color
    private int vehicleCount;
    private String location;

    // static counter to track total signals
    private static int totalSignals = 0;

    // protected used for subclasses to access
    protected final Object lock = new Object();

    // Default constructor
    public TrafficSignal() {
        this("UNKNOWN", 30, 0); // constructor chaining
    }

    // Parameterized constructor
    public TrafficSignal(String location, int timerDuration, int vehicleCount) {
        this.location = location;
        this.timerDuration = timerDuration;
        this.vehicleCount = vehicleCount;
        this.signalColor = "RED";
        incrementSignalCount();
    }

    // Static counter methods
    private static void incrementSignalCount() {
        totalSignals++;
    }
    public static int getTotalSignals() {
        return totalSignals;
    }

    // Encapsulation: getters & setters
    public String getSignalColor() {
        synchronized (lock) {
            return signalColor;
        }
    }
    public void setSignalColor(String signalColor) {
        synchronized (lock) {
            this.signalColor = signalColor;
        }
    }
    public int getTimerDuration() {
        synchronized (lock) {
            return timerDuration;
        }
    }
    public void setTimerDuration(int timerDuration) {
        synchronized (lock) {
            this.timerDuration = timerDuration;
        }
    }
    public int getVehicleCount() {
        synchronized (lock) {
            return vehicleCount;
        }
    }
    public void setVehicleCount(int vehicleCount) {
        synchronized (lock) {
            this.vehicleCount = vehicleCount;
        }
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    // Abstract methods to implement in subclasses
    public abstract void changeSignal(String newSignal);
    public abstract void displaySignalStatus();
    public abstract void controlMode(); // automatic or manual

    // Overloaded display method - polymorphism by overloading
    public void displaySignalStatus(String extra) {
        System.out.printf("(%s) %s - %s\n", getLocation(), getSignalColor(), extra);
    }
}

// StandardSignal - fixed time intervals; allows manual override
class StandardSignal extends TrafficSignal {
    private boolean manualOverride = false;
    private int greenDuration; // default green duration
    private int yellowDuration;

    // Default constructor chaining
    public StandardSignal() {
        this("Standard Intersection", 30, 0, 20, 5);
    }

    public StandardSignal(String location, int timerDuration, int vehicleCount, int greenDuration, int yellowDuration) {
        super(location, timerDuration, vehicleCount);
        this.greenDuration = greenDuration;
        this.yellowDuration = yellowDuration;
    }

    public void setManualOverride(boolean manual) {
        this.manualOverride = manual;
    }
    public boolean isManualOverride() {
        return manualOverride;
    }

    @Override
    public void changeSignal(String newSignal) {
        setSignalColor(newSignal);
        // set timerDuration according to signal color
        if ("GREEN".equalsIgnoreCase(newSignal)) {
            setTimerDuration(greenDuration);
        } else if ("YELLOW".equalsIgnoreCase(newSignal)) {
            setTimerDuration(yellowDuration);
        } else if ("RED".equalsIgnoreCase(newSignal)) {
            setTimerDuration(greenDuration + yellowDuration); // keep red for combined time as placeholder
        }
        displaySignalStatus();
    }

    @Override
    public void displaySignalStatus() {
        System.out.printf("StandardSignal at %s -> %s for %d sec (vehicles=%d)\n",
                getLocation(), getSignalColor(), getTimerDuration(), getVehicleCount());
    }

    // Overriding controlMode to show manual override behavior
    @Override
    public void controlMode() {
        if (manualOverride) {
            System.out.println(getLocation() + " in MANUAL mode - officer can change signals.");
        } else {
            System.out.println(getLocation() + " in AUTOMATIC fixed-timing mode.");
        }
    }
}

// SmartSignal - adjusts timing based on vehicleCount (simulated sensors)
class SmartSignal extends TrafficSignal {
    private int baseGreen = 15;
    private int maxGreen = 50;
    private Random rnd = new Random();

    public SmartSignal() {
        this("Smart Intersection", 15, 0);
    }

    public SmartSignal(String location, int timerDuration, int vehicleCount) {
        super(location, timerDuration, vehicleCount);
    }

    // sensor simulation: update vehicle count randomly
    public void senseTraffic() {
        // simulate a sensor reading: 0..100 vehicles
        int sensed = rnd.nextInt(101);
        setVehicleCount(sensed);
    }

    // adjust green time based on vehicle count linearly
    private int computeGreen() {
        int v = getVehicleCount();
        int green = baseGreen + (int) ((maxGreen - baseGreen) * (Math.min(v, 100) / 100.0));
        return green;
    }

    @Override
    public void changeSignal(String newSignal) {
        setSignalColor(newSignal);
        if ("GREEN".equalsIgnoreCase(newSignal)) {
            int green = computeGreen();
            setTimerDuration(green);
        } else if ("YELLOW".equalsIgnoreCase(newSignal)) {
            setTimerDuration(5);
        } else if ("RED".equalsIgnoreCase(newSignal)) {
            setTimerDuration(10);
        }
        displaySignalStatus();
    }

    @Override
    public void displaySignalStatus() {
        System.out.printf("SmartSignal at %s -> %s for %d sec (vehicles=%d)\n",
                getLocation(), getSignalColor(), getTimerDuration(), getVehicleCount());
    }

    @Override
    public void controlMode() {
        System.out.println(getLocation() + " in SMART automatic mode (adapts to traffic density).");
    }
}

// PedestrianSignal - supports pedestrian crossing requests
class PedestrianSignal extends TrafficSignal {
    private AtomicBoolean pedestrianWaiting = new AtomicBoolean(false);

    public PedestrianSignal() {
        this("Pedestrian Intersection", 10, 0);
    }

    public PedestrianSignal(String location, int timerDuration, int vehicleCount) {
        super(location, timerDuration, vehicleCount);
    }

    public void requestCrossing() {
        pedestrianWaiting.set(true);
        System.out.println("Pedestrian requested crossing at " + getLocation());
    }

    public boolean isPedestrianWaiting() {
        return pedestrianWaiting.get();
    }

    public void clearPedestrianRequest() {
        pedestrianWaiting.set(false);
    }

    @Override
    public void changeSignal(String newSignal) {
        setSignalColor(newSignal);
        if ("WALK".equalsIgnoreCase(newSignal) || "GREEN".equalsIgnoreCase(newSignal)) {
            setTimerDuration(10);
        } else {
            setTimerDuration(5);
        }
        displaySignalStatus();
    }

    @Override
    public void displaySignalStatus() {
        System.out.printf("PedestrianSignal at %s -> %s for %d sec (pedWaiting=%s)\n",
                getLocation(), getSignalColor(), getTimerDuration(), isPedestrianWaiting());
    }

    @Override
    public void controlMode() {
        System.out.println(getLocation() + " supports pedestrian request-driven crossing.");
    }
}

/**
 * IntersectionPanel - GUI panel representing one intersection and its signal
 */
class IntersectionPanel extends JPanel {
    private TrafficSignal signal;
    private JLabel locationLabel;
    private JPanel lightPanel;
    private JLabel countLabel;
    private JButton manualButton;
    private JButton pedestrianButton; // only used if PedestrianSignal

    // control for simulation
    private javax.swing.Timer guiTimer;
    private Thread signalThread;
    private volatile boolean running = true;

    public IntersectionPanel(TrafficSignal signal) {
        this.signal = signal;
        setupUI();
        startSimulation();
    }

    private void setupUI() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        locationLabel = new JLabel(signal.getLocation(), SwingConstants.CENTER);
        locationLabel.setFont(locationLabel.getFont().deriveFont(Font.BOLD, 14f));
        add(locationLabel, BorderLayout.NORTH);

        lightPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // draw 3 circles for traffic lights
                int w = getWidth();
                int h = getHeight();
                int size = Math.min(w, h) / 3;
                int cx = w / 2 - size / 2;
                int y = 10;
                // Determine colors
                String color = signal.getSignalColor();
                Color greenC = "GREEN".equalsIgnoreCase(color) || "WALK".equalsIgnoreCase(color) ? Color.GREEN : Color.GRAY;
                Color yellowC = "YELLOW".equalsIgnoreCase(color) ? Color.YELLOW : Color.GRAY;
                Color redC = "RED".equalsIgnoreCase(color) ? Color.RED : Color.GRAY;

                g.setColor(redC);
                g.fillOval(cx, y, size, size);
                g.setColor(yellowC);
                g.fillOval(cx, y + size + 8, size, size);
                g.setColor(greenC);
                g.fillOval(cx, y + 2*(size + 8), size, size);
            }
        };
        lightPanel.setPreferredSize(new Dimension(120, 180));
        add(lightPanel, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER, 6, 6));
        countLabel = new JLabel("Vehicles: " + signal.getVehicleCount());
        bottom.add(countLabel);

        manualButton = new JButton("Toggle Manual");
        manualButton.addActionListener(e -> {
            if (signal instanceof StandardSignal) {
                StandardSignal ss = (StandardSignal) signal;
                ss.setManualOverride(!ss.isManualOverride());
                ss.controlMode();
            } else {
                JOptionPane.showMessageDialog(this, "Manual toggle only meaningful for StandardSignal.");
            }
        });
        bottom.add(manualButton);

        pedestrianButton = new JButton("Pedestrian Request");
        pedestrianButton.addActionListener(e -> {
            if (signal instanceof PedestrianSignal) {
                ((PedestrianSignal) signal).requestCrossing();
            } else {
                JOptionPane.showMessageDialog(this, "Only available for PedestrianSignal.");
            }
        });
        bottom.add(pedestrianButton);

        add(bottom, BorderLayout.SOUTH);

        // GUI update timer to repaint regularly
        guiTimer = new javax.swing.Timer(500, (e) -> {
            countLabel.setText("Vehicles: " + signal.getVehicleCount());
            lightPanel.repaint();
        });
        guiTimer.start();
    }

    private void startSimulation() {
        signalThread = new Thread(() -> {
            try {
                while (running) {
                    if (signal instanceof SmartSignal) {
                        SmartSignal ss = (SmartSignal) signal;
                        ss.senseTraffic();
                        ss.controlMode();
                    } else if (signal instanceof StandardSignal) {
                        // simulate constant small variation of vehicles
                        StandardSignal st = (StandardSignal) signal;
                        st.setVehicleCount(Math.max(0, st.getVehicleCount() + (new Random().nextInt(7) - 3)));
                    } else if (signal instanceof PedestrianSignal) {
                        // maybe nothing here
                    }

                    // Example sequence: GREEN -> YELLOW -> RED -> (repeat)
                    // But PedestrianSignal may insert WALK if requested
                    if (signal instanceof PedestrianSignal) {
                        PedestrianSignal ps = (PedestrianSignal) signal;
                        if (ps.isPedestrianWaiting()) {
                            ps.changeSignal("WALK");
                            Thread.sleep(ps.getTimerDuration() * 1000L);
                            ps.clearPedestrianRequest();
                            ps.changeSignal("RED");
                            Thread.sleep(ps.getTimerDuration() * 1000L);
                            continue;
                        }
                    }

                    // If standard signal in manual override, pause and wait until toggled
                    if (signal instanceof StandardSignal) {
                        StandardSignal st = (StandardSignal) signal;
                        if (st.isManualOverride()) {
                            // in manual mode - wait (simulate officer control)
                            st.changeSignal("RED");
                            Thread.sleep(1000 * 3); // brief pause
                            continue; // loop and check again
                        }
                    }

                    // normal automatic cycle
                    signal.changeSignal("GREEN");
                    Thread.sleep(signal.getTimerDuration() * 1000L);

                    signal.changeSignal("YELLOW");
                    Thread.sleep(signal.getTimerDuration() * 1000L);

                    signal.changeSignal("RED");
                    Thread.sleep(signal.getTimerDuration() * 1000L);
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }, signal.getLocation() + "-Thread");
        signalThread.setDaemon(true);
        signalThread.start();
    }

    public void stopSimulation() {
        running = false;
        guiTimer.stop();
        if (signalThread != null) signalThread.interrupt();
    }
}

/**
 * Main application frame and entry point
 */
public class SmartTrafficControlSystem {
    private JFrame frame;
    private JLabel totalLabel;
    private java.util.List<IntersectionPanel> panels = new java.util.ArrayList<>();

    public SmartTrafficControlSystem() {
        SwingUtilities.invokeLater(this::createAndShowGUI);
    }

    private void createAndShowGUI() {
        frame = new JFrame("Smart Traffic Control System - Prototype");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        totalLabel = new JLabel("Total signals: " + TrafficSignal.getTotalSignals());
        JButton refreshBtn = new JButton("Refresh Count");
        refreshBtn.addActionListener(e -> totalLabel.setText("Total signals: " + TrafficSignal.getTotalSignals()));
        top.add(totalLabel);
        top.add(refreshBtn);

        // Quick instructions
        JLabel instructions = new JLabel("<html><i>Click 'Toggle Manual' to switch StandardSignal to manual.<br>" +
                "Use 'Pedestrian Request' to request crossing at pedestrian intersection.</i></html>");
        top.add(instructions);

        frame.add(top, BorderLayout.NORTH);

        // Create signals and panels
        JPanel center = new JPanel(new GridLayout(1, 3, 10, 10));

        // Intersection 1: StandardSignal
        StandardSignal s1 = new StandardSignal("Intersection A (Standard)", 20, 10, 20, 4);
        s1.setVehicleCount(12);
        IntersectionPanel p1 = new IntersectionPanel(s1);
        panels.add(p1);
        center.add(p1);

        // Intersection 2: SmartSignal
        SmartSignal s2 = new SmartSignal("Intersection B (Smart)", 15, 30);
        s2.setVehicleCount(30);
        IntersectionPanel p2 = new IntersectionPanel(s2);
        panels.add(p2);
        center.add(p2);

        // Intersection 3: PedestrianSignal
        PedestrianSignal s3 = new PedestrianSignal("Intersection C (Pedestrian)", 10, 0);
        IntersectionPanel p3 = new IntersectionPanel(s3);
        panels.add(p3);
        center.add(p3);

        frame.add(center, BorderLayout.CENTER);

        // Footer with exit button
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        JButton exit = new JButton("Exit");
        exit.addActionListener(e -> {
            stopAll();
            frame.dispose();
            System.exit(0);
        });
        footer.add(exit);
        frame.add(footer, BorderLayout.SOUTH);

        frame.setSize(900, 380);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Update totalLabel initially
        totalLabel.setText("Total signals: " + TrafficSignal.getTotalSignals());
    }

    private void stopAll() {
        for (IntersectionPanel p : panels) {
            p.stopSimulation();
        }
    }

    public static void main(String[] args) {
        // Create some signals to demonstrate static counter increments outside GUI creation too
        System.out.println("Starting Smart Traffic Control System...");
        // Launch the GUI + simulation
        new SmartTrafficControlSystem();
    }
}

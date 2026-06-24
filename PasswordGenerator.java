import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGeneratorUI extends JFrame {

    private static final String CHAR_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPERCASE = CHAR_LOWERCASE.toUpperCase();
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;:'\",.<>/?";
    private static final SecureRandom random = new SecureRandom();

    private JTextField passwordOutput;
    private JSpinner lengthSpinner;
    private JCheckBox lowerCaseCheck;
    private JCheckBox upperCaseCheck;
    private JCheckBox digitsCheck;
    private JCheckBox specialCheck;

    public PasswordGeneratorUI() {
        setTitle("Secure Password Generator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        initializeUI();
    }

    private void initializeUI() {
        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        passwordOutput = new JTextField();
        passwordOutput.setFont(new Font("Monospaced", Font.BOLD, 16));
        passwordOutput.setEditable(false);
        passwordOutput.setHorizontalAlignment(JTextField.CENTER);

        JButton copyButton = new JButton("Copy");
        copyButton.addActionListener(e -> copyToClipboard());

        topPanel.add(passwordOutput, BorderLayout.CENTER);
        topPanel.add(copyButton, BorderLayout.EAST);

        JPanel centerPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JPanel lengthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lengthPanel.add(new JLabel("Password Length: "));
        lengthSpinner = new JSpinner(new SpinnerNumberModel(16, 4, 128, 1));
        lengthPanel.add(lengthSpinner);
        centerPanel.add(lengthPanel);

        lowerCaseCheck = new JCheckBox("Include Lowercase (a-z)", true);
        upperCaseCheck = new JCheckBox("Include Uppercase (A-Z)", true);
        digitsCheck = new JCheckBox("Include Numbers (0-9)", true);
        specialCheck = new JCheckBox("Include Symbols (!@#$)", true);

        centerPanel.add(lowerCaseCheck);
        centerPanel.add(upperCaseCheck);
        centerPanel.add(digitsCheck);
        centerPanel.add(specialCheck);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        JButton generateButton = new JButton("Generate Password");
        generateButton.setFont(new Font("Arial", Font.BOLD, 14));
        generateButton.setPreferredSize(new Dimension(200, 40));
        
        generateButton.addActionListener(e -> generateAndDisplayPassword());
        bottomPanel.add(generateButton);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        
        generateAndDisplayPassword();
    }

    private void generateAndDisplayPassword() {
        int length = (int) lengthSpinner.getValue();
        boolean useLower = lowerCaseCheck.isSelected();
        boolean useUpper = upperCaseCheck.isSelected();
        boolean useDigits = digitsCheck.isSelected();
        boolean useSpecial = specialCheck.isSelected();

        if (!useLower && !useUpper && !useDigits && !useSpecial) {
            JOptionPane.showMessageDialog(this, "You must select at least one character type!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String password = generatePasswordLogic(length, useLower, useUpper, useDigits, useSpecial);
        passwordOutput.setText(password);
    }

    private String generatePasswordLogic(int length, boolean useLower, boolean useUpper, boolean useDigits, boolean useSpecial) {
        StringBuilder charPool = new StringBuilder();
        List<Character> passwordChars = new ArrayList<>();

        if (useLower) {
            charPool.append(CHAR_LOWERCASE);
            passwordChars.add(CHAR_LOWERCASE.charAt(random.nextInt(CHAR_LOWERCASE.length())));
        }
        if (useUpper) {
            charPool.append(CHAR_UPPERCASE);
            passwordChars.add(CHAR_UPPERCASE.charAt(random.nextInt(CHAR_UPPERCASE.length())));
        }
        if (useDigits) {
            charPool.append(DIGITS);
            passwordChars.add(DIGITS.charAt(random.nextInt(DIGITS.length())));
        }
        if (useSpecial) {
            charPool.append(SPECIAL_CHARS);
            passwordChars.add(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));
        }

        String poolString = charPool.toString();
        for (int i = passwordChars.size(); i < length; i++) {
            passwordChars.add(poolString.charAt(random.nextInt(poolString.length())));
        }

        Collections.shuffle(passwordChars, random);

        StringBuilder finalPassword = new StringBuilder();
        for (char c : passwordChars) {
            finalPassword.append(c);
        }

        return finalPassword.toString();
    }

    private void copyToClipboard() {
        String password = passwordOutput.getText();
        if (password != null && !password.isEmpty()) {
            StringSelection stringSelection = new StringSelection(password);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            JOptionPane.showMessageDialog(this, "Password copied to clipboard!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PasswordGeneratorUI app = new PasswordGeneratorUI();
            app.setVisible(true);
        });
    }
}

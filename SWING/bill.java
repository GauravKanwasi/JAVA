import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bill extends JFrame implements ActionListener {

    JLabel title, itemLabel, priceLabel, qtyLabel, totalLabel;
    JTextField itemField, priceField, qtyField;
    JButton addButton, clearButton;
    JTextArea billArea;
    double grandTotal = 0;

    public bill() {
        setTitle("Simple Billing Menu");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        title = new JLabel("Billing Menu", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        itemLabel = new JLabel("Item Name:");
        priceLabel = new JLabel("Price:");
        qtyLabel = new JLabel("Quantity:");
        totalLabel = new JLabel("Grand Total: 0.0");

        itemField = new JTextField();
        priceField = new JTextField();
        qtyField = new JTextField();

        addButton = new JButton("Add Item");
        clearButton = new JButton("Clear Bill");

        addButton.addActionListener(this);
        clearButton.addActionListener(this);

        inputPanel.add(itemLabel);
        inputPanel.add(itemField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);
        inputPanel.add(qtyLabel);
        inputPanel.add(qtyField);
        inputPanel.add(addButton);
        inputPanel.add(clearButton);

        add(inputPanel, BorderLayout.CENTER);

        billArea = new JTextArea();
        billArea.setEditable(false);
        billArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(billArea);

        add(scrollPane, BorderLayout.SOUTH);
        add(totalLabel, BorderLayout.WEST);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            try {
                String item = itemField.getText();
                double price = Double.parseDouble(priceField.getText());
                int qty = Integer.parseInt(qtyField.getText());

                double total = price * qty;
                grandTotal += total;

                billArea.append(item + "  x" + qty + "  = " + total + "\n");
                totalLabel.setText("Grand Total: " + grandTotal);

                itemField.setText("");
                priceField.setText("");
                qtyField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter valid input");
            }
        }

        if (e.getSource() == clearButton) {
            billArea.setText("");
            grandTotal = 0;
            totalLabel.setText("Grand Total: 0.0");
            itemField.setText("");
            priceField.setText("");
            qtyField.setText("");
        }
    }

    public static void main(String[] args) {
        new bill();
    }
}

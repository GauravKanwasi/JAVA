import java.awt.*;
import java.awt.event.*;

public class SI_Calculator extends Frame implements ActionListener {

    Label lblPrincipal, lblRate, lblTime, lblResult;
    TextField txtPrincipal, txtRate, txtTime, txtResult;
    Button btnCalculate, btnClear;

    public SI_Calculator() {
        setTitle("Simple Interest Calculator (AWT)");
        setSize(350, 250);
        setLayout(new GridLayout(5, 2, 10, 10));

        lblPrincipal = new Label("Principal:");
        lblRate = new Label("Rate (%):");
        lblTime = new Label("Time (years):");
        lblResult = new Label("Simple Interest:");


      
        txtPrincipal = new TextField();
        txtRate = new TextField();
        txtTime = new TextField();
        txtResult = new TextField();
        txtResult.setEditable(false);

        btnCalculate = new Button("Calculate");
        btnClear = new Button("Clear");

        btnCalculate.addActionListener(this);
        btnClear.addActionListener(this);

        add(lblPrincipal);
        add(txtPrincipal);


      
        add(lblRate);
        add(txtRate);

        add(lblTime);
        add(txtTime);

        add(lblResult);
        add(txtResult);

        add(btnCalculate);
        add(btnClear);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    
    
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnCalculate) {
                double principal = Double.parseDouble(txtPrincipal.getText());
                double rate = Double.parseDouble(txtRate.getText());
                double time = Double.parseDouble(txtTime.getText());

                double si = (principal * rate * time) / 100;
                txtResult.setText(String.valueOf(si));
            }

            if (e.getSource() == btnClear) {
                txtPrincipal.setText("");
                txtRate.setText("");
                txtTime.setText("");
                txtResult.setText("");
            }
        } catch (NumberFormatException ex) {
            txtResult.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new SI_Calculator();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JTextField resultField;

    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;

    public Calculator() {
        setTitle("Simple Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("First Number:"));
        firstNumberField = new JTextField();
        add(firstNumberField);

        add(new JLabel("Second Number:"));
        secondNumberField = new JTextField();
        add(secondNumberField);

        add(new JLabel("Result:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double first = Double.parseDouble(firstNumberField.getText());
            double second = Double.parseDouble(secondNumberField.getText());

            double result;

            if (e.getSource() == addButton) {
                result = first + second;
            } else if (e.getSource() == subtractButton) {
                result = first - second;
            } else if (e.getSource() == multiplyButton) {
                result = first * second;
            } else {
                if (second == 0) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Division by zero is not allowed.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                result = first / second;
            }

            resultField.setText(String.valueOf(result));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numbers.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}

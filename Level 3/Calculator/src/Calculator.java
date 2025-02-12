import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField textField;
    private String operator;
    private double num1, num2, result;

    public Calculator() {
        setTitle("Swing Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(300, 70));
        add(topPanel, BorderLayout.NORTH);

        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setPreferredSize(new Dimension(300, 50));
        topPanel.add(textField, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9]") || command.equals(".")) {
            textField.setText(textField.getText() + command);
        } else if (command.equals("C")) {
            textField.setText("");
            num1 = num2 = result = 0;
            operator = "";
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = (num2 != 0) ? num1 / num2 : 0; break;
            }
            textField.setText(String.valueOf(result));
        } else {
            num1 = Double.parseDouble(textField.getText());
            operator = command;
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class TemperatureConverterGUI extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;

    public TemperatureConverterGUI() {
        setTitle("Temperature Converter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(230, 230, 230)); // Setting background color
        setLayout(null);

        JLabel inputLabel = new JLabel("Enter temperature:");
        inputLabel.setBounds(20, 20, 150, 25);
        inputLabel.setForeground(new Color(70, 130, 180)); // Dark blue color for the label
        add(inputLabel);

        inputField = new JTextField();
        inputField.setBounds(150, 20, 100, 25);
        add(inputField);

        JButton celsiusToFahrenheitButton = new JButton("C to F");
        celsiusToFahrenheitButton.setBounds(50, 60, 80, 25);
        celsiusToFahrenheitButton.setBackground(new Color(144, 238, 144)); // Light green button
        add(celsiusToFahrenheitButton);

        JButton fahrenheitToCelsiusButton = new JButton("F to C");
        fahrenheitToCelsiusButton.setBounds(150, 60, 80, 25);
        fahrenheitToCelsiusButton.setBackground(new Color(255, 192, 203)); // Light pink button
        add(fahrenheitToCelsiusButton);

        resultLabel = new JLabel("Result:");
        resultLabel.setBounds(100, 100, 150, 25);
        resultLabel.setForeground(new Color(128, 0, 128)); // Purple color for the label
        add(resultLabel);

        celsiusToFahrenheitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                if (!inputText.isEmpty()) {
                    double celsius = Double.parseDouble(inputText);
                    double fahrenheit = celsiusToFahrenheit(celsius);
                    resultLabel.setText(celsius + "°C = " + fahrenheit + "°F");
                } else {
                    resultLabel.setText("Please enter a value.");
                }
            }
        });

        fahrenheitToCelsiusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                if (!inputText.isEmpty()) {
                    double fahrenheit = Double.parseDouble(inputText);
                    double celsius = fahrenheitToCelsius(fahrenheit);
                    resultLabel.setText(fahrenheit + "°F = " + celsius + "°C");
                } else {
                    resultLabel.setText("Please enter a value.");
                }
            }
        });
    }

    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TemperatureConverterGUI converter = new TemperatureConverterGUI();
                converter.setVisible(true);
            }
        });
    }
}

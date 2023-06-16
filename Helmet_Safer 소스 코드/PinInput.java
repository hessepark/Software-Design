import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PinInput {
    private JFrame frame;
    private JPanel pinNumberPanel;
    private JTextField codeDisplay;
    private JButton[] buttons;
    private JLabel inputLabel;
    private JLabel inputLabel1;
    private JButton exitButton;
    private  String buttonText;

    public PinInput(JFrame frame) {
        this.frame = frame;
        initialize();
    }

    private void initialize() {
        pinNumberPanel = new JPanel(null);
        pinNumberPanel.setBackground(new Color(222, 235, 247));

        codeDisplay = new JTextField();
        codeDisplay.setBounds(75, 120, 200, 40);
        codeDisplay.setFont(new Font("Arial", Font.PLAIN, 20));
        codeDisplay.setEditable(false);
        pinNumberPanel.add(codeDisplay);

        buttons = new JButton[12];
        String[] buttonLabels = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "R", "0", "D"};

        for (int i = 0; i < 12; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setBounds(75 + (i % 3) * 70, 180 + (i / 3) * 70, 60, 60);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            pinNumberPanel.add(buttons[i]);

            int index = i;
            buttons[i].addActionListener(e -> {
                buttonText = buttons[index].getText();
                if (buttonText.equals("R")) {
                    String pinNumber = codeDisplay.getText();
                    if (UserManager.getPinNumber().equals(pinNumber)) {
                    	System.out.println("PIN number checked: " + pinNumber);
                        pinNumberPanel.setVisible(false);
                        frame.remove(pinNumberPanel);
                        frame.repaint();
                        new HelmetCodeInput(frame);
                    } else {
                    	
                        JOptionPane.showMessageDialog(pinNumberPanel, "Please enter a valid 4-digit PIN number.", "Invalid code", JOptionPane.ERROR_MESSAGE);
                        pinNumberPanel.setVisible(true);
                    }
                } else if (buttonText.equals("D")) {
                    String currentText = codeDisplay.getText();
                    if (!currentText.isEmpty()) {
                        codeDisplay.setText(currentText.substring(0, currentText.length() - 1));
                    }
                } else if (buttonText.equals("Exit")) {
                    pinNumberPanel.setVisible(false);
                    frame.remove(pinNumberPanel);
                    frame.repaint();
                    Login.initialize(frame);
                } else {
                    codeDisplay.setText(codeDisplay.getText() + buttonText);
                }
            });
        }

        inputLabel = new JLabel("4ÀÚ¸®");
        inputLabel.setFont(new Font("±¼¸²", Font.BOLD, 24));
        inputLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputLabel.setBounds(50, 23, 256, 64);
        pinNumberPanel.add(inputLabel);

        inputLabel1 = new JLabel("PIN Number ÀÔ·Â");
        inputLabel1.setFont(new Font("±¼¸²", Font.BOLD, 24));
        inputLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        inputLabel1.setBounds(50, 53, 256, 64);
        pinNumberPanel.add(inputLabel1);

        exitButton = new JButton("Exit");
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(new Color(68, 114, 196));
        exitButton.setBounds(125, 470, 100, 30);
        pinNumberPanel.add(exitButton);

        exitButton.addActionListener(e -> {
            pinNumberPanel.setVisible(false);
            frame.remove(pinNumberPanel);
            frame.repaint();
            Login.initialize(frame);
        });

        buttons[9].setFont(new Font("Arial", Font.PLAIN, 10));
        buttons[11].setFont(new Font("Arial", Font.PLAIN, 10));

        frame.getContentPane().add(pinNumberPanel);
    }
}
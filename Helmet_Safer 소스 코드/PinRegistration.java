import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.SwingConstants;

public class PinRegistration {
	
	//public static String pinNumber1=null; -> UserManager에서 따로 만들어줌
	
    private JPanel pinNumberPanel;
    private JTextField codeDisplay;
    private JFrame frame;

    public void initialize(JFrame parentFrame) {
        frame = parentFrame;
        createPinNumberPanel();
        addComponentsToPinNumberPanel();
        addPinNumberPanelToFrame();
    }

    private void createPinNumberPanel() {
        pinNumberPanel = new JPanel(null);
        pinNumberPanel.setBackground(new Color(222, 235, 247));
    }

    private void addComponentsToPinNumberPanel() {
        codeDisplay = new JTextField();
        codeDisplay.setBounds(75, 120, 200, 40);
        codeDisplay.setFont(new Font("Arial", Font.PLAIN, 20));
        codeDisplay.setEditable(false);
        pinNumberPanel.add(codeDisplay);

        JButton[] buttons = new JButton[12];
        String[] buttonLabels = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "R", "0", "D"};

        for (int i = 0; i < 12; i++) {
            buttons[i] = createButton(buttonLabels[i], i);
            pinNumberPanel.add(buttons[i]);
        }

        JLabel inputLabel = createLabel("4자리", 23);
        JLabel inputLabel1 = createLabel("PIN Number 설정", 53);
        JButton exitButton = createExitButton();

        pinNumberPanel.add(inputLabel);
        pinNumberPanel.add(inputLabel1);
        pinNumberPanel.add(exitButton);
    }

    private JButton createButton(String label, int buttonIndex) {
        JButton button = new JButton(label);
        button.setBounds(75 + (buttonIndex % 3) * 70, 180 + (buttonIndex / 3) * 70, 60, 60);
        button.setFont(new Font("Arial", Font.PLAIN, 20));

        button.addActionListener(e -> handleButtonAction(button.getText()));

        return button;
    }

    private JLabel createLabel(String text, int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("굴림", Font.BOLD, 24));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(50, y, 256, 64);
        return label;
    }

    private JButton createExitButton() {
        JButton exitButton = new JButton("Exit");
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(new Color(68, 114, 196));
        exitButton.setBounds(125, 470, 100, 30);

        exitButton.addActionListener(e -> {
            removePinNumberPanel();
            frame.repaint();
            Login.initialize(frame);
        });

        return exitButton;
    }

    private void addPinNumberPanelToFrame() {
        frame.getContentPane().add(pinNumberPanel);
    }

    private void removePinNumberPanel() {
        pinNumberPanel.setVisible(false);
        frame.remove(pinNumberPanel);
    }

    private void handleButtonAction(String buttonText) {
        if (buttonText.equals("R")) {
            String pinNumber = codeDisplay.getText();
            if (pinNumber.length() == 4) {
            	System.out.println("Registered PIN number: " + pinNumber);
            	UserManager.setPinNumber(pinNumber);;
                removePinNumberPanel();
                frame.repaint();
                Login.initialize(frame);
            } else {
                JOptionPane.showMessageDialog(pinNumberPanel, "Please enter a 4-digit PIN number.", "Invalid code", JOptionPane.ERROR_MESSAGE);
            }
        } else if (buttonText.equals("D")) {
            String currentText = codeDisplay.getText();
            if (!currentText.isEmpty()) {
                codeDisplay.setText(currentText.substring(0, currentText.length() - 1));
            }
        } else {
            codeDisplay.setText(codeDisplay.getText() + buttonText);
        }
    }

}
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HelmetCodeInput {
    private JFrame frame;
    private JPanel codeNumberPanel;
    private JTextField codeDisplay;
    private JLabel digitLabel;
    private JLabel inputHcodeLabel;
    private JButton exitButton;

    public HelmetCodeInput(JFrame frame) {
        this.frame = frame;
        initialize();
    }

    private void initialize() {
        codeNumberPanel = new JPanel(null);
        codeNumberPanel.setBackground(new Color(222, 235, 247)); 

        codeDisplay = new JTextField();
        codeDisplay.setBounds(75, 120, 200, 40);
        codeDisplay.setFont(new Font("Arial", Font.PLAIN, 20));
        codeDisplay.setEditable(false);
        codeNumberPanel.add(codeDisplay);

        JButton[] buttons = new JButton[12];
        String[] buttonLabels = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "R", "0", "D"};

        for (int i = 0; i < 12; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setBounds(75 + (i % 3) * 70, 180 + (i / 3) * 70, 60, 60);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            codeNumberPanel.add(buttons[i]);

            int index = i; 

            buttons[i].addActionListener(e -> {
                String buttonText = buttons[index].getText();
                if (buttonText.equals("R")) {
                    String codeNumber = codeDisplay.getText();
                    if (codeNumber.length() == 6) {
                       
                        registerHelmetCodeNumber(codeNumber);

                     
                        codeNumberPanel.setVisible(false); 
                        frame.remove(codeNumberPanel); 
                        frame.repaint();

                       
                        new RegistrationConfirmation(frame);
                    } else {
                        JOptionPane.showMessageDialog(codeNumberPanel, "Please enter a 6-digit code number.", "Invalid code", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (buttonText.equals("D")) {
                   
                    String currentText = codeDisplay.getText();
                    if (!currentText.isEmpty()) {
                        codeDisplay.setText(currentText.substring(0, currentText.length() - 1));
                    }
                } else if (buttonText.equals("Exit")) {
                 
                    codeNumberPanel.setVisible(false);
                    frame.remove(codeNumberPanel); 
                    frame.repaint(); 

                    
                    Login.initialize(frame); 
                } else {
                   
                    codeDisplay.setText(codeDisplay.getText() + buttonText);
                }
            });
        }

        buttons[9].setFont(new Font("Arial", Font.PLAIN, 10));
        buttons[11].setFont(new Font("Arial", Font.PLAIN, 10));

        digitLabel = new JLabel("6ÀÚ¸®");
        digitLabel.setFont(new Font("±¼¸²", Font.BOLD, 24));
        digitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        digitLabel.setBounds(50, 23, 256, 64);
        codeNumberPanel.add(digitLabel);

        inputHcodeLabel = new JLabel("Input Hcode");
        inputHcodeLabel.setFont(new Font("±¼¸²", Font.BOLD, 24));
        inputHcodeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputHcodeLabel.setBounds(50, 53, 256, 64);
        codeNumberPanel.add(inputHcodeLabel);

        exitButton = new JButton("Exit");
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(new Color(68, 114, 196));
        exitButton.setBounds(125, 470, 100, 30);
        codeNumberPanel.add(exitButton);

        exitButton.addActionListener(e -> {
            codeNumberPanel.setVisible(false);
            frame.remove(codeNumberPanel); 
            frame.repaint(); 
            Login.initialize(frame);
        });

        frame.getContentPane().add(codeNumberPanel); 
    }

    private void registerHelmetCodeNumber(String helmetCodeNumber) {
        System.out.println("Registered helmet Code number: " + helmetCodeNumber);
       
    }
}
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Report {
    private JFrame frame;
    private JPanel reportPanel;
    private JButton homeButton;
    private JTextArea reportTextArea;
    private JTextArea inputTextArea;
    private JLabel inputLabel;
    private JButton submitButton;
    private JPanel buttonPanel;
    private JPanel inputPanel;
    private JScrollPane reportScrollPane;

    public Report(JFrame frame) {
        this.frame = frame;
        initialize();
    }

    private void initialize() {
        reportPanel = new JPanel();
        reportPanel.setLayout(new BorderLayout());

       
        homeButton = new JButton("Home");
        homeButton.addActionListener(e -> {
           
            Login.initialize(frame);
        });
        reportPanel.add(homeButton, BorderLayout.SOUTH);

     
        reportTextArea = new JTextArea(10, 30);
        reportTextArea.setEditable(false);

        reportScrollPane = new JScrollPane(reportTextArea);
        reportScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        reportPanel.add(reportScrollPane, BorderLayout.CENTER);

      
        inputTextArea = new JTextArea(5, 30);
        inputLabel = new JLabel("¿äÃ» »çÇ× ÀÔ·Â: ");
        inputLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16)); 
        inputLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0)); 

    
        inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputLabel, BorderLayout.NORTH);
        inputPanel.add(new JScrollPane(inputTextArea), BorderLayout.CENTER);

        
        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String input = inputTextArea.getText();
            reportTextArea.append(input + "\n"); 
            inputTextArea.setText("");

           
            reportTextArea.setCaretPosition(reportTextArea.getDocument().getLength());
        });

      
        buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(homeButton);

       
        reportPanel.add(inputPanel, BorderLayout.NORTH);
        reportPanel.add(buttonPanel, BorderLayout.SOUTH);

       
        frame.getContentPane().removeAll();
        frame.getContentPane().add(reportPanel);
        frame.revalidate();
        frame.repaint();
    }
}
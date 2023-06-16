import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OutOfRange {
    private JFrame frame;
    private JPanel outOfRangeScreenPanel;
    private JLabel helmetLabel;
    private JLabel actionLabel;
    private JButton emergencyButton;
    private ImageIcon icon;
    private Image image;
    private Image resizedImage;
    private ImageIcon resizedIcon;
    private JLabel imageLabel;

    public OutOfRange(JFrame frame) {
        this.frame = frame;
        initialize();
    }

    private void initialize() {
        outOfRangeScreenPanel = new JPanel();
        outOfRangeScreenPanel.setBackground(new Color(222, 235, 247));
        outOfRangeScreenPanel.setLayout(new BorderLayout());

        helmetLabel = new JLabel("Çï¸äÀÌ ¹üÀ§ ¾È¿¡ ¾ø½À´Ï´Ù.");
        helmetLabel.setFont(new Font("±¼¸²", Font.BOLD, 27));
        helmetLabel.setHorizontalAlignment(SwingConstants.CENTER);
        helmetLabel.setBounds(2, 5, 400, 100);
        outOfRangeScreenPanel.add(helmetLabel);

        actionLabel = new JLabel("°ð ÀÛµ¿À» ¸ØÃä´Ï´Ù.");
        actionLabel.setFont(new Font("±¼¸²", Font.BOLD, 30));
        actionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        actionLabel.setBounds(25, 65, 350, 100);
        outOfRangeScreenPanel.add(actionLabel);

        emergencyButton = new JButton("ºñ»ó ÀÛµ¿");
        emergencyButton.setForeground(Color.WHITE);
        emergencyButton.setBackground(new Color(112, 48, 160));
        emergencyButton.setBounds(260, 430, 90, 90);
        outOfRangeScreenPanel.add(emergencyButton);
        
        emergencyButton.addActionListener(e -> {
            System.out.println("Purple button clicked!");
            new EmergencyOpration(frame);
        });

        icon = new ImageIcon("emergency.png");
        image = icon.getImage();
        resizedImage = image.getScaledInstance(300, 280, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(resizedImage);
        imageLabel = new JLabel(resizedIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        outOfRangeScreenPanel.add(imageLabel, BorderLayout.CENTER);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(outOfRangeScreenPanel);
        frame.revalidate();
        frame.repaint();
    }
}
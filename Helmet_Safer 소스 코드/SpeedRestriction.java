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

public class SpeedRestriction {
    private JFrame frame;
    private JPanel restrictedScreenPanel;
    private JLabel distanceLabel;
    private JLabel speedLimitLabel;
    private JButton redButton;
    private JLabel imageLabel;
    private ImageIcon icon;
    private Image image;
    private Image resizedImage;
    private ImageIcon resizedIcon;

    public SpeedRestriction(JFrame frame) {
        this.frame = frame;
        initialize();
    }

    private void initialize() {
        restrictedScreenPanel = new JPanel();
        restrictedScreenPanel.setBackground(new Color(222, 235, 247));
        restrictedScreenPanel.setLayout(new BorderLayout());

        distanceLabel = new JLabel("거리 멀어짐 ");
        distanceLabel.setFont(new Font("굴림", Font.BOLD, 34));
        distanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        distanceLabel.setBounds(20, 5, 350, 100);
        restrictedScreenPanel.add(distanceLabel);

        speedLimitLabel = new JLabel("속도 제한이 걸립니다 ");
        speedLimitLabel.setFont(new Font("굴림", Font.BOLD, 30));
        speedLimitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        speedLimitLabel.setBounds(25, 45, 350, 100);
        restrictedScreenPanel.add(speedLimitLabel);

        redButton = new JButton("");
        redButton.setForeground(Color.WHITE);
        redButton.setBackground(Color.RED);
        redButton.setBounds(260, 430, 90, 90);
        restrictedScreenPanel.add(redButton);

        redButton.addActionListener(e -> {
            System.out.println("Red button clicked!");
            //OutofRange.initialize(frame);
            new OutOfRange(frame);
        });

        icon = new ImageIcon("restricted.png");
        image = icon.getImage();
        resizedImage = image.getScaledInstance(300, 280, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(resizedImage);
        imageLabel = new JLabel(resizedIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        restrictedScreenPanel.add(imageLabel, BorderLayout.CENTER);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(restrictedScreenPanel);
        frame.revalidate();
        frame.repaint();
    }
}
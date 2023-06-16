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

public class CheckSucceed {
    private JFrame frame;
    private JPanel checkSucceedPanel;
    private JLabel safetyLabel;
    private JLabel statusLabel;
    private JButton yellowButton;
    private ImageIcon icon;
    private Image image;
    private Image resizedImage;
    private ImageIcon resizedIcon;
    private JLabel imageLabel;
    
    public CheckSucceed(JFrame frame) {
        this.frame = frame;
        initialize();
    }

    private void initialize() {
        checkSucceedPanel = new JPanel();
        checkSucceedPanel.setBackground(new Color(222, 235, 247));
        checkSucceedPanel.setLayout(new BorderLayout());

        safetyLabel = new JLabel("안전 운전 하세요 :) ");
        safetyLabel.setFont(new Font("굴림", Font.BOLD, 34));
        safetyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		safetyLabel.setBounds(25, 40, 350, 100);
		checkSucceedPanel.add(safetyLabel);

        statusLabel = new JLabel("동작 중..");
        statusLabel.setFont(new Font("굴림", Font.BOLD, 30));
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statusLabel.setBounds(55, 443, 256, 64);
		checkSucceedPanel.add(statusLabel);

        yellowButton = new JButton("");
        yellowButton.setForeground(Color.WHITE);
        yellowButton.setBackground(Color.YELLOW);
        yellowButton.setBounds(260, 430, 90, 90);
		checkSucceedPanel.add(yellowButton);

        yellowButton.addActionListener(e -> {
            System.out.println("Yellow button clicked!");
            //SpeedRestriction.initialize(frame);
            new SpeedRestriction(frame);
        });

        icon = new ImageIcon("success.png");
		image = icon.getImage();
		resizedImage = image.getScaledInstance(300, 280, Image.SCALE_SMOOTH);
		resizedIcon = new ImageIcon(resizedImage);
		imageLabel = new JLabel(resizedIcon);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		checkSucceedPanel.add(imageLabel, BorderLayout.CENTER);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(checkSucceedPanel);
        frame.revalidate();
        frame.repaint();
    }
}
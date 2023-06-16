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

public class RegistrationConfirmation {
    private JFrame frame;
    private JPanel nextScreenPanel;
    private JButton blueButton;
    private JButton redButton;
    private JLabel helmetLabel;
    private JLabel kickboardLabel;
    private JLabel helmetPressureLabel;
    private JLabel distanceLabel;
    private ImageIcon loadingIcon;
    private Image image;
    private Image resizedImage;
    private ImageIcon resizedIcon;
    private JLabel imageLabel;
    
    public RegistrationConfirmation(JFrame frame) {
        this.frame = frame;
        initialize();
    }

    private void initialize() {
        nextScreenPanel = new JPanel();
        nextScreenPanel.setBackground(new Color(222, 235, 247));
        nextScreenPanel.setLayout(new BorderLayout());
        

        blueButton = new JButton("");
        blueButton.setForeground(Color.WHITE);
        blueButton.setBackground(Color.BLUE);
        blueButton.setBounds(60, 420, 90, 90);
        nextScreenPanel.add(blueButton);

        blueButton.addActionListener(e -> {
            System.out.println("Blue button clicked!");
            new CheckSucceed(frame);
        });

        redButton = new JButton("");
        redButton.setForeground(Color.WHITE);
        redButton.setBackground(Color.RED);
        redButton.setBounds(220, 420, 90, 90);
        nextScreenPanel.add(redButton);

        redButton.addActionListener(e -> {
            System.out.println("Red button clicked!");
            //LoadFailure.initialize(frame);
            new LoadFailure(frame);
        });

        helmetLabel = new JLabel("Çï¸ä ÄÚµå ÀÔ·Â ¿Ï·á.");
        helmetLabel.setFont(new Font("±¼¸²", Font.BOLD, 15));
        helmetLabel.setHorizontalAlignment(SwingConstants.CENTER);
        helmetLabel.setBounds(65, 13, 256, 64);
        nextScreenPanel.add(helmetLabel);

        kickboardLabel = new JLabel("Å±º¸µå µî·Ï ¿Ï·á.");
        kickboardLabel.setFont(new Font("±¼¸²", Font.BOLD, 15));
        kickboardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        kickboardLabel.setBounds(65, 43, 256, 64);
        nextScreenPanel.add(kickboardLabel);

        helmetPressureLabel = new JLabel("Çï¸ä ¾Ð¹Ú ÀÎÁö ¿Ï·á.");
        helmetPressureLabel.setFont(new Font("±¼¸²", Font.BOLD, 15));
        helmetPressureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        helmetPressureLabel.setBounds(65, 73, 256, 64);
        nextScreenPanel.add(helmetPressureLabel);

        distanceLabel = new JLabel("Çï¸ä °Å¸® À¯Áö È®ÀÎ Áß..");
        distanceLabel.setFont(new Font("±¼¸²", Font.BOLD, 15));
        distanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        distanceLabel.setBounds(65, 103, 256, 64);
        nextScreenPanel.add(distanceLabel);
        


        //loadingIcon = new ImageIcon();
        //loadingIcon = new ImageIcon(getClass().getClassLoader().getResource("free-icon-loading-6356465.png"));
        loadingIcon = new ImageIcon("free-icon-loading-6356465.png");
        image = loadingIcon.getImage();
        resizedImage = image.getScaledInstance(300, 250, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(resizedImage);
        imageLabel = new JLabel(resizedIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nextScreenPanel.add(imageLabel, BorderLayout.CENTER);        

        frame.getContentPane().removeAll();
        frame.getContentPane().add(nextScreenPanel);
        frame.revalidate();
        frame.repaint();
    }
}
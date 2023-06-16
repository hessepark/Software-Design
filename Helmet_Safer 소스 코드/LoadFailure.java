import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class LoadFailure {
    private JFrame frame;
    private JPanel failedScreenPanel;
    private JLabel failureLabel;
    private JLabel returnLabel;
    private JLabel returnLabel2;
    private ImageIcon icon;
    private Image image;
    private Image resizedImage;
    private ImageIcon resizedIcon;
    private JLabel imageLabel;
    private Timer timer;

    public LoadFailure(JFrame frame) {
        this.frame = frame;
        initialize();
    }

    private void initialize() {
        failedScreenPanel = new JPanel();
        failedScreenPanel.setBackground(new Color(222, 235, 247));
        failedScreenPanel.setLayout(new BorderLayout());

        failureLabel = new JLabel("Á¤º¸ ºÒ·¯¿À±â ½ÇÆÐ");
        failureLabel.setFont(new Font("±¼¸²", Font.BOLD, 34));
        failureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        failureLabel.setBounds(25, 40, 350, 100);
        failedScreenPanel.add(failureLabel);

        returnLabel = new JLabel("Çï¸ä ÄÚµå ÀÔ·Â Ã¢À¸·Î");
        returnLabel.setFont(new Font("±¼¸²", Font.BOLD, 25));
        returnLabel.setHorizontalAlignment(SwingConstants.CENTER);
        returnLabel.setBounds(35, 423, 300, 74);
        failedScreenPanel.add(returnLabel);

        returnLabel2 = new JLabel("µ¹¾Æ°©´Ï´Ù...");
        returnLabel2.setFont(new Font("±¼¸²", Font.BOLD, 25));
        returnLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        returnLabel2.setBounds(35, 463, 300, 74);
        failedScreenPanel.add(returnLabel2);

        icon = new ImageIcon("failed.png");
        image = icon.getImage();
        resizedImage = image.getScaledInstance(300, 280, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(resizedImage);
        imageLabel = new JLabel(resizedIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        failedScreenPanel.add(imageLabel, BorderLayout.CENTER);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(failedScreenPanel);
        frame.revalidate();
        frame.repaint();

        timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new HelmetCodeInput(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}

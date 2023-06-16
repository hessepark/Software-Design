import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ApplicationTerminator {
    private JFrame frame;
    private JPanel useEndScreenPanel;
    private JLabel titleLabel;
    private ImageIcon icon;
    private Image image;
    private Image resizedImage;
    private ImageIcon resizedIcon;
    private JLabel imageLabel;
    private JPanel buttonPanel;
    private JButton greenButton;
    private JPanel rightButtonPanel;
    private JButton reportButton;
    private JButton warningButton;
    private JPanel rightButtonWrapperPanel;

    public ApplicationTerminator(JFrame frame) {
        this.frame = frame;
        initialize();
    }

    private void initialize() {
        useEndScreenPanel = new JPanel();
        useEndScreenPanel.setBackground(new Color(222, 235, 247));
        useEndScreenPanel.setLayout(new BorderLayout());

        titleLabel = new JLabel("Å±º¸µå »ç¿ë Á¾·á");
        titleLabel.setFont(new Font("±¼¸²", Font.BOLD, 34));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        useEndScreenPanel.add(titleLabel, BorderLayout.NORTH);

        icon = new ImageIcon("finish.png");
        image = icon.getImage();
        resizedImage = image.getScaledInstance(220, 210, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(resizedImage);
        imageLabel = new JLabel(resizedIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 0));
        useEndScreenPanel.add(imageLabel, BorderLayout.WEST);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        buttonPanel.setBackground(new Color(222, 235, 247));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 30));

        greenButton = new JButton("");
        greenButton.setForeground(Color.WHITE);
        greenButton.setBackground(Color.GREEN);
        greenButton.setPreferredSize(new Dimension(90, 90));
        buttonPanel.add(greenButton);

        greenButton.addActionListener(e -> {
            System.out.println("Green button clicked!");
            Login.initialize(frame);
        });

        useEndScreenPanel.add(buttonPanel, BorderLayout.SOUTH);

        rightButtonPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        rightButtonPanel.setBackground(new Color(222, 235, 247));

        reportButton = new JButton("Report");
        reportButton.setForeground(Color.BLACK);
        reportButton.setBackground(new Color(180, 199, 231));
        reportButton.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        reportButton.setPreferredSize(new Dimension(90, 20));
        rightButtonPanel.add(reportButton);

        reportButton.addActionListener(e -> {
            System.out.println("reportButton clicked!");
            //Report.initialize(frame);
            new Report(frame);
        });

        warningButton = new JButton("Warning");
        warningButton.setForeground(Color.BLACK);
        warningButton.setBackground(new Color(180, 199, 231));
        warningButton.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        warningButton.setPreferredSize(new Dimension(90, 20));
        rightButtonPanel.add(warningButton);

        warningButton.addActionListener(e -> {
            System.out.println("warningButton clicked!");
            //WarningHistory.initialize(frame);
            new WarningHistory(frame);
        });

        rightButtonWrapperPanel = new JPanel(new BorderLayout());
        rightButtonWrapperPanel.setBackground(new Color(222, 235, 247));
        rightButtonWrapperPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));
        rightButtonWrapperPanel.add(rightButtonPanel, BorderLayout.EAST);

        useEndScreenPanel.add(rightButtonWrapperPanel, BorderLayout.EAST);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(useEndScreenPanel);
        frame.revalidate();
        frame.repaint();
    }
}
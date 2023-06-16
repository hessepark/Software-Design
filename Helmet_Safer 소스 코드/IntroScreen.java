import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroScreen {
    private JFrame frame;
    private JPanel contentPanel;
    private JLabel titleLabel;
    private JLabel imageLabel;
    private JLabel loadingLabel;
    private Timer timer;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IntroScreen introScreen = new IntroScreen();
            introScreen.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        frame = new JFrame("Helmet Safer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);

        titleLabel = new JLabel("Helmet Safer");
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 40));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        contentPanel.add(titlePanel, BorderLayout.NORTH);

        ImageIcon imageIcon = new ImageIcon("Helmet Safer.jpg");
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        imageLabel = new JLabel(resizedIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(imageLabel, BorderLayout.CENTER);

        loadingLabel = new JLabel("Loading ...");
        loadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loadingLabel.setFont(loadingLabel.getFont().deriveFont(Font.BOLD, 24));
        loadingLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
        contentPanel.add(loadingLabel, BorderLayout.SOUTH);

        timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                Login.initialize(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        timer.setRepeats(false);
        timer.start();

        frame.getContentPane().add(contentPanel);
        frame.setVisible(true);
    }
}
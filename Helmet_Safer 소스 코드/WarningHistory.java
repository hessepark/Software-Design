import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class WarningHistory {
    private JFrame frame;
    private JPanel warningScreenPanel;
    private JLabel titleLabel;
    private JLabel timerLabel;

    public WarningHistory(JFrame frame) {
        this.frame = frame;
        initialize();
    }

    private void initialize() {
        warningScreenPanel = new JPanel();
        warningScreenPanel.setBackground(new Color(222, 235, 247));
        warningScreenPanel.setLayout(new BorderLayout());

        titleLabel = new JLabel("°æ°í ³»¿ª");
        titleLabel.setFont(new Font("±¼¸²", Font.BOLD, 40));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //titleLabel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        titleLabel.setBounds(45, 40, 300, 300);
        warningScreenPanel.add(titleLabel);

        timerLabel = new JLabel("´©Àû °æ°í ÃÑ 2È¸");
        timerLabel.setFont(new Font("±¼¸²", Font.BOLD, 34));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        warningScreenPanel.add(timerLabel, BorderLayout.CENTER);

        Timer timer = new Timer(3000, new ActionListener() {
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

        frame.getContentPane().removeAll();
        frame.getContentPane().add(warningScreenPanel);
        frame.revalidate();
        frame.repaint();
    }
}
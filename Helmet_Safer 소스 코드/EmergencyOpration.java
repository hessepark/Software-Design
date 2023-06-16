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

public class EmergencyOpration {
    private JFrame frame;
    private JPanel emergencyScreenPanel;
    private JLabel titleLabel;
    private JLabel timerLabel;
    private Timer timer;
    private int remainingTime;

    public EmergencyOpration(JFrame frame) {
        this.frame = frame;
        initialize();
    }

    private void initialize() {
        emergencyScreenPanel = new JPanel();
        emergencyScreenPanel.setBackground(new Color(222, 235, 247));
        emergencyScreenPanel.setLayout(new BorderLayout());

        titleLabel = new JLabel("비상 작동 중");
        titleLabel.setFont(new Font("굴림", Font.BOLD, 40));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //titleLabel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        titleLabel.setBounds(45, 40, 300, 300);
        emergencyScreenPanel.add(titleLabel);
        
        
        timerLabel = new JLabel("남은 시간: 4");
        timerLabel.setFont(new Font("굴림", Font.BOLD, 34));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        emergencyScreenPanel.add(timerLabel, BorderLayout.CENTER);
        
        remainingTime = 4;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remainingTime--;

                if (remainingTime >= 0) {
                    timerLabel.setText("남은 시간: " + remainingTime);
                } else {
                    ((Timer) e.getSource()).stop();
                    //ApplicationTerminator.initialize(frame);
                    new ApplicationTerminator(frame);
                }
            }
        });

        timer.start();

        frame.getContentPane().removeAll();
        frame.getContentPane().add(emergencyScreenPanel);
        frame.revalidate();
        frame.repaint();
    }
}
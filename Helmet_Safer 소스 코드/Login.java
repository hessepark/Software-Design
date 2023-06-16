import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JFrame frame;
    private JPanel loginPanel;
    private JTextField idTextField;
    private JTextField pwTextField;
    private JButton pinButton;
    private JButton joinButton;
    private JPanel idPanel;
    private JLabel idLabel;
    private JPanel pwPanel;
    private JLabel pwLabel;

    public static void initialize(JFrame parentFrame) {
        Login login = new Login(parentFrame);
        login.performLogin();
    }

    private Login(JFrame parentFrame) {
        frame = parentFrame;
    }

    private void performLogin() {
        loginPanel = new JPanel(null);
        loginPanel.setBackground(new Color(222, 235, 247));

        JLabel loginLabel = new JLabel("LOGIN");
        loginLabel.setFont(new Font("±¼¸²", Font.BOLD, 20));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setBounds(50, 53, 256, 64);
        loginPanel.add(loginLabel);

        JButton loginButton = new JButton("Login");
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setBackground(new Color(68, 114, 196));
        loginButton.setBounds(282, 127, 68, 66);
        loginPanel.add(loginButton);

        idTextField = new JTextField();
        idTextField.setFont(new Font("±¼¸²", Font.BOLD, 12));
        idTextField.setBounds(115, 127, 155, 30);
        loginPanel.add(idTextField);
        idTextField.setColumns(10);

        pwTextField = new JTextField();
        pwTextField.setFont(new Font("±¼¸²", Font.BOLD, 12));
        pwTextField.setColumns(10);
        pwTextField.setBounds(115, 163, 155, 30);
        loginPanel.add(pwTextField);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idTextField.getText();
                String pw = pwTextField.getText();

                if (UserManager.getUserCredentials().containsKey(id) && UserManager.getUserCredentials().get(id).equals(pw)) {
                    frame.getContentPane().removeAll();
                    new HelmetCodeInput(frame);
                    frame.revalidate();
                    frame.repaint();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid ID or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pinButton = new JButton("PIN Number");
        pinButton.setForeground(new Color(255, 255, 255));
        pinButton.setBackground(new Color(68, 114, 196));
        pinButton.setBounds(35, 245, 125, 74);
        loginPanel.add(pinButton);

        pinButton.addActionListener(e -> {
            System.out.println("pinButton clicked!");
            frame.getContentPane().removeAll();
            new PinInput(frame);
         
            frame.revalidate();
            frame.repaint();
        });

        joinButton = new JButton("Join");
        joinButton.setForeground(new Color(255, 255, 255));
        joinButton.setBackground(new Color(68, 114, 196));
        joinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new Join(frame);
                //Join join = new Join(frame);
                //join.initialize();
                frame.revalidate();
                frame.repaint();
            }
        });
        joinButton.setBounds(201, 245, 149, 74);
        loginPanel.add(joinButton);

        idPanel = new JPanel();
        idPanel.setBorder(new LineBorder(new Color(153, 255, 0), 3, true));
        idPanel.setBounds(35, 127, 68, 30);
        loginPanel.add(idPanel);
        idPanel.setLayout(null);

        idLabel = new JLabel("ID");
        idLabel.setFont(new Font("±¼¸²", Font.BOLD, 16));
        idLabel.setHorizontalAlignment(SwingConstants.CENTER);
        idLabel.setBounds(0, 0, 68, 30);
        idLabel.setOpaque(true);
        idLabel.setBackground(new Color(180, 199, 231));
        idLabel.setForeground(Color.BLACK);
        idPanel.add(idLabel);

        pwPanel = new JPanel();
        pwPanel.setBorder(new LineBorder(new Color(153, 255, 0), 3, true));
        pwPanel.setBounds(35, 163, 68, 30);
        loginPanel.add(pwPanel);
        pwPanel.setLayout(null);

        pwLabel = new JLabel("PW");
        pwLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pwLabel.setFont(new Font("±¼¸²", Font.BOLD, 16));
        pwLabel.setBounds(0, 0, 68, 30);
        pwLabel.setOpaque(true);
        pwLabel.setBackground(new Color(180, 199, 231));
        pwLabel.setForeground(Color.BLACK);
        pwPanel.add(pwLabel);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(loginPanel);
        frame.revalidate();
        frame.repaint();
    }
}
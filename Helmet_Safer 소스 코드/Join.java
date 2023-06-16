import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Join {
	private JFrame frame;
	private JPanel registrationPanel;
	private JLabel registrationLabel;
	private JLabel idLabel;
	private JTextField idTextField;
	private JButton duplicateCheckButton;
	private JLabel pwLabel;
	private JPasswordField pwPasswordField;
	private JLabel birthdateLabel;
	private JTextField birthdateTextField;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JButton registerButton;
	private JButton backButton;

	public Join(JFrame parentFrame) {
		frame = parentFrame;
		initialize();
	}

	private void initialize() {
		registrationPanel = new JPanel(null);
		registrationPanel.setBackground(new Color(222, 235, 247));

		registrationLabel = new JLabel("Join");
		registrationLabel.setFont(new Font("±¼¸²", Font.BOLD, 24));
		registrationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registrationLabel.setBounds(50, 53, 256, 64);
		registrationPanel.add(registrationLabel);

		idLabel = new JLabel("ID");
		idLabel.setFont(new Font("±¼¸²", Font.BOLD, 16));
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setBounds(35, 127, 68, 30);
		idLabel.setOpaque(true);
		idLabel.setBackground(new Color(180, 199, 231));
		idLabel.setForeground(Color.BLACK);
		registrationPanel.add(idLabel);

		idTextField = new JTextField();
		idTextField.setFont(new Font("±¼¸²", Font.BOLD, 12));
		idTextField.setBounds(115, 127, 150, 30);
		registrationPanel.add(idTextField);

		duplicateCheckButton = new JButton("Áßº¹ È®ÀÎ");
		duplicateCheckButton.setForeground(Color.WHITE);
		duplicateCheckButton.setBackground(new Color(68, 114, 196));
		duplicateCheckButton.setBounds(280, 127, 100, 30);
		registrationPanel.add(duplicateCheckButton);

		duplicateCheckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idTextField.getText();

				if (id.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please enter an ID.", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (UserManager.getUserCredentials().containsKey(id)) {
					JOptionPane.showMessageDialog(frame, "ID already exists. Please choose a different ID.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frame, "ID is available!", "Success",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		pwLabel = new JLabel("PW");
		pwLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pwLabel.setFont(new Font("±¼¸²", Font.BOLD, 16));
		pwLabel.setBounds(35, 163, 68, 30);
		pwLabel.setOpaque(true);
		pwLabel.setBackground(new Color(180, 199, 231));
		pwLabel.setForeground(Color.BLACK);
		registrationPanel.add(pwLabel);

		pwPasswordField = new JPasswordField();
		pwPasswordField.setBounds(115, 163, 150, 30);
		registrationPanel.add(pwPasswordField);

		birthdateLabel = new JLabel("»ý³â¿ùÀÏ");
		birthdateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		birthdateLabel.setFont(new Font("±¼¸²", Font.BOLD, 16));
		birthdateLabel.setBounds(35, 199, 68, 30);
		birthdateLabel.setOpaque(true);
		birthdateLabel.setBackground(new Color(180, 199, 231));
		birthdateLabel.setForeground(Color.BLACK);
		registrationPanel.add(birthdateLabel);

		birthdateTextField = new JTextField();
		birthdateTextField.setBounds(115, 199, 150, 30);
		registrationPanel.add(birthdateTextField);

		nameLabel = new JLabel("ÀÌ¸§");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("±¼¸²", Font.BOLD, 16));
		nameLabel.setBounds(35, 235, 68, 30);
		nameLabel.setOpaque(true);
		nameLabel.setBackground(new Color(180, 199, 231));
		nameLabel.setForeground(Color.BLACK);
		registrationPanel.add(nameLabel);

		nameTextField = new JTextField();
		nameTextField.setBounds(115, 235, 150, 30);
		registrationPanel.add(nameTextField);

		registerButton = new JButton("È¸¿ø °¡ÀÔ");
		registerButton.setForeground(Color.WHITE);
		registerButton.setBackground(new Color(68, 114, 196));
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idTextField.getText();
				String pw = new String(pwPasswordField.getPassword());
				String birthdate = birthdateTextField.getText();
				String name = nameTextField.getText();

				if (id.isEmpty() || pw.isEmpty() || birthdate.isEmpty() || name.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (UserManager.getUserCredentials().containsKey(id)) {
					JOptionPane.showMessageDialog(frame, "ID already exists. Please choose a different ID.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					UserManager.getUserCredentials().put(id, pw);

					int choice = JOptionPane.showConfirmDialog(frame,
							"Registration successful! Would you like to set a PIN number?", "Success",
							JOptionPane.YES_NO_OPTION);
					if (choice == JOptionPane.YES_OPTION) {
						frame.getContentPane().removeAll();
						PinRegistration PinRegistration = new PinRegistration();
						PinRegistration.initialize(frame);
					} else {
						JOptionPane.showMessageDialog(frame, "You can now log in.", "Success",
								JOptionPane.INFORMATION_MESSAGE);
						frame.getContentPane().removeAll();
						Login.initialize(frame);
					}

					frame.revalidate();
					frame.repaint();
				}
			}
		});
		registerButton.setBounds(35, 283, 345, 30);
		registrationPanel.add(registerButton);

		backButton = new JButton("Back");
		backButton.setForeground(Color.WHITE);
		backButton.setBackground(new Color(68, 114, 196));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				Login.initialize(frame);
				frame.revalidate();
				frame.repaint();
			}
		});
		backButton.setBounds(35, 323, 345, 30);
		registrationPanel.add(backButton);

		frame.getContentPane().add(registrationPanel);
	}
}
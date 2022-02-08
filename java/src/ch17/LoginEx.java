package ch17;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LoginEx extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JPasswordField pwd;
	private JLabel lblResult;
	Map<String, String> map;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginEx frame = new LoginEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		userid = new JTextField();
		userid.setBounds(161, 47, 116, 21);
		contentPane.add(userid);
		userid.setColumns(10);

		pwd = new JPasswordField();
		pwd.setBounds(161, 78, 116, 21);
		contentPane.add(pwd);

		map = new HashMap<>();
		map.put("kim", "1234");
		map.put("park", "2222");
		map.put("hong", "3333");

		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = userid.getText();
				String pw = String.valueOf(pwd.getPassword());
				if (map.get(id) == null) {
					lblResult.setForeground(Color.red);
					lblResult.setText("ID is incorrect.");
				} else {
					if (map.get(id).equals(pw)) {
						lblResult.setForeground(Color.blue);
						lblResult.setText("Welcome, " + id);
					} else {
						lblResult.setForeground(Color.red);
						lblResult.setText("ID or Password is incorrect");
					}
				}
			}
		});
		btnLogin.setBounds(170, 125, 97, 23);
		contentPane.add(btnLogin);

		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(114, 171, 208, 15);
		contentPane.add(lblResult);
	}
}

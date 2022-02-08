package jdbc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ALogin extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JPasswordField pwd;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ALogin frame = new ALogin();
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
	public ALogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(43, 41, 57, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(43, 80, 57, 15);
		contentPane.add(lblNewLabel_1);

		userid = new JTextField();
		userid.setBounds(112, 38, 130, 21);
		contentPane.add(userid);
		userid.setColumns(10);

		pwd = new JPasswordField();
		pwd.setBounds(112, 77, 130, 21);
		contentPane.add(pwd);

		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strUserid = userid.getText();
				String strPwd = String.valueOf(pwd.getPassword());
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DB.oraConn();
					String sql = "select * from loginDB where userid=? and passwd=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, strUserid);
					pstmt.setString(2, strPwd);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						lblResult.setText(rs.getString("username") + "님 환영합니다.");
					} else {
						lblResult.setText("아이디 또는 비밀번호가 일치하지 않습니다.");
					}
					if (strUserid.equals("") || strPwd.equals("")) {
						JOptionPane.showMessageDialog(ALogin.this, "아이디 혹은 비밀번호를 입력하세요.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						if (rs != null)
							rs.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					try {
						if (pstmt != null)
							pstmt.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}

			}
		});
		btnLogin.setBounds(267, 37, 78, 58);
		contentPane.add(btnLogin);

		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(61, 147, 272, 15);
		contentPane.add(lblResult);
	}
}

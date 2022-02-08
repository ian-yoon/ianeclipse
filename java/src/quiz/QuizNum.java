package quiz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class QuizNum extends JFrame {

	private JPanel contentPane;
	private JTextField tF;
	private JLabel lblResult;
	private int com;
	private int user;
	private Random random;
	private int count;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizNum frame = new QuizNum();
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
	
	public QuizNum() {
		setTitle("숫자 맞추기 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNum = new JLabel("숫자를 추측하세요:");
		lblNum.setBounds(46, 28, 107, 15);
		lblNum.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(lblNum);
		
		tF = new JTextField();
		tF.setHorizontalAlignment(SwingConstants.CENTER);
		tF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				tF.setText("");
			}
		});
		tF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				user = Integer.parseInt(tF.getText());
				lblResult.setOpaque(true);
				if (user > com) {
					lblResult.setBackground(Color.red);
					lblResult.setText(count + "회 입력 - 더 작은 숫자를 입력하세요.");
				} else if (user < com) {
					lblResult.setBackground(Color.red);
					lblResult.setText(count + "회 입력 - 더 큰 숫자를 입력하세요.");
				} else if (user == com) {
					lblResult.setBackground(Color.cyan);
					lblResult.setText(count + "회만에 맞췄습니다!");
				}
			}
		});
		tF.setBounds(165, 25, 226, 21);
		contentPane.add(tF);
		tF.setColumns(10);
		
		JButton btnAgain = new JButton("다시 한 번");
		btnAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initialize();
			}
		});
		btnAgain.setBounds(107, 136, 97, 23);
		contentPane.add(btnAgain);
		
		JButton btnExit = new JButton("종료");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,  "프로그램을 종료합니다.");
				System.exit(0);
			}
		});
		btnExit.setBounds(216, 136, 97, 23);
		contentPane.add(btnExit);
		
		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(75, 80, 298, 15);
		contentPane.add(lblResult);

		random = new Random();
		initialize();
		
	}
	
	void initialize() {
		com = random.nextInt(100) + 1;
		System.out.println("랜덤값: " + com);
		lblResult.setText("");
		count = 0;
		tF.setText("1~100 사이의 숫자를 입력하세요.");
		tF.requestFocus();
	}
}

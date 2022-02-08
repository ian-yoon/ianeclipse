package quiz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NumberFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfNum;
	private JLabel lblResult;
	// 컴퓨터가 생성한 숫자
	private int com;
	// 사용자가 입력한 숫자
	private int user;
	private Random random;
	// 카운트 변수
	private int count;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberFrame frame = new NumberFrame();
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
	public NumberFrame() {
		setTitle("숫자 맞추기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("숫자를 입력하세요");
		lblNewLabel.setBounds(12, 30, 117, 15);
		contentPane.add(lblNewLabel);

		tfNum = new JTextField();
		tfNum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				tfNum.setText("");
			}
		});
		tfNum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				user = Integer.parseInt(tfNum.getText());
				lblResult.setOpaque(true); // 투명도 설정
				if (user > com) {
					lblResult.setBackground(Color.red);
					lblResult.setText(count + "회 입력-더 작은 숫자를 입력하세요.");
				} else if (user < com) {
					lblResult.setBackground(Color.red);
					lblResult.setText(count + "회 입력-더 큰 숫자를 입력하세요.");
				} else if (user == com) {
					lblResult.setBackground(Color.blue);
					lblResult.setText(count + "회만에 맞추셨습니다!!!");
				}
			}
		});
		tfNum.setBounds(124, 27, 303, 21);
		contentPane.add(tfNum);
		tfNum.setColumns(10);

		lblResult = new JLabel("");
		lblResult.setBounds(124, 75, 303, 21);
		contentPane.add(lblResult);

		JButton btnRetry = new JButton("다시 한번");
		btnRetry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initialize();
			}
		});
		btnRetry.setBounds(73, 129, 97, 23);
		contentPane.add(btnRetry);

		JButton btnExit = new JButton("종료");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "프로그램을 종료합니다.");
				System.exit(0);
			}
		});
		btnExit.setBounds(205, 129, 97, 23);
		contentPane.add(btnExit);

		random = new Random();
		initialize();
	}

	void initialize() {
		com = random.nextInt(100) + 1;
		System.out.println("랜덤값:" + com);
		lblResult.setText("");
		count = 0;
		tfNum.setText("1~100 사이의 숫자를 입력하세요");
		tfNum.requestFocus();
	}
}

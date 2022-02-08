package quiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Quiz16 extends JFrame {

	private JPanel contentPane;
	private JTextField tfNum;
	private JButton btnEnter;
	private JButton btnRetry;
	private JButton btnExit;
	private JLabel lblResult;
	private int com, user, count;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quiz16 frame = new Quiz16();
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
	public Quiz16() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("0부터 100 사이의 숫자를 입력하세요");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(115, 30, 210, 15);
		contentPane.add(lblNewLabel);
		
		tfNum = new JTextField();
		tfNum.setBounds(125, 56, 116, 21);
		contentPane.add(tfNum);
		tfNum.setColumns(10);
		
		btnEnter = new JButton("확인");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guess();
			}
		});
		btnEnter.setBounds(253, 55, 64, 23);
		contentPane.add(btnEnter);
		
		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(82, 97, 275, 54);
		contentPane.add(lblResult);
		
		btnRetry = new JButton("다시 한 번");
		btnRetry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initialize();
			}
		});
		btnRetry.setBounds(97, 174, 97, 23);
		contentPane.add(btnRetry);
		
		btnExit = new JButton("종료");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "프로그램을 종료합니다.");
				System.exit(0);
			}
		});
		btnExit.setBounds(228, 174, 97, 23);
		contentPane.add(btnExit);
		initialize();
	}
	
	Random random = new Random();
	
	void initialize() {
		com = random.nextInt(100) + 1;
		lblResult.setText("");
		count = 0;
	}
	
	void guess() {
		count++;
		user = Integer.parseInt(tfNum.getText());
		lblResult.setOpaque(true);
		if (user > com) {
			lblResult.setBackground(Color.red);
			lblResult.setText(count + "회 입력 - 더 작은 숫자를 입력하세요.");
		} else if (user < com) {
			lblResult.setBackground(Color.red);
			lblResult.setText(count + "회 입력 - 더 큰 숫자를 입력하세요.");
		} else if (user == com) {
			lblResult.setBackground(Color.yellow);
			lblResult.setText("정답입니다! " + count + "회 만에 맞추셨습니다!");
		}
	}
	
}

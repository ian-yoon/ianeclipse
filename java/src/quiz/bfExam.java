package quiz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bfExam extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfPrice;
	private JTextField tfQuan;
	private JTextArea taResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bfExam frame = new bfExam();
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
	public bfExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 255, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfName = new JTextField();
		tfName.setBounds(88, 27, 116, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);

		tfPrice = new JTextField();
		tfPrice.setBounds(88, 73, 116, 21);
		contentPane.add(tfPrice);
		tfPrice.setColumns(10);

		tfQuan = new JTextField();
		tfQuan.setBounds(88, 120, 116, 21);
		contentPane.add(tfQuan);
		tfQuan.setColumns(10);

		JLabel lblNewLabel = new JLabel("상품이름");
		lblNewLabel.setBounds(19, 30, 57, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("가격");
		lblNewLabel_1.setBounds(19, 76, 57, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("수량");
		lblNewLabel_2.setBounds(19, 123, 57, 15);
		contentPane.add(lblNewLabel_2);

		JButton btnEval = new JButton("계산");
		btnEval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				int price = Integer.valueOf(tfPrice.getText());
				int amount = Integer.valueOf(tfQuan.getText());
				int money = price * amount;
				String str = "상품명: " + name + "\n" + "가격: " + price + "\n" + "수량: " + amount + "\n" + "총 합계 금액: "
						+ money;
				taResult.setText(str);
			}
		});
		btnEval.setBounds(71, 167, 97, 23);
		contentPane.add(btnEval);

		taResult = new JTextArea();
		taResult.setBounds(19, 204, 197, 117);
		contentPane.add(taResult);
	}
}

// 캡슐화는 변수는 private, 함수는 public으로 사용
// 상속은 extends를 통해서 코드를 재사용할 수 있음
// 다형성은 상위 참조변수를 통해서 다양한 하위 클래스에 접근할 수 있음
//     ex. List items = new ArrayList<>();

// InetAddress[] address = InetAddress.getAllbyName("naver.com");
// try catch로 묶어야 함


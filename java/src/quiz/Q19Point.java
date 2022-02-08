package quiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Q19Point extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMat;
	private String name;
	private int kor, eng, mat, tot;
	private double avg;
	private JTextArea ta;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Q19Point frame = new Q19Point();
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
	public Q19Point() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("이름");
		lblName.setBounds(46, 46, 48, 15);
		contentPane.add(lblName);

		tfName = new JTextField();
		tfName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = tfName.getText();
				if (name.equals("")) {
					check("이름을 입력하세요", tfName);
					return;
				}
				tfKor.requestFocus();
			}
		});
		tfName.setBounds(114, 43, 199, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);

		JLabel lblKor = new JLabel("국어");
		lblKor.setBounds(46, 92, 48, 15);
		contentPane.add(lblKor);

		tfKor = new JTextField();
		tfKor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strKor = tfKor.getText();
				if (strKor.equals("")) {
					check("국어점수를 입력하세요.", tfKor);
					return;
				}
				tfEng.requestFocus();
			}
		});
		tfKor.setBounds(114, 89, 199, 21);
		contentPane.add(tfKor);
		tfKor.setColumns(10);

		JLabel lblEng = new JLabel("영어");
		lblEng.setBounds(46, 138, 57, 15);
		contentPane.add(lblEng);

		tfEng = new JTextField();
		tfEng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strEng = tfEng.getText();
				if (strEng.equals("")) {
					check("영어점수를 입력하세요.", tfEng);
					return;
				}
				tfMat.requestFocus();
			}
		});
		tfEng.setBounds(114, 135, 199, 21);
		contentPane.add(tfEng);
		tfEng.setColumns(10);

		JLabel lblMat = new JLabel("수학");
		lblMat.setBounds(46, 184, 57, 15);
		contentPane.add(lblMat);

		tfMat = new JTextField();
		tfMat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strMat = tfMat.getText();
				if (strMat.equals("")) {
					check("수학점수를 입력하세요.", tfMat);
					return;
				}
				calc();
			}
		});
		tfMat.setBounds(114, 181, 199, 21);
		contentPane.add(tfMat);
		tfMat.setColumns(10);

		JButton btnCal = new JButton("계산");
		btnCal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc();
			}
		});
		btnCal.setBounds(74, 231, 97, 23);
		contentPane.add(btnCal);
		this.getRootPane().setDefaultButton(btnCal);

		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfName.setText("");
				tfKor.setText("");
				tfEng.setText("");
				tfMat.setText("");
				ta.setText("");
				tfName.requestFocus();
			}
		});
		btnCancel.setBounds(205, 231, 97, 23);
		contentPane.add(btnCancel);

		ta = new JTextArea();
		ta.setBounds(58, 281, 267, 126);
		contentPane.add(ta);

		lblResult = new JLabel("New label");
		lblResult.setBounds(74, 291, 239, 104);
		contentPane.add(lblResult);
	}

	void check(String message, JTextField tf) {
		JOptionPane.showMessageDialog(Q19Point.this, message);
		tf.requestFocus();
	}

	void calc() {
		name = tfName.getText();
		if (name.equals("")) {
			check("이름을 입력하세요.", tfName);
			return;
		}
		String strKor = tfKor.getText();
		if (strKor.equals("")) {
			check("국어점수를 입력하세요.", tfKor);
			return;
		}
		String strEng = tfEng.getText();
		if (strKor.equals("")) {
			check("영어점수를 입력하세요.", tfEng);
			return;
		}
		String strMat = tfMat.getText();
		if (strKor.equals("")) {
			check("수학점수를 입력하세요.", tfMat);
			return;
		}
		kor = Integer.parseInt(strKor);
		eng = Integer.parseInt(strEng);
		mat = Integer.parseInt(strMat);
		tot = kor + eng + mat;
		avg = tot / 3.0;
		String result = "이름: " + name + "\n"
			+ "총점: " + tot + "\n"
			+ "평균: " + String.format("%.2f", avg);
		ta.setText(result);

	}
}

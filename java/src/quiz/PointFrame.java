package quiz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PointFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMath;
	private JTextArea ta;
	private String name;
	private int kor,eng,math,tot;
	private double avg;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PointFrame frame = new PointFrame();
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
	public PointFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 285, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setBounds(34, 26, 57, 15);
		contentPane.add(lblNewLabel);
		
		tfName = new JTextField();
		tfName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name=tfName.getText();
				if(name.equals("")){
					check("이름을 입력하세요",tfName);
					return;
				}
				tfKor.requestFocus();
			}
		});
		tfName.setBounds(114, 23, 116, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel label = new JLabel("국어");
		label.setBounds(34, 57, 57, 15);
		contentPane.add(label);
		
		tfKor = new JTextField();
		tfKor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strKor=tfKor.getText();
				if( strKor.equals("")){
					check("국어점수를 입력하세요.",tfKor);
					return;
				}				
				tfEng.requestFocus();
			}
		});
		tfKor.setColumns(10);
		tfKor.setBounds(114, 54, 116, 21);
		contentPane.add(tfKor);
		
		JLabel label_1 = new JLabel("영어");
		label_1.setBounds(34, 90, 57, 15);
		contentPane.add(label_1);
		
		tfEng = new JTextField();
		tfEng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strEng=tfEng.getText();
				if( strEng.equals("")){
					check("영어점수를 입력하세요.",tfEng);
					return;
				}
				tfMath.requestFocus();
			}
		});
		tfEng.setColumns(10);
		tfEng.setBounds(114, 87, 116, 21);
		contentPane.add(tfEng);
		
		JLabel label_2 = new JLabel("수학");
		label_2.setBounds(34, 120, 57, 15);
		contentPane.add(label_2);
		
		tfMath = new JTextField();
		tfMath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strMath=tfMath.getText();
				if( strMath.equals("")){
					check("수학점수를 입력하세요.",tfMath);
					return;
				}				
				calc();
			}
		});
		tfMath.setColumns(10);
		tfMath.setBounds(114, 117, 116, 21);
		contentPane.add(tfMath);
		
		JButton btnEval = new JButton("계산");
		btnEval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc();
			}
		});
		btnEval.setBounds(30, 163, 97, 23);
		contentPane.add(btnEval);
		//프레임의 기본 버튼으로 설정
		//포커스를 받은 상태에서 엔터키 입력 가능
		this.getRootPane().setDefaultButton(btnEval);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfName.setText("");
				tfKor.setText("");
				tfEng.setText("");
				tfMath.setText("");
				ta.setText("");
				tfName.requestFocus(); //커서 이동
			}
		});
		btnCancel.setBounds(133, 163, 97, 23);
		contentPane.add(btnCancel);
		
		ta = new JTextArea();
		ta.setBounds(154, 206, 83, 89);
		contentPane.add(ta);
		
		lblResult = new JLabel("New label");
		lblResult.setBounds(34, 206, 93, 89);
		contentPane.add(lblResult);
	}
	void check(String message,JTextField tf){
		JOptionPane.showMessageDialog(
				PointFrame.this, message);
		tf.requestFocus();
	}
	void calc(){
		name=tfName.getText();
//		if(name=="") {
//			check("이름을 입력하세요",tfName);
//			return;
//		}
		if(name.equals("")){
			check("이름을 입력하세요",tfName);
			return;
		}
		String strKor=tfKor.getText();
		if( strKor.equals("")){
			check("국어점수를 입력하세요.",tfKor);
			return;
		}
		String strEng=tfEng.getText();
		if( strEng.equals("")){
			check("영어점수를 입력하세요.",tfEng);
			return;
		}
		String strMath=tfMath.getText();
		if( strMath.equals("")){
			check("수학점수를 입력하세요.",tfMath);
			return;
		}
		kor=Integer.parseInt(strKor);
		eng=Integer.parseInt(strEng);
		math=Integer.parseInt(strMath);
		tot=kor+eng+math;
		avg=tot/3.0;
		String result="이름:"+name+"\n"
				+"총점:"+tot+"\n"
				+"평균:"+String.format("%.2f", avg);
		ta.setText(result);
		
		result="<html>이름:"+name+"<br>"
				+"총점:"+tot+"<br>"
				+"평균:"+String.format("%.2f", avg)+"</html>";
		lblResult.setText(result);
	}
}






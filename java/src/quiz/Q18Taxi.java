package quiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Q18Taxi extends JFrame {

	private JPanel contentPane;
	private JTextField tfKm;
	private int fee;
	private JLabel lblNewLabel_1;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Q18Taxi frame = new Q18Taxi();
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
	public Q18Taxi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("운행거리(km)");
		lblNewLabel.setBounds(44, 41, 95, 15);
		contentPane.add(lblNewLabel);
		
		tfKm = new JTextField();
		tfKm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eval();
			}
		});
		tfKm.setBounds(140, 38, 150, 21);
		contentPane.add(tfKm);
		tfKm.setColumns(10);
		
		lblNewLabel_1 = new JLabel("요금: ");
		lblNewLabel_1.setBounds(44, 77, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		lblResult = new JLabel("");
		lblResult.setFont(new Font("굴림", Font.BOLD, 12));
		lblResult.setBounds(140, 77, 150, 15);
		contentPane.add(lblResult);
		
		JButton btnEval = new JButton("계산");
		btnEval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eval();
			}
		});
		btnEval.setBounds(300, 37, 73, 23);
		contentPane.add(btnEval);
	}
	
	void eval() {
		int m = Integer.parseInt(tfKm.getText()) * 1000;
		if (m <= 2000) {
			fee = 3000;
		} else {
			int temp = m-2000;
			fee = 3000 + (((int)Math.ceil(temp/140.0))*150);
		}
		lblResult.setText((String.valueOf(fee)) + "원 입니다.");
	}

}

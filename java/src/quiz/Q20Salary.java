package quiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Q20Salary extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfJob;
	private JTextField tfSal;
	private JTextField tfBonus;
	private JComboBox cbTaxRate;
	private JLabel taxResult;
	private JLabel salResult;
	private int sal, bonus, tot, tax, money;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Q20Salary frame = new Q20Salary();
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
	public Q20Salary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLabel1 = new JLabel("성명");
		lblLabel1.setBounds(44, 35, 57, 15);
		contentPane.add(lblLabel1);

		JLabel lblLabel2 = new JLabel("직급");
		lblLabel2.setBounds(44, 82, 57, 15);
		contentPane.add(lblLabel2);

		JLabel lblLabel3 = new JLabel("기본급");
		lblLabel3.setBounds(44, 135, 57, 15);
		contentPane.add(lblLabel3);

		JLabel lblLabel4 = new JLabel("보너스");
		lblLabel4.setBounds(44, 188, 57, 15);
		contentPane.add(lblLabel4);

		JLabel lblLabel5 = new JLabel("세율");
		lblLabel5.setBounds(44, 243, 57, 15);
		contentPane.add(lblLabel5);

		JLabel lblLabel6 = new JLabel("세액");
		lblLabel6.setBounds(44, 340, 57, 15);
		contentPane.add(lblLabel6);

		JLabel lblLabel7 = new JLabel("실수령액");
		lblLabel7.setBounds(44, 381, 57, 15);
		contentPane.add(lblLabel7);

		tfName = new JTextField();
		tfName.setBounds(130, 32, 150, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);

		tfJob = new JTextField();
		tfJob.setBounds(130, 79, 150, 21);
		contentPane.add(tfJob);
		tfJob.setColumns(10);

		tfSal = new JTextField();
		tfSal.setBounds(130, 132, 150, 21);
		contentPane.add(tfSal);
		tfSal.setColumns(10);

		tfBonus = new JTextField();
		tfBonus.setBounds(130, 185, 150, 21);
		contentPane.add(tfBonus);
		tfBonus.setColumns(10);

		String cbRate[] = {"0%","3%","5%"};
		cbTaxRate = new JComboBox(cbRate);
//		cbTaxRate.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent e) {
//				if (e.getStateChange() == ItemEvent.SELECTED) {
//					calc();
//				}
//			}
//		});
		cbTaxRate.setBounds(130, 239, 150, 23);
		contentPane.add(cbTaxRate);

		JButton btnCal = new JButton("계산");
		btnCal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc();
			}
		});
		btnCal.setBounds(56, 290, 97, 23);
		contentPane.add(btnCal);

		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfName.setText("");
				tfJob.setText("");
				tfSal.setText("");
				tfBonus.setText("");
				taxResult.setText("");
				salResult.setText("");
				cbTaxRate.setSelectedIndex(0);
			}
		});
		btnCancel.setBounds(172, 290, 97, 23);
		contentPane.add(btnCancel);

		taxResult = new JLabel("");
		taxResult.setBounds(130, 340, 150, 15);
		contentPane.add(taxResult);

		salResult = new JLabel("");
		salResult.setBounds(130, 381, 139, 15);
		contentPane.add(salResult);
	}

	void calc() {
		String strsal = tfSal.getText();
		String strbonus = tfBonus.getText();
		sal = Integer.valueOf(strsal);
		bonus = Integer.valueOf(strbonus);
		tot = sal + bonus;

		int rate_idx = cbTaxRate.getSelectedIndex();
		switch (rate_idx) {
		case 0:
			tax = 0;
			break;
		case 1:
			tax = (int) (tot * 0.03);
			break;
		case 2:
			tax = (int) (tot * 0.05);
			break;
		}
		money = tot - tax;
		taxResult.setText(tax + "");
		salResult.setText(money + "");

	}
}

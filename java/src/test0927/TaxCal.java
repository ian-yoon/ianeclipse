package test0927;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class TaxCal extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfSal;
	private JTextField tfBonus;
	private JComboBox cboTax;
	private JTextArea taResult;
	private String name;
	private int sal, bonus, totalSal, tax;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaxCal frame = new TaxCal();
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
	public TaxCal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("성명");
		lblNewLabel.setBounds(60, 31, 57, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("기본급");
		lblNewLabel_1.setBounds(60, 71, 57, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("보너스");
		lblNewLabel_2.setBounds(60, 115, 57, 15);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("세율");
		lblNewLabel_3.setBounds(60, 159, 57, 15);
		contentPane.add(lblNewLabel_3);

		tfName = new JTextField();
		tfName.setBounds(129, 28, 220, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);

		tfSal = new JTextField();
		tfSal.setBounds(129, 68, 220, 21);
		contentPane.add(tfSal);
		tfSal.setColumns(10);

		tfBonus = new JTextField();
		tfBonus.setBounds(129, 112, 220, 21);
		contentPane.add(tfBonus);
		tfBonus.setColumns(10);

		cboTax = new JComboBox();
		cboTax.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					taResult.setText("");
				}
			}
		});
		cboTax.setModel(new DefaultComboBoxModel(new String[] { "0%", "급여총액의 3%", "급여총액의 5%" }));
		cboTax.setBounds(129, 159, 220, 23);
		contentPane.add(cboTax);

		JButton btnCal = new JButton("계산");
		btnCal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc();
			}
		});
		btnCal.setBounds(161, 219, 97, 23);
		contentPane.add(btnCal);

		taResult = new JTextArea();
		taResult.setBounds(33, 270, 360, 103);
		contentPane.add(taResult);
	}

	void calc() {
		name = tfName.getText();
		sal = Integer.valueOf(tfSal.getText());
		bonus = Integer.valueOf(tfBonus.getText());
		totalSal = sal * 12 + bonus;
		int rate_tax = cboTax.getSelectedIndex();
		switch (rate_tax) {
		case 0:
			tax = 0;
			break;
		case 1:
			tax = (int) (totalSal * 0.03);
			break;
		case 2:
			tax = (int) (totalSal * 0.05);
			break;
		}
		
		taResult.setText(name + "님의 세액은 " + tax + "원 이고, \n실수령액은 " + (totalSal-tax) + "원 입니다.");

	}
}

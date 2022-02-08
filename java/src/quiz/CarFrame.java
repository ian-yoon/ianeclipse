package quiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;

public class CarFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblResult;
	private int sum;
	private int[] money = { 45000, 80000, 30000, 100000 };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarFrame frame = new CarFrame();
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
	public CarFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("자동차 정비 요금 계산");
		setBounds(100, 100, 520, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(82, 43, 345, 102);
		contentPane.add(scrollPane);
		String[] title = { "수리", "가격(원)" };
		String[][] data = { { "엔진 오일 교환", "45,000" }, { "자동 변속기 오일 교환", "80,000" }, { "에어콘 필터 교환", "30,000" },
				{ "타이어 교환", "100,000" } };

		table = new JTable(data, title);
		scrollPane.setViewportView(table);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);

		JPanel panel = new JPanel();
		panel.setBounds(12, 174, 482, 33);
		contentPane.add(panel);

		JCheckBox chEngine = new JCheckBox("엔진오일교환");
		chEngine.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sum += money[0];
				} else {
					sum -= money[0];
				}
				putResult();
			}
		});
		panel.add(chEngine);

		JCheckBox chOil = new JCheckBox("자동변속기오일교환");
		chOil.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sum += money[1];
				} else {
					sum -= money[1];
				}
				putResult();
			}
		});
		panel.add(chOil);

		JCheckBox chFilter = new JCheckBox("에어콘필터교환");
		chFilter.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sum += money[2];
				} else {
					sum -= money[2];
				}
				putResult();
			}
		});
		panel.add(chFilter);

		JCheckBox chTire = new JCheckBox("타이어교환");
		chTire.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sum += money[3];
				} else {
					sum -= money[3];
				}
				putResult();
			}
		});
		panel.add(chTire);

		JButton btnExit = new JButton("종료");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(187, 339, 91, 23);
		contentPane.add(btnExit);

		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("굴림", Font.PLAIN, 20));
		lblResult.setBounds(34, 237, 433, 72);
		lblResult.setOpaque(true);
		lblResult.setBackground(Color.yellow);
		contentPane.add(lblResult, BorderLayout.CENTER);
	}

	void putResult() {
		lblResult.setText("현재까지의 가격은 " + String.format("%,d", sum) + "원입니다.");
	}
}
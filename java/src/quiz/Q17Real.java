package quiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Q17Real extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblResult;
	private int sum;
	private int[] money = {45000, 80000, 30000, 100000};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Q17Real frame = new Q17Real();
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
	public Q17Real() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("자동차 정비 요금 계산");
		setBounds(100, 100, 570, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 530, 157);
		contentPane.add(scrollPane);
		
		String[] title = {"수리", "가격(원)"};
		String[][] data = {{"엔진오일교환", "45,000"}, {"자동변속기오일교환", "80,000"}, {"에어컨필터교환", "30,000"}, {"타이어교환", "100,000"}};
		
		table = new JTable(data, title);
		scrollPane.setViewportView(table);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
		
		JCheckBox ckEngine = new JCheckBox("엔진오일교체");
		ckEngine.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sum += money[0];
				} else {
					sum -= money[0];
				}
				putResult();
			}
		});
		ckEngine.setBounds(33, 189, 108, 23);
		contentPane.add(ckEngine);
		
		JCheckBox ckGear = new JCheckBox("자동변속기오일교체");
		ckGear.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sum += money[1];
				} else {
					sum -= money[1];
				}
				putResult();
			}
		});
		ckGear.setBounds(145, 189, 150, 23);
		contentPane.add(ckGear);
		
		JCheckBox ckAir = new JCheckBox("에어컨필터교체");
		ckAir.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sum += money[2];
				} else {
					sum -= money[2];
				}
				putResult();
			}
		});
		ckAir.setBounds(299, 189, 118, 23);
		contentPane.add(ckAir);
		
		JCheckBox ckTire = new JCheckBox("타이어교체");
		ckTire.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sum += money[3];
				} else {
					sum -= money[3];
				}
				putResult();
			}
		});
		ckTire.setBounds(421, 189, 99, 23);
		contentPane.add(ckTire);
		
		lblResult = new JLabel("");
		lblResult.setFont(new Font("굴림", Font.BOLD, 18));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(50, 242, 461, 37);
		contentPane.add(lblResult);
	}
	
	void putResult() {
		lblResult.setText("현재까지의 가격은 " + String.format("%,d", sum) + "원입니다.");
	}
}

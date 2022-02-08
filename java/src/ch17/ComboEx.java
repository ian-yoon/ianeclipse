package ch17;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ComboEx extends JFrame {

	private JPanel contentPane;
	private JTextArea ta;
	private JComboBox cboTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboEx frame = new ComboEx();
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
	public ComboEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		cboTable = new JComboBox();
		cboTable.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ta.setText("");
					int table = cboTable.getSelectedIndex() + 2;
					for (int i = 1; i <= 9; i++) {
						ta.append(String.format("%2d x %2d = %2d\n", table, i, table * i));
					}
				}
			}
		});
		cboTable.setModel(new DefaultComboBoxModel(new String[] { "2단", "3단", "4단", "5단", "6단", "7단", "8단", "9단" }));
		contentPane.add(cboTable, BorderLayout.NORTH);

		ta = new JTextArea();
		contentPane.add(ta, BorderLayout.CENTER);
	}

}

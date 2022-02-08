package ch17;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckboxEx extends JFrame {

	private JPanel contentPane;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckboxEx frame = new CheckboxEx();
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
	public CheckboxEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JCheckBox ckJava = new JCheckBox("자바");
		ckJava.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ta.append("Java를 신청했습니다.\n");
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					ta.append("Java 신청을 취소했습니다.\n");
				}
			}
		});
		panel.add(ckJava);

		JCheckBox ckC = new JCheckBox("C언어");
		ckC.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ta.append("C언어를 신청했습니다.\n");
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					ta.append("C언어 신청을 취소했습니다.\n");
				}
			}
		});
		panel.add(ckC);

		JCheckBox ckAndroid = new JCheckBox("안드로이드");
		ckAndroid.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ta.append("안드로이드를 신청했습니다.\n");
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					ta.append("안드로이드 신청을 취소했습니다.\n");
				}
			}
		});
		panel.add(ckAndroid);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		ta = new JTextArea();
		scrollPane.setViewportView(ta);

		JButton btnExit = new JButton("종료");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnExit, BorderLayout.SOUTH);
	}

}

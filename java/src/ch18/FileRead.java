package ch18;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;

public class FileRead extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileRead frame = new FileRead();
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
	public FileRead() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tf = new JTextField();
		tf.setBounds(12, 21, 301, 21);
		contentPane.add(tf);
		tf.setColumns(10);

		JButton button1 = new JButton("OK");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String file = tf.getText();
				String str = "";
				BufferedReader reader = null;
				try {
					reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
					ta.setText("");
					while ((str = reader.readLine()) != null) {
						ta.append(str + "\n");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				} finally {
					try {
						if (reader != null) {
							reader.close();
						}
					} catch (IOException e3) {
						e3.printStackTrace();
					}
				}
			}
		});
		button1.setBounds(325, 20, 97, 23);
		contentPane.add(button1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 52, 410, 188);
		contentPane.add(scrollPane);

		ta = new JTextArea();
		scrollPane.setViewportView(ta);
	}

}

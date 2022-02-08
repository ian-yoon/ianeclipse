package ch18;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Directory extends JFrame {

	private JPanel contentPane;
	private JTextField tfDirectory;
	private JTextArea ta;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Directory frame = new Directory();
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
	public Directory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfDirectory = new JTextField();
		tfDirectory.setBounds(12, 25, 301, 21);
		contentPane.add(tfDirectory);
		tfDirectory.setColumns(10);

		JButton button1 = new JButton("OK");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String directory = tfDirectory.getText();
				File file = new File(directory);
				String[] list = file.list();
				ta.setText("");
				for (int i = 0; i < list.length; i++) {
					File f = new File(directory, list[i]);
					String str = f.isDirectory() ? "Directory" : "File";
					ta.append(str + ":" + list[i] + "\n");
				}
			}
		});
		button1.setBounds(325, 25, 97, 23);
		contentPane.add(button1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 58, 400, 174);
		contentPane.add(scrollPane);
		
				ta = new JTextArea();
				scrollPane.setViewportView(ta);
	}
}

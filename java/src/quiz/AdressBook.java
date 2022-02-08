package quiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdressBook extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable tbAdress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdressBook frame = new AdressBook();
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
	public AdressBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lblAdressBook = new JLabel("주소록");
		lblAdressBook.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblAdressBook.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAdressBook, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		String[] title = { "닉네임", "이름", "주소", "전화번호" };
		String[][] data = { { "kim", "김철수", "구로구", "010-1234-5678" }, 
				{ "park", "박주연", "성동구", "010-7894-1235" }, 
				{ "song", "송서진", "강서구", "010-6354-1598" }, 
				{ "jeon", "전성윤", "마포구", "010-2454-8681" } };

		tbAdress = new JTable(data, title);
		scrollPane.setViewportView(tbAdress);

	}
}

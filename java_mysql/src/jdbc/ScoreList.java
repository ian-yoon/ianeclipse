package jdbc;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ScoreList extends JFrame {

	private ScoreDAO dao;
	private Vector<String> col;
	private DefaultTableModel model;
	private ScoreDTO dto;

	private JPanel contentPane;
	private JTable table;
	private JTextField tfStudentNo;
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMat;
	private JTextField tfSearch;
	private JScrollPane scrollPane;
	private JButton btnSave;
	private JButton btnUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreList frame = new ScoreList();
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
	public ScoreList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 230, 530, 251);
		contentPane.add(scrollPane);

		dao = new ScoreDAO();
		col = new Vector<String>();
		col.add("학번");
		col.add("이름");
		col.add("국어");
		col.add("영어");
		col.add("수학");
		col.add("총점");
		col.add("평균");
		list();
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idx = table.getSelectedRow();
				tfStudentNo.setEditable(false);
				tfStudentNo.setText(table.getValueAt(idx, 0) + "");
				tfName.setText(table.getValueAt(idx, 1) + "");
				tfKor.setText(table.getValueAt(idx, 2) + "");
				tfEng.setText(table.getValueAt(idx, 3) + "");
				tfMat.setText(table.getValueAt(idx, 4) + "");
			}
		});

		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("학번");
		lblNewLabel.setBounds(47, 23, 57, 15);
		contentPane.add(lblNewLabel);

		tfStudentNo = new JTextField();
		tfStudentNo.setBounds(119, 20, 195, 21);
		contentPane.add(tfStudentNo);
		tfStudentNo.setColumns(10);

		JLabel label = new JLabel("이름");
		label.setBounds(47, 51, 57, 15);
		contentPane.add(label);

		tfName = new JTextField();
		tfName.setBounds(119, 48, 195, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);

		JLabel label_1 = new JLabel("국어");
		label_1.setBounds(47, 79, 57, 15);
		contentPane.add(label_1);

		tfKor = new JTextField();
		tfKor.setBounds(119, 76, 195, 21);
		contentPane.add(tfKor);
		tfKor.setColumns(10);

		JLabel label_2 = new JLabel("영어");
		label_2.setBounds(47, 107, 57, 15);
		contentPane.add(label_2);

		tfEng = new JTextField();
		tfEng.setBounds(119, 104, 195, 21);
		contentPane.add(tfEng);
		tfEng.setColumns(10);

		JLabel label_3 = new JLabel("수학");
		label_3.setBounds(47, 135, 57, 15);
		contentPane.add(label_3);

		tfMat = new JTextField();
		tfMat.setBounds(119, 132, 195, 21);
		contentPane.add(tfMat);
		tfMat.setColumns(10);

		btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result = dao.insert_score(dto);
				if (result == 1) {
					JOptionPane.showMessageDialog(ScoreList.this, "저장되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnSave.setBounds(347, 44, 97, 23);
		contentPane.add(btnSave);

		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result = dao.update_score(dto);
				if (result == 1) {
					JOptionPane.showMessageDialog(ScoreList.this, "수정되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnUpdate.setBounds(347, 78, 97, 23);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String student_no = tfStudentNo.getText();
				int result = 0;
				int response = JOptionPane.showConfirmDialog(ScoreList.this, "삭제하시겠습니까?");
				if (response == JOptionPane.YES_OPTION) {
					result = dao.delete_score(student_no);
				}
				if (result == 1) {
					JOptionPane.showMessageDialog(ScoreList.this, "삭제되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnDelete.setBounds(347, 112, 97, 23);
		contentPane.add(btnDelete);

		JLabel lblNewLabel_1 = new JLabel("이름을 입력하세요");
		lblNewLabel_1.setBounds(47, 183, 111, 15);
		contentPane.add(lblNewLabel_1);

		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				search();
			}
		});
		tfSearch.setBounds(161, 180, 223, 21);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);

		JButton btnSearch = new JButton("찾기");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnSearch.setBounds(396, 179, 97, 23);
		contentPane.add(btnSearch);
	}

	public void search() {
		String name = tfSearch.getText();
		model = new DefaultTableModel(dao.search_score(name), col) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(model);
	}

	public void input() {
		String student_no = tfStudentNo.getText();
		String name = tfName.getText();
		int kor = Integer.parseInt(tfKor.getText());
		int eng = Integer.parseInt(tfEng.getText());
		int mat = Integer.parseInt(tfMat.getText());
		dto = new ScoreDTO(student_no, name, kor, eng, mat);
	}

	public void clear() {
		tfStudentNo.setText("");
		tfName.setText("");
		tfKor.setText("");
		tfEng.setText("");
		tfMat.setText("");
		tfStudentNo.requestFocus();
		tfStudentNo.setEditable(true);
	}

	public void list() {
		model = new DefaultTableModel(dao.list_score(), col) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}
}

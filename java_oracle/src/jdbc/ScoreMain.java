package jdbc;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScoreMain extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ScoreDAO dao;
	private Vector data, cols;
	private JButton btnAdd;
	private JButton btnEdit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreMain frame = new ScoreMain();
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
	public ScoreMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		dao = new ScoreDAO();
		cols = new Vector();
		cols.add("학번");
		cols.add("이름");
		cols.add("국어");
		cols.add("영어");
		cols.add("수학");
		cols.add("총점");
		cols.add("평균");
		table = new JTable();

		btnAdd = new JButton("점수 추가");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveScore form = new SaveScore(ScoreMain.this);
				form.setVisible(true);
				form.setLocation(200, 200);
			}
		});
		btnAdd.setBounds(12, 22, 97, 23);
		contentPane.add(btnAdd);

		btnEdit = new JButton("수정/삭제");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idx = table.getSelectedRow();
				if(idx == -1) {
					JOptionPane.showMessageDialog(ScoreMain.this, "자료를 선택하세요.");
					return;
				}
				String student_no = String.valueOf(table.getValueAt(idx, 0));
				String name = String.valueOf(table.getValueAt(idx, 1));
				int kor = Integer.valueOf(table.getValueAt(idx, 2) + "");
				int eng = Integer.valueOf(table.getValueAt(idx, 3) + "");
				int mat = Integer.valueOf(table.getValueAt(idx, 4) + "");
				ScoreDTO dto = new ScoreDTO(student_no, name, kor, eng, mat);
				EditScore form = new EditScore(ScoreMain.this, dto);
				form.setVisible(true);
			}
		});
		btnEdit.setBounds(121, 22, 97, 23);
		contentPane.add(btnEdit);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 66, 500, 278);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		refreshTable();

	}

	public void refreshTable() {
		DefaultTableModel model = new DefaultTableModel(dao.listScore(), cols);
		table.setModel(model);
	}
}

package jdbc;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaveScore extends JFrame {

	private JPanel contentPane;
	private JTextField tfStudentNo;
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMat;
	private ScoreMain parent;

	/**
	 * Create the frame.
	 */
	public SaveScore(ScoreMain parent) {
		this.parent = parent;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 330, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl1 = new JLabel("학번");
		lbl1.setBounds(32, 37, 40, 15);
		contentPane.add(lbl1);

		JLabel lbl2 = new JLabel("이름");
		lbl2.setBounds(32, 75, 40, 15);
		contentPane.add(lbl2);

		JLabel lbl3 = new JLabel("국어");
		lbl3.setBounds(32, 113, 40, 15);
		contentPane.add(lbl3);

		JLabel lbl4 = new JLabel("영어");
		lbl4.setBounds(32, 151, 40, 15);
		contentPane.add(lbl4);

		JLabel lbl5 = new JLabel("수학");
		lbl5.setBounds(32, 189, 40, 15);
		contentPane.add(lbl5);

		JButton btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreDAO dao = new ScoreDAO();
				String student_no = tfStudentNo.getText();
				String name = tfName.getText();
				int kor = Integer.valueOf(tfKor.getText());
				int eng = Integer.valueOf(tfEng.getText());
				int mat = Integer.valueOf(tfMat.getText());
				dao.insertScore(new ScoreDTO(student_no, name, kor, eng, mat));
				JOptionPane.showMessageDialog(SaveScore.this, "추가되었습니다.");
				parent.refreshTable();
				dispose();
			}
		});
		btnSave.setBounds(102, 247, 106, 23);
		contentPane.add(btnSave);

		tfStudentNo = new JTextField();
		tfStudentNo.setBounds(84, 34, 189, 21);
		contentPane.add(tfStudentNo);
		tfStudentNo.setColumns(10);

		tfName = new JTextField();
		tfName.setBounds(84, 72, 189, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);

		tfKor = new JTextField();
		tfKor.setColumns(10);
		tfKor.setBounds(84, 110, 189, 21);
		contentPane.add(tfKor);

		tfEng = new JTextField();
		tfEng.setColumns(10);
		tfEng.setBounds(84, 148, 189, 21);
		contentPane.add(tfEng);

		tfMat = new JTextField();
		tfMat.setColumns(10);
		tfMat.setBounds(84, 186, 189, 21);
		contentPane.add(tfMat);
	}
}

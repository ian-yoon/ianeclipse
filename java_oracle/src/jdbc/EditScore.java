package jdbc;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditScore extends JFrame {

	private JPanel contentPane;
	private JTextField tfStudentNo;
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMat;
	private ScoreMain parent;
	private ScoreDTO dto;

	/**
	 * Create the frame.
	 */
	public EditScore(ScoreMain parent, ScoreDTO dto) {
		this.parent = parent;
		this.dto = dto;
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

		tfStudentNo = new JTextField();
		tfStudentNo.setBounds(84, 31, 189, 21);
		contentPane.add(tfStudentNo);
		tfStudentNo.setColumns(10);

		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(84, 72, 189, 21);
		contentPane.add(tfName);

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

		tfStudentNo.setText(dto.getStudent_no());
		tfName.setText(dto.getName());
		tfKor.setText(dto.getKor() + "");
		tfEng.setText(dto.getEng() + "");
		tfMat.setText(dto.getMat() + "");

		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreDAO dao = new ScoreDAO();
				String student_no = tfStudentNo.getText();
				String name = tfName.getText();
				int kor = Integer.valueOf(tfKor.getText());
				int eng = Integer.valueOf(tfEng.getText());
				int mat = Integer.valueOf(tfMat.getText());
				dao.updateScore(new ScoreDTO(student_no, name, kor, eng, mat));
				JOptionPane.showMessageDialog(EditScore.this, "수정되었습니다.");
				parent.refreshTable();
				dispose();
			}
		});
		btnUpdate.setBounds(49, 246, 97, 23);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int response = JOptionPane.showConfirmDialog(EditScore.this, "삭제하시겠습니까?");
				if (response == JOptionPane.YES_OPTION) {
					String student_no = tfStudentNo.getText();
					ScoreDAO dao = new ScoreDAO();
					dao.deleteScore(student_no);
					parent.refreshTable();
					JOptionPane.showMessageDialog(EditScore.this, "삭제되었습니다.");
					dispose();
				}
			}
		});
		btnDelete.setBounds(158, 246, 97, 23);
		contentPane.add(btnDelete);

	}

}

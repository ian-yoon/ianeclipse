package jdbc;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;

public class ComboEx extends JFrame implements ItemListener {

	private JPanel contentPane;
	private JList list;
	private JComboBox combo;
	private EmpDAO empDao;
	private DeptDAO deptDao;
	private ArrayList<DeptDTO> deptList;
	private ArrayList<EmpDTO> empList;

	public ComboEx() {

		empDao = new EmpDAO();
		deptDao = new DeptDAO();
		deptList = deptDao.listDept();
		combo = new JComboBox();
		empList = empDao.listEmp(0);
		for (DeptDTO dto : deptList) {
			combo.addItem(dto.getDname());
		}
		list = new JList();
		refreshList(0);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(combo, BorderLayout.NORTH);
		contentPane.add(list, BorderLayout.CENTER);
		combo.addItemListener(this);
	}

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

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			int idx = combo.getSelectedIndex();
			if (idx != -1) {
				refreshList(idx);
			}
		}
	}

	void refreshList(int idx) {
		int deptno = deptList.get(idx).getDeptno();
		empList = empDao.listEmp(deptno);
		String[] names = new String[empList.size()];
		for (int i = 0; i < names.length; i++) {
			names[i] = empList.get(i).getEname();
		}
		DefaultListModel<String> model = new DefaultListModel<>();
		for (String val : names)
			model.addElement(val);
		list.setModel(model);
	}

}

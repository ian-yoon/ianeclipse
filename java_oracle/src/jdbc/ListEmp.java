package jdbc;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ListEmp extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox cboDept;
	private Vector data, cols;
	private EmpDAO empDao;
	private DeptDAO deptDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListEmp frame = new ListEmp();
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
	public ListEmp() {
		
		empDao = new EmpDAO();
		cols = new Vector();
		cols.add("사원번호");
		cols.add("사원이름");
		cols.add("직급");
		cols.add("입사일자");
		cols.add("급여");
		cols.add("소속부서");
		DefaultTableModel model = new DefaultTableModel(empDao.listEmp("%"), cols);
		
		table = new JTable(model);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cboDept = new JComboBox();
		cboDept.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String dname = cboDept.getSelectedItem().toString();
					DefaultTableModel model = new DefaultTableModel(empDao.listEmp(dname), cols);
					table.setModel(model);
				}
			}
		});
		cboDept.setBounds(12, 10, 140, 23);
		contentPane.add(cboDept);
		
		deptDao = new DeptDAO();
		ArrayList<DeptDTO> deptList = deptDao.listDept();
		cboDept.addItem("전체부서");
		for (DeptDTO dto : deptList) {
			cboDept.addItem(dto.getDname());
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 43, 410, 273);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
	}
}

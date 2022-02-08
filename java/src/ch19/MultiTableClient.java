package ch19;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MultiTableClient extends JFrame {

	private JPanel contentPane;
	private JComboBox cboTable;
	private JTextArea taResult;
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultiTableClient frame = new MultiTableClient();
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
	public MultiTableClient() {
		
		try {
			socket = new Socket("192.168.10.153", 9999);
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cboTable = new JComboBox();
		cboTable.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					int table = cboTable.getSelectedIndex() + 2;
					try {
						dos.writeInt(table);
						taResult.setText(dis.readUTF());
					} catch (Exception e2) {
						e2.printStackTrace();
					}	
				}
			}
		});
		cboTable.setModel(new DefaultComboBoxModel(new String[] {"2단", "3단", "4단", "5단", "6단", "7단", "8단", "9단"}));
		cboTable.setBounds(12, 10, 194, 23);
		contentPane.add(cboTable);
		
		taResult = new JTextArea();
		taResult.setBounds(12, 43, 290, 260);
		contentPane.add(taResult);
	}
}

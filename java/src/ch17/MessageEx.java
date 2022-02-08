package ch17;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MessageEx extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageEx frame = new MessageEx();
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
	public MessageEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton button1 = new JButton("메시지");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MessageEx.this, "안녕.");
			}
		});
		contentPane.add(button1);
		
		JButton button2 = new JButton("확인");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(MessageEx.this, "나갈까요?", "나가기",
						JOptionPane.YES_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		contentPane.add(button2);
		
		JButton button3 = new JButton("입력");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(MessageEx.this, "이름을 입력하세요.");
				JOptionPane.showMessageDialog(MessageEx.this, "환영합니다, " + name);
			}
		});
		contentPane.add(button3);
		
		JButton button4 = new JButton("옵션");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] str = {"추가", "업데이트", "삭제"};
				JOptionPane.showOptionDialog(MessageEx.this,  "메뉴 선택", "옵션",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
			}
		});
		contentPane.add(button4);
	}

}

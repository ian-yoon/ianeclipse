package ch17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuEx extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuEx frame = new MenuEx();
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
	public MenuEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("파일");
		menuBar.add(mnFile);
		
		JMenuItem mnNew = new JMenuItem("새파일");
		mnFile.add(mnNew);
		
		JMenuItem mnOpen = new JMenuItem("열기");
		mnFile.add(mnOpen);
		
		JMenuItem mnSave = new JMenuItem("저장하기");
		mnFile.add(mnSave);
		
		JMenuItem mnExit = new JMenuItem("종료");
		mnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(MenuEx.this, "종료할까요?", "종료",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		mnFile.add(mnExit);
		
		JMenu mnColor = new JMenu("색상");
		menuBar.add(mnColor);
		
		JMenuItem mnRed = new JMenuItem("빨강");
		mnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.red);
			}
		});
		mnColor.add(mnRed);
		
		JMenuItem mnGreen = new JMenuItem("초록");
		mnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.green);
			}
		});
		mnColor.add(mnGreen);
		
		JMenuItem mnBlue = new JMenuItem("파랑");
		mnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.blue);
			}
		});
		mnColor.add(mnBlue);
		
		JMenuItem mnYellow = new JMenuItem("노랑");
		mnYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.yellow);
			}
		});
		mnColor.add(mnYellow);
		
		JMenu mnHelp = new JMenu("도움말");
		menuBar.add(mnHelp);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("New menu item");
		mnHelp.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("New menu item");
		mnHelp.add(mntmNewMenuItem_9);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}

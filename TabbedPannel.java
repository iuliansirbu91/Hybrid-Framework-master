package com.totsy.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSplitPane;
import javax.swing.JButton;

public class TabbedPannel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabbedPannel window = new TabbedPannel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TabbedPannel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		tabbedPane.setBounds(0, 0, 434, 58);
		frame.getContentPane().add(tabbedPane);
		
		JSplitPane splitPane = new JSplitPane();
		tabbedPane.addTab("tab1", null, splitPane, null);
		
		JSplitPane splitPane_1 = new JSplitPane();
		tabbedPane.addTab("tab2", null, splitPane_1, null);
		
		JSplitPane splitPane_2 = new JSplitPane();
		tabbedPane.addTab("tab3", null, splitPane_2, null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 69, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}

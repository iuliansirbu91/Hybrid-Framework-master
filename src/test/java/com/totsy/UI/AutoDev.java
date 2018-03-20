package com.totsy.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.totsy.logs.TextAreaOutputStream;

public class AutoDev {

	  private JFrame frame;
	  private JTextField txtPath;
	  private JTextArea textArea;
	  public static JTextArea ta;
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutoDev window = new AutoDev();
					window.frame.setVisible(true);
				
					 TextAreaOutputStream taos = new TextAreaOutputStream( ta, 60 );
					    PrintStream ps = new PrintStream( taos );
					    System.setOut( ps );
					    System.setErr( ps );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AutoDev() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		  frame = new JFrame();
		    frame.setBounds(100, 100, 450, 300);
		    frame.getContentPane().add( new JLabel(" Output" ), BorderLayout.NORTH );
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.getContentPane().setLayout(null);
		         
		    txtPath = new JTextField();
		    txtPath.setBounds(10, 10, 414, 21);
		    frame.getContentPane().add(txtPath);
		    txtPath.setColumns(10);
		         
		    JButton btnBrowse = new JButton("Browse");
		    btnBrowse.setBounds(10, 41, 87, 23);
		    frame.getContentPane().add(btnBrowse);
		    
		    textArea = new JTextArea();
		    textArea.setBounds(10, 91, 414, 159);
		    frame.getContentPane().add(textArea);
		    

  
		   
		   


		    frame.add( new JScrollPane( ta )  );

		//    frame.pack();
		    frame.setVisible( true );
		 //   frame.setSize(800,600);
		    		    
		    btnBrowse.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		      	  
		      	  
		     // 	  panel.add(new JScrollPane(taskOutput), BorderLayout.CENTER);
		      //      MessageConsole mc = new MessageConsole(taskOutput);
		    
		            
		          JFileChooser fileChooser = new JFileChooser();
		   
		          // For Directory
		          fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		   
		          // For File
		          //fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		   
		          fileChooser.setAcceptAllFileFilterUsed(false);
		   
		          int rVal = fileChooser.showOpenDialog(null);
		          if (rVal == JFileChooser.APPROVE_OPTION) {
		           txtPath.setText(fileChooser.getSelectedFile().toString());
		           
		          }
		        }
		      });
		    
	}

}

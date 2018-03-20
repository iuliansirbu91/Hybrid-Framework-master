package com.totsy.UI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;


import com.totsy.logs.TextAreaOutputStream;

import javax.swing.JTextArea;
 
public class ApplicationUI {
 
  private JFrame frame;
  private JTextField txtPath;
 
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
       try {
    	   ApplicationUI window = new ApplicationUI();
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
  public ApplicationUI() {
    initialize();
  }
 
  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.add( new JLabel(" Outout" ), BorderLayout.NORTH );
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
         
    

    JTextArea ta = new JTextArea();
    TextAreaOutputStream taos = new TextAreaOutputStream( ta, 60 );
    PrintStream ps = new PrintStream( taos );
    System.setOut( ps );
    System.setErr( ps );


    frame.add( new JScrollPane( ta )  );

    frame.pack();
    frame.setVisible( true );
    frame.setSize(800,600);
    
    
    
    txtPath = new JTextField();
    txtPath.setBounds(10, 10, 414, 21);
    frame.getContentPane().add(txtPath);
    txtPath.setColumns(10);
         
    JButton btnBrowse = new JButton("Browse");
    btnBrowse.setBounds(10, 41, 87, 23);
    frame.getContentPane().add(btnBrowse);
    
    JTextArea textArea = new JTextArea();
    textArea.setBounds(10, 119, 414, 131);
    frame.getContentPane().add(textArea);
    
    
   
         
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

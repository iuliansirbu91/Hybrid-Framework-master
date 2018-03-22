package com.totsy.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import com.totsy.logs.TextAreaOutputStream;
import com.totsy.test.DriverScript;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Color;


public class ApplicationUI extends JFrame{
	public static Properties CONFIG;
    public static Properties OR;
	
	private JButton browse1;
	private JButton browse2;
	private JButton browse3;
	private JButton start;
	private JTextField item1;
	private JTextField item2;
	private JTextField item3;
	public JTextArea textArea;
		
	private JPasswordField passwordField;
	private JTextField textField;
	private JButton btnRun;
	private FileInputStream fs1;
	private FileInputStream fs;
	
	private PrintStream standardOut;
	private JScrollPane scrollBar;
	
	public ApplicationUI() {
		super("OBAutoDev");
	
	thehandler handler = new thehandler();
	//JFrame frame = new JFrame();
	
		browse1 = new JButton("Browse");
		browse1.setBounds(22, 11, 67, 23);
		browse1.addActionListener(handler);
		
		item1 = new JTextField("C:\\Users\\isirbu\\Desktop\\Documente\\Automation\\xls");
		item1.setBounds(131, 12, 482, 20);
		item1.setEditable(false);
		item1.addActionListener(handler);
	
		browse2 = new JButton("Browse");
		browse2.setBounds(22, 45, 67, 23);
		browse2.addActionListener(handler);
	
	item2 = new JTextField("C:\\Users\\isirbu\\Desktop\\Documente\\Automation\\xls\\or.properties");
	item2.setBounds(131, 46, 482, 20);
	item2.setEditable(false);
	getContentPane().setLayout(null);
	getContentPane().add(browse1);
	getContentPane().add(item1);
	getContentPane().add(browse2);
	getContentPane().add(item2);
	
	browse3 = new JButton("Browse");
	browse3.setBounds(22, 79, 67, 23);
	browse3.addActionListener(handler);
	getContentPane().add(browse3);
	
	item3 = new JTextField("C:\\Users\\isirbu\\Desktop\\Documente\\Automation\\xls\\config.properties");
	item3.setBounds(131, 82, 166, 20);
	item3.setEditable(false);
	getContentPane().add(item3);
	
	btnRun = new JButton("RUN");
	btnRun.setBackground(Color.GREEN);
	btnRun.setBounds(131, 129, 482, 23);
	getContentPane().add(btnRun);
	btnRun.addActionListener(handler);
	//JTextArea log = new JTextArea();
	System.out.println("text de afisat in jarea");
	
	textArea = new JTextArea(16,58);
	textArea.setBounds(28, 163, 585, 244);
    textArea.setEditable(false);
	
	
    PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
    
    // keeps reference of standard output stream
    standardOut = System.out;
     
    // re-assigns standard output stream and error output stream
    System.setOut(printStream);
    System.setErr(printStream);
    getContentPane().add(textArea);
//	getContentPane().add(textArea);
	// textArea.setEditable(false);
	
		
	}
	
	public Properties getConfig() throws IOException
		{
			if (CONFIG == null){
			fs1 = new FileInputStream(item3.getText());
			//string = item2.getText();
			Properties CONFIG2 = new Properties();
	        CONFIG2.load(fs1);
	        return CONFIG2;
	        				
			}
			else 
		    return CONFIG;
	}

	public Properties getGui() throws IOException
	{
		if (OR == null){
		fs = new FileInputStream(item2.getText());
		//string = item2.getText();
		Properties OR2 = new Properties();
        OR2.load(fs1);
        return OR2;
        				
		}
		else 
	    return OR;
}
	
	private class thehandler implements ActionListener {
	
		private JFileChooser fileChooser;
		
		public void actionPerformed(ActionEvent event){

			

			String string = "";
			if(event.getSource()==browse1){
				//string = String.format("field 1: %s", event.getActionCommand());
				
				  fileChooser = new JFileChooser();
				   
		          // For Directory
		          fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		   
		          // For File
		          //fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		   
		          fileChooser.setAcceptAllFileFilterUsed(false);
		   
		          int rVal = fileChooser.showOpenDialog(null);
		          if (rVal == JFileChooser.APPROVE_OPTION) 
		          item1.setText(fileChooser.getSelectedFile().toString());
					}
			else if (event.getSource()==browse2){
				
				//string = String.format("field 1: %s", event.getActionCommand());
				 fileChooser = new JFileChooser();
				 // For Directory
		          fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		          // For File
		          //fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		          fileChooser.setAcceptAllFileFilterUsed(false);
		          int rVal = fileChooser.showOpenDialog(null);
		          if (rVal == JFileChooser.APPROVE_OPTION) 				
				
				//string = String.format("field 2: %s", event.getActionCommand());
				item2.setText(fileChooser.getSelectedFile().toString());
				//FileInputStream fs;
				try {
					fs = new FileInputStream(item2.getText());
					 System.out.println(item2.getText());
				//string = item2.getText();
				OR= new Properties();
			    OR.load(fs);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if (event.getSource()==browse3 ){
				
				//string = String.format("field 1: %s", event.getActionCommand());
				
				  JFileChooser fileChooser = new JFileChooser();
				   
		          // For Directory
		          fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		   
		          // For File
		          //fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		   
		          fileChooser.setAcceptAllFileFilterUsed(false);
		   
		          int rVal = fileChooser.showOpenDialog(null);
		          if (rVal == JFileChooser.APPROVE_OPTION) 
				
				//string = String.format("field 2: %s", event.getActionCommand());
				item3.setText(fileChooser.getSelectedFile().toString());
				
				try {
					fs1 = new FileInputStream(item2.getText());
				
				//string = item2.getText();
				CONFIG= new Properties();
		        CONFIG.load(fs1);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (event.getSource()==btnRun ){
				string = String.format("a inceput rularea programului %s", event.getActionCommand());
				JOptionPane.showMessageDialog(null, string);
				
				
				
			//	item1.setText(fileChooser.getSelectedFile().toString());
				
				string = item1.getText();
				
				DriverScript test = null;
				try {
					test = new DriverScript();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					
					test.start(string);
					
					
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
			//JOptionPane.showMessageDialog(null, string);
			
			
			/* 
			 * 
			 * 
			 * else if (event.getSource()==item3)
				string = String.format("field 3: %s", event.getActionCommand());
			else if (event.getSource()==passwordField)
				string = String.format("password field is : %s", event.getActionCommand());
			else if (rVal == JFileChooser.APPROVE_OPTION)
				item2.setText(fileChooser.getSelectedFile().toString());
			 * 
			 * 
			 * 
			 * 
			 * */
		
		    
		}
	}
}
package com.totsy.UI;

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

/*
 * TabDemo.java
 */

import java.awt.*;
import javax.swing.*;

import com.totsy.logs.TextAreaOutputStream;
import com.totsy.test.DriverScript;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.awt.event.ActionEvent;


public class TabDemo {
	thehandler handler = new thehandler();
    final static String BUTTONPANEL1 = "Test Files";
    final static String BUTTONPANEL2 = "Results";
    final static String BUTTONPANEL3 = "Settings";
    final static int extraWindowWidth = 100;
    
    public static Properties CONFIG;
    public static Properties OR;
    public static String string;
    public static String radioButton;
    public static String screenshot_everystep;
    public static final String Y= "Y";
    public static final String N= "N";
    public JTextArea textArea;
    
    private JFileChooser fileChooser;
    private TextAreaOutputStream textAreaOutputStream;
	
//	private JPasswordField passwordField;
//	private JTextField textField;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton btnRun;
	private FileInputStream fs1;
	private FileInputStream fs;
	private JRadioButton rdbtnNewRadioButton,rdbtnNewRadioButton_1;
	
	private PrintStream standardOut;
//	private JScrollPane scrollBar;
//	private JScrollPane scrollPane;
    
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField txtHttpsrositecbnielocalpublicportaladmin;
    private JTextField textField_3;

    public void addComponentToPane(Container pane) {
    	
        JTabbedPane tabbedPane = new JTabbedPane();

        //Create the "cards".
        JPanel card1 = new JPanel() {
            //Make the panel wider than it really needs, so
            //the window's wide enough for the tabs to stay
            //in one row.
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }
        };
        card1.setLayout(null);

        JPanel card2 = new JPanel();

        tabbedPane.addTab(BUTTONPANEL1, card1);
        
        btnRun = new JButton("RUN");
        btnRun.setBackground(Color.GREEN);
        btnRun.setBounds(12, 169, 745, 148);
        btnRun.addActionListener(handler);
        card1.add(btnRun);
        
        button = new JButton("...");
        button.setBounds(714, 12, 43, 23);
        card1.add(button);
        
        textField = new JTextField("C:\\Users\\isirbu\\Desktop\\Documente\\Automation\\xls\\Suite.xlsx");
        textField.setBounds(184, 13, 519, 20);
        card1.add(textField);
        
        textField_1 = new JTextField("C:\\Users\\isirbu\\Desktop\\Documente\\Automation\\xls\\or.properties");
        textField_1.setBounds(184, 47, 519, 20);
        card1.add(textField_1);
        
        button_1 = new JButton("...");
        button_1.setBounds(714, 47, 43, 23);
        card1.add(button_1);
        
        button_2 = new JButton("...");
        button_2.setBounds(714, 82, 43, 23);
        card1.add(button_2);
        
        textField_2 = new JTextField("C:\\Users\\isirbu\\Desktop\\Documente\\Automation\\xls\\config.properties");
        textField_2.setBounds(184, 83, 519, 20);
        card1.add(textField_2);
        
        JButton button_4 = new JButton("...");
        button_4.setBounds(714, 117, 43, 23);
        card1.add(button_4);
        
        textField_3 = new JTextField("C:\\Users\\isirbu\\Desktop\\Documente\\Automation\\xls\\config.properties");
        textField_3.setBounds(184, 118, 519, 20);
        card1.add(textField_3);
        
        JTextPane txtpnSuite = new JTextPane();
        txtpnSuite.setText("Suite");
        txtpnSuite.setOpaque(false);
        txtpnSuite.setEditable(false);
        txtpnSuite.setBounds(28, 12, 136, 22);
        card1.add(txtpnSuite);
        
        JTextPane txtpnGuiMap = new JTextPane();
        txtpnGuiMap.setText("GUI Map");
        txtpnGuiMap.setOpaque(false);
        txtpnGuiMap.setEditable(false);
        txtpnGuiMap.setBounds(28, 48, 136, 22);
        card1.add(txtpnGuiMap);
        
        JTextPane txtpnSettingsFile = new JTextPane();
        txtpnSettingsFile.setText(BUTTONPANEL3);
        txtpnSettingsFile.setOpaque(false);
        txtpnSettingsFile.setEditable(false);
        txtpnSettingsFile.setBounds(28, 83, 136, 22);
        card1.add(txtpnSettingsFile);
        
        JTextPane txtpnScreenshots = new JTextPane();
        txtpnScreenshots.setText("Screenshots ");
        txtpnScreenshots.setOpaque(false);
        txtpnScreenshots.setEditable(false);
        txtpnScreenshots.setBounds(28, 118, 136, 22);
        card1.add(txtpnScreenshots);
        tabbedPane.addTab(BUTTONPANEL2, card2);
        card2.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane((Component) null);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setAutoscrolls(true);
        scrollPane.setAlignmentX(1.0f);
        scrollPane.setBounds(0, 0, 757, 317);
        card2.add(scrollPane);
        
        textArea = new JTextArea(5, 20);
        scrollPane.setViewportView(textArea);
        textArea.setEditable(false);
        textArea.setAlignmentX(1.0f);

        pane.add(tabbedPane, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        tabbedPane.addTab("Settings", null, panel, null);
        panel.setLayout(null);
        
        txtHttpsrositecbnielocalpublicportaladmin = new JTextField();
        txtHttpsrositecbnielocalpublicportaladmin.setText("https://ro-site.cbnie.local/public-portal-admin/");
        txtHttpsrositecbnielocalpublicportaladmin.setBounds(108, 47, 649, 20);
        panel.add(txtHttpsrositecbnielocalpublicportaladmin);
        txtHttpsrositecbnielocalpublicportaladmin.setColumns(10);
        
        JTextPane txtpnUrl = new JTextPane();
        txtpnUrl.setOpaque(false);
        txtpnUrl.setText("URL");
        txtpnUrl.setEditable(false);
        txtpnUrl.setBounds(12, 45, 84, 22);
        panel.add(txtpnUrl);
        
        JTextPane txtpnBrowserType = new JTextPane();
        txtpnBrowserType.setText("Browser Type");
        txtpnBrowserType.setOpaque(false);
        txtpnBrowserType.setEditable(false);
        txtpnBrowserType.setBounds(12, 86, 84, 22);
        panel.add(txtpnBrowserType);
        
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Chrome");
        comboBox.addItem("Mozilla");
        comboBox.addItem("IE");        
        comboBox.setBounds(108, 79, 649, 25);
        panel.add(comboBox);
        
        rdbtnNewRadioButton = new JRadioButton("Capture screenshot on Every Step");
        rdbtnNewRadioButton.setActionCommand("Y");
        rdbtnNewRadioButton.setBounds(103, 168, 280, 23);
        panel.add(rdbtnNewRadioButton);
        
        rdbtnNewRadioButton_1 = new JRadioButton("Capture screenshot only on error");
        rdbtnNewRadioButton_1.setSelected(true);
        rdbtnNewRadioButton_1.setActionCommand("N");
        rdbtnNewRadioButton_1.setBounds(455, 168, 241, 23);
        panel.add(rdbtnNewRadioButton_1);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
    	JFrame frame = new JFrame("ObAutoDev");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        TabDemo demo = new TabDemo();
        demo.addComponentToPane(frame.getContentPane());

        //Display the window.
       // frame.pack();
        frame.setResizable(true);
    }
    
    
    public Properties getConfig() throws IOException
	{
		if (CONFIG == null){
		fs1 = new FileInputStream(textField.getText());
		//string = button_1.getText();
		Properties CONFIG2 = new Properties();
        CONFIG2.load(fs1);
        return CONFIG2;
        				
		}
		else 
	    return CONFIG;
}

public String getSelected() throws IOException
{
	 if (screenshot_everystep=="Y") {
		 
		return screenshot_everystep;
}
	 else {
		 screenshot_everystep = "N";
		 return screenshot_everystep;
	 }
		
}

public Properties getGui() throws IOException
{   
	if (OR == null){
	fs = new FileInputStream(textField_1.getText());
	//string = button_1.getText();
	Properties OR2 = new Properties();
    OR2.load(fs);
    return OR2;
	
	}
	else 
    return OR;
}

private void customInit() {

    PrintStream ps = new PrintStream(getTextAreaOutputStream());
    System.setOut(ps);
//    System.setErr( ps );
  //   filePath.setText("/home/alex/Public/Book1.csv");
}

private TextAreaOutputStream getTextAreaOutputStream() {
    if(textAreaOutputStream == null)
    {
        textAreaOutputStream = new TextAreaOutputStream( textArea, 1000 );
    }
    return textAreaOutputStream;
}

class MyClass extends Thread {
	
	public void run() {
		
		string = textField.getText();
		
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
		    PrintStream printStream = new PrintStream(new TextAreaOutputStream(textArea));
		    
		    //  keeps reference of standard output stream
		      standardOut = System.out;
		       
		   //    re-assigns standard output stream and error output stream
		      System.setOut(printStream);
		      System.setErr(printStream);
			System.out.println("A inceput testarea");
			
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
	
}




    

    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
	public class thehandler implements ActionListener, MouseListener {
	    
	
	
/*	public void mouseClicked(MouseEvent event) {

		
	}
	
	
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		System.out.println("clicked");
		if (event.equals(rdbtnNewRadioButton)){
			string = "Y";
			radioGroup.clearSelection();
			
		}else if (event.get){
			string = "N";
			radioGroup.clearSelection();
			
		}
	}
	*/
    
    public void actionPerformed(ActionEvent event){
		if(event.getSource()==button){
			//string = String.format("field 1: %s", event.getActionCommand());
			
			  fileChooser = new JFileChooser();
			   
	          // For Directory
	          fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	   
	          // For File
	          //fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	   
	          fileChooser.setAcceptAllFileFilterUsed(false);
	   
	          int rVal = fileChooser.showOpenDialog(null);
	          if (rVal == JFileChooser.APPROVE_OPTION) 
	          button.setText(fileChooser.getSelectedFile().toString());
				}
		else if (event.getSource()==button_1){
			
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
			button_1.setText(fileChooser.getSelectedFile().toString());
			//FileInputStream fs;
			try {
			   fs = new FileInputStream(button_1.getText());
			   System.out.println(button_1.getText());
			//string = button_1.getText();
			OR= new Properties();
		    OR.load(fs);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if (event.getSource()==button_2 ){
			
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
			button_2.setText(fileChooser.getSelectedFile().toString());
			
			try {
				fs1 = new FileInputStream(button_1.getText());
			
			//string = button_1.getText();
			CONFIG= new Properties();
	        CONFIG.load(fs1);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (event.getSource()==btnRun ){
		//	string = String.format("a inceput rularea programului %s", event.getActionCommand());
		//	JOptionPane.showMessageDialog(null, string);
			
			
			
		//	button.setText(fileChooser.getSelectedFile().toString());
			
        MyClass myClass = new MyClass();
        myClass.start();
			
		}else if (event.getActionCommand().equals(Y)) {
			screenshot_everystep = "Y";
			rdbtnNewRadioButton_1.setSelected(false);
			
		}else {
			screenshot_everystep = "N";
			
			rdbtnNewRadioButton.setSelected(false);
		}
		//JOptionPane.showMessageDialog(null, string);
		
		
		/* 
		 * 
		 * 
		 * else if (event.getSource()==button_2)
			string = String.format("field 3: %s", event.getActionCommand());
		else if (event.getSource()==passwordField)
			string = String.format("password field is : %s", event.getActionCommand());
		else if (rVal == JFileChooser.APPROVE_OPTION)
			button_1.setText(fileChooser.getSelectedFile().toString());
		 * 
		 * 
		 * 
		 * 
		 * */
	
	    
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    
	}
    
}





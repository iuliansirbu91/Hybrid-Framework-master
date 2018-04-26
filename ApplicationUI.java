package com.totsy.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.DefaultCaret;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import javax.swing.JButton;
import javax.swing.JFileChooser;

//import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.totsy.logs.MessageConsole;
import com.totsy.logs.TextAreaOutputStream;
import com.totsy.test.DriverScript;
import com.totsy.test.Keywords.Scratch;
import com.totsy.util.ReportUtil;

import javax.swing.ButtonGroup;

import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.JRadioButton;
import java.awt.Component;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import javax.swing.JProgressBar;


public class ApplicationUI extends JFrame{
	public static Properties CONFIG;
    public static Properties OR;
    public static String string,text;
    public static String radioButton;
    public static String screenshot_everystep;
    public static final String Y= "Y";
    public static final String N= "N";
    public static int curentTest,totalTest;
    
    
//    private ButtonGroup radioGroup;
	private JRadioButton rdbtnNewRadioButton,rdbtnNewRadioButton_1;
	private JButton browse1,browse2,browse3,btnClearLog,btnSaveLog;
//	private JButton start;
	private JTextField item1;
	private JTextField item2;
	private JTextField item3;
	public JTextArea textArea;
	final static int extraWindowWidth = 100;
	private TextAreaOutputStream textAreaOutputStream;
	private MessageConsole mc;
//	private JPasswordField passwordField;
//	private JTextField textField;
	private JTextPane textPane;
	private JButton btnRun;
	private FileInputStream fs1;
	private FileInputStream fs;
	
	private PrintStream standardOut;
	private JScrollPane scrollBar;
	private JScrollPane scrollPane;
	private JTabbedPane tabbedPane;
	private JProgressBar progressBar;
	private JPanel panel;
	private JPanel panel_1;
	private JFileChooser saveFile,saveReport;
	private JButton btnGenerateReport;

	  public static void updateProgressBar(int nr1,int nr2) {
			// TODO Auto-generated method stub
		  	if (nr1<=nr2)  {
		  		System.out.println(nr1+ " " + nr2);
		  //		ApplicationUI prg = new ApplicationUI();
		  //		APP_LOGS.debug("Numarul 1: " + nr1 +"si : " + nr2 );
		  		int progress = (100/nr2)*nr1;
		 // 		progressBar.setValue(progress);
		  		
	        
		  	}
		}

	  
  
	
	
	public static void createAndShowGUI() {
        //Create and set up the window.
  //  	
    	ApplicationUI bucky = new ApplicationUI();
       

        //Create and set up the content pane.
   //     TabDemo demo = new TabDemo();
  //      demo.addComponentToPane(frame.frame.getContentPane());

        //Display the window.

  //      bucky.frame.getContentPane().setLayout(new BorderLayout());
    //    bucky.setResizable(true);
        bucky.getContentPane().setLayout(new GridLayout());
       
    }
    
	
	public ApplicationUI() {
	//	super("OBAutoDev");
	

	thehandler handler = new thehandler();
//	System.out.println(item2.getText());
	getContentPane().setLayout(null);
	
	tabbedPane = new JTabbedPane();
	tabbedPane.setBounds(0, 0, 846, 602);
	getContentPane().add(tabbedPane);
	
	panel = new JPanel() {
		public Dimension getPreferredSize() {
			return (Dimension) null;
		}
	};
	panel.setLayout(null);
	tabbedPane.addTab("Test Files", null, panel, null);
	          //	JFrame frame = new JFrame();
	          	   
	          		browse1 = new JButton("Browse");
	          		browse1.setBounds(665, 42, 80, 23);
	          		panel.add(browse1);
	          		
	          		item1 = new JTextField("C:\\Users\\isirbu\\Desktop\\Documente\\Automation\\xls\\Suite.xlsx");
	          		item1.setBounds(162, 43, 482, 20);
	          		panel.add(item1);
	          		
	          			browse2 = new JButton("Browse");
	          			browse2.setBounds(665, 73, 80, 23);
	          			panel.add(browse2);
	          			
	          			item2 = new JTextField("C:\\Users\\isirbu\\Desktop\\Documente\\Automation\\xls\\or.properties");
	          			item2.setBounds(162, 74, 482, 20);
	          			panel.add(item2);
	          			
	          			browse3 = new JButton("Browse");
	          			browse3.setBounds(665, 107, 80, 23);
	          			panel.add(browse3);
	          			
	          			item3 = new JTextField("C:\\Users\\isirbu\\Desktop\\Documente\\Automation\\xls\\config.properties");
	          			item3.setBounds(162, 107, 482, 20);
	          			panel.add(item3);
	          			
	          			btnRun = new JButton("RUN");
	          			btnRun.setBounds(100, 235, 591, 39);
	          			panel.add(btnRun);
	          			btnRun.setBackground(Color.GREEN);
	          			
	          			progressBar = new JProgressBar();
	          		//	progressBar.setValue(0);
	    				progressBar.setBounds(100, 298, 591, 30);
	    				progressBar.setStringPainted(true);
	    				panel.add(progressBar);

	    			//	setContentPane(progressBar);
	          			
	          			rdbtnNewRadioButton = new JRadioButton("Capture screenshot on Every Step");
	          			rdbtnNewRadioButton.setBounds(456, 159, 232, 23);
	          			panel.add(rdbtnNewRadioButton);
	          			//	rdbtnNewRadioButton.setMnemonic(KeyEvent.VK_M);
	          				rdbtnNewRadioButton.addActionListener(handler);
	          				rdbtnNewRadioButton.setActionCommand(Y);
	          				//	rdbtnNewRadioButton.setEnabled(false);
	          					
	          					
	          					rdbtnNewRadioButton_1 = new JRadioButton("Capture screenshot only on error");
	          					rdbtnNewRadioButton_1.setBounds(100, 159, 220, 23);
	          					panel.add(rdbtnNewRadioButton_1);
	          					//	rdbtnNewRadioButton_1.setMnemonic(KeyEvent.VK_M);
	          						rdbtnNewRadioButton_1.addActionListener(handler);
	          						rdbtnNewRadioButton_1.setActionCommand(N);
	          						rdbtnNewRadioButton_1.setSelected(true);
	          						

	          						          
	          						            panel_1 = new JPanel() {
	          						          	public Dimension getPreferredSize() {
	          						          	Dimension size = super.getPreferredSize();
	          					                size.width += extraWindowWidth;
	          					                return size;
	          						          	}
	          						          };
	          						          panel_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	          						          panel_1.setLayout(null);
	          						          tabbedPane.addTab("Results", null, panel_1, null);
	          						          //JTextArea log = new JTextArea();
	          						          //System.out.println("text de afisat in jarea");
    						                   textPane = new JTextPane();
    						                   textPane.setBounds(1, 1, 822, 532);
    						                   textPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
 	          						  
    						                   textPane.setEditable(false);
    						                  
 	          						           panel_1.add(textPane);
    						                  
	          		/*				          textArea = new JTextArea(16,58);
	          						        textArea.setAlignmentX(Component.RIGHT_ALIGNMENT);
	          						      textArea.setBounds(22, 227, 562, 180);
	          						    textArea.setEditable(false);
	          						    panel_1.add(textArea); 
	          						          
	          						            textArea.setColumns(20);
	          						            textArea.setRows(5);*/
	          						            //    DefaultCaret caret = (DefaultCaret)textArea.getCaret();
	          						            //    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
	          						               // textArea.setPreferredSize(new Dimension(50,50));
	          						             //   
	          						                
	          						                scrollPane = new JScrollPane(textPane);
	          						                scrollPane.setSize(new Dimension(800, 800));
	          						                scrollPane.setBounds(0, 0, 841, 528);
	          						                panel_1.add(scrollPane);
	          						                scrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
	          						                scrollPane.setAutoscrolls(true);
	          						                //	scrollPane.setViewportView(textArea);
	          						                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	          						                    
	          						                    btnClearLog = new JButton("Clear log");
	          						                    btnClearLog.setBounds(274, 537, 89, 23);
	          						                    panel_1.add(btnClearLog);
	          						                    btnClearLog.addActionListener(handler);
	          						                    
	          						                    btnSaveLog = new JButton("Save log");
	          						                    btnSaveLog.setBounds(389, 537, 89, 23);
	          						                    panel_1.add(btnSaveLog);
	          						                    
	          						                    btnSaveLog.addActionListener(handler);
	          						                    btnGenerateReport = new JButton("Generate Report");
	          						                    btnGenerateReport.setBounds(501, 537, 113, 23);
	          						                    panel_1.add(btnGenerateReport);
	          						                    btnGenerateReport.addActionListener(handler);
	          						                  //  scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	          						                   
	          			btnRun.addActionListener(handler);
	          			browse3.addActionListener(handler);
	          			browse2.addActionListener(handler);
	          		//	item1.setEditable(false);
	          			item1.addActionListener(handler);
	          		browse1.addActionListener(handler);
	
	
	
		
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
		fs = new FileInputStream(item2.getText());
		//string = item2.getText();
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
//        System.setErr( ps );
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
				
			    //PrintStream printStream = new PrintStream(new TextAreaOutputStream(textArea));
			  //  textArea.setText(null);
			   //  keeps reference of standard output stream
			  //    standardOut = System.out;
			   //    re-assigns standard output stream and error output stream
			 //     System.setOut(printStream);
			   //   System.setErr(printStream);
		/*	    textPane.setText(null);
				mc = new MessageConsole(textPane);
				mc.redirectOut();
				mc.redirectErr(Color.RED, null);
				mc.setMessageLines(100);
				
				
				*/
				System.out.println("A inceput testarea");
//				for (int i=0;i<=100;i++) {
//					progressBar.setValue(i);
	//			}
				progressBar.setValue(0);
				test.start(string);

				  //                      System.out.println(pair.first()+ " " + pair.second());
				
		    	
				
				
				
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
	

	
	
	
		public class thehandler implements ActionListener, MouseListener {
	    
		private JFileChooser fileChooser;
		
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
			if(event.getSource()==browse1){
				//string = String.format("field 1: %s", event.getActionCommand());
				
				  fileChooser = new JFileChooser();
				   
		          // For Directory
		          fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		   
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
				
			}else if (event.getSource()==browse3 ){
				
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
			}else if (event.getSource()==btnRun ){
			//	string = String.format("a inceput rularea programului %s", event.getActionCommand());
			//	JOptionPane.showMessageDialog(null, string);
				
				
				
			//	item1.setText(fileChooser.getSelectedFile().toString());
				
            MyClass myClass = new MyClass();
            myClass.start();
				
			}else if (event.getActionCommand().equals(Y)) {
				screenshot_everystep = "Y";
				rdbtnNewRadioButton_1.setSelected(false);
				
			}else if (event.getSource()==btnClearLog){
				
				textPane.setText(null);
				
			}else if (event.getSource()==btnSaveLog){
				
		        text = textPane.getText();
		        saveFile = new JFileChooser();
		        int option = saveFile.showSaveDialog(null);
		        saveFile.setDialogTitle("Save the file...");

		        if (option == JFileChooser.APPROVE_OPTION) {

		            File file = saveFile.getSelectedFile();
		            if (!file.exists()) {

		                try {
		                    BufferedWriter writer = new BufferedWriter(
		                            new FileWriter(file.getAbsolutePath() + ".txt"));
		                    writer.write(text);
		                    writer.close();

		                } catch (IOException ex) {

		                    ex.printStackTrace();
		                    System.out.println(ex.getMessage());
		                    JOptionPane.showMessageDialog(null,
		                            "Failed to save the file");
		                }

		            }

		            else if (file.exists()) {

		                int confirm = JOptionPane.showConfirmDialog(null,
		                        "File exists do you want to save anyway?");
		                if (confirm == 0) {

		                    try {
		                        BufferedWriter writer = new BufferedWriter(
		                                new FileWriter(file.getAbsolutePath()
		                                        + ".txt"));
		                        writer.write(text);
		                        writer.close();

		                    } catch (IOException ex) {

		                        ex.printStackTrace();
		                        System.out.println(ex.getMessage());
		                        JOptionPane.showMessageDialog(null,
		                                "Failed to save the file");
		                    }

		                }

		                else if (confirm == 1) {

		                    JOptionPane.showMessageDialog(null,
		                            "The file was not saved.");

		                }

		            }

		        }

		        if (option == JFileChooser.CANCEL_OPTION) {

		            saveFile.setVisible(false);

		        }
				
			}else if (event.getSource()==btnGenerateReport){
				
				saveReport = new JFileChooser();
				saveReport.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);				
				int optionReport = saveReport.showSaveDialog(null);
		        
		        saveReport.setDialogTitle("Save the file...");

		        if (optionReport == JFileChooser.APPROVE_OPTION) {
		        	
		            File file = saveReport.getSelectedFile();




		                //	btnGenerateReport.setText(saveReport.getSelectedFile().toString());
		                	String reportPath = saveReport.getSelectedFile().toString();
		                    String configPath = item3.getText();
		                    String suitePath = item1.getText();
		                    ReportUtil generateReport = new ReportUtil();
		                    try {
		                    	
							int val = generateReport.generateReport(suitePath, configPath, reportPath);
								if (val ==1) {
									JOptionPane.showMessageDialog(null,
				                            "Report generated successfully");
								}
								else {
									JOptionPane.showMessageDialog(null,
				                            "Failed to generate the file");
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
						

		            }

		        }

		        if (optionReport == JFileChooser.CANCEL_OPTION) {

		        	saveReport.setVisible(false);
		            }
				
			}else {
				screenshot_everystep = "N";
				
				rdbtnNewRadioButton.setSelected(false);
			}
			//JOptionPane.showMessageDialog(null, string);
			
			
			/* 
			 * 
			 * 
			 * btnGenerateReport
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

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


	}
}
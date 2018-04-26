package com.totsy.UI;


import javax.swing.*;

import com.totsy.logs.MessageConsole;
import com.totsy.logs.TextAreaOutputStream;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Properties;

public class SwingWorkerExample extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private final JButton startButton, stopButton;
    private JScrollPane scrollPane = new JScrollPane();
    private JList listBox = null;
    private DefaultListModel listModel = new DefaultListModel();
    private final JProgressBar progressBar;
    private mySwingWorker swingWorker;
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
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JFileChooser saveFile,saveReport;
	private JButton btnGenerateReport;
	
	public static Properties CONFIG;
    public static Properties OR;
    public static String string,text;
    public static String radioButton;
    public static String screenshot_everystep;
    public static final String Y= "Y";
    public static final String N= "N";
    public static int curentTest,totalTest;

    public SwingWorkerExample() {
        super("OBAutoDev");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(754, 537));
        getContentPane().setLayout(new GridLayout(2, 2));
        
        
        
        browse1 = makeButton("Browse");
        browse2 = makeButton("Browse");
        browse3 = makeButton("Browse");
        btnRun = makeButton("Run");
        startButton = makeButton("START");
        stopButton = makeButton("Stop");
        
        stopButton.setEnabled(false);
        progressBar = makeProgressBar(0, 99);


        //Display the window.
      //  pack();
        setVisible(true);
        setResizable(true);
        						                  
    	          		/*				          textArea = new JTextArea(16,58);
    	          						        textArea.setAlignmentX(Component.RIGHT_ALIGNMENT);
    	          						      textArea.setBounds(22, 227, 562, 180);
    	          						    textArea.setEditable(false);
    	          						    panel_1.add(textArea); 
    	          						          
    	          						            textArea.setColumns(20);
    	          						            textArea.setRows(5);*/
        
        
        
        
        
        
        
        
        
        
        
    }
//Class SwingWorker<T,V> T - the result type returned by this SwingWorker's doInBackground
//and get methods V - the type used for carrying out intermediate results by this SwingWorker's 
//publish and process methods

    private class mySwingWorker extends javax.swing.SwingWorker<ArrayList<Integer>, Integer> {
//The first template argument, in this case, ArrayList<Integer>, is what s returned by doInBackground(), 
//and by get(). The second template argument, in this case, Integer, is what is published with the 
//publish method. It is also the data type which is stored by the java.util.List that is the parameter
//for the process method, which recieves the information published by the publish method.

        @Override
        protected ArrayList<Integer> doInBackground() {
//Returns items of the type given as the first template argument to the SwingWorker class.
            if (javax.swing.SwingUtilities.isEventDispatchThread()) {
                System.out.println("javax.swing.SwingUtilities.isEventDispatchThread() returned true.");
            }
            Integer tmpValue = new Integer(1);
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) { //find every 100th prime, just to make it slower
                    tmpValue = FindNextPrime(tmpValue.intValue());
//isCancelled() returns true if the cancel() method is invoked on this class. That is the proper way
//to stop this thread. See the actionPerformed method.
                    if (isCancelled()) {
                        System.out.println("SwingWorker - isCancelled");
                        return list;
                    }
                }
//Successive calls to publish are coalesced into a java.util.List, which is what is received by process, 
//which in this case, isused to update the JProgressBar. Thus, the values passed to publish range from 
//1 to 100.
                publish(new Integer(i));
                list.add(tmpValue);
            }
            return list;
        }//Note, always use java.util.List here, or it will use the wrong list.

        @Override
        protected void process(java.util.List<Integer> progressList) {
//This method is processing a java.util.List of items given as successive arguments to the publish method.
//Note that these calls are coalesced into a java.util.List. This list holds items of the type given as the
//second template parameter type to SwingWorker. Note that the get method below has nothing to do with the 
//SwingWorker get method; it is the List's get method. This would be a good place to update a progress bar.
            if (!javax.swing.SwingUtilities.isEventDispatchThread()) {
                System.out.println("javax.swing.SwingUtilities.isEventDispatchThread() + returned false.");
            }
            Integer percentComplete = progressList.get(progressList.size() - 1);
            progressBar.setValue(percentComplete.intValue());
        }

        @Override
        protected void done() {
            System.out.println("doInBackground is complete");
            if (!javax.swing.SwingUtilities.isEventDispatchThread()) {
                System.out.println("javax.swing.SwingUtilities.isEventDispatchThread() + returned false.");
            }
            try {
//Here, the SwingWorker's get method returns an item of the same type as specified as the first type parameter
//given to the SwingWorker class.
                ArrayList<Integer> results = get();
                for (Integer i : results) {
                    listModel.addElement(i.toString());
                }
            } catch (Exception e) {
                System.out.println("Caught an exception: " + e);
            }
            startButton();
        }

        boolean IsPrime(int num) { //Checks whether a number is prime
            int i;
            for (i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

        protected Integer FindNextPrime(int num) { //Returns next prime number from passed arg.       
            do {
                if (num % 2 == 0) {
                    num++;
                } else {
                    num += 2;
                }
            } while (!IsPrime(num));
            return new Integer(num);
        }
    }

    private JButton makeButton(String caption) {
        JButton b = new JButton(caption);
        b.setActionCommand(caption);
        b.addActionListener(this);
        
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
        			btnRun.setBounds(100, 235, 147, 39);
        			panel.add(btnRun);
        			btnRun.setBackground(Color.GREEN);
        			JProgressBar progressBar1 = new JProgressBar();
        			progressBar1.setBounds(10, 35, 142, 39);
        			panel.add(progressBar1);
        			progressBar1.setMinimum(min);
        			progressBar1.setMaximum(max);
        			progressBar1.setStringPainted(true);
        			progressBar1.setBorderPainted(true);
        			return progressBar1;
        			
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
        getContentPane().add(b);
        return b;
    }
    
    private JRadioButton makeRadioButton(String caption) {
    	JRadioButton b = new JRadioButton(caption);
        b.setActionCommand(Y);
        b.addActionListener(this);
        getContentPane().add(b);
        return b;
    }
   
    private JTextField makeTextField(String caption) {
    	JTextField b = new JTextField(caption);
        getContentPane().add(b);
        return b;
    }      
    
    
    private JTextPane makeTextPane(String caption) {
    	JTextPane b = new JTextPane();
    	b.setBounds(1, 1, 822, 532);
        b.setAlignmentX(Component.RIGHT_ALIGNMENT);
        b.setEditable(false);
        getContentPane().add(b);
        return b;
    } 
    
    
    private JPanel makePanel(Component caption) {
    		  JPanel b = new JPanel() {
	          public Dimension getPreferredSize() {
	          Dimension size = super.getPreferredSize();
              size.width += extraWindowWidth;
              return size;
	          	}
	          };
	          b.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		      b.setLayout(null);      
	          b.add(caption);      
        return b;
    }
    
    
    private JTabbedPane makeTabbedPane(String caption,Component panel) {
    	JTabbedPane b = new JTabbedPane();
    	b.setBounds(0, 0, 846, 602);
    	tabbedPane.addTab(caption, null, panel, null);
    	getContentPane().add(b);
        return b;
    } 
    
    private JProgressBar makeProgressBar(int min, int max) {
    }

    private void startButton() {
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        System.out.println("SwingWorker - Done");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Start" == null ? e.getActionCommand() == null : "Start".equals(e.getActionCommand())) {
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
// Note that it creates a new instance of the SwingWorker-derived class. Never reuse an old one.
            (swingWorker = new mySwingWorker()).execute(); // new instance
        } else if ("Stop" == null ? e.getActionCommand() == null : "Stop".equals(e.getActionCommand())) {
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            swingWorker.cancel(true); // causes isCancelled to return true in doInBackground
            swingWorker = null;
        }
    }

    public static void main(String[] args) {
// Notice that it kicks it off on the event-dispatching thread, not the main thread.
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                SwingWorkerExample swingWorkerExample = new SwingWorkerExample();
            }
        });
    }
}
package com.totsy.UI;

import java.awt.BorderLayout;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.totsy.logs.TextAreaOutputStream;

public class ApplicationUI { 
	
	
	public void porneste() throws InterruptedException  {
    JFrame frame = new JFrame();
    frame.add( new JLabel(" Outout" ), BorderLayout.NORTH );

    JTextArea ta = new JTextArea();
    TextAreaOutputStream taos = new TextAreaOutputStream( ta, 60 );
    PrintStream ps = new PrintStream( taos );
    System.setOut( ps );
    System.setErr( ps );


    frame.add( new JScrollPane( ta )  );

    frame.pack();
    frame.setVisible( true );
    frame.setSize(800,600);
    }

	
}

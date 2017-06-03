import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Page{ //superclass for all the pages
	public JButton backButton;
	public JPanel panel;
	public JLabel header;
	public Timer timer;
	public JLabel timeDisplay;

	
	public Page(){
		panel = new JPanel(new GridLayout(4, 4));	
		backButton = new JButton("Back");
		backButton.setActionCommand("back");
		backButton.addActionListener(new ButtonClickListener());
		backButton.setPreferredSize(new Dimension(75, 30));
		timeDisplay = new JLabel();
		panel.add(header);
		panel.add(backButton);
		//panel.add(timeDisplay);
	}

	
}
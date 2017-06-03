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

	
	public Page(){
		panel = new JPanel();	
		backButton = new JButton("Back");
		backButton.setActionCommand("back");
		backButton.addActionListener(new ButtonClickListener());
	}

	public void display(){

	}

	public void remove(){ //called when back button is pressed

	}

}
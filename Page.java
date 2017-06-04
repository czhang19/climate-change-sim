import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

public class Page{ //superclass for all the pages
	public JButton backButton;
	public JPanel panel;
	public JLabel header;
	public Timer timer;
    public Timer qtimer;
	public JLabel timeDisplay;
    public ArrayList<TriviaQuestion> bank;
	
	public Page(){
		panel = new JPanel(new GridLayout(4, 4));	
		backButton = new JButton("Back");
		backButton.setActionCommand("back");
		backButton.setPreferredSize(new Dimension(75, 30));
		timeDisplay = new JLabel();
        String dt = new SimpleDateFormat("EEE, d MMM yyyy").format(new Date()); // starts date as today
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);  // number of days to add
        dt = sdf.format(cal.getTime());
        timeDisplay.setText(sdf.format(cal.getTime()));
       	timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cal.add(Calendar.DATE, 1);
                timeDisplay.setText(sdf.format(cal.getTime()) /*String.format("%04d:%02d:%02d.%03d", hours, minutes, seconds, millis)*/);
                
            }
        });
        qtimer = new Timer(10000, new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                TriviaQuestion test = bank.get(i);
                test.displayQuestion();
                i++;
            }
        });
		panel.add(backButton);
		panel.add(timeDisplay);
	}

	public void setHeader(int number){
		header = new JLabel("Level " + number, JLabel.CENTER);
		panel.add(header);
	}
	
	public class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
        	String command = e.getActionCommand();
        	
		}
	}	
}
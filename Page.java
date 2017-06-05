import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public JButton co2;

	
	public Page(){
		panel = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D)g;
                g2.setColor(new Color(25, 150, 200));
                g2.fillRect(0, 500, 1000, 750);
            }
            
        };
        co2 = new JButton("CO2");
        co2.setActionCommand("co2");
        co2.addActionListener(new ButtonClickListener());
        waterLevel();
        panel.setLayout(new GridLayout(4,4));
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
        
        // displays the "date", currently 10 days in 1 second
       	timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cal.add(Calendar.DATE, 1);
                timeDisplay.setText(sdf.format(cal.getTime()) /*String.format("%04d:%02d:%02d.%03d", hours, minutes, seconds, millis)*/);
                
            }
        });
        
        // displays the trivia questions every 60 seconds
        //Collections.shuffle(bank);
        qtimer = new Timer(5000, new ActionListener() {
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
        ImageIcon image = new ImageIcon("trumppppp.jpg");
        JLabel label = new JLabel("", image, JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setVerticalAlignment(JLabel.TOP);
        panel.add(label);
	}

	public void setHeader(int number){
		header = new JLabel("Level " + number, JLabel.CENTER);
		panel.add(header);
	}

    public void waterLevel(){

    }

	
	public class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
        	String command = e.getActionCommand();
            if (command.equals("co2")){
                waterLevel();
            }	
		}
	}	


}
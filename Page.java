import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

public abstract class Page{ //superclass for all the pages
	public JButton backButton;
    public JButton playButton;
    public JFrame infoFrame;
	public JPanel panel;
    public JPanel infoPanel;
	public JLabel header;
	public Timer timer;
    public Timer qtimer;
	public JLabel timeDisplay;
    public JLabel leaderInfo;
    public ArrayList<TriviaQuestion> bank;
    public int displayed = -1;
    public ArrayList<Boolean> answers;
    public JButton co2;
    public int waterLevel;
    public int waterInterval;

	
	public Page(){
        waterLevel = 500;
        waterInterval = 25;
        playButton = new JButton("Play!");
		playButton.setActionCommand("play");
		playButton.addActionListener(new ButtonClickListener());	
		panel = new JPanel(new GridLayout(4, 4)){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D)g;
                g2.setColor(new Color(25, 150, 200));
                g2.fillRect(0, waterLevel, 1000, 750);
            }

        };
        co2 = new JButton("CO2");
        co2.setActionCommand("co2");
        co2.addActionListener(new ButtonClickListener());
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
        qtimer = new Timer(10000, new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                TriviaQuestion test = bank.get(i);
                test.displayQuestion();
                displayed = i;
                i++;
            }
        });
		panel.add(backButton);
        panel.add(co2);
		panel.add(timeDisplay);
	}

    public void closeTrivia(){
        if (displayed == -1){
            return;
        }
        for (int i = 0; i <= displayed; i++){
            bank.get(i).close();
        }
    }
    
    public abstract void info();
    
	public void setHeader(String s){
		header = new JLabel("Level " + s, JLabel.CENTER);
		panel.add(header);
	}

    public void waterLevelRising(){
        waterLevel -= waterInterval;
        panel.repaint();
    }

	public void resetWater(){
        waterLevel = 500;
    }

	public class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
        	String command = e.getActionCommand();
            if (command.equals("co2")){
                waterLevelRising();
            }    
            else if (command.equals("play")){
            	infoFrame.dispatchEvent(new WindowEvent(infoFrame, WindowEvent.WINDOW_CLOSING));
                timer.start();
                qtimer.start();
            } 
		}
	}	


}
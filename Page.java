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
    public JLabel win;
	public Timer timer;
    public Timer qtimer;
	public JLabel timeDisplay;
    public JLabel leaderInfo;
    public GridBagConstraints c;
    public ArrayList<TriviaQuestion> bank;
    public int displayed = -1;
    public ArrayList<Boolean> answers;
    public JButton co2;
    public JButton ch4;
    public int waterLevel;
    public int waterInterval;

	
	public Page(){
        // information page for each leader
        infoFrame = new JFrame();
		infoFrame.setSize(1000, 750);
        infoPanel = new JPanel(new FlowLayout());
        leaderInfo = new JLabel();
        playButton = new JButton("Play!");
		playButton.setActionCommand("play");
		playButton.addActionListener(new ButtonClickListener());	
        infoPanel.add(leaderInfo);
        infoPanel.add(playButton);
        infoFrame.add(infoPanel);
		infoPanel.add(leaderInfo);
		infoPanel.add(playButton);
        
        // game page
        waterLevel = 500;
        waterInterval = 25;
		panel = new JPanel(new FlowLayout()){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D)g;
                g2.setColor(new Color(25, 150, 200));
                g2.fillRect(0, waterLevel, 1000, 750 - waterLevel);
            }

        };
        //panel.setLayout(new GridBagLayout());
        //c = new GridBagConstraints();
        
        // back button to get to home page
		backButton = new JButton("Back");
		backButton.setActionCommand("back");
		backButton.setPreferredSize(new Dimension(75, 30));
        /*
        c.weightx = 1.0;
        c.gridwidth = GridBagConstraints.RELATIVE;
        //c.gridx = 0;
        //c.gridy = 0;
        panel.add(backButton, c);
        */
        
        // co2 button
        co2 = new JButton("CO2");
        co2.setActionCommand("co2");
        co2.addActionListener(new ButtonClickListener());

        ch4 = new JButton("CH4");
        ch4.setActionCommand("ch4");
        ch4.addActionListener(new ButtonClickListener());
        //c.gridwidth = GridBagConstraints.REMAINDER;
        //c.weightx = 0.9;
        //c.gridx = 100;
        //c.gridy = 0;
        //panel.add(co2, c);
        
        // stopwatch with current "date"
		timeDisplay = new JLabel();
        String dt = new SimpleDateFormat("EEE, d MMM yyyy").format(new Date()); // starts date as today
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);  // number of days to add
        dt = sdf.format(cal.getTime());
        timeDisplay.setText(sdf.format(cal.getTime()));
        /*
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(timeDisplay, c);
        */

        // displays the "date", currently 10 days in 1 second
       	timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cal.add(Calendar.DATE, 1);
                timeDisplay.setText(sdf.format(cal.getTime()) /*String.format("%04d:%02d:%02d.%03d", hours, minutes, seconds, millis)*/);
                
            }
        });
        
        // displays the trivia questions every 60 seconds
        qtimer = new Timer(5000, new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                TriviaQuestion test = bank.get(i);
                test.displayQuestion();
                displayed = i;
                i++;
            }
        });
        
        // Congratulations text box
        win = new JLabel();
        
		panel.add(backButton);
        panel.add(co2);
        panel.add(ch4);
		panel.add(timeDisplay);
	}

    public void addImage(String filename) {
        ImageIcon icon = new ImageIcon(filename);
        Image scaleImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon imageicon = new ImageIcon(scaleImage);
        JLabel label = new JLabel(imageicon);
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setVerticalAlignment(JLabel.TOP);
        /*
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 40;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 2;
        //panel.add(label, c); */
        panel.add(label);
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
    
    public abstract void win();
    
	public void setHeader(String s){
		header = new JLabel("Level " + s, JLabel.CENTER);
		panel.add(header);
	}

    public void waterLevelRising(){
        waterLevel -= waterInterval;
        if (waterLevel % 150 == 0 && waterLevel > 50) {
            ch4.setEnabled(true);
        }
        if (waterLevel < 50) {
            co2.setEnabled(false);
            win();
            timer.stop();
            qtimer.stop();
        }
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
            } else if (command.equals("ch4")){
                waterLevel -= 75;
                ch4.setEnabled(false);
                panel.repaint();
            } 
		}
	}	


}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public abstract class Page{ //superclass for all the pages
    public JButton backButton;
    public JButton playButton;
    public JFrame infoFrame;
	public JPanel panel;
    public JComponent solarPanel;
    public JPanel infoPanel;
    public JLabel header;
    public JLabel win;
    public Timer timer;
    public Timer qtimer;
    public Timer atimer;
    public JLabel timeDisplay;
    public JLabel leaderInfo;
    public GridBagConstraints c;
    public ArrayList<TriviaQuestion> bank;
    public int displayed = 0;
    public int displayedAction = 0;
    public ArrayList<Boolean> answers;
    public ArrayList<LeaderAction> actions;
    public int qCounter = 0;
    public JButton co2;
    public JButton ch4;
    public int waterLevel;
    public int waterInterval;
    public JLabel triviaCounter;
    public int triviaGoal = 2;
    public int[] xPointsOne = {110, 130, 160, 130}; 
    public int[] yPointsOne = {90, 10, 5, 110};
    public int[] xPointsTwo = {15, 100, 120, 5};
    public int[] yPointsTwo = {110, 100, 120, 135};
    public Timer panelTimer;
    public Calendar cal;
    public SimpleDateFormat sdf;
    
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

        // game page
        waterLevel = 500;
        waterInterval = 20;
        panel = new JPanel(new FlowLayout()){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D)g;
                g2.setColor(new Color(25, 150, 200));
                g2.fillRect(0, waterLevel, 1000, 750-waterLevel);
                g2.setColor(new Color(250, 215, 66));
                g2.fillOval(15, 10, 70, 70);
            }

        };
        
        // back button to get to home page
        backButton = new JButton("Back");
        backButton.setActionCommand("back");
        backButton.setPreferredSize(new Dimension(75, 30));
        
        // co2 button
        co2 = new JButton("CO2");
        co2.setActionCommand("co2");
        co2.addActionListener(new ButtonClickListener());
        
        // ch4 button
        ch4 = new JButton("CH4");
        ch4.setActionCommand("ch4");
        ch4.addActionListener(new ButtonClickListener());
        
        // stopwatch with current "date"
        timeDisplay = new JLabel();
        sdf = new SimpleDateFormat("EEE, d MMM yyyy");
        cal = Calendar.getInstance();
        timeDisplay.setText(sdf.format(cal.getTime()));
        
        // displays the "date", currently 10 days in 1 second
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cal.add(Calendar.DATE, 1);
                timeDisplay.setText(sdf.format(cal.getTime()) /*String.format("%04d:%02d:%02d.%03d", hours, minutes, seconds, millis)*/);
                
            }
        });
        
        // displays actions at fixed intervals
        atimer = new Timer(5000, new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                actions.get(i).display();
                displayedAction = i;
                waterLevelAction(actions.get(i));
                if (i == actions.size() - 1) {
                    i = 0;
                } else {
                    i++;
                }
            }
        });

        // displays the trivia questions every 30 seconds
        answers = new ArrayList<Boolean>();
        qtimer = new Timer(12000, new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                bank.get(i).displayQuestion();
                displayed = i+1;
                answers.add(Boolean.FALSE);
                bank.get(i).answered.addActionListener(new ButtonClickListener());
                if (i == bank.size() - 1) {
                    i = 0;
                } else {
                    i++;
                }
            }
        });
        
        // Congratulations text box
        win = new JLabel();
        
        actions = new ArrayList<LeaderAction>();
        
        panel.add(backButton);
        panel.add(co2);
        panel.add(ch4);
        panel.add(timeDisplay);

    }

    public void buttonSound(String track) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(track).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception a) {
            a.printStackTrace();
        }
    }

    public void addImage(String filename) {
        ImageIcon icon = new ImageIcon(filename);
        Image scaleImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon imageicon = new ImageIcon(scaleImage);
        JLabel label = new JLabel(imageicon);
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setVerticalAlignment(JLabel.TOP);
        panel.add(label);
    }

    public void closeTrivia(){
        for (int i = 0; i < displayed; i++){
            bank.get(i).close();
        }
    }
    
    public void closeLevelAction() {
        actions.get(displayedAction).close();
    }

    public void updateCounter(){
        int counter = 0;
        for (int i = 0; i < answers.size(); i++){
            if (answers.get(i)){
                counter++;
            }
        }
        qCounter = counter;
        System.out.println(qCounter);
        checkCounter();
    }

    public void checkCounter(){
        if (qCounter == triviaGoal){
            turnPanels();
        }
    }

    public void turnPanels(){
        // double[][] translateFirstArrayOne = {{1, 0, 135}, {0, 1, 50}, {0, 0, 1}};
        // double[][] rotateArrayOne = {{Math.cos(0.1), -Math.sin(0.1), 0}, {Math.sin(0.1), Math.cos(0.1), 0}, {0, 0, 1}};
        // double[][] translateSecondArrayOne = {{1, 0, -135}, {0, 1, -50}, {0, 0, 1}};
        // double[][] pointsOneArray = {xPointsOne, yPointsTwo, {1, 1, 1}};
        // Matrix rotateOne = new Matrix(rotateArrayOne);
        // Matrix translateFirstOne = new Matrix(translateFirstArrayOne);
        // Matrix translateSecondOne = new Matrix(translateSecondArrayOne);
        // Matrix pointsOne = new Matrix(pointsOneArray);
        // panelTimer = new Timer(500, new ActionListener(){
        //     int i = 0;
        //     @Override
        //     public void actionPerformed(ActionEvent e){
                
        //         xPointsOne = pointsOne.returnRow(1);
        //         yPointsOne = pointsOne.returnRow(2);
        //         panel.repaint();
        //         i++;
        //         if (i == 5){
        //             panelTimer.stop();
        //         }

        //     }
        // });
        // panelTimer.start();
        // win();
        // //solarPanel.repaint();
    }

    public void resetCounter(){
        qCounter = 0;
        answers.clear();
        displayed = 0;
    }
    
    public abstract void info();
    
    public void closeInfo(){
        infoFrame.dispatchEvent(new WindowEvent(infoFrame, WindowEvent.WINDOW_CLOSING));
    }

    public abstract void win();
    
    public abstract void lose();
    
	public void setHeader(String s){
		header = new JLabel("Level " + s, JLabel.CENTER);
		panel.add(header);
	}

    public void waterLevelRising(){
        waterLevel -= waterInterval;
        if (waterLevel % 150 == 0 && waterLevel > 50) {
            ch4.setEnabled(true);
        } 
        
        if (waterLevel <= 50) {
            co2.setEnabled(false);
            win();
            closeTrivia();
            closeLevelAction();
            timer.stop();
            qtimer.stop();
            atimer.stop();
        }
        panel.repaint();
    }
    
    public void waterLevelAction(LeaderAction act) {
        waterLevel += act.x;

        if (waterLevel <= 50 || waterLevel >= 750) {
            co2.setEnabled(false);
            if (waterLevel <= 50) {
                win();
            } else {
                lose();
            }
            closeTrivia();
            closeLevelAction();
            timer.stop();
            qtimer.stop();
            atimer.stop();
        }
        panel.repaint();
    }

    public void stopTimer() {
        timer.stop();
        atimer.stop();
        qtimer.stop();
    }

    public void resetWater(){
        waterLevel = 500;
    }
    
    public class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if (command.equals("co2")){
                waterLevelRising();
                buttonSound("Honk.wav");
            }    
            else if (command.equals("play")){
                infoFrame.dispatchEvent(new WindowEvent(infoFrame, WindowEvent.WINDOW_CLOSING));
                cal = Calendar.getInstance();
                timeDisplay.setText(sdf.format(cal.getTime()));
                timer.restart();
                qtimer.restart();
                atimer.restart();
            } 
            else if (command.equals("ch4")){
                waterLevel -= (3*waterInterval);
                ch4.setEnabled(false);
                panel.repaint();
            } 
            else if (command.equals("answered")){
                for (int i = 0; i <= answers.size(); i++){
                    if (bank.get(i).ansCorrectly){
                        answers.set(i, Boolean.TRUE);
                    }
                }
                updateCounter();
            }

		}
	}
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Page5 extends Page {
    public Page5() {
        super();
        super.addImage("bruckerrrrr.jpg");
        waterInterval = 1;
        setHeader("5: King Bruck");
        panel.add(win);
        win.setText("<html><body style='width: 750px'>");
        level5Page();
        triviaGoal = 10;
        setQuestionLabel();
    }
    
    public void info() {
        infoFrame.setTitle("King Bruck");
        leaderInfo.setText("<html><body style='width: 750px'>King Bruck is currently located in Room BPi at our beloved Mission San Jose High School in Fremont, California. King Bruck is a champion of climate science. He will be nearly impossible to drown. Press play when you are ready to begin!");
        leaderInfo.setFont(new Font("Zapfino", Font.PLAIN, 24));
		infoFrame.setVisible(true);
        infoFrame.setLocationRelativeTo(null);
    }
    
    public void lose() {
        win.setText("<html><body style='width: 750px'>~~~~~~~~~King Bruck always wins.~~~~~~~~");
        win.setFont(new Font("Serif", Font.PLAIN, 50));
        panel.repaint();
    }
    
    public void win() {
        win.setText("<html><body style='width: 750px'>Congratulations! You have completed the impossible.");
        panel.repaint();
    }
    
    public void level5Page() {
        actions.add(new LeaderAction("Dr. Brucker plants 500 trees!", 50));
        actions.add(new LeaderAction("Dr. Brucker convinces all of California to drive electric cars!", 100));
        actions.add(new LeaderAction("Dr. Brucker writes a new PEEB!", 20));
        actions.add(new LeaderAction("Dr. Brucker emits SO2 into the atmosphere!", -10));
        actions.add(new LeaderAction("Dr. Brucker shuts down all coal factories in the US!", 100));
        actions.add(new LeaderAction("Dr. Brucker sends solar panels into orbit.", 40));
        actions.add(new LeaderAction("Dr. Brucker bans all gas-guzzling vehicles for a week in the US!", 100));
    }
}
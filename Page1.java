import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Page1 extends Page {
    public Page1() {
        super();
        super.addImage("trumppppp.jpg");
        setHeader("1: President Donald Trump");
        panel.add(win);
        win.setText("<html><body style='width: 750px'>");
        waterInterval = 20;
        level1Page();
    }
    
    public void info() {
        infoFrame.setTitle("President Donald Trump");
        // make this frame immovable
        leaderInfo.setText("<html><body style='width: 750px'>Donald Trump is at Palm Beach, Florida visiting his Mar-a-Lago resort. The concept of global warming was created by and for the Chinese in order to make U.S. manufacturing non-competitive. Needless to say, it will not be difficult to drown our beloved President. Press play when you are ready to begin!");
        leaderInfo.setFont(new Font("Serif", Font.PLAIN, 24));
		infoFrame.setVisible(true);
        infoFrame.setLocationRelativeTo(null);
    }
    
    public void lose() {
        win.setText("<html><body style='width: 750px'>How did you lose to Trump?");
        panel.repaint();
    }
    
    public void win() {
        win.setText("<html><body style='width: 750px'>Congratulations! You have succeeded in eliminating President Donald Trump at the Mar-a-Lago resort! Click back to return to the home page and attempt Level 2.");
        panel.repaint();
    }
    
    public void level1Page() {
        actions.add(new LeaderAction("President Trump has halted Obama's Clean Power Plan (CPP), which restricts emissions from coal-fired power plants. 50 coal factories are re-opened", -50));
        actions.add(new LeaderAction("Trump pulls out of the Paris climate accord!", -50));
        actions.add(new LeaderAction("Trump nominates Scott Pruitt to head the EPA!", -50));
    }
}
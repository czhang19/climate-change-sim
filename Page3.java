import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Page3 extends Page {
    public Page3() {
        super();
        super.addImage("trudeauuuuu.jpg");
        setHeader("3: Prime Minister Justin Trudeau");
        panel.add(win);
        win.setText("<html><body style='width: 750px'>");
        waterInterval = 5;
        level3Page();
    }
    
    public void info() {
        infoFrame.setTitle("Prime Minister Justin Trudeau");
        // make this frame immovable
        leaderInfo.setText("<html><body style='width: 750px'>Prime Minister Justin Trudeau is in Ottawa, Canada. While Prime Minister Trudeau has made some controversial decisions regarding climate change (supporting the revival of the Keystone Pipeline), he is far from skeptic and is strong in his stance to reduce global carbon emissions. He will be somewhat difficult to drown. Press play when you are ready to begin!");
        leaderInfo.setFont(new Font("Serif", Font.PLAIN, 24));
		infoFrame.setVisible(true);
        infoFrame.setLocationRelativeTo(null);
    }
    
    public void lose() {
        win.setText("<html><body style='width: 750px'>I guess Trudeau wins.");
        panel.repaint();
    }
    
    public void win() {
        win.setText("<html><body style='width: 750px'>Congratulations! You have succeeded in eliminating Prime Minister Justin Trudeau in Ottawa, Canada! Click back to return to the home page and attempt Level 4.");
        panel.repaint();
    }
    
    public void level3Page() {
        actions.add(new LeaderAction("Justin Trudeau reaffirms his commitment to the Paris Accord!", 40));
        actions.add(new LeaderAction("Justin Trudeau speaks in support of the Keystone Pipeline.", -20));
        actions.add(new LeaderAction("Justin Trudeau endowed the Low Carbon Economy Trust with $2 billion.", 40));
        actions.add(new LeaderAction("Justin Trudeau fulfilled the G20 commitment and phased out subsidies for the fossil fuel industry over the medium-term.", 40));
        actions.add(new LeaderAction("Justin Trudeau supports tar sands drilling.", -40));
        actions.add(new LeaderAction("Canada pledges in Paris to cut greenhouse gas emissions 30 percent from 2005 levels by 2030.", 50));
    }
}
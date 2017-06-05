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
        setHeader("3: Justin Trudeau");
        waterInterval = 10;
        setHeader("3: Prime Minister Justin Trudeau");
        panel.add(win);
        win.setText("<html><body style='width: 750px'>");
    }
    
    public void info() {
        infoFrame.setTitle("Prime Minister Justin Trudeau");
        // make this frame immovable
        leaderInfo.setText("<html><body style='width: 750px'>Prime Minister Justin Trudeau is in Ottawa, Canada. While Prime Minister Trudeau has made some controversial decisions regarding climate change (supporting the revival of the Keystone Pipeline), he is far from skeptic and is strong in his stance to reduce global carbon emissions. He will be somewhat difficult to drown. Press play when you are ready to begin!");
        leaderInfo.setFont(new Font("Serif", Font.PLAIN, 24));
		infoFrame.setVisible(true);
        infoFrame.setLocationRelativeTo(null);
    }
    
    public void win() {
        win.setText("<html><body style='width: 750px'>Congratulations! You have succeeded in drowning Prime Minister Justin Trudeau in Ottawa, Canada by increasing CO2 levels sufficiently enough to rise sea levels! Click back to return to the home page and attempt Level 4.");
        panel.repaint();
    }
    
    public void level3Page() {
    
    }
}
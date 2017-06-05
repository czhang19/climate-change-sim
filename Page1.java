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
    }
    
    public void info() {
        infoFrame.setTitle("President Donald Trump");
        // make this frame immovable
        leaderInfo.setText("<html><body style='width: 750px'>Donald Trump is at Palm Beach, Florida visiting his Mar-a-Lago resort. The concept of global warming was created by and for the Chinese in order to make U.S. manufacturing non-competitive. Needless to say, it will not be difficult to drown our beloved President. Press play when you are ready to begin!");
        leaderInfo.setFont(new Font("Serif", Font.PLAIN, 24));
		infoFrame.setVisible(true);
        infoFrame.setLocationRelativeTo(null);
    }
    
    public void win() {
        win.setText("<html><body style='width: 750px'>Congratulations! You have succeeded in drowning President Donald Trump by increasing CO2 levels sufficiently enough to rise sea levels and reach his Mar-a-Lago resort! Click back to return to the home page and attempt Level 2.");
        panel.repaint();
    }
    
    public void level1Page() {
        
    }
}
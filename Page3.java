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
        setHeader("3: Justin Trudeau");
    }
    
    public void info() {
        infoFrame = new JFrame("Justin Trudeau");
		infoFrame.setSize(1000, 750);
        infoPanel = new JPanel(new FlowLayout());
        // make this frame immovable
        leaderInfo = new JLabel("blah blah blah stuff on Trudeau");
        infoPanel.add(leaderInfo);
        infoPanel.add(playButton);
        infoFrame.add(infoPanel);
		infoPanel.add(leaderInfo);
		infoPanel.add(playButton);
		infoFrame.setVisible(true);
        infoFrame.setLocationRelativeTo(null);
    }
    
    public void level3Page() {
    
    }
}
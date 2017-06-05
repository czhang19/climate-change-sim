import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Page4 extends Page {
    public Page4() {
        super();
        setHeader("4: Angela Merkel");
    }
    
    public void info() {
        infoFrame = new JFrame("Angela Merkel");
		infoFrame.setSize(1000, 750);
        infoPanel = new JPanel(new FlowLayout());
        // make this frame immovable
        leaderInfo = new JLabel("blah blah blah stuff on Merkel");
        infoPanel.add(leaderInfo);
        infoPanel.add(playButton);
        infoFrame.add(infoPanel);
		infoPanel.add(leaderInfo);
		infoPanel.add(playButton);
		infoFrame.setVisible(true);
        infoFrame.setLocationRelativeTo(null);
    }
    
    public void level4Page() {
    
    }
}
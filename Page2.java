import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Page2 extends Page {
    public Page2() {
        super();
        setHeader("2: Vladimir Putin");
    }
    
    public void info() {
        infoFrame = new JFrame("Vladimir Putin");
		infoFrame.setSize(1000, 750);
        infoPanel = new JPanel(new FlowLayout());
        // make this frame immovable
        leaderInfo = new JLabel("blah blah blah stuff on Putin");
        infoPanel.add(leaderInfo);
        infoPanel.add(playButton);
        infoFrame.add(infoPanel);
		infoPanel.add(leaderInfo);
		infoPanel.add(playButton);
		infoFrame.setVisible(true);
        infoFrame.setLocationRelativeTo(null);
    }
    
    public void level2Page() {
        
    }
}
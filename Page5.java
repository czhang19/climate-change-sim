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
        setHeader("5: King Bruck");
        waterInterval = 1;
        panel.add(win);
        win.setText("<html><body style='width: 750px'>");
    }
    
    public void info() {
        infoFrame.setTitle("King Bruck");
        // make this frame immovable
        leaderInfo.setText("<html><body style='width: 750px'>King Bruck is currently located in Room BPi at our beloved Mission San Jose High School in Fremont, California. King Bruck is a champion of climate science. He will be nearly impossible to drown. Press play when you are ready to begin!");
        leaderInfo.setFont(new Font("Zapfino", Font.PLAIN, 24));
		infoFrame.setVisible(true);
        infoFrame.setLocationRelativeTo(null);
    }
    
    public void win() {
        win.setText("<html><body style='width: 750px'>Congratulations! You have completed the impossible.");
        panel.repaint();
    }
    
    public void level5Page() {
    
    }
}
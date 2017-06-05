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
        setHeader("1: President Donald Trump");
    }
    
    public void info() {
        infoFrame.setTitle("President Donald Trump");
        // make this frame immovable
        leaderInfo.setText("<html><body style='width: 750px'>Donald Trump is at Palm Beach, Florida visiting his Mar-a-Lago resort. The concept of global warming was created by and for the Chinese in order to make U.S. manufacturing non-competitive. Needless to say, it will not be difficult to drown our beloved President. Press play when you are ready to begin!");
        leaderInfo.setFont(new Font("Serif", Font.PLAIN, 24));
		infoFrame.setVisible(true);
        infoFrame.setLocationRelativeTo(null);
    }
    
    public void level1Page() {
        
    }
}
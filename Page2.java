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
        super.addImage("putinnnnn.jpg");
        setHeader("2: President Vladimir Putin");
        waterInterval = 15;
    }
    
    public void info() {
        infoFrame.setTitle("President Vladimir Putin");
        // make this frame immovable
        leaderInfo.setText("<html><body style='width: 750px'>You can find President Putin in Moscow, Russia. While President Putin has made some surprising pledges to reduce Russia’s carbon emissions, he is a long-time climate change skeptic. He will not prove exceedingly difficult to drown. Press play when you are ready to begin!");
        leaderInfo.setFont(new Font("Serif", Font.PLAIN, 24));
		infoFrame.setVisible(true);
        infoFrame.setLocationRelativeTo(null);
    }
    
    public void level2Page() {
        
    }
}
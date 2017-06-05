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
        super.addImage("merkelllll.jpg");
        setHeader("4: Chancellor Angela Merkel");
    }
    
    public void info() {
        infoFrame.setTitle("Chancellor Angela Merkel");
        // make this frame immovable
        leaderInfo.setText("<html><body style='width: 750px'>Chancellor Angela Merkel is in Berlin, Germany. Chancellor Merkel is a long-time supporter of climate science. She will prove difficult to drown. Press play when you are ready to begin!");
        leaderInfo.setFont(new Font("Serif", Font.PLAIN, 24));
		infoFrame.setVisible(true);
        infoFrame.setLocationRelativeTo(null);
    }
    
    public void level4Page() {
    
    }
}
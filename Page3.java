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
    }
    
    public void info() {
        infoFrame.setTitle("Justin Trudeau");
        // make this frame immovable
        leaderInfo.setText("<html><body style='width: 750px'>Justin Trudeau is in Ottawa, Canada. While Justin Trudeau has made some controversial decisions regarding climate change (supporting the revival of the Keystone Pipeline), he is far from skeptic and is strong in his stance to reduce global carbon emissions. He will be somewhat difficult to drown. Press play when you are ready to begin!");
        leaderInfo.setFont(new Font("Serif", Font.PLAIN, 24));
		infoFrame.setVisible(true);
        infoFrame.setLocationRelativeTo(null);
    }
    
    public void level3Page() {
    
    }
}
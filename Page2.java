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
        panel.add(win);
        win.setText("<html><body style='width: 750px'>");
        waterInterval = 25;
        level2Page();
    }
    
    public void info() {
        infoFrame.setTitle("President Vladimir Putin");
        // make this frame immovable
        leaderInfo.setText("<html><body style='width: 750px'>You can find President Putin in Moscow, Russia. While President Putin has made some surprising pledges to reduce Russia’s carbon emissions, he is a long-time climate change skeptic. He will not prove exceedingly difficult to drown. Press play when you are ready to begin!");
        leaderInfo.setFont(new Font("Serif", Font.PLAIN, 24));
		infoFrame.setVisible(true);
        infoFrame.setLocationRelativeTo(null);
    }
    
    public void win() {
        win.setText("<html><body style='width: 750px'>Congratulations! You have succeeded in drowning President Vladimir Putin by increasing CO2 levels sufficiently enough to rise sea levels and reach his residence in Moscow, Russia! Click back to return to the home page and attempt Level 3.");
        panel.repaint();
    }
    
    public void level2Page() {
        actions.add(new LeaderAction("“Don’t worry, be happy” says Putin with regards to Trump’s climate policies.", -30));
        actions.add(new LeaderAction("Russia is the fourth largest greenhouse gas polluter.", -30));
        actions.add(new LeaderAction("Discovered in a survey, Russians had the lowest level of concern about global warming out of every country but Ukraine.", -20));
        actions.add(new LeaderAction("President Putin actively contributes to address the issue of global warming.", 20));
        actions.add(new LeaderAction("Russian President Vladimir Putin says climate change is unstoppable and not caused by human activity and urges countries to adapt to global warming.", -30));
    }
}
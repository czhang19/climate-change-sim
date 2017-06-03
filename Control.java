import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Control{ //to navigate between pages
	public JFrame mainFrame;

    public Control() {
        mainFrame = new JFrame("Flood");
        mainFrame.setSize(1000, 750);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Start start = new Start();
        Levels levels = new Levels(); //still need to create levels
        Page level1 = new Page1();
        Page level2 = new Page2();
       	Page level3 = new Page3();
       	Page level4 = new Page4();
       	Page level5 = new Page5();
       	Page level6 = new Page6();

    }

    public static void main(String[] args) {
    	Control game = new Control();
    }

    public void display(Page page){
        String dt = "Wednesday, 31 May 2017";  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);  // number of days to add
        dt = sdf.format(cal.getTime());
        timeDisplay.setText(sdf.format(cal.getTime()));
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cal.add(Calendar.DATE, 1);
                timeDisplay.setText(sdf.format(cal.getTime()) /*String.format("%04d:%02d:%02d.%03d", hours, minutes, seconds, millis)*/);
                
            }
        });
    }

    public void display(Start start){

    }

    public void display(Level level){

    }

    public void remove(Page page){
    	mainFrame.remove(page.panel)
    }
}
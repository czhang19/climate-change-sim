import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Start {
	public JPanel panel;
	public JButton startButton;
	public JLabel intro;

	public Start(){
        panel = new JPanel(new FlowLayout());
        intro = new JLabel("Flood", JLabel.CENTER);
        intro.setFont(new Font("Serif", Font.PLAIN, 48));
        startButton = new JButton("Start");
        startButton.setActionCommand("start"); //set action command
        startButton.setPreferredSize(new Dimension(75, 30));
        panel.add(intro);
        panel.add(startButton);
	}
}
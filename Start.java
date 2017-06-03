import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Start {
	public JButton startButton
	public Start(){
		startButton = new JButton("Start");
        startButton.setActionCommand("start");
        startButton.addActionListener(new ButtonClickListener());
        startButton.setPreferredSize(new Dimension(75, 30));
	}
}
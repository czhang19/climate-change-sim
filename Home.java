import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Home{
	public JPanel panel;
	public JButton level1Button;
	public JButton level2Button;
	public JButton level3Button;
	public JButton level4Button;
	public JButton level5Button;
	public JLabel label;

	public Home(){
		panel = new JPanel(new GridLayout(1,5));
		label = new JLabel("Choose a level: ", JLabel.CENTER);
		level1Button = new JButton("Level 1");
		level1Button.setActionCommand("level1");
		level2Button = new JButton("Level 2");
		level2Button.setActionCommand("level2");
		level3Button = new JButton("Level 3");
		level3Button.setActionCommand("level3");
		level4Button = new JButton("Level 4");
		level4Button.setActionCommand("level4");
		level5Button = new JButton("Level 5");
		level5Button.setActionCommand("level5");
		panel.add(label);
		panel.add(level1Button);
		panel.add(level2Button);
		panel.add(level3Button);
		panel.add(level4Button);
		panel.add(level5Button);
	}
}
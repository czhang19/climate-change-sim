import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Sim2 {
    private JFrame mainFrame;
    private JPanel start, levels, level1, level2, level3, level4, level5, level6, level7, level8, level9;
    JLabel timeDisplay;
    private Timer timer;
    private long lastTickTime, time;
    
    public static void main(String[] args) {
        Sim2 simulation = new Sim2();
    }

    public Sim2() {
        mainFrame = new JFrame("Flood");
        mainFrame.setSize(1000, 750);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startPage();
        
    }

    public void startPage(){
        start = new JPanel(new FlowLayout());
        JLabel intro = new JLabel("Flood", JLabel.CENTER);
        JButton startButton = new JButton("Start");
        startButton.setActionCommand("start"); //set action command
        startButton.addActionListener(new ButtonClickListener());
        startButton.setPreferredSize(new Dimension(75, 30));
        mainFrame.add(start);
        start.add(intro);
        start.add(startButton);
        mainFrame.setVisible(true);
    }

    public void levelsPage(){
        mainFrame.remove(start);
        levels = new JPanel(new GridLayout(4, 2));
        JLabel second = new JLabel("Choose a level: ", JLabel.CENTER);
        JButton level1 = new JButton("Level 1");
        level1.setActionCommand("level1");
        level1.addActionListener(new ButtonClickListener());
        JButton level2 = new JButton("Level 2");
        level2.setActionCommand("level2");
        level2.addActionListener(new ButtonClickListener());
        JButton level3 = new JButton("Level 3");
        level3.setActionCommand("level3");
        level3.addActionListener(new ButtonClickListener());
        JButton level4 = new JButton("Level 4");
        level4.setActionCommand("level4");
        level4.addActionListener(new ButtonClickListener());
        JButton level5 = new JButton("Level 5");
        level5.setActionCommand("level5");
        level5.addActionListener(new ButtonClickListener());
        JButton level6 = new JButton("Level 6");
        level6.setActionCommand("level6");
        level6.addActionListener(new ButtonClickListener());
        JButton level7 = new JButton("Level 7");
        level7.setActionCommand("level7");
        level7.addActionListener(new ButtonClickListener());
        JButton level8 = new JButton("Level 8");
        level8.setActionCommand("level8");
        level8.addActionListener(new ButtonClickListener());
        JButton level9 = new JButton("Level 9");
        level9.setActionCommand("level9");
        level9.addActionListener(new ButtonClickListener());
        mainFrame.add(levels);
        levels.add(second);
        levels.add(level1);
        levels.add(level2);
        levels.add(level3);
        levels.add(level4);
        levels.add(level5);
        levels.add(level6);
        levels.add(level7);
        levels.add(level8);
        levels.add(level9);
        mainFrame.setVisible(true);
    }

    public void level1Page() {
        mainFrame.remove(levels);
        level1 = new JPanel(new GridLayout(4, 4));
        JLabel level1Header = new JLabel("Level 1", JLabel.CENTER);
        JButton back = new JButton("Back");
        back.setPreferredSize(new Dimension(75, 30));
        back.setActionCommand("back1");
        back.addActionListener(new ButtonClickListener());
        mainFrame.add(level1);
        level1.add(back);
        level1.add(level1Header);
        level1.add(timeDisplay);
        timer.start();
        mainFrame.setVisible(true);
        TriviaQuestion test = new TriviaQuestion("this is a test", "true");
        test.displayQuestion();
    }

     public void level2Page() {
        mainFrame.remove(levels);
        level2 = new JPanel(new GridLayout(4, 4));
        JLabel level2Header = new JLabel("Level 2", JLabel.CENTER);
        JButton back = new JButton("Back");
        back.setPreferredSize(new Dimension(75, 30));
        back.setActionCommand("back2");
        back.addActionListener(new ButtonClickListener());
        mainFrame.add(level2);
        level2.add(back);
        level2.add(level2Header);
        level2.add(timeDisplay);
        timer.start();
        mainFrame.setVisible(true);
    }

     public void level3Page() {
        mainFrame.remove(levels);
        level3 = new JPanel(new GridLayout(4, 4));
        JLabel level3Header = new JLabel("Level 3", JLabel.CENTER);
        JButton back = new JButton("Back");
        back.setPreferredSize(new Dimension(75, 30));
        back.setActionCommand("back3");
        back.addActionListener(new ButtonClickListener());
        mainFrame.add(level3);
        level3.add(back);
        level3.add(level3Header);
        level3.add(timeDisplay);
        timer.start();
        mainFrame.setVisible(true);
    }

     public void level4Page() {
        mainFrame.remove(levels);
        level4 = new JPanel(new GridLayout(4, 4));
        JLabel level4Header = new JLabel("Level 4", JLabel.CENTER);
        JButton back = new JButton("Back");
        back.setPreferredSize(new Dimension(75, 30));
        back.setActionCommand("back4");
        back.addActionListener(new ButtonClickListener());
        mainFrame.add(level4);
        level4.add(back);
        level4.add(level4Header);
        level4.add(timeDisplay);
        timer.start();
        mainFrame.setVisible(true);
    }

     public void level5Page() {
        mainFrame.remove(levels);
        level5 = new JPanel(new GridLayout(4, 4));
        JLabel level5Header = new JLabel("Level 5", JLabel.CENTER);
        JButton back = new JButton("Back");
        back.setPreferredSize(new Dimension(75, 30));
        back.setActionCommand("back5");
        back.addActionListener(new ButtonClickListener());
        mainFrame.add(level5);
        level5.add(back);
        level5.add(level5Header);
        level5.add(timeDisplay);
        timer.start();
        mainFrame.setVisible(true);
    }

     public void level6Page() {
        mainFrame.remove(levels);
        level6 = new JPanel(new GridLayout(4, 4));
        JLabel level6Header = new JLabel("Level 6", JLabel.CENTER);
        JButton back = new JButton("Back");
        back.setPreferredSize(new Dimension(75, 30));
        back.setActionCommand("back6");
        back.addActionListener(new ButtonClickListener());
        mainFrame.add(level6);
        level6.add(back);
        level6.add(level6Header);
        level6.add(timeDisplay);
        timer.start();
        mainFrame.setVisible(true);
    }

     public void level7Page() {
        mainFrame.remove(levels);
        level7 = new JPanel(new GridLayout(4, 4));
        JLabel level7Header = new JLabel("Level 7", JLabel.CENTER);
        JButton back = new JButton("Back");
        back.setPreferredSize(new Dimension(75, 30));
        back.setActionCommand("back7");
        back.addActionListener(new ButtonClickListener());
        mainFrame.add(level7);
        level7.add(back);
        level7.add(level7Header);
        level7.add(timeDisplay);
        timer.start();
        mainFrame.setVisible(true);
    }

     public void level8Page() {
        mainFrame.remove(levels);
        level8 = new JPanel(new GridLayout(4, 4));
        JLabel level8Header = new JLabel("Level 8", JLabel.CENTER);
        JButton back = new JButton("Back");
        back.setPreferredSize(new Dimension(75, 30));
        back.setActionCommand("back8");
        back.addActionListener(new ButtonClickListener());
        mainFrame.add(level8);
        level8.add(back);
        level8.add(level8Header);
        level8.add(timeDisplay);
        timer.start();
        mainFrame.setVisible(true);
    }

     public void level9Page() {
        mainFrame.remove(levels);
        level9 = new JPanel(new GridLayout(4, 4));
        JLabel level9Header = new JLabel("Level 9", JLabel.CENTER);
        JButton back = new JButton("Back");
        back.setPreferredSize(new Dimension(75, 30));
        back.setActionCommand("back9");
        back.addActionListener(new ButtonClickListener());
        mainFrame.add(level9);
        level9.add(back);
        level9.add(level9Header);
        level9.add(timeDisplay);
        timer.start();
        mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            timeDisplay = new JLabel();
            String dt = new SimpleDateFormat("EEE, d MMM yyyy").format(new Date()); // starts date as today
            SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, 1);  // number of days to add
            dt = sdf.format(cal.getTime());
            timeDisplay.setText(sdf.format(cal.getTime()));
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cal.add(Calendar.DATE, 1);
                    timeDisplay.setText(sdf.format(cal.getTime()));
                    
                }
            });

            if (command.equals("start")){
                levelsPage();
            }
            else if (command.equals("level1")){
                level1Page();
            }
            else if (command.equals("level2")){
                level2Page();
            }
            else if (command.equals("level3")){
                level3Page();
            }
            else if (command.equals("back1")){
                mainFrame.remove(level1);
                //levelsPage();
            }
            else if (command.equals("back2")){
                mainFrame.remove(level2);
                levelsPage();
            }
            else if (command.equals("back3")){
                mainFrame.remove(level3);
                levelsPage();
            }
              else if (command.equals("level4")){
                level4Page();
            }
            else if (command.equals("level5")){
                level5Page();
            }
            else if (command.equals("level6")){
                level6Page();
            }
            else if (command.equals("back4")){
                mainFrame.remove(level4);
                levelsPage();
            }
            else if (command.equals("back5")){
                mainFrame.remove(level5);
                levelsPage();
            }
            else if (command.equals("back6")){
                mainFrame.remove(level6);
                levelsPage();
            }
              else if (command.equals("level7")){
                level7Page();
            }
            else if (command.equals("level8")){
                level8Page();
            }
            else if (command.equals("level9")){
                level9Page();
            }
            else if (command.equals("back7")){
                mainFrame.remove(level7);
                levelsPage();
            }
            else if (command.equals("back8")){
                mainFrame.remove(level8);
                levelsPage();
            }
            else if (command.equals("back9")){
                mainFrame.remove(level9);
                levelsPage();
            }
        }              
    }
}


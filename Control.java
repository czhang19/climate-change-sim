import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;


public class Control{ //to navigate between pages
	public JFrame mainFrame;
	public Start start;
	public Home home;
	public Page level1;
	public Page level2;
	public Page level3;
	public Page level4;
	public Page level5;
	public Page level6;
	public Page level7;
	public Page level8;
	public Page level9;
	public Page tracker;
    public ArrayList<TriviaQuestion> qbank;


    public Control() 
            throws FileNotFoundException {
        mainFrame = new JFrame("Flood");
        mainFrame.setSize(1000, 750);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start = new Start();
        start.startButton.addActionListener(new ButtonClickListener());
        display(start);
        home = new Home();
    	home.level1Button.addActionListener(new ButtonClickListener());
    	home.level2Button.addActionListener(new ButtonClickListener());
    	home.level3Button.addActionListener(new ButtonClickListener());
    	home.level4Button.addActionListener(new ButtonClickListener());
    	home.level5Button.addActionListener(new ButtonClickListener());
    	home.level6Button.addActionListener(new ButtonClickListener());
    	home.level7Button.addActionListener(new ButtonClickListener());
    	home.level8Button.addActionListener(new ButtonClickListener());
    	home.level9Button.addActionListener(new ButtonClickListener());
        level1 = new Page1();
        level2 = new Page2();
       	level3 = new Page3();
       	level4 = new Page4();
       	level5 = new Page5();
       	level6 = new Page6();
       	level7 = new Page7();
       	level8 = new Page8();
       	level9 = new Page9();
       	level1.backButton.addActionListener(new ButtonClickListener());
       	level2.backButton.addActionListener(new ButtonClickListener());
       	level3.backButton.addActionListener(new ButtonClickListener());
       	level4.backButton.addActionListener(new ButtonClickListener());
       	level5.backButton.addActionListener(new ButtonClickListener());
       	level6.backButton.addActionListener(new ButtonClickListener());
       	level7.backButton.addActionListener(new ButtonClickListener());
       	level8.backButton.addActionListener(new ButtonClickListener());
       	level9.backButton.addActionListener(new ButtonClickListener());
       	mainFrame.setVisible(true);
    
        File f = new File("TriviaBank.txt");
        Scanner input = new Scanner(f);
        input.useDelimiter("\\s*=\\s*");
        qbank = new ArrayList<TriviaQuestion>();
        String question = "";
        String answer = "";
        while (input.hasNextLine()) {
            question = input.next();
            answer = input.next();
            qbank.add(new TriviaQuestion(question, answer));
        }
        input.close();
    }

    public static void main(String[] args) 
            throws FileNotFoundException {
    	Control game = new Control();
    	
    }

    public void display(Start start){
    	mainFrame.add(start.panel);
    	mainFrame.setVisible(true);
    }

    public void display(Home home){
    	mainFrame.add(home.panel);
    	mainFrame.setVisible(true);
    }

    public void display(Page page){
        page.timer.start();
        page.panel.add(page.timeDisplay);
        mainFrame.add(page.panel);
        mainFrame.setVisible(true);
        page.bank = qbank;
        page.qtimer.start();

    }


    public void remove(Page page){
    	mainFrame.remove(page.panel);
        page.timer.stop();
        page.qtimer.stop();
    }

    public void remove(Start start){
    	mainFrame.remove(start.panel);
    }

    public void remove(Home home){
    	mainFrame.remove(home.panel);
    }

    public class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();

            if (command.equals("start")){
            	remove(start);
                display(home);
            }
            else if (command.equals("level1")){
            	remove(home);
                display(level1);
                tracker = level1;
            }
            else if (command.equals("level2")){
            	remove(home);
                display(level2);
                tracker = level2;
            }
            else if (command.equals("level3")){
                remove(home);
                display(level3);
                tracker = level3;
            }
            else if (command.equals("level4")){
                remove(home);
                display(level4);
                tracker = level4;
            }
            else if (command.equals("level5")){
                remove(home);
                display(level5);
                tracker = level5;
            }
            else if (command.equals("level6")){
                remove(home);
                display(level6);
                tracker = level6;
            }
            else if (command.equals("level7")){
                remove(home);
                display(level7);
                tracker = level7;
            }
            else if (command.equals("level8")){
                remove(home);
                display(level8);
                tracker = level8;
            }
            else if (command.equals("level9")){
                remove(home);
                display(level9);
                tracker = level9;
            }
            else if (command.equals("back")){
                //remove(tracker);
                mainFrame.remove(level1.panel);
                display(home);
            }
        }              
    }
}
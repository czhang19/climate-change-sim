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
import java.util.Collections;


public class Control{ //to navigate between pages
	public JFrame mainFrame;
	public Start start;
	public Home home;
	public Page level1;
	public Page level2;
	public Page level3;
	public Page level4;
	public Page level5;
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
        level1 = new Page1();
        level2 = new Page2();
       	level3 = new Page3();
       	level4 = new Page4();
       	level5 = new Page5();
       	level1.backButton.addActionListener(new ButtonClickListener());
       	level2.backButton.addActionListener(new ButtonClickListener());
       	level3.backButton.addActionListener(new ButtonClickListener());
       	level4.backButton.addActionListener(new ButtonClickListener());
       	level5.backButton.addActionListener(new ButtonClickListener());
       	mainFrame.setVisible(true);
    
        File f = new File("TriviaBank.txt");
        Scanner input = new Scanner(f); // scans trivia bank
        input.useDelimiter("\\s*=\\s*");
        qbank = new ArrayList<TriviaQuestion>();
        String question = "";
        String answer = "";
        String html1 = "";
        String html2 = "";
        while (input.hasNextLine()) {
            html1 = "<html><body style='width: "; 
            html2 = "px'>";
            question = html1+ "300" + html2 + input.next(); // sets width to fit jframe
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
        home.panel.revalidate();
        home.panel.repaint();
    	mainFrame.setVisible(true);
    }

    public void display(Page page){
        page.panel.add(page.timeDisplay);
        mainFrame.add(page.panel);
        page.panel.revalidate();
        page.panel.repaint();
        mainFrame.setVisible(true);
        page.info();
        Collections.shuffle(qbank);
        page.bank = qbank;
    }


    public void remove(Page page){
        page.closeTrivia();
        page.resetWater();
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
            else if (command.equals("back")){
                remove(tracker);
                display(home);
            }
        }              
    }
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestSwing{
    private JFrame mainFrame;
    private JLabel intro;
    private JPanel controlPanel;
    private JButton start;
    private JLabel second;
    private JButton topic1, topic2, topic3;

    public TestSwing(){
        prepareGUI();
    }
    public static void main(String[] args) {
       TestSwing test = new TestSwing();
       test.showEvent();
    }
    private void prepareGUI(){
        mainFrame = new JFrame("Test Swing"); //creating frame
        mainFrame.setSize(500, 500);
        //mainFrame.setLayout(new GridLayout(2,2));
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //program ends when user exits jframe
        //mainFrame.setVisible(true);
        // controlPanel = new JPanel();
        // controlPanel.setLayout(new FlowLayout());
        intro = new JLabel("Climate Change Simulation", JLabel.CENTER); //create label
        mainFrame.add(intro); //adds label to frame
    }
    private void showEvent(){
        start = new JButton("Start"); //create button
        start.setActionCommand("start"); //set action command
        start.addActionListener(new ButtonClickListener());
        start.setPreferredSize(new Dimension(75, 30));
        mainFrame.add(start); //adds button to frame
        //controlPanel.add(start);
        mainFrame.setVisible(true); //necessary for some reason to make buttons+labels appear
    }
    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand(); //gets action command corresponding to button
            if (command.equals("start")){ //because "start" is the action command associated with the start button
                //mainFrame.removeAll(); //method that doesn't work for whatever reason
                secondPage();
            }
            else if (command.equals())
        }
    }
    private void secondPage(){
        JButton test = new JButton("test");
        start.setVisible(false);
        intro.setVisible(false);
        //mainFrame.remove(start);
        //mainFrame.add(test);
        second = new JLabel("Choose a topic: ", JLabel.CENTER);
        topic1 = new JButton("Florida Coastline");
        topic2 = new JButton("Glaciers");
        topic3 = new JButton("Coral Reefs");

        mainFrame.setLayout(new GridLayout(4, 2));
        mainFrame.add(second);
        mainFrame.add(topic1);
        mainFrame.add(topic2);
        mainFrame.add(topic3);
        mainFrame.setVisible(true);
    }

}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestSwing{
    private JFrame mainFrame;
    private JLabel intro;
    private JPanel controlPanel;
    private JButton start;

    public TestSwing(){
        prepareGUI();
    }
    public static void main(String[] args) {
       TestSwing test = new TestSwing();
       test.showEvent();
    }
    private void prepareGUI(){
        mainFrame = new JFrame("Test Swing");
        mainFrame.setSize(500, 500);
        //mainFrame.setLayout(new GridLayout(2,2));
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //mainFrame.setVisible(true);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        intro = new JLabel("Climate Change Simulation", JLabel.CENTER);
        mainFrame.add(intro);
    }
    private void showEvent(){
        start = new JButton("Start");
        start.setActionCommand("start");
        start.addActionListener(new ButtonClickListener());
        start.setPreferredSize(new Dimension(75, 30));
        mainFrame.add(start);
        //controlPanel.add(start);
        mainFrame.setVisible(true);
    }
    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if (command.equals("start")){
                System.out.println("marker");
                //mainFrame.removeAll();
                secondPage();
            }
        }
    }
    private void secondPage(){
        JButton test = new JButton("test");
        start.setVisible(false);
        intro.setVisible(false);
        //mainFrame.remove(start);
        //mainFrame.add(test);
        mainFrame.setVisible(true);
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LeaderAction {
    public String text;
    public int x; // if negative, causes climate change; if positive, slows climate change
    public JFrame commentaryFrame;
    public JPanel commentaryPanel;
    public JLabel commentaryLabel;
    public Timer timer;
    
    public LeaderAction(String text, int x) {
        this.text = "<html><body style='width: 300px'>" + text;
        this.x = x;
    }
    
    public void display() {
        commentaryFrame = new JFrame("Breaking News!");
        //commentaryFrame.setLocationRelativeTo(null);
        commentaryFrame.setSize(400, 200);
        commentaryPanel = new JPanel(new FlowLayout());
        commentaryLabel = new JLabel(text);
        commentaryFrame.add(commentaryPanel);
        commentaryPanel.add(commentaryLabel);
        commentaryFrame.setVisible(true);
        timer = new Timer(5000, new ButtonClick());
        timer.setRepeats(false);
        timer.setActionCommand("timer");
        timer.start();
    }
    
    private class ButtonClick implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            
            if (command.equals("timer")){
            	commentaryFrame.dispatchEvent(new WindowEvent(commentaryFrame, WindowEvent.WINDOW_CLOSING));
            }
        }
    }
}
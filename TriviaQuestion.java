import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TriviaQuestion{
	String question;
	boolean answer;
	JFrame qFrame;
	JPanel qPanel;
	JLabel qLabel;
	Timer timer;
	JLabel correct = new JLabel("Correct!");
	JLabel incorrect = new JLabel("Incorrect");

	public TriviaQuestion(String question, String answer){
		this.question = question;
		this.answer = answer.equals("true");
	}

	public void displayQuestion(){
		qFrame = new JFrame("Trivia!");
		qFrame.setLocationRelativeTo(null);
		qFrame.setSize(400, 300);
		qPanel = new JPanel(new FlowLayout());
		qLabel = new JLabel(question);
		JButton trueButton = new JButton("True");
		trueButton.setActionCommand("true");
		trueButton.addActionListener(new ButtonClick());		
		JButton falseButton = new JButton("False");
		falseButton.setActionCommand("false");
		falseButton.addActionListener(new ButtonClick());
		qFrame.add(qPanel);
		qPanel.add(qLabel);
		qPanel.add(trueButton);
		qPanel.add(falseButton);
		qFrame.setVisible(true);
		timer = new Timer(1000, new ButtonClick());
        timer.setRepeats(false);
        timer.setActionCommand("timer");
	}
	
  	private class ButtonClick implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if (command.equals("true")){
            	qFrame.remove(qPanel);
            	if (answer){
            		qFrame.add(correct);
            	}
            	else{
            		qFrame.add(incorrect);
            	}
            	qFrame.setVisible(true);
            	timer.start();
            }
            else if (command.equals("false")){
            	qFrame.remove(qPanel);
            	if (!answer){
            		qFrame.add(correct);
            	}
            	else{
            		qFrame.add(incorrect);
            	}
            	qFrame.setVisible(true);
            	timer.start();
            }
            else if (command.equals("timer")){
            	qFrame.dispatchEvent(new WindowEvent(qFrame, WindowEvent.WINDOW_CLOSING));
            }
		}
	}	
}

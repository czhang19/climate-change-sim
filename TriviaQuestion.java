import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TriviaQuestion{
	String question;
	boolean answer;
	JFrame qFrame;
	JPanel qPanel;
	JLabel qLabel;
    JTextArea qText;
    JButton trueButton;
    JButton falseButton;
	Timer timer;
	boolean ansCorrectly;
	boolean isClosed = false;
	JLabel correct = new JLabel("Correct!");
	JLabel incorrect = new JLabel("Incorrect :(");

	public TriviaQuestion(String question, String answer){
		this.question = question;
		this.answer = answer.equals("T");
	}

	public void displayQuestion(){
		qFrame = new JFrame("Trivia!");
		qFrame.setLocationRelativeTo(null);
		qFrame.setSize(400, 300);
		addAction();
		qPanel = new JPanel(new FlowLayout());
		qLabel = new JLabel(question);
		trueButton = new JButton("True");
		trueButton.setActionCommand("true");
		//trueButton.addActionListener(new ButtonClick());		
		falseButton = new JButton("False");
		falseButton.setActionCommand("false");
		//falseButton.addActionListener(new ButtonClick());
		qFrame.add(qPanel);
		qPanel.add(qLabel);
		qPanel.add(trueButton);
		qPanel.add(falseButton);
		qFrame.setVisible(true);
		timer = new Timer(1000, new ButtonClick());
        timer.setRepeats(false);
        timer.setActionCommand("timer");
	}

	public void addAction(){
		qFrame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosed(WindowEvent e){
				isClosed = true;
			}
		});
	}

	public void close(){
		if (!isClosed){
			qFrame.dispatchEvent(new WindowEvent(qFrame, WindowEvent.WINDOW_CLOSING));
		}
	}
	
  	private class ButtonClick implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            // if (command.equals("true")){
            // 	qFrame.remove(qPanel);
            // 	if (answer){
            // 		qFrame.add(correct);
            // 		ansCorrectly = true;
            // 	}
            // 	else{
            // 		qFrame.add(incorrect);
            // 		ansCorrectly = false;
            // 	}
            // 	qFrame.setVisible(true);
            // 	timer.start();
            // }
            // else if (command.equals("false")){
            // 	qFrame.remove(qPanel);
            // 	if (!answer){
            // 		qFrame.add(correct);
            // 		ansCorrectly = true;
            // 	}
            // 	else{
            // 		qFrame.add(incorrect);
            // 		ansCorrectly = false;
            // 	}
            // 	qFrame.setVisible(true);
            // 	timer.start();
            // }
            if (command.equals("timer")){
            	qFrame.dispatchEvent(new WindowEvent(qFrame, WindowEvent.WINDOW_CLOSING));
            }
		}
	}

}

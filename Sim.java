import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sim{
	private JFrame mainFrame;
	private JPanel start, topics, florida, coral, glacier;

	public static void main(String[] args) {
		Sim simulation = new Sim();
	}

	public Sim(){
		mainFrame = new JFrame("Climate Change Simulation");
		mainFrame.setSize(1000, 750);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startPage();
	}

	public void startPage(){
		start = new JPanel(new FlowLayout());
		JLabel intro = new JLabel("Climate Change Simulation", JLabel.CENTER);
		JButton startButton = new JButton("Start");
        startButton.setActionCommand("start"); //set action command
        startButton.addActionListener(new ButtonClickListener());
        startButton.setPreferredSize(new Dimension(75, 30));
        mainFrame.add(start);
        start.add(intro);
        start.add(startButton);
        mainFrame.setVisible(true);
	}

	public void topicsPage(){
		mainFrame.remove(start);
		topics = new JPanel(new GridLayout(4, 2));
		JLabel second = new JLabel("Choose a topic: ", JLabel.CENTER);
        JButton topic1 = new JButton("Florida Coastline");
        topic1.setActionCommand("florida");
        topic1.addActionListener(new ButtonClickListener());
        JButton topic2 = new JButton("Glaciers");
        topic2.setActionCommand("glaciers");
        topic2.addActionListener(new ButtonClickListener());
        JButton topic3 = new JButton("Coral Reefs");
        topic3.setActionCommand("coral");
        topic3.addActionListener(new ButtonClickListener());
        mainFrame.add(topics);
        topics.add(second);
        topics.add(topic1);
        topics.add(topic2);
        topics.add(topic3);
        mainFrame.setVisible(true);
	}

	public void floridaPage(){
		mainFrame.remove(topics);
		florida = new JPanel(new GridLayout(4, 4));
		// florida = new JPanel(new GridBagLayout());
		// GridBagConstraints c = new GridBagConstraints();
		// c.gridx = -2;
		// c.gridy = -1;

		JLabel floridaHeader = new JLabel("Florida Coastline", JLabel.CENTER);
		JButton back = new JButton("Back");
		back.setPreferredSize(new Dimension(75, 30));
		back.setActionCommand("floridaBack");
		back.addActionListener(new ButtonClickListener());
		mainFrame.add(florida);
		//florida.add(back, c);
		florida.add(back);
		florida.add(floridaHeader);
		mainFrame.setVisible(true);
	}

	public void glacierPage(){
		mainFrame.remove(topics);
		glacier = new JPanel(new GridLayout(4, 4));
		JLabel glacierHeader = new JLabel("Mendenhall Glacier", JLabel.CENTER);
		JButton back = new JButton("Back");
		back.setPreferredSize(new Dimension(75, 30));
		back.setActionCommand("glacierBack");
		back.addActionListener(new ButtonClickListener());
		mainFrame.add(glacier);
		glacier.add(back);
		glacier.add(glacierHeader);
		mainFrame.setVisible(true);
	}

	public void coralPage(){
		mainFrame.remove(topics);
		coral = new JPanel(new GridLayout(4, 4));
		JLabel coralHeader = new JLabel("Coral Reefs", JLabel.CENTER);
		JButton back = new JButton("Back");
		back.setPreferredSize(new Dimension(75, 30));
		back.setActionCommand("coralBack");
		back.addActionListener(new ButtonClickListener());
		mainFrame.add(coral);
		coral.add(back);
		coral.add(coralHeader);
		mainFrame.setVisible(true);
	}

	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String command = e.getActionCommand();
			if (command.equals("start")){
				topicsPage();
			}
			else if (command.equals("florida")){
				floridaPage();
			}
			else if (command.equals("glaciers")){
				glacierPage();
			}
			else if (command.equals("coral")){
				coralPage();
			}
			else if (command.equals("floridaBack")){
				mainFrame.remove(florida);
				topicsPage();
			}
			else if (command.equals("coralBack")){
				mainFrame.remove(coral);
				topicsPage();
			}
			else if (command.equals("glacierBack")){
				mainFrame.remove(glacier);
				topicsPage();
			}
		}	
	}

}
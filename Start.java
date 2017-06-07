import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Start {
        public JPanel panel;
        public JButton startButton;
        public JLabel intro;
        public JLabel introduction;
        public JLabel directions;

        public Start(){
        panel = new JPanel(new FlowLayout());
        JLabel bufferLeft = new JLabel("<html><body style='width: 40'>");
        panel.add(bufferLeft);
        JLabel spaceBuffer = new JLabel("<html><body style='width: 1000'>");
        spaceBuffer.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        JLabel spaceBufferTwo = new JLabel("<html><body style='width: 1000'>");
        spaceBufferTwo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        JLabel spaceBufferThree = new JLabel("<html><body style='width: 1000'>");
        spaceBufferThree.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        intro = new JLabel("                                              Flood                                              ", JLabel.CENTER);
        intro.setHorizontalAlignment(JLabel.CENTER);
        intro.setFont(new Font("Serif", Font.PLAIN, 48));
        panel.add(spaceBufferThree);
        startButton = new JButton("Start");
        introduction = new JLabel("<html><body style='width: 800'> <b>Introduction:</b> Rising levels of greenhouse gases (CO2 and CH4 in particular) in the atmosphere have a net warming effect on our Earth. As global temperatures rise, so do water levels. This change in sea level is due to melting ice caps and general expansion of water molecules.");
        introduction.setFont(new Font("Serif", Font.PLAIN, 25));
        directions = new JLabel("<html><body style='width: 800'> <b>Directions:</b> Observe the effects of greenhouse gases by drowning some world leaders! Clicking the CO2 button will raise water levels, and CH4 (the more potent gas) will activate at intervals throughout gameplay. In our simulation, CH4 raises water levels three times more than CO2 does. The world leaders will either fight against or help you through their actions supporting or undermining climate science, so keep an eye out for pop-ups. You can also answer trivia questions to help you - answering a certain number of questions correctly will zap the leader using the reflective solar panels located at the top left of the screen. If the water level goes below the screen, you lose. Happy flooding!");
        directions.setFont(new Font("Serif", Font.PLAIN, 20));
        startButton.setActionCommand("start"); //set action command
        startButton.setPreferredSize(new Dimension(75, 30));
        panel.add(intro);
        panel.add(startButton);
        panel.add(spaceBufferTwo);
        panel.add(introduction);
        panel.add(spaceBuffer);
        panel.add(directions);
        }

        
}
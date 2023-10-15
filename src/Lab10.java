import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.BevelBorder;

//Eyiara Oladipo
//12/1/2022
//Lab 10
public class Lab10 extends JFrame{
	//Declaring the jlabel variables for the coordinates of the 
	//x values or the y values
	JLabel xCoordsValue;
	JLabel yCoordsValue;
	int mouseClicks = 0;
	JLabel clickedCounter;
	
	//Mouse listener 
	private class mouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			int xCoords = e.getX();
			int yCoords = e.getY();
			//Getting the current clicked position and setting the appropriate text value
			xCoordsValue.setText(""+xCoords);
			yCoordsValue.setText(""+yCoords);
			
			//incrementing mouseclicks
			mouseClicks++;
			clickedCounter.setText(mouseClicks + " times");
		}
	}
	
	//once the user clicks the cancel button, ask them whether they want to exit or not
	private class CheckOnExit extends WindowAdapter{
		JFrame popup;
	 class cancelListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JButton buttonClicked = (JButton) e.getSource();
				if(buttonClicked.getText()== "Yes") {
					System.exit(0);
			}else {
				popup.dispose();
			}
			}
			
		}
		public void windowClosing(WindowEvent e) {
			popup = new JFrame();
			popup.setSize(200, 200);
			popup.getContentPane().setLayout(new GridLayout(2,1));
			JPanel questionPanel = new JPanel();
			JLabel questionLabel = new JLabel("Are you sure you want to exit?");
			questionPanel.add(questionLabel);
			
			JPanel buttonPanel = new JPanel();
			JButton button1 = new JButton("Yes");
			JButton button2 = new JButton("No");
			buttonPanel.setLayout(new GridLayout(1,2));
			buttonPanel.add(button1);
			buttonPanel.add(button2);
			button1.addActionListener(new cancelListener());
			button2.addActionListener(new cancelListener());
			popup.getContentPane().add(questionPanel);
			popup.getContentPane().add(buttonPanel);
			popup.setVisible(true);
		}
	}
	
	
	public Lab10() {
		getContentPane().setLayout(null);
		//Adding the mouse listener to the jframe
		addMouseListener(new mouseListener());
		JPanel coOrdsPanel = new JPanel();
		coOrdsPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		coOrdsPanel.setBounds(25, 30, 384, 129);
		setSize(464, 294);
		getContentPane().add(coOrdsPanel);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new CheckOnExit());
		coOrdsPanel.setLayout(null);
		
		//Window builder code to create the layout
		JLabel lblNewLabel = new JLabel("Co-ordinates of where you Clicked");
		lblNewLabel.setBounds(95, 29, 224, 14);
		coOrdsPanel.add(lblNewLabel);
		
		JLabel xCoordsLabel = new JLabel("X-coords");
		xCoordsLabel.setBounds(45, 54, 72, 14);
		coOrdsPanel.add(xCoordsLabel);
		
		JLabel yCoordsLabel = new JLabel("Y-coords");
		yCoordsLabel.setBounds(290, 54, 72, 14);
		coOrdsPanel.add(yCoordsLabel);
		
		xCoordsValue = new JLabel("0");
		xCoordsValue.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		xCoordsValue.setBounds(45, 79, 54, 21);
		coOrdsPanel.add(xCoordsValue);
		
		yCoordsValue = new JLabel("0");
		yCoordsValue.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		yCoordsValue.setBounds(290, 79, 84, 21);
		coOrdsPanel.add(yCoordsValue);
		
		JPanel clickCounterPanel = new JPanel();
		clickCounterPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		clickCounterPanel.setBounds(25, 185, 384, 45);
		getContentPane().add(clickCounterPanel);
		clickCounterPanel.setLayout(null);
		
		//Shows how many times the user has clicked
		JLabel clickedCounterLabel = new JLabel("You have clicked :");
		clickedCounterLabel.setBounds(45, 11, 131, 23);
		clickCounterPanel.add(clickedCounterLabel);
		
		clickedCounter = new JLabel("0 times");
		clickedCounter.setBounds(144, 15, 48, 14);
		clickCounterPanel.add(clickedCounter);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		//initializing lab10
		new Lab10();
	}
	
}

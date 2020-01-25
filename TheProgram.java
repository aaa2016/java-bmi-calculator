package guiProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TheProgram extends JFrame implements ActionListener {
	
	JTextField heightField = new JTextField(5);
	JTextField weightField = new JTextField(5);
	JLabel heightLabel = new JLabel(" Height in m: ");
	JLabel weightLabel = new JLabel(" Weight in kg: ");
	JButton calculateButton = new JButton(" Calculate BMI ");
	//JButton clearButton = new JButton(" Clear form ");
	JTextField resultField = new JTextField(10);
	
	public TheProgram() {
	
		super("BMI Calculator");
		setBounds(300, 100, 350, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pane = new JPanel();
		GridLayout bmiForm = new GridLayout(3,2);
		pane.setLayout(bmiForm);
		pane.add(heightLabel);
		pane.add(heightField);
		pane.add(weightLabel);
		pane.add(weightField);
		pane.add(calculateButton);
		pane.add(resultField);
		add(pane);
		setVisible(true);
		
		calculateButton.addActionListener(this);
		//clearButton.addActionListener(this);
	
	}
	
	public void actionPerformed(ActionEvent event) {
		
		try {
			
			float height = Float.parseFloat(heightField.getText());
			float weight = Float.parseFloat(weightField.getText());
		
			float bmi = (weight / (height * height));
			//String bmiString = Float.toString(bmi);
			String bmiString = String.format ("%.1f", bmi);
			
			if (bmi<18.5) {
				resultField.setText(bmiString +", which is low");
			} else if (bmi<25) {
				resultField.setText(bmiString +", which is normal");
			} else {
				resultField.setText(bmiString +", which is high");
			}
		
		} catch (NumberFormatException nfe) {
			
			resultField.setText("Input must be in numbers");
			
		}
		
	}
	public static void main(String[] arguments) {
		
		TheProgram sf = new TheProgram();
		
	}
	
}

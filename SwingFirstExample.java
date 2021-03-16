import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;  
public class SwingFirstExample implements ActionListener {   
	SwingFirstExample(){  
		 JFrame frame = new JFrame("Insertion sort");  
	        JPanel panel = new JPanel();  
	        JLabel label = new JLabel("Enter some numbers: \n");  
	        JTextField t1;  
	        t1=new JTextField();  
	        t1.setBounds(50,100, 200,30);  
	        frame.add(t1); 
	        
	        JButton button = new JButton();  
	        JButton button1 = new JButton();  
	        button.setText("Ok"); 
	        button1.setText("Cancel"); 
	        panel.add(label);  
	        panel.add(button,BorderLayout.SOUTH);  
	        panel.add(button1,BorderLayout.SOUTH);  
	        frame.add(panel);  
	        button.addActionListener(this);  
	        button1.addActionListener(this); 
	        frame.setSize(300, 300);  
	        frame.setLocationRelativeTo(null);  
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        frame.setVisible(true);
	        frame.setLayout(null);  
	}  
	public static void main(String[] args) {  
		new SwingFirstExample();  
	}
	public void actionPerformed(ActionEvent e) {
		//接button功能
	}  
}

import javax.swing.*;  
public class SwingFirstExample {  
JFrame f;  
	SwingFirstExample(){  
		f=new JFrame();   
		String name=JOptionPane.showInputDialog(f,"Enter numbers: ");
		JOptionPane.showMessageDialog(null,"After insertion sort: ");
	}  
	public static void main(String[] args) {  
		new SwingFirstExample();  
	}  
}  

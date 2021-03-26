import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class calculator extends JPanel {
   private static final int ROWS = 10;
   private static final int COLS = 50;
   private static final String[] BUTTON_NAMES = { "insertion_sort" };
   private static final int GAP = 3;
   private JTextArea inputTextArea = new JTextArea(ROWS, COLS);
   private JTextArea outputTextArea = new JTextArea(ROWS, COLS);
   private static final JButton button = new JButton();
   
   private int[] data;


   public calculator() {
      JPanel buttonPanel = new JPanel(new GridLayout(2, 6, GAP, 0));
      
      
      for (String btnName : BUTTON_NAMES) {
    	    
    	  buttonPanel.add(button);
    	  button.setText(btnName);
    	 
      }
      outputTextArea.setFocusable(false);
      outputTextArea.setEditable(false);

      setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
      add(buttonPanel);
      add(putInTitledScrollPane(inputTextArea, "Input Text"));
      add(putInTitledScrollPane(outputTextArea, "Output Text"));
      
     button.addActionListener(new insertion_sort());
     
      
   }

   private JPanel putInTitledScrollPane(JComponent component,
         String title) {
      JPanel wrapperPanel = new JPanel(new BorderLayout());
      wrapperPanel.setBorder(BorderFactory.createTitledBorder(title));
      wrapperPanel.add(new JScrollPane(component));
      return wrapperPanel;
   }

   private static void createAndShowGui() {
    calculator mainPanel = new calculator();

      JFrame frame = new JFrame("calculator");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
      
      
   }
   public void functionbutton(){
    //link insertion sort with button



   }
   
   private class insertion_sort implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			insertion_sort_actionPerformed(e);
		}
	}
   
   protected void insertion_sort_actionPerformed(ActionEvent e) {
		writeText();
		try {
			ReadText();
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		ArrayList<Integer> userdata=new ArrayList<Integer>();
		FromBigToSmall user1=new FromBigToSmall(userdata);
		user1.addNumber(data);
		user1.stepByStep();
		
		Path path = Paths.get("log.txt");
		try {
            String content = Files.readString(path);
            outputTextArea.setText(content);
        }catch (IOException ee){
            ee.printStackTrace();
        }
		
	}
   
   private void writeText()  {
		
	   File f = new File("data.txt"); 
	   String data = inputTextArea.getText();
	   
	   try {
		   BufferedWriter bw = new BufferedWriter( new FileWriter(f) );
		   
		   bw.write(data);
		   bw.flush();
		   bw.close();
		   
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      }
	   
	}
   
   private void ReadText() throws FileNotFoundException{
	   File f = new File("data.txt");
	   Scanner sc = new Scanner(f);
	   
	   ArrayList<Integer> al = new ArrayList<Integer>();

	   while (sc.hasNextInt()) {

	    al.add(sc.nextInt());

	   }
	   
	   data = new int[al.size()];

	   for (int i = 0; i < data.length; i++) {

	    data[i] = al.get(i);
	   }
   }
   
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}
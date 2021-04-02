import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class calculator extends JPanel implements ItemListener{
   private static final int ROWS = 10;
   private static final int COLS = 50;
   private static final String BUTTON_NAMES[] = { "insertion sort","reverse",
   "count number","add number","random","search","edit","delete","mean","median","quartile","standard deviation",
   "big to small","small to big"};
   private static final int GAP = 3;
   static JComboBox c1 = new JComboBox();
   static JButton b=new JButton("Previous step");
   static JButton b2=new JButton("Next step");
   private JTextArea inputTextArea = new JTextArea(ROWS, COLS);
   private JTextArea outputTextArea = new JTextArea(ROWS, COLS);
   private JTextArea addTextArea = new JTextArea(2, 15);
   private static final JButton button = new JButton();
   private int[] data;
   ArrayList<Integer> userdata=new ArrayList<Integer>();
   


   public calculator() {
      JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
      outputTextArea.setFocusable(false);
      outputTextArea.setEditable(false);
      inputTextArea.setLineWrap(true);
      outputTextArea.setLineWrap(true);
      setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
      
      
      
      for (String btnName : BUTTON_NAMES) {
    	   c1.addItem(btnName);
       }
      
      c1.addActionListener(new JboxActionListener());
      b.addActionListener(new Previous_step_ActionListener());
      b2.addActionListener(new Next_step_ActionListener());
      buttonPanel.add(c1);
      buttonPanel.add(b);
      buttonPanel.add(b2);
      add(buttonPanel);
      add(putInTitledScrollPane(inputTextArea, "Input Text"));
      add(putInTitledScrollPane(outputTextArea, "Output Text"));
      
      File f = new File("log.txt");
     	
      try {
		   BufferedWriter bw = new BufferedWriter( new FileWriter(f) );   
	       
		   bw.write("");
		   bw.flush();
		   bw.close();
		   
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      }
      File fI = new File("data.txt");
     	
      try {
		   BufferedWriter bw = new BufferedWriter( new FileWriter(fI) );   
	       
		   bw.write("");
		   bw.flush();
		   bw.close();
		   
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      }
     
      
   }


   private JPanel putInTitledScrollPane(JComponent component,
         String title) {
      JPanel wrapperPanel = new JPanel(new BorderLayout());
      wrapperPanel.setBorder(BorderFactory.createTitledBorder(title));
      wrapperPanel.add(new JScrollPane(component));
      return wrapperPanel;
   }
   
   private static void createAndShowGui() {
       JFrame f = new JFrame("frame");
       calculator s = new calculator();
       f.setLayout(new FlowLayout());

       
       f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       f.setTitle("Insertion sort Version 21.3.28");
       f.setSize(400, 300);
       f.show();
       f.getContentPane().add(s);
       f.pack();
       f.setLocationByPlatform(false);
       f.setVisible(true); 
   }
   
   
   
   
   protected void addnum_actionPerformed(ActionEvent e) {
	   load();
	   
	   String InputData= JOptionPane.showInputDialog(null,"Please input numbers to add");
	   
	   Path path = Paths.get("data.txt");
		try {
         String content = Files.readString(path);
         inputTextArea.setText(content+" "+InputData);
     }catch (IOException ee){
         ee.printStackTrace();
     }	
	   
		File f = new File("log.txt");
	   	
	       
	       try {
	    	   String content = Files.readString(path);
	 		   BufferedWriter bw = new BufferedWriter( new FileWriter(f) );   
	 	       
	 		   bw.write("old dataset: "+ content +"\n\rinput dataset: "+InputData+"\n\rnew dataset: " + content+" "+InputData);
	 		   bw.flush();
	 		   bw.close();
	 		   
	 	      } catch (IOException ex) {
	 	         ex.printStackTrace();
	 	      }
	       
	        output();   
	}
   
   protected void deletenum_actionPerformed(ActionEvent e) {
	   load();
	   
	   String InputData= JOptionPane.showInputDialog(null,"Please input a number to delete");
	   Scanner sc = new Scanner(InputData);	
	   
	   int Input = sc.nextInt();
	   
		FromSmallToBig user1=new FromSmallToBig(userdata);
		user1.addNumber(data);
		user1.display();
		user1.delete(Input);
		
		File f = new File("log.txt");
		Path path = Paths.get("data.txt");
	       
	       try {
	    	   String content = Files.readString(path);
	 		   BufferedWriter bw = new BufferedWriter( new FileWriter(f) );   
	 	       

	 		   bw.write("old dataset: "+ content);
	 		   bw.write("\n\rdelete number: "+ Input);
	 		   user1.delete(Input);
	 		   user1.display();
	 		   content = Files.readString(path);
	 		   bw.write("\n\rnew dataset: "+ content);
	 		   inputTextArea.setText(content);
	 		   bw.flush();
	 		   bw.close();
	 		   
	 	      } catch (IOException ex) {
	 	         ex.printStackTrace();
	 	      }
	       
	        output();   
	}
   
   protected void randomnum_actionPerformed(ActionEvent e) {
	   load();
	   
	   String InputData1= JOptionPane.showInputDialog(null,"Please input the number of data: ");
	   Scanner sc1 = new Scanner(InputData1);
	   int Input1 = sc1.nextInt();
	   String InputData2= JOptionPane.showInputDialog(null,"Please input min number: ");
	   Scanner sc2 = new Scanner(InputData2);
	   int Input2 = sc2.nextInt();
	   String InputData3= JOptionPane.showInputDialog(null,"Please input max number: ");
	   Scanner sc3 = new Scanner(InputData3);
	   int Input3 = sc3.nextInt();
	   
	    FromSmallToBig user1=new FromSmallToBig(userdata);
		user1.random(Input1,Input2,Input3);
		user1.display();
		
		File f = new File("log.txt");
		Path path = Paths.get("data.txt");
	       
	       try {
	    	   String content = Files.readString(path);
	 		   BufferedWriter bw = new BufferedWriter( new FileWriter(f) );   
	 	       
	 		   bw.write("random dataset: "+ content);
	 		   inputTextArea.setText(content);
	 		   bw.flush();
	 		   bw.close();
	 		   
	 	      } catch (IOException ex) {
	 	         ex.printStackTrace();
	 	      }
	       
	        output();   
	}
   
   protected void search_actionPerformed(ActionEvent e) {
	    load();
	    
	    String InputData1= JOptionPane.showInputDialog(null,"Please input the min rage of data: ");
		Scanner sc1 = new Scanner(InputData1);
		int Input1 = sc1.nextInt();
		String InputData2= JOptionPane.showInputDialog(null,"Please input the max rage of data: ");
		Scanner sc2 = new Scanner(InputData2);
		int Input2 = sc2.nextInt();
		
		FromSmallToBig user1=new FromSmallToBig(userdata);
		user1.addNumber(data);
		user1.search(Input1,Input2);
		
		output();
		
	}
   
   protected void editenum_actionPerformed(ActionEvent e) {
	   load();
	   
	   String InputData1= JOptionPane.showInputDialog(null,"Please input a number to be edited");
	   Scanner sc1 = new Scanner(InputData1);	
	   int Input1 = sc1.nextInt();
	   String InputData2= JOptionPane.showInputDialog(null,"Please input a number to edit");
	   Scanner sc2 = new Scanner(InputData2);	
	   int Input2 = sc2.nextInt();
	   
		FromSmallToBig user1=new FromSmallToBig(userdata);
		user1.addNumber(data);
		user1.display();
		
		File f = new File("log.txt");
		Path path = Paths.get("data.txt");
	       
	       try {
	    	   String content = Files.readString(path);
	 		   BufferedWriter bw = new BufferedWriter( new FileWriter(f) );   
	 	       

	 		   bw.write("old dataset: "+ content);
	 		   bw.write("\n\rdata be edited: "+ Input1);
	 		   bw.write("\n\rdata edit to: "+ Input2);
	 		   user1.edit(Input1,Input2);
	 		   user1.display();
	 		   content = Files.readString(path);
	 		   bw.write("\n\rnew dataset: "+ content);
	 		   inputTextArea.setText(content);
	 		   bw.flush();
	 		   bw.close();
	 		   
	 	      } catch (IOException ex) {
	 	         ex.printStackTrace();
	 	      }
	       
	        output();   
	}
   
   private class Previous_step_ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Previous step");
		}
	}
   
   private class Next_step_ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Next step");
		}
	}
   
   private class JboxActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String action = (String) c1.getSelectedItem();//get the selected item

            switch (action) {
                case "insertion sort":
                	insertion_sort_actionPerformed(e);
                    System.out.println("insertion sort");
                    break;
                case "count number":
                	count_number_actionPerformed(e);
                    System.out.println("count number");
                    break;
                case "reverse":
                	reverse_actionPerformed(e);
                    System.out.println("reverse");
                    break;
                case "add number":
                    System.out.println("add number");
                    addnum_actionPerformed(e);
                    break;
                case "random":
                    System.out.println("random");
                    randomnum_actionPerformed(e);
                    break;
                case "search":
                    System.out.println("search");
                    search_actionPerformed(e);
                    break;
                case "edit":
                    System.out.println("edit");
                    editenum_actionPerformed(e);
                    break;
                case "delete":
                    System.out.println("delete");
                    deletenum_actionPerformed(e);
                    break;
                case "mean":
                	mean_actionPerformed(e);
                    System.out.println("mean");
                    break;
                case "median":
                	median_actionPerformed(e);
                    System.out.println("median");
                    break;
                case "quartile":
                	quartiles_actionPerformed(e);
                    System.out.println("quartile");
                    break;
                case "standard deviation":
                	standard_diviation_actionPerformed(e);
                    System.out.println("standard deviation");
                    break;
                case "big to small":
                	bts_actionPerformed(e);
                    System.out.println("big to small");
                    break;
                case "small to big":
                	stb_actionPerformed(e);
                    System.out.println("small to big");
                    break;

            }
		}
	}
   
   
   protected void insertion_sort_actionPerformed(ActionEvent e) {
	    load();
		
		
		FromSmallToBig user1=new FromSmallToBig(userdata);
		user1.addNumber(data);
		user1.stepByStep();
		
		output();
		
	}
   
   protected void bts_actionPerformed(ActionEvent e) {
	    load();
		
		FromBigToSmall user2=new FromBigToSmall(userdata);
		user2.addNumber(data);
		user2.stepByStep();
		
		output();
		
	}
   
   protected void stb_actionPerformed(ActionEvent e) {
	   	load();
		
		FromSmallToBig user1=new FromSmallToBig(userdata);
		user1.addNumber(data);
		user1.stepByStep();
		
		output();
		
	}
   
   protected void count_number_actionPerformed(ActionEvent e) {
	    load();
	   
		FromSmallToBig user1=new FromSmallToBig(userdata);
		user1.addNumber(data);
		
	   
	   File f = new File("log.txt");
   	
       int num = user1.countNumber();
       try {
 		   BufferedWriter bw = new BufferedWriter( new FileWriter(f) );   
 	       
 		   bw.write("show dataset size: "+num);
 		   bw.flush();
 		   bw.close();
 		   
 	      } catch (IOException ex) {
 	         ex.printStackTrace();
 	      }
       
        output();
       
	}
   
   protected void reverse_actionPerformed(ActionEvent e) {
	    load();
	   
		FromSmallToBig user1=new FromSmallToBig(userdata);
		user1.addNumber(data);
		user1.reverse();
      
        output();
      
	}
   
   protected void mean_actionPerformed(ActionEvent e) {
	    load();
	   
		FromSmallToBig user1=new FromSmallToBig(userdata);
		user1.addNumber(data);
		
	   
	   File f = new File("log.txt");
  	
      double num = user1.mean();
      try {
		   BufferedWriter bw = new BufferedWriter( new FileWriter(f) );   
	       
		   bw.write("find average: "+num);
		   bw.flush();
		   bw.close();
		   
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      }
      
       output();
      
	}

   protected void median_actionPerformed(ActionEvent e) {
	    load();
	   
		FromSmallToBig user1=new FromSmallToBig(userdata);
		user1.addNumber(data);
		
	   
	   File f = new File("log.txt");
  	
      int num = user1.median();
      try {
		   BufferedWriter bw = new BufferedWriter( new FileWriter(f) );   
	       
		   bw.write("find the median: "+num);
		   bw.flush();
		   bw.close();
		   
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      }
      
       output();
      
	}
   
   protected void quartiles_actionPerformed(ActionEvent e) {
	    load();
	   
		FromSmallToBig user1=new FromSmallToBig(userdata);
		user1.addNumber(data);
		
	   
	   File f = new File("log.txt");
  	
      int[] num = user1.quartile();
      try {
		   BufferedWriter bw = new BufferedWriter( new FileWriter(f) );   
	       
		   bw.write("find the quartiles: " + num[0] + " " + num[1] + " " + num[2]);
		   bw.flush();
		   bw.close();
		   
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      }
      
       output();
      
	}

   protected void standard_diviation_actionPerformed(ActionEvent e) {
	    load();
	   
		FromSmallToBig user1=new FromSmallToBig(userdata);
		user1.addNumber(data);
		
	   
	   File f = new File("log.txt");
  	
      double num = user1.sd();
      try {
		   BufferedWriter bw = new BufferedWriter( new FileWriter(f) );   
	       
		   bw.write("find standard diviation: "+num);
		   bw.flush();
		   bw.close();
		   
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      }
      
       output();
      
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
   
   protected void output() {
		
		Path path = Paths.get("log.txt");
		try {
          String content = Files.readString(path);
          outputTextArea.setText(content);
      }catch (IOException ee){
          ee.printStackTrace();
      }	
	}
   
   protected void load() {
	   writeText();
		try {
			ReadText();
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
	}
   
   public static void main(String[] args) {
	   
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }


@Override
public void itemStateChanged(ItemEvent e) {
	// TODO Auto-generated method stub
	
}

}


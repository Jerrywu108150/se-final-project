import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.filechooser.FileNameExtensionFilter;



public class calculator extends JPanel implements ActionListener{
	display Display =new display();

   private static final int ROWS = 10;
   private static final int COLS = 50;
   private static final String BUTTON_NAMES[] = { 
   "count number","add number","search","edit","delete","mean","median","quartile","standard deviation",
   "big to small","small to big"};
   private static final int GAP = 3;
   static JComboBox c1 = new JComboBox();
   static JButton b=new JButton("Previous step");
   static JButton b2=new JButton("Next step");
   static JButton b4=new JButton("reset");
   static JComboBox c2 = new JComboBox();
   static JComboBox c3 = new JComboBox();
   static JButton run=new JButton("run");
   static  JLabel status_label = new JLabel("Welcome to Sort Program",SwingConstants.CENTER);
   private JTextArea inputTextArea = new JTextArea(ROWS,COLS);
   private JTextArea outputTextArea = new JTextArea(ROWS,COLS);
   private JTextArea addTextArea = new JTextArea(2, 15);
   private static final JButton button = new JButton();
   private int[] data;
   private String path="";
   ArrayList<Integer> userdata=new ArrayList<Integer>();
   public String content;
   int type = 0;
   int step ;
   int N_step = 0;
   


   public calculator() {
      outputTextArea.setFocusable(false);
      outputTextArea.setEditable(false);
      inputTextArea.setLineWrap(true);
      outputTextArea.setLineWrap(true);
      setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      setLayout(new GridBagLayout());
      outputTextArea.setText("Using Manual input");
      
      
      for (String btnName : BUTTON_NAMES) {
    	   c1.addItem(btnName);
       }
      c2.addItem("Insertion Sort");
      c2.addItem("Selection Sort");
      c3.addItem("Manual input");
      c3.addItem("File input");
      c3.addItem("Random string");
      c3.addItem("Random number");
      
      
      GridBagConstraints g_c3 = new GridBagConstraints();
      g_c3.gridx = 0;
      g_c3.gridy = 0;
      g_c3.gridwidth = 1;
      g_c3.gridheight = 1;
      g_c3.weightx = 0;
      g_c3.weighty = 0;
      g_c3.fill = GridBagConstraints.NONE;
      g_c3.anchor = GridBagConstraints.CENTER;
      g_c3.insets = new Insets(3,3,3,3);
      c3.setFont(new Font("", Font.PLAIN, 15));
      c3.addActionListener(this);
      add(c3, g_c3);
      c3.setFocusable(false);
      
      GridBagConstraints g_c2 = new GridBagConstraints();
      g_c2.gridx = 2;
      g_c2.gridy = 0;
      g_c2.gridwidth = 1;
      g_c2.gridheight = 1;
      g_c2.weightx = 0;
      g_c2.weighty = 0;
      g_c2.fill = GridBagConstraints.NONE;
      g_c2.anchor = GridBagConstraints.CENTER;
      g_c2.insets = new Insets(3,3,3,3);
      c2.setFont(new Font("", Font.PLAIN, 15));
      add(c2, g_c2);
      c2.addActionListener(this);
      c2.setFocusable(false);
      
      GridBagConstraints g_c1 = new GridBagConstraints();
      g_c1.gridx = 5;
      g_c1.gridy = 0;
      g_c1.gridwidth = 1;
      g_c1.gridheight = 1;
      g_c1.weightx = 0;
      g_c1.weighty = 0;
      g_c1.fill = GridBagConstraints.NONE;
      g_c1.anchor = GridBagConstraints.CENTER;
      g_c1.insets = new Insets(3,3,3,3);
      c1.setFont(new Font("", Font.PLAIN, 15));
      add(c1,g_c1);
      c1.addActionListener(this);
      c1.setEnabled(false);
      c1.setFocusable(false);
      
      GridBagConstraints g_b = new GridBagConstraints();
      g_b.gridx = 3;
      g_b.gridy = 0;
      g_b.gridwidth = 1;
      g_b.gridheight = 1;
      g_b.weightx = 0;
      g_b.weighty = 0;
      g_b.fill = GridBagConstraints.NONE;
      g_b.anchor = GridBagConstraints.CENTER;
      g_b.insets = new Insets(3,3,3,3);
      b.setFont(new Font("", Font.PLAIN, 15));
      add(b,g_b);
      b.setEnabled(false);
      b.addActionListener(this);
      
      GridBagConstraints g_b2 = new GridBagConstraints();
      g_b2.gridx = 4;
      g_b2.gridy = 0;
      g_b2.gridwidth = 1;
      g_b2.gridheight = 1;
      g_b2.weightx = 0;
      g_b2.weighty = 0;
      g_b2.fill = GridBagConstraints.NONE;
      g_b2.anchor = GridBagConstraints.CENTER;
      g_b2.insets = new Insets(3,3,3,3);
      b2.setFont(new Font("", Font.PLAIN, 15));
      add(b2,g_b2);
      b2.setEnabled(false);
      b2.addActionListener(this);
      
      GridBagConstraints g_b4 = new GridBagConstraints();
      g_b4.gridx = 12;
      g_b4.gridy = 51;
      g_b4.gridwidth = 50;
      g_b4.gridheight = 50;
      g_b4.weightx = 0;
      g_b4.weighty = 0;
      g_b4.fill = GridBagConstraints.NONE;
      g_b4.anchor = GridBagConstraints.SOUTHEAST;
      g_b4.insets = new Insets(3,3,3,3);
      b4.setFont(new Font("", Font.PLAIN, 14));
      b4.addActionListener(this);
      add(b4,g_b4);
      b4.setFocusable(false);
      
      GridBagConstraints g_status = new GridBagConstraints();
      g_status.gridx = 12;
      g_status.gridy = 1;
      g_status.gridwidth = 50;
      g_status.gridheight = 50;
      g_status.weightx = 0;
      g_status.weighty = 0;
      g_status.ipadx = 25;
      g_status.ipady = 25;
      g_status.fill = GridBagConstraints.NONE;
      g_status.anchor = GridBagConstraints.CENTER;
      status_label.setFont(new Font("", Font.PLAIN, 15));
      add(status_label,g_status);
      
      GridBagConstraints g_run = new GridBagConstraints();
      g_run.gridx = 12;
      g_run.gridy = 51;
      g_run.gridwidth = 50;
      g_run.gridheight = 50;
      g_run.weightx = 0;
      g_run.weighty = 0;
      g_run.ipadx = 50;
      g_run.ipady = 25;
      g_run.fill = GridBagConstraints.NONE;
      g_run.anchor = GridBagConstraints.SOUTHWEST;
      run.setFont(new Font("", Font.PLAIN, 20));
      add(run,g_run);
      run.addActionListener(this);
      run.setFocusable(false);
      
      GridBagConstraints g_Input = new GridBagConstraints();
      g_Input.gridx = 0;
      g_Input.gridy = 1;
      g_Input.gridwidth = 10;
      g_Input.gridheight = 50;
      g_Input.weightx = 0;
      g_Input.weighty = 0;
      g_Input.fill = GridBagConstraints.NONE;
      g_Input.anchor = GridBagConstraints.WEST;
      inputTextArea.setFont(new Font("", Font.PLAIN, 20));
      add(putInTitledScrollPane(inputTextArea, "Input Text"),g_Input);
      
      GridBagConstraints g_Output = new GridBagConstraints();
      g_Output.gridx = 0;
      g_Output.gridy = 51;
      g_Output.gridwidth = 10;
      g_Output.gridheight = 50;
      g_Output.weightx = 0;
      g_Output.weighty = 0;
      g_Output.fill = GridBagConstraints.NONE;
      g_Output.anchor = GridBagConstraints.WEST;
      outputTextArea.setFont(new Font("", Font.PLAIN, 20));
      add(putInTitledScrollPane(outputTextArea, "Output Text"),g_Output);
      
      
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
       f.show();
       f.getContentPane().add(s);
       f.pack();
       f.setLocationByPlatform(false);
       f.setVisible(true); 
   }
   
   public void actionPerformed(ActionEvent e) {

	   if(e.getSource()==c3){
           int index = c3.getSelectedIndex();
           
           switch(index) {
			case 0:
				input_reset();
				output_reset();
				outputTextArea.setText("Using Manual input");
				break;
			case 1:
				input_reset();
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File("./data"));
				fileChooser.setMultiSelectionEnabled(false);
				
	            int response = fileChooser.showOpenDialog(null);
	            if(response == JFileChooser.APPROVE_OPTION){
	                path=fileChooser.getSelectedFile().getAbsolutePath();
	                Display.get_file_data(path);
	                content = Display.get_content(); 
	                outputTextArea.setText(fileChooser.getSelectedFile().getName()+" has been choose !");
	                inputTextArea.setText(content);
	            }    
	            inputTextArea.setEditable(false);
				break;
			case 2:
				input_reset();
				output_reset();
				
				String InputData_Sa= JOptionPane.showInputDialog(null,"Please input amount number");
				Scanner sc_Sa = new Scanner(InputData_Sa);	
				int as = sc_Sa.nextInt();
				
				String InputData_Sb= JOptionPane.showInputDialog(null,"Please input the min rage of data: ");
				Scanner sc_Sb = new Scanner(InputData_Sb);	
				int bs = sc_Sb.nextInt();
				
				String InputData_Sc= JOptionPane.showInputDialog(null,"Please input the max rage of data: ");
				Scanner sc_Sc = new Scanner(InputData_Sc);	
				int cs = sc_Sc.nextInt();
				
				
				
				Display.get_random_string(as, bs, cs);
				content = Display.get_content();
				inputTextArea.setText(content);
				inputTextArea.setEditable(false);
				outputTextArea.setText("Using Random String input");
				break;
				
			case 3:
				input_reset();
				output_reset();
				
				String InputData_Na= JOptionPane.showInputDialog(null,"Please input amount number");
				Scanner sc_Na = new Scanner(InputData_Na);	
				int an = sc_Na.nextInt();
				
				String InputData_Nb= JOptionPane.showInputDialog(null,"Please input the min rage of data: ");
				Scanner sc_Nb = new Scanner(InputData_Nb);	
				double bn = sc_Nb.nextInt();
				
				String InputData_Nc= JOptionPane.showInputDialog(null,"Please input the max rage of data: ");
				Scanner sc_Nc = new Scanner(InputData_Nc);	
				double cn = sc_Nc.nextInt();
				
				Display.get_random_num(an, bn, cn);
				content = Display.get_content();
				inputTextArea.setText(content);
				inputTextArea.setEditable(false);
				outputTextArea.setText("Using Random Number input");
				break;
			
		}
       }
	   
	   if(e.getSource()==c2){
           int index = c2.getSelectedIndex();
           
           switch(index) {
			case 0:
				type = 0;
				outputTextArea.setText("Using Insertion Sort");
				break;
			case 1:
				type = 1;
				outputTextArea.setText("Using Selection Sort");
				break;
		}
       }
	   
	   if(e.getSource()==b){
		   Display.get_previous_result(type,inputTextArea.getText());
		   content = Display.get_content();
		   outputTextArea.setText(content);
		   b2.setEnabled(true);
		   N_step--;
		   if(N_step==0) b.setEnabled(false);
		   if((N_step==step)&&(type==0)) b2.setEnabled(false);
		   else if((N_step==(step-1))&&(type==1)) b2.setEnabled(false);
		  
	   }
	   
	   if(e.getSource()==b2){
		   Display.get_next_result(type,inputTextArea.getText());
		   content = Display.get_content();
		   outputTextArea.setText(content);
		   b.setEnabled(true);
		   N_step++;
		   if((N_step==step)&&(type==0)) b2.setEnabled(false);
		   else if((N_step==(step-1))&&(type==1)) b2.setEnabled(false);
	   }
	   
	   if(e.getSource()==b4){
		   input_reset();
		   output_reset();
		   GUI_reset();
	   }
	   
	   if(e.getSource()==run){
		   if(type == 0) {
			   status_label.setText("Now using Insertion Sort");
		   }else if(type == 1) {
			   status_label.setText("Now using Selection Sort");
		   }
		   Display.start_sort(type ,inputTextArea.getText());
		   content = Display.get_content();
		   outputTextArea.setText(content);
		   inputTextArea.setEditable(false);
           inputTextArea.setFocusable(false);
           b.setEnabled(false);
		   b2.setEnabled(true);
		   c1.setEnabled(true);
		   c2.setEnabled(false);
		   c3.setEnabled(false);
		   Display.reset_log();
		   N_step=0;
		   step = Display.get_size(inputTextArea.getText());
	   }
	   
	}
   
   public void input_reset() {
	   content = "";
	   inputTextArea.setText(content);
	   inputTextArea.setEditable(true);
	   inputTextArea.setFocusable(true);
	   Display.reset_data();
   }
   
   public void output_reset() {
	   content = "";
	   outputTextArea.setText(content);
	   Display.reset_log();
   }
   
   public void GUI_reset() {
	   b2.setEnabled(false);
	   b.setEnabled(false);
	   c1.setEnabled(false);
	   c2.setEnabled(true);
	   c3.setEnabled(true);
	   status_label.setText("Welcome to Sort Program");
   }
   

   
   public static void main(String[] args) {
	   
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }

}


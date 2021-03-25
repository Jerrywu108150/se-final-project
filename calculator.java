import java.awt.*;
import javax.swing.*;

public class calculator extends JPanel {
   private static final int ROWS = 10;
   private static final int COLS = 50;
   private static final String[] BUTTON_NAMES = { "insertion sort", "reverse",
         "count number", "add number", "add randnum","search","edit","mean","median","quartile","sd" };
   private static final int GAP = 3;
   private JTextArea inputTextArea = new JTextArea(ROWS, COLS);
   private JTextArea outputTextArea = new JTextArea(ROWS, COLS);

   public calculator() {
      JPanel buttonPanel = new JPanel(new GridLayout(2, 6, GAP, 0));
      for (String btnName : BUTTON_NAMES) {
         buttonPanel.add(new JButton(btnName));
      }
      outputTextArea.setFocusable(false);
      outputTextArea.setEditable(false);

      setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
      add(buttonPanel);
      add(putInTitledScrollPane(inputTextArea, "Input Text"));
      add(putInTitledScrollPane(outputTextArea, "Output Text"));
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

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}
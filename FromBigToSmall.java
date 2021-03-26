import java.util.*;
import java.io.*;

public class FromBigToSmall extends InsertionSort {

    public FromBigToSmall(ArrayList<Integer> dataset) {
        super(dataset);
    }

    public void stepByStep() {
    	File f = new File("log.txt"); 
    	
        int cn=countNumber();
        
        try {
 		   BufferedWriter bw = new BufferedWriter( new FileWriter(f) );
 		   
 		   
 		  for (int i = 1; i < cn; i++) {
 	            int n = dataset.get(i);
 	            int j = i - 1;
 	            while (j >= 0 && dataset.get(j) < n) {
 	                dataset.set(j + 1, dataset.get(j));
 	                j--;
 	            }
 	            dataset.set(j + 1, n);
 	            
 	            System.out.print("Step " + i + ": ");
 	           bw.write("Step " + i + ": ");
 	            for (int k = 0; k < cn; k++) {
 	                System.out.print(dataset.get(k));
 	                int num = dataset.get(k);
 	                bw.write(""+num);
 	                if (k < cn - 1) {
 	                    System.out.print(" ");
 	                	bw.write(" ");
 	                }
 	            }
 	            System.out.println();
 	            bw.write("\r\n");
 	        }
 		   bw.flush();
 		   bw.close();
 		   
 	      } catch (IOException ex) {
 	         ex.printStackTrace();
 	      }
        
    }
    
    public void spinSlash() {
        int cn=countNumber();
        for (int i=1;i<cn;i++) {
            int n = dataset.get(i);
            int j = i - 1;
            while (j >= 0 && dataset.get(j) < n) {
                dataset.set(j + 1, dataset.get(j));
                j--;
            }
            dataset.set(j + 1, n);
        }
        for (int k = 0; k < cn; k++) {
            System.out.print(dataset.get(k));
            if (k < cn - 1)
                System.out.print(" ");
        }
        System.out.println();
    }
    
    public int timeComplexity() {
        int tc=0, cn=countNumber();
        ArrayList<Integer>copy=new ArrayList<Integer>(dataset);
        for (int i = 1; i < cn; i++) {
            int n = copy.get(i);
            int j = i - 1;
            tc++;
            while (j >= 0 && copy.get(j) < n) {
                copy.set(j + 1, copy.get(j));
                j--;
                tc++;
            }
            copy.set(j + 1, n);
        }
        return tc;
    }

}

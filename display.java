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

public class display {
	public String content;
	public Insertion insertion = null;
	public Selection selection = null;
	boolean ft = true;
	
	public void get_file_data(String path) {
        
		try {
        	Path Input_data = Paths.get(path);
        	content = Files.readString(Input_data);   
	 	} catch (IOException ex) {
	 		ex.printStackTrace();
	 	}
        
	}
	
	public void get_random_string(int amount, int n1, int n2) {
    	
    	try {
    		ArrayList<String> al=new ArrayList<String>();
    		Sort sort = new Sort();
    		sort.randomString(amount, n1, n2);
    		File f=new File("data.txt");
    		al = sort.getDataset();
    		BufferedWriter bw=new BufferedWriter(new FileWriter(f));
            for(int i=0;i<al.size();i++){
                bw.write(al.get(i)+" ");
                bw.flush();
            }
            bw.close();
            Path Input_data = Paths.get("data.txt");
        	content = Files.readString(Input_data);   
	 	} catch (IOException ex) {
	 		ex.printStackTrace();
	 	}
		
	}
	
	public void get_random_num(int amount, double n1, double n2) {
    	
    	try {
    		ArrayList<String> al=new ArrayList<String>();
    		Sort sort = new Sort();
    		sort.randomNumber(amount, n1, n2);
    		File f=new File("data.txt");
    		al = sort.getDataset();
    		BufferedWriter bw=new BufferedWriter(new FileWriter(f));
            for(int i=0;i<al.size();i++){
                bw.write(al.get(i)+" ");
                bw.flush();
            }
            bw.close();
            Path Input_data = Paths.get("data.txt");
        	content = Files.readString(Input_data);   
	 	} catch (IOException ex) {
	 		ex.printStackTrace();
	 	}
		
	}
	
	public void reset_data() {
    	
		try {
    		File f=new File("data.txt");
    		BufferedWriter bw=new BufferedWriter(new FileWriter(f));
            
            bw.write("");
            bw.flush();
            bw.close();
	 	} catch (IOException ex) {
	 		ex.printStackTrace();
	 	}
		ft = true;
		
	}
	
	public void reset_log() {
	public void reset_ft() {
    	
		try {
    		File f=new File("log.txt");
    		BufferedWriter bw=new BufferedWriter(new FileWriter(f));
            
            bw.write("");
            bw.flush();
            bw.close();
	 	} catch (IOException ex) {
	 		ex.printStackTrace();
	 	}
		ft = true;
	}
	
 Show 20 lines  Show all unchanged lines  Show 20 lines
		while(sc.hasNext()) {
			input.add(sc.next());
        }
		content = "";
		insertion = new Insertion(input);
		selection = new Selection(input);
		
        if(type == 0) {
        
        	insertion.aStepByStep();
        	
        	try {
        		ArrayList<String> al=new ArrayList<String>();
        		File f=new File("log.txt");
        		al = insertion.getResult();
        		BufferedWriter bw=new BufferedWriter(new FileWriter(f));
                for(int i=0;i<al.size();i++){
                    bw.write(al.get(i)+"\n\r");
                    bw.flush();
                }
                bw.close();
                Path Input_data = Paths.get("log.txt");
            	content = Files.readString(Input_data);   
    	 	} catch (IOException ex) {
    	 		ex.printStackTrace();
    	 	}
        	
        	ArrayList<String> al=new ArrayList<String>();
        		
        	al = insertion.getResult();
        		
            for(int i=0;i<al.size();i++){
              	content += al.get(i)+"\n\r";
            }  

        }else if(type == 1) {
        	
        	selection.aStepByStep();
        	
        	try {
        		ArrayList<String> al=new ArrayList<String>();
        		File f=new File("log.txt");
        		al = selection.getResult();
        		BufferedWriter bw=new BufferedWriter(new FileWriter(f));
                for(int i=0;i<al.size();i++){
                    bw.write(al.get(i)+"\n\r");
                    bw.flush();
                }
                bw.close();
                Path Input_data = Paths.get("log.txt");
            	content = Files.readString(Input_data);   
    	 	} catch (IOException ex) {
    	 		ex.printStackTrace();
    	 	}
        	
        	ArrayList<String> al=new ArrayList<String>();
        		
        	al = selection.getResult();
        		
            for(int i=0;i<al.size();i++){
                content += al.get(i)+"\n\r";
            }

        }
	}
	
	public int get_size(String data) {
		ArrayList<String> input=new ArrayList<String>();
		Scanner sc = new Scanner(data);
		while(sc.hasNext()) {
			input.add(sc.next());
        }
		return input.size();
	}
	
	public void get_previous_result(int type ,String data) {
    	System.out.println("previous");
    	
    	if(ft) {
			ArrayList<String> input=new ArrayList<String>();
			Scanner sc = new Scanner(data);
			while(sc.hasNext()) {
				input.add(sc.next());
			}
			insertion = new Insertion(input);
			selection = new Selection(input);
			ft = false;
		}
		
    	if(type==0) content =  insertion.previous();
    	else if(type==1) content =  selection.previous();
	}
	
	public void get_next_result(int type ,String data) {
		System.out.println("next");
		
		
		if(ft) {
			ArrayList<String> input=new ArrayList<String>();
			Scanner sc = new Scanner(data);
			while(sc.hasNext()) {
				input.add(sc.next());
			}
			insertion = new Insertion(input);
			selection = new Selection(input);
			ft = false;
		}
		if(type==0) content =  insertion.aNext();
		else if(type==1)content =  selection.aNext();
		
		
	}
	
	
	public String get_content() {
        return content;
	}
	

}

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class display {
	public String content;
	public Sort sort = null;
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
			ArrayList<String> al = new ArrayList<String>();
			sort = new Sort();
			sort.randomString(amount, n1, n2);
			File f = new File("data.txt");
			al = sort.getDataset();
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			for (int i = 0; i < al.size(); i++) {
				bw.write(al.get(i) + " ");
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
			ArrayList<String> al = new ArrayList<String>();
			sort = new Sort();
			sort.randomNumber(amount, n1, n2);
			File f = new File("data.txt");
			al = sort.getDataset();
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			for (int i = 0; i < al.size(); i++) {
				bw.write(al.get(i) + " ");
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
			File f = new File("data.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));

			bw.write("");
			bw.flush();
			bw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		ft = true;

	}

	public void reset_ft() {

		ft = true;
	}

	public void start_asort(int type, String data) {

		ArrayList<String> input = new ArrayList<String>();
		Scanner sc = new Scanner(data);
		while (sc.hasNext()) {
			input.add(sc.next());
		}
		sc.close();
		content = "";

		if (type == 0) {
			sort = new Insertion(input);
			sort.aStepByStep();

			ArrayList<String> al = new ArrayList<String>();

			al = sort.getResult();

			for (int i = 0; i < al.size(); i++) {
				content += al.get(i) + "\n\r";
			}

		} else if (type == 1) {
			sort = new Selection(input);
			sort.aStepByStep();

			ArrayList<String> al = new ArrayList<String>();

			al = sort.getResult();

			for (int i = 0; i < al.size(); i++) {
				content += al.get(i) + "\n\r";
			}

		}
	}
	
	public void start_dsort(int type, String data) {

		ArrayList<String> input = new ArrayList<String>();
		Scanner sc = new Scanner(data);
		while (sc.hasNext()) {
			input.add(sc.next());
		}
		sc.close();
		content = "";

		if (type == 0) {
			sort = new Insertion(input);
			sort.dStepByStep();

			ArrayList<String> al = new ArrayList<String>();

			al = sort.getResult();

			for (int i = 0; i < al.size(); i++) {
				content += al.get(i) + "\n\r";
			}

		} else if (type == 1) {
			sort = new Selection(input);
			sort.dStepByStep();

			ArrayList<String> al = new ArrayList<String>();

			al = sort.getResult();

			for (int i = 0; i < al.size(); i++) {
				content += al.get(i) + "\n\r";
			}

		}
	}

	public int get_size(String data) {
		ArrayList<String> input = new ArrayList<String>();
		Scanner sc = new Scanner(data);
		while (sc.hasNext()) {
			input.add(sc.next());
		}
		sc.close();
		return input.size();
	}

	public void get_previous_result(int type, String data) {


		if (type == 0)
			content = sort.previous();
		else if (type == 1)
			content = sort.previous();
	}

	public void get_next_result(int ad,int type, String data) {

		if (ft) {
			ArrayList<String> input = new ArrayList<String>();
			Scanner sc = new Scanner(data);
			while (sc.hasNext()) {
				input.add(sc.next());
			}
			sc.close();
			if (type == 0)
				sort = new Insertion(input);
			else if (type == 1)
				sort = new Selection(input);

			ft = false;
		}
		if (ad == 0) {
			if (type == 0) 
				content = sort.aNext();
			else if (type == 1)
				content = sort.aNext();
		}else if(ad == 1) {
			if (type == 0)
				content = sort.dNext();
			else if (type == 1)
				content = sort.dNext();
		}
	}

	public String get_content() {
		return content;
	}

}
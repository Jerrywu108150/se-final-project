import java.util.*;
import java.io.*;

public class InsertionSort {
    protected int stepCount = 0;
    protected ArrayList<Integer> dataset;
    protected ArrayList<String> record = new ArrayList<String>();

    public InsertionSort(ArrayList<Integer> dataset) {
        this.dataset = new ArrayList<Integer>(dataset);
    }

    public boolean display() {
        if (countNumber() == 0)
            return false;
        int cn = countNumber();
        File f = new File("data.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            for (int i = 0; i < cn; i++) {
                int num = dataset.get(i);
                bw.write("" + num);
                System.out.print(dataset.get(i));
                if (i < cn - 1) {
                    bw.write(" ");
                    System.out.print(" ");
                }
            }
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public boolean reverse() {
        if (countNumber() == 0)
            return false;
        File f = new File("log.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write("display the dataset in reverse: ");
            for (int i = countNumber() - 1; i >= 0; i--) {
                int num = dataset.get(i);
                bw.write("" + num);
                System.out.print(dataset.get(i));
                if (i > 0) {
                    bw.write(" ");
                    System.out.print(" ");
                }
            }
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public int countNumber() {
        return dataset.size();
    }

    public boolean addNumber(int... newNumber) {
        if (newNumber.length == 0)
            return false;
        stepCount = 0;
        int nl = newNumber.length;
        String str = "Current dataset:";
        for (int i = 0; i < nl; i++) {
            dataset.add(i);
            str += Integer.toString(i);
            if (i < nl - 1)
                str += " ";
        }
        record.add(str);
        return true;
    }

    public boolean random(int amount, int n1, int n2) {
        if (amount <= 0)
            return false;
        int max, min;
        if (n1 > n2) {
            max = n1;
            min = n2;
        } else {
            max = n2;
            min = n1;
        }
        for (int i = 0; i < amount; i++)
            addNumber((int) (Math.random() * (max - min + 1) + min));
        return true;
    }

    public boolean search(int n1, int n2) {
        boolean notEmpty = false;
        int max, min, cn = countNumber();
        if (n1 > n2) {
            max = n1;
            min = n2;
        } else {
            max = n2;
            min = n1;
        }
        File f = new File("log.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write("data in the range: ");
            for (int i = 0; i < cn; i++) {
                int di = dataset.get(i);
                if (di <= max && di >= min) {
                    bw.write("" + di + " ");
                    System.out.print(di + " ");
                    if (!notEmpty)
                        notEmpty = true;
                }
            }
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println();
        return notEmpty;
    }

    public boolean edit(int target, int modify) {
        boolean targetExist = false;
        int cn = countNumber();
        for (int i = 0; i < cn; i++)
            if (dataset.get(i) == target) {
                dataset.set(i, modify);
                if (!targetExist)
                    targetExist = true;
            }
        return targetExist;
    }

    public boolean delete(int target) {
        boolean targetExist = false;
        int cn = countNumber();
        for (int i = 0; i < cn; i++)
            if (dataset.get(i) == target) {
                dataset.remove(i);
                cn--;
                i--;
                if (!targetExist)
                    targetExist = true;
            }
        return targetExist;
    }

    public double mean() {
        double sum = 0;
        int cn = countNumber();
        for (int i = 0; i < cn; i++)
            sum += dataset.get(i);
        return sum / cn;
    }

    public int median() {
        int cn = countNumber();
        if (cn % 2 == 0)
            return (int) Math.round((dataset.get(cn / 2 - 1) + dataset.get(cn / 2)) / 2);
        else
            return dataset.get(cn / 2);
    }

    public int[] quartile() {
        int cn = countNumber();
        int[] q = new int[3];
        q[1] = median();
        if (cn % 4 == 0) {
            q[0] = (int) Math.round((dataset.get(cn / 4 - 1) + dataset.get(cn / 4)) / 2);
            q[2] = (int) Math.round((dataset.get(cn / 4 * 3 - 1) + dataset.get(cn / 4 * 3)) / 2);
        } else {
            q[0] = dataset.get(cn / 4);
            q[2] = dataset.get(cn - cn / 4 - 1);
        }
        return q;
    }

    public double sd() {
        int m = (int) Math.round(mean());
        int cn = countNumber();
        int v = 0;
        for (int i = 0; i < cn; i++)
            v += Math.pow(dataset.get(i), 2);
        return Math.sqrt(v / cn - m * m);
    }

    public double[] ci(double sd_num) {
        double sd = sd();
        double mean = mean();
        double[] ci_range = new double[2];
        ci_range[0] = mean - sd * sd_num;
        ci_range[1] = mean + sd * sd_num;
        return ci_range;
    }

    public double ppmcc() {
        int cn = countNumber();
        int x = 0, y = 0;
        for (int i = 0; i < cn; i++) {
            x += dataset.get(i);
            y += dataset.get(i);
        }
        int Sxy = x * y - cn * x / cn * y / cn;
        return Sxy / (Math.sqrt(Math.pow(x, 2) * (cn - 1) / cn) * Math.pow(y, 2) * (cn - 1) / cn);
    }

    public boolean previous() {
        record.remove(record.size() - 1);
        if (record.size() == 0)
            return false;
        String str = record.get(record.size() - 1);
        System.out.println(str);
        if (str.substring(0, 4).equals("Step") || str.substring(0, 16).equals("Current dataset:")) {
            if (stepCount > 0)
                stepCount--;
            dataset.clear();
            StringTokenizer st = new StringTokenizer(str);
            st.nextToken();
            st.nextToken();
            while (st.hasMoreTokens()) {
                dataset.add(Integer.parseInt(st.nextToken()));
            }
        }
        return true;
    }
}

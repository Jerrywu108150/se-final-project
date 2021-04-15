import java.util.*;
import java.io.*;

public class tool {

    public boolean addNumber(int... newNumber) {
        if (newNumber.length == 0)
            return false;
        stepCount = 0;
        int nl = newNumber.length;
        String str = "Current dataset:";
        for (int i = 0; i < nl; i++) {
            dataset.add(newNumber[i]);
            str += Integer.toString(i);
            if (i < nl - 1)
                str += " ";
        }
        record.add(str);
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

}

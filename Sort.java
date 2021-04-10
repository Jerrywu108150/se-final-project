import java.util.*;

public class Sort {
    protected int stepCount = 0;
    protected ArrayList<String> dataset;
    protected ArrayList<String> result = new ArrayList<String>();
    protected ArrayList<String> record = new ArrayList<String>();

    public Sort() {
        dataset = new ArrayList<String>();
    }

    public Sort(ArrayList<String> input) {
        dataset = new ArrayList<String>(input);
        String temp = "Before sort:";
        for (String str : input) {
            temp += "  " + str;
        }
        record.add(temp);
    }

    public Sort(String... input) {
        dataset = new ArrayList<String>();
        String temp = "Before sort:";
        for (String str : input) {
            dataset.add(str);
            temp += "  " + str;
        }
        record.add(temp);
    }

    public ArrayList<String> getResult() {
        return result;
    }

    public ArrayList<String> getDataset() {
        return dataset;
    }

    public boolean addString(String... input) {
        if (input.length == 0) {
            return false;
        }
        stepCount = 0;
        record.clear();
        for (String str : input) {
            dataset.add(str);
        }
        String temp = "Before sort:";
        for (String str : dataset) {
            temp += "  " + str;
        }
        record.add(temp);
        return true;
    }

    public boolean random(int amount, double n1, double n2) {
        if (amount < 1)
            return false;
        double max, min;
        if (n1 > n2) {
            max = n1;
            min = n2;
        } else {
            max = n2;
            min = n1;
        }
        stepCount = 0;
        record.clear();
        for (int i = 0; i < amount; i++) {
            addString(Double.toString(Math.random() * (max - min + 1) + min));
        }
        String temp = "Before sort:";
        for (String str : dataset) {
            temp += "  " + str;
        }
        record.add(temp);
        return true;
    }

    public String previous() {
        if (record.size() == 1) {
            return null;
        }
        record.remove(stepCount--);
        String temp = record.get(record.size() - 1);
        dataset.clear();
        StringTokenizer st = new StringTokenizer(temp);
        st.nextToken();
        st.nextToken();
        while (st.hasMoreTokens()) {
            dataset.add(st.nextToken());
        }
        return temp;
    }

}
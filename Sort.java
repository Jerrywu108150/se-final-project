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
    }

    public Sort(String... input) {
        dataset = new ArrayList<String>();
        for (String i : input) {
            dataset.add(i);
        }
    }

    public ArrayList<String> getResult() {
        return result;
    }

    public ArrayList<String> getDataset() {
        return dataset;
    }

    public boolean addString(String... input) {
        if (input.length == 0)
            return false;
        for (String i : input) {
            dataset.add(i);
        }
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
        for (int i = 0; i < amount; i++)
            addString(Double.toString(Math.random() * (max - min + 1) + min));
        return true;
    }

    public String previous() {
        record.remove(record.size() - 1);
        if (record.size() == 0)
            return null;
        String temp = record.get(record.size() - 1);
        if (temp.substring(0, 4).equals("Step") || temp.substring(0, 16).equals("Current dataset:")) {
            if (stepCount > 0)
                stepCount--;
            dataset.clear();
            StringTokenizer st = new StringTokenizer(temp);
            st.nextToken();
            st.nextToken();
            while (st.hasMoreTokens()) {
                dataset.add(st.nextToken());
            }
        }
        return temp;
    }

}
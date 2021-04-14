import java.util.*;

public class Sort {
    protected int stepCount = 0;
    protected boolean isNumber = false;
    protected ArrayList<String> dataset;
    protected ArrayList<String> result = new ArrayList<String>();
    protected ArrayList<String> record = new ArrayList<String>();

    public Sort() {
        dataset = new ArrayList<String>();
        isNumber = judgeType();
    }

    public Sort(ArrayList<String> input) {
        dataset = new ArrayList<String>(input);
        String temp = "Before sort:";
        for (String str : input) {
            temp += "  " + str;
        }
        record.add(temp);
        isNumber = judgeType();
    }

    public Sort(String... input) {
        dataset = new ArrayList<String>();
        String temp = "Before sort:";
        for (String str : input) {
            dataset.add(str);
            temp += "  " + str;
        }
        record.add(temp);
        isNumber = judgeType();
    }

    public boolean judgeType() {
        for (String i : dataset) {
            if (i.charAt(0) != '-' && (i.charAt(0) < '0' || i.charAt(0) > '9')) {
                return false;
            } else if (i.indexOf("-") != i.lastIndexOf("-")) {
                return false;
            } else if (i.indexOf(".") != i.lastIndexOf(".")) {
                return false;
            } else if (i.indexOf(".") == i.length() - 1) {
                return false;
            }
            for (char j : i.toCharArray()) {
                if (j != '-' && j != '.' && (j < '0' || j > '9')) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean getIsNumber() {
        return isNumber;
    }

    public ArrayList<String> getResult() {
        return result;
    }

    public ArrayList<String> getDataset() {
        return dataset;
    }

    public ArrayList<String> getRecord() {
        return record;
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
            temp += "\t" + str;
        }
        record.add(temp);
        isNumber = judgeType();
        return true;
    }

    public boolean randomNumber(int amount, double n1, double n2) {
        if (amount < 1) {
            return false;
        }
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
        Random r = new Random();
        String d = new String();
        for (int i = 0; i < amount; i++) {
            d = Double.toString(Math.random() * (max - min) + min);
            switch (r.nextInt(3)) {
            case 0:
                d = d.substring(0, d.indexOf("."));
                break;
            case 1:
                d = d.substring(0, d.indexOf(".") + 2);
                break;
            case 2:
                d = d.substring(0, d.indexOf(".") + 3);
            }
            dataset.add(d);
        }
        String temp = "Before sort:";
        for (String str : dataset) {
            temp += "  " + str;
        }
        record.add(temp);
        isNumber = judgeType();
        return true;
    }

    public boolean randomString(int amount, int n1, int n2) {
        if (amount < 1 || n1 < 1 || n2 < 1) {
            return false;
        }
        int max, min;
        if (n1 > n2) {
            max = n1;
            min = n2;
        } else {
            max = n2;
            min = n1;
        }
        stepCount = 0;
        record.clear();
        Random r = new Random();
        for (int i = 0; i < amount; i++) {
            int size = r.nextInt(max - min + 1) + min;
            String d = new String();
            for (int j = 0; j < size; j++) {
                d += (char) (r.nextInt(94) + 33);
            }
            dataset.add(d);
        }
        String temp = "Before sort:";
        for (String str : dataset) {
            temp += "  " + str;
        }
        record.add(temp);
        isNumber = false;
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

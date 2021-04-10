import java.util.ArrayList;

public class InsertionAscend extends Insertion {
    public InsertionAscend() {
        super();
    }

    public InsertionAscend(ArrayList<String> input) {
        super(input);
    }

    public InsertionAscend(String... input) {
        super(input);
    }

    public boolean stepByStep() {
        if (dataset.size() < 2) {
            return false;
        }
        result.clear();
        int size = dataset.size();
        for (int i = 1; i < size; i++) {
            String temp = dataset.get(i);
            int j = i - 1;
            while (j >= 0 && dataset.get(j).compareTo(temp) > 0) {
                dataset.set(j + 1, dataset.get(j));
                j--;
            }
            dataset.set(j + 1, temp);
            String step = "Step " + i + ":";
            for (String str : dataset) {
                step += "  " + str;
            }
            result.add(step);
        }
        return true;
    }

    public int timeComplexity() {
        int count = 0, size = dataset.size();
        ArrayList<String> copy = new ArrayList<String>(dataset);
        for (int i = 1; i < size; i++) {
            String temp = copy.get(i);
            int j = i - 1;
            count++;
            while (j >= 0 && copy.get(j).compareTo(temp) > 0) {
                copy.set(j + 1, copy.get(j));
                j--;
                count++;
            }
            copy.set(j + 1, temp);
        }
        return count;
    }

    public String next() {
        stepCount++;
        if (stepCount >= dataset.size() || dataset.size() < 2) {
            return null;
        }
        String temp = dataset.get(stepCount);
        int j = stepCount - 1;
        while (j >= 0 && dataset.get(j).compareTo(temp) > 0) {
            dataset.set(j + 1, dataset.get(j));
            j--;
        }
        dataset.set(j + 1, temp);
        String step = "Step " + stepCount + ":";
        for (String str : dataset) {
            step += "  " + str;
        }
        record.add(step);
        return step;
    }

}
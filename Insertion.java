import java.util.*;

public class Insertion extends Sort {
    public Insertion() {
        super();
    }

    public Insertion(ArrayList<String> input) {
        super(input);
    }

    public Insertion(String... input) {
        super(input);
    }

    public boolean aStepByStep() {
        if (dataset.size() < 2) {
            return false;
        }
        result.clear();
        int size = dataset.size();
        for (; stepCount < size; stepCount++) {
            String temp = dataset.get(stepCount);
            int j = stepCount - 1;
            if (isNumber) {
                while (j >= 0 && Double.parseDouble(dataset.get(j)) > Double.parseDouble(temp)) {
                    dataset.set(j + 1, dataset.get(j));
                    j--;
                }
            } else {
                while (j >= 0 && dataset.get(j).compareTo(temp) > 0) {
                    dataset.set(j + 1, dataset.get(j));
                    j--;
                }
            }
            dataset.set(j + 1, temp);
            String step = "Step " + stepCount + ":";
            for (String str : dataset) {
                step += "  " + str;
            }
            result.add(step);
        }
        return true;
    }

    public int aTimeComplexity() {
        int count = 0, size = dataset.size();
        ArrayList<String> copy = new ArrayList<String>(dataset);
        for (int i = 1; i < size; i++) {
            String temp = copy.get(i);
            int j = i - 1;
            count++;
            if (isNumber) {
                while (j >= 0 && Double.parseDouble(copy.get(j)) > Double.parseDouble(temp)) {
                    copy.set(j + 1, copy.get(j));
                    j--;
                    count++;
                }
            } else {
                while (j >= 0 && copy.get(j).compareTo(temp) > 0) {
                    copy.set(j + 1, copy.get(j));
                    j--;
                    count++;
                }
            }
            copy.set(j + 1, temp);
        }
        return count;
    }

    public String aNext() {
        if (stepCount == dataset.size() - 1 || dataset.size() < 2) {
            return null;
        }
        String temp = dataset.get(++stepCount);
        int j = stepCount - 1;
        if (isNumber) {
            while (j >= 0 && Double.parseDouble(dataset.get(j)) > Double.parseDouble(temp)) {
                dataset.set(j + 1, dataset.get(j));
                j--;
            }
        } else {
            while (j >= 0 && dataset.get(j).compareTo(temp) > 0) {
                dataset.set(j + 1, dataset.get(j));
                j--;
            }
        }
        dataset.set(j + 1, temp);
        String step = "Step " + stepCount + ":";
        for (String str : dataset) {
            step += "  " + str;
        }
        record.add(step);
        return step;
    }

    public boolean dStepByStep() {
        if (dataset.size() < 2) {
            return false;
        }
        result.clear();
        int size = dataset.size();
        for (; stepCount < size; stepCount++) {
            String temp = dataset.get(stepCount);
            int j = stepCount - 1;
            if (isNumber) {
                while (j >= 0 && Double.parseDouble(dataset.get(j)) < Double.parseDouble(temp)) {
                    dataset.set(j + 1, dataset.get(j));
                    j--;
                }
            } else {
                while (j >= 0 && dataset.get(j).compareTo(temp) < 0) {
                    dataset.set(j + 1, dataset.get(j));
                    j--;
                }
            }
            dataset.set(j + 1, temp);
            String step = "Step " + stepCount + ":";
            for (String str : dataset) {
                step += "  " + str;
            }
            result.add(step);
        }
        return true;
    }

    public int dTimeComplexity() {
        int count = 0, size = dataset.size();
        ArrayList<String> copy = new ArrayList<String>(dataset);
        for (int i = 1; i < size; i++) {
            String temp = copy.get(i);
            int j = i - 1;
            count++;
            if (isNumber) {
                while (j >= 0 && Double.parseDouble(copy.get(j)) < Double.parseDouble(temp)) {
                    copy.set(j + 1, copy.get(j));
                    j--;
                    count++;
                }
            } else {
                while (j >= 0 && copy.get(j).compareTo(temp) < 0) {
                    copy.set(j + 1, copy.get(j));
                    j--;
                    count++;
                }
            }
            copy.set(j + 1, temp);
        }
        return count;
    }

    public String dNext() {
        if (stepCount == dataset.size() - 1 || dataset.size() < 2) {
            return null;
        }
        String temp = dataset.get(++stepCount);
        int j = stepCount - 1;
        if (isNumber) {
            while (j >= 0 && Double.parseDouble(dataset.get(j)) < Double.parseDouble(temp)) {
                dataset.set(j + 1, dataset.get(j));
                j--;
            }
        } else {
            while (j >= 0 && dataset.get(j).compareTo(temp) < 0) {
                dataset.set(j + 1, dataset.get(j));
                j--;
            }
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
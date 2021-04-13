import java.util.*;

public class Selection extends Sort {
    public Selection() {
        super();
    }

    public Selection(ArrayList<String> input) {
        super(input);
    }

    public Selection(String... input) {
        super(input);
    }

    public boolean aStepByStep() {
        if (dataset.size() < 2) {
            return false;
        }
        result.clear();
        int size = dataset.size();
        for (int target; stepCount < size - 1; stepCount++) {
            target = stepCount;
            if (isNumber) {
                for (int j = stepCount + 1; j < size; j++) {
                    if (Double.parseDouble(dataset.get(j)) < Double.parseDouble(dataset.get(target))) {
                        target = j;
                    }
                }
            } else {
                for (int j = stepCount + 1; j < size; j++) {
                    if (dataset.get(j).compareTo(dataset.get(target)) < 0) {
                        target = j;
                    }
                }
            }
            if (target != stepCount) {
                String temp = dataset.get(target);
                dataset.set(target, dataset.get(stepCount));
                dataset.set(stepCount, temp);
            }
            String step = "Step " + stepCount + ":";
            for (String str : dataset) {
                step += "  " + str;
            }
            result.add(step);
        }
        return true;
    }

    public int aTimeComplexity() {
        return dataset.size() * (dataset.size() - 1) / 2;
    }

    public String aNext() {
        if (stepCount == dataset.size() - 1 || dataset.size() < 2) {
            return null;
        }
        int size = dataset.size(), target = stepCount;
        if (isNumber) {
            for (int j = stepCount + 1; j < size; j++) {
                if (Double.parseDouble(dataset.get(j)) < Double.parseDouble(dataset.get(target))) {
                    target = j;
                }
            }
        } else {
            for (int j = stepCount + 1; j < size; j++) {
                if (dataset.get(j).compareTo(dataset.get(target)) < 0) {
                    target = j;
                }
            }
        }
        if (target != stepCount) {
            String temp = dataset.get(target);
            dataset.set(target, dataset.get(stepCount));
            dataset.set(stepCount, temp);
        }
        String step = "Step " + (++stepCount) + ":";
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
        for (int target; stepCount < size - 1; stepCount++) {
            target = stepCount;
            if (isNumber) {
                for (int j = stepCount + 1; j < size; j++) {
                    if (Double.parseDouble(dataset.get(j)) > Double.parseDouble(dataset.get(target))) {
                        target = j;
                    }
                }
            } else {
                for (int j = stepCount + 1; j < size; j++) {
                    if (dataset.get(j).compareTo(dataset.get(target)) > 0) {
                        target = j;
                    }
                }
            }
            if (target != stepCount) {
                String temp = dataset.get(target);
                dataset.set(target, dataset.get(stepCount));
                dataset.set(stepCount, temp);
            }
            String step = "Step " + stepCount + ":";
            for (String str : dataset) {
                step += "  " + str;
            }
            result.add(step);
        }
        return true;
    }

    public int dTimeComplexity() {
        return dataset.size() * (dataset.size() - 1) / 2;
    }

    public String dNext() {
        if (stepCount == dataset.size() - 1 || dataset.size() < 2) {
            return null;
        }
        int size = dataset.size(), target = stepCount;
        if (isNumber) {
            for (int j = stepCount + 1; j < size; j++) {
                if (Double.parseDouble(dataset.get(j)) > Double.parseDouble(dataset.get(target))) {
                    target = j;
                }
            }
        } else {
            for (int j = stepCount + 1; j < size; j++) {
                if (dataset.get(j).compareTo(dataset.get(target)) > 0) {
                    target = j;
                }
            }
        }
        if (target != stepCount) {
            String temp = dataset.get(target);
            dataset.set(target, dataset.get(stepCount));
            dataset.set(stepCount, temp);
        }
        String step = "Step " + (++stepCount) + ":";
        for (String str : dataset) {
            step += "  " + str;
        }
        record.add(step);
        return step;
    }

}
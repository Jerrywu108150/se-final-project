import java.util.ArrayList;

public class SelectionAscend extends Selection {
    public SelectionAscend() {
        super();
    }

    public SelectionAscend(ArrayList<String> input) {
        super(input);
    }

    public SelectionAscend(String... input) {
        super(input);
    }

    public boolean stepByStep() {
        if (dataset.size() < 2) {
            return false;
        }
        result.clear();
        int size = dataset.size();
        for (int target; stepCount < size - 1; stepCount++) {
            target = stepCount;
            for (int j = stepCount + 1; j < size; j++) {
                if (dataset.get(j).compareTo(dataset.get(target)) < 0) {
                    target = j;
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

    public int timeComplexity() {
        return dataset.size() * (dataset.size() - 1) / 2;
    }

    public String next() {
        if (stepCount == dataset.size() - 1 || dataset.size() < 2) {
            return null;
        }
        int size = dataset.size(), target = stepCount;
        for (int j = stepCount + 1; j < size; j++) {
            if (dataset.get(j).compareTo(dataset.get(target)) < 0) {
                target = j;
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
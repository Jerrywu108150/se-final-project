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
        for (int i = 0, target; i < size - 1; i++) {
            target = i;
            for (int j = i + 1; j < size; j++) {
                if (dataset.get(j).compareTo(dataset.get(target)) < 0) {
                    target = j;
                }
            }
            if (target != i) {
                String temp = dataset.get(target);
                dataset.set(target, dataset.get(i));
                dataset.set(i, temp);
            }
            String step = "Step " + i + ":";
            for (String str : dataset) {
                step += "  " + str;
            }
            result.add(step);
        }
        return true;
    }

}
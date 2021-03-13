import java.util.*;

public class FromSmallToBig extends InsertionSort {

    public FromSmallToBig(ArrayList<Integer> dataset) {
        super(dataset);
    }

    public void stepByStep() {
        for (int i = 1; i < countNumber(); i++) {
            int n = dataset.get(i);
            int j = i - 1;
            while (j >= 0 && dataset.get(j) > n) {
                dataset.set(j + 1, dataset.get(j));
                j--;
            }
            dataset.set(j + 1, n);
            System.out.print("Step " + i + ": ");
            for (int k = 0; k < countNumber(); k++) {
                System.out.print(dataset.get(k));
                if (k < countNumber() - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

}

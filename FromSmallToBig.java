import java.util.*;

public class FromSmallToBig extends InsertionSort {

    public FromSmallToBig(ArrayList<Integer> dataset) {
        super(dataset);
    }

    public void stepByStep() {
        int cn=countNumber();
        for (int i = 1; i < cn; i++) {
            int n = dataset.get(i);
            int j = i - 1;
            while (j >= 0 && dataset.get(j) > n) {
                dataset.set(j + 1, dataset.get(j));
                j--;
            }
            dataset.set(j + 1, n);
            System.out.print("Step " + i + ": ");
            for (int k = 0; k < cn; k++) {
                System.out.print(dataset.get(k));
                if (k < cn - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    public void spinSlash() {
        int cn=countNumber();
        for (int i=1;i<cn;i++) {
            int n = dataset.get(i);
            int j = i - 1;
            while (j >= 0 && dataset.get(j) > n) {
                dataset.set(j + 1, dataset.get(j));
                j--;
            }
            dataset.set(j + 1, n);
        }
        for (int k = 0; k < cn; k++) {
            System.out.print(dataset.get(k));
            if (k < cn - 1)
                System.out.print(" ");
        }
        System.out.println();
    }
    
    public int timeComplexity() {
        int tc=0, cn=countNumber();
        ArrayList<Integer>copy=new ArrayList<Integer>(dataset);
        for (int i = 1; i < cn; i++) {
            int n = copy.get(i);
            int j = i - 1;
            tc++;
            while (j >= 0 && copy.get(j) > n) {
                copy.set(j + 1, copy.get(j));
                j--;
                tc++;
            }
            copy.set(j + 1, n);
        }
        return tc;
    }

}

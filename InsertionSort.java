import java.util.*;

public class InsertionSort {

    protected ArrayList<Integer> dataset;

    public InsertionSort(ArrayList<Integer> dataset) {
        this.dataset = new ArrayList<Integer>(dataset);
    }

    public int countNumber() {
        return dataset.size();
    }

}
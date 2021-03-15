import java.util.*;

public class InsertionSort {

    protected ArrayList<Integer> dataset;
    private Scanner sc=new Scanner(System.in);

    public InsertionSort(ArrayList<Integer> dataset) {
        this.dataset = new ArrayList<Integer>(dataset);
    }

    public int countNumber() {
        return dataset.size();
    }

    public void addNumber(int newNumber) {
        dataset.add(newNumber);
    }

    public void reverse() {
        for(int i=countNumber()-1;i>=0;i--) {
            System.out.print(dataset.get(i));
            if(i>0)System.out.print(" ");
        }
        System.out.println();
    }

    public void search() {
        int max=sc.nextInt();
        int min=sc.nextInt();
        for(int i=0;i<countNumber();i++)
        if(dataset.get(i)<=max&&dataset.get(i)>=min)
        System.out.print(dataset.get(i)+" ");
        System.out.println();
    }

    public void edit() {
        int target=sc.nextInt();
        int modify=sc.nextInt();
        boolean empty=true;
        for(int i=0;i<countNumber();i++) {
            if(dataset.get(i)==target){
            dataset.set(i,modify);
            empty=false;
            }
        }
        if(empty)edit();
    }


}

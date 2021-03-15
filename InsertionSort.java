import java.util.*;

public class InsertionSort {

    protected ArrayList<Integer> dataset;
    private Scanner sc=new Scanner(System.in);

    public InsertionSort(ArrayList<Integer> dataset) {
        this.dataset = new ArrayList<Integer>(dataset);
    }
    
    public void display(){
        for(int i=0;i<countNumber();i++){
            System.out.print(dataset.get(i));
            if(i<countNumber()-1)System.out.print(" ");
        }
        System.out.println();
    }
    
    public void reverse() {
        for(int i=countNumber()-1;i>=0;i--) {
            System.out.print(dataset.get(i));
            if(i>0)System.out.print(" ");
        }
        System.out.println();
    }

    public int countNumber() {
        return dataset.size();
    }

    public void addNumber(int newNumber) {
        dataset.add(newNumber);
    }
    
    public void random(int amount, int n1, int n2) {
        int max, min;
        if(n1>n2){
            max=n1;
            min=n2;
        }else{
            max=n2;
            min=n1;
        }
        for(int i=0;i<amount;i++)
        addNumber((int)(Math.random()*(max-min+1)+min));
    }
    
    public boolean search(int n1, int n2) {
        boolean notEmpty=false;
        int max,min;
        if(n1>n2){
            max=n1;
            min=n2;
        }else{
            max=n2;
            min=n1;
        }
        for(int i=0;i<countNumber();i++)
        if(dataset.get(i)<=max&&dataset.get(i)>=min){
            System.out.print(dataset.get(i)+" ");
            notEmpty=true;
        }
        System.out.println();
        return notEmpty;
    }

    public boolean edit(int target, int modify) {
        boolean targetExist=false;
        for(int i=0;i<countNumber();i++)
        if(dataset.get(i)==target) {
            dataset.set(i,modify);
            targetExist=true;
        }
        return targetExist;
    }
    
    public boolean delete(int target) {
        boolean targetExist=false;
        for(int i=0;i<countNumber();i++)
        if(dataset.get(i)==target){
            dataset.remove(i);
            targetExist=true;
        }
        return targetExist;
    }
    
    public double mean() {
        double sum=0;
        for(int i=0;i<countNumber();i++)
        sum+=dataset.get(i);
        return sum/countNumber();
    }
    
}
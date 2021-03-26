import java.util.*;

public class InsertionSort {

    protected ArrayList<Integer> dataset;

    public InsertionSort(ArrayList<Integer> dataset) {
        this.dataset = new ArrayList<Integer>(dataset);
    }

    public void display() {
        int cn = countNumber();
        for (int i = 0; i < cn; i++) {
            System.out.print(dataset.get(i));
            if (i < cn - 1)
                System.out.print(" ");
        }
        System.out.println();
    }

    public void reverse() {
        for (int i = countNumber() - 1; i >= 0; i--) {
            System.out.print(dataset.get(i));
            if (i > 0)
                System.out.print(" ");
        }
        System.out.println();
    }

    public int countNumber() {
        return dataset.size();
    }

    public void addNumber(int... newNumber) {
        for (int i : newNumber) {
            dataset.add(i);
        }
    }

    public boolean random(int amount, int n1, int n2) {
        if (amount <= 0)
            return false;
        int max, min;
        if (n1 > n2) {
            max = n1;
            min = n2;
        } else {
            max = n2;
            min = n1;
        }
        for (int i = 0; i < amount; i++)
            addNumber((int) (Math.random() * (max - min + 1) + min));
        return true;
    }

    public boolean search(int n1, int n2) {
        boolean notEmpty = false;
        int max, min, cn = countNumber();
        if (n1 > n2) {
            max = n1;
            min = n2;
        } else {
            max = n2;
            min = n1;
        }
        for (int i = 0; i < cn; i++) {
            int di = dataset.get(i);
            if (di <= max && di >= min) {
                System.out.print(di + " ");
                if (!notEmpty)
                    notEmpty = true;
            }
        }
        System.out.println();
        return notEmpty;
    }

    public boolean edit(int target, int modify) {
        boolean targetExist = false;
        int cn = countNumber();
        for (int i = 0; i < cn; i++)
            if (dataset.get(i) == target) {
                dataset.set(i, modify);
                if (!targetExist)
                    targetExist = true;
            }
        return targetExist;
    }

    public boolean delete(int target) {
        boolean targetExist = false;
        int cn = countNumber();
        for (int i = 0; i < cn; i++)
            if (dataset.get(i) == target) {
                dataset.remove(i);
                cn--;
                i--;
                if (!targetExist)
                    targetExist = true;
            }
        return targetExist;
    }

    public double mean() {
        double sum = 0;
        int cn = countNumber();
        for (int i = 0; i < cn; i++)
            sum += dataset.get(i);
        return sum / cn;
    }

    public int median() {
        int cn = countNumber();
        if (cn % 2 == 0)
            return (int) Math.round((dataset.get(cn / 2 - 1) + dataset.get(cn / 2)) / 2);
        else
            return dataset.get(cn / 2);
    }

    public void quartile() {
        int first, third, cn = countNumber();
        if (cn % 4 == 0) {
            first = (int) Math.round((dataset.get(cn / 4 - 1) + dataset.get(cn / 4)) / 2);
            third = (int) Math.round((dataset.get(cn / 4 * 3 - 1) + dataset.get(cn / 4 * 3)) / 2);
        } else {
            first = dataset.get(cn / 4);
            third = dataset.get(cn - cn / 4 - 1);
        }
        System.out.printf("%d %d %d", first, median(), third);
    }

    public double sd() {
        int m = (int) Math.round(mean());
        int cn = countNumber();
        int v = 0;
        for (int i = 0; i < cn; i++)
            v += Math.pow(dataset.get(i), 2);
        return Math.sqrt(v / cn - m * m);
    }

    /*confidence interval, CI(幾個標準差)*/
	public static double[] ci(double sd_num){
		/*一個標準差區間 68.2%*/
		/*兩個標準差區間 95.4%*/
		/*兩個標準差區間 99.7%*/
		double sd = getstandardDeviaction();
		double mean = getMeanValue();
		
		/*[0]信賴區間下限 [1]信賴區間上限*/
		double [] ci_range = new double[2];
		ci_range[0] = mean - sd*sd_num;
		ci_range[1] = mean + sd*sd_num;
	    return ci_range;
	}
	/*get standard deviaction*/
	public static double getstandardDeviaction(){
	    double sum = 0;
	    double mean = getMeanValue();
	    for (int i=0; i<dataset.size(); i++)
	    {
	    	sum+=Math.pow((dataset.get(i)-mean), 2);
	    }
	    double sd = Math.pow(sum/dataset.size(), 0.5);
	    return sd;
	}
	
	public static double getMeanValue(){
	    double sum = 0;
	    for (int i = 0; i<dataset.size();i++)
	    {
	    	sum+=dataset.get(i);
	    }
	    double meansValue = sum/dataset.size();
	    System.out.println(meansValue);
	    return meansValue;
	}
}

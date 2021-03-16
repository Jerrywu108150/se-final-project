import java.util.*;
public class TestBigToSmall{
	public static void main(String args[]){
		
		ArrayList<Integer> userdata=new ArrayList<Integer>();
		FromBigToSmall user1=new FromBigToSmall(userdata);
		user1.addNumber(45,12,77,84,-3,91,4,-24);
		System.out.println("show sorting process:");
		user1.stepByStep();
		user1.display();
		System.out.println("spinSlash:");
		user1.spinSlash();
		System.out.println("time complexity:");
		user1.timeComplexity();
		System.out.println("display the dataset:");
		user1.display();
		System.out.println("display the dataset in reverse:");
		user1.reverse();
		System.out.println("show dataset size:");
		user1.countNumber();
		System.out.println("add numbers to dataset:");
		user1.addNumber(40,-100,200);
		user1.display();
		System.out.println("random range A~B:");
		user1.random(5,2,90);
		user1.stepByStep();
		System.out.println("revise a number:");
		user1.edit(84,70);
		user1.display();
		System.out.println("delete a number");
		user1.delete(91);
		user1.display();
		System.out.println("find average:");
		user1.mean();
		System.out.println("find the median:");
		user1.median();
		System.out.println("find the quartiles:");
		user1.quartile();
		System.out.println("find standard diviation:");
		user1.sd();
	}
}	

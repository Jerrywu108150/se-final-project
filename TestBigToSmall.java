import java.util.*;
public class TestBigToSmall{
	public static void main(String args[]){
		
		ArrayList<Integer> userdata=new ArrayList<Integer>();
		FromBigToSmall user1=new FromBigToSmall(userdata);
		user1.addNumber(45,12,77,84,-3,91,4,-24);

		System.out.println("-------------------------");
		System.out.println("time complexity:");
		System.out.println(user1.timeComplexity());

		System.out.println("-------------------------");
		System.out.println("show sorting process:");
		user1.stepByStep();
		
		System.out.println("-------------------------");
		System.out.println("spinSlash:");
		user1.spinSlash();

		System.out.println("-------------------------");
		System.out.println("display the dataset:");
		user1.display();

		System.out.println("-------------------------");
		System.out.println("display the dataset in reverse:");
		user1.reverse();

		System.out.println("-------------------------");
		System.out.println("show dataset size:");
		System.out.println(user1.countNumber());

		System.out.println("-------------------------");
		System.out.println("add numbers to dataset:");
		user1.display();
		user1.addNumber(40,-100,200);
		user1.display();

		System.out.println("-------------------------");
		FromBigToSmall user2=new FromBigToSmall(userdata);

		System.out.println("-------------------------");
		System.out.println("random range A~B:");
		user2.random(5,2,90);
		user2.display();

		System.out.println("-------------------------");
		System.out.println("search numbers A~B:");
		user1.search(0,100);
		System.out.println(user1.search(-300,20));
		
		System.out.println("-------------------------");
		System.out.println("revise a number:");
		user1.display();
		user1.edit(84,70);
		user1.display();
		
		System.out.println("-------------------------");
		System.out.println("delete a number");
		user1.display();
		user1.delete(91);
		user1.display();	

		System.out.println("-------------------------");
		System.out.println("find average:");
		System.out.println(user1.mean());

		System.out.println("-------------------------");
		System.out.println("find the median:");
		user1.spinSlash();
		System.out.println(user1.median());

		
		int[] q = user1.quartile();
		System.out.println("-------------------------");
		System.out.println("find the quartiles:");
		System.out.print(" "+q[0]);
		System.out.print(" "+q[1]);
		System.out.print(" "+q[2]);
		System.out.println();

		System.out.println("-------------------------");
		System.out.println("find standard diviation:");
		System.out.println(user1.sd());
	}
}	

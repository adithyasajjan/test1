import java.util.*;
public class Exp3{

	public void validator(int age){
		if(age >= 18)
			System.out.println("Happy Voting");
		else
			System.out.println("Not Eligible to vote");
	}

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter Your Age");
		int age = sc.nextInt();
		Exp3 obj = new Exp3();
		obj.validator(age);
    }
}
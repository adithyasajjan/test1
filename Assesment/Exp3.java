package Assesment;

import java.util.Scanner;

public class Exp3 {
	
	public void balanceParan(String S, int n) {
		int incre = 0;
		for(int i=0; i<n; i++){
			if(S.charAt(i) == '(')
				incre++;
			if(S.charAt(i) == ')')
				incre--;
		}
		if(incre == 0) 
			System.out.println("Balanced Parenthesis");
		else
			System.out.println("No Balanced Parenthesis");
	}
	public static void main(String args[]) {
		Exp3 obj = new Exp3();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter String");
		String S = sc.next();
	
		int n = S.length();
		
		obj.balanceParan(S, n);
		
		}
}

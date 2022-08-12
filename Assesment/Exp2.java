package Assesment;

import java.util.Scanner;

public class Exp2 {
	
	public void returnIndices(int arr[], int n, int tar) {
		int ind1 = 0, ind2 = 0;
		for(int i=0; i<n; i++) {
			ind1 = i;
			for(int j=i+1; j<n; j++) {
				ind2 = j;
				if((arr[i]+arr[j]) == tar) {
					System.out.println(ind1+" "+ind2);
//					return ;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int n, tar;
		
		Scanner sc = new Scanner(System.in);
		
		Exp2 obj = new Exp2();
		
		System.out.println("Enter array size");
		n = sc.nextInt();
		int arr[] = new int[n];
		
		System.out.println("Enter the target value");
		tar = sc.nextInt();
		
		System.out.println("Enter array elements");
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		obj.returnIndices(arr, n, tar);
		
	}
}

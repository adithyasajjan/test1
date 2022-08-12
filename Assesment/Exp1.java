package Assesment;

import java.util.Scanner;

public class Exp1 {
	
	public void rotate(int arr[], int n, int k) {
		int num1 = 0;
		for(int j=0; j<k; j++){
			num1 = arr[0];
			for(int i=0; i<n-1; i++) {
				arr[i] = arr[i+1];
			}
			arr[n-1] = num1;
		}
	}
	
	public void display(int arr[], int n) {
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		int n, k;
		
		Scanner sc = new Scanner(System.in);
		
		Exp1 obj = new Exp1();
		
		System.out.println("Enter array size");
		n = sc.nextInt();
		int arr[] = new int[n];
		
		System.out.println("Enter the number of times need to rotate an array");
		k = sc.nextInt();
		
		System.out.println("Enter array elements");
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		obj.rotate(arr, n, k);
		obj.display(arr, n);
	}
}

package com.package2;

import java.util.*; //contains Scanner class and Regex class

//import java.util.regex.*;

import com.package1.*;      					//including package1 in package 2

class child extends studDetails{
	public void show(studDetails obj){
		System.out.println();
		System.out.println("Name: "+obj.name);
		System.out.println("Roll No: "+obj.rollNo);
		System.out.println("Phone No: "+obj.phNo);
		System.out.println("Blood Group: "+obj.bGroup);
		System.out.println("City: "+obj.city);
		System.out.println("DoB: "+obj.DoB);
		System.out.println("Gender: "+obj.Gen);
		System.out.println("Grade: "+obj.Grade);
	}
}
public class display {
	public static void main(String args[]){
		studDetails obj = new studDetails();
		Scanner sc = new Scanner(System.in);
		int flag=1;
		System.out.println("Enter Name");
		String name = sc.nextLine();
		if(name.matches("[a-zA-Z]+") == true)
		{
			obj.name=name;
		}
		else
		{
			System.out.println("Enter a valid name");
			String name1 = sc.nextLine();
			obj.name = name1;
		}
		
		System.out.println("Enter Roll No");
		int rollNo = sc.nextInt();
		if(rollNo > 100)
		{
			System.out.println("Enter a valid roll No");
			int rollNo1 = sc.nextInt();
			obj.rollNo = rollNo1;
		}
		else
		{
			obj.rollNo = rollNo;
		}
		
		System.out.println("Enter Phone No.");
		long phNo = sc.nextLong();
		
		while(flag == 1)
		{
			String S = Long.toString(phNo);
			if(S.length() != 10 || S.matches("^[1-5][0-9]+"))
			{
				System.out.println("Enter a valid phone number");
				phNo = sc.nextLong();
//				obj.phNo = phNo1;
			}
			else
			{
				phNo=Long.parseLong(S);
				obj.phNo = phNo;
				flag = 0;
			}
		}
		
		System.out.println("Enter Blood Group");
		sc.nextLine();
		String bGroup = sc.next();
		
		System.out.println("Enter City");
		sc.nextLine();
		String city = sc.next();
		
		System.out.println("Enter DoB [dd/mm/yyyy]");
		sc.nextLine();
		String DoB = sc.next();
		if(!(DoB.matches("[0-9][1-9]/[0-9][1-9]/[1-2][0-9][0-9][0-9]")))
		{
			System.out.println("Enter a valid DoB");
			DoB = sc.next();
			obj.DoB = DoB;
		}
		else
		{
			obj.DoB = DoB;
		}
		
		System.out.println("Enter Gender [M/F]");
		char Gen = sc.next().charAt(0);
		
		System.out.println("Enter Grade [A/B/C/F]");
		char Grade = sc.next().charAt(0);
		if(Grade != 'A' && Grade != 'B' && Grade != 'C' && Grade != 'F')
		{
			System.out.println("Enter a valid Grade");
			Grade = sc.next().charAt(0);
			obj.Grade = Grade;
		}
		else
		{
			obj.Grade = Grade;
		}
		
		//obj.name = name;
		//obj.rollNo = rollNo;
		obj.bGroup = bGroup;
		obj.city = city;
		
		obj.Gen = Gen;
		//obj.Grade = Grade;
		
		child obj1 = new child();
		obj1.show(obj);
	}

}

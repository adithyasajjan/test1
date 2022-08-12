import java.util.*;

public class Exp2 {
	public void details(String Sname, String Sclg, String SRNo, String SBranch, char SSec, double Scgpa)
	{
		System.out.println("Name : "+ Sname +"\nCollege Name : "+Sclg +"\nSRN : "+SRNo +"\nBranch : "+SBranch +
				"\nSec : "+SSec +"\nCGPA : "+Scgpa);
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name");
		String Sname = sc.nextLine();
		
		System.out.println("Enter College Name");
		String Sclg = sc.nextLine();
		
		System.out.println("Enter SRN");
		String SRNo = sc.nextLine();
		
		System.out.println("Enter Branch");
		String SBranch = sc.nextLine();
		
		System.out.println("Enter Section");
		char SSec = sc.next().charAt(0);
		
		System.out.println("Enter CGPA");
		double Scgpa = sc.nextDouble();
		
		Exp2 obj = new Exp2();
		obj.details(Sname, Sclg, SRNo, SBranch, SSec, Scgpa);
	}	
}


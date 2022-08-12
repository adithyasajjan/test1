import java.util.Scanner;

class Exp{
	
	int rollNo;
	String name;
	
	static Exp obj = null;					
	
	private Exp()
	{
		
	}
	
	public static Exp getObj() { 					
		if(obj == null) {
			obj = new Exp();
		}
		return obj;
	}
	
	void Details() {
		System.out.println("Roll No = "+obj.rollNo);
		System.out.println("Name = "+obj.name);
	}
}
public class Exp5 {
	public static void main(String[] args) {
		Exp obj1 = Exp.getObj();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Roll No");
		int rollNo = sc.nextInt();
		
		System.out.println("Enter student name");
		sc.nextLine();
		String name = sc.next();
		
		obj1.name = name;
		obj1.rollNo = rollNo;
		
		obj1.Details();
	}
}


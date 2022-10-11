package CusDetails;

public class PayableAmount {
	
	public double getPayableAmount(CusUser cu) {
		
		double amount = 0;
		
		amount = cu.getWeight() * cu.getPrice();
		
		return amount;
	}
}

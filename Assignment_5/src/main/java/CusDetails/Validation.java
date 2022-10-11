package CusDetails;

public class Validation {
	
	public boolean validatePasswords(String passwd1, String passwd2){

		boolean index=false;

        if (passwd1.matches(passwd2)) {
             index = true;
        }
        
        return index;
    }
	
	public boolean validatePassword(String passwd1) {
		
		boolean index = false;
		if(passwd1.matches("(?=.*[0-9Validation val = new Validation();])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*])(?=\\S+$).{8,16}")) {
			
			index = true;	
		}
		return index;
	}
	
	public boolean validateBalance(double balance){

		boolean index=true;

        if(balance >= 1000){

            return index;

        }
        else{

//            System.out.println("Minimum amount to open an account is 1000Rs");
            index = false;
            return index;

        }
    }
	
	public boolean validateEmail(String email) {
		
		boolean index = true;
		
		if(email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$") == true) {
			index = false;
				
		}
		
		return index;
	}
	
	public boolean validateVehicleNum(String vehiNum) {
		
		boolean index = false;
		
		if(vehiNum.matches("^[A-Z]{2}\s[0-9]{2}\s[A-Z]{2}\s[0-9]{4}$")) {
			
			index = true;
		}
		
		return index;	
	}
	
	public boolean validatePhoneNum(String phNum) {
		
		boolean index = false;
		
		if(phNum.matches("(0|91)?[6-9][0-9]{9}")) {
			
			index = true;
		}
		
		return index;
	}
	
	public boolean validateName(String name) {
		
		boolean index = false;
		if(name.matches("[a-zA-Z]+[ a-zA-Z]*")) {
			
			index = true;
		}
		
		return index;
	}
	
	public boolean validateAmount(double amount) {
		
		boolean index = false;
		if((amount > 1000) && (amount > 0)) {
			
			index = true;
		}
		
		return index;
	}
}

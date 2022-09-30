package Register;

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
		if(passwd1.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*])(?=\\S+$).{8,16}")) {
			
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

}

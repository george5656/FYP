package model;
/**
 * a class to check if the user input is valid.
 * @author George
 *
 */
public class InputValidation {
//fields
	private String errorMessage = ""; 
	/**
	 * function checks if the user input is valdiad and ok to use
	 * @param userInput = a string of the user data want to check
	 * @return String that says the error
	 */
	public String stringValidation(String userInput) {
		errorMessage = "";
		if(userInput.length() == 0) {
			errorMessage = "no input";
		}
		if(userInput.length()>50) {
			errorMessage = "user input to big";
		}
		if(!userInput.matches("[a-zA-Z0-9 ]+")&&!userInput.equals("")) {
			errorMessage = "only a-z and A-Z";
		}
		return errorMessage;
	
	
}
}
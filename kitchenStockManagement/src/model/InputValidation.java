package model;

import java.time.LocalDate;

/**
 * a class to check if the user input is valid.
 * @author George
 *
 */
public class InputValidation {
//fields
	private String errorMessage = ""; 
	/**
	 * function checks if the user input is validate and ok to use.
	 * it checks if there is an input, if the input size is below 50,
	 * if it only contains [a-z0-9 ]+
	 * and that it doesn't contain any key words
	 * note, no upper case as the database, converts all char to lower case.
	 * @param userInput = a string of the user data want to check
	 * @return String that says the error or just "" if no error
	 */
	public String stringMustBePresetValidation(String userInput) {
		errorMessage = stringPresentIsOptionalValidation(userInput);
		if(userInput.length() == 0) {
			errorMessage = "no input";
		}
		return errorMessage;
	
	
}
	/**
	 * function checks if the user input is validate and ok to use.
	 * if the input size is below 50 and
	 * if it only contains [a-zA-Z0-9 ]+
	 * and that it doesn't contain any key words
	 * @param userInput = a string of the user data want to check
	 * @return String that says the error or just "" if no error 
	 */
	public String stringPresentIsOptionalValidation(String userInput) {
		errorMessage = "";
		if(userInput.length()>50) {
			errorMessage = "user input to big";
		}
		if(!userInput.matches("[a-z0-9 ]+")&&!userInput.equals("")) {
			errorMessage = "only a-z and 0-9 allowed";
		}
		if(userInput.contains("null")||userInput.contains("name")||userInput.contains("name")||userInput.contains("cost")) {
			errorMessage = "a key word has been inputed and must be removed";
		}
		if(userInput.contains("id")||userInput.contains("storage")||userInput.contains("quantity")||userInput.contains("quanity")) {
			errorMessage = "a key word has been inputed and must be removed";
		}
		if(userInput.contains("amount")||userInput.contains("quantity type")||userInput.contains("account")||userInput.contains("type")) {
			errorMessage = "a key word has been inputed and must be removed";
		}
		return errorMessage;
	
	
}
	/**
	 * checks the following areas, 
	 * that is has an input, that it only contains [0-9]+ and
	 * that its length is less than 50 characters
	 * 
	 * @param userInput = a string of the user data want to check
	 * @return String that says the error or just "" if no error 
	 */
	public String intMustBePresetValidation(String userInput) {
		errorMessage =intPresentIsOptionalValidation(userInput);
				
		
		if(userInput.length() == 0) {
			errorMessage = "no input";
		}
		
		return errorMessage;
	}
	/**
	 * checks the following areas, 
	 * that it only contains [0-9]+ and
	 * that its length is less than 50 characters
	 * 
	 * @param userInput = a string of the user data want to check
	 * @return String that says the error or just "" if no error 
	 */
	public String intPresentIsOptionalValidation(String userInput) {
		errorMessage ="";
				
		if(!userInput.matches("[0-9]+")&&!userInput.equals("")) {
			errorMessage = "only characters between 0-9 allowed";
		}
		if(userInput.length()>50) {
			errorMessage = "user input has to many characters";
		}
		return errorMessage;
	}
	/**
	 * validate a string. 
	 * checks that the string is present, that it only contains [0-9.]+ and has only one . and 
	 * two values after the dot, and that the length of the string is less that 50 characters.
	 * 
	 * 
	 * @param userInput =  a double in a string format, that you want to validate.
	 * @return string that says what the error is, if none get ""
	 */
	public String doubleMustBePresetValidation(String userInput) {
		errorMessage =doublePresentIsOptionalValidation(userInput);
		
		
		if(userInput.length() == 0) {
			errorMessage = "no input";
		}
		
		return errorMessage;
	}
	/**
	 * validate a string. 
	 * checks that it only contains [0-9.]+ and has only one . and 
	 * two values after the dot, and that the length of the string is less that 50 characters.
	 * 
	 * 
	 * @param userInput =  a double in a string format, that you want to validate.
	 * @return string that says what the error is, if none get ""
	 */
	public String doublePresentIsOptionalValidation(String userInput) {
		errorMessage ="";
		
		int indexOfDot = userInput.indexOf('.');
		//to stop out of bound issues 
		if(indexOfDot != -1) {
		String valueAfterDot = userInput.substring(indexOfDot+1);
		
		if(valueAfterDot.indexOf('.') != -1) {
			errorMessage = "only one \'.\' allowed";
		}
		if(valueAfterDot.length()>2) {
			errorMessage = "only 2 decmal place allowed";
		}
		}
		
		if(!userInput.matches("[0-9.]+")&&!userInput.equals("")) {
			errorMessage = "only 0-9 and \'.\' characters allowed";
		}
	
		if(userInput.length()>50) {
			errorMessage = "user input has to many characters";
		}
		return errorMessage;
	}
	
	/**
	 * this is designed to work with a datePicker. 
	 * this check that there is date present, as done by seeing if the input is present,
	 * it also checks that the datepicker has registered the input. this is done 
	 * by making sure that the locaclDate and input have input, as if the user just 
	 * types in the datepicker it wont make a local date.
	 * 
	 * @param input = String =  from datePicker textField
	 * @param valuePresent = localDate = from datePicker
	 * @return String that says the error or just "" if no error 
	 */
	public String dateValidation(String input, LocalDate valuePresent) {
		errorMessage ="";
		
		if (!input.equals("")&&valuePresent == null) {
			errorMessage = "no data found, if some does exists try selecting it and preesing enter";
		}
		
		if(input.equals("")) {
			errorMessage = "error no date";
		}
		return errorMessage;
	}
	/**
	 * this is designed to work with a datePicker. 
	 * this checks that the datepicker has registered the input. this is done 
	 * by making sure that the locaclDate and input have input, as if the user just 
	 * types in the datepicker it wont make a local date.
	 * 
	 * @param input = String =  from datePicker textField
	 * @param valuePresent = localDate = from datePicker
	 * @return String that says the error or just "" if no error 
	 */
	public String dateValidationPresentIsOptional(String input, LocalDate valuePresent) {
		errorMessage ="";
		
		
		if (!input.equals("")&&valuePresent == null) {
			errorMessage = "no data found, if some does exists try selecting it and preesing enter";
		}
		
		return errorMessage;
	}
}
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
	 * if it only contains [a-zA-Z0-9 ]+
	 * @param userInput = a string of the user data want to check
	 * @return String that says the error
	 */
	public String stringMustBePresetValidation(String userInput) {
		errorMessage = stringPresentIsOptionalValidation(userInput);
		if(userInput.length() == 0) {
			errorMessage = "no input";
		}
		return errorMessage;
	
	
}
	
	public String stringPresentIsOptionalValidation(String userInput) {
		errorMessage = "";
		if(userInput.length()>50) {
			errorMessage = "user input to big";
		}
		if(!userInput.matches("[a-zA-Z0-9 ]+")&&!userInput.equals("")) {
			errorMessage = "only a-z, A-Z and 0-9 allowed";
		}
		return errorMessage;
	
	
}
	
	public String intMustBePresetValidation(String userInput) {
		errorMessage =intPresentIsOptionalValidation(userInput);
				
		
		if(userInput.length() == 0) {
			errorMessage = "no input";
		}
		
		return errorMessage;
	}
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
	public String dateValidation(String input, LocalDate valuePresent) {
		errorMessage ="";
		//int indexOfFirstSlash = userInput.indexOf('/');
		//int indexOfSecondSlash = -1;
		
		/*
		if(!userInput.matches("[0-9/-]+")&&!userInput.equals("")) {
			errorMessage = "only 0-9 and \'/\' characters allowed";
		}
		if(userInput.length()!=10) {
			errorMessage = "date must be in the format, dd/mm/yyyy";
		}
		*/
		
		/*
		if(indexOfFirstSlash == -1) {
			errorMessage = "date must be in the format, dd/mm/yyyy";
		}else {
		indexOfSecondSlash = userInput.indexOf('/',indexOfFirstSlash+1); 
	
		}
		*
		 * not needed as the dataPicker does this all for me	
		if(indexOfSecondSlash == -1) {
			errorMessage = "date must be in the format, dd/mm/yyyy";
		}else if(userInput.indexOf('/',indexOfSecondSlash +1 ) != -1) {
			errorMessage = "to many /";
			System.out.println(indexOfSecondSlash);
		}
		*/
		
		if (!input.equals("")&&valuePresent == null) {
			errorMessage = "no data found, if some does exists try selecting it and preesing enter";
		}
		
		if(input.equals("")) {
			errorMessage = "error no date";
		}
		return errorMessage;
	}
	public String dateValidationPresentIsOptional(String input, LocalDate valuePresent) {
		errorMessage ="";
		
		
		if (!input.equals("")&&valuePresent == null) {
			errorMessage = "no data found, if some does exists try selecting it and preesing enter";
		}
		
		return errorMessage;
	}
}
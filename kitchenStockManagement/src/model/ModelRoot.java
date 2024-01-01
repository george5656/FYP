package model;
/**
 * class represent the root of the M from MVC.
 * @author George
 *
 */
public class ModelRoot {
//fields 
	private WritableDatabase db = new WritableDatabase();
	private InputValidation validation = new InputValidation();

/**
 * simply gets the validation class
 * @return InputValdiation class
 */
	public InputValidation getValidation() {
		return validation;
	}
	/**
	 * simply gets the database
	 * @returnWritableDatabase
	 */
	public WritableDatabase getDatabase() {
		return db;
	}
}

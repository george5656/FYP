package model;
/**
 * class represent the root of the M from MVC.
 * @author Student
 *
 */
public class ModelRoot {
//fields 
	private WritableDatabase db = new WritableDatabase();
	private InputValidation validation = new InputValidation();
/**
 * Default constructor 
 * 
 */
	public ModelRoot(){
		
	}

	public InputValidation getValidation() {
		return validation;
	}
	public WritableDatabase getDatabase() {
		return db;
	}
}

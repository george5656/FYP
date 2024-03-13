package model;

/**
 * 
 * storage location object is used to represent of a storage location while
 * using the stock management system
 * 
 * @author Student
 *
 */
public class StorageLocation {
	private String name;
	private boolean isAvailble;
	private String type;

	/**
	 * constructor
	 * 
	 * @param name       = String
	 * @param type       = String
	 * @param isAvailble = Boolean, true = is admin, false = isnt admin
	 */
	public StorageLocation(String name, String type, boolean isAvailble) {
		this.name = name;
		this.type = type;
		this.isAvailble = isAvailble;
	}

	/**
	 * not in stand format as need for the listview in the StorgaeLcoationListPage
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "name = " + name + ", type = " + type + ", storage is available = " + isAvailble;
	}

	/**
	 * get the value in the name var
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * get the value in the type var
	 * 
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * gets the value in isAvailble var
	 * 
	 * @return Boolean, true = is Availble, false = isnt available
	 */
	public Boolean getAvailbility() {
		return isAvailble;
	}

	/**
	 * gets a string representation of the value in isAvailable
	 * 
	 * @return Sting, which is either true or false
	 */
	public String getIsAvailble() {
		return String.valueOf(isAvailble);
	}
}

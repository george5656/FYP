package model;

public class StorageLocation {
private String name;
private boolean isAvailble;
private String type;

public StorageLocation(String name, String type, boolean isAvailble) {
	this.name = name;
	this.type = type;
	this.isAvailble = isAvailble;
}


/**
 * no stand format as need for the listview, StorgaeLcoationList. 
 */
@Override
	public String toString() {
		return "name = " + name + ", type = " + type + ", storage is available = " + isAvailble;
	}
public String getName() {
	return name;
}
}

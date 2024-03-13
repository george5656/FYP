package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * class is designed to be extended. it extends the BasicLayoutDetails, and
 * simply changes the save button to be apply instead.
 * 
 * @author Student
 *
 */
public class BasicLayoutFilter extends BasicLayoutDetails {
	private Button btnApply = getBtnSave();

	/**
	 * default constructor, simply changes the save button text to apply
	 */
	public BasicLayoutFilter() {
		btnApply.setText("Apply");
	}

	/**
	 * sets the apply button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBtnApply(EventHandler<ActionEvent> event) {
		btnApply.setOnAction(event);
	}
}

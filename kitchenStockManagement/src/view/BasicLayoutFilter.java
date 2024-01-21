package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BasicLayoutFilter extends BasicLayoutDetails {
	private Button btnApply = getbtnSave();
	
	public BasicLayoutFilter() {
		 btnApply.setText("apply");
	}
	/**
	 * sets the apply button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnApply(EventHandler<ActionEvent> event) {
		btnApply.setOnAction(event);
	}
}

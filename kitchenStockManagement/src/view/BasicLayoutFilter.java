package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BasicLayoutFilter extends BasicLayoutDetails {
	private Button btnApply = getbtnSave();
	
	public BasicLayoutFilter() {
		 btnApply.setText("apply");
	}
	public void setBtnApply(EventHandler<ActionEvent> event) {
		btnApply.setOnAction(event);
	}
}

package view;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
/**
 * class is the view for the BudgetFilter
 * @author George
 *
 */
	public class BudgetFilter extends HBox  {
	
		private Label test = new Label("test");
		public BudgetFilter() {
	this.getChildren().add(test);
		}
	}

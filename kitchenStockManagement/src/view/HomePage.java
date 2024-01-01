package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
/**
 * class is the home page after login meant for navigation. 
 * @author George
 *
 */
public class HomePage extends SceneMenu {
//fields
	private VBox layout = new VBox(20);
	private Button stock = new Button("stock");
	private Button budget = new Button("budget");
	private Button account = new Button("account");
	private Button menu = new Button("menu");
	//constructor
	public HomePage() {
	super.setCenter(layout);
		layout.getChildren().addAll(stock,budget,account,menu);
		layout.setAlignment(Pos.CENTER);
		layout.setVgrow(stock, Priority.ALWAYS);
		layout.setVgrow(budget, Priority.ALWAYS);
		layout.setVgrow(account, Priority.ALWAYS);
		layout.setVgrow(menu, Priority.ALWAYS);
		layout.setFillWidth(true);
		stock.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		budget.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		account.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		menu.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		layout.setPadding(new Insets(20,20,20,20));
	}
}

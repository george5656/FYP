package view;

import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class RootView extends VBox{
private Login login = new Login();	
private BudgetFilter budgetFilter = new BudgetFilter();
public RootView() {
	super(20);
	this.getChildren().add(login);
this.setVgrow(login, Priority.ALWAYS);
this.setAlignment(Pos.CENTER);
this.setFillWidth(true);
}
public Login getLoginPage() {
	return login;
}
public BudgetFilter getBudgetFilter() {
	return budgetFilter;
}
}

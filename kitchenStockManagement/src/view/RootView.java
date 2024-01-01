package view;

import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * class is the root of the view in the MVC
 * 
 * @author George
 *
 */
public class RootView extends VBox {
	// fields
	private Login login = new Login();
	private BudgetFilter budgetFilter = new BudgetFilter();
	private HomePage homePage = new HomePage();

	/**
	 * default constructor
	 */
	public RootView() {
		super(20);
		this.getChildren().add(login);
		this.setVgrow(login, Priority.ALWAYS);
		this.setAlignment(Pos.CENTER);
		this.setFillWidth(true);
	}

	/**
	 * get the Login view
	 * 
	 * @return Login view
	 */
	public Login getLoginPage() {
		return login;
	}

	/**
	 * get the budget filter
	 * 
	 * @return BudgetFilter view
	 */
	public BudgetFilter getBudgetFilter() {
		return budgetFilter;
	}
	/**
	 * get the Home page view
	 * @return HomePage view
	 */
public HomePage getHomePage() {
	return homePage;
}
}

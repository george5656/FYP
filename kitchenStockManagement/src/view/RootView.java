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
	private ListPage stockListPage = new ListPage();
	private MenuDetails menuDetails = new MenuDetails();
	private ListPage menuListPage = new ListPage();
	private DeleteConfirmationPage dcp= new DeleteConfirmationPage(); 
	private DishDetailsPage ddp = new DishDetailsPage();
	private StockDetails sd = new StockDetails();
	private ListPage budgetListPage = new ListPage();
	private BudgetDetailsPage bdp = new BudgetDetailsPage();
	private ListPage storageLocationListPage = new ListPage();
	private StockStorageLocationDetails ssld = new StockStorageLocationDetails();
	private AccountDetails ad = new AccountDetails();
	private ListPage accountListPage = new ListPage();
	private StockStorageLocationFilter sslf = new StockStorageLocationFilter();
	private StockFilter sf = new StockFilter();
	private FilterDishes fd = new FilterDishes();
	private AccountFilter af = new AccountFilter();
	private MenuFilter mf = new MenuFilter();
	private MenuSettingPage msp = new MenuSettingPage();
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
public ListPage getStockListPage() {
	return stockListPage;
}

public ListPage getMenuListPage() {
	return menuListPage;
}
public MenuDetails getMenuDetails() {
return menuDetails;
}
public DeleteConfirmationPage getDeleteConfirmationPage() {
	return dcp;
}
public DishDetailsPage getDishDetailsPage() {
	return ddp;
}
public StockDetails getStockDetails() {
	return sd;
}
public ListPage getBudgetListPage() {
	return budgetListPage;
}
public BudgetDetailsPage getBudgetDetailsPage() {
	return bdp;
}
public ListPage getStorageLocationListPage() {
	return storageLocationListPage;
}
public StockStorageLocationDetails getStockStorageLoctionDetailsPage() {
	return ssld;
}
public AccountDetails getAccountDetails() {
	return ad;
}
public ListPage getAccountListPage() {
	return accountListPage;
}
public StockStorageLocationFilter getStockStorageLocationFilter() {
	return sslf;
}
public StockFilter getStockFilter() {
	return sf;
}
public FilterDishes getFilterDishes() {
	return fd;
}
public AccountFilter getAccountFilter() {
	return af;
}
public MenuFilter getMenuFilter() {
	return mf;
}
public MenuSettingPage getMenuSettingPage() {
	return msp;
}


}
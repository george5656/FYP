package view;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;

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
	private Output output = new Output();
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
public ArrayList<PaneMenu> getAllView(){
	ArrayList<PaneMenu> all = new ArrayList<>();
	all.add(budgetFilter);
	all.add(homePage);
	all.add(stockListPage);
	all.add(menuDetails);
	all.add(menuListPage);
	all.add(dcp);
	all.add(ddp);
	all.add(sd);
	all.add(budgetListPage);
	all.add(bdp);
	all.add(storageLocationListPage);
	all.add(ssld);
	all.add(ad);
	all.add(accountListPage);
	all.add(sslf);
	all.add(sf);
	all.add(fd);
	all.add(af);
	all.add(mf);
	all.add(msp);
	all.add(output);
	
	return all;
}
public Output getOutputPage() {
	return output;
}





//login 

public void setLoginBtnExit(EventHandler<ActionEvent> event) {
	login.setBtnExitEventHandler(event);
}

public void setLoginBtnLogin(EventHandler<ActionEvent> event) {
	login.setBtnLoginEventHandler(event);
}

public String getLoginUserUsernameInput() {
	return login.getUserUsernameInput();
}
public String getLoginUserPasswordInput() {
	return login.getUserPasswordInput();
}
public void loginLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(login);
	this.setVgrow(login, Priority.ALWAYS);
	login.clearInput();
}
//home page

public void setHomeBtnStockEventHandler(EventHandler<ActionEvent> event) {
	homePage.setBtnStockEventHandler(event);
}
public void setHomeBtnMenuEventHandler(EventHandler<ActionEvent> event) {
	homePage.setBtnMenuEventHandler(event);
}
public void setHomeBtnAccountEventHandler(EventHandler<ActionEvent> event) {
	homePage.setBtnAccountEventHandler(event);
}
public void setHomeBtnBudgetEventHandler(EventHandler<ActionEvent> event) {
	homePage.setBtnBudgetEventHandler(event);
}
public void setHomeBtnStorageEventHandler(EventHandler<ActionEvent> event) {
	homePage.setBtnStorageEventHandler(event);
}

public void homePageMenuLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(homePage);
	this.setVgrow(homePage, Priority.ALWAYS);
}

//stockListPage

public void setStockListBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
	stockListPage.setBtnDeleteEventHandler(event);
}
public void setStockListBtnAddEventHandler(EventHandler<ActionEvent> event) {
	stockListPage.setBtnAddEventHandler(event);
}
public void setStockListBtnFilterEventHandler(EventHandler<ActionEvent> event) {
	stockListPage.setBtnFilterEventHandler(event);
}
public void stockListLoad(ObservableList<String> data) {
	stockListPage.getErrorLabel().setVisible(false);
	stockListPage.setObservableList(data);
	this.getChildren().remove(0);
	this.getChildren().add(ad);
	this.setVgrow(ad, Priority.ALWAYS);
}

/*
public void setStockListObservableList(EventHandler<ActionEvent> event) {
	stockListPage.setObservableList(event);
}
*/
public void setStockListBtnFindEventHandler(EventHandler<ActionEvent> event) {
	stockListPage.setBtnFindEventHandler(event);
}
public void setStockListBtnEditEventHandler(EventHandler<ActionEvent> event) {
	stockListPage.setBtnEditEventHandler(event);
}


// stock details 

public void setStockDetailsBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	sd.setBtnSaveEventHandler(event);
}
public void setStockDetailsBtnCancelEventHandler(EventHandler<ActionEvent> event) {
	sd.setBtnCancelEventHandler(event);
}
public void stockDetailsLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(sd);
	this.setVgrow(sd, Priority.ALWAYS);
}

// stock filter 

public void setStockFilterBtnApply(EventHandler<ActionEvent> event) {
	sf.setBtnApply(event);
}

//menuList

public void setMenuListBtnFilterEventHandler(EventHandler<ActionEvent> event) {
	menuListPage.setBtnFilterEventHandler(event);
}
public void setMenuListBtnAddEventHandler(EventHandler<ActionEvent> event) {
	menuListPage.setBtnAddEventHandler(event);
}
public void menuListLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(menuListPage);
	this.setVgrow(menuListPage, Priority.ALWAYS);
}


// menuDetails

public void setMenuDetailsBtnSettingEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnSettingEventHandler(event);
}
public void setMenuDetailsBtnOutputEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnOutputEventHandler(event);
}
public void setMenuDetailsBtnFilterEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnFilterEventHandler(event);
}
public void setMenuDetailsBtnAddEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnAddEventHandler(event);
}
public void MenuDetailsLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(menuDetails);
	this.setVgrow(menuDetails, Priority.ALWAYS);
}

//menu filter
public void menuFilterLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(mf);
	this.setVgrow(mf, Priority.ALWAYS);
}
// menu settings

public void menuSettingsLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(msp);
	this.setVgrow(msp, Priority.ALWAYS);
}
//outputPage
public void outputPageLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(output);
	this.setVgrow(output, Priority.ALWAYS);
}

//budgetList

public void setBudgetListBtnAddEventHandler(EventHandler<ActionEvent> event) {
	budgetListPage.setBtnAddEventHandler(event);
}
public void setBudgetListBtnFilterEventHandler(EventHandler<ActionEvent> event) {
	budgetListPage.setBtnFilterEventHandler(event);
}
public void setBudgetListBtnFindEventHandler(EventHandler<ActionEvent> event) {
	budgetListPage.setBtnFindEventHandler(event);
}
//budgetDetailsPage
public void setBudgetDetailsBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	bdp.setBtnSaveEventHandler(event);
}
public void budgetDetailsLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(bdp);
	this.setVgrow(bdp, Priority.ALWAYS);
}

//budget filter

public void budgetfilterLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(budgetFilter);
	this.setVgrow(budgetFilter, Priority.ALWAYS);
}

//storagelocationlist
public void setStorgaeLocationListBtnAddEventHandler(EventHandler<ActionEvent> event) {
	storageLocationListPage.setBtnAddEventHandler(event);
}
public void setStorgaeLocationListBtnFilterEventHandler(EventHandler<ActionEvent> event) {
	storageLocationListPage.setBtnFilterEventHandler(event);
}
//storageLocationDetails

public void StorgaeLocationDetailsLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(ssld);
	this.setVgrow(ssld,Priority.ALWAYS);
}

//storgae location filter 

public void StorgaeLocationFilterLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(sslf);
	this.setVgrow(sslf,Priority.ALWAYS);
}

//accountListPage
public void setAccountListBtnAddEventHandler(EventHandler<ActionEvent> event) {
	accountListPage.setBtnAddEventHandler(event);
}
public void setAccountListBtnFilterEventHandler(EventHandler<ActionEvent> event) {
	accountListPage.setBtnFilterEventHandler(event);
}
//account details
public void accountDetailsLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(ad);
	this.setVgrow(ad, Priority.ALWAYS);
}

// account filter 

public void accountFilterLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(af);
	this.setVgrow(af, Priority.ALWAYS);
}

//DeleteConfirmaitonPage

public void setDeleteConfirmationBtnConfirmEventHandler(EventHandler<ActionEvent> event) {
	dcp.setBtnConfirmEventHandler(event);
}
public void setDeleteConfirmationBtnCancelEventHandler(EventHandler<ActionEvent> event) {
	dcp.setBtnCancelEventHandler(event);
}
public void setAllPaneMenu(EventHandler<ActionEvent> home,EventHandler<ActionEvent> Logout) {
	ArrayList<PaneMenu> all = getAllView();
	for(PaneMenu i : all) {
		i.setHomeEventHandler(home);
		i.setLogoutEventHandler(Logout);
	}
}

// dish 
public void dishDetailsLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(ddp);
	this.setVgrow(ddp, Priority.ALWAYS);
}

//filter dishes
public void dishFilterLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(fd);
	this.setVgrow(fd, Priority.ALWAYS);
}

}
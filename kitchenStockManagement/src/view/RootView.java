package view;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
public HomePage getHomePage(Boolean isAdmin) {
	homePage.setHomePagetype(isAdmin);
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
/**
 * 
 * @return
 */
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
/**
 * sets the exit button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setLoginBtnExit(EventHandler<ActionEvent> event) {
	login.setBtnExitEventHandler(event);
}
/**
 * sets the login button event handler 
 * @param event = Event handler<ActionEvent> 
 */
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
/**
 * sets the stock button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setHomeBtnStockEventHandler(EventHandler<ActionEvent> event) {
	homePage.setBtnStockEventHandler(event);
}
/**
 * sets the home page about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setHomeBtnAboutEventHandler(EventHandler<ActionEvent> event) {
	homePage.setAboutEventHandler(event);
}
/**
 * sets the menu button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setHomeBtnMenuEventHandler(EventHandler<ActionEvent> event) {
	homePage.setBtnMenuEventHandler(event);
}
/**
 * sets the Account button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setHomeBtnAccountEventHandler(EventHandler<ActionEvent> event) {
	homePage.setBtnAccountEventHandler(event);
}
/**
 * sets the budget button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setHomeBtnBudgetEventHandler(EventHandler<ActionEvent> event) {
	homePage.setBtnBudgetEventHandler(event);
}
/**
 * sets the storage button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setHomeBtnStorageEventHandler(EventHandler<ActionEvent> event) {
	homePage.setBtnStorageEventHandler(event);
}

public void homePageMenuLoad(Boolean isAdmin) {
	homePage.setHomePagetype(isAdmin);
	this.getChildren().remove(0);
	this.getChildren().add(homePage);
	this.setVgrow(homePage, Priority.ALWAYS);
}

//stockListPage
/**
 * sets the stock delete button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStockListBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
	stockListPage.setBtnDeleteEventHandler(event);
}
/**
 * sets the stock list page about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStockListBtnAboutEventHandler(EventHandler<ActionEvent> event) {
	stockListPage.setAboutEventHandler(event);
}
/**
 * sets the stock add button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStockListBtnAddEventHandler(EventHandler<ActionEvent> event) {
	stockListPage.setBtnAddEventHandler(event);
}
/**
 * sets the stock filter button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStockListBtnFilterEventHandler(EventHandler<ActionEvent> event) {
	stockListPage.setBtnFilterEventHandler(event);
}
public void stockListLoad(ObservableList<String> data) {
	stockListPage.getErrorLabel().setVisible(false);
	stockListPage.setObservableList(data);
	this.getChildren().remove(0);
	this.getChildren().add(stockListPage);
	this.setVgrow(stockListPage, Priority.ALWAYS);
}
public String getStockListSelectedItem() {
	
	if(stockListPage.getSelectionNode().getSelectionModel().getSelectedItem()!= null) {
	return stockListPage.getSelectionNode().getSelectionModel().getSelectedItem();
	}else {
		return "null";
	}
}

public void setStockListError(String errorMessgae) {
	stockListPage.getErrorLabel().setVisible(true);
	stockListPage.getErrorLabel().setText(errorMessgae);
}

/**
 * sets the stock list find button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStockListBtnFindEventHandler(EventHandler<ActionEvent> event) {
	stockListPage.setBtnFindEventHandler(event);
}
/**
 * sets the stock list edit button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStockListBtnEditEventHandler(EventHandler<ActionEvent> event) {
	stockListPage.setBtnEditEventHandler(event);
}

public String getSelectedStockId() {
	String stockId = stockListPage.getSelection();
	int idStart = stockId.indexOf("id");
	int storageStart = stockId.indexOf("storage");
	return stockId.substring(idStart + 5, storageStart -2);
}

public String getStockListTfFindValue() {
	return stockListPage.getTfFindValue();
}
public void setStockListValues(ObservableList<String> data) {
stockListPage.setObservableList(data);
}



// stock details 
/**
 * sets the stock details save button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStockDetailsBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	sd.setBtnSaveEventHandler(event);
}
/**
 * sets the stock details about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStockDetailsBtnAboutEventHandler(EventHandler<ActionEvent> event) {
	sd.setAboutEventHandler(event);
}
/**
 * sets the stock details cancel button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStockDetailsBtnCancelEventHandler(EventHandler<ActionEvent> event) {
	sd.setBtnCancelEventHandler(event);
}
/**
 * sets the stock details load from file button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStockDetailsBtnLoadFromFileEventHandler(EventHandler<ActionEvent> event) {
	sd.setBtnLoadFromFileEventHandler(event);
}
//true means go to add, false means go to edit
public void stockDetailsLoad(Boolean add) {
	this.getChildren().remove(0);
	this.getChildren().add(sd);
	this.setVgrow(sd, Priority.ALWAYS);
	
	if(add) {
		sd.setAddVarient();
	}else {
		sd.RemoveAddVarient();
	}
	
}
public String getStockDetailsStockName() {
	return sd.getStockName().getText();
}
public String getStockDetailsQuantity() {
	return sd.getQuanity().getText();
}
public String getStockDetailsQuanitType() {
	return sd.getQuantityType().getText();
}
public String getStockDetailsCost() {
	return sd.getCost().getText();
}
public String getStockDetailsDateValue() {
	if(sd.getExpiereDate().getValue() != null) {
	return sd.getExpiereDate().getValue().toString();
	}else {
		return "null";
	}
	
	}
public LocalDate getStockDetailsDateValueAsLocalDate() {
	
	return sd.getExpiereDate().getValue();
	}
public String getStockDetailsDateText() {
	if(sd.getExpiereDate().getEditor().getText() != null) {
	return sd.getExpiereDate().getEditor().getText();
	}else {
		return "null";
	}
	
	}
public String getStorageLocation() {
	return sd.getStorageLocation().getSelectionModel().getSelectedItem().toString();
}


public void resetStockDetailsPage(ObservableList<String> data) {
	sd.getStorageLocation().getItems().clear();
	sd.getStorageLocation().getItems().addAll(data);
	sd.getStockName().clear();
	sd.getQuanity().clear();
	sd.getQuantityType().clear();
	sd.getExpiereDate().getEditor().clear();
	sd.getCost().clear();
}

public void setStockDetailsName(String name) {
	sd.getStockName().setText(name);
}
public void setStockDetailsStorgeLocation(String StorgeLocation) {
	sd.getStorageLocation().setValue(StorgeLocation);
}
public void setStockDetailsQuanity(String Quanity) {
	sd.getQuanity().setText(Quanity);
}
public void setStockDetailsQuanityType(String QuanityType) {
	sd.getQuantityType().setText(QuanityType);
}
public void setStockDetailsExpiereDate(String ExpiereDate) {
	sd.getExpiereDate().getEditor().setText(ExpiereDate);
}
public void setStockDetailsCost(String Cost) {
	sd.getCost().setText(Cost);
}

// stock filter 
/**
 * sets the stock filter apply button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStockFilterBtnApply(EventHandler<ActionEvent> event) {
	sf.setBtnApply(event);
}
/**
 * sets the stock filter about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStockFilterBtnAbout(EventHandler<ActionEvent> event) {
	sf.setAboutEventHandler(event);
}
/**
 * sets the stock filter cancel button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStockFilterBtnCancel(EventHandler<ActionEvent> event) {
	sf.setBtnCancelEventHandler(event);
}
public void stockFilterLoad(ArrayList<String> storageLocations, ArrayList<String> stockType) {
	
	sf.getCbStorageLocation().getItems().clear();
	sf.getCbStorageLocation().getItems().addAll(storageLocations);
	
	sf.getCbStockType().getItems().clear();
	sf.getCbStockType().getItems().addAll(stockType);
	
	this.getChildren().remove(0);
	this.getChildren().add(sf);
	this.setVgrow(sf, Priority.ALWAYS);
}
public String getStockFilterTfMinQunaity() {
	return sf.getTfMinQunaity().getText();
}
public String getStockFilterTfMaxQunaity() {
	return sf.getTfMaxQuanity().getText();
}
public String getStockFilterDpAfterDateText() {
	return sf.getDpAfterDate().getEditor().getText();
}
public String getStockFilterDpBeforeDateText() {
	return sf.getDpBeforeDate().getEditor().getText();
}

public LocalDate getStockFilterDpAfterDateValuePresent() {
	return sf.getDpAfterDate().getValue();
}
public LocalDate getStockFilterDpBeforeDateValuePresent() {
	return sf.getDpBeforeDate().getValue();
}

public String getStockFilterAboveCost() {
	return sf.getTfAboveCost().getText();
}
public String getStockFilterBelowCost() {
	return sf.getTfBelowCost().getText();
}
public String getStockFilterStorgaeLocation() {
	
	if(sf.getCbStorageLocation().getSelectionModel().getSelectedItem()!=null) {
		return sf.getCbStorageLocation().getSelectionModel().getSelectedItem();
	}else {
		return "null";
	}
}
public String getStockFilterStockType() {
	
	if(sf.getCbStockType().getSelectionModel().getSelectedItem()!=null) {
		return sf.getCbStockType().getSelectionModel().getSelectedItem();
	}else {
		return "null";
	}
}
//menuList
/**
 * sets the menu list apply filter button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuListBtnFilterEventHandler(EventHandler<ActionEvent> event) {
	menuListPage.setBtnFilterEventHandler(event);
}
/**
 * sets the menu list apply add button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuListBtnAddEventHandler(EventHandler<ActionEvent> event) {
	menuListPage.setBtnAddEventHandler(event);
}
/**
 * sets the menu list apply delete button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuListBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
	menuListPage.setBtnDeleteEventHandler(event);
}
/**
 * sets the menu list apply find button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuListBtnFindEventHandler(EventHandler<ActionEvent> event) {
	menuListPage.setBtnFindEventHandler(event);
}
/**
 * sets the menu list apply edit button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuListBtnEditEventHandler(EventHandler<ActionEvent> event) {
	menuListPage.setBtnEditEventHandler(event);
}
/**
 * sets the menu list apply about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuListBtnAboutEventHandler(EventHandler<ActionEvent> event) {
	menuListPage.setAboutEventHandler(event);
}
public String getMenuListSelectedMenu() {
	if(menuListPage.getSelectionNode().getSelectionModel().getSelectedItem()!= null) {
	return menuListPage.getSelectionNode().getSelectionModel().getSelectedItem();
	}else {
		return "null";
	}
}
public String getMenuListSelectedMenuId() {
	String selection = menuListPage.getSelectionNode().getSelectionModel().getSelectedItem();
	return selection.substring(selection.indexOf("=")+2);
	
}
public void setMenuListError(String errorMessage) {
	menuListPage.getErrorLabel().setVisible(true);
	menuListPage.getErrorLabel().setText(errorMessage);
}
public String getMenuListFindUserInput() {
	return menuListPage.getTfFindValue();
	
}
public void hideMenuListErrorMessage() {
	menuListPage.hideErrorMessage();
}
public void setMenuListErrorMessage(String error) {
	menuListPage.setErrorMessage(error);
}
public void menuListLoad(ObservableList<String> data) {
	menuListPage.setObservableList(data);
	this.getChildren().remove(0);
	this.getChildren().add(menuListPage);
	this.setVgrow(menuListPage, Priority.ALWAYS);
	
}



// menuDetails
/**
 * sets the menu Details settings button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuDetailsBtnSettingEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnSettingEventHandler(event);
}
/**
 * sets the menu Details output button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuDetailsBtnOutputEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnOutputEventHandler(event);
}
/**
 * sets the menu Details filter button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuDetailsBtnFilterEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnFilterEventHandler(event);
}
/**
 * sets the menu Details add button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuDetailsBtnAddEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnAddEventHandler(event);
}
/**
 * sets the menu Details find button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuDetailsBtnFindEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnFindEventHandler(event);
}
/**
 * sets the menu Details new dish button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuDetailsBtnNewDishEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnNewDishEventHandler(event);
}
/**
 * sets the menu Details Remove from list button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuDetailsBtnRemoveFromListEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnRemoveFromListEventHandler(event);
}
/**
 * sets the menu Details delete dish permently button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuDetailsBtnDeleteDishPermentlyFromListEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnDeleteDishPermenetlyFromListEventHandler(event);
}
/**
 * sets the menu Details edit button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuDetailsBtnEditEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnEditEventHandler(event);
}
/**
 * sets the menu Details load from file chooser button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuDetailsBtnLoadFromFileChooserEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnLoadFromFileChooserEventHandler(event);
}
/**
 * sets the menu Details about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuDetailsBtnAboutEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setAboutEventHandler(event);
}
public void MenuDetailsLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(menuDetails);
	this.setVgrow(menuDetails, Priority.ALWAYS);
}
public void setMenuDetailsDishList(ObservableList<String> dishes) {
	menuDetails.setDishes(dishes);
}
public void setMenuDetailsShoppingList(ObservableList<String> dishes) {	
	menuDetails.setShoppingListList(dishes);
}
public ObservableList<String> getMenuDetailsShoppingList(){
	return menuDetails.getShoppingListList();
}
public String getMenuDetailsFindUserInput() {
	return menuDetails.getFindUserInput();
}

public String getMenuDetailsDishListSelectedItemValueIdOnly() {
	
	return menuDetails.getDishListSelectedValue().substring(menuDetails.getDishListSelectedValue().indexOf("=")+2);
}
public Integer getMenuDetailsDishListSelectedItemIndex() {
	return menuDetails.getDishListSelectedIndex();
}
public void setMenuDetailsMenuListItems(ObservableList<String> items) {
	menuDetails.setMenuDishList(items);
}
public void setMenuDetailsBudgetValue(String amount) {
	menuDetails.setBudgetValue(amount);
}
public int getMenuDetailsMenuListSelectedIndex() {
	return menuDetails.getMenuListSelectedIndex();
}
public String getMenuDetailsMenuListSelectedValueName() {
	return menuDetails.getMenuListSelectedValueAsId();
}
public int getMenuDetailsMenuListSize() {
	return menuDetails.getMenuListSize(); 
}


public String getBudgetListSelectedItem() {
	
	if(budgetListPage.getSelectionNode().getSelectionModel().getSelectedItem()!= null) {
	return budgetListPage.getSelectionNode().getSelectionModel().getSelectedItem();
	}else {
		return "null";
	}
}



//menu filter
public void menuFilterLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(mf);
	this.setVgrow(mf, Priority.ALWAYS);
}
/**
 * sets the menu filter save button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenufilterBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	mf.setBtnSaveEventHandler(event);
}
/**
 * sets the menu filter cancel button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenufilterBtnCancelEventHandler(EventHandler<ActionEvent> event) {
	mf.setBtnCancelEventHandler(event);
}
/**
 * sets the menu filter about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenufilterBtnAboutEventHandler(EventHandler<ActionEvent> event) {
	mf.setAboutEventHandler(event);
}
public String getMenuFilterTotalCostBelow() {
	return mf.getTotalCostBelow();
}
public String getMenuFilterTotalCostAbove() {
	return mf.getTotalCostAbove();
}
public String getMenuFilterContainsDish() {
	return mf.getContainsDish();
}
public String getMenuFilterDoesntContainsDish() {
	return mf.getDoesntContainDish();
}


// menu settings

public void menuSettingsLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(msp);
	this.setVgrow(msp, Priority.ALWAYS);
}
/**
 * sets the menu settings save button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuSettingBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	msp.setBtnSaveEventHandler(event);
}
/**
 * sets the menu settings cancel button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuSettingBtnCancelEventHandler(EventHandler<ActionEvent> event) {
	msp.setBtnCancelEventHandler(event);
}
/**
 * sets the menu settings about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setMenuSettingBtnAboutEventHandler(EventHandler<ActionEvent> event) {
	msp.setAboutEventHandler(event);
}
public String getMenuSettingName() {
	return msp.getName();
}
public int getMenuSettingBudgetIndex() {
	return msp.getBudgetIndex();
}
public void setMenuSettingBudgetOptions(ObservableList<String> options) {
	msp.setBudgetOptions(options);
}
public String getMenuSettingSelectedBudgetOption() {
	return msp.getSelectedBudgetValue();
}
//outputPage
public void outputPageLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(output);
	this.setVgrow(output, Priority.ALWAYS);
}
/**
 * sets the output menu button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setOutputBtnMenuEventHandler(EventHandler<ActionEvent> event) {
	output.setBtnMenuEventHandler(event);
}
/**
 * sets the output shopping button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setOutputBtnShoppingEventHandler(EventHandler<ActionEvent> event) {
	output.setBtnShoppingEventHandler(event);
}
/**
 * sets the output save button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setOutputBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	output.setBtnSaveEventHandler(event);
}
/**
 * sets the output back to menu details button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setOutputBtnBackToMenuDetailsEventHandler(EventHandler<ActionEvent> event) {
	output.setBtnBackToMenuDetailsEventHandler(event);
}
/**
 * sets the output back to menu list button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setOutputBtnBackToMenuListEventHandler(EventHandler<ActionEvent> event) {
	output.setBtnBackToMenuListEventHandler(event);
}
/**
 * sets the output about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setOutputBtnAboutEventHandler(EventHandler<ActionEvent> event) {
	output.setAboutEventHandler(event);
}
//budgetList
/**
 * sets the budget list add button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBudgetListBtnAddEventHandler(EventHandler<ActionEvent> event) {
	/**
	 * sets the budget list filter button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */}
public void setBudgetListBtnFilterEventHandler(EventHandler<ActionEvent> event) {
	budgetListPage.setBtnFilterEventHandler(event);
}
/**
 * sets the budget list find button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBudgetListBtnFindEventHandler(EventHandler<ActionEvent> event) {
	budgetListPage.setBtnFindEventHandler(event);
}
/**
 * sets the budget list delete button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBudgetListBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
	budgetListPage.setBtnDeleteEventHandler(event);
}
/**
 * sets the budget list edit button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBudgetListBtnEditEventHandler(EventHandler<ActionEvent> event) {
	budgetListPage.setBtnEditEventHandler(event);
}
/**
 * sets the budget list about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBudgetListBtnAboutEventHandler(EventHandler<ActionEvent> event) {
	budgetListPage.setAboutEventHandler(event);
}
public void BudgetListLoad(ObservableList<String> data) {
	budgetListPage.getErrorLabel().setVisible(false);
	budgetListPage.setObservableList(data);
	this.getChildren().remove(0);
	this.getChildren().add(budgetListPage);
	this.setVgrow(budgetListPage, Priority.ALWAYS);
}

public String getBudgetTfFind() {
	return budgetListPage.getTfFindValue();
}
public void setBudgetListErrorMessage(String error) {
	budgetListPage.getErrorLabel().setText(error);
	budgetListPage.getErrorLabel().setVisible(true);
}

public String getSelectedBudgetId() {
	String budgetId = budgetListPage.getSelection();
	int idStart = budgetId.indexOf("id");
	int amountStart = budgetId.indexOf("amount");
	return budgetId.substring(idStart + 5, amountStart -2);
}

//budgetDetailsPage
/**
 * sets the budget details save button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBudgetDetailsBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	bdp.setBtnSaveEventHandler(event);
}
/**
 * sets the budget details about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBudgetDetailsBtnAboutEventHandler(EventHandler<ActionEvent> event) {
	bdp.setAboutEventHandler(event);
}
/**
 * sets the budget details cancel button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBudgetDetailsBtnCancelEventHandler(EventHandler<ActionEvent> event) {
	bdp.setBtnCancelEventHandler(event);
}

public void budgetDetailsLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(bdp);
	this.setVgrow(bdp, Priority.ALWAYS);
}

public String getBudgetDetailsInputtedName() {
	return bdp.getName().getText();
}
public String getBudgetDetailsInputtedAmount() {
	return bdp.getAmount().getText();
	
}
public String getBudgetDetailsInputtedStartDate() {
	return bdp.getStartDate().getEditor().getText();
			
}
public String getBudgetDetailsInputtedEndDate() {
	return bdp.getEndDate().getEditor().getText();
	//bdp.getEndDate().getEditor().
}
public LocalDate getBudgetDetailsInputtedStartDateAsLocalDate() {
	return bdp.getStartDate().getValue();
}
public LocalDate getBudgetDetailsInputtedEndDateAsLocalDate() {
	return bdp.getEndDate().getValue();
}
public void clearBudgetDetailsPage() {
	bdp.getName().clear();
	bdp.getAmount().clear();
	bdp.getStartDate().getEditor().clear();
	bdp.getEndDate().getEditor().clear();
}
public void setBudgetDetailsName(String name) {
	 bdp.getName().setText(name);
}
public void setBudgetDetailsAmount(String amount) {
	 bdp.getAmount().setText(amount);;
}
public void setBudgetDetailsStartDate(String startDate) {
	 bdp.getStartDate().getEditor().setText(startDate);
}
public void setBudgetDetailsEndDate(String endDate) {
	 bdp.getEndDate().getEditor().setText(endDate);
}
//budget filter

public void budgetfilterLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(budgetFilter);
	this.setVgrow(budgetFilter, Priority.ALWAYS);
}
/**
 * sets the budget filter save button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBudgetFilterBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	budgetFilter.setBtnSaveEventHandler(event);
}
/**
 * sets the budget filter cancel button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBudgetFilterBtnCancelEventHandler(EventHandler<ActionEvent> event) {
	budgetFilter.setBtnCancelEventHandler(event);
}
/**
 * sets the budget filter about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBudgetFilterBtnAboutEventHandler(EventHandler<ActionEvent> event) {
	budgetFilter.setAboutEventHandler(event);
}
public String getBudgetFilterNoBudgetLessThan() {
	return budgetFilter.getMinAmount().getText().toString();
}
public String getBudgetFilterNoBudgetMoreThan() {
	return budgetFilter.getMaxAmount().getText().toString();
}
public String getBudgetFilterStartsBeforeDateText() {
	return budgetFilter.getStartBefore().getEditor().getText();
}
public String getBudgetFilterStartsAfterDateText() {
	return budgetFilter.getStartAfter().getEditor().getText();
}
public String getBudgetFilterEndsBeforeDateText() {
	return budgetFilter.getEndsBefore().getEditor().getText();
}
public String getBudgetFilterEndsAfterDateText() {
	return budgetFilter.getEndsAfter().getEditor().getText();
}
public LocalDate getBudgetFilterStartsBeforeValuePresent() {
	return budgetFilter.getStartBefore().getValue();
}
public LocalDate getBudgetFilterStartsAfterValuePresent() {
	return budgetFilter.getStartAfter().getValue();
}
public LocalDate getBudgetFilterEndsBeforeValuePresent() {
	return budgetFilter.getEndsBefore().getValue();
}
public LocalDate getBudgetFilterEndsAfterValuePresent() {
	return budgetFilter.getEndsAfter().getValue();
}

//storagelocationlist
/**
 * sets the storage location add button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStorgaeLocationListBtnAddEventHandler(EventHandler<ActionEvent> event) {
	storageLocationListPage.setBtnAddEventHandler(event);
}
/**
 * sets the storage location filter button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStorgaeLocationListBtnFilterEventHandler(EventHandler<ActionEvent> event) {
	storageLocationListPage.setBtnFilterEventHandler(event);
}
/**
 * sets the storage location edit button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStorgaeLocationListBtnEditEventHandler(EventHandler<ActionEvent> event) {
	storageLocationListPage.setBtnEditEventHandler(event);
}
/**
 * sets the storage location about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStorgaeLocationListBtnAboutEventHandler(EventHandler<ActionEvent> event) {
	storageLocationListPage.setAboutEventHandler(event);
}
/**
 * sets the storage location delete button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStorgaeLocationListBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
	storageLocationListPage.setBtnDeleteEventHandler(event);
}
/**
 * sets the storage location find button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStorgaeLocationListBtnFindEventHandler(EventHandler<ActionEvent> event) {
	storageLocationListPage.setBtnFindEventHandler(event);
}
public void storgaeLocationListLoad(ObservableList<String> storageLocations) {
	storageLocationListPage.getErrorLabel().setVisible(false);
	storageLocationListPage.setObservableList(storageLocations);
	this.getChildren().remove(0);
	this.getChildren().add(storageLocationListPage);
	this.setVgrow(storageLocationListPage,Priority.ALWAYS);
}
public String getStorageLocationFindInput() {
	return storageLocationListPage.getTfFindValue();
}
public void setStorageListErrorMessage(String error) {
	storageLocationListPage.getErrorLabel().setVisible(true);
	storageLocationListPage.getErrorLabel().setText(error);
}
public void hideStorageListErrorMessage() {
	storageLocationListPage.getErrorLabel().setVisible(false);
}
public String getStorageListSelectedItem() {
	
	if(storageLocationListPage.getSelectionNode().getSelectionModel().getSelectedItem()!= null) {
	return storageLocationListPage.getSelectionNode().getSelectionModel().getSelectedItem();
	}else {
		return "null";
	}
}
public String getSelectedStorageId() {
	String storageId = storageLocationListPage.getSelection();
	int idStart = storageId.indexOf("=");
	int typeStart = storageId.indexOf("type");
	return storageId.substring(idStart + 2, typeStart -2);
}



//storageLocationDetails

public void StorgaeLocationDetailsLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(ssld);
	this.setVgrow(ssld,Priority.ALWAYS);
}
/**
 * sets the storage location details save button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStorageDetailsBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	ssld.setBtnSaveEventHandler(event);
}
/**
 * sets the storage location details cancel button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStorageDetailsBtnCancelEventHandler(EventHandler<ActionEvent> event) {
	ssld.setBtnCancelEventHandler(event);
}
/**
 * sets the storage location details about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStorageDetailsBtnAbooutEventHandler(EventHandler<ActionEvent> event) {
	ssld.setAboutEventHandler(event);
}
public String getStorageDetailsName() {
	return ssld.getName();
}
public String getStorageDetailsType() {
	return ssld.getType();
}
//yes = true, no = false
public Boolean getStorageDetailsAvailbilty() {
	return ssld.getAvailblity();
}
public void resetStorageLocationDetails() {
	ssld.reset();
}
public void setStorageLocationDetailsValues(String name, String type, Boolean isAvaible) {
	resetStorageLocationDetails();
	ssld.setDetailsValues(name, type, isAvaible);
	
	
}
//storgae location filter 

public void StorgaeLocationFilterLoad(ArrayList<String> type) {
	sslf.setType(type);
	this.getChildren().remove(0);
	this.getChildren().add(sslf);
	this.setVgrow(sslf,Priority.ALWAYS);
}
/**
 * sets the storage location filter apply button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStorageFilterBtnApplyEventHandler(EventHandler<ActionEvent> event) {
	sslf.setBtnApply(event);
}
/**
 * sets the storage location filter cancel button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStorageFilterBtnCancelEventHandler(EventHandler<ActionEvent> event) {
	sslf.setBtnCancelEventHandler(event);
}
/**
 * sets the storage location filter about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setStorageFilterBtnAboutEventHandler(EventHandler<ActionEvent> event) {
	sslf.setAboutEventHandler(event);
}
public Boolean getStorgaeFilterAvailbleStatus() {
	return sslf.getAvailblityStatus();
}
public String getStorgeFilterType() {
	return sslf.getSelectedType();
}
public Boolean StorageFilterHasATypeBeenSelected() {
	return sslf.hasATypeBeenSelectec();
}
//accountListPage
/**
 * sets the account list add button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setAccountListBtnAddEventHandler(EventHandler<ActionEvent> event) {
	accountListPage.setBtnAddEventHandler(event);
}
/**
 * sets the account list filter button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setAccountListBtnFilterEventHandler(EventHandler<ActionEvent> event) {
	accountListPage.setBtnFilterEventHandler(event);
}
/**
 * sets the account list find button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setAccountListBtnFindEventHandler(EventHandler<ActionEvent> event) {
	accountListPage.setBtnFindEventHandler(event);
}
/**
 * sets the account list edit button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setAccountListBtnEditEventHandler(EventHandler<ActionEvent> event) {
	accountListPage.setBtnEditEventHandler(event);
}
/**
 * sets the account list about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setAccountListBtnAboutEventHandler(EventHandler<ActionEvent> event) {
	accountListPage.setAboutEventHandler(event);
}
/**
 * sets the account list delete button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setAccountListBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
	accountListPage.setBtnDeleteEventHandler(event);
}
public String getAccountTfFindValue() {
	return accountListPage.getTfFindValue();
}
public void accountDetailsLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(ad);
	this.setVgrow(ad, Priority.ALWAYS);
}
public void setAccountListError(String errorMessgae) {
	accountListPage.getErrorLabel().setVisible(true);
	accountListPage.getErrorLabel().setText(errorMessgae);
}
public String getAccountListSelectedItem() {
	
	if(accountListPage.getSelectionNode().getSelectionModel().getSelectedItem()!= null) {
	return accountListPage.getSelectionNode().getSelectionModel().getSelectedItem();
	}else {
		return "null";
	}
}
public String getSelectedAccountName() {
	String accountId = accountListPage.getSelection();
	int usernameStart = accountId.indexOf("=");
	int accountStart = accountId.indexOf("account");
	return accountId.substring(usernameStart + 2, accountStart -2);
}

//account details
public void accountListLoad(ObservableList<String> data) {
	accountListPage.getErrorLabel().setVisible(false);
	accountListPage.setObservableList(data);
	this.getChildren().remove(0);
	this.getChildren().add(accountListPage);
	this.setVgrow(accountListPage, Priority.ALWAYS);
}
public String getAccountDetailsUserName() {
	return ad.getUsername();
}
public String getAccountDetailsUserPassword() {
	return ad.getPassword();
}
public Boolean getAccountDetailsIsAdminYesSelected() {
	return ad.isAdminYesSelected();
}
public Boolean getAccontDetailsIsAdminNoSelected() {
	return ad.isAdminNoSelected();
}
/**
 * sets the account details save button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setAccountDetailsBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	ad.setBtnSaveEventHandler(event);
}
/**
 * sets the account details cancel button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setAccountDetailsBtnCancelEventHandler(EventHandler<ActionEvent> event) {
	ad.setBtnCancelEventHandler(event);
}
/**
 * sets the account details about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setAccountDetailsBtnAboutEventHandler(EventHandler<ActionEvent> event) {
	ad.setAboutEventHandler(event);
}
public void setAccountDetailsUsername(String username) {
	ad.setUsername(username);
}
public void setAdminStatus(Boolean adminStatus) {
	ad.setAdminStatus(adminStatus);
}
public void resetAccountDetailPage() {
	ad.resetPage();
}
// account filter 

public void accountFilterLoad() {
	af.reset();
	this.getChildren().remove(0);
	this.getChildren().add(af);
	this.setVgrow(af, Priority.ALWAYS);
}
/**
 * sets the account filter apply button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setAccountFilterBtnApplyEventHandler(EventHandler<ActionEvent> event) {
	af.setBtnApply(event);
}
/**
 * sets the account filter cancel button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setAccountFilterBtnCancelEventHandler(EventHandler<ActionEvent> event) {
	af.setBtnCancelEventHandler(event);
}
/**
 * sets the account filter about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setAccountFilterBtnAboutEventHandler(EventHandler<ActionEvent> event) {
	af.setAboutEventHandler(event);
}

public Boolean getIsAdminYes() {
	return af.isYesSelected();
}
public Boolean getIsAdminNo() {
	return af.isNoSelected();
}
//DeleteConfirmaitonPage
/**
 * sets the delete confirm button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setDeleteConfirmationBtnConfirmEventHandler(EventHandler<ActionEvent> event) {
	dcp.setBtnConfirmEventHandler(event);
}
/**
 * sets the delete cancel button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setDeleteConfirmationBtnCancelEventHandler(EventHandler<ActionEvent> event) {
	dcp.setBtnCancelEventHandler(event);
}
/**
 * sets the delete confirm about event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setDeleteConfirmationBtnAboutEventHandler(EventHandler<ActionEvent> event) {
	dcp.setAboutEventHandler(event);
}

public void deleteConfirmationLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(dcp);
	this.setVgrow(dcp, Priority.ALWAYS);
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
/**
 * sets the dish details save button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setDishDetailsBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	ddp.setBtnSaveEventHandler(event);
}
/**
 * sets the dish details about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setDishDetailsBtnAboutEventHandler(EventHandler<ActionEvent> event) {
	ddp.setAboutEventHandler(event);
}
/**
 * sets the dish details add button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setDishDetailsBtnAddEventHandler(EventHandler<ActionEvent> event) {
	ddp.setBtnAddEventHandler(event);
}
/**
 * sets the dish details delete button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setDishDetailsBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
	ddp.setBtnDeleteEventHandler(event);
}
/**
 * sets the dish details edit button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setDishDetailsBtnEditEventHandler(EventHandler<ActionEvent> event) {
	ddp.setBtnEditEventHandler(event);
}
/**
 * sets the dish details cancel button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setDishDetailsBtnCanceltHandler(EventHandler<ActionEvent> event) {
	ddp.setBtnCancelEventHandler(event);
}
public String getDishDetailsDishName() {
	return ddp.getName();
}
public String getDishDetailsIngrdeintName() {
	return ddp.getIngredientName();
}
public String getDishDetailsQuanity() {
	return ddp.getQuanity();
}
public String getDishDetailsUnit() {
	return ddp.getUnit();
}
public String getDishDetailsEstimateCost() {
	return ddp.getEstimatedCost();
}

public void setDishDetailsList(ObservableList<String> ingredents) {
	ddp.setIngredentList(ingredents);
}
public int getDishDetailsSelectedIndex() {
	return ddp.getSelectedIndex();
			
}
public String getDishDetaulsSelectedId() {
	return ddp.getSelectedId();
}
public void dishDetailsAddReset() {
	ddp.addReset();
}
public String getDishDetailsSelectedItem() {
	return ddp.getSelectedValue();
}
public void setDishDetailsUserInput(String name, String quanity, String quanityType, String cost) {
	ddp.setUserInputValues(name, quanity, quanityType, cost);
}
public int getDishDetailsListSize() {
	return ddp.getIngredientListSize();
}


 
//filter dishes
public void dishFilterLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(fd);
	this.setVgrow(fd, Priority.ALWAYS);
}
/**
 * sets the filter dishes apply button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setDishFilterBtnApplyEventHandler(EventHandler<ActionEvent> event) {
	fd.setBtnApply(event);
}
/**
 * sets the filter dishes cancel button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setDishFilterBtnCancelEventHandler(EventHandler<ActionEvent> event) {
	fd.setBtnCancelEventHandler(event);
}/**
 * sets the filter dishes about button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setDishFilterBtnAboutEventHandler(EventHandler<ActionEvent> event) {
	fd.setAboutEventHandler(event);
}
public String getDishFilterCostMoreThan() {
	return fd.getCostMoreThan();
}
public String getDishFilterCostLessThan() {
	return fd.getCostLessThan();
}
public String getDishFilterNumberOfIngredeintsLessThan() {
	return fd.getNumberOfIngredientsLessThan();
}
public String getDishFilterNumberOfIngredeintsMoreThan() {
	return fd.getNumberOfIngredientsMoreThan();
}
}
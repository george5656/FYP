package view;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
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

public void homePageMenuLoad(Boolean isAdmin) {
	homePage.setHomePagetype(isAdmin);
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

public void setStockDetailsBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	sd.setBtnSaveEventHandler(event);
}
public void setStockDetailsBtnCancelEventHandler(EventHandler<ActionEvent> event) {
	sd.setBtnCancelEventHandler(event);
}
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

public void setStockFilterBtnApply(EventHandler<ActionEvent> event) {
	sf.setBtnApply(event);
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

public void setMenuListBtnFilterEventHandler(EventHandler<ActionEvent> event) {
	menuListPage.setBtnFilterEventHandler(event);
}
public void setMenuListBtnAddEventHandler(EventHandler<ActionEvent> event) {
	menuListPage.setBtnAddEventHandler(event);
}
public void setMenuListBtnFindEventHandler(EventHandler<ActionEvent> event) {
	menuListPage.setBtnFindEventHandler(event);
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
public void setMenuDetailsBtnFindEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnFindEventHandler(event);
}
public void setMenuDetailsBtnNewDishEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnNewDishEventHandler(event);
}
public void setMenuDetailsBtnRemoveFromListEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnRemoveFromListEventHandler(event);
}
public void setMenuDetailsBtnDeleteDishPermentlyFromListEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnDeleteDishPermenetlyFromListEventHandler(event);
}
public void setMenuDetailsBtnEditEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnEditEventHandler(event);
}
public void setMenuDetailsBtnLoadFromFileChooserEventHandler(EventHandler<ActionEvent> event) {
	menuDetails.setBtnLoadFromFileChooserEventHandler(event);
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
// menu settings

public void menuSettingsLoad() {
	this.getChildren().remove(0);
	this.getChildren().add(msp);
	this.setVgrow(msp, Priority.ALWAYS);
}
public void setMenuSettingBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	msp.setBtnSaveEventHandler(event);
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

public void setOutputBtnMenuEventHandler(EventHandler<ActionEvent> event) {
	output.setBtnMenuEventHandler(event);
}
public void setOutputBtnShoppingEventHandler(EventHandler<ActionEvent> event) {
	output.setBtnShoppingEventHandler(event);
}
public void setOutputBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	output.setBtnSaveEventHandler(event);
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
public void setBudgetListBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
	budgetListPage.setBtnDeleteEventHandler(event);
}
public void setBudgetListBtnEditEventHandler(EventHandler<ActionEvent> event) {
	budgetListPage.setBtnEditEventHandler(event);
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
public void setBudgetDetailsBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	bdp.setBtnSaveEventHandler(event);
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
public void setBudgetFilterBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	budgetFilter.setBtnSaveEventHandler(event);
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
public void setStorgaeLocationListBtnAddEventHandler(EventHandler<ActionEvent> event) {
	storageLocationListPage.setBtnAddEventHandler(event);
}
public void setStorgaeLocationListBtnFilterEventHandler(EventHandler<ActionEvent> event) {
	storageLocationListPage.setBtnFilterEventHandler(event);
}
public void setStorgaeLocationListBtnEditEventHandler(EventHandler<ActionEvent> event) {
	storageLocationListPage.setBtnEditEventHandler(event);
}
public void setStorgaeLocationListBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
	storageLocationListPage.setBtnDeleteEventHandler(event);
}
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

public void setStorageDetailsBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	ssld.setBtnSaveEventHandler(event);
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
public void setStorageFilterBtnApplyEventHandler(EventHandler<ActionEvent> event) {
	sslf.setBtnApply(event);
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
public void setAccountListBtnAddEventHandler(EventHandler<ActionEvent> event) {
	accountListPage.setBtnAddEventHandler(event);
}
public void setAccountListBtnFilterEventHandler(EventHandler<ActionEvent> event) {
	accountListPage.setBtnFilterEventHandler(event);
}
public void setAccountListBtnFindEventHandler(EventHandler<ActionEvent> event) {
	accountListPage.setBtnFindEventHandler(event);
}
public void setAccountListBtnEditEventHandler(EventHandler<ActionEvent> event) {
	accountListPage.setBtnEditEventHandler(event);
}
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
public void setAccountDetailsBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	ad.setBtnSaveEventHandler(event);
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
public void setAccountFilterBtnApplyEventHandler(EventHandler<ActionEvent> event) {
	af.setBtnApply(event);
}
public Boolean getIsAdminYes() {
	return af.isYesSelected();
}
public Boolean getIsAdminNo() {
	return af.isNoSelected();
}
//DeleteConfirmaitonPage

public void setDeleteConfirmationBtnConfirmEventHandler(EventHandler<ActionEvent> event) {
	dcp.setBtnConfirmEventHandler(event);
}
public void setDeleteConfirmationBtnCancelEventHandler(EventHandler<ActionEvent> event) {
	dcp.setBtnCancelEventHandler(event);
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

public void setDishDetailsBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	ddp.setBtnSaveEventHandler(event);
}
public void setDishDetailsBtnAddEventHandler(EventHandler<ActionEvent> event) {
	ddp.setBtnAddEventHandler(event);
}
public void setDishDetailsBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
	ddp.setBtnDeleteEventHandler(event);
}
public void setDishDetailsBtnEditEventHandler(EventHandler<ActionEvent> event) {
	ddp.setBtnEditEventHandler(event);
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

public void setDishFilterBtnApplyEventHandler(EventHandler<ActionEvent> event) {
	fd.setBtnApply(event);
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
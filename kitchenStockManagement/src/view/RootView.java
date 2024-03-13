package view;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.Account;
import model.Budget;
import model.CurrentStock;
import model.Dish;
import model.Menu;
import model.Recommedation;
import model.StockType;
import model.StorageLocation;

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
	private ListPage<CurrentStock> stockListPage = new ListPage<>();
	private MenuDetails menuDetails = new MenuDetails();
	private ListPage<Menu> menuListPage = new ListPage<>();
	private DeleteConfirmationPage dcp = new DeleteConfirmationPage();
	private DishDetailsPage ddp = new DishDetailsPage();
	private StockDetails sd = new StockDetails();
	private ListPage<Budget> budgetListPage = new ListPage<>();
	private BudgetDetailsPage bdp = new BudgetDetailsPage();
	private ListPage<StorageLocation> storageLocationListPage = new ListPage<>();
	private StockStorageLocationDetails ssld = new StockStorageLocationDetails();
	private AccountDetails ad = new AccountDetails();
	private ListPage<Account> accountListPage = new ListPage<>();
	private StockStorageLocationFilter sslf = new StockStorageLocationFilter();
	private StockFilter sf = new StockFilter();
	private FilterDishes fd = new FilterDishes();
	private AccountFilter af = new AccountFilter();
	private MenuFilter mf = new MenuFilter();
	private MenuSettingPage msp = new MenuSettingPage();
	private Output output = new Output();
	private AlertPage alert = new AlertPage();
	private Recommendations recommedationAdmin = new Recommendations();
	private RecommendationChefView recommedationChef = new RecommendationChefView();

	/**
	 * default constructor
	 */
	public RootView() {
		super(20);
		this.getChildren().add(login);
		VBox.setVgrow(login, Priority.ALWAYS);
		this.setAlignment(Pos.CENTER);
		this.setFillWidth(true);
	}

	/**
	 * get the stock list page
	 * 
	 * @return ListPage<CurrentStock>
	 */
	public ListPage<CurrentStock> getStockListPage() {
		return stockListPage;
	}

	/**
	 * gets the deleteCOnfirmationPage object
	 * 
	 * @return DeleteConfirmationPage
	 */
	public DeleteConfirmationPage getDeleteConfirmationPage() {
		return dcp;
	}

	/**
	 * gets the stockDetails page
	 * 
	 * @return StockDetails object
	 */
	public StockDetails getStockDetails() {
		return sd;
	}

	/**
	 * get the account list page
	 * 
	 * @return ListPage<Account>
	 */
	public ListPage<Account> getAccountListPage() {
		return accountListPage;
	}

	/**
	 * get the filter page for the storage locations
	 * 
	 * @return StockStorageLocationFilter object.
	 */
	public StockStorageLocationFilter getStockStorageLocationFilter() {
		return sslf;
	}

	/**
	 * get the filter page for the stock
	 * 
	 * @return StockFilter object.
	 */
	public StockFilter getStockFilter() {
		return sf;
	}

	/**
	 * get the filter page for the dishes
	 * 
	 * @return FilterDishes object.
	 */
	public FilterDishes getFilterDishes() {
		return fd;
	}

	/**
	 * get the filter page for the accounts
	 * 
	 * @return AccountFilter object.
	 */
	public AccountFilter getAccountFilter() {
		return af;
	}

	/**
	 * get the filter page for the menus
	 * 
	 * @return MenuFilter object.
	 */
	public MenuFilter getMenuFilter() {
		return mf;
	}

	/**
	 * gets the menu setting page
	 * 
	 * @return MenuSettingPage object.
	 */
	public MenuSettingPage getMenuSettingPage() {
		return msp;
	}

	/**
	 * reset the menu setting page
	 */
	public void clearMenuSettingPage() {
		msp.resetPage();
	}

	/**
	 * gets all the views that have instance in the RootView. get all the views the
	 * application has.
	 * 
	 * @return ArrayList<PaneMenu> All views downcast to the pane menu.
	 */
	public ArrayList<PaneMenu> getAllView() {
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
		all.add(alert);
		all.add(recommedationChef);
		all.add(recommedationAdmin);

		return all;
	}

//login 
	/**
	 * sets the exit button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setLoginBtnExit(EventHandler<ActionEvent> event) {
		login.setBtnExitEventHandler(event);
	}

	/**
	 * set the event handler for btnCancel on the recommedation page,
	 * 
	 * @param event = EventHandler<ActionEvent> event
	 */
	public void setAdminRecommedationBtnCancel(EventHandler<ActionEvent> event) {
		recommedationAdmin.setBtnCancel(event);
	}

	/**
	 * set the event handler for btnSave on the recommedation page,
	 * 
	 * @param event = EventHandler<ActionEvent> event
	 */
	public void setAdminRecommedationBtnSave(EventHandler<ActionEvent> event) {
		recommedationAdmin.setBtnSave(event);
	}

	/**
	 * gets the user input from the recommendation page
	 * 
	 * @return String
	 */
	public String getAdminRecommedationTextContent() {
		return recommedationAdmin.getRecommedation();
	}

	/**
	 * sets the event handler for btnBavk on the alert page
	 * 
	 * @param event = EventHandler<ActionEvent> event
	 */

	public void setAlertBtnBack(EventHandler<ActionEvent> event) {
		alert.setBtnBack(event);
	}

	/**
	 * sets the login button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setLoginBtnLogin(EventHandler<ActionEvent> event) {
		login.setBtnLoginEventHandler(event);
	}

	/**
	 * get the user input from the login page for the user name input
	 * 
	 * @return String which represent the user input in to the user name area
	 */
	public String getLoginUserUsernameInput() {
		return login.getUserUsernameInput();
	}

	/**
	 * get what the user input on the login page for the password. the input isn't
	 * hashed yet
	 * 
	 * @return String which is the user input for the password section in the login
	 *         page.
	 */
	public String getLoginUserPasswordInput() {
		return login.getUserPasswordInput();
	}

	/**
	 * loads the login page. it removes any children from the root view VBox, and
	 * add self in place so is visible it also clears all the user input.
	 */
	public void loginLoad() {
		this.getChildren().remove(0);
		this.getChildren().add(login);
		VBox.setVgrow(login, Priority.ALWAYS);
		login.clearInput();
	}

//home page
	/**
	 * sets the stock button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setHomeBtnStockEventHandler(EventHandler<ActionEvent> event) {
		homePage.setBtnStockEventHandler(event);
	}

	/**
	 * sets the home page about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setHomeBtnAboutEventHandler(EventHandler<ActionEvent> event) {
		homePage.setAboutEventHandler(event);
	}

	/**
	 * sets the menu button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setHomeBtnMenuEventHandler(EventHandler<ActionEvent> event) {
		homePage.setBtnMenuEventHandler(event);
	}

	/**
	 * sets the Account button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setHomeBtnAccountEventHandler(EventHandler<ActionEvent> event) {
		homePage.setBtnAccountEventHandler(event);
	}

	/**
	 * sets the budget button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setHomeBtnBudgetEventHandler(EventHandler<ActionEvent> event) {
		homePage.setBtnBudgetEventHandler(event);
	}

	/**
	 * sets the storage button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setHomeBtnStorageEventHandler(EventHandler<ActionEvent> event) {
		homePage.setBtnStorageEventHandler(event);
	}

	/**
	 * loads the home page it removes any children from the root view VBox, and add
	 * self in place so is visible the controls it shows are based of the input, if
	 * it is admin then it shows all, if it isnt admin it then shows a reduced set
	 * of options.
	 * 
	 * @param isAdmin = boolean, true = is admin, false = isnt admin
	 */
	public void homePageMenuLoad(Boolean isAdmin) {
		homePage.setHomePagetype(isAdmin);
		this.getChildren().remove(0);
		this.getChildren().add(homePage);
		VBox.setVgrow(homePage, Priority.ALWAYS);
	}

//stockListPage
	/**
	 * sets the stock delete button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStockListBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
		stockListPage.setBtnDeleteEventHandler(event);
	}

	/**
	 * sets the stock list page about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStockListBtnAboutEventHandler(EventHandler<ActionEvent> event) {
		stockListPage.setAboutEventHandler(event);
	}

	/**
	 * sets the stock add button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStockListBtnAddEventHandler(EventHandler<ActionEvent> event) {
		stockListPage.setBtnAddEventHandler(event);
	}

	/**
	 * sets the stock filter button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStockListBtnFilterEventHandler(EventHandler<ActionEvent> event) {
		stockListPage.setBtnFilterEventHandler(event);
	}

	/**
	 * loads the stock list page it removes any children from the root view VBox,
	 * and add self in place so is visible it reset the stock list page the inputed
	 * data is then shown in the table view, as well as making the tabeColumns and
	 * passing them to the table view.
	 * 
	 * @param data = ObservableList<CurrentStock> each iteration is a string
	 *             representation of stock
	 */

	public void stockListLoad(ObservableList<CurrentStock> data) {
		stockListPage.setObservableList(data);

		this.getChildren().remove(0);
		this.getChildren().add(stockListPage);
		VBox.setVgrow(stockListPage, Priority.ALWAYS);

		stockListPage.clearTableColumn();

		TableColumn<CurrentStock, String> name = new TableColumn<>("Name");
		TableColumn<CurrentStock, String> cost = new TableColumn<>("Cost");
		TableColumn<CurrentStock, String> quantityType = new TableColumn<>("Quantity Type");
		TableColumn<CurrentStock, String> location = new TableColumn<>("Storage Location");
		TableColumn<CurrentStock, String> quantity = new TableColumn<>("Quantity");
		TableColumn<CurrentStock, String> expiereDate = new TableColumn<>("Expiere Date");

		name.setCellValueFactory(new PropertyValueFactory<CurrentStock, String>("name"));
		cost.setCellValueFactory(new PropertyValueFactory<CurrentStock, String>("cost"));
		quantityType.setCellValueFactory(new PropertyValueFactory<CurrentStock, String>("quanityType"));
		location.setCellValueFactory(new PropertyValueFactory<CurrentStock, String>("storageLocationId"));
		quantity.setCellValueFactory(new PropertyValueFactory<CurrentStock, String>("quanity"));
		expiereDate.setCellValueFactory(new PropertyValueFactory<CurrentStock, String>("expiereDate"));

		ArrayList<TableColumn<CurrentStock, String>> tableColumns = new ArrayList<>();

		tableColumns.add(name);
		tableColumns.add(cost);
		tableColumns.add(quantityType);
		tableColumns.add(location);
		tableColumns.add(quantity);
		tableColumns.add(expiereDate);

		stockListPage.setTableColumns(tableColumns);

		stockListPage.getErrorLabel().setVisible(false);
		stockListPage.resetFindInput();

	}

	/**
	 * loads the alert page and set the table view underling data structure to be
	 * the passed in one
	 * 
	 * @param data = ObservableList<StockType> data
	 */
	public void alertPageLoad(ObservableList<StockType> data) {
		this.getChildren().remove(0);
		this.getChildren().add(alert);
		VBox.setVgrow(alert, Priority.ALWAYS);
		alert.setTableDataInfo(data);

	}

	/**
	 * loads the chef Recommedation page and set the table view underling data
	 * structure to be the passed in one
	 * 
	 * @param data = ObservableList<Recommedation> data
	 */
	public void chefRecommedationLoad(ObservableList<Recommedation> data) {
		this.getChildren().remove(0);
		this.getChildren().add(recommedationChef);
		VBox.setVgrow(recommedationChef, Priority.ALWAYS);
		recommedationChef.setData(data);
		recommedationChef.clearUserSelection();
	}

	/**
	 * loads the Admin Recommendation page.
	 */
	public void adminRecommedationLoad() {
		this.getChildren().remove(0);
		this.getChildren().add(recommedationAdmin);
		VBox.setVgrow(recommedationAdmin, Priority.ALWAYS);
		recommedationAdmin.clear();
	}

	/**
	 * set the event handler for the alert button on the home page
	 * 
	 * @param event = EventHandler<ActionEvent> event
	 */
	public void setHomeBtnAlertEventHandler(EventHandler<ActionEvent> event) {
		homePage.setBtnAlertEventHandler(event);
	}

	/**
	 * set the event handler for the chef recommedation button on the home page
	 * 
	 * @param event = EventHandler<ActionEvent> event
	 */
	public void setHomeBtnChefRecommedationtEventHandler(EventHandler<ActionEvent> event) {
		homePage.setBtnChefRecommedationEventHandler(event);
	}

	/**
	 * set the event handler for the admin recommendation button on the home page
	 * 
	 * @param event = EventHandler<ActionEvent> event
	 */
	public void setHomeBtnAdminRecommedationEventHandler(EventHandler<ActionEvent> event) {
		homePage.setBtnAdminRecommedatiobEventHandler(event);
	}

	/**
	 * sets the event handler for the button back on the chef accommodation page
	 * 
	 * @param event = EventHandler<ActionEvent> event
	 */
	public void setChefRecommedaitonBtnBackEventHandler(EventHandler<ActionEvent> event) {
		recommedationChef.setBtnBack(event);
	}

	/**
	 * sets the event handler for the button delete on the chef accommodation page
	 * 
	 * @param event = EventHandler<ActionEvent> event
	 */
	public void setChefRecommedaitonBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
		recommedationChef.setBtnDelete(event);
	}

	/**
	 * gets the id of the selected recommendation from the recommendation chef page
	 * 
	 * @return String which is a "null" if no item is selected.
	 */
	public String getChefRecommedationSelectedItemId() {
		return recommedationChef.getSelectedItemId();
	}

	/**
	 * gets the item that is selected in the listview in the stock list page.
	 * 
	 * @return String or null. if no item is selected null is returned, else it is
	 *         the string that is selected.
	 */
	public String getStockListSelectedItem() {

		if (stockListPage.getSelectionNode().getSelectionModel().getSelectedItem() != null) {
			return stockListPage.getSelectionNode().getSelectionModel().getSelectedItem().getName();
		} else {
			return "null";
		}
	}

	/**
	 * shows the user an error message on the stock list page.
	 * 
	 * @param errorMessgae = String which is an error message you want the user to
	 *                     be shown
	 */
	public void setStockListError(String errorMessgae) {
		stockListPage.getErrorLabel().setVisible(true);
		stockListPage.getErrorLabel().setText(errorMessgae);
	}

	/**
	 * sets the stock list find button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStockListBtnFindEventHandler(EventHandler<ActionEvent> event) {
		stockListPage.setBtnFindEventHandler(event);
	}

	/**
	 * sets the stock list edit button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStockListBtnEditEventHandler(EventHandler<ActionEvent> event) {
		stockListPage.setBtnEditEventHandler(event);
	}

	/**
	 * get the selected value in the table view from the stock list page but only
	 * the id part
	 * 
	 * @return String, which is the id of the stock selected in the table view.
	 */
	public String getSelectedStockId() {

		return String.valueOf(stockListPage.getSelection().getId());
	}

	/**
	 * get the user input in the find section on the stock list page.
	 * 
	 * @return String = user input in find section on stock list page.
	 */
	public String getStockListTfFindValue() {
		return stockListPage.getTfFindValue();
	}

	/**
	 * sets the table view underling data structure in the stock list page
	 * 
	 * @param data = ObservableList<CurrentStock>
	 */

	public void setStockListValues(ObservableList<CurrentStock> data) {
		stockListPage.setObservableList(data);
	}

// stock details 
	/**
	 * sets the stock details save button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStockDetailsBtnSaveEventHandler(EventHandler<ActionEvent> event) {
		sd.setBtnSaveEventHandler(event);
	}

	/**
	 * sets the stock details about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStockDetailsBtnAboutEventHandler(EventHandler<ActionEvent> event) {
		sd.setAboutEventHandler(event);
	}

	/**
	 * sets the stock details cancel button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStockDetailsBtnCancelEventHandler(EventHandler<ActionEvent> event) {
		sd.setBtnCancelEventHandler(event);
	}

	/**
	 * sets the stock details load from file button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStockDetailsBtnLoadFromFileEventHandler(EventHandler<ActionEvent> event) {
		sd.setBtnLoadFromFileEventHandler(event);
	}

//true means go to add, false means go to edit
	/**
	 * loads the stock details page. it removes any children from the root view
	 * VBox, and add self in place so is visible if add = true, it loads the add
	 * version of it else it loads the edit version of it.
	 * 
	 * @param add = boolean, true = from add, false = from edit.
	 */
	public void stockDetailsLoad(Boolean add) {
		this.getChildren().remove(0);
		this.getChildren().add(sd);
		VBox.setVgrow(sd, Priority.ALWAYS);

		if (add) {
			sd.setAddVarient();
		} else {
			sd.RemoveAddVarient();
		}

	}

	/**
	 * gets the user input for the stock name from the stock details page
	 * 
	 * @return String = user input for the stock name from the stock details page
	 */
	public String getStockDetailsStockName() {
		return sd.getStockName().getText();
	}

	/**
	 * gets the user input for the quantity from the stock details page
	 * 
	 * @return String = user input for the quantity from the stock details page
	 */
	public String getStockDetailsQuantity() {
		return sd.getQuanity().getText();
	}

	/**
	 * gets the user input for the quantity type from the stock details page
	 * 
	 * @return String = user input for the quantity type from the stock details page
	 */
	public String getStockDetailsQuanitType() {
		return sd.getQuantityType().getText();
	}

	/**
	 * gets the user input for the cost from the stock details page
	 * 
	 * @return String = user input for the cost from the stock details page
	 */
	public String getStockDetailsCost() {
		return sd.getCost().getText();
	}

	/**
	 * get the user input for the expire date from the stock details page. if the
	 * input is null get back null in string format
	 * 
	 * @return String or "null". represent the user input.
	 */
	public String getStockDetailsDateValue() {
		if (sd.getExpiereDate().getValue() != null) {
			return sd.getExpiereDate().getValue().toString();
		} else {
			return "null";
		}

	}

	/**
	 * get the user input for the stock details expire date. get the user input from
	 * the stock details page
	 * 
	 * @return LocalDate = the user input that the date picker has as a local date.
	 */
	public LocalDate getStockDetailsDateValueAsLocalDate() {

		return sd.getExpiereDate().getValue();
	}

	/**
	 * get the stock details expire date. get the user input from the stock details
	 * page get the textFild associated with the datePicker.
	 * 
	 * @return String or null, if no value found in date picker textField get null
	 *         as a string, else get the value.
	 */
	public String getStockDetailsDateText() {
		if (sd.getExpiereDate().getEditor().getText() != null) {
			return sd.getExpiereDate().getEditor().getText();
		} else {
			return "null";
		}

	}

	/**
	 * get the selected value from the storage location combo box. user input is
	 * from the stock details page.
	 * 
	 * @return String = Storage location Id that is selected.
	 */
	public String getStorageLocation() {
		return sd.getStorageLocation().getSelectionModel().getSelectedItem().toString();
	}

	/**
	 * resets the stock details page.
	 * 
	 * @param data = ObservableList<String> of all the storage location id so can be
	 *             populated in the storage Location combo box in the stock details
	 *             page.
	 */
	public void resetStockDetailsPage(ObservableList<String> data) {
		sd.getStorageLocation().getItems().clear();
		sd.getStorageLocation().getItems().addAll(data);
		sd.getStockName().clear();
		sd.getQuanity().clear();
		sd.getQuantityType().clear();
		sd.getExpiereDate().getEditor().clear();
		sd.getCost().clear();
	}

	/**
	 * set the stock details page, stock name to the inputed value
	 * 
	 * @param name = String want the stock name to be.
	 */
	public void setStockDetailsName(String name) {
		sd.getStockName().setText(name);
	}

	/**
	 * set the stock details page, Storage location to the inputed value
	 * 
	 * @param StorgeLocation = String want the storage location to be set as.
	 */
	public void setStockDetailsStorgeLocation(String StorgeLocation) {
		sd.getStorageLocation().setValue(StorgeLocation);
	}

	/**
	 * set the stock details page, quantity to the inputed value
	 * 
	 * @param Quanity = String want the quantity to be.
	 */
	public void setStockDetailsQuanity(String Quanity) {
		sd.getQuanity().setText(Quanity);
	}

	/**
	 * set the stock details page, stock quantity type to the inputed value
	 * 
	 * @param QuanityType = String want the stock quantity type to be.
	 */
	public void setStockDetailsQuanityType(String QuanityType) {
		sd.getQuantityType().setText(QuanityType);
	}

	/**
	 * set the stock details page, stock expire date to the inputed value
	 * 
	 * @param ExpiereDate = String want the stock expire date to be.
	 */
	public void setStockDetailsExpiereDate(String ExpiereDate) {
		sd.getExpiereDate().getEditor().setText(ExpiereDate);
	}

	/**
	 * set the stock details page, stock cost to the inputed value
	 * 
	 * @param Cost = String want the stock cost to be.
	 */
	public void setStockDetailsCost(String Cost) {
		sd.getCost().setText(Cost);
	}

// stock filter 
	/**
	 * sets the stock filter apply button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStockFilterBtnApply(EventHandler<ActionEvent> event) {
		sf.setBtnApply(event);
	}

	/**
	 * sets the stock filter about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStockFilterBtnAbout(EventHandler<ActionEvent> event) {
		sf.setAboutEventHandler(event);
	}

	/**
	 * sets the stock filter cancel button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStockFilterBtnCancel(EventHandler<ActionEvent> event) {
		sf.setBtnCancelEventHandler(event);
	}

	/**
	 * loads the stock filter page. it removes any children from the root view VBox,
	 * and adds self in place so is visible the parameter are there to populate the
	 * combo boxes on the screen.
	 * 
	 * @param storageLocations = ArrayList<String> for the combo box for storage
	 *                         location options to be
	 * @param stockType        = ArrayList<String> for the combo box for stock type
	 *                         options to be
	 */
	public void stockFilterLoad(ArrayList<String> storageLocations, ArrayList<String> stockType) {

		sf.getCbStorageLocation().getItems().clear();
		sf.getCbStorageLocation().getItems().addAll(storageLocations);

		sf.getCbStockType().getItems().clear();
		sf.getCbStockType().getItems().addAll(stockType);

		sf.resetPage();

		this.getChildren().remove(0);
		this.getChildren().add(sf);
		VBox.setVgrow(sf, Priority.ALWAYS);
	}

	/**
	 * get the user input, of min quantity input area. all input are from the stock
	 * filter page.
	 * 
	 * @return String = user input for the input area min quantity
	 */
	public String getStockFilterTfMinQunaity() {
		return sf.getTfMinQunaity().getText();
	}

	/**
	 * get the user input, of max quantity input area. all input are from the stock
	 * filter page.
	 * 
	 * @return String = user input for the input area max quantity
	 */
	public String getStockFilterTfMaxQunaity() {
		return sf.getTfMaxQuanity().getText();
	}

	/**
	 * gets the user inputed info from the expires after date. info it gets is from
	 * the datePicker associated textField. all inputs are from the stock filter
	 * page.
	 * 
	 * @return String that is in the datePicker textField.
	 */
	public String getStockFilterDpAfterDateText() {
		return sf.getDpAfterDate().getEditor().getText();
	}

	/**
	 * gets the user inputed info from the expires before date. info it gets is from
	 * the datePicker associated textField. all inputs are from the stock filter
	 * page.
	 * 
	 * @return String that is in the datePicker textField.
	 */
	public String getStockFilterDpBeforeDateText() {
		return sf.getDpBeforeDate().getEditor().getText();
	}

	/**
	 * gets the user inputed info from the expires after date. info it gets is from
	 * the datePicker held localDate. all inputs are from the stock filter page.
	 * 
	 * @return LocalDate that the datePicker has.
	 */
	public LocalDate getStockFilterDpAfterDateValuePresent() {
		return sf.getDpAfterDate().getValue();
	}

	/**
	 * gets the user inputed info from the expires before date. info it gets is from
	 * the datePicker held localDate. all inputs are from the stock filter page.
	 * 
	 * @return LocalDate that the datePicker has.
	 */
	public LocalDate getStockFilterDpBeforeDateValuePresent() {
		return sf.getDpBeforeDate().getValue();
	}

	/**
	 * get the user input, of above cost input area. all input are from the stock
	 * filter page.
	 * 
	 * @return String = user input for the input area above cost
	 */
	public String getStockFilterAboveCost() {
		return sf.getTfAboveCost().getText();
	}

	/**
	 * get the user input, of below cost input area. all input are from the stock
	 * filter page.
	 * 
	 * @return String = user input for the input area below cost
	 */
	public String getStockFilterBelowCost() {
		return sf.getTfBelowCost().getText();
	}

	/**
	 * gets the user input, of the selected storage location all input are from the
	 * stock filter page.
	 * 
	 * @return String or null. if nothing is selected null as string is returned
	 *         else the selected storage location id/name is returned as a string.
	 */
	public String getStockFilterStorgaeLocation() {

		if (sf.getCbStorageLocation().getSelectionModel().getSelectedItem() != null) {
			return sf.getCbStorageLocation().getSelectionModel().getSelectedItem();
		} else {
			return "null";
		}
	}

	/**
	 * gets the user input, of the selected stock type all input are from the stock
	 * filter page.
	 * 
	 * @return String or null. if nothing is selected null as string is returned
	 *         else the selected stock type id/name is returned as a string.
	 */
	public String getStockFilterStockType() {

		if (sf.getCbStockType().getSelectionModel().getSelectedItem() != null) {
			return sf.getCbStockType().getSelectionModel().getSelectedItem();
		} else {
			return "null";
		}
	}

//menuList
	/**
	 * sets the menu list apply filter button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuListBtnFilterEventHandler(EventHandler<ActionEvent> event) {
		menuListPage.setBtnFilterEventHandler(event);
	}

	/**
	 * sets the menu list apply add button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuListBtnAddEventHandler(EventHandler<ActionEvent> event) {
		menuListPage.setBtnAddEventHandler(event);
	}

	/**
	 * sets the menu list apply delete button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuListBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
		menuListPage.setBtnDeleteEventHandler(event);
	}

	/**
	 * sets the menu list apply find button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuListBtnFindEventHandler(EventHandler<ActionEvent> event) {
		menuListPage.setBtnFindEventHandler(event);
	}

	/**
	 * sets the menu list apply edit button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuListBtnEditEventHandler(EventHandler<ActionEvent> event) {
		menuListPage.setBtnEditEventHandler(event);
	}

	/**
	 * sets the menu list apply about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuListBtnAboutEventHandler(EventHandler<ActionEvent> event) {
		menuListPage.setAboutEventHandler(event);
	}

	/**
	 * gets the menu which is selected from the list view in the menu list page.
	 * 
	 * @return String or null. null as a string is returned if there is no
	 *         selection, else the menu in its string format is returned.
	 */
	public String getMenuListSelectedMenu() {
		if (menuListPage.getSelectionNode().getSelectionModel().getSelectedItem() != null) {
			return menuListPage.getSelectionNode().getSelectionModel().getSelectedItem().getName();
		} else {
			return "null";
		}
	}

	/**
	 * get the menu which has been selected from the table view in the menu list
	 * page, but only gives its id.
	 * 
	 * @return String = the selected menu id
	 */
	public String getMenuListSelectedMenuId() {
		return menuListPage.getSelectionNode().getSelectionModel().getSelectedItem().getName();

	}

	/**
	 * shows the user an error message on the menu list page.
	 * 
	 * @param errorMessgae = String which is an error message you want the user to
	 *                     be shown
	 */
	public void setMenuListError(String errorMessage) {
		menuListPage.getErrorLabel().setVisible(true);
		menuListPage.getErrorLabel().setText(errorMessage);
	}

	/**
	 * get the user input in the find section on the menu list page.
	 * 
	 * @return String = user input in find section on menu list page.
	 */
	public String getMenuListFindUserInput() {
		return menuListPage.getTfFindValue();

	}

	/**
	 * hides the error message on the menu list page.
	 */
	public void hideMenuListErrorMessage() {
		menuListPage.hideErrorMessage();
	}

	/**
	 * shows the user an error message on the menu list page.
	 * 
	 * @param errorMessgae = String which is an error message you want the user to
	 *                     be shown
	 */
	public void setMenuListErrorMessage(String error) {
		menuListPage.setErrorMessage(error);
	}

	/**
	 * loads the menu list page it removes any children from the root view VBox, and
	 * add self in place so is visible the inputed data is then shown in the table
	 * view. it also make the tableColumns and sets them up in the table view.
	 * 
	 * @param data = ObservableList<Menu>
	 */

	public void menuListLoad(ObservableList<Menu> data) {

		menuListPage.clearTableColumn();

		TableColumn<Menu, String> name = new TableColumn<>("Menu Name");

		name.setCellValueFactory(new PropertyValueFactory<Menu, String>("name"));
		ArrayList<TableColumn<Menu, String>> tableColumns = new ArrayList<>();

		tableColumns.add(name);

		menuListPage.setTableColumns(tableColumns);

		menuListPage.getErrorLabel().setVisible(false);
		menuListPage.setObservableList(data);
		menuListPage.resetFindInput();
		this.getChildren().remove(0);
		this.getChildren().add(menuListPage);
		VBox.setVgrow(menuListPage, Priority.ALWAYS);

	}

// menuDetails
	/**
	 * sets the menu Details settings button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuDetailsBtnSettingEventHandler(EventHandler<ActionEvent> event) {
		menuDetails.setBtnSettingEventHandler(event);
	}

	/**
	 * sets the menu Details output button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuDetailsBtnOutputEventHandler(EventHandler<ActionEvent> event) {
		menuDetails.setBtnOutputEventHandler(event);
	}

	/**
	 * sets the menu Details filter button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuDetailsBtnFilterEventHandler(EventHandler<ActionEvent> event) {
		menuDetails.setBtnFilterEventHandler(event);
	}

	/**
	 * sets the menu Details add button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuDetailsBtnAddEventHandler(EventHandler<ActionEvent> event) {
		menuDetails.setBtnAddEventHandler(event);
	}

	/**
	 * sets the menu Details find button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuDetailsBtnFindEventHandler(EventHandler<ActionEvent> event) {
		menuDetails.setBtnFindEventHandler(event);
	}

	/**
	 * sets the menu Details new dish button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuDetailsBtnNewDishEventHandler(EventHandler<ActionEvent> event) {
		menuDetails.setBtnNewDishEventHandler(event);
	}

	/**
	 * sets the menu Details Remove from list button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuDetailsBtnRemoveFromListEventHandler(EventHandler<ActionEvent> event) {
		menuDetails.setBtnRemoveFromListEventHandler(event);
	}

	/**
	 * sets the menu Details delete dish permently button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuDetailsBtnDeleteDishPermentlyFromListEventHandler(EventHandler<ActionEvent> event) {
		menuDetails.setBtnDeleteDishPermenetlyFromListEventHandler(event);
	}

	/**
	 * sets the menu Details edit button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuDetailsBtnEditEventHandler(EventHandler<ActionEvent> event) {
		menuDetails.setBtnEditEventHandler(event);
	}

	/**
	 * sets the menu Details load from file chooser button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuDetailsBtnLoadFromFileChooserEventHandler(EventHandler<ActionEvent> event) {
		menuDetails.setBtnLoadFromFileChooserEventHandler(event);
	}

	/**
	 * sets the menu Details about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuDetailsBtnAboutEventHandler(EventHandler<ActionEvent> event) {
		menuDetails.setAboutEventHandler(event);
	}

	/**
	 * loads the menu details page. it removes any children from the root view VBox,
	 * and add self in place so is visible
	 */

	public void MenuDetailsLoad() {

		menuDetails.clearTablesColumns();

		TableColumn<Dish, String> dName = new TableColumn<>("All Dishes Names");
		TableColumn<Dish, String> mName = new TableColumn<>("All Dishes In Menu Name");
		TableColumn<StockType, String> slName = new TableColumn<>("Name");
		TableColumn<StockType, String> slCost = new TableColumn<>("Cost");
		TableColumn<StockType, String> slQuanityType = new TableColumn<>("Quantity Type");
		TableColumn<StockType, String> slQuanity = new TableColumn<>("Quantity");

		dName.setCellValueFactory(new PropertyValueFactory<Dish, String>("dishName"));
		mName.setCellValueFactory(new PropertyValueFactory<Dish, String>("dishName"));
		slName.setCellValueFactory(new PropertyValueFactory<StockType, String>("name"));
		slCost.setCellValueFactory(new PropertyValueFactory<StockType, String>("cost"));
		slQuanityType.setCellValueFactory(new PropertyValueFactory<StockType, String>("quanityType"));
		slQuanity.setCellValueFactory(new PropertyValueFactory<StockType, String>("quanity"));

		menuDetails.setDishColumn(dName);
		menuDetails.setMenuColumn(mName);

		ArrayList<TableColumn<StockType, String>> shoppingColumns = new ArrayList<>();

		shoppingColumns.add(slName);
		shoppingColumns.add(slCost);
		shoppingColumns.add(slQuanityType);
		shoppingColumns.add(slQuanity);

		menuDetails.setShoppingColumns(shoppingColumns);

		this.getChildren().remove(0);
		this.getChildren().add(menuDetails);
		VBox.setVgrow(menuDetails, Priority.ALWAYS);
	}

	/**
	 * sets the menu details dish List view. set the values to be the passed in
	 * value
	 * 
	 * @param dishes ObservableList<String> = values to be shown in the dish list.
	 */
	public void setMenuDetailsDishList(ObservableList<Dish> dishes) {
		menuDetails.setDishes(dishes);
	}

	/**
	 * sets the menu details shopping list view. set the values to be the passed in
	 * value
	 * 
	 * @param dishes ObservableList<String> = values to be shown in the shopping
	 *               list.
	 */
	public void setMenuDetailsShoppingList(ObservableList<StockType> dishes) {
		menuDetails.setShoppingListList(dishes);
	}

	/**
	 * gets the user input for the find input area. input from the menu details
	 * page.
	 * 
	 * @return String = the user input.
	 */
	public String getMenuDetailsFindUserInput() {
		return menuDetails.getFindUserInput();
	}

	/**
	 * gets the selected item from the dish list, list view but only the items id.
	 * selection from the menu details page.
	 * 
	 * @return String = selected items id.
	 */
	public String getMenuDetailsDishListSelectedItemValueIdOnly() {
		return menuDetails.getDishListSelectedValue().getDishName();
	}

	/**
	 * gets the selected value name in the menu details shopping list
	 * 
	 * @return String = Name of the selected stock type from the shopping list
	 */
	public String getMenuDetailsShoppingListSelectedItemValueIdOnly() {
		return menuDetails.getShoppingListSelectedValue().getName();
	}

	/**
	 * get the selected value from the table view in the menu details shopping list
	 * 
	 * @return StockType
	 */
	public StockType getMenuDetailsShoppungListSelctedItem() {
		return menuDetails.getShoppingListSelectedValue();
	}

	/**
	 * gets the selected item from the Menu list, list view but only the items id.
	 * selection from the menu details page.
	 * 
	 * @return String = selected items id.
	 */
	public String getMenuDetailsMenuDishListSelectedItemValueIdOnly() {
		return menuDetails.getMenuListSelectedValue().getDishName();
	}

	/**
	 * removes the user selection from the menu details lists. it doesn't remove
	 * selection from shipping list as user doesn't interact with it for anything.
	 */
	public void clearMenuDetailsListSelection() {
		menuDetails.deSelect();
	}

	/**
	 * gets the selected item index in list view from the dish list, list view.
	 * selection from the menu details page.
	 * 
	 * @return Integer = selected items index.
	 */
	public Integer getMenuDetailsDishListSelectedItemIndex() {
		return menuDetails.getDishListSelectedIndex();
	}

	/**
	 * sets the menu details menu list, list view. set the values to be the passed
	 * in value
	 * 
	 * @param items ObservableList<String> = values to be shown in the menu list.
	 */
	public void setMenuDetailsMenuListItems(ObservableList<Dish> items) {
		menuDetails.setMenuDishList(items);
	}

	/**
	 * resets the menu details page menu and shopping list views. (middle and right
	 * ones) and also the find input area
	 */
	public void resetMenuDetailsPage() {
		menuDetails.resetMenuAndShoppingListContent();
	}

	/**
	 * clears the find text field user input. its located on the menu details page
	 */
	public void MenuDetailsRestFindInput() {
		menuDetails.clearFindUserInput();
	}

	/**
	 * sets the label in the menuDetails page. format is Budget = amount
	 * 
	 * @param amount = String, which should be a double in a string format.
	 */
	public void setMenuDetailsBudgetValue(String amount) {
		menuDetails.setBudgetValue(amount);
	}

	/**
	 * gets the selected item index in list view from the menu list, list view.
	 * selection from the menu details page.
	 * 
	 * @return Int = selected items index.
	 */
	public int getMenuDetailsMenuListSelectedIndex() {
		return menuDetails.getMenuListSelectedIndex();
	}

	/**
	 * get the value that is selected, in the menu details menu table view
	 * 
	 * @return Dish, which the underling data structure holds for that selected
	 *         value.
	 */
	public Dish getMenuDetailsMenuListSelecteditem() {
		return menuDetails.getMenuListSelectedValue();
	}

	/**
	 * get the index of the the item selected in the menu details shopping lst table
	 * view
	 * 
	 * @return int
	 */
	public int getMenuDetailsShoppingListSelectedIndex() {
		return menuDetails.getShoppingListSelectedIndex();
	}

	/*
	 * new method
	 */
	/**
	 * unselects the user selection for the table views, menu and shopping list in
	 * the menu details page.
	 */
	public void unselectMenuDetailsMenuAndshoppingListSelection() {
		menuDetails.unselectMenuAndshoppingList();
	}

	/**
	 * gets the selected item from the menu list, list view but only the items name.
	 * selection from the menu details page.
	 * 
	 * @return String = selected items name.
	 */
	public String getMenuDetailsMenuListSelectedValueName() {
		return menuDetails.getMenuListSelectedValueAsId();
	}

	/**
	 * get the size of the menu list. list located on the menu details page.
	 * 
	 * @return int = menu list size.
	 */
	public int getMenuDetailsMenuListSize() {
		return menuDetails.getMenuListSize();
	}

	/**
	 * gets the item that is selected in the listview in the budget list page.
	 * 
	 * @return String or null. if no item is selected null is returned, else it is
	 *         the string that is selected.
	 */
	public String getBudgetListSelectedItem() {

		if (budgetListPage.getSelectionNode().getSelectionModel().getSelectedItem() != null) {
			return budgetListPage.getSelectionNode().getSelectionModel().getSelectedItem().getBudgetId();
		} else {
			return "null";
		}
	}

//menu filter
	/**
	 * loads the menu filter page it removes any children from the root view VBox,
	 * and add self in place so is visible
	 */
	public void menuFilterLoad() {
		mf.resetPage();
		this.getChildren().remove(0);
		this.getChildren().add(mf);
		VBox.setVgrow(mf, Priority.ALWAYS);
	}

	/**
	 * sets the menu filter save button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenufilterBtnSaveEventHandler(EventHandler<ActionEvent> event) {
		mf.setBtnSaveEventHandler(event);
	}

	/**
	 * sets the menu filter cancel button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenufilterBtnCancelEventHandler(EventHandler<ActionEvent> event) {
		mf.setBtnCancelEventHandler(event);
	}

	/**
	 * sets the menu filter about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenufilterBtnAboutEventHandler(EventHandler<ActionEvent> event) {
		mf.setAboutEventHandler(event);
	}

	/**
	 * get the user input for total cost below input area. get the user input from
	 * the page, menu filter.
	 * 
	 * @return String representing the total cost below user input
	 */
	public String getMenuFilterTotalCostBelow() {
		return mf.getTotalCostBelow();
	}

	/**
	 * get the user input for total cost above input area. get the user input from
	 * the page, menu filter.
	 * 
	 * @return String representing the total cost above user input
	 */
	public String getMenuFilterTotalCostAbove() {
		return mf.getTotalCostAbove();
	}

	/**
	 * get the user input for contains dish input area. get the user input from the
	 * page, menu filter.
	 * 
	 * @return String representing the contains dish user input
	 */
	public String getMenuFilterContainsDish() {
		return mf.getContainsDish();
	}

	/**
	 * get the user input for doesnt contains dish input area. get the user input
	 * from the page, menu filter.
	 * 
	 * @return String representing the doenst contains dish user input
	 */
	public String getMenuFilterDoesntContainsDish() {
		return mf.getDoesntContainDish();
	}

	/**
	 * loads the menu settings page. it removes any children from the root view
	 * VBox, and add self in place so is visible it also sets the input on the page
	 * to the passed in inputs
	 * 
	 * @param budget = String, sets the budget combo box in menu setting page to
	 *               select the passed in value
	 * @param name   = string, sets the budget name input in menu setting page to
	 *               the passed in string
	 */
	public void menuSettingsLoad(String budget, String name) {
		this.getChildren().remove(0);
		this.getChildren().add(msp);
		VBox.setVgrow(msp, Priority.ALWAYS);
		if (!budget.equals("null")) {
			msp.setSettingUserInput(budget, name);
		}
	}

	/**
	 * sets the menu settings save button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuSettingBtnSaveEventHandler(EventHandler<ActionEvent> event) {
		msp.setBtnSaveEventHandler(event);
	}

	/**
	 * sets the menu settings cancel button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuSettingBtnCancelEventHandler(EventHandler<ActionEvent> event) {
		msp.setBtnCancelEventHandler(event);
	}

	/**
	 * sets the menu settings about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setMenuSettingBtnAboutEventHandler(EventHandler<ActionEvent> event) {
		msp.setAboutEventHandler(event);
	}

	/**
	 * get user input for the menu name input. input from menu setting page
	 * 
	 * @return String = user input in to menu name input area.
	 */
	public String getMenuSettingName() {
		return msp.getName();
	}

	/**
	 * get the index of the budget selected in the combo box. combo box is in the
	 * menu setting page.
	 * 
	 * @return Int = index of the item selected in the combo box.
	 */
	public int getMenuSettingBudgetIndex() {
		return msp.getBudgetIndex();
	}

	/**
	 * sets the options for the combo box in the menu setting page. input meant to
	 * be, the budgets.
	 * 
	 * @param options = ObservableList<String>
	 */
	public void setMenuSettingBudgetOptions(ObservableList<String> options) {
		msp.setBudgetOptions(options);
	}

	/**
	 * gets the budget selected in the combo box. combo box is the budget one in the
	 * menu settings page.
	 * 
	 * @return String = budget name/id as a string of the selected budget.
	 */
	public String getMenuSettingSelectedBudgetOption() {
		return msp.getSelectedBudgetValue();
	}

//outputPage
	/**
	 * loads the output page. it removes any children from the root view VBox, and
	 * add self in place so is visible
	 */
	public void outputPageLoad() {
		this.getChildren().remove(0);
		this.getChildren().add(output);
		VBox.setVgrow(output, Priority.ALWAYS);
	}

	/**
	 * sets the output menu button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setOutputBtnMenuEventHandler(EventHandler<ActionEvent> event) {
		output.setBtnMenuEventHandler(event);
	}

	/**
	 * sets the output shopping button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setOutputBtnShoppingEventHandler(EventHandler<ActionEvent> event) {
		output.setBtnShoppingEventHandler(event);
	}

	/**
	 * sets the output save button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setOutputBtnSaveEventHandler(EventHandler<ActionEvent> event) {
		output.setBtnSaveEventHandler(event);
	}

	/**
	 * sets the output back to menu details button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setOutputBtnBackToMenuDetailsEventHandler(EventHandler<ActionEvent> event) {
		output.setBtnBackToMenuDetailsEventHandler(event);
	}

	/**
	 * sets the output back to menu list button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setOutputBtnBackToMenuListEventHandler(EventHandler<ActionEvent> event) {
		output.setBtnBackToMenuListEventHandler(event);
	}

	/**
	 * sets the output about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setOutputBtnAboutEventHandler(EventHandler<ActionEvent> event) {
		output.setAboutEventHandler(event);
	}

//budgetList
	/**
	 * sets the budget list add button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBudgetListBtnAddEventHandler(EventHandler<ActionEvent> event) {
		budgetListPage.setBtnAddEventHandler(event);
	}

	/**
	 * sets the budget list filter button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBudgetListBtnFilterEventHandler(EventHandler<ActionEvent> event) {
		budgetListPage.setBtnFilterEventHandler(event);
	}

	/**
	 * sets the budget list find button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBudgetListBtnFindEventHandler(EventHandler<ActionEvent> event) {
		budgetListPage.setBtnFindEventHandler(event);
	}

	/**
	 * sets the budget list delete button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBudgetListBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
		budgetListPage.setBtnDeleteEventHandler(event);
	}

	/**
	 * sets the budget list edit button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBudgetListBtnEditEventHandler(EventHandler<ActionEvent> event) {
		budgetListPage.setBtnEditEventHandler(event);
	}

	/**
	 * sets the budget list about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBudgetListBtnAboutEventHandler(EventHandler<ActionEvent> event) {
		budgetListPage.setAboutEventHandler(event);
	}

	/**
	 * loads the budget list page it removes any children from the root view VBox,
	 * and add self in place so is visible it reset the budget list page the inputed
	 * data is set as the table view, underling data structure, it also make the
	 * table columns for the table view.
	 * 
	 * @param data = ObservableList<Budget>
	 */

	public void BudgetListLoad(ObservableList<Budget> data) {

		budgetListPage.clearTableColumn();

		TableColumn<Budget, String> id = new TableColumn<>("Id");
		TableColumn<Budget, String> amount = new TableColumn<>("Amount");
		TableColumn<Budget, String> start = new TableColumn<>("Start Date");
		TableColumn<Budget, String> end = new TableColumn<>("End Date");

		id.setCellValueFactory(new PropertyValueFactory<Budget, String>("budgetId"));
		amount.setCellValueFactory(new PropertyValueFactory<Budget, String>("amount"));
		start.setCellValueFactory(new PropertyValueFactory<Budget, String>("startDate"));
		end.setCellValueFactory(new PropertyValueFactory<Budget, String>("endDate"));

		ArrayList<TableColumn<Budget, String>> tableColumns = new ArrayList<>();

		tableColumns.add(id);
		tableColumns.add(amount);
		tableColumns.add(start);
		tableColumns.add(end);

		budgetListPage.setTableColumns(tableColumns);

		budgetListPage.getErrorLabel().setVisible(false);
		budgetListPage.setObservableList(data);
		budgetListPage.resetFindInput();
		this.getChildren().remove(0);
		this.getChildren().add(budgetListPage);
		VBox.setVgrow(budgetListPage, Priority.ALWAYS);
	}

	/**
	 * get the user input in the find section on the budget list page.
	 * 
	 * @return String = the user input in find section on budget list page.
	 */
	public String getBudgetTfFind() {
		return budgetListPage.getTfFindValue();
	}

	/**
	 * shows the user an error message on the budget list page.
	 * 
	 * @param errorMessgae = String which is an error message you want the user to
	 *                     be shown
	 */
	public void setBudgetListErrorMessage(String error) {
		budgetListPage.getErrorLabel().setText(error);
		budgetListPage.getErrorLabel().setVisible(true);
	}

	/**
	 * get the id of the selected value, from the table view which is located in the
	 * budget list page.
	 * 
	 * @return String, which is the id of the selected item.
	 */
	public String getSelectedBudgetId() {

		return budgetListPage.getSelection().getBudgetId();
	}

//budgetDetailsPage
	/**
	 * sets the budget details save button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBudgetDetailsBtnSaveEventHandler(EventHandler<ActionEvent> event) {
		bdp.setBtnSaveEventHandler(event);
	}

	/**
	 * sets the budget details about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBudgetDetailsBtnAboutEventHandler(EventHandler<ActionEvent> event) {
		bdp.setAboutEventHandler(event);
	}

	/**
	 * sets the budget details cancel button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBudgetDetailsBtnCancelEventHandler(EventHandler<ActionEvent> event) {
		bdp.setBtnCancelEventHandler(event);
	}

	/**
	 * loads the budget details page. it removes any children from the root view
	 * VBox, and add self in place so is visible.
	 */

	public void budgetDetailsLoad() {

		this.getChildren().remove(0);
		this.getChildren().add(bdp);
		VBox.setVgrow(bdp, Priority.ALWAYS);

	}

	/**
	 * gets the user input for the budget name. user input comes form the budget
	 * details page.
	 * 
	 * @return String = the user input for the budget name.
	 */
	public String getBudgetDetailsInputtedName() {
		return bdp.getName().getText();
	}

	/**
	 * gets the user input for the budget amount user input comes form the budget
	 * details page.
	 * 
	 * @return String = the user input for the budget amount.
	 */
	public String getBudgetDetailsInputtedAmount() {
		return bdp.getAmount().getText();
	}

	/**
	 * gets the user input for the start date. user input comes form the budget
	 * details page. get the value in the textField that is associated with the date
	 * picker
	 * 
	 * @return String = the value in the textField.
	 */

	public String getBudgetDetailsInputtedStartDate() {

		if (bdp.getStartDate().getEditor().getText() != null) {
			return bdp.getStartDate().getEditor().getText();
		} else {
			return "null";
		}

	}

	/**
	 * gets the user input for the end date. user input comes form the budget
	 * details page. get the value in the textField that is associated with the date
	 * picker
	 * 
	 * @return String = the value in the textField.
	 */
	public String getBudgetDetailsInputtedEndDate() {

		if (bdp.getEndDate().getEditor().getText() != null) {
			return bdp.getEndDate().getEditor().getText();
		} else {
			return "null";
		}

	}

	/**
	 * gets the user input for the start date. user input comes form the budget
	 * details page. gets the local date that the datePicker has
	 * 
	 * @return LocalDate that the datePicker has
	 */
	public LocalDate getBudgetDetailsInputtedStartDateAsLocalDate() {
		return bdp.getStartDate().getValue();
	}

	/**
	 * reset the date picker value in the budget details page
	 */
	public void resetBudgetDetailsPageDatePickers() {
		bdp.resetDatePickers();
	}

	/**
	 * reset the date picker value in the stock details page
	 */
	public void resetStockDetailsPageDatePicker() {
		sd.resetDatePicker();
	}

	/**
	 * gets the user input for the end date. user input comes form the budget
	 * details page. gets the local date that the datePicker has
	 * 
	 * @return LocalDate that the datePicker has
	 */

	public LocalDate getBudgetDetailsInputtedEndDateAsLocalDate() {
		return bdp.getEndDate().getValue();
	}

	/**
	 * reset the budget details page. clears all the user input
	 */
	public void clearBudgetDetailsPage() {
		bdp.getName().clear();
		bdp.getAmount().clear();
		bdp.getStartDate().getEditor().clear();
		bdp.getEndDate().getEditor().clear();
	}

	/**
	 * sets the budget details page name input to the passed in parameter.
	 * 
	 * @param name = String
	 */
	public void setBudgetDetailsName(String name) {
		bdp.getName().setText(name);
	}

	/**
	 * sets the budget details page amount input to the passed in parameter.
	 * 
	 * @param amount = String that is a double in a string format
	 */
	public void setBudgetDetailsAmount(String amount) {
		bdp.getAmount().setText(amount);
	}

	/**
	 * sets the budget details page start date input to the passed in parameter.
	 * 
	 * @param startDate = String
	 */
	public void setBudgetDetailsStartDate(String startDate) {
		bdp.getStartDate().getEditor().setText(startDate);
	}

	/**
	 * sets the budget details page end date input to the passed in parameter.
	 * 
	 * @param endDate = String
	 */
	public void setBudgetDetailsEndDate(String endDate) {
		bdp.getEndDate().getEditor().setText(endDate);
	}

//budget filter
	/**
	 * loads the budget filter page it removes any children from the root view VBox,
	 * and add self in place so is visible
	 */
	public void budgetfilterLoad() {
		budgetFilter.resetPage();
		this.getChildren().remove(0);
		this.getChildren().add(budgetFilter);
		VBox.setVgrow(budgetFilter, Priority.ALWAYS);
	}

	/**
	 * sets the budget filter save button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBudgetFilterBtnSaveEventHandler(EventHandler<ActionEvent> event) {
		budgetFilter.setBtnSaveEventHandler(event);
	}

	/**
	 * sets the budget filter cancel button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBudgetFilterBtnCancelEventHandler(EventHandler<ActionEvent> event) {
		budgetFilter.setBtnCancelEventHandler(event);
	}

	/**
	 * sets the budget filter about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBudgetFilterBtnAboutEventHandler(EventHandler<ActionEvent> event) {
		budgetFilter.setAboutEventHandler(event);
	}

	/**
	 * gets the user input for the no budget has less than user input get the user
	 * input from the budgetFilter page.
	 * 
	 * @return String = the user input.
	 */
	public String getBudgetFilterNoBudgetLessThan() {
		return budgetFilter.getMinAmount().getText().toString();
	}

	/**
	 * gets the user input for the no budget has more than user input get the user
	 * input from the budgetFilter page.
	 * 
	 * @return String = the user input.
	 */
	public String getBudgetFilterNoBudgetMoreThan() {
		return budgetFilter.getMaxAmount().getText().toString();
	}

	/**
	 * gets the user input for the starts before date. get the user input from the
	 * budgetFilter page.
	 * 
	 * @return String that is what the textFiled of starts before date user inputs
	 *         holds.
	 */
	public String getBudgetFilterStartsBeforeDateText() {
		return budgetFilter.getStartBefore().getEditor().getText();
	}

	/**
	 * gets the user input for the starts after date. get the user input from the
	 * budgetFilter page.
	 * 
	 * @return String that is what the textFiled of starts after date user inputs
	 *         holds.
	 */
	public String getBudgetFilterStartsAfterDateText() {
		return budgetFilter.getStartAfter().getEditor().getText();
	}

	/**
	 * gets the user input for the ends before date. get the user input from the
	 * budgetFilter page.
	 * 
	 * @return String that is what the textFiled of ends before date user inputs
	 *         holds.
	 */
	public String getBudgetFilterEndsBeforeDateText() {
		return budgetFilter.getEndsBefore().getEditor().getText();
	}

	/**
	 * gets the user input for the ends after date. get the user input from the
	 * budgetFilter page.
	 * 
	 * @return String that is what the textFiled of ends after date user inputs
	 *         holds.
	 */
	public String getBudgetFilterEndsAfterDateText() {
		return budgetFilter.getEndsAfter().getEditor().getText();
	}

	/**
	 * gets the user input for the starts before date. get the user input from the
	 * budgetFilter page.
	 * 
	 * @return LocalDate which the datePicker holds from the user input.
	 */
	public LocalDate getBudgetFilterStartsBeforeValuePresent() {
		return budgetFilter.getStartBefore().getValue();
	}

	/**
	 * gets the user input for the starts after date. get the user input from the
	 * budgetFilter page.
	 * 
	 * @return LocalDate which the datePicker holds from the user input.
	 */
	public LocalDate getBudgetFilterStartsAfterValuePresent() {
		return budgetFilter.getStartAfter().getValue();
	}

	/**
	 * gets the user input for the ends before date. get the user input from the
	 * budgetFilter page.
	 * 
	 * @return LocalDate which the datePicker holds from the user input.
	 */
	public LocalDate getBudgetFilterEndsBeforeValuePresent() {
		return budgetFilter.getEndsBefore().getValue();
	}

	/**
	 * gets the user input for the ends after date. get the user input from the
	 * budgetFilter page.
	 * 
	 * @return LocalDate which the datePicker holds from the user input.
	 */
	public LocalDate getBudgetFilterEndsAfterValuePresent() {
		return budgetFilter.getEndsAfter().getValue();
	}

//storagelocationlist
	/**
	 * sets the storage location add button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStorgaeLocationListBtnAddEventHandler(EventHandler<ActionEvent> event) {
		storageLocationListPage.setBtnAddEventHandler(event);
	}

	/**
	 * sets the storage location filter button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStorgaeLocationListBtnFilterEventHandler(EventHandler<ActionEvent> event) {
		storageLocationListPage.setBtnFilterEventHandler(event);
	}

	/**
	 * sets the storage location edit button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStorgaeLocationListBtnEditEventHandler(EventHandler<ActionEvent> event) {
		storageLocationListPage.setBtnEditEventHandler(event);
	}

	/**
	 * sets the storage location about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStorgaeLocationListBtnAboutEventHandler(EventHandler<ActionEvent> event) {
		storageLocationListPage.setAboutEventHandler(event);
	}

	/**
	 * sets the storage location delete button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStorgaeLocationListBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
		storageLocationListPage.setBtnDeleteEventHandler(event);
	}

	/**
	 * sets the storage location find button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStorgaeLocationListBtnFindEventHandler(EventHandler<ActionEvent> event) {
		storageLocationListPage.setBtnFindEventHandler(event);
	}

	/**
	 * loads the storage location list page it removes any children from the root
	 * view VBox, and add self in place so is visible it reset the storage list page
	 * the input is the passed to the table view to be its underling data structure.
	 * it also make the table columns for table view.
	 * 
	 * @param storageLocations = ObservableList<StorageLocation>
	 */

	public void storgaeLocationListLoad(ObservableList<StorageLocation> storageLocations) {

		storageLocationListPage.clearTableColumn();

		TableColumn<StorageLocation, String> name = new TableColumn<>("Name");
		TableColumn<StorageLocation, String> type = new TableColumn<>("Type");
		TableColumn<StorageLocation, String> available = new TableColumn<>("Is Avaible");

		name.setCellValueFactory(new PropertyValueFactory<StorageLocation, String>("name"));
		type.setCellValueFactory(new PropertyValueFactory<StorageLocation, String>("type"));
		available.setCellValueFactory(new PropertyValueFactory<StorageLocation, String>("isAvailble"));

		ArrayList<TableColumn<StorageLocation, String>> tableColumns = new ArrayList<>();

		tableColumns.add(name);
		tableColumns.add(type);
		tableColumns.add(available);

		storageLocationListPage.setTableColumns(tableColumns);

		storageLocationListPage.getErrorLabel().setVisible(false);
		storageLocationListPage.setObservableList(storageLocations);
		storageLocationListPage.resetFindInput();
		this.getChildren().remove(0);
		this.getChildren().add(storageLocationListPage);
		VBox.setVgrow(storageLocationListPage, Priority.ALWAYS);
	}

	/**
	 * get the user input in the find section on the storage location list page.
	 * 
	 * @return String = the user input in find section on the storage location list
	 *         page.
	 */
	public String getStorageLocationFindInput() {
		return storageLocationListPage.getTfFindValue();
	}

	/**
	 * shows the user an error message on the storage location list page.
	 * 
	 * @param errorMessgae = String which is an error message you want the user to
	 *                     be shown
	 */
	public void setStorageListErrorMessage(String error) {
		storageLocationListPage.getErrorLabel().setVisible(true);
		storageLocationListPage.getErrorLabel().setText(error);
	}

	/**
	 * hides the error message on the storage location list page.
	 */
	public void hideStorageListErrorMessage() {
		storageLocationListPage.getErrorLabel().setVisible(false);
	}

	/**
	 * gets the item that is selected in the listview in the storage location list
	 * page.
	 * 
	 * @return String or null. if no item is selected null is returned, else it is
	 *         the string that is selected.
	 */
	public String getStorageListSelectedItem() {

		if (storageLocationListPage.getSelectionNode().getSelectionModel().getSelectedItem() != null) {
			return storageLocationListPage.getSelectionNode().getSelectionModel().getSelectedItem().getName();
		} else {
			return "null";
		}
	}

	/**
	 * gets the selected storage location id. selection is made in the storage
	 * location list page. the id that is given is not the index id, but the id that
	 * is shown in the list view/ what the string displays.
	 * 
	 * @return String = selected storage id
	 */
	/*
	 * complete changed
	 */
	/**
	 * get the selected item name. the selection is the one made in the storage
	 * location list page, by selecting an item in the table view.
	 * 
	 * @return string, which is the selected value name.
	 */
	public String getSelectedStorageId() {

		return storageLocationListPage.getSelection().getName();
	}

	/**
	 * loads the Storage location details page. it removes any children from the
	 * root view VBox, and add self in place so is visible
	 */
	public void StorgaeLocationDetailsLoad() {
		this.getChildren().remove(0);
		this.getChildren().add(ssld);
		VBox.setVgrow(ssld, Priority.ALWAYS);
	}

	/**
	 * sets the storage location details save button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStorageDetailsBtnSaveEventHandler(EventHandler<ActionEvent> event) {
		ssld.setBtnSaveEventHandler(event);
	}

	/**
	 * sets the storage location details cancel button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStorageDetailsBtnCancelEventHandler(EventHandler<ActionEvent> event) {
		ssld.setBtnCancelEventHandler(event);
	}

	/**
	 * sets the storage location details about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStorageDetailsBtnAbooutEventHandler(EventHandler<ActionEvent> event) {
		ssld.setAboutEventHandler(event);
	}

	/**
	 * get the user input for the storage location name. input comes from the
	 * storage location details page.
	 * 
	 * @return String = storage location name
	 */
	public String getStorageDetailsName() {
		return ssld.getName();
	}

	/**
	 * get the user input for the storage location type input comes from the storage
	 * location details page.
	 * 
	 * @return String = storage location type
	 */
	public String getStorageDetailsType() {
		return ssld.getType();
	}

//yes = true, no = false
	/**
	 * get the user input for the storage location is available. input comes from
	 * the storage location details page.
	 * 
	 * @return Boolean = true = yes, false = no
	 */
	public Boolean getStorageDetailsAvailbilty() {
		return ssld.getAvailblity();
	}

	/**
	 * resets the storage location details page. removes all the user input from the
	 * input areas.
	 */
	public void resetStorageLocationDetails() {
		ssld.reset();
	}

	/**
	 * sets the storage location details page input areas to the passed in values
	 * 
	 * @param name      = String
	 * @param type      = String
	 * @param isAvaible = boolean, true =yes, false = no
	 */
	public void setStorageLocationDetailsValues(String name, String type, Boolean isAvaible) {
		resetStorageLocationDetails();
		ssld.setDetailsValues(name, type, isAvaible);

	}
//storgae location filter 

	/**
	 * loads the storage location filter page. it removes any children from the root
	 * view VBox, and add self in place so is visible it also sets the the combo box
	 * values to be the passed in parameters
	 * 
	 * @param type = ArrayList<String> of the values to be shown in the combo box.
	 */
	public void StorgaeLocationFilterLoad(ArrayList<String> type) {
		sslf.setType(type);
		sslf.resetPage();
		this.getChildren().remove(0);
		this.getChildren().add(sslf);
		VBox.setVgrow(sslf, Priority.ALWAYS);
	}

	/**
	 * sets the storage location filter apply button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStorageFilterBtnApplyEventHandler(EventHandler<ActionEvent> event) {
		sslf.setBtnApply(event);
	}

	/**
	 * sets the storage location filter cancel button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStorageFilterBtnCancelEventHandler(EventHandler<ActionEvent> event) {
		sslf.setBtnCancelEventHandler(event);
	}

	/**
	 * sets the storage location filter about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setStorageFilterBtnAboutEventHandler(EventHandler<ActionEvent> event) {
		sslf.setAboutEventHandler(event);
	}

	/**
	 * get the storage location filter page, is available user input.
	 * 
	 * @return boolean = true = yes, false = no
	 */
	public Boolean getStorgaeFilterAvailbleStatus() {
		return sslf.getAvailblityStatus();
	}

	/**
	 * get the storage location filter page, selected type.
	 * 
	 * @return String = user input
	 */
	public String getStorgeFilterType() {
		return sslf.getSelectedType();
	}

	/**
	 * says if the combo box on the stock storage location has had an item be
	 * selected.
	 * 
	 * @return boolean true = no item has been selected, false = an item has been
	 *         selected.
	 */
	public Boolean StorageFilterHasATypeBeenSelected() {
		return sslf.hasATypeBeenSelectec();
	}

//accountListPage
	/**
	 * sets the account list add button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setAccountListBtnAddEventHandler(EventHandler<ActionEvent> event) {
		accountListPage.setBtnAddEventHandler(event);
	}

	/**
	 * sets the account list filter button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setAccountListBtnFilterEventHandler(EventHandler<ActionEvent> event) {
		accountListPage.setBtnFilterEventHandler(event);
	}

	/**
	 * sets the account list find button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setAccountListBtnFindEventHandler(EventHandler<ActionEvent> event) {
		accountListPage.setBtnFindEventHandler(event);
	}

	/**
	 * sets the account list edit button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setAccountListBtnEditEventHandler(EventHandler<ActionEvent> event) {
		accountListPage.setBtnEditEventHandler(event);
	}

	/**
	 * sets the account list about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setAccountListBtnAboutEventHandler(EventHandler<ActionEvent> event) {
		accountListPage.setAboutEventHandler(event);
	}

	/**
	 * sets the account list delete button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setAccountListBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
		accountListPage.setBtnDeleteEventHandler(event);
	}

	/**
	 * get the user input in the find section on the account list page.
	 * 
	 * @return String = the user input in find section on account list page.
	 */
	public String getAccountTfFindValue() {
		return accountListPage.getTfFindValue();
	}

	/**
	 * loads the account details page. it removes any children from the root view
	 * VBox, and add self in place so is visible
	 */
	public void accountDetailsLoad() {
		this.getChildren().remove(0);
		this.getChildren().add(ad);
		VBox.setVgrow(ad, Priority.ALWAYS);
	}

	/**
	 * shows the user an error message on the account list page.
	 * 
	 * @param errorMessgae = String which is an error message you want the user to
	 *                     be shown
	 */
	public void setAccountListError(String errorMessgae) {
		accountListPage.getErrorLabel().setVisible(true);
		accountListPage.getErrorLabel().setText(errorMessgae);
	}

	/**
	 * gets the item that is selected in the listview in the accounts list page.
	 * 
	 * @return String or null. if no item is selected null is returned, else it is
	 *         the string that is selected.
	 */
	public String getAccountListSelectedItem() {

		if (accountListPage.getSelectionNode().getSelectionModel().getSelectedItem() != null) {
			return accountListPage.getSelectionNode().getSelectionModel().getSelectedItem().getUsername();
		} else {
			return "null";
		}
	}

	/**
	 * 
	 * get the selected account name only account is selected on the account list
	 * page in the table view. it then gets the underling data structure item that
	 * was selected and gets its name
	 * 
	 * @return String = account name.
	 */

	public String getSelectedAccountName() {

		return accountListPage.getSelection().getUsername();
	}

//account details
	/**
	 * loads the account list page it removes any children from the root view VBox,
	 * and add self in place so is visible it reset the account list page the
	 * inputed data is set as the table view underling data. it also make the table
	 * columns which are set in the table view.
	 * 
	 * @param data = ObservableList<Account>
	 */
	public void accountListLoad(ObservableList<Account> data) {
		accountListPage.clearTableColumn();

		TableColumn<Account, String> username = new TableColumn<>("Username");
		TableColumn<Account, String> isAccountAdmin = new TableColumn<>("Is Account Admin");

		username.setCellValueFactory(new PropertyValueFactory<Account, String>("username"));
		isAccountAdmin.setCellValueFactory(new PropertyValueFactory<Account, String>("isAdmin"));

		ArrayList<TableColumn<Account, String>> tableColumns = new ArrayList<>();

		tableColumns.add(username);
		tableColumns.add(isAccountAdmin);

		accountListPage.setTableColumns(tableColumns);

		accountListPage.getErrorLabel().setVisible(false);
		accountListPage.setObservableList(data);
		accountListPage.resetFindInput();
		this.getChildren().remove(0);
		this.getChildren().add(accountListPage);
		VBox.setVgrow(accountListPage, Priority.ALWAYS);
	}

	/**
	 * gets the account details page, user name user input
	 * 
	 * @return String = user input in to the user name area.
	 */
	public String getAccountDetailsUserName() {
		return ad.getUsername();
	}

	/**
	 * gets the account details page, password the user inputed
	 * 
	 * @return String = user input in to the password area.
	 */
	public String getAccountDetailsUserPassword() {
		return ad.getPassword();
	}

	/**
	 * if the radio button yes has been selected on the account details page.
	 * 
	 * @return boolean = true = it is ticked.
	 */
	public Boolean getAccountDetailsIsAdminYesSelected() {
		return ad.isAdminYesSelected();
	}

	/**
	 * if the radio button no has been selected on the account details page.
	 * 
	 * @return boolean = true = it is ticked.
	 */
	public Boolean getAccontDetailsIsAdminNoSelected() {
		return ad.isAdminNoSelected();
	}

	/**
	 * sets the account details save button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setAccountDetailsBtnSaveEventHandler(EventHandler<ActionEvent> event) {
		ad.setBtnSaveEventHandler(event);
	}

	/**
	 * sets the account details cancel button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setAccountDetailsBtnCancelEventHandler(EventHandler<ActionEvent> event) {
		ad.setBtnCancelEventHandler(event);
	}

	/**
	 * sets the account details about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setAccountDetailsBtnAboutEventHandler(EventHandler<ActionEvent> event) {
		ad.setAboutEventHandler(event);
	}

	/**
	 * sets the account details page user name input to the passed in parameter
	 * 
	 * @param username = String
	 */
	public void setAccountDetailsUsername(String username) {
		ad.setUsername(username);
	}

	/**
	 * sets the account details page, is admin radio group radio buttons.
	 * 
	 * @param adminStatus = boolean, true = yes selected, false = no selected.
	 */
	public void setAdminStatus(Boolean adminStatus) {
		ad.setAdminStatus(adminStatus);
	}

	/**
	 * resets the account detail page. all user input is removed.
	 */
	public void resetAccountDetailPage() {
		ad.resetPage();
	}

// account filter 
	/**
	 * loads the account filter page it removes any children from the root view
	 * VBox, and add self in place so is visible and reset the account filter page
	 */
	public void accountFilterLoad() {
		af.reset();
		this.getChildren().remove(0);
		this.getChildren().add(af);
		VBox.setVgrow(af, Priority.ALWAYS);
	}

	/**
	 * sets the account filter apply button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setAccountFilterBtnApplyEventHandler(EventHandler<ActionEvent> event) {
		af.setBtnApply(event);
	}

	/**
	 * sets the account filter cancel button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setAccountFilterBtnCancelEventHandler(EventHandler<ActionEvent> event) {
		af.setBtnCancelEventHandler(event);
	}

	/**
	 * sets the account filter about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setAccountFilterBtnAboutEventHandler(EventHandler<ActionEvent> event) {
		af.setAboutEventHandler(event);
	}

	/**
	 * gets if the account filter page is admin yes is clicked.
	 * 
	 * @return Boolean, true = it is selected, false = it isnt selected.
	 */
	public Boolean getIsAdminYes() {
		return af.isYesSelected();
	}

	/**
	 * gets if the account filter page is admin no is clicked.
	 * 
	 * @return Boolean, true = it is selected, false = it isnt selected.
	 */
	public Boolean getIsAdminNo() {
		return af.isNoSelected();
	}

//DeleteConfirmaitonPage
	/**
	 * sets the delete confirm button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setDeleteConfirmationBtnConfirmEventHandler(EventHandler<ActionEvent> event) {
		dcp.setBtnConfirmEventHandler(event);
	}

	/**
	 * sets the delete cancel button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setDeleteConfirmationBtnCancelEventHandler(EventHandler<ActionEvent> event) {
		dcp.setBtnCancelEventHandler(event);
	}

	/**
	 * sets the delete confirm about event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setDeleteConfirmationBtnAboutEventHandler(EventHandler<ActionEvent> event) {
		dcp.setAboutEventHandler(event);
	}

	/**
	 * loads the delete confirmation page. it removes any children from the root
	 * view VBox, and add self in place so is visible
	 */
	public void deleteConfirmationLoad() {
		this.getChildren().remove(0);
		this.getChildren().add(dcp);
		VBox.setVgrow(dcp, Priority.ALWAYS);
	}

	/**
	 * sets the menu bar, home and logout event handler
	 * 
	 * @param home   = Event handler<ActionEvent>
	 * @param Logout = Event handler<ActionEvent>
	 */
	public void setAllPaneMenu(EventHandler<ActionEvent> home, EventHandler<ActionEvent> Logout) {
		ArrayList<PaneMenu> all = getAllView();
		for (PaneMenu i : all) {
			i.setHomeEventHandler(home);
			i.setLogoutEventHandler(Logout);
		}
	}

// dish 
	/**
	 * loads the dish details page. it removes any children from the root view VBox,
	 * and add self in place so is visible
	 */
	public void dishDetailsLoad() {

		ddp.clearTableColumn();

		TableColumn<StockType, String> name = new TableColumn<>("Name");
		TableColumn<StockType, String> cost = new TableColumn<>("Cost");
		TableColumn<StockType, String> quantityType = new TableColumn<>("Quantity Type");
		TableColumn<StockType, String> quanity = new TableColumn<>("Quantity");

		name.setCellValueFactory(new PropertyValueFactory<StockType, String>("name"));
		cost.setCellValueFactory(new PropertyValueFactory<StockType, String>("cost"));
		quantityType.setCellValueFactory(new PropertyValueFactory<StockType, String>("quanityType"));
		quanity.setCellValueFactory(new PropertyValueFactory<StockType, String>("quanity"));

		ddp.setDishNameLabel("No dish name");

		ArrayList<TableColumn<StockType, String>> tableColumns = new ArrayList<>();
		tableColumns.add(name);
		tableColumns.add(cost);
		tableColumns.add(quantityType);
		tableColumns.add(quanity);

		ddp.setTableColumns(tableColumns);

		this.getChildren().remove(0);
		this.getChildren().add(ddp);
		ddp.hideErrorMessage();
		VBox.setVgrow(ddp, Priority.ALWAYS);
	}

	/**
	 * set the text of the label in the dish details page and make it visible
	 * 
	 * @param errorMessage = String which is the text you want to show.
	 */
	public void setDishDetailsErrorMessage(String errorMessage) {
		ddp.setErrorMessage(errorMessage);
	}

	/**
	 * hides the label that represent the error message on dish details page
	 */
	public void setDishDetailsErrorMessageFalse() {
		ddp.hideErrorMessage();
	}

	/**
	 * sets the dish details save button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setDishDetailsBtnSaveEventHandler(EventHandler<ActionEvent> event) {
		ddp.setBtnSaveEventHandler(event);
	}

	/**
	 * sets the dish details about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setDishDetailsBtnAboutEventHandler(EventHandler<ActionEvent> event) {
		ddp.setAboutEventHandler(event);
	}

	/**
	 * sets the dish details add button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setDishDetailsBtnAddEventHandler(EventHandler<ActionEvent> event) {
		ddp.setBtnAddEventHandler(event);
	}

	/**
	 * sets the dish details delete button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setDishDetailsBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
		ddp.setBtnDeleteEventHandler(event);
	}

	/**
	 * sets the dish details edit button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setDishDetailsBtnEditEventHandler(EventHandler<ActionEvent> event) {
		ddp.setBtnEditEventHandler(event);
	}

	/**
	 * sets the dish details cancel button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setDishDetailsBtnCanceltHandler(EventHandler<ActionEvent> event) {
		ddp.setBtnCancelEventHandler(event);
	}

	/**
	 * get the user input for the dish name. all info come from the dish details
	 * page, user input
	 * 
	 * @return String which represent the dish name user input
	 */
	public String getDishDetailsDishName() {
		return ddp.getName();
	}

	/**
	 * get the user input for the ingredient name. all info come from the dish
	 * details page, user input
	 * 
	 * @return String which represent the ingredient name user input
	 */
	public String getDishDetailsIngrdeintName() {
		return ddp.getIngredientName();
	}

	/**
	 * get the user input for the quantity. all info come from the dish details
	 * page, user input
	 * 
	 * @return String which represent the quantity user input
	 */
	public String getDishDetailsQuanity() {
		return ddp.getQuanity();
	}

	/**
	 * get the user input for the unit/quantity type. all info come from the dish
	 * details page, user input
	 * 
	 * @return String which represent the unit/quantity type user input
	 */
	public String getDishDetailsUnit() {
		return ddp.getUnit();
	}

	/**
	 * get the user input for the estimate cost. all info come from the dish details
	 * page, user input
	 * 
	 * @return String which represent the estimated cost user input
	 */
	public String getDishDetailsEstimateCost() {
		return ddp.getEstimatedCost();
	}

	/**
	 * sets the dish details page table view underling data structure, and the label
	 * that displays the dish name to the dish name input parameter.
	 * 
	 * @param ingredents = observableList<StockType>
	 * @param dishName   = String this is the name of the dish name
	 */
	public void setDishDetailsList(ObservableList<StockType> ingredents, String dishName) {
		ddp.setIngredentList(ingredents);
		ddp.setDishNameLabel(dishName);
	}

	/**
	 * clears all the input and listview on the dish details page.
	 */
	public void clearDishDetailsPage() {
		ddp.resetWholePage();
	}

	/**
	 * get the index of the item selected in the list view which is in dish details
	 * page,
	 * 
	 * @return int =index of the selected item
	 */
	public int getDishDetailsSelectedIndex() {
		return ddp.getSelectedIndex();
	}

	/**
	 * get the id of the item selected in the list view which is in dish details
	 * page,
	 * 
	 * @return String = the id of the selected item
	 */
	public String getDishDetaulsSelectedId() {
		return ddp.getSelectedId();
	}

	/**
	 * clears all the input areas of the dish details page
	 */
	public void dishDetailsAddReset() {
		ddp.addReset();
	}

	/**
	 * gets the item which has been selected in the table view. the table view is
	 * located in the dish details page
	 * 
	 * @return StockType
	 */
	public StockType getDishDetailsSelectedItem() {
		return ddp.getSelectedValue();
	}

	/**
	 * sets the dish details page user input areas with the provided info.
	 * 
	 * @param name        = string, goes in the ingredient name section.
	 * @param quanity     = String which is a double in a string format, goes in the
	 *                    quantity section.
	 * @param quanityType = string, goes in the unit section.
	 * @param cost        = String which is a double in a string format, goes in the
	 *                    Estimated cost section.
	 */
	public void setDishDetailsUserInput(String name, String quanity, String quanityType, String cost) {
		ddp.setUserInputValues(name, quanity, quanityType, cost);
	}

	/**
	 * gets the size of the list view in the dish details page.
	 * 
	 * @return Int = size of the list in the dish details page.
	 */
	public int getDishDetailsListSize() {
		return ddp.getIngredientListSize();
	}

	/**
	 * loads the dish filter page it removes any children from the root view VBox,
	 * and add self in place so is visible
	 */
	public void dishFilterLoad() {
		fd.resetPage();
		this.getChildren().remove(0);
		this.getChildren().add(fd);
		VBox.setVgrow(fd, Priority.ALWAYS);
	}

	/**
	 * sets the filter dishes apply button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setDishFilterBtnApplyEventHandler(EventHandler<ActionEvent> event) {
		fd.setBtnApply(event);
	}

	/**
	 * sets the filter dishes cancel button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setDishFilterBtnCancelEventHandler(EventHandler<ActionEvent> event) {
		fd.setBtnCancelEventHandler(event);
	}

	/**
	 * sets the filter dishes about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setDishFilterBtnAboutEventHandler(EventHandler<ActionEvent> event) {
		fd.setAboutEventHandler(event);
	}

	/**
	 * get the user input for cost more than. the info is from the dish filter page.
	 * 
	 * @return String which represents the cost more than user input.
	 */
	public String getDishFilterCostMoreThan() {
		return fd.getCostMoreThan();
	}

	/**
	 * get the user input for cost less than. the info is from the dish filter page.
	 * 
	 * @return String which represents the cost less than user input.
	 */
	public String getDishFilterCostLessThan() {
		return fd.getCostLessThan();
	}

	/**
	 * get the user input for number of ingredients less than. the info is from the
	 * dish filter page.
	 * 
	 * @return String which represents the number of ingredients less than user
	 *         input.
	 */
	public String getDishFilterNumberOfIngredeintsLessThan() {
		return fd.getNumberOfIngredientsLessThan();
	}

	/**
	 * get the user input for number of ingredients more than. the info is from the
	 * dish filter page.
	 * 
	 * @return String which represents the number of ingredients more than user
	 *         input.
	 */
	public String getDishFilterNumberOfIngredeintsMoreThan() {
		return fd.getNumberOfIngredientsMoreThan();
	}
}
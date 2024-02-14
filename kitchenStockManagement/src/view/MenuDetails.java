package view;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/**
 * the class represent a page of the application.
 * this page is meant to allow the navigation to other pages, 
 * and to show the menu details, to allow the creation of new one and edit old ones.
 * @author Student
 *
 */
public class MenuDetails extends PaneMenu {
	//feilds 
	private Button btnAdd = new Button("add");
	private Button btnEdit = new Button("edit");
	private Button btnRemoveFromList = new Button("remove from list");
	private Button btnLoadFromFileChooser = new Button("load from file chooser");
	private Button btnNewDish = new Button("new dish");
	private Button btnSettings = new Button("settings");
	private Button btnDeleteDishPeremently = new Button("delete dish peremently");
	private Button btnFind = new Button("find");
	private Button btnFilter = new Button("filter");
	private Button btnOutput = new Button("output list");
	private Label txtBudget = new Label("Budget = not selected");
	//private Label txtErrorMessage = new Label("Error");
	private TextField tfUserInput = new TextField();
	private ListView<String> lvDishes = new ListView<>();
	private ListView<String> lvMenu = new ListView<>();
	private ListView<String> lvShopping = new ListView<>();
	private VBox mainLayout = new VBox(20);
	
	
	private HBox initialSplit = new HBox(20);
	private VBox budgetAndFind = new VBox(20);
	private HBox buttons = new HBox(20);
	private HBox find = new HBox(20);
	
	
	
	private HBox lists = new HBox(20);
private VBox sAndN = new VBox(20);
private VBox aAndE = new VBox(20);
private VBox rAndD = new VBox(20);
private VBox LAndFAndO = new VBox(20);
private HBox fAndO = new HBox(20);
	
	/**
	 * default constructor
	 */
	public MenuDetails() {
		super.setCenter(mainLayout);
		mainLayout.getChildren().addAll(lists,initialSplit);
		initialSplit.getChildren().addAll(budgetAndFind,buttons);
		buttons.getChildren().addAll(sAndN,aAndE,rAndD,LAndFAndO);
		budgetAndFind.getChildren().addAll(txtBudget, find);
		find.getChildren().addAll(btnFind,tfUserInput);
		lists.getChildren().addAll(lvDishes,lvMenu,lvShopping);
		sAndN.getChildren().addAll(btnSettings,btnNewDish);
		aAndE.getChildren().addAll(btnAdd,btnEdit);
		rAndD.getChildren().addAll(btnRemoveFromList,btnDeleteDishPeremently);
		LAndFAndO.getChildren().addAll(btnLoadFromFileChooser,fAndO);
		fAndO.getChildren().addAll(btnFilter,btnOutput);
	//mainLayout.setAlignment(Pos.CENTER);
	//lists.setAlignment(Pos.CENTER);
		
	txtBudget.setAlignment(Pos.CENTER);
	//txtErrorMessage.setAlignment(Pos.CENTER);
	
	
	VBox.setVgrow(lists, Priority.ALWAYS);
	VBox.setVgrow(initialSplit, Priority.ALWAYS);
	HBox.setHgrow(budgetAndFind, Priority.ALWAYS);
	HBox.setHgrow(buttons, Priority.ALWAYS);
	
	HBox.setHgrow(lvDishes, Priority.ALWAYS);
	HBox.setHgrow(lvMenu, Priority.ALWAYS);
	HBox.setHgrow(lvShopping, Priority.ALWAYS);
	HBox.setHgrow(txtBudget, Priority.ALWAYS);
	HBox.setHgrow(find, Priority.ALWAYS);
	//controlsTop.setHgrow(txtErrorMessage, Priority.ALWAYS);
	HBox.setHgrow(btnAdd, Priority.ALWAYS);
	HBox.setHgrow(btnEdit, Priority.ALWAYS);
	HBox.setHgrow(btnRemoveFromList, Priority.ALWAYS);
	HBox.setHgrow(btnLoadFromFileChooser, Priority.ALWAYS);
	HBox.setHgrow(btnFind, Priority.ALWAYS);
	HBox.setHgrow(tfUserInput, Priority.ALWAYS);
	HBox.setHgrow(btnNewDish, Priority.ALWAYS);
	HBox.setHgrow(btnSettings, Priority.ALWAYS);
	HBox.setHgrow(btnDeleteDishPeremently, Priority.ALWAYS);
	HBox.setHgrow(btnFilter, Priority.ALWAYS);
	HBox.setHgrow(btnOutput, Priority.ALWAYS);
	
	
	VBox.setVgrow(btnAdd, Priority.ALWAYS);
	VBox.setVgrow(btnEdit, Priority.ALWAYS);
	VBox.setVgrow(btnRemoveFromList, Priority.ALWAYS);
	VBox.setVgrow(btnLoadFromFileChooser, Priority.ALWAYS);
	VBox.setVgrow(btnFind, Priority.ALWAYS);
	VBox.setVgrow(tfUserInput, Priority.ALWAYS);
	VBox.setVgrow(btnNewDish, Priority.ALWAYS);
	VBox.setVgrow(btnSettings, Priority.ALWAYS);
	VBox.setVgrow(btnDeleteDishPeremently, Priority.ALWAYS);
	VBox.setVgrow(btnFilter, Priority.ALWAYS);
	VBox.setVgrow(btnOutput, Priority.ALWAYS);
	VBox.setVgrow(fAndO, Priority.ALWAYS);
	
	
	HBox.setHgrow(sAndN, Priority.ALWAYS);
	HBox.setHgrow(aAndE, Priority.ALWAYS);
	HBox.setHgrow(rAndD, Priority.ALWAYS);
	HBox.setHgrow(LAndFAndO, Priority.ALWAYS);
	
	VBox.setVgrow(txtBudget, Priority.ALWAYS);
	VBox.setVgrow(find, Priority.ALWAYS);
	VBox.setVgrow(btnFind, Priority.ALWAYS);
	VBox.setVgrow(tfUserInput, Priority.ALWAYS);
	
	
	
	mainLayout.setPadding(new Insets(20,20,20,20));
	
	btnAdd.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	btnEdit.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	btnRemoveFromList.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	btnLoadFromFileChooser.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	btnNewDish.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	btnSettings.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	btnDeleteDishPeremently.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	btnFind.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	btnFilter.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	btnOutput.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	tfUserInput.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	txtBudget.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	//txtErrorMessage.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	
	btnAdd.setFont(new Font(20));
	btnEdit.setFont(new Font(20));
	btnRemoveFromList.setFont(new Font(20));
	btnLoadFromFileChooser.setFont(new Font(20));
	btnNewDish.setFont(new Font(20));
	btnSettings.setFont(new Font(20));
	btnDeleteDishPeremently.setFont(new Font(20));
	btnFind.setFont(new Font(20));
	btnFilter.setFont(new Font(20));
	btnOutput.setFont(new Font(20));
	
	txtBudget.setFont(new Font(20));
	//txtErrorMessage.setFont(new Font(20));
	
	tfUserInput.setFont(new Font(20));
	
	
	lvDishes.setPlaceholder(new Label("empty dish list"));
	lvMenu.setPlaceholder(new Label("empty menu items list"));
	lvShopping.setPlaceholder(new Label("empty shopping list"));
	
	
	
	}
	/**
	 * sets the add button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnAddEventHandler(EventHandler<ActionEvent> event) {
		btnAdd.setOnAction(event);
	}
	/**
	 * sets the filter button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnFilterEventHandler(EventHandler<ActionEvent> event) {
		btnFilter.setOnAction(event);
	}
	/**
	 * sets the setting button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnSettingEventHandler(EventHandler<ActionEvent> event) {
		btnSettings.setOnAction(event);
	}
	/**
	 * sets the output button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnOutputEventHandler(EventHandler<ActionEvent> event) {
		btnOutput.setOnAction(event);
	}
	/**
	 * sets the find button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnFindEventHandler(EventHandler<ActionEvent> event) {
		btnFind.setOnAction(event);
	}
	/**
	 * sets the new dish button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnNewDishEventHandler(EventHandler<ActionEvent> event) {
		btnNewDish.setOnAction(event);
	}
	/**
	 * sets the remove from list button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnRemoveFromListEventHandler(EventHandler<ActionEvent> event) {
		btnRemoveFromList.setOnAction(event);
	}
	/**
	 * sets the delete dish peremently button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnDeleteDishPermenetlyFromListEventHandler(EventHandler<ActionEvent> event) {
		btnDeleteDishPeremently.setOnAction(event);
	}
	/**
	 * sets the edit button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnEditEventHandler(EventHandler<ActionEvent> event) {
		btnEdit.setOnAction(event);
	}
	/**
	 * sets the load from file chooser button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnLoadFromFileChooserEventHandler(EventHandler<ActionEvent> event) {
		btnLoadFromFileChooser.setOnAction(event);
	}
	/**
	 * gets the user input in the find input area 
	 * @return String
	 */
	public String getFindUserInput() {
		return tfUserInput.getText();
	}
	/**
	 * sets the list that displays the dish to the inputed list.
	 * list on the far left
	 * @param dishes = ObservableList<String>,
	 */
	public void setDishes(ObservableList<String> dishes) {
		lvDishes.getItems().clear();
		lvDishes.getItems().addAll(dishes);
	}
	/**
	 * gets the index of the item selected in the dish (far left) list view
	 * @return int = index of dish selected
	 */
	public int getDishListSelectedIndex() {
		return lvDishes.getSelectionModel().getSelectedIndex();
	}
	/**
	 * gets the item the use selected in the dish (far left) list view
	 * @return String, which the user selected.
	 */
	public String getDishListSelectedValue() {
		return lvDishes.getSelectionModel().getSelectedItem();	
	}
	/**
	 * gets the item the use selected in the menu (middle) list view
	 * @return String, which the user selected.
	 */
	public String getMenuListSelectedValue() {
		return lvMenu.getSelectionModel().getSelectedItem();	
	}
	/**
	 * sets the list that displays the dish in a menu to the inputed list.
	 * list in the middle
	 * @param items = ObservableList<String>,
	 */
	public void setMenuDishList(ObservableList<String> items) {
		lvMenu.getItems().clear();
		lvMenu.getItems().addAll(items);
	}
	/**
	 * sets the list that displays the stock that needs to be brought (shopping list) to the inputed list.
	 * list on the far right.
	 * @param items = ObservableList<String>,
	 */
	public void setShoppingListList(ObservableList<String> items) {
		lvShopping.getItems().clear();
		lvShopping.getItems().addAll(items);
	}
	/**
	 * gets the underling data structure the shopping (far right) list has
	 * @return ObservableList<String>
	 */
	public ObservableList<String> getShoppingListList(){
		return lvShopping.getItems();
	}
	/**
	 * gets the index of the item which was selected in the menu list (middle one)
	 * @return int
	 */
	public int getMenuListSelectedIndex() {
		return lvMenu.getSelectionModel().getSelectedIndex();
	}
	/**
	 * gets the item selected in the menu list(middle one) but only the id of that item.
	 * the id is the id which is shown, eg after the dish name =
	 * @return String, = just the selected item id. 
	 */
	public String getMenuListSelectedValueAsId() {
		return lvMenu.getSelectionModel().getSelectedItem().substring(lvMenu.getSelectionModel().getSelectedItem().indexOf("=")+2);
	}
	//so for output know if anything there to output or not
	/**
	 * get the size of the list that listView in the middle (menu list)
	 * main purpose is to know if have any data to be outputted.
	 * @return int = size of list
	 */
	public int getMenuListSize() {
		return lvMenu.getItems().size();
	}
	//for easy of use just add the semantics around it
	/**
	 * sets the budget label.
	 * sets it to Budget = ${value}
	 * @param value = String which is a double in a string format.
	 */
	public void setBudgetValue(String value) {
		txtBudget.setText("Budget = " + value);
	}
	/**
	 * clears the menu dish and shopping list and also clears the find input area text
	 */
	public void resetMenuAndShoppingListContent() {
		lvMenu.getItems().clear();
		lvShopping.getItems().clear();
		tfUserInput.clear();
		
	}
	/**
	 * clears the find area input
	 */
	public void clearFindUserInput() {
		tfUserInput.clear();
	}
	/**
	 * removes selection from the list view menu and list view dishes
	 */
	public void deSelect() {
		lvMenu.getSelectionModel().clearSelection();
		lvDishes.getSelectionModel().clearSelection();
	}
}

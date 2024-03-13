package view;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.Dish;
import model.StockType;

/**
 * the class represent a page of the application. this page is meant to allow
 * the navigation to other pages, and to show the menu details, to allow the
 * creation of new one and edit old ones.
 * 
 * @author Student
 *
 */
public class MenuDetails extends PaneMenu {
	// feilds
	private Button btnAdd = new Button("Add");
	private Button btnEdit = new Button("Edit");
	private Button btnRemoveFromList = new Button("Remove From List");
	private Button btnLoadFromFileChooser = new Button("Load From File Chooser");
	private Button btnNewDish = new Button("New Dish");
	private Button btnSettings = new Button("Settings");
	private Button btnDeleteDishPeremently = new Button("Delete Dish Peremently");
	private Button btnFind = new Button("Find");
	private Button btnFilter = new Button("Filter");
	private Button btnOutput = new Button("Output List");
	private Label txtBudget = new Label("Budget = Not Selected");
	// private Label txtErrorMessage = new Label("Error");
	private TextField tfUserInput = new TextField();
	private TableView<Dish> tvDishes = new TableView<>();
	private TableView<Dish> tvMenu = new TableView<>();
	private TableView<StockType> tvShopping = new TableView<>();
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

		tvDishes.setPrefWidth(100);
		tvMenu.setPrefWidth(100);
		tvShopping.setPrefWidth(400);

		tvDishes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tvMenu.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tvShopping.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		tvDishes.widthProperty().addListener(new EHDishListSize());
		tvMenu.widthProperty().addListener(new EHMenuListSize());
		tvShopping.widthProperty().addListener(new EHShopingListSize());

		super.setCenter(mainLayout);
		mainLayout.getChildren().addAll(lists, initialSplit);
		initialSplit.getChildren().addAll(budgetAndFind, buttons);
		buttons.getChildren().addAll(sAndN, aAndE, rAndD, LAndFAndO);
		budgetAndFind.getChildren().addAll(txtBudget, find);
		find.getChildren().addAll(btnFind, tfUserInput);
		lists.getChildren().addAll(tvDishes, tvMenu, tvShopping);
		sAndN.getChildren().addAll(btnSettings, btnNewDish);
		aAndE.getChildren().addAll(btnAdd, btnEdit);
		rAndD.getChildren().addAll(btnRemoveFromList, btnDeleteDishPeremently);
		LAndFAndO.getChildren().addAll(btnLoadFromFileChooser, fAndO);
		fAndO.getChildren().addAll(btnFilter, btnOutput);
		// mainLayout.setAlignment(Pos.CENTER);
		// lists.setAlignment(Pos.CENTER);

		txtBudget.setAlignment(Pos.CENTER);
		// txtErrorMessage.setAlignment(Pos.CENTER);

		VBox.setVgrow(lists, Priority.ALWAYS);
		VBox.setVgrow(initialSplit, Priority.ALWAYS);
		HBox.setHgrow(budgetAndFind, Priority.ALWAYS);
		HBox.setHgrow(buttons, Priority.ALWAYS);

		HBox.setHgrow(tvDishes, Priority.ALWAYS);
		HBox.setHgrow(tvMenu, Priority.ALWAYS);
		HBox.setHgrow(tvShopping, Priority.ALWAYS);
		HBox.setHgrow(txtBudget, Priority.ALWAYS);
		HBox.setHgrow(find, Priority.ALWAYS);
		// controlsTop.setHgrow(txtErrorMessage, Priority.ALWAYS);
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

		mainLayout.setPadding(new Insets(20, 20, 20, 20));

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
		// txtErrorMessage.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

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
		// txtErrorMessage.setFont(new Font(20));

		tfUserInput.setFont(new Font(20));

		tvDishes.setPlaceholder(new Label("empty dish list"));
		tvMenu.setPlaceholder(new Label("empty menu items list"));
		tvShopping.setPlaceholder(new Label("empty shopping list"));

	}

	/**
	 * sets the add button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBtnAddEventHandler(EventHandler<ActionEvent> event) {
		btnAdd.setOnAction(event);
	}

	/**
	 * sets the filter button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBtnFilterEventHandler(EventHandler<ActionEvent> event) {
		btnFilter.setOnAction(event);
	}

	/**
	 * sets the setting button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBtnSettingEventHandler(EventHandler<ActionEvent> event) {
		btnSettings.setOnAction(event);
	}

	/**
	 * sets the output button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBtnOutputEventHandler(EventHandler<ActionEvent> event) {
		btnOutput.setOnAction(event);
	}

	/**
	 * sets the find button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBtnFindEventHandler(EventHandler<ActionEvent> event) {
		btnFind.setOnAction(event);
	}

	/**
	 * sets the new dish button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBtnNewDishEventHandler(EventHandler<ActionEvent> event) {
		btnNewDish.setOnAction(event);
	}

	/**
	 * sets the remove from list button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBtnRemoveFromListEventHandler(EventHandler<ActionEvent> event) {
		btnRemoveFromList.setOnAction(event);
	}

	/**
	 * sets the delete dish peremently button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBtnDeleteDishPermenetlyFromListEventHandler(EventHandler<ActionEvent> event) {
		btnDeleteDishPeremently.setOnAction(event);
	}

	/**
	 * sets the edit button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBtnEditEventHandler(EventHandler<ActionEvent> event) {
		btnEdit.setOnAction(event);
	}

	/**
	 * sets the load from file chooser button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setBtnLoadFromFileChooserEventHandler(EventHandler<ActionEvent> event) {
		btnLoadFromFileChooser.setOnAction(event);
	}

	/**
	 * gets the user input in the find input area
	 * 
	 * @return String
	 */
	public String getFindUserInput() {
		return tfUserInput.getText();
	}

	/**
	 * sets the table view underling data structure to the passed in one. the table
	 * view is the dish one.
	 * 
	 * @param dishes = Observable<Dish>
	 */
	public void setDishes(ObservableList<Dish> dishes) {
		tvDishes.getItems().clear();
		tvDishes.getItems().addAll(dishes);
	}

	/**
	 * gets the index of the item selected in the dish (far left) list view
	 * 
	 * @return int = index of dish selected
	 */
	public int getDishListSelectedIndex() {
		return tvDishes.getSelectionModel().getSelectedIndex();
	}

	/**
	 * gets the item the use selected in the dish (far left) table view
	 * 
	 * @return Dish, which the user selected.
	 */
	public Dish getDishListSelectedValue() {
		return tvDishes.getSelectionModel().getSelectedItem();
	}

	/**
	 * gets the item the use selected in the menu (middle) table view
	 * 
	 * @return Dish, which the user selected.
	 */
	public Dish getMenuListSelectedValue() {
		return tvMenu.getSelectionModel().getSelectedItem();
	}

	/**
	 * gets the item the use selected in the left (middle) table view
	 * 
	 * @return StockType, which the user selected.
	 */
	public StockType getShoppingListSelectedValue() {
		return tvShopping.getSelectionModel().getSelectedItem();
	}

	/**
	 * sets the table view underling data structure of menu dish (middle one) to the
	 * passed in the data structure.
	 * 
	 * @param items = ObservableList<Dish>
	 */
	public void setMenuDishList(ObservableList<Dish> items) {
		tvMenu.getItems().clear();
		tvMenu.getItems().addAll(items);
	}

	/**
	 * sets the shopping list table view underling data structure, to be the passed
	 * in one.
	 * 
	 * @param items = ObservableList<StockType>
	 */
	public void setShoppingListList(ObservableList<StockType> items) {
		tvShopping.getItems().clear();
		tvShopping.getItems().addAll(items);
	}

	/**
	 * gets the underling data structure the shopping (far right) table view
	 * 
	 * @return ObservableList<StockType>
	 */
	public ObservableList<StockType> getShoppingListList() {
		return tvShopping.getItems();
	}

	/**
	 * gets the index of the item which was selected in the menu list (middle one)
	 * 
	 * @return int
	 */
	public int getMenuListSelectedIndex() {
		return tvMenu.getSelectionModel().getSelectedIndex();
	}

	/**
	 * gets the shopping list table view, selected item index
	 * 
	 * @return int
	 */
	public int getShoppingListSelectedIndex() {
		return tvShopping.getSelectionModel().getSelectedIndex();
	}

	/**
	 * gets the menu table view, selected item name
	 * 
	 * @return String which is the Dish name that the user selected in the menu
	 *         table
	 */
	public String getMenuListSelectedValueAsId() {
		return tvMenu.getSelectionModel().getSelectedItem().getDishName();
	}

	// so for output know if anything there to output or not
	/**
	 * get the size of the list that listView in the middle (menu list) main purpose
	 * is to know if have any data to be outputted.
	 * 
	 * @return int = size of list
	 */
	public int getMenuListSize() {
		return tvMenu.getItems().size();
	}

	// for easy of use just add the semantics around it
	/**
	 * sets the budget label. sets it to Budget = ${value}
	 * 
	 * @param value = String which is a double in a string format.
	 */
	public void setBudgetValue(String value) {
		txtBudget.setText("Budget = " + value);
	}

	/**
	 * clears the menu dish and shopping list and also clears the find input area
	 * text
	 */
	public void resetMenuAndShoppingListContent() {
		tvMenu.getItems().clear();
		tvShopping.getItems().clear();
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
		tvMenu.getSelectionModel().clearSelection();
		tvDishes.getSelectionModel().clearSelection();
	}

	/**
	 * clears all the table columns from all the table views.
	 */
	public void clearTablesColumns() {
		tvMenu.getColumns().clear();
		tvDishes.getColumns().clear();
		tvShopping.getColumns().clear();
	}

	/**
	 * sets the Table columns for the the dish list table view sets them to the
	 * passed in ones.
	 * 
	 * @param column = TableColumn<Dish, String>
	 */
	public void setDishColumn(TableColumn<Dish, String> column) {
		tvDishes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tvDishes.getColumns().add(column);
		// ec = existing column
		tvDishes.getColumns().forEach(ec -> {
			ec.setSortable(false);
		});
		tvDishes.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
	}

	/**
	 * sets the Table columns for the the menu list table view sets them to the
	 * passed in ones.
	 * 
	 * @param column = TableColumn<Dish, String>
	 */
	public void setMenuColumn(TableColumn<Dish, String> column) {
		tvMenu.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tvMenu.getColumns().add(column);
		tvMenu.getColumns().forEach(ec -> {
			ec.setSortable(false);
		});
		tvMenu.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
	}

	/**
	 * sets the Table columns for the the shopping list table view. sets them to the
	 * passed in ones.
	 * 
	 * @param column = ArrayList<TableColumn<StockType, String>>
	 */
	public void setShoppingColumns(ArrayList<TableColumn<StockType, String>> columns) {
		tvShopping.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tvShopping.getColumns().addAll(columns);
		tvShopping.getColumns().forEach(column -> {
			column.setSortable(false);
		});
		tvShopping.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
	}

	/**
	 * removes user selection from the tvShopping and tvMenu
	 */
	public void unselectMenuAndshoppingList() {
		tvShopping.getSelectionModel().clearSelection();
		tvMenu.getSelectionModel().clearSelection();
	}

	/**
	 * simply resize the shopping list column when every the shopping list table
	 * view changes
	 * 
	 * @author Student
	 *
	 */
	private class EHShopingListSize implements ChangeListener<Number> {

		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			tvShopping.getColumns()
					.forEach(x -> x.setPrefWidth(tvShopping.getWidth() / tvShopping.getColumns().size()));

		}

	}

	/**
	 * simply resize the dish list column when every the shopping list table view
	 * changes
	 * 
	 * @author Student
	 *
	 */
	private class EHDishListSize implements ChangeListener<Number> {

		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			tvDishes.getColumns().forEach(x -> x.setPrefWidth(tvDishes.getWidth()));

		}

	}

	/**
	 * simply resize the menu list column when every the shopping list table view
	 * changes
	 * 
	 * @author Student
	 *
	 */
	private class EHMenuListSize implements ChangeListener<Number> {

		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			tvMenu.getColumns().forEach(x -> {
				x.setPrefWidth(tvMenu.getWidth());

			});

		}
	}
}

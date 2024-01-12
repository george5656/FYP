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
	private Label txtBudget = new Label("Budget =");
	private Label txtErrorMessage = new Label("Error");
	private TextField tfUserInput = new TextField();
	private ListView<String> lvDishes = new ListView<>();
	private ListView<String> lvMenu = new ListView<>();
	private ListView<String> lvShopping = new ListView<>();
	private VBox mainLayout = new VBox(20);
	private HBox lists = new HBox(20);
	private HBox controlsTop = new HBox(20);
	private HBox controlsBottom = new HBox(20);
	
	public MenuDetails() {
		super.setCenter(mainLayout);
		mainLayout.getChildren().addAll(lists,controlsTop,controlsBottom);
		lists.getChildren().addAll(lvDishes,lvMenu,lvShopping);
		controlsTop.getChildren().addAll(txtBudget, txtErrorMessage,btnAdd,btnEdit,btnRemoveFromList,btnLoadFromFileChooser);
		controlsBottom.getChildren().addAll(btnFind,tfUserInput,btnNewDish,btnSettings,btnDeleteDishPeremently,btnFilter,btnOutput);
	 
	//mainLayout.setAlignment(Pos.CENTER);
	//lists.setAlignment(Pos.CENTER);
	controlsTop.setAlignment(Pos.CENTER);
	controlsBottom.setAlignment(Pos.CENTER);
	txtBudget.setAlignment(Pos.CENTER);
	txtErrorMessage.setAlignment(Pos.CENTER);
	
	
	mainLayout.setVgrow(lists, Priority.ALWAYS);
	mainLayout.setVgrow(controlsTop, Priority.ALWAYS);
	mainLayout.setVgrow(controlsBottom, Priority.ALWAYS);
	lists.setHgrow(lvDishes, Priority.ALWAYS);
	lists.setHgrow(lvMenu, Priority.ALWAYS);
	lists.setHgrow(lvShopping, Priority.ALWAYS);
	controlsTop.setHgrow(txtBudget, Priority.ALWAYS);
	controlsTop.setHgrow(txtErrorMessage, Priority.ALWAYS);
	controlsTop.setHgrow(btnAdd, Priority.ALWAYS);
	controlsTop.setHgrow(btnEdit, Priority.ALWAYS);
	controlsTop.setHgrow(btnRemoveFromList, Priority.ALWAYS);
	controlsTop.setHgrow(btnLoadFromFileChooser, Priority.ALWAYS);
	controlsBottom.setHgrow(btnFind, Priority.ALWAYS);
	controlsBottom.setHgrow(tfUserInput, Priority.ALWAYS);
	controlsBottom.setHgrow(btnNewDish, Priority.ALWAYS);
	controlsBottom.setHgrow(btnSettings, Priority.ALWAYS);
	controlsBottom.setHgrow(btnDeleteDishPeremently, Priority.ALWAYS);
	controlsBottom.setHgrow(btnFilter, Priority.ALWAYS);
	controlsBottom.setHgrow(btnOutput, Priority.ALWAYS);
	
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
	txtErrorMessage.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	
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
	txtErrorMessage.setFont(new Font(20));
	
	tfUserInput.setFont(new Font(20));
	}
	public void setBtnAddEventHandler(EventHandler<ActionEvent> event) {
		btnAdd.setOnAction(event);
	}
	public void setBtnFilterEventHandler(EventHandler<ActionEvent> event) {
		btnFilter.setOnAction(event);
	}
	public void setBtnSettingEventHandler(EventHandler<ActionEvent> event) {
		btnSettings.setOnAction(event);
	}
	public void setBtnOutputEventHandler(EventHandler<ActionEvent> event) {
		btnOutput.setOnAction(event);
	}
	public void setBtnFindEventHandler(EventHandler<ActionEvent> event) {
		btnFind.setOnAction(event);
	}
	public String getFindUserInput() {
		return tfUserInput.getText();
	}
	public void setDishes(ObservableList<String> dishes) {
		lvDishes.getItems().clear();
		lvDishes.getItems().addAll(dishes);
	}
}

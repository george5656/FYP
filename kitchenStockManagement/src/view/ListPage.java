package view;



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

/**
 * class meant to be extened to give the default info about the other UI pages
 * @author Student
 * @param <E>
 *
 */
public class ListPage<E> extends PaneMenu {
	//fields 
	private Button btnAdd = new Button("Add");
	private Button btnEdit = new Button("Edit");
	private Button btnDelete = new Button("Delete");
	private Button btnFilter = new Button("Filter");
	private Button btnFind = new Button("Find");
	private TextField tfFind = new TextField();
	private Label txtErrorMessage = new Label("Error");
	private TableView<E> tv = new TableView<>();
	private HBox mainLayout = new HBox(20);
	private VBox list = new VBox(20);
	private VBox buttons = new VBox(20);
	private HBox find = new HBox(20);
	/**
	 * default constructor
	 */
	public ListPage() {
	tv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		super.setCenter(mainLayout);
		txtErrorMessage.setVisible(false);
		mainLayout.getChildren().addAll(list,buttons);
		list.getChildren().addAll(tv,txtErrorMessage);
		buttons.getChildren().addAll(btnAdd,btnEdit,btnDelete,btnFilter,find);
		find.getChildren().addAll(btnFind,tfFind);
		
		tv.setPlaceholder(new Label("No data"));
		
		mainLayout.setAlignment(Pos.CENTER);
		list.setAlignment(Pos.CENTER);
		buttons.setAlignment(Pos.CENTER);
		find.setAlignment(Pos.CENTER);
		txtErrorMessage.setAlignment(Pos.CENTER);
		
		
		
		btnAdd.setPrefSize(200,200);
		btnEdit.setPrefSize(200,200);
		btnFilter.setPrefSize(200,200);
		btnFind.setPrefSize(200,200);
		btnDelete.setPrefSize(200,200);
		tfFind.setPrefSize(200,200);
		
		
		btnAdd.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnEdit.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnFilter.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnFind.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnDelete.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		tfFind.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );
		txtErrorMessage.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		HBox.setHgrow(list, Priority.ALWAYS);
		
		VBox.setVgrow(tv, Priority.ALWAYS);
		
		
		mainLayout.setPadding(new Insets(20,20,20,20));
		
		btnAdd.setFont(new Font(20));
		btnEdit.setFont(new Font(20));
		btnFilter.setFont(new Font(20));
		btnFind.setFont(new Font(20));
		btnDelete.setFont(new Font(20));
		txtErrorMessage.setFont(new Font(20));
		
		tfFind.setFont(new Font(20)); 

		
		
		
	}
	/**
	 * sets the add button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
public void setBtnAddEventHandler(EventHandler<ActionEvent> event) {
	btnAdd.setOnAction(event);
}
/**
 * sets the delete button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
	btnDelete.setOnAction(event);
}
/**
 * sets the filter button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBtnFilterEventHandler(EventHandler<ActionEvent> event) {
	btnFilter.setOnAction(event);
}
/**
 * sets the find button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBtnFindEventHandler(EventHandler<ActionEvent> event) {
	btnFind.setOnAction(event);
}
/**
 * sets the edit button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBtnEditEventHandler(EventHandler<ActionEvent> event) {
	btnEdit.setOnAction(event);
}
/**
 * adds the passed in data structure to the table view
 * @param data = ObservableList<E> 
 */
public void setObservableList(ObservableList<E> data) {
	tv.setItems(data);
}
/**
 * gets the item that the user selected in the listView
 * @return String = the String which the user selected.  
 */
public E getSelection() {
	return tv.getSelectionModel().getSelectedItem();
}

/**
 * get the tableView that is displayed
 * @return TableView<E>
 */
public TableView<E> getSelectionNode(){
	return tv;
}
/**
 * gets the user input for the find section.
 * @return String
 */
public String getTfFindValue() {
	return tfFind.getText();
}
/**
 * get the label node.
 * the label is hidden by default and meant to be used to show errors
 * @return Label
 */
public Label getErrorLabel() {
	return txtErrorMessage;
}
/**
 * hides the Label.
 */
public void hideErrorMessage() {
	txtErrorMessage.setVisible(false);
}
/**
 * sets the error message text and makes it visible.
 * @param error = String you want to show the user.
 */
public void setErrorMessage(String error) {
	txtErrorMessage.setText(error);
	txtErrorMessage.setVisible(true);
}
/**
 * clears the value in the find user input area
 */
public void resetFindInput() {
	tfFind.clear();
}

/**
 * adds the passed in table column to the table view
 * @param column TableColumn<E,String>
 */
public void setTableColumn(TableColumn<E,String> column) {
	tv.getColumns().add(column);
}

/**
 * removed all table columns from the table view.
 */
public void clearTableColumn() {
	tv.getColumns().clear();
}
}

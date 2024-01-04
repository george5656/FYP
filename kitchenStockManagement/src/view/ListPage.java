package view;



import java.util.ArrayList;

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
 * class meant to be extened to give the default info about the other UI pages
 * @author Student
 *
 */
public class ListPage extends PaneMenu {
	//fields 
	private Button btnAdd = new Button("add");
	private Button btnEdit = new Button("edit");
	private Button btnDelete = new Button("delete");
	private Button btnFilter = new Button("filter");
	private Button btnFind = new Button("find");
	private TextField tfFind = new TextField();
	private Label txtErrorMessage = new Label("Error");
	private ListView<String> lv = new ListView<>();
	private HBox mainLayout = new HBox(20);
	private VBox list = new VBox(20);
	private VBox buttons = new VBox(20);
	private HBox find = new HBox(20);
	
	public ListPage() {
	
		super.setCenter(mainLayout);
		mainLayout.getChildren().addAll(list,buttons);
		list.getChildren().addAll(lv,txtErrorMessage);
		buttons.getChildren().addAll(btnAdd,btnEdit,btnDelete,btnFilter,find);
		find.getChildren().addAll(btnFind,tfFind);
		
		
		mainLayout.setAlignment(Pos.CENTER);
		list.setAlignment(Pos.CENTER);
		buttons.setAlignment(Pos.CENTER);
		find.setAlignment(Pos.CENTER);
		txtErrorMessage.setAlignment(Pos.CENTER);
		
		
		btnAdd.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnEdit.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnFilter.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnFind.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnDelete.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		tfFind.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );
		txtErrorMessage.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		mainLayout.setHgrow(list, Priority.ALWAYS);
		mainLayout.setHgrow(buttons, Priority.ALWAYS);
		list.setVgrow(lv, Priority.ALWAYS);
		list.setVgrow(txtErrorMessage,Priority.ALWAYS);
		buttons.setVgrow(btnAdd, Priority.ALWAYS);
		buttons.setVgrow(btnAdd, Priority.ALWAYS);
		buttons.setVgrow(btnEdit, Priority.ALWAYS);
		buttons.setVgrow(btnDelete, Priority.ALWAYS);
		buttons.setVgrow(btnFilter, Priority.ALWAYS);
		buttons.setVgrow(find, Priority.ALWAYS);
		find.setHgrow(btnFind, Priority.ALWAYS);
		find.setHgrow(tfFind, Priority.ALWAYS);
		
		mainLayout.setPadding(new Insets(20,20,20,20));
		
		btnAdd.setFont(new Font(30));
		btnEdit.setFont(new Font(30));
		btnFilter.setFont(new Font(30));
		btnFind.setFont(new Font(30));
		btnDelete.setFont(new Font(30));
		txtErrorMessage.setFont(new Font(30));
		
		tfFind.setFont(new Font(30)); 
	}
public void setBtnAddEventHandler(EventHandler<ActionEvent> event) {
	btnAdd.setOnAction(event);
}
public void setBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
	btnDelete.setOnAction(event);
}
public void setBtnFilterEventHandler(EventHandler<ActionEvent> event) {
	btnFilter.setOnAction(event);
}
public void setObservableList(ObservableList<String> test) {
	lv.setItems(test);
}
}

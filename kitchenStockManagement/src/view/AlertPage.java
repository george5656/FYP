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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.CurrentStock;
import model.Recommedation;
import model.StockType;

public class AlertPage extends PaneMenu {
private VBox pageStructure = new VBox(20);
private Button back = new Button("Back");
private TableView<StockType> lowStock = new TableView<>();
private TableColumn<StockType, String> name = new TableColumn<>("Name");
private TableColumn<StockType, String> quanityType = new TableColumn<>("QuanityType");
private TableColumn<StockType, String> quantity = new TableColumn<>("Quanity");
	
	
public AlertPage() {
	
	super.setCenter(pageStructure);
	pageStructure.getChildren().add(lowStock);
	pageStructure.getChildren().add(back);
	lowStock.getColumns().add(name);
	lowStock.getColumns().add(quanityType);
	lowStock.getColumns().add(quantity);
	
	
	lowStock.setPlaceholder(new Label("No Low Stock"));
	
	
	pageStructure.setPadding(new Insets(20,20,20,20));
	
	back.setFont(new Font(20));
	back.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	lowStock.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	
	VBox.setVgrow(lowStock, Priority.ALWAYS);
	VBox.setVgrow(back, Priority.ALWAYS);
	
	name.setCellValueFactory(new PropertyValueFactory<StockType, String>("name"));
	quanityType.setCellValueFactory(new PropertyValueFactory<StockType, String>("quanityType"));
	quantity.setCellValueFactory(new PropertyValueFactory<StockType, String>("quanity"));
	
	
	
	
	
	
	
}
	


public void setTableDataInfo(ObservableList<StockType> data) {
	lowStock.getItems().clear();
	lowStock.setItems(data);
}
public void setBtnBack(EventHandler<ActionEvent> event) {
	back.setOnAction(event);
}




}

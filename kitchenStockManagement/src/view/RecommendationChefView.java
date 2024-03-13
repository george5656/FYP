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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.CurrentStock;
import model.Recommedation;

public class RecommendationChefView extends PaneMenu {
private VBox layout = new VBox(20);
private HBox buttons = new HBox(20);

private TableView<Recommedation> tvRecommendation = new TableView<>();
private TableColumn<Recommedation,String> tcRecommendation = new TableColumn<>("recommendation");
private Button delete = new Button("delete");
private Button back = new Button("back");



public RecommendationChefView() {
	tvRecommendation.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	super.setCenter(layout);
	buttons.getChildren().add(back);
	buttons.getChildren().add(delete);
	layout.getChildren().add(tvRecommendation);
	layout.getChildren().add(buttons);
	
	VBox.setVgrow(buttons, Priority.ALWAYS);
	VBox.setVgrow(tvRecommendation, Priority.ALWAYS);
	HBox.setHgrow(delete, Priority.SOMETIMES);
	HBox.setHgrow(back, Priority.SOMETIMES);
	
	tvRecommendation.setPlaceholder(new Label("no recommedation"));
	tvRecommendation.getColumns().add(tcRecommendation);
	
	
	back.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	delete.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	layout.setPadding(new Insets(20, 20, 20, 20));
	
	delete.setFont(new Font(20));
	back.setFont(new Font(20));
	
	
	
	tcRecommendation.setCellValueFactory(new PropertyValueFactory<Recommedation, String>("Recommedation"));
	
	
	
	
}


public void setData(ObservableList<Recommedation> data) {
	tvRecommendation.getItems().clear();
	tvRecommendation.getItems().addAll(data);

}


public void clearUserSelection() {
	tvRecommendation.getSelectionModel().clearSelection();
}
public String getSelectedItemId() {
	if(tvRecommendation.getSelectionModel().isEmpty()) {
		return "null";
	}else {
	return tvRecommendation.getSelectionModel().getSelectedItem().getId()+"";
}
}


public void setBtnBack(EventHandler<ActionEvent> event) {
	back.setOnAction(event);
}
public void setBtnDelete(EventHandler<ActionEvent> event) {
	delete.setOnAction(event);
}

}

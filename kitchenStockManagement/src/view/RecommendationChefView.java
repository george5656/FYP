package view;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.Recommedation;

public class RecommendationChefView extends PaneMenu {
	private VBox layout = new VBox(20);
	private HBox buttons = new HBox(20);

	private TableView<Recommedation> tvRecommendation = new TableView<>();
	private TableColumn<Recommedation, String> tcRecommendation = new TableColumn<>("recommendation");
	private Button delete = new Button("delete");
	private Button back = new Button("back");

	/**
	 * default constructor
	 */
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

	/**
	 * clears the table view data and then set it underlining data structure to the
	 * passed in one
	 * 
	 * @param data = ObservableList<Recommedation>
	 */
	public void setData(ObservableList<Recommedation> data) {
		tvRecommendation.getItems().clear();
		tvRecommendation.getItems().addAll(data);

	}

	/**
	 * clears the selctedmodel in tableview
	 */
	public void clearUserSelection() {
		tvRecommendation.getSelectionModel().clearSelection();
	}

	/**
	 * get the selected item Id
	 * 
	 * @return String, which is "null"(as a string) if no item has been selected.
	 */
	public String getSelectedItemId() {
		if (tvRecommendation.getSelectionModel().isEmpty()) {
			return "null";
		} else {
			return tvRecommendation.getSelectionModel().getSelectedItem().getId() + "";
		}
	}

	/**
	 * sets the event handler for btnBack
	 * 
	 * @param event = EventHandler<ActionEvent>
	 */
	public void setBtnBack(EventHandler<ActionEvent> event) {
		back.setOnAction(event);
	}

	/**
	 * sets the event handler for btnDelete
	 * 
	 * @param event = EventHandler<ActionEvent> event
	 */
	public void setBtnDelete(EventHandler<ActionEvent> event) {
		delete.setOnAction(event);
	}

}

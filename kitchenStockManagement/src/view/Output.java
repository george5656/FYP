package view;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Output extends PaneMenu {
	private Label txtTitle = new Label("Which menu to save");
	private Button btnMenu = new Button("menu");
	private Button btnShoppingList = new Button("shoing List");
	private Button btnCancel = new Button("cancel");
	private ArrayList<Labeled> controls = new ArrayList<>();
	private VBox layout =  new VBox(20);
	
	public Output() {
		
		this.setCenter(layout);
	
		layout.setPadding(new Insets(20,20,20,20));
		
		txtTitle.setUnderline(true);
		
		controls.add(txtTitle);
		controls.add(btnMenu);
		controls.add(btnShoppingList);
		controls.add(btnCancel);
		
		layout.getChildren().addAll(txtTitle,btnMenu,btnShoppingList,btnCancel);
		
		for(Labeled i : controls) {
			i.setFont(new Font(20));
			i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			i.setAlignment(Pos.CENTER);
			layout.setVgrow(i, Priority.ALWAYS);
		}
	}
	
}

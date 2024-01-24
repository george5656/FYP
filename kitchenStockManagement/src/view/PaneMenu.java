package view;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 * this class just make a menu bar the rest of the classes can extend.
 * 
 * @author George
 *
 */
public class PaneMenu extends BorderPane {
	/*
	 * private MenuBar mb = new MenuBar(); private Menu home= new Menu("home");
	 * private Menu about = new Menu("about"); private Menu logout = new
	 * Menu("logout"); private MenuItem test = new MenuItem("test");
	 */
	// private ButtonBar mb = new ButtonBar();
	private HBox mb = new HBox(0);
	private Button btnHome = new Button("home");
	private Button btnAbout = new Button("about");
	private Button btnLogout = new Button("logout");
	private ArrayList<Button> controls = new ArrayList<>();

	/**
	 * default constructor, assigning the menu items and adding the elements to the
	 * scene graph, with basic ui set up
	 */
	public PaneMenu() {
		mb.setStyle("-fx-background-color : #d4d4d4");
		this.setTop(mb);
		// mb.getChildren().addAll(home,about,logout);
		mb.setPadding(new Insets(0, 0, 0, 0));
		controls.add(btnHome);
		controls.add(btnAbout);
		controls.add(btnLogout);
		// mb.getButtons().addAll(controls);
		mb.getChildren().addAll(controls);
		for (Button i : controls) {
			i.setFont(new Font(20));

		}

		/*
		 * mb.getMenus().addAll(home,about,logout); this.setTop(mb);
		 * home.setStyle("-fx-Font-size:20"); about.setStyle("-fx-Font-size:20");
		 * logout.setStyle("-fx-Font-size:20");
		 * 
		 */

	}

	/**
	 * sets the home button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setHomeEventHandler(EventHandler<ActionEvent> event) {
		btnHome.setOnAction(event);
	}

	/**
	 * sets the logout button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setLogoutEventHandler(EventHandler<ActionEvent> event) {
		btnLogout.setOnAction(event);
	}

	/**
	 * sets the about button event handler
	 * 
	 * @param event = Event handler<ActionEvent>
	 */
	public void setAboutEventHandler(EventHandler<ActionEvent> event) {
		btnAbout.setOnAction(event);
	}
}

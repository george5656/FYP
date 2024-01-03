package view;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;

/**
 * this class just make a menu bar the rest of the classes can extend. 
 * @author George
 *
 */
public class SceneMenu extends BorderPane {
private MenuBar mb = new MenuBar();
private static Menu home= new Menu("home");
private Menu about = new Menu("about");
private Menu logout = new Menu("logout");
/**
 * default constructor, assigning the menu items and adding the
 * elements to the scene graph, with basic ui set up
 */
public SceneMenu() {
	mb.getMenus().addAll(home,about,logout);
	this.setTop(mb);
	home.setStyle("-fx-Font-size:20");
	about.setStyle("-fx-Font-size:20");
	logout.setStyle("-fx-Font-size:20");
 
}
public static void setHomeEventHandler(EventHandler<ActionEvent> event) {
	home.setOnAction(event);
}
}

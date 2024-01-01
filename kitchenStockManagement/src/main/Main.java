package main;
import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ModelRoot;
import view.RootView;
/**
 * is the main method for the kitchen stock management system.
 * @author George
 *
 */
public class Main extends Application {
// fields
	private RootView view;
	/**
	 * where the root V,M and C are made
	 */
	@Override
	public void init() {
		view = new RootView();
		new Controller(new ModelRoot(), view);
	}
	/**
	 * where the scene is made and the stage is shown
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("kitchen stock management");
		primaryStage.setScene(new Scene(view));
		primaryStage.show();
	}


	/**
	 * starts the application
	 * @param args
	 */
	public static void main(String[] args) {

			launch("kitchen stock management");
	}

	
}

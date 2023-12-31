package main;
import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ModelRoot;
import view.RootView;
public class Main extends Application {
// fields
	private RootView view;
	@Override
	public void init() {
		view = new RootView();
		ModelRoot model = new ModelRoot();
		new Controller();
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		 primaryStage.setScene(new Scene(view));
		primaryStage.show();
	}


	
	public static void main(String[] args) {

			launch("kitchen stock management");
	}

	
}

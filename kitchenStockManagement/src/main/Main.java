package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
		
		new Controller(new ModelRoot(), view);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("kitchen stock management");
		primaryStage.setScene(new Scene(view));
		primaryStage.show();
	}


	
	public static void main(String[] args) {

		
		
			launch("kitchen stock management");
	}

	
}

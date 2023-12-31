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
		ModelRoot model = new ModelRoot();
		new Controller();
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		 primaryStage.setScene(new Scene(view));
		primaryStage.show();
	}


	
	public static void main(String[] args) {

		try {
		System.out.println("connecting...");
		Connection connetion = DriverManager.getConnection("jdbc:mysql://localhost:3306/MySQL","root","Root123@");
		System.out.println("connected");	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
			//launch("kitchen stock management");
	}

	
}

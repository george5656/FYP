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
	private Scene scene ;
	/**
	 * where the root V,M,c and scene are made
	 * and the css file is connected to the scene.
	 */
	@Override
	public void init() {
		view = new RootView();
		new Controller(new ModelRoot(), view);
	 scene = new Scene(view,1200,600);
		
			scene.getStylesheets().add( getClass().getResource("StockManegment.css").toString());
		
	}
	/*
	 * *tes
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setMinHeight(700);
		primaryStage.setMinWidth(1200);
		primaryStage.setTitle("kitchen stock management");
		
		primaryStage.setScene(scene);
		
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

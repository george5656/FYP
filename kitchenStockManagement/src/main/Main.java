package main;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

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
	 * and the css file is connected to teh scene.
	 */
	@Override
	public void init() {
		view = new RootView();
		new Controller(new ModelRoot(), view);
	 scene = new Scene(view,1200,600);
		
			//scene.getStylesheets().add("file:/C:/Users/Student/Documents/DMU%202023%202024/modules/development%20project/Code/version14/FYP/kitchenStockManagement/bin/main/StockManegment.css");
		//scene.getStylesheets().add("/../../bin/main/StockManegment.css");
			//scene.getStylesheets().add("/./StockManegment");
	//scene.getStylesheets().add("FYP/kitchenStockManagement/bin/main/StockManegment.css");		
	// System.out.println(getClass().getResource("StockManegment.css").toExternalForm());
	 try {
		 URL pathToCurrentPlace = new File("StockManegment.css").toURL();
		 
		 
		 scene.getStylesheets().add(pathToCurrentPlace.toExternalForm().replace(" ", "%20").replace("StockManegment.css", "bin/main/StockManegment.css"));
		 
		// System.out.println(new File(getParent() + "/./bin/main/stockManegment.css").toURL().toExternalForm().replace(" ", "%20"));
	
	 } catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	/**
	 * setting the stage up.
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

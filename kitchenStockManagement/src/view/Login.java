package view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/**
 * first page loaded, login page for the application.
 * @author George
 *
 */
public class Login extends VBox {
//fields 
	private HBox labelAndTextInputLayout = new HBox(20);
	private VBox label = new VBox(20);
	private VBox textInput = new VBox(20);
	private HBox controls = new HBox(20);
	private Label txtTitle = new Label("Login");
	private Label txtUsername = new Label("username");
	private Label txtPassword = new Label("password");
	private Button btnExit = new Button("Exit");
	private Button btnLogin = new Button("Login");
	private TextField tfUsername = new TextField();
	private PasswordField pfPassword = new PasswordField();
	
	
	/**
	 * default constructor
	 * initialling the layout and set the properties.
	 */
	public Login() {
		
		super(20);
		
		//Creating HBox, adding the children.
	labelAndTextInputLayout.getChildren().addAll(label,textInput);
	label.getChildren().addAll(txtUsername,txtPassword);
	textInput.getChildren().addAll(tfUsername,pfPassword);
	
	HBox.setHgrow(label, Priority.ALWAYS);
	HBox.setHgrow(textInput, Priority.ALWAYS);
	VBox.setVgrow(txtUsername, Priority.ALWAYS);
	VBox.setVgrow(txtPassword, Priority.ALWAYS);
	VBox.setVgrow(tfUsername, Priority.ALWAYS);
	VBox.setVgrow(pfPassword, Priority.ALWAYS);
	 
	controls.getChildren().addAll(btnExit,btnLogin);
	 
	 //adding to the scene graph
	 this.getChildren().addAll(txtTitle,labelAndTextInputLayout,controls);
	
	 //pane alignment 
	 this.setAlignment(Pos.CENTER);
	 txtTitle.setAlignment(Pos.CENTER);
	 txtUsername.setAlignment(Pos.CENTER);
	 txtPassword.setAlignment(Pos.CENTER);
	 
	 
	
	 btnExit.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	 btnLogin.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	 tfUsername.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	 pfPassword.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	 txtTitle.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	 txtUsername.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	 txtPassword.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	 
	 //underline the title
	 txtTitle.setUnderline(true);
	
	//seting font size
	txtTitle.setFont(new Font(40));
	txtUsername.setFont(new Font(40));
	txtPassword.setFont(new Font(40));
	btnExit.setFont(new Font(40));
	btnLogin.setFont(new Font(40));
	
	 
	 tfUsername.setFont(new Font(20));
		pfPassword.setFont(new Font(20));
	 //growth 
		VBox.setVgrow(txtTitle, Priority.ALWAYS);
		VBox.setVgrow(labelAndTextInputLayout, Priority.ALWAYS);
		VBox.setVgrow(controls, Priority.ALWAYS);
	this.setFillWidth(true);
	 
	 
	 
	 controls.setFillHeight(true);
	 HBox.setHgrow(btnExit, Priority.ALWAYS);
	 HBox.setHgrow(btnLogin, Priority.ALWAYS);
	
	
	//the padding
	 	this.setPadding(new Insets(20, 20, 20, 20));
	 
}
	/**
	 * set the btnLogin event handler
	 * @param Event = EventHandler<ActionEvent>
	 */
	public void setBtnLoginEventHandler(EventHandler<ActionEvent> Event) {
		btnLogin.setOnAction(Event);
	}
	/**
	 * set the btnExit event handler
	 * @param Event = EventHandler<ActionEvent>
	 */
	public void setBtnExitEventHandler(EventHandler<ActionEvent> event) {
		btnExit.setOnAction(event);
	}
	/**
	 * get the user input. the input that the user input in to tfUsername
	 * @return string (user input)
	 */
public String getUserUsernameInput() {
	return tfUsername.getText().toString();
}
/**
 * get the user input. the input that the user input in to pfPassword
 * @return String (user input)
 */
public String getUserPasswordInput() {
	return pfPassword. getText().toString(); 
}
/**
 * clears the input fields, sets the inputs to ""
 */
public void clearInput() {
	pfPassword.setText("");
	tfUsername.setText("");
}
}

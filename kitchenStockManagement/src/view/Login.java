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
 * 
 * @author George
 *first page loaded, login page for the application.
 */
public class Login extends VBox {
//fields 
	private HBox username;
	private HBox password;
	private HBox controls;
	private Label lbTitle = new Label("Login");
	private Label lbUsername = new Label("username");
	private Label lbPassword = new Label("password");
	private Button btnExit = new Button("Exit");
	private Button btnLogin = new Button("Login");
	private TextField tfUsername = new TextField();
	private PasswordField pfPassword = new PasswordField();
	
	
	/**
	 * initialling the layout and set the properties.
	 */
	public Login() {
		
		super(20);
		
		//Creating HBox, adding the children.
	 username = new HBox(20);
	 username.getChildren().addAll(lbUsername,tfUsername);
	
	 password = new HBox(20);
	 password.getChildren().addAll(lbPassword,pfPassword);
	 
	 controls = new HBox(20);
	 controls.getChildren().addAll(btnExit,btnLogin);
	 
	 //adding to the scene graph
	 this.getChildren().addAll(lbTitle,username,password,controls);
	
	 //pane alignment 
	 this.setAlignment(Pos.CENTER);
	 username.setAlignment(Pos.CENTER);
	 password.setAlignment(Pos.CENTER);
	 controls.setAlignment(Pos.CENTER);
	 
	 
	 //button growth 
	 btnExit.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	 btnLogin.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	 tfUsername.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	 pfPassword.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	
	 //underline the title
	 lbTitle.setUnderline(true);
	
	//seting font size
	lbTitle.setFont(new Font(40));
	lbUsername.setFont(new Font(40));
	lbPassword.setFont(new Font(40));
	btnExit.setFont(new Font(40));
	btnLogin.setFont(new Font(40));
	
	 
	 tfUsername.setFont(new Font(20));
		pfPassword.setFont(new Font(20));
	 //growth 
	 this.setVgrow(lbTitle, Priority.SOMETIMES);
	 this.setVgrow(username, Priority.SOMETIMES);
	 this.setVgrow(password, Priority.SOMETIMES);
	 this.setVgrow(controls, Priority.ALWAYS);
	 this.setFillWidth(true);
	 
	 username.setHgrow(lbUsername, Priority.ALWAYS);
	 username.setHgrow(tfUsername, Priority.ALWAYS);
	 username.setFillHeight(true);
	 
	 password.setHgrow(lbPassword, Priority.ALWAYS);
	 password.setHgrow(pfPassword, Priority.ALWAYS);
	 password.setFillHeight(true);
	 
	 controls.setFillHeight(true);
	 controls.setHgrow(btnExit, Priority.ALWAYS);
	 controls.setHgrow(btnLogin, Priority.ALWAYS);
	
	
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
}

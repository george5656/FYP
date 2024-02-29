package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import model.ModelRoot;
import view.RootView;

/**
 * the controller class of the MVC for the kitchen management system.
 * 
 * @author George
 */
public class Controller {
	// field 
	private ModelRoot model;
	private RootView view;
	// private String stockId;

	/**
	 * Constructor, indicate all the other classes and assigning the event handlers.
	 * 
	 * @param model. the root of the M from MVC
	 * @param view.  the root of the v from MVC
	 */
	public Controller(ModelRoot model, RootView view) {
 
		// shadowing
		this.model = model;
		this.view = view;
		
		//login
		view.setLoginBtnExit(new EHExit());
		view.setLoginBtnLogin(new EHLogin());
		
		//home page
		view.setHomeBtnStockEventHandler(new EHStockListLaod());
		view.setHomeBtnMenuEventHandler(new EHMenuListLoad());
		view.setHomeBtnAccountEventHandler(new EHAccountListLoad());
		view.setHomeBtnBudgetEventHandler(new EHBudgetListLoad());
		view.setHomeBtnStorageEventHandler(new EHStorageListLoad());
		view.setHomeBtnAboutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("this is the main navigation page, click a button to go somewhere").show();
		});
		
		//stockList page
		view.setStockListBtnDeleteEventHandler(new EHStockListBtnDelete());
		view.setStockListBtnAddEventHandler(new EHStockBtnAdd());
		view.setStockListBtnFilterEventHandler(new EHStockBtnFilter());
		view.setStockListBtnFindEventHandler(new EHStockListBtnFind());
		view.setStockListBtnEditEventHandler(new EHStockListBtnEdit());
		view.setStockListBtnAboutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("this page displays all the current stock. it "
					+ "also is used to navigate to pages that manipulate the stock").show();
		});
		
		//stock add/edit/details page
		view.setStockDetailsBtnSaveEventHandler(new EHStockDetailsBtnSave());
		view.setStockDetailsBtnCancelEventHandler(new EHStockListLaod());
		view.setStockDetailsBtnLoadFromFileEventHandler(new EHStockDetailsBtnLoadFromFile());
		view.setStockDetailsBtnAboutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("this page is where you can add or"
					+ " update a stock depeding on the button picked in the previous page").show();
		});
		
		//page to filter the stock seen in stock list page
		view.setStockFilterBtnApply(new EHStockFilterBtnApply());
		view.setStockFilterBtnCancel(new EHStockListLaod());
		view.setStockFilterBtnAbout((ActionEvent event) -> {
			model.makeInfoAlert("pick the filter to be applied to the list on the page just left").show();
		});
		
		//menuList page
		view.setMenuListBtnFilterEventHandler(new EHMenuBtnFilter());
		view.setMenuListBtnAddEventHandler(new EHMenuListBtnAdd());
		view.setMenuListBtnFindEventHandler(new EHMenuListBtnFind());
		view.setMenuListBtnDeleteEventHandler(new EHMenuListBtnDelete());
		view.setMenuListBtnEditEventHandler(new EHMenuListBtnEdit());
		view.setMenuListBtnAboutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("this page displays all the current menus. it "
					+ "also is used to navigate to pages that manipulate the menus").show();
		});
		
		//page to make menu and manipulate the dishes
		view.setMenuDetailsBtnSettingEventHandler(new EHMenuDetailsBtnSetting());
		view.setMenuDetailsBtnOutputEventHandler(new EHMenuDetailsBtnOutput());
		view.setMenuDetailsBtnFilterEventHandler(new EHDishesBtnFilter());
		view.setMenuDetailsBtnAddEventHandler(new EHMenuDetailsBtnAdd());
		view.setMenuDetailsBtnFindEventHandler(new EHMenuDetailsBtnFind());
		view.setMenuDetailsBtnNewDishEventHandler(new EHMenuDetailsBtnAddNewDish());
		view.setMenuDetailsBtnRemoveFromListEventHandler(new EHMenuDetailsBtnRemoveFromList());
		view.setMenuDetailsBtnDeleteDishPermentlyFromListEventHandler(new EHMenuDetailsBtnDeleteDishPermentlyFromList());
		view.setMenuDetailsBtnEditEventHandler(new EHMenuDetailsBtnEdit());
		view.setMenuDetailsBtnLoadFromFileChooserEventHandler(new EHMenuDetailsBtnLoadFromFileChooser());
		view.setMenuDetailsBtnAboutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("this page shows all the dish, is used to make or edit a menu "
					+ "and is used to navaget to the dishes manipulation").show();
		});
		
		//page to set the menu budget and name
		view.setMenuSettingBtnSaveEventHandler(new EHMenuSettingBtnSave());
		view.setMenuSettingBtnCancelEventHandler(new EHMenuDetailsLoad());
		view.setMenuSettingBtnAboutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("this page is used to set the menu name and the budget the menu uses").show();
		});
		
		//page to filter menus on the menu list page
		view.setMenufilterBtnSaveEventHandler(new EHMenuFilterBtnSave());
		view.setMenufilterBtnCancelEventHandler(new EHMenuListLoad());
		view.setMenufilterBtnAboutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("pick the filter to be applied to the list on the page just left").show();
		});
		
		//page to list the budgets
		view.setBudgetListBtnAddEventHandler(new EHBudgetBtnAdd());
		view.setBudgetListBtnFilterEventHandler(new EHBudgetBtnFilter());
		view.setBudgetListBtnFindEventHandler(new EHBudgetListBtnFind());
		view.setBudgetListBtnDeleteEventHandler(new EHBudgteListBtnDelete());
		view.setBudgetListBtnEditEventHandler(new EHBudgetBtnEdit());
		view.setBudgetListBtnAboutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("this page displays all the current budgets. it "
					+ "also is used to navigate to pages that manipulate the budgets").show();
		});
		
		//page to create or edit a budget
		view.setBudgetDetailsBtnSaveEventHandler(new EHBudgetDetailsBtnSave());
		view.setBudgetDetailsBtnCancelEventHandler(new EHBudgetListLoad());
		view.setBudgetDetailsBtnAboutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("this page is where you can add or"
					+ " update a budget depeding on the button picked in the previous page").show();
		});
		
		//page to filter the budgets on the budget list page
		view.setBudgetFilterBtnSaveEventHandler(new EHBudgetFilterBtnApply());
		view.setBudgetFilterBtnCancelEventHandler(new EHBudgetListLoad());
		view.setBudgetFilterBtnAboutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("pick the filter to be applied to the list on the page just left").show();
		});
		
		//page list all the storage locations
		view.setStorgaeLocationListBtnAddEventHandler(new EHStorageBtnAdd());
		view.setStorgaeLocationListBtnFilterEventHandler(new EHStorageBtnFilter());
		view.setStorgaeLocationListBtnFindEventHandler(new EHStorageListBtnFind());
		view.setStorgaeLocationListBtnDeleteEventHandler(new EHStorageListBtnDelete());
		view.setStorgaeLocationListBtnEditEventHandler(new EHStorageListBtnEdit());
		view.setStorgaeLocationListBtnAboutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("this page displays all the current storage locations. it "
					+ "also is used to navigate to pages that manipulate the storage locations").show();
		});
		
		//page filters the storage locations lists
		view.setStorageFilterBtnApplyEventHandler(new EHStorageFilterBtnApply());
		view.setStorageFilterBtnCancelEventHandler(new EHStorageListLoad());
		view.setStorageFilterBtnAboutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("pick the filter to be applied to the list on the page just left").show();
		});
		
		//page to add or edit a stoarge locations details
		view.setStorageDetailsBtnSaveEventHandler(new EHStorageDetailsBtnSave());
		view.setStorageDetailsBtnCancelEventHandler(new EHStorageListLoad());
		view.setStorageDetailsBtnAbooutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("this page is where you can add or"
					+ " update a Storage location depeding on the button picked in the previous page").show();
		});
		
		//page to list all the accounts
		view.setAccountListBtnAddEventHandler(new EHAccountBtnAdd());
		view.setAccountListBtnFilterEventHandler(new EHAccountBtnFilter());
		view.setAccountListBtnFindEventHandler(new EHAccountBtnFind());
		view.setAccountListBtnDeleteEventHandler(new EHAccountListBtnDelete());
		view.setAccountListBtnEditEventHandler(new EHAccountListBtnEdit());
		view.setAccountListBtnAboutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("this page displays all the current accounts. it "
					+ "also is used to navigate to pages that manipulate the accounts").show();
		});
		
		//page to add or edit account details
		view.setAccountDetailsBtnSaveEventHandler(new EHAccountDetailsBtnSave());
		view.setAccountDetailsBtnCancelEventHandler(new EHAccountListLoad());
		view.setAccountDetailsBtnAboutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("this page is where you can add or"
					+ " update a account depeding on the button picked in the previous page").show();
		});
		
		//page to filter all the accounts listed
		view.setAccountFilterBtnApplyEventHandler(new EHAccountFilterBtnApply());
		view.setAccountFilterBtnCancelEventHandler(new EHAccountListLoad());
		view.setAccountFilterBtnAboutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("pick the filter to be applied to the list on the page just left").show();
		});
		
		//page to delete data
		view.setDeleteConfirmationBtnConfirmEventHandler(new EHDeleteBtnConfirm());
		view.setDeleteConfirmationBtnCancelEventHandler(new EHDeleteBtnCancel());
		view.setDeleteConfirmationBtnAboutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("select if you want the shown item to be delted").show();
		});
		
		//set the funcanality for the menu bar
		view.setAllPaneMenu(new EHHomeLoad(), new EHLogout());
	
		//page to create an edit a dish
		view.setDishDetailsBtnAddEventHandler(new EHDishDetailsBtnAdd());
		view.setDishDetailsBtnDeleteEventHandler(new EHDishDetailsBtnDelete());
		view.setDishDetailsBtnEditEventHandler(new EHDishDetailsBtnEdit());
		view.setDishDetailsBtnSaveEventHandler(new EHDishDetailsBtnSave());
		view.setDishDetailsBtnCanceltHandler(new EHMenuDetailsLoad());
		view.setDishDetailsBtnAboutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("This is the page where you can make a new dish which will be shown in the menu list page").show();
		});
		
		//page to filter all the dishes 
		view.setDishFilterBtnApplyEventHandler(new EHDishFilterBtnApply());
		view.setDishFilterBtnCancelEventHandler(new EHMenuDetailsLoad());
		view.setDishFilterBtnAboutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("pick the filter to be applied to the list on the page just left").show();
		});
		
		//page for outtpung the list in the menu details page
		view.setOutputBtnMenuEventHandler(new EHOutputBtnMenuFromList());
		view.setOutputBtnShoppingEventHandler(new EHOutputBtnShoppingFromList());
		view.setOutputBtnSaveEventHandler(new EHOutputBtnSave());
		view.setOutputBtnBackToMenuDetailsEventHandler(new EHMenuDetailsLoad());
		view.setOutputBtnBackToMenuListEventHandler(new EHMenuListLoad());
		view.setOutputBtnAboutEventHandler((ActionEvent event) -> {
			model.makeInfoAlert("pick if you would like to save to the database or to a text document").show();
		});
	}

	/**
	 * 
	 * close the application.
	 * @author Student EH = event handler
	 */
	private class EHExit implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// if not zero then it an abnormal exit
			System.exit(0);

		}

	}

	/**
	 * class for the btnLogin from Login class. it take the input and validates it,
	 * if an issue is present it shows an error message, if pass validation the password is then 
	 * hashed (SHA-256) and checked against the database to see if it matches it loads the home page, 
	 * type load based on the the account that is logged in, if the password and user name doesn't match
	 * it again shows an error message. error message done by alert dialog box.
	 * 
	 * @author Student
	 *
	 */
	private class EHLogin implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			String errorUsername = model.stringMustBePresetValidation(view.getLoginUserUsernameInput());
			String errorPassword = model.stringMustBePresetValidation(view.getLoginUserPasswordInput());
			Boolean passValidation = false;
			Alert alert;
			if (!errorUsername.equals("")) {
				alert = model.makeAlert("username issue", errorUsername);
				alert.show();
			} else if (!errorPassword.equals("")) {
				alert = model.makeAlert("password issue", errorPassword);
				alert.show();
			} else {
				passValidation = true;
			}
			if (passValidation == true) {

				if (!model.passwordAndUsernameAreValid(view.getLoginUserUsernameInput(),
						model.hash(view.getLoginUserPasswordInput()))) {
					alert = model.makeAlert("input issue", "user name and password didn't match");
					alert.show();
				} else {
					model.checkAdminStatusInDb(view.getLoginUserUsernameInput());
					
					view.homePageMenuLoad(model.getLoggedInAccountAdminStatus());
					model.setLogedInAccount(view.getLoginUserUsernameInput());
				}
			}

		}
	}

	/**
	 * class loads the menu list page and populate its list view with all the menus in the database.
	 * @author Student
	 *
	 */
	private class EHMenuListLoad implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			view.menuListLoad(model.getAllMenus());
		
		}

	}
	/**
	 * class loads the menu details page.
	 * @author Student
	 *
	 */
	private class EHMenuDetailsLoad implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.clearMenuDetailsListSelection();
			view.MenuDetailsRestFindInput();
			view.MenuDetailsLoad();
		
		}

	}
	/**
	 * loads the menu details page.
	 * it sets the from menu to null so that it know its an add and not an edit,
	 * it also populates the combo box, with all the dishes the database has.
	 * @author Student
	 *
	 */
	private class EHMenuListBtnAdd implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.clearMenuSettingPage();
			view.resetMenuDetailsPage();
			model.setFromMenu(null);
			model.resetMenuDetailList();
			view.setMenuDetailsDishList(model.getAllDishes());
			model.resetSelectedMenu();
			view.resetMenuDetailsPage();
			view.setMenuDetailsBudgetValue("not selected");
			view.MenuDetailsLoad();
		}

	}
	/**
	 * loads the delete page. 
	 * it checks the user has selected an item from the list view
	 * if no item has been selected it make the error message label visible saying the issue
	 * if an item has been selected it loads the delete confirmation page
	 * with the name of the item to be deleted in it. 
	 * 
	 * 
	 * @author Student
	 *
	 */
	private class EHStockListBtnDelete implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			if (!view.getStockListSelectedItem().equals("null")) {

				model.selectAStock(view.getSelectedStockId());

				view.getDeleteConfirmationPage()
						.setTxtConfirmMessage("Are you sure you wan to delete " + model.getSelectedStockName() + "?");
				model.setDeleteFrom("StockList");
				view.deleteConfirmationLoad();
			} else {
				view.setStockListError("No data selected");

			}
		}

	}
	/**
	 * loads the delete page. 
	 * it checks the user has selected an item from the list view
	 * if no item has been selected it make the error message label visible saying the issue
	 * if an item has been selected it loads the delete confirmation page
	 * with the name of the item to be deleted in it. 
	 * 
	 * 
	 * @author Student
	 *
	 */
	private class EHBudgteListBtnDelete implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			if (!view.getBudgetListSelectedItem().equals("null")) {
				
				model.selectABudget(view.getSelectedBudgetId());
				
				view.getDeleteConfirmationPage()
						.setTxtConfirmMessage("Are you sure you wan to delete " + view.getSelectedBudgetId() + "?");
				
				model.setDeleteFrom("BudgteList");
				
				view.deleteConfirmationLoad();
				
			} else {
				
				view.setBudgetListErrorMessage("No data selected");
				
			}
		}

	}
	/**
	 * loads the delete page. 
	 * it checks the user has selected an item from the list view
	 * if no item has been selected it make the error message label visible saying the issue
	 * if an item has been selected it loads the delete confirmation page
	 * with the name of the item to be deleted in it. 
	 * 
	 * 
	 * @author Student
	 *
	 */
	private class EHAccountListBtnDelete implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			if (!view.getAccountListSelectedItem().equals("null")) {

				model.selectAAccount(view.getSelectedAccountName());
				
				if((model.getSelectedAccountAdminStatus().equals(false) || model.getSelectedAccountUsername().equals(model.getLogedInAccountId()))) {
					//this is the final check, making sure the last admin cant just delete there account
					if(model.doesTheDatabaseHaveMoreThanOneAdminLeft()) {
				view.getDeleteConfirmationPage()
						.setTxtConfirmMessage("Are you sure you wan to delete " + model.getSelectedAccountUsername() + "?");
				model.setDeleteFrom("Account");
				view.deleteConfirmationLoad();
					}else {
						view.setAccountListError("last admin in database cant \ndelete there account");
					}
				
				}else {
					view.setAccountListError("must be that admin to delete that account");
				}
				} else {
				view.setAccountListError("No data selected");

			}
		}

	}
	/**
	 * loads the delete page. 
	 * it checks the user has selected an item from the list view
	 * if no item has been selected it make the error message label visible saying the issue
	 * if an item has been selected it loads the delete confirmation page
	 * with the name of the item to be deleted in it. 
	 * 
	 * 
	 * @author Student
	 *
	 */
	private class EHStorageListBtnDelete implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			if (!view.getStorageListSelectedItem().equals("null")) {

				model.selectAStorageLocation(view.getSelectedStorageId());

				view.getDeleteConfirmationPage()
						.setTxtConfirmMessage("Are you sure you wan to delete " + model.getSelectedStorageName() + "?");
				model.setDeleteFrom("Storage");
				view.deleteConfirmationLoad();
			} else {
				view.setStorageListErrorMessage("No data selected");

			}
		}
	}
	/**
	 * loads the dish details page.
	 * sets the came from edit to false and details original id to null
	 * so it knows that it is, adding not editing. 
	 * @author Student
	 *
	 */
	private class EHMenuDetailsBtnAddNewDish implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.clearDishDetailsPage();
			model.setDishDetailsCameFromEdit(false);
			model.setDishDetailsOrginalId(null);
			view.dishDetailsLoad();
			
		}

	}
	/**
	 * loads the DishDetails page.
	 * check the user has selected a dish from the list view.
	 * if no dish has been selected an error message is shown, 
	 * if a dish has been shown it loads the dish details page,
	 * with that dish details populating the dish details list view.
	 * 
	 * @author Student
	 *
	 */
	
	private class EHMenuDetailsBtnEdit implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			
			String issueFrom ="";
			String masterErrorMessage ="";
			if(view.getMenuDetailsDishListSelectedItemIndex() == -1 && view.getMenuDetailsMenuListSelectedIndex() == -1) {
				issueFrom = "the lists";
				masterErrorMessage = "no item selected";
			} else if (view.getMenuDetailsDishListSelectedItemIndex() != -1 && view.getMenuDetailsMenuListSelectedIndex() != -1) {
				issueFrom = "the list";
				masterErrorMessage = "please only select from one list at a time";
			}
			
			
			if (masterErrorMessage.equals("")) {

				//gets the dish and stores it to be used later
				view.clearDishDetailsPage();
				model.setDishDetailsCameFromEdit(true);
				//simply as could come from one of two lists
				if(view.getMenuDetailsDishListSelectedItemIndex() != -1) {
				model.setDishDetailsOrginalId(view.getMenuDetailsDishListSelectedItemValueIdOnly());
				model.setDishStockId(view.getMenuDetailsDishListSelectedItemValueIdOnly());
				model.setSelectedDish(model.getASpecificDish(view.getMenuDetailsDishListSelectedItemValueIdOnly()));
				}else {
					model.setDishDetailsOrginalId(view.getMenuDetailsMenuDishListSelectedItemValueIdOnly());
					model.setDishStockId(view.getMenuDetailsMenuDishListSelectedItemValueIdOnly());
					model.setSelectedDish(model.getASpecificDish(view.getMenuDetailsMenuDishListSelectedItemValueIdOnly()));
				}
				
				view.setDishDetailsList(model.getSelectedDishList());
				view.dishDetailsLoad();
				view.dishDetailsAddReset();
			
			} else {
				model.makeAlert(issueFrom, masterErrorMessage).show();
				view.clearMenuDetailsListSelection();
			}
			
		}

	}
	
/**
 * loads a menu from a text file which the user picks form the file chooser.
 * first it checks if the use has inputed in a menu name and a budget in the settings page
 * if not it shows an alert error message
 * if they have it loads a file chooser.
 * if the user inputs a file that isnt the correct file type it will show an error message
 * if the file has unrecognisable dishes, it will show a information alert box that dishes where not readable.
 * if no issue happen it will populate the menu details page with the info in the file.
 * 
 * @author Student
 *
 */
	private class EHMenuDetailsBtnLoadFromFileChooser implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			String issueFrom="";
			String masterErrorMessage = "";
			File chosenLocation = null;
			int dishNotRecognised = 0;
			//used to know if they input a known dish or not
			ArrayList<String> getAllCurrentdDishes = model.getAllCurrentDishName();
			
			if(model.getSelectedMenu() == null) {
				issueFrom = "missing data";
				masterErrorMessage = "need to go to setting before can continue";
			}
			// in here as want only alert message, but also dont want the user to have to
			//do this of already have an error but can be in the one with the scanner as 
			//also need to check the file they get
			if(masterErrorMessage.equals("")) {
			 chosenLocation = new FileChooser().showOpenDialog(null);	
			}
			
			if(chosenLocation == null) {
				issueFrom = "missing data";
				masterErrorMessage = "no file selected";
			}else if(!chosenLocation.toURI().toString().endsWith(".txt")) {
				issueFrom = "file Selected";
				masterErrorMessage = "only .txt files allowed";
			}
			
			
			if(masterErrorMessage.equals("")) {
			
			try {
				Scanner sc = new Scanner(chosenLocation).useDelimiter("[\n\r]+");
				
				sc.next();
				while(sc.hasNext()) {
					String dishIdInStringFormat = sc.next();
					//two as its "= "
					String id ="";
					if((dishIdInStringFormat.indexOf("=")+2) != -1) {
					id = dishIdInStringFormat.substring(dishIdInStringFormat.indexOf("=")+2);
					}
					
					
					
					if(getAllCurrentdDishes.contains(id)) {
					
					model.addDishToSelectedMenu(id);
					view.setMenuDetailsMenuListItems(model.getSelectedMenuDishes());
					model.resetMenuDetailList();
					view.setMenuDetailsDishList(model.getNotSelectedDishesAsString());
					view.setMenuDetailsShoppingList(model.getSelectedMenuStockType());
					// +"" is simply to convert it to a string
					view.setMenuDetailsBudgetValue(model.getBudgetSizeMinusTheShoppingList()+"");
					}else {
						dishNotRecognised = dishNotRecognised + 1;
					}
				}
				sc.close();
			
			
			
			
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
			}else {
				//if top error fail 
				model.makeAlert(issueFrom, masterErrorMessage).show();
			}
			
			
			if(dishNotRecognised != 0) {
				Alert missedDishes = new Alert(AlertType.INFORMATION);
				missedDishes.setContentText(dishNotRecognised +" where not recognised");
				missedDishes.setHeaderText("file input");
				missedDishes.setTitle("warning");
				missedDishes.show();
			}
		}

	}
	/**
	 * loads the stock detail page.
	 * the input fields in the stock details page are empty and ready for new input.
	 * @author Student
	 *
	 */
	private class EHStockBtnAdd implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			model.createStock(-1, "null", -1.00, "null", "null", "null", -1.00);
			resetStockDetailsPage();
			view.stockDetailsLoad(true);
			model.setStockFrom(true);
		}

	}
/**
 * loads the budget detail page.
 * the input fields in the budget details page are empty and ready for new input.
 * @author Student
 *
 */
	private class EHBudgetBtnAdd implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			view.clearBudgetDetailsPage();
			model.resetABudget();
			view.budgetDetailsLoad();

		}

	}
	
	/**
	 * loads the storage details page.
	 * checks the user has selected an item from the list view
	 * if no item has been selected it make the error label visible with info about the error
	 * if an item has been selected it loads the storage details page with the selected items 
	 * info populating it. 
	 * @author Student
	 *
	 */
	private class EHStorageListBtnEdit implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			if (!view.getStorageListSelectedItem().equals("null")) {

				model.selectAStorageLocation(view.getSelectedStorageId());
				view.setStorageLocationDetailsValues(model.getSelectedStorageName(), model.getSelectedStorageType(), model.getSelectedStorageAvailbilty());
				view.StorgaeLocationDetailsLoad();
				
				
			} else {
				view.setStorageListErrorMessage("No data selected");

			}
		}
	}
	/**
	 * loads the budget details page.
	 * checks the user has selected an item from the list view
	 * if no item has been selected it make the error label visible with info about the error
	 * if an item has been selected it loads the budget details page with the selected items 
	 * info populating it. 
	 * @author Student
	 *
	 */
	private class EHBudgetBtnEdit implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
		
if (!view.getBudgetListSelectedItem().equals("null")) {
				
		
			view.clearBudgetDetailsPage();
			model.resetABudget();
			model.selectABudget(view.getSelectedBudgetId());
			
			view.setBudgetDetailsName(model.getSelectedBudgetName());
			view.setBudgetDetailsAmount(model.getSelectedBudgetAmount());
			view.setBudgetDetailsStartDate(model.deFormatDate(model.getSelectedBudgetStartDate()));
			view.setBudgetDetailsEndDate(model.deFormatDate(model.getSelectedBudgetEndDate()));
		
			view.budgetDetailsLoad();
} else {
	
	view.setBudgetListErrorMessage("No data selected");
	
}


		}

	}
	/**
	 * loads the account details page.
	 * checks the user has selected an item from the list view
	 * if no item has been selected it make the error label visible with info about the error
	 * if the selected item is an admin and is not the logged in admin an error message is shown
	 * if an item has been selected and isnt an admin account or is the logged in admin account it loads the account 
	 * details page with the selected items info populating it. 
	 * @author Student
	 *
	 */
	private class EHAccountListBtnEdit implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.resetAccountDetailPage();
			if (!view.getAccountListSelectedItem().equals("null")) {

				model.selectAAccount(view.getSelectedAccountName());
				
				if((model.getSelectedAccountAdminStatus().equals(false) || model.getSelectedAccountUsername().equals(model.getLogedInAccountId()))) {
					view.setAccountDetailsUsername(model.getSelectedAccountUsername());
					view.setAdminStatus(model.getSelectedAccountAdminStatus());
					view.accountDetailsLoad();
				
				}else {
					view.setAccountListError("must be that admin to edit that account");
				}
				} else {
				view.setAccountListError("No data selected");

			}
		}

	}
/**
 * loads the storage location details page. 
 * it clears any info that is the storage location details page and then loads it.
 * @author Student
 *
 */
	private class EHStorageBtnAdd implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			model.resetSelectedStorage();
			view.resetStorageLocationDetails();
			view.StorgaeLocationDetailsLoad();

		}

	}
	/**
	 * loads the account details page. 
	 * it clears any info that is the account details page and then loads it.
	 * @author Student
	 *
	 */
	private class EHAccountBtnAdd implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.resetAccountDetailPage();
			model.resetSelectedAccount();
			view.accountDetailsLoad();

		}

	}
/**
 * loads the stock storage location filter class/ page.
 * loads the page and populates the combo box with all the storage types the database has. 
 * @author Student
 *
 */
	private class EHStorageBtnFilter implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.StorgaeLocationFilterLoad(model.getAllStorgaeType());

		}

	}
	/**
	 * loads the stock filter class/ page.
	 * loads the page and populates the corresponding combo boxes with either 
	 * all the stock types or storage locations the database has depending on which combo box it is. 
	 * @author Student
	 *
	 */
	private class EHStockBtnFilter implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			view.stockFilterLoad(model.getObservableStorgaeLocationListNameOnlyArrayList(), model.getStockTypeListAsString());

		}

	}
	/**
	 * loads the budget filter class/ page
	 * @author Student
	 *
	 */
	private class EHBudgetBtnFilter implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.budgetfilterLoad();
		}

	}
	/**
	 * loads the filter dishes class/ page
	 * @author Student
	 *
	 */
	private class EHDishesBtnFilter implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.dishFilterLoad();

		}

	}
	/**
	 * loads the account filter class/ page
	 * @author Student
	 *
	 */
	private class EHAccountBtnFilter implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			view.accountFilterLoad();

		}

	}
	/**
	 * loads the menu filter class/ page
	 * @author Student
	 *
	 */
	private class EHMenuBtnFilter implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.menuFilterLoad();

		}

	}
/**
 * loads the settings page.
 * loads the menu details setting pages and populate the combo box
 * with all the budget that the database holds.
 * @author Student
 *
 */
	private class EHMenuDetailsBtnSetting implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			view.setMenuSettingBudgetOptions(model.getAllBudgetsButJustTheId());
			
			view.menuSettingsLoad();

		}

	}
/**
 * loads the home page.
 * loads the home page and sets the admin status, which determines 
 * the type of home page loaded, eg admin or none admin one.
 * @author Student
 *
 */
	private class EHHomeLoad implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.homePageMenuLoad(model.getLoggedInAccountAdminStatus());

		}

	}
/**
 * loads the login page.
 * take the user from what ever page they are on to the login page which input has been cleared from 
 * the last user input.
 * 
 * @author Student
 *
 */
	private class EHLogout implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			view.loginLoad();
		}

	}
/**
 * loads the output page.
 * button found in the menu details page.
 * @author Student
 *
 */
	private class EHMenuDetailsBtnOutput implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.outputPageLoad();

		}
	}
/**
 * saves the stock details in the database. 
 *it check the user input,
 *if there is an issue with it show this issue in an alert dialog box

 *if there is no issue it will look to see if there is a stored stock name/id
 *this is done as if they come from add there will be null but if from edit there will be an id/name
 *if there isnt one it will simply insert/ make a new one in the database,
 *if there is one it will update that stock type but only bits that very 
 *using the info provided. 
 *
 *it then check the get stock from, if true it makes a new stock, if false it updates the stock
 *this is set when the button eg add and edit is pressed, button in the stock list page.
 *it then loads the stock list page.
 *
 * @author Student
 *
 */
	private class EHStockDetailsBtnSave implements EventHandler<ActionEvent> {

		
		@Override
		public void handle(ActionEvent event) {
			// StockDetails userInput = view.getStockDetails();
			// a way to know if need to create it or not
			String masterErrorMessage = "";
			String issuesWith = "";
		
			//used to inform the user the Quantity Type and Cost will change. 
			Alert options = new Alert(AlertType.CONFIRMATION);
			Optional<ButtonType> output = null;
			
			

			String nameErrorMessage = model.stringMustBePresetValidation(view.getStockDetailsStockName());
			String quanityErrorMessage = model.doubleMustBePresetValidation(view.getStockDetailsQuantity());
			String quanityTypeErrorMessage = model.stringMustBePresetValidation(view.getStockDetailsQuanitType());
			String expiereDateErrorMessage = model.dateValidation(view.getStockDetailsDateText(),
					view.getStockDetailsDateValueAsLocalDate());

			String costErrorMessage = model.doubleMustBePresetValidation(view.getStockDetailsCost());
			
		
			
			// userInput.getExpiereDate().getValue().toString()
			if (!nameErrorMessage.equals("")) {
				masterErrorMessage = nameErrorMessage;
				issuesWith = "stock name";
			} else if (!quanityErrorMessage.equals("")) {
				masterErrorMessage = quanityErrorMessage;
				issuesWith = "quanity";
			} else if (!quanityTypeErrorMessage.equals("")) {
				masterErrorMessage = quanityTypeErrorMessage;
				issuesWith = "quantity type";
			} else if (!expiereDateErrorMessage.equals("")) {
				masterErrorMessage = expiereDateErrorMessage;
				issuesWith = "expiere date";
			} else if (!costErrorMessage.equals("")) {
				masterErrorMessage = costErrorMessage;
				issuesWith = "cost";
			} else if (view.getStockDetails().getStorageLocation().getSelectionModel().getSelectedItem() == null) {
				masterErrorMessage = "no item has been chosen";
				issuesWith = "storage location";
			}

			if (masterErrorMessage.equals("")) {
				
				//used to tell the user, hey your changing, x/y/z
				if(!(model.hasTheStockTypeCostChanged(view.getStockDetailsCost(),view.getStockDetailsStockName()).equals("")&&model.hasTheStockTypeQuanityTypeChanged(view.getStockDetailsQuanitType(),view.getStockDetailsStockName()).equals(""))) {
				
					options.setContentText("chaning the ");
					if(!model.hasTheStockTypeCostChanged(view.getStockDetailsCost(),view.getStockDetailsStockName()).equals("")) {
						
						options.setHeaderText("changing the cost of all the matching stock");
						options.setContentText(options.getContentText() + "cost from " + model.hasTheStockTypeCostChanged(view.getStockDetailsCost(),view.getStockDetailsStockName()));
					}
					if(!model.hasTheStockTypeQuanityTypeChanged(view.getStockDetailsQuanitType(),view.getStockDetailsStockName()).equals("")) {
						
						if(!options.getHeaderText().equals("changing the cost of all the matching stock")) {
							
							options.setHeaderText("quantity type");
							options.setContentText(options.getContentText() + "quanityType from " + model.hasTheStockTypeQuanityTypeChanged(view.getStockDetailsQuanitType(),view.getStockDetailsStockName()));
						}else {
							
							options.setHeaderText("changing the cost and quantity type of all the matching stock");
							options.setContentText(options.getContentText() + " and quantity type from " + model.hasTheStockTypeQuanityTypeChanged(view.getStockDetailsQuanitType(),view.getStockDetailsStockName()));
						}
						
					}
					
					output = options.showAndWait();
				}
				
				if(output == null || output.isPresent() && output.get() == ButtonType.OK) {
					
					
				model.setTestStockType(view.getStockDetailsStockName());

				if (model.getTestStockName() == "null") {

					model.addStockType(view.getStockDetailsStockName(), view.getStockDetailsCost(),
							view.getStockDetailsQuanitType());

				}else if (model.getTestStockCost() != view.getStockDetailsCost()) {

						model.updateStockTypeCost(view.getStockDetailsStockName(), view.getStockDetailsCost());
						model.updateStockTypeQuanityType(view.getStockDetailsStockName(),
								view.getStockDetailsQuanitType());
					} else if (model.getTestStockQuanityType() != view.getStockDetailsQuanitType()) {
						model.updateStockTypeQuanityType(view.getStockDetailsStockName(),
								view.getStockDetailsQuanitType());
					}
					

					if (model.getStockFrom()) {

						// CurrentStock stock = new
						// CurrentStock(-1,"cubbord",10.56,"units","2004-01-05","apple",5.00);

model.createStock(-1, view.getStorageLocation(), Double.parseDouble(view.getStockDetailsQuantity()),
		view.getStockDetailsQuanitType(), model.formatDate(view.getStockDetailsDateText()),
		view.getStockDetailsStockName(), 10.5);
						model.addCurrentStock();

					} else {

model.createStock(model.getSelectedStockId(), view.getStorageLocation(), Double.parseDouble(view.getStockDetailsQuantity()),
		view.getStockDetailsQuanitType(), model.formatDate(view.getStockDetailsDateText()),
		view.getStockDetailsStockName(), 10.5);
						model.updateCurrentStock();
					}
					loadStockListPage();
			}
				}else {
					// if it fails the first if, eg validation of the inputs fails
					Alert errorPopup = model.makeAlert("issue with " + issuesWith, masterErrorMessage);
					errorPopup.show();
			}
		}
	}
	/**
	 * loads the stock list page.
	 * the stock list page is loaded and the list view is populated with all the stock that the database
	 * has in a string format.
	 * @author Student
	 *
	 */
	private class EHStockListLaod implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			loadStockListPage();

		}
	}
	/**
	 * loads the stock list page.
	 * the stock list page is loaded and the list view is populated with all the stock that the database
	 * has in a string format.
	 *
	 */
	private void loadStockListPage() {

		view.stockListLoad(model.getObservableListStringStockList());
		
	}
/**
 * 
 * deletes a item from the database.
 * deletes the item it hold which name it is showing in the list view, which it got from the delete buttons
 * on the list pages. 
 *it will then load the list page they original came from 
 *the only time it wont do the above is if the user deletes there own account.
 *if a user is deleting there own account that they are currently logged in as, it will then take the user
 *to the log in page where there account will be removed and they will have to use another account
 *if they want to use the application
 * 
 * @author Student
 *
 */
	private class EHDeleteBtnConfirm implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
if(model.getDeleteFrom().equals("StockList")) {
			model.selectAStock(view.getSelectedStockId());
			model.deleteStockType();
			view.stockListLoad(model.getObservableListStringStockList());
}else if (model.getDeleteFrom().equals("BudgteList")) {
model.selectABudget(view.getSelectedBudgetId());
model.deleteBudgetType();
view.BudgetListLoad(model.getObservableListBudgetList());
} else if(model.getDeleteFrom().equals("Account")) {
	model.selectAAccount(view.getSelectedAccountName());
	
	model.deleteAccount();
	
	if(model.getLogedInAccountId().equals(model.getSelectedAccountUsername())) {
		//deletes own account 
		view.loginLoad();
	}else {
		view.accountListLoad(model.getObservableListAccountList());
	}
} else if(model.getDeleteFrom().equals("Storage")) {
	model.selectAStorageLocation(view.getSelectedStorageId());
	model.deleteSelectedStorage();
	loadStorgaeLocationListPage();
	
} else if(model.getDeleteFrom().equals("MenuDetails")) {
	if(view.getMenuDetailsDishListSelectedItemIndex() != -1) {
		view.setMenuDetailsDishList(model.deleteADish(view.getMenuDetailsDishListSelectedItemValueIdOnly()));
}else {
	
	view.setMenuDetailsDishList(model.deleteADish(view.getMenuDetailsMenuDishListSelectedItemValueIdOnly()));
	
	model.removeADishFromSelectedMenuDishes(view.getMenuDetailsMenuListSelectedIndex());
	model.resetMenuDetailList();
	view.setMenuDetailsMenuListItems(model.getSelectedMenuDishes());
	view.setMenuDetailsDishList(model.getNotSelectedDishesAsString());
	view.setMenuDetailsShoppingList(model.getSelectedMenuStockType());
	view.setMenuDetailsBudgetValue(model.getBudgetSizeMinusTheShoppingList()+"");
	
}
	//need to also remove from the temporary hold
	
	view.MenuDetailsLoad();
	
} else if (model.getDeleteFrom().equals("MenuList")) {
	model.deleteSelectedMenu();
	view.menuListLoad(model.getAllMenus());
}

		}
	}
	
	/**
	 * loads the page where the user came from and
	 * populates the corresponding list view with what the database holds.
	 * @author Student
	 *
	 */
	private class EHDeleteBtnCancel implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
if(model.getDeleteFrom().equals("StockList")) {
	view.stockListLoad(model.getObservableListStringStockList());
}else if (model.getDeleteFrom().equals("BudgteList")) {
	loadBudgetListPage();
} else if(model.getDeleteFrom().equals("Account")) {
	loadAccountListPage();
} else if(model.getDeleteFrom().equals("Storage")) {
	loadStorgaeLocationListPage();
	
} else if(model.getDeleteFrom().equals("MenuDetails")) {
	view.MenuDetailsLoad();

} else if (model.getDeleteFrom().equals("MenuList")) {
	view.menuListLoad(model.getAllMenus());
}

		}
	}
	
	
/**
 * 
 * makes the list view show just the stock that is like the find value input.
 * check the user input
 * if there is an issue the label is made visible and show the error
 * if there is no issue the list view is populates with all the stock the database has that is like
 * the user input. like in mysql is % user input %.
 * 
 * @author Student
 *
 */
	private class EHStockListBtnFind implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			String errorMessage = model.stringPresentIsOptionalValidation(view.getStockListTfFindValue());
			if (errorMessage.equals("")) {

				view.getStockListPage().getErrorLabel().setVisible(false);
				view.setStockListValues(model.getCurrentStockThatsLike(view.getStockListTfFindValue()));
			} else {
				view.setStockListError(errorMessage);
			}

		}
	}
	/**
	 * 
	 * makes the list view show just the accounts that are like the find value input.
	 * check the user input
	 * if there is an issue the label is made visible and show the error
	 * if there is no issue the list view is populates with all the accounts in the database has that are 
	 * like the user input. like in mysql is % user input %.
	 * 
	 * @author Student
	 *
	 */
	private class EHAccountBtnFind implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			String errorMessage = model.stringPresentIsOptionalValidation(view.getAccountTfFindValue());
			if (errorMessage.equals("")) {

				view.getAccountListPage().getErrorLabel().setVisible(false);
				view.accountListLoad(model.getAccountsThatsLike(view.getAccountTfFindValue()));
			} else {
				view.setAccountListError(errorMessage);
			}

		}
	}
	/**
	 * 
	 * makes the list view show just the storage locations that are like the find value input.
	 * check the user input
	 * if there is an issue the label is made visible and show the error
	 * if there is no issue the list view is populates with all the storage locations that the
	 * database has that is like the user input. like in mysql is % user input %.
	 * 
	 * @author Student
	 *
	 */
	private class EHStorageListBtnFind implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			String errorMessage = model.stringPresentIsOptionalValidation(view.getStorageLocationFindInput());
			if (errorMessage.equals("")) {

				view.hideStorageListErrorMessage();
			
				view.storgaeLocationListLoad(model.getStorageThatsLike(view.getStorageLocationFindInput()));
				
				view.setStockListValues(model.getCurrentStockThatsLike(view.getStockListTfFindValue()));
			} else {
				view.setStorageListErrorMessage(errorMessage);
			}

		}
	}
	/**
	 * It displays a filtered list of the stock items that are in the database based of the inputed filters.
	 * 
	 * it will first validate the input, no input is accepted. if there is an issue will display the issue
	 * in an alert dialog box. if there is no issue, it will display in the stock list page a list of 
	 * all the menu that passed all the filters. the inputs are from the stock filter page.
	 * @author Student
	 *
	 */
	private class EHStockFilterBtnApply implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			String masterErrorMessage = "";
			String issueFrom = "";
			String moreQuanityErrorMessage = model.doublePresentIsOptionalValidation(view.getStockFilterTfMinQunaity());
			String lessQuanityErrorMessage = model.doublePresentIsOptionalValidation(view.getStockFilterTfMaxQunaity());
			/*
			 * String date = "null";
			 * if(view.getStockDetails().getExpiereDate().getEditor().getText() != null) {
			 * date = view.getStockDetails().getExpiereDate().getValue().toString(); }
			 */
			// test for date to see if the userforgot to hit entere,
			// one part test if the user input any info, part two is testing if that input
			// got registeres
			String expiresAfterErrorMessage = model.dateValidationPresentIsOptional(view.getStockFilterDpAfterDateText(),
					view.getStockFilterDpAfterDateValuePresent());
			String expiresBeforeErrorMessage = model.dateValidationPresentIsOptional(view.getStockFilterDpBeforeDateText(),
					view.getStockFilterDpBeforeDateValuePresent());

			String costMoreErrorMessage = model.doublePresentIsOptionalValidation(view.getStockFilterAboveCost());
			String costLessErrorMessage = model.doublePresentIsOptionalValidation(view.getStockFilterBelowCost());

			if (!moreQuanityErrorMessage.equals("")) {
				masterErrorMessage = moreQuanityErrorMessage;
				issueFrom = "more quantit than";
			} else if (!lessQuanityErrorMessage.equals("")) {
				masterErrorMessage = lessQuanityErrorMessage;
				issueFrom = "less quantit than";
			} else if (!expiresAfterErrorMessage.equals("")) {
				masterErrorMessage = expiresAfterErrorMessage;
				issueFrom = "expires after";
			} else if (!expiresBeforeErrorMessage.equals("")) {
				masterErrorMessage = expiresBeforeErrorMessage;
				issueFrom = "expires before";
			} else if (!costMoreErrorMessage.equals("")) {
				masterErrorMessage = costMoreErrorMessage;
				issueFrom = "cost more than";
			} else if (!costLessErrorMessage.equals("")) {
				masterErrorMessage = costLessErrorMessage;
				issueFrom = "cost less than";
			}

			if (masterErrorMessage.equals("")) {
				String whereClause = "";
				// so if the user didn't input a value it not added
				
				if (!view.getStockFilterStorgaeLocation().equals("null")) {
					whereClause = whereClause
							+ "tbl_stock_iteration.storageLocationId = \"" + view.getStockFilter()
									.getCbStorageLocation().getSelectionModel().getSelectedItem().toString()
							+ "\" And ";
				}

				if (!view.getStockFilterStockType().equals("null")) {
					whereClause = whereClause + "tbl_stock_iteration.stockTypeId = \""
							+ view.getStockFilter().getCbStockType().getSelectionModel().getSelectedItem().toString()
							+ "\" And ";
				}

				if (!view.getStockFilterTfMinQunaity().equals("")) {
					whereClause = whereClause + "tbl_stock_iteration.quanity >= \""
							+ view.getStockFilter().getTfMinQunaity().getText() + "\" And ";
				}

				if (!view.getStockFilterTfMaxQunaity().equals("")) {
					whereClause = whereClause + "tbl_stock_iteration.quanity <= \""
							+ view.getStockFilter().getTfMaxQuanity().getText() + "\" And ";

				}
				boolean expiresAfterToRun = model.dateValidation(view.getStockFilterDpAfterDateText(),
						view.getStockFilterDpAfterDateValuePresent()).equals("");
				boolean expiresBeforeToRun = model.dateValidation(view.getStockFilterDpBeforeDateText(),
						view.getStockFilterDpBeforeDateValuePresent()).equals("");
				
				if (expiresAfterToRun) {
				
					whereClause = whereClause + "tbl_stock_iteration.expiereDate > \""
							+ model.formatDate(view.getStockFilterDpAfterDateText()) + "\" And ";
					
				}

				if (expiresBeforeToRun) {
					
					whereClause = whereClause + "tbl_stock_iteration.expiereDate < \""
							+ model.formatDate(view.getStockFilterDpBeforeDateText()) + "\" And ";

				}

				if (!view.getStockFilterAboveCost().equals("")) {
					whereClause = whereClause + "tbl_stock_type.cost >= \""
							+ view.getStockFilter().getTfAboveCost().getText() + "\" And ";

				}
				if (!view.getStockFilterBelowCost().equals("")) {
					whereClause = whereClause + "tbl_stock_type.cost <= \""
							+ view.getStockFilter().getTfAboveCost().getText() + "\" And ";

				}
				// so doesn't run and crash if none put in, and also remove that \"and\" have at
				// the end as could end anywhere
				
				if (!whereClause.equals("")) {
					whereClause = whereClause.substring(0, whereClause.length() - 5) + ";";
					view.stockListLoad(model.getCurrentStockThatsMatchesWhere(whereClause));
				}else {
					view.stockListLoad(model.getObservableListStringStockList());
				}
				

			} else {
				// if fails validation does this part
				Alert errorMessagePopup = model.makeAlert(issueFrom, masterErrorMessage);
				errorMessagePopup.show();
			}
		
		}
	
	}
	
	/**
	 * It displays a filtered list of the budgets that are in the database based of the inputed filters.
	 * 
	 * it will first validate the input, no input is accepted. if there is an issue will display the issue
	 * in an alert dialog box. if there is no issue, it will display in the budget list page a list of 
	 * all the menu that passed all the filters. the inputs are from the budget filter page.
	 * @author Student
	 *
	 */
	private class EHBudgetFilterBtnApply implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
	String masterErrorMessage = "";
	String issueFrom = "";
	String budgetLessErrorMessage = model.doublePresentIsOptionalValidation(view.getBudgetFilterNoBudgetLessThan());
	String budgetMoreErrorMessage = model.doublePresentIsOptionalValidation(view.getBudgetFilterNoBudgetMoreThan());
	String startsBeforeErrorMessage = model.dateValidationPresentIsOptional(view.getBudgetFilterStartsBeforeDateText(), view.getBudgetFilterStartsBeforeValuePresent());
	String startsAfterErrorMessage = model.dateValidationPresentIsOptional(view.getBudgetFilterStartsAfterDateText(), view.getBudgetFilterStartsAfterValuePresent());
	String endsBeforeErrorMessage = model.dateValidationPresentIsOptional(view.getBudgetFilterEndsBeforeDateText(), view.getBudgetFilterEndsBeforeValuePresent());
	String endsAfterErrorMessage = model.dateValidationPresentIsOptional(view.getBudgetFilterEndsAfterDateText(), view.getBudgetFilterEndsAfterValuePresent());
	
	if(!budgetLessErrorMessage.equals("")) {	
		masterErrorMessage = budgetLessErrorMessage;
		issueFrom = " budget has more than";
	} else if(!budgetMoreErrorMessage.equals("")) {	
		masterErrorMessage = budgetMoreErrorMessage;
		issueFrom = " budget has less than";
	} else if(!startsBeforeErrorMessage.equals("")) {	
		masterErrorMessage = startsBeforeErrorMessage;
		issueFrom = " starts before";
	}else if(!startsAfterErrorMessage.equals("")) {	
		masterErrorMessage = startsAfterErrorMessage;
		issueFrom = " starts after";
	}else if(!endsBeforeErrorMessage.equals("")) {	
		masterErrorMessage = endsBeforeErrorMessage;
		issueFrom = " ends before";
	}else if(!endsAfterErrorMessage.equals("")) {	
		masterErrorMessage = endsAfterErrorMessage;
		issueFrom = " ends after";
	}
	
	
	if(masterErrorMessage.equals("")) {
		String whereClause = "";
		
		
		
		if(!view.getBudgetFilterNoBudgetLessThan().equals("")) {
			whereClause = whereClause + "tbl_budget.amount >= \"" + view.getBudgetFilterNoBudgetLessThan() + "\" And ";
		}
		if(!view.getBudgetFilterNoBudgetMoreThan().equals("")) {
			whereClause = whereClause + "tbl_budget.amount <= \"" + view.getBudgetFilterNoBudgetMoreThan() + "\" And ";
		}
		
		if(!view.getBudgetFilterStartsBeforeDateText().equals("")) {
			whereClause = whereClause + "tbl_budget.startDate <= \"" + model.formatDate(view.getBudgetFilterStartsBeforeDateText()) + "\" And ";
		}
		if(!view.getBudgetFilterStartsAfterDateText().equals("")) {
			whereClause = whereClause + "tbl_budget.startDate >= \"" + model.formatDate(view.getBudgetFilterStartsAfterDateText()) + "\" And ";
		}
		if(!view.getBudgetFilterEndsBeforeDateText().equals("")) {
			whereClause = whereClause + "tbl_budget.endDate <= \"" + model.formatDate(view.getBudgetFilterEndsBeforeDateText()) + "\" And ";
		}
		if(!view.getBudgetFilterEndsAfterDateText().equals("")) {
			whereClause = whereClause + "tbl_budget.endDate >= \"" + model.formatDate(view.getBudgetFilterEndsAfterDateText()) + "\" And ";
		}
		//the final run, where it actually find them all
		if (!whereClause.equals("")) {
			whereClause = whereClause.substring(0, whereClause.length() - 5) + ";";
			
			
		view.BudgetListLoad(model.getBudgetsThatMatchesWhere(whereClause));	
		}else {
			view.BudgetListLoad(model.getObservableListBudgetList());
			
		}
		
		}else {
			Alert budgetErrorMessage = model.makeAlert(issueFrom, masterErrorMessage);
			budgetErrorMessage.show();
		}
		
		}
	
	}
	
	/**
	 * It displays a filtered list of the Accounts that are in the database based of the inputed filters.
	 * 
	 * it will first validate the input, no input is accepted. if there is an issue will display the issue
	 * in an alert dialog box. if there is no issue, it will display in the accounts list page a list of 
	 * all the accounts that passed all the filters. the inputs are from the menu filter page.
	 * @author Student
	 *
	 */
	private class EHAccountFilterBtnApply implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			String whereClause = "";
			if(view.getIsAdminYes()) {
				whereClause = whereClause + "tbl_account_details.isAdmin = \"" + 1 + "\" And ";
			}
			if(view.getIsAdminNo()) {
				whereClause = whereClause + "tbl_account_details.isAdmin = \"" + 0 + "\" And ";
			}
			if (!whereClause.equals("")) {
				whereClause = whereClause.substring(0, whereClause.length() - 5) + ";";
				
				
			view.accountListLoad(model.getAccountsThatMatchesWhere(whereClause));	
			}else {
				view.accountListLoad(model.getObservableListAccountList());
				
			}
			
			
		}

	}
	/**
	 * It displays a filtered list of the storage locationss that are in the database based of the inputed filters.
	 * 
	 * it will first validate the input, no input is accepted. if there is an issue will display the issue
	 * in an alert dialog box. if there is no issue, it will display in the storage location list page a list of 
	 * all the storage locations that passed all the filters. the inputs are from the storage lcoation filter page.
	 * @author Student
	 *
	 */
	private class EHStorageFilterBtnApply implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			String whereClause = "";
			
			
			//in case the didn't select anything.
			if(view.getStorgaeFilterAvailbleStatus()!=null) {
			
			if(view.getStorgaeFilterAvailbleStatus()) {
				whereClause = whereClause + "tbl_storage_location.isAvailable = \"" + 1 + "\" And ";
			}
			if(!view.getStorgaeFilterAvailbleStatus()) {
				whereClause = whereClause + "tbl_storage_location.isAvailable = \"" + 0 + "\" And ";
			}
			}
			//as the is empty use true is no selected and false if they are selected
			if(!view.StorageFilterHasATypeBeenSelected()) {
				whereClause = whereClause + "tbl_storage_location.type = \"" + view.getStorgeFilterType() + "\" And ";
			
			}
			if (!whereClause.equals("")) {
				whereClause = whereClause.substring(0, whereClause.length() - 5) + ";";
				
				view.storgaeLocationListLoad(model.getStorageWhere(whereClause));
			
			}else {
				view.storgaeLocationListLoad(model.getObservableListStringStorgaeLocationsList());
				
			}
			
			
		}

	}
/**
 * resets the stock details page
 * it clears all the text feilds gives the combo box all the storage locations 
 * the database has
 */
	public void resetStockDetailsPage() {
		view.resetStockDetailsPage(model.getObservableStorgaeLocationListNameOnly());

	}
/**
 * loads the budget list page.
 * loads the budget list page and populate it list view with all the
 * budgets the database has in string format
 */
	private void loadBudgetListPage() {
		view.BudgetListLoad(model.getObservableListBudgetList());

	}
/**
 * 
 * loads the budget list page.
 * loads the budget list page and populate it list view with all the
 * budgets the database has in string format
 * @author Student
 *
 */
	private class EHBudgetListLoad implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			loadBudgetListPage();

		}

	}
/**
 * saves / updates the inputed budget details.
 * validates all the user input.
 * if there is an issue it make an alert dialog box of the user issues
 * if there isnt an issues, it see when the page loaded 
 * was a selected budget populated, if it is null it know came from add 
 * so just inserts the info, if there is one it updates that selected budget.
 * it then loads the budget list page.
 * 
 * @author Student
 *
 */
	private class EHBudgetDetailsBtnSave implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			String masterError = "";
			String issueTitle = "";
			
			String nameErrorMessage = model.stringMustBePresetValidation(view.getBudgetDetailsInputtedName());
			String amountErrorMessage = model.doubleMustBePresetValidation(view.getBudgetDetailsInputtedAmount().toString() );
			
			String startDateErrorMessage = model.dateValidation(view.getBudgetDetailsInputtedStartDate(), view.getBudgetDetailsInputtedStartDateAsLocalDate());
			String endDateErrorMessage = model.dateValidation(view.getBudgetDetailsInputtedEndDate(), view.getBudgetDetailsInputtedEndDateAsLocalDate());
			
			
			if(!nameErrorMessage.equals("")) {
				masterError = nameErrorMessage;
				issueTitle = "issue with name";
			} else if(!amountErrorMessage.equals("")) {
				masterError = amountErrorMessage;
				issueTitle = "issue with amount";
			} else if(!startDateErrorMessage.equals("")) {
				masterError = startDateErrorMessage;
				issueTitle = "issue with start date";
			} else if(!endDateErrorMessage.equals("")) {
				masterError = endDateErrorMessage;
				issueTitle = "issue with end date";
			} else if (model.getSelectedBudget() == null && model.doesBudgetNameAlreadyExist(view.getBudgetDetailsInputtedName())) {
				masterError = "name already taken";
				issueTitle = "issue with name";
			}else if(model.getSelectedBudget() != null && model.doesBudgetNameAlreadyExistAndIsntId(view.getBudgetDetailsInputtedName())) {
				masterError = "name already taken";
				issueTitle = "issue with name";
			}
			
			
			if(masterError.equals("")) {
			
				if(model.getSelectedBudget() == null) {
			model.addBudget(view.getBudgetDetailsInputtedName(), Double.parseDouble(view.getBudgetDetailsInputtedAmount()),
					model.formatDate(view.getBudgetDetailsInputtedStartDate()), model.formatDate(view.getBudgetDetailsInputtedEndDate()));
				}else {
					
					model.updateBudget(view.getBudgetDetailsInputtedName(), Double.parseDouble(view.getBudgetDetailsInputtedAmount()),
							model.formatDate(view.getBudgetDetailsInputtedStartDate()), model.formatDate(view.getBudgetDetailsInputtedEndDate()));
					
					
				}
				
				
			loadBudgetListPage();
			
			}else {
				
				 model.makeAlert(issueTitle, masterError).show();
			
			}
		}

	}
	
	/**
	 * saves / updates the account details.
	 * validates all the user input.
	 * if there is an issue it make an alert dialog box of the user issues
	 * if there isnt an issues, it see when the page loaded 
	 * was a selected account populated, if it is null it know came from add 
	 * so just inserts the info, if there is one it updates that account details.
	 * it then loads the account list page.
	 * 
	 * the password is saved using the hash algorithm(SHA-256)
	 * 
	 * @author Student
	 *
	 */
	private class EHAccountDetailsBtnSave implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			String issueFrom = ""; 
			String masterError = "";
			String usernameError = model.stringMustBePresetValidation(view.getAccountDetailsUserName());
			String passwordError = model.stringMustBePresetValidation(view.getAccountDetailsUserPassword());
			
			if(!usernameError.equals("")) {
				issueFrom = "username";
				masterError = usernameError;
			}else if(!passwordError.equals("")) {
				issueFrom = "password";
				masterError = passwordError;
			}else if((!view.getAccountDetailsIsAdminYesSelected())&&(!view.getAccontDetailsIsAdminNoSelected())) {
				issueFrom = "is admin";
				masterError = "need to select if admin or not";
			}else if(model.doesAccountNameAlreadyExist(view.getAccountDetailsUserName())) {
				issueFrom = "username";
				masterError = "username is already taken";
			}
			
			if(masterError.equals("")) {
				Boolean adminStatus = false;
				if(view.getAccountDetailsIsAdminYesSelected()) {
					adminStatus = true;
				}
				
				if(model.getSelectedAccount() == null ) {
					
				model.createAccount(view.getAccountDetailsUserName(), model.hash(view.getAccountDetailsUserPassword()), adminStatus);
				model.addSelectedAccount();
				
				}else {
					
					
					model.updateAccount(view.getAccountDetailsUserName(), model.hash(view.getAccountDetailsUserPassword()), adminStatus);
				}
				loadAccountListPage();
			}else {
			Alert accountErrorMessage = model.makeAlert(issueFrom, masterError);
					accountErrorMessage.show();
			}
			
		
		}

	}
	/**
	 * saves / updates the storage details.
	 * validates all the user input.
	 * if there is an issue it make an alert dialog box of the user issues
	 * if there isnt an issues, it see when the page loaded 
	 * was a selected storage location populated, if it is null it know came from add 
	 * so just inserts the info, if there is one it updates that selected storage location.
	 * it then loads the storage location list page.
	 * 
	 * @author Student
	 *
	 */
	private class EHStorageDetailsBtnSave implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			String errorFrom = "";
			String masterError = "";
			
			String nameError = model.stringMustBePresetValidation(view.getStorageDetailsName());
			String typeError = model.stringMustBePresetValidation(view.getStorageDetailsType());
			
			if(!nameError.equals("")) {
				errorFrom = "name";
				masterError = nameError;
			}else if(!typeError.equals("")) {
				errorFrom = "type";
				masterError = typeError;
			}else if(view.getStorageDetailsAvailbilty() == null) {
				errorFrom = "availability";
				masterError = "need to select one of the options";
						
			} 
			if(model.getSelectedStorageLocation() == null) {
			if(model.doesStorageAlreadyExist(view.getStorageDetailsName())) {
				errorFrom = "name";
				masterError = "name already taken";
			}
			}else {
				if(model.doesStorageAlreadyExist(view.getStorageDetailsName())&&!model.getSelectedStorageName().equals(view.getStorageDetailsName())) {
					errorFrom = "name";
					masterError = "name already taken";
				}
			}
			if(masterError.equals("")) {
				if(model.getSelectedStorageLocation() == null) {
				model.createStorage(view.getStorageDetailsName(), view.getStorageDetailsType(), view.getStorageDetailsAvailbilty());
				}else {
					model.updateStorage(view.getStorageDetailsName(), view.getStorageDetailsType(), view.getStorageDetailsAvailbilty());
				}
				loadStorgaeLocationListPage();
			}else {
				Alert storageErrorMessage = model.makeAlert(errorFrom, masterError);
				storageErrorMessage.show();
			}
			
		}

	}
	
	/**
	 * 
	 * makes the list view show just the budgets that are like the find value input.
	 * check the user input
	 * if there is an issue the label is made visible and show the error
	 * if there is no issue the list view is populates with all the budgets that the
	 * database has that is like the user input. like in mysql is % user input %.
	 * 
	 * @author Student
	 *
	 */
	
	private class EHBudgetListBtnFind implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			String errorMessage = model.stringPresentIsOptionalValidation(view.getBudgetTfFind());
			
			/*
			ObservableList<String> dataToBeDisplayed = FXCollections.observableArrayList(
					model.getDatabase().getBudgetsThatsLike(view.getBudgetListPage().getTfFindValue()));

			view.getBudgetListPage().setObservableList(dataToBeDisplayed);
			*/
			if (errorMessage.equals("")) {
			view.BudgetListLoad(model.getBudgetThatsLike(view.getBudgetTfFind()));
			}else {
				view.setBudgetListErrorMessage(errorMessage);
			}
		}

	}
/**
 * loads the account list page.
 * loads the account list page and populates its list view with 
 * all the accounts the database holds in string format
 */
	private void loadAccountListPage() {
		view.accountListLoad(model.getObservableListAccountList());

	}
/**
 * 
 * loads the account list page.
 * loads the account list page and populates its list view with 
 * all the accounts the database holds in string format
 *
 * @author Student
 *
 */
	private class EHAccountListLoad implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			loadAccountListPage();

		}

	}
/**
 * loads the storage location list page.
 * loads the storage location list page and populates
 * its list view with all the storage location the database has.
 */
	private void loadStorgaeLocationListPage() {

		view.storgaeLocationListLoad(model.getObservableListStringStorgaeLocationsList());

	}
/**
 * 
 * loads the storage location list page.
 * loads the storage location list page and populates
 * its list view with all the storage location the database has.
 *
 * @author Student
 *
 */
	private class EHStorageListLoad implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			loadStorgaeLocationListPage();

		}

	}
/**
 * save stock details that is on a text file. 
 * loads a file chooser, if there is an issue with it eg wrong file type
 * it will show an error message through alert dialog box, if there is no issue it will save
 * the stock info.
 * @author Student
 *
 */
	private class EHStockDetailsBtnLoadFromFile implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			String errorMessage = "";
			File selection = new FileChooser().showOpenDialog(null);
			if (selection != null) {
				errorMessage = model.saveStockTypeFromFile(selection.toURI());
			} else {
				errorMessage = "no file seleted";
			}
			if (!errorMessage.equals("")) {
				Alert fileLoadErrorPopup = model.makeAlert("file issue", errorMessage);
				fileLoadErrorPopup.show();
			} else {
				loadStockListPage();
			}
		}

	}
	/**
	 * loads the stock details page.
	 * check the user has selected an item from the list view
	 * if no item has been selected the error label is made visible with 
	 * info about the error 
	 * if an item has been selected the stock details page is loaded and the 
	 * the pages input areas are populated with the selected stock info.
	 * @author Student
	 *
	 */
	private class EHStockListBtnEdit implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			resetStockDetailsPage();
			if (!(view.getStockListSelectedItem().equals("null"))) {

				model.selectAStock(view.getSelectedStockId());
				
				// reformatting the text so the save isn't in a diffrente format

				// populating the items
				view.setStockDetailsName(model.getSelectedStockName());
				view.setStockDetailsStorgeLocation(model.getSelectedStockStorgaeLocation());
				view.setStockDetailsQuanity(model.getSelectedStockQuanity());
				view.setStockDetailsQuanityType(model.getSelectedStockQuanityType());
				view.setStockDetailsExpiereDate(model.deFormatDate(model.getSelectedStockExpierDate()));
				view.setStockDetailsCost(model.getSelectedStockCost());

				// selectedStockId = model.getSelectedStockId();
				model.setStockFrom(false);
				view.stockDetailsLoad(false);

			} else {
				view.setStockListError("No data selected");

			}
		}

	}
	
	
	/**
	 * adds a ingredient to the dish details list view.
	 * it first validates the user input.
	 * if there is an issue it shown in an alert dialog box.
	 * if there is no issue, it first sees if the stock type exists if not it
	 * makes it and if it does exist it see if it needs to update its info.
	 * it next will then add then see if it if the dish name has been changed
	 * if it has it updates it, if it hasn't it simply add the stock info to the dish list 
	 * it then reset the fields and updates the listview.
	 * 
	 * @author Student
	 *
	 */
	private class EHDishDetailsBtnAdd implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			//used to inform the user the Quantity Type and Cost will change. 
			Alert options = new Alert(AlertType.CONFIRMATION);
			Optional<ButtonType> output = null;
			
		
			String masterError = "";
			
			String nameError = model.stringMustBePresetValidation(view.getDishDetailsDishName());
			String ingredientNameError = model.stringMustBePresetValidation(view.getDishDetailsIngrdeintName());
			String quanityError = model.doubleMustBePresetValidation(view.getDishDetailsQuanity());
			String unitError = model.stringMustBePresetValidation(view.getDishDetailsUnit());
			String costError = model.doubleMustBePresetValidation(view.getDishDetailsEstimateCost());
			 
			
			
			
			if(!nameError.equals("")) {
				
				masterError = nameError;
			} else if(!ingredientNameError.equals("")) {
				
				masterError = ingredientNameError;
			}else if(!quanityError.equals("")) {
				
				masterError = quanityError;
			}else if(!unitError.equals("")) {
				
				masterError = unitError;
			}else if(!costError.equals("")) {
				
				masterError = costError;
			} else if(model.doseDishNameAlreadyExist(view.getDishDetailsDishName())) {
				
				
				
				masterError = "name already taken";
			}
			
			
			if(masterError.equals("")) {
			
				
				//used to tell the user, hey your changing, x/y/z
				if(!(model.hasTheStockTypeCostChanged(view.getDishDetailsEstimateCost(),view.getDishDetailsIngrdeintName()).equals("")&&model.hasTheStockTypeQuanityTypeChanged(view.getDishDetailsUnit(),view.getDishDetailsIngrdeintName()).equals(""))) {
				
					options.setContentText("chaning the ");
					if(!model.hasTheStockTypeCostChanged(view.getDishDetailsEstimateCost(),view.getDishDetailsIngrdeintName()).equals("")) {
						
						options.setHeaderText("changing the cost of all the matching stock");
						options.setContentText(options.getContentText() + "cost from " + model.hasTheStockTypeCostChanged(view.getDishDetailsEstimateCost(),view.getDishDetailsIngrdeintName()));
					}
					if(!model.hasTheStockTypeQuanityTypeChanged(view.getDishDetailsUnit(),view.getDishDetailsIngrdeintName()).equals("")) {
						
						if(!options.getHeaderText().equals("changing the cost of all the matching stock")) {
							
							options.setHeaderText("quantity type");
							options.setContentText(options.getContentText() + "quanityType from " + model.hasTheStockTypeQuanityTypeChanged(view.getDishDetailsUnit(),view.getDishDetailsIngrdeintName()));
						}else {
							
							options.setHeaderText("changing the cost and quantity type of all the matching stock");
							options.setContentText(options.getContentText() + " and quantity type from " + model.hasTheStockTypeQuanityTypeChanged(view.getDishDetailsUnit(),view.getDishDetailsIngrdeintName()));
						}
						
					}
					
					output = options.showAndWait();
				}
				
				if(output == null || output.isPresent() && output.get() == ButtonType.OK) {
				
				
				
				
				
				
				
				
				
				
				
				
				
				model.setTestStockType(view.getDishDetailsIngrdeintName());

				
				//make a new stock type if required
				if (model.getTestStockName().equals("null")) {

					model.addStockType(view.getDishDetailsIngrdeintName(), view.getDishDetailsEstimateCost(),
							view.getDishDetailsUnit());

				}else if (!model.getTestStockCost().equals(view.getDishDetailsEstimateCost())) {

						model.updateStockTypeCost(view.getDishDetailsIngrdeintName(), view.getDishDetailsEstimateCost());
						
						model.updateStockTypeQuanityType(view.getDishDetailsIngrdeintName(),
								view.getDishDetailsUnit());
					} else if (!model.getTestStockQuanityType().equals(view.getDishDetailsUnit())) {
						model.updateStockTypeQuanityType(view.getDishDetailsIngrdeintName(),
								view.getDishDetailsUnit());
					}
					
				
				
				//meant if to be used if first one
				if(model.getSelectedDish() == null) {
				model.createDish(view.getDishDetailsDishName(), view.getDishDetailsIngrdeintName(), view.getDishDetailsEstimateCost(), view.getDishDetailsUnit(),view.getDishDetailsQuanity());
				
				}else {
					// if the dish already exists it does this one
					
					if(model.hasDishDetailsChangedTheDishName(view.getDishDetailsDishName())) {
						//if it has been changed it does this 
						model.setSelectedDishName(view.getDishDetailsDishName());
					}
					
					model.selectedDishIngrednitnAdd(view.getDishDetailsIngrdeintName(), view.getDishDetailsEstimateCost(), view.getDishDetailsUnit(),view.getDishDetailsQuanity());
				
				
				
				}	
				
				
				view.setDishDetailsList(model.getSelectedDishList());
				view.dishDetailsAddReset();
			}
			}else {
				view.setDishDetailsErrorMessage(masterError);
			//model.makeAlert(issueFrom, masterError).show();
				
			}
			
			
			

		}

	}
	/**
	 * loads the delete page. 
	 * it checks the user has selected an item from the list view
	 * if no item has been selected it make the error message label visible saying the issue
	 * if an item has been selected it loads the delete confirmation page
	 * with the name of the item to be deleted in it. 
	 * 
	 * 
	 * @author Student
	 *
	 */
	private class EHDishDetailsBtnDelete implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			String masterIssue = "";
			if(view.getDishDetailsSelectedIndex() == -1) {
				masterIssue = "no selection made";
			}else if(view.getDishDetailsSelectedIndex() ==0 ) {
				masterIssue = "cant delete dish name";
			}
			if(masterIssue.equals("")) {
				
				model.selectedDishIngrednitnRemove(view.getDishDetailsSelectedIndex()-1);
				view.setDishDetailsList(model.getSelectedDishList());
				view.setDishDetailsErrorMessageFalse();
			}else {
				
			view.setDishDetailsErrorMessage(masterIssue);
				//Alert dishDetailsErrorMessage = model.makeAlert("selection issue", masterIssue);
				//dishDetailsErrorMessage.show();
			}
		}

	}
	/**
	 * loads the selected stock info into the dish details input fields.
	 * checks the user has selected stock from the list view.
	 * if no stock has been selected an alert dialog box is shown with an error message.
	 * if an item has been selected, the item is removed from the listview and its info is populated
	 * in to the user input areas.
	 * @author Student
	 *
	 */
	private class EHDishDetailsBtnEdit implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			String masterIssue = "";
			if(view.getDishDetailsSelectedIndex() == -1) {
				masterIssue = "no selection made";
			}else if(view.getDishDetailsSelectedIndex() ==0 ) {
				masterIssue = "add a ingredent with new dish name to chnage the dish name";
			}
			if(masterIssue.equals("")) {
				 
				//done a head so can get the equal sign so know that all values are jus two place behind them
				String value = view.getDishDetailsSelectedItem();

				
				int equals1 = value.indexOf("=");
				int equals2 = value.indexOf("=", equals1 +1);
				int equals3 = value.indexOf("=", equals2 +1);
				int equals4 = value.indexOf("=", equals3 +1);
				
				//so know where they end
				int comma1 = value.indexOf(",");
				int comma2 = value.indexOf(",",comma1+1);
				int comma3 = value.indexOf(",",comma2+1);
				
				
				String name = value.substring(equals1 + 2,comma1);
				String quanity = value.substring(equals2 + 2,comma2);
				String quanityType = value.substring(equals3 + 2,comma3); 
				String cost  = value.substring(equals4 + 2);
				
				view.setDishDetailsUserInput(name, cost, quanityType, quanity);
				
				model.selectedDishIngrednitnRemove(view.getDishDetailsSelectedIndex()-1);
				view.setDishDetailsList(model.getSelectedDishList());
			}else {
				
			view.setDishDetailsErrorMessage(masterIssue);
				//Alert dishDetailsErrorMessage = model.makeAlert("selection issue", masterIssue);
				//dishDetailsErrorMessage.show();
			}
		}

	} 
	/**
	 * makes the list view show just the dishes that are like the find value input.
	 * check the user input
	 * if there is an issue a alert dialog box with the error message is shown.
	 * if there is no issue the list view is populates with all the dishes that the
	 * database has that is like the user input. like in mysql is % user input %.
	 * 
	 * @author Student
	 *
	 */
	private class EHMenuDetailsBtnFind implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			String errorMessage = model.stringPresentIsOptionalValidation(view.getMenuDetailsFindUserInput());
			if (errorMessage.equals("")) {
				
				//so if all need to present can do it the nomal way 
				//top one else  if will only filter items not selected. 
				if(model.getSelectedMenu() == null) {
					
				view.setMenuDetailsDishList(model.getAllDishesThatAreLike(view.getMenuDetailsFindUserInput()));
				}else {
					
					
					view.setMenuDetailsDishList(model.getNotSelectedDishesThatAreLikeMenuDetailsFind(view.getMenuDetailsFindUserInput()));
				}
			} else {
				Alert menuDetailsFindErrorMessage = model.makeAlert("issue with find", errorMessage);
				menuDetailsFindErrorMessage.show();
			}

		}
	}
	/**
	 * 
	 * makes the list view show just the menus that are like the find value input.
	 * check the user input
	 * if there is an issue the label is made visible and show the error
	 * if there is no issue the list view is populates with all the menus that the
	 * database has that is like the user input. like in mysql is % user input %.
	 * 
	 * @author Student
	 *
	 */
	private class EHMenuListBtnFind implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			String errorMessage = model.stringPresentIsOptionalValidation(view.getMenuListFindUserInput());
			
			if (errorMessage.equals("")) {
				view.menuListLoad(model.getAllMenusThatAreLike(view.getMenuListFindUserInput()));
				view.hideMenuListErrorMessage();
				
			} else {
				view.setMenuListErrorMessage(errorMessage);
				
			}

		}
	}
	/**
	 * loads the delete page. 
	 * it checks the user has selected an item from the list view
	 * if no item has been selected it make the error message label visible saying the issue
	 * if an item has been selected it loads the delete confirmation page
	 * with the name of the item to be deleted in it. 
	 * 
	 * 
	 * @author Student
	 *
	 */
	private class EHMenuListBtnDelete implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			if (!view.getMenuListSelectedMenu().equals("null")) {

				
				model.setSelectedMenu(view.getMenuListSelectedMenuId(), null);
				
				//model.selectAStock(view.getSelectedStockId());

				view.getDeleteConfirmationPage()
						.setTxtConfirmMessage("Are you sure you wan to delete " + view.getMenuListSelectedMenuId() + "?");
				model.setDeleteFrom("MenuList");
				view.deleteConfirmationLoad();
			} else {
				view.setMenuListError("No data selected");

			}

		}
	}
	/**
	 * loads the menu details page.
	 * check the user has selected an item from the list view
	 * if no item has been selected the error label is made visible with 
	 * info about the error 
	 * if an item has been selected the menu details page is loaded and the 
	 * the pages input areas are populated with the selected menu info.
	 * @author Student
	 *
	 */
	private class EHMenuListBtnEdit implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			if (!view.getMenuListSelectedMenu().equals("null")) {
				
				view.clearMenuSettingPage();
				model.setFromMenu(view.getMenuListSelectedMenuId());
				
				model.setSelectedMenuToBeAnExisitingMenu(view.getMenuListSelectedMenuId());
				
				
				model.resetMenuDetailList();
				
				view.setMenuDetailsMenuListItems(model.getSelectedMenuDishes());
				
				view.setMenuDetailsDishList(model.getNotSelectedDishesAsString());
				
				view.setMenuDetailsShoppingList(model.getSelectedMenuStockType());
				
				// +"" is simply to convert it to a string
				view.setMenuDetailsBudgetValue(model.getBudgetSizeMinusTheShoppingList()+"");
				
				view.MenuDetailsLoad();
				
			} else {
				view.setMenuListError("No data selected");

			}

		}
	}
	/**
	 * sets the menu name and budget used for the menu.
	 * check the user input.
	 * if there is an issue it show an alert dialog box with the error message.
	 * if there is no issue it loads the menu details page. 
	 * @author Student
	 *
	 */
	private class EHMenuSettingBtnSave implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			String issueFrom = "";
			String masterError = "";
			
			String nameErrorMessage = model.stringMustBePresetValidation(view.getMenuSettingName());
			
			if(!nameErrorMessage.equals("")) {
				issueFrom = "name";
				masterError = nameErrorMessage;
			} else if(view.getMenuSettingBudgetIndex() == -1) {
				issueFrom = "budget";
				masterError = "no budget selected";
			}else if(model.doesBudgetNameAlreadyExist(view.getMenuSettingName())) {
				issueFrom = "name";
				masterError = "name already taken";
						
			}
			
			
			if(masterError.equals("")) {
				view.resetMenuDetailsPage();
				view.setMenuDetailsDishList(model.getAllDishes());
				
				
				
				//needs both as makes a menu object
				model.setSelectedMenu(view.getMenuSettingName(), view.getMenuSettingSelectedBudgetOption());
				
				view.MenuDetailsLoad();
				view.setMenuDetailsBudgetValue(model.getBudgetSizeMinusTheShoppingList() +"");
			}else {
				Alert menuSettingErrorMessage = model.makeAlert(issueFrom, masterError);
						menuSettingErrorMessage.show();
			}

		}
	}
	/**
	 * adds a dish from the dish list to the menu list and potentially the shopping list.
	 * check the user has selected a budget and given the menu a name, checks that the user has
	 * selected an item from the dish list and the dish total cost doesnt go over the budget.
	 * if it fails any of the before mentioned things, it shows an alert dialog box with the error message
	 * if it passes it will add the dish to the menu list, it will then depending on if the item stock
	 * is in add the item that stock needs to be order to the shopping list. and finaly remove the dish
	 * from the dish list and decreasing the budget 
	 * 
	 *  
	 * @author Student
	 *
	 */
	private class EHMenuDetailsBtnAdd implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			String issueFrom = "";
			String masterErrorMessage = "";
			
			if(model.getSelectedMenu() == null) {
				issueFrom = "missing data";
				masterErrorMessage = "need to go to setting before can continue";
			}else if(view.getMenuDetailsDishListSelectedItemIndex() == -1) {
				issueFrom = "dish list";
				masterErrorMessage = "no item selected";
			}else if (model.doesDishGoOverBudget(view.getMenuDetailsDishListSelectedItemValueIdOnly())) {
				issueFrom = "dish list";
				masterErrorMessage = "budget is to small to buy all the needed items";
			}
			
			
			if(masterErrorMessage.equals("")) {
			//if no errors does this part
				
				model.addDishToSelectedMenu(view.getMenuDetailsDishListSelectedItemValueIdOnly());
				view.setMenuDetailsMenuListItems(model.getSelectedMenuDishes());
				model.resetMenuDetailList();
				view.setMenuDetailsDishList(model.getNotSelectedDishesAsString());
				view.setMenuDetailsShoppingList(model.getSelectedMenuStockType());
				// +"" is simply to convert it to a string
				view.setMenuDetailsBudgetValue(model.getBudgetSizeMinusTheShoppingList()+"");
				
				
				
			}else {
			
				//so they have to give it a name, the selected menu is made in the seating save
				Alert noMenuMadeError = model.makeAlert(issueFrom,masterErrorMessage);
				noMenuMadeError.show();
			}
			

		}
	}
	/**
	 * removed a dish from the menu list. 
	 * check the user has seletced a dish in the menu list.
	 * if no dish has been selected an alert dialog box is shown with the error message inside.
	 * it then removed the dish from the menu list and add it to the dish list, while also 
	 * removeing any of its ingredients from the shopping list and increaing the budget but the dish cost.
	 * @author Student
	 *
	 */
	private class EHMenuDetailsBtnRemoveFromList implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			if(view.getMenuDetailsMenuListSelectedIndex() == -1) {
				Alert removeFromListError = model.makeAlert("menu list", "no item selected to be removed");
				removeFromListError.show();
			}else {
				
				
				
				model.removeADishFromSelectedMenuDishes(view.getMenuDetailsMenuListSelectedIndex());
				model.resetMenuDetailList();
				view.setMenuDetailsMenuListItems(model.getSelectedMenuDishes());
				view.setMenuDetailsDishList(model.getNotSelectedDishesAsString());
				view.setMenuDetailsShoppingList(model.getSelectedMenuStockType());
				view.setMenuDetailsBudgetValue(model.getBudgetSizeMinusTheShoppingList()+"");
			}
			

		}
	}
	/**
	 * loads the delete page. 
	 * it checks the user has selected an item from the list view
	 * if no item has been selected it make the error message label visible saying the issue
	 * if an item has been selected it loads the delete confirmation page
	 * with the name of the item to be deleted in it. 
	 * 
	 * 
	 * @author Student
	 *
	 */
	private class EHMenuDetailsBtnDeleteDishPermentlyFromList implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			String issueFrom ="";
			String masterErrorMessage ="";
			if(view.getMenuDetailsDishListSelectedItemIndex() == -1 && view.getMenuDetailsMenuListSelectedIndex() == -1) {
				issueFrom = "the lists";
				masterErrorMessage = "no item selected";
			} else if (view.getMenuDetailsDishListSelectedItemIndex() != -1 && view.getMenuDetailsMenuListSelectedIndex() != -1) {
				issueFrom = "the list";
				masterErrorMessage = "please only select from one list at a time";
			}
			
			
			if (masterErrorMessage.equals("")) {

				
if(view.getMenuDetailsDishListSelectedItemIndex() != -1) {
				view.getDeleteConfirmationPage()
						.setTxtConfirmMessage("Are you sure you wan to delete " + view.getMenuDetailsDishListSelectedItemValueIdOnly() + "?");
}else {
	view.getDeleteConfirmationPage()
	.setTxtConfirmMessage("Are you sure you wan to delete " + view.getMenuDetailsMenuDishListSelectedItemValueIdOnly() + "?");

}
				model.setDeleteFrom("MenuDetails");
				view.deleteConfirmationLoad();
			} else {
				model.makeAlert(issueFrom, masterErrorMessage).show();

			}
			
		}
	}
	/**
	 * save the dish made in the dish details. 
	 * check that the dish has item in it. 
	 * if no items an alert dialog box is shown with the error message in it.
	 * it then add the dish to the database or update dish depending on where
	 * the user came from. 
	 * it adds the dish or the updates info the list views and the menu details page is then loaded.
	 * @author Student
	 *
	 */
	// need a way to know if update or add
	private class EHDishDetailsBtnSave implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
		
			if(view.getDishDetailsListSize() < 2) {
				view.setDishDetailsErrorMessage("not enough to be saved");
				//model.makeAlert("data to be saved", "not enough to be saved").show();
			
			}else {
				// if have data to be save it does this part.
				
					//save it to the database
					if(!model.getDishDetailsCameFromEdit()) {
				view.setMenuDetailsDishList(model.saveDishDetails());	
					}else {
						view.setMenuDetailsDishList(model.updateDishDetails());
					}
				
				//seperate as doesnt mess with the list so only need one
				view.MenuDetailsRestFindInput();
				view.MenuDetailsLoad();
				view.clearMenuDetailsListSelection();
				
			}
			

		}
	}
	/**
	 * It displays a filtered list of the dish items that are in the database based of the inputed filters.
	 * 
	 * it will first validate the input, no input is accepted. if there is an issue will display the issue
	 * in an alert dialog box. if there is no issue, it will display in the menu details page a list of 
	 * all the dish that passed all the filters. the inputs are from the dish filter page.
	 * @author Student
	 *
	 */
	private class EHDishFilterBtnApply implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
		
		String issueFrom ="";
		String masterError = "";
		
		//cmt = cost more than(the label for input)
		String cmt = model.doublePresentIsOptionalValidation(view.getDishFilterCostMoreThan());
		String clt = model.doublePresentIsOptionalValidation(view.getDishFilterCostLessThan());
		String nib = model.intPresentIsOptionalValidation(view.getDishFilterNumberOfIngredeintsLessThan());
		String nia = model.intPresentIsOptionalValidation(view.getDishFilterNumberOfIngredeintsMoreThan());
		
		//populating the master and from string so that can just be put in to an alert
		if(!cmt.equals("")) {
			issueFrom = "total cost more than";
			masterError = cmt;
					
		} else if(!clt.equals("")) {
			issueFrom = "total cost less than";
			masterError = clt;
					
		} else if(!nib.equals("")) {
			issueFrom = "number ingredeients below";
			masterError = nib;
					
		} else if(!nia.equals("")) {
			issueFrom = "number ingredeints above";
			masterError = nia;
					
		}
		
		if(masterError.equals("")) {
			
			//ass need a way to run it if they dont put anything in
			String cmtInput = "null";
			String cltInput ="null";
			String nibInput ="null";
			String niaInput ="null";
			
			if(!view.getDishFilterCostMoreThan().equals("")) {
				cmtInput = view.getDishFilterCostMoreThan();
				
			}
			if(!view.getDishFilterCostLessThan().equals("")) {
				cltInput = view.getDishFilterCostLessThan();
				
			}
			if(!view.getDishFilterNumberOfIngredeintsLessThan().equals("")) {
				nibInput = view.getDishFilterNumberOfIngredeintsLessThan();
				
			}
			if(!view.getDishFilterNumberOfIngredeintsMoreThan().equals("")) {
				niaInput = view.getDishFilterNumberOfIngredeintsMoreThan();
				
			}
			
			
			if(!niaInput.equals("null") || !nibInput.equals("null") || !cltInput.equals("null") || !cmtInput.equals("null")) {
			//actaully runs it and get results
				
			view.setMenuDetailsDishList(model.getDishFilterResults(niaInput, nibInput, cltInput, cmtInput));	
			}else {
				//just bascially removes any filters if none have been applied. 
				if(model.getSelectedMenu() == null) {
					view.setMenuDetailsDishList(model.getAllDishes());
				}else {
				view.setMenuDetailsDishList(model.getNotSelectedDishesAsString());
				}
				}
			
			
			view.MenuDetailsLoad();
			
		}else {
			model.makeAlert(issueFrom, masterError).show();
		}
		
		

		}
	}
	/**
	 * is a functional interface for outputting the menu list.
	 * it check if the menu details shopping list has items if not it show an error message,
	 * if it does it then displace a file chooser to select the folder to save in before making the file 
	 * and outputting it. its output is written English.
	 * @author Student
	 *
	 */
	private class EHOutputBtnMenuFromList implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event)  {
			String issueFrom = "";
			String masterErrorMessage = "";
			if(view.getMenuDetailsMenuListSize() == 0) {
				issueFrom = "menu dishes list";
				masterErrorMessage = "no data to output";
			}
			File chosenLocation = new FileChooser().showSaveDialog(null);
			if (chosenLocation == null) {
				masterErrorMessage = "no location selected";
			}
		
			if(masterErrorMessage.equals("")) {
			
			
				try {
					PrintWriter pw = new PrintWriter(chosenLocation);
					
					pw.write("menu name = " + model.getSelectedMenu().getName() + "\n");
					
					model.getSelectedMenuDishsAsString().forEach((String i) -> {
						
						pw.print("dish name = " + i + "\n");
						
					});
					//need else it wont write it
					 pw.flush();
					pw.close();
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
					
			} else {
				model.makeAlert(issueFrom, masterErrorMessage).show();
			}
			
		}
	}
	
	/**
	 * is a functional interface for outputting the shopping list.
	 * it check if the menu details shopping list has items if not it show an error message,
	 * if it does it then displace a file chooser to select the folder to save in before making the file 
	 * and outputting it. its output is written English.
	 * @author Student
	 *
	 */
	private class EHOutputBtnShoppingFromList implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event)  {
			String issueFrom = "shopping list";
			String masterErrorMessage = "";
			if(view.getMenuDetailsMenuListSize() == 0) {
				masterErrorMessage = "no data to output";
			}
			File chosenLocation = new FileChooser().showSaveDialog(null);
			if (chosenLocation == null) {
				masterErrorMessage = "no location selected";
			}
			if(masterErrorMessage.equals("")) {
			
				
						
				try {
					PrintWriter pw = new PrintWriter(chosenLocation);
					
					pw.write("shopping list for\n menu name = " + model.getSelectedMenu().getName() + "\n");
					
					model.getSelectedMenuStockType().forEach((String i) -> {
						
						pw.print(i + "\n");
						
					});
					//need else it wont write it
					 pw.flush();
						pw.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			} else {
				model.makeAlert(issueFrom, masterErrorMessage).show();
			}

		}
	}
	/**
	 * save the menu made in menu details.
	 * check there is a menu info to be saved,
	 * if there isnt it show an error message 
	 * if there is it checks to see if it should update the database 
	 * or make a new entry and use the corresponding menu functions.
	 * 
	 * @author Student
	 *
	 */
	private class EHOutputBtnSave implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event)  {
			
			String issueFrom = "";
			String masterErrorMessage = "";
			if(view.getMenuDetailsMenuListSize() == 0) {
				issueFrom = "menu list";
				masterErrorMessage = "no data to output";
			}
			
			if(masterErrorMessage.equals("")) {
				
				if(model.getFromMenu() == null) {
				model.saveSelectedMenu();
				}else {
					model.updateMenuFromSelectedMenu();
				}
				
				view.menuListLoad(model.getAllMenus());
			}else {
				model.makeAlert(issueFrom, masterErrorMessage).show();
			}
		
		}
	}
	/**
	 * It displays a filtered list of the menu items that are in the database based of the inputed filters.
	 * 
	 * it will first validate the input, no input is accepted. if there is an issue will display the issue
	 * in an alert dialog box. if there is no issue, it will display in the menu list page a list of 
	 * all the menu that passed all the filters. the inputs are from the menu filter page.
	 * @author Student
	 *
	 */
	private class EHMenuFilterBtnSave implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event)  {
			String issueFrom ="";
			String masterErrorMessage = "";
			
			String tcbError = model.doublePresentIsOptionalValidation(view.getMenuFilterTotalCostBelow());
			String tcaError = model.doublePresentIsOptionalValidation(view.getMenuFilterTotalCostAbove());
			String cdError = model.stringPresentIsOptionalValidation(view.getMenuFilterContainsDish());
			String dcdError = model.stringPresentIsOptionalValidation(view.getMenuFilterDoesntContainsDish());
			
			
			if(!tcbError.equals("")) {
				issueFrom = "total cost below";
				masterErrorMessage = tcbError;
			}else if(!tcaError.equals("")) {
				issueFrom = "total cost above";
				masterErrorMessage = tcaError;
			}else if(!cdError.equals("")) {
				issueFrom = "contians dish";
				masterErrorMessage = cdError;
			}else if(!dcdError.equals("")) {
				issueFrom = "doesnt contain dish";
				masterErrorMessage = dcdError;
			}
			
			if(masterErrorMessage.equals("")) {
			
				//set to null so can later check if the user has input anything in to them
				String tcbInput = null;
				String tcaInput = null;
				String cdInput = null;
				String dcdInput = null;
				
				if(!view.getMenuFilterTotalCostBelow().equals("")) {
					tcbInput = view.getMenuFilterTotalCostBelow();
					
				}
				if(!view.getMenuFilterTotalCostAbove().equals("")) {
					tcaInput = view.getMenuFilterTotalCostAbove();
					
				}
				if(!view.getMenuFilterContainsDish().equals("")) {
					cdInput = view.getMenuFilterContainsDish();
					
				}
				if(!view.getMenuFilterDoesntContainsDish().equals("")) {
					dcdInput = view.getMenuFilterDoesntContainsDish();
					
				}
				
			if(tcbInput != null ||tcaInput != null || cdInput != null || dcdInput != null) {
			//so if there is input does this one if not just simply does the other one.	
				
				view.menuListLoad(model.getMenuFilterResults(tcbInput, tcaInput, cdInput, dcdInput));
				
			}else {
				
				view.menuListLoad(model.getAllMenus());
			}
		
			}else {
				model.makeAlert(issueFrom, masterErrorMessage).show();
			}
		
		}
	}
	
}

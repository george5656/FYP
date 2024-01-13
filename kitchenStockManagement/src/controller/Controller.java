package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import model.ModelRoot;
import view.RootView;

/**
 * is the controller class of the MVC for the kitchen management system.
 * 
 * @author George
 */
public class Controller {
// field 
	private ModelRoot model;
	private RootView view;
	// private String stockId;

	/**
	 * Constructor, intictae all the other classes and assigning the event handlers.
	 * 
	 * @param model. the root of the M from MVC
	 * @param view.  the root of the v from MVC
	 */
	public Controller(ModelRoot model, RootView view) {

		// shadowing
		this.model = model;
		this.view = view;

		view.setLoginBtnExit(new EHExit());
		view.setLoginBtnLogin(new EHLogin());

		// just tying out a lamabda to see if they still work as expected.
		/*
		 * view.getHomePage().setBtnStockEventHandler(event -> {
		 * view.getChildren().remove(0);
		 * view.getChildren().add(view.getStockListPage());
		 * view.setVgrow(view.getStockListPage(),Priority.ALWAYS);} );
		 */
		view.setHomeBtnStockEventHandler(new EHStockListLaod());
		view.setHomeBtnMenuEventHandler(new EHHomePageMenuLoad());
		view.setHomeBtnAccountEventHandler(new EHHomeBtnAccount());
		view.setHomeBtnBudgetEventHandler(new EHHomeBtnBudget());
		view.setHomeBtnStorageEventHandler(new EHHomeBtnStorage());

		view.setStockListBtnDeleteEventHandler(new EHStockListBtnDelete());
		view.setStockListBtnAddEventHandler(new EHStockBtnAdd());
		view.setStockListBtnFilterEventHandler(new EHStockBtnFilter());
		//view.getStockListPage().setObservableList(setStockListContent());
		view.setStockListBtnFindEventHandler(new EHStockListBtnFind());
		view.setStockListBtnEditEventHandler(new EHStockListBtnEdit());

		view.setStockDetailsBtnSaveEventHandler(new EHStockDetailsBtnSave());
		view.setStockDetailsBtnCancelEventHandler(new EHStockListLaod());
		view.setStockDetailsBtnLoadFromFileEventHandler(new EHStockDetailsBtnLoadFromFile());

		view.setStockFilterBtnApply(new EHStockFilterBtnApply());

		view.setMenuListBtnFilterEventHandler(new EHMenuBtnFilter());
		view.setMenuListBtnAddEventHandler(new EHMenuListBtnAdd());
		view.setMenuListBtnFindEventHandler(new EHMenuListBtnFind());
		
		view.setMenuDetailsBtnSettingEventHandler(new EHMenuDetailsBtnSetting());
		view.setMenuDetailsBtnOutputEventHandler(new EHMenuDetailsBtnOutput());
		view.setMenuDetailsBtnFilterEventHandler(new EHDishesBtnFilter());
		view.setMenuDetailsBtnAddEventHandler(new EHMenuDetailsBtnAdd());
		view.setMenuDetailsBtnFindEventHandler(new EHMenuDetailsBtnFind());
		view.setMenuDetailsBtnNewDishEventHandler(new EHMenuDetailsBtnAddNewDish());
		view.setMenuDetailsBtnRemoveFromListEventHandler(new EHMenuDetailsBtnRemoveFromList());
		view.setMenuDetailsBtnDeleteDishPermentlyFromListEventHandler(new EHMenuDetailsBtnDeleteDishPermentlyFromList());
		
		view.setMenuSettingBtnSaveEventHandler(new EHMenuSettingBtnSave());
		
		view.setBudgetListBtnAddEventHandler(new EHBudgetBtnAdd());
		view.setBudgetListBtnFilterEventHandler(new EHBudgetBtnFilter());
		view.setBudgetListBtnFindEventHandler(new EHBudgetListBtnFind());
		view.setBudgetListBtnDeleteEventHandler(new EHBudgteListBtnDelete());
		view.setBudgetListBtnEditEventHandler(new EHBudgetBtnEdit());
		
		view.setBudgetDetailsBtnSaveEventHandler(new EHBudgetDetailsBtnSave());

		view.setBudgetFilterBtnSaveEventHandler(new EHBudgetFilterBtnApply());
		
		view.setStorgaeLocationListBtnAddEventHandler(new EHStorageBtnAdd());
		view.setStorgaeLocationListBtnFilterEventHandler(new EHStorageBtnFilter());
		view.setStorgaeLocationListBtnFindEventHandler(new EHStorageListBtnFind());
		view.setStorgaeLocationListBtnDeleteEventHandler(new EHStorageListBtnDelete());
		view.setStorgaeLocationListBtnEditEventHandler(new EHStorageListBtnEdit());
		
		view.setStorageFilterBtnApplyEventHandler(new EHStorageFilterBtnApply());
		
		view.setStorageDetailsBtnSaveEventHandler(new EHStorageDetailsBtnSave());
		
		view.setAccountListBtnAddEventHandler(new EHAccountBtnAdd());
		view.setAccountListBtnFilterEventHandler(new EHAccountBtnFilter());
		view.setAccountListBtnFindEventHandler(new EHAccountBtnFind());
		view.setAccountListBtnDeleteEventHandler(new EHAccountListBtnDelete());
		view.setAccountListBtnEditEventHandler(new EHAccountListBtnEdit());
		
		
		view.setAccountDetailsBtnSaveEventHandler(new EHAccountDetailsBtnSave());
		
		view.setAccountFilterBtnApplyEventHandler(new EHAccountFilterBtnApply());
		
		
		view.setDeleteConfirmationBtnConfirmEventHandler(new EHStockDeleteBtnConfirm());
		view.setDeleteConfirmationBtnCancelEventHandler(new EHStockListLaod());

		view.setAllPaneMenu(new EHHomeLoad(), new EHLogout());
	
	
		view.setDishDetailsBtnAddEventHandler(new EHDishDetailsBtnAdd());
		view.setDishDetailsBtnDeleteEventHandler(new EHDishDetailsBtnDelete());
		view.setDishDetailsBtnEditEventHandler(new EHDishDetailsBtnEdit());
		view.setDishDetailsBtnSaveEventHandler(new EHDishDetailsBtnSave());
		
		view.setOutputBtnMenuEventHandler(new EHOutputBtnMenuFromList());
	
	
	
	
	
	
	
	
	}

	/**
	 * this is simply a functional interface, to pass function in to the tbnExit
	 * event handler in the login class
	 * 
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
	 * is an issue is present it shows an error message, if pass validation it check
	 * the database to see if it matches and it if does it loads the next page, if
	 * doesn't it again shows an error message. error message done by alert
	 * 
	 * dialog box.
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
						view.getLoginUserPasswordInput())) {
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

	private class EHHomePageMenuLoad implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			view.menuListLoad(model.getAllMenus());
		
		}

	}

	private class EHMenuListBtnAdd implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			model.resetMenuDetailList();
	view.setMenuDetailsDishList(model.getAllDishes());
			model.resetSelectedMenu();
			
			view.MenuDetailsLoad();
		}

	}

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
	private class EHAccountListBtnDelete implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			if (!view.getAccountListSelectedItem().equals("null")) {

				model.selectAAccount(view.getSelectedAccountName());
				
				if((model.getSelectedAccountAdminStatus().equals(false) || model.getSelectedAccountUsername().equals(model.getLogedInAccountId()))) {

				view.getDeleteConfirmationPage()
						.setTxtConfirmMessage("Are you sure you wan to delete " + model.getSelectedAccountUsername() + "?");
				model.setDeleteFrom("Account");
				view.deleteConfirmationLoad();
				}else {
					view.setAccountListError("must be that admin to delete that account");
				}
				} else {
				view.setAccountListError("No data selected");

			}
		}

	}
	
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
	
	private class EHMenuDetailsBtnAddNewDish implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.dishDetailsLoad();

		}

	}

	private class EHStockBtnAdd implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			model.createStock(-1, "null", -1.00, "null", "null", "null", -1.00);
			resetStockDetailsPage();
			view.stockDetailsLoad(true);
			model.setStockFrom(true);
		}

	}

	private class EHBudgetBtnAdd implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.clearBudgetDetailsPage();
			model.resetABudget();
			view.budgetDetailsLoad();

		}

	}
	
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

	private class EHStorageBtnAdd implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			model.resetSelectedStorage();
			view.resetStorageLocationDetails();
			view.StorgaeLocationDetailsLoad();

		}

	}

	private class EHAccountBtnAdd implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.resetAccountDetailPage();
			model.resetSelectedAccount();
			view.accountDetailsLoad();

		}

	}

	private class EHStorageBtnFilter implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.StorgaeLocationFilterLoad(model.getAllStorgaeType());

		}

	}

	private class EHStockBtnFilter implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			view.stockFilterLoad(model.getObservableStorgaeLocationListNameOnlyArrayList(), model.getStockTypeListAsString());

		}

	}

	private class EHBudgetBtnFilter implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.budgetfilterLoad();
		}

	}

	private class EHDishesBtnFilter implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.dishFilterLoad();

		}

	}

	private class EHAccountBtnFilter implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			view.accountFilterLoad();

		}

	}

	private class EHMenuBtnFilter implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.menuFilterLoad();

		}

	}

	private class EHMenuDetailsBtnSetting implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			view.setMenuSettingBudgetOptions(model.getAllBudgetsButJustTheId());
			
			view.menuSettingsLoad();

		}

	}

	private class EHHomeLoad implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.homePageMenuLoad(model.getLoggedInAccountAdminStatus());

		}

	}

	private class EHLogout implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			view.loginLoad();
		}

	}

	private class EHMenuDetailsBtnOutput implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.outputPageLoad();

		}
	}

	/*
	 * private ObservableList<String> setStockListContent() {
	 * 
	 * ObservableList<String> dataToBeDisplayed =
	 * FXCollections.observableArrayList(model.getDatabase().getCurrentStock());
	 * 
	 * return dataToBeDisplayed; }
	 */
	private class EHStockDetailsBtnSave implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// StockDetails userInput = view.getStockDetails();
			// a way to know if need to create it or not
			String masterErrorMessage = "";
			String issuesWith = "";
		

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
				
				}else {
					// if it fails the first if, eg validation of the inputs fails
					Alert errorPopup = model.makeAlert("issue with " + issuesWith, masterErrorMessage);
					errorPopup.show();
			}
		}
	}
	
	private class EHStockListLaod implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			view.stockListLoad(model.getObservableListStringStockList());

		}
	}

	private void loadStockListPage() {

		view.stockListLoad(model.getObservableListStringStockList());

	}

	private class EHStockDeleteBtnConfirm implements EventHandler<ActionEvent> {

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
	
	//need to also remove from the temporary hold
	model.deleteADish(view.getMenuDetailsDishListSelectedItemValueIdOnly());
	
	view.MenuDetailsLoad();
	
	
}

		}
	}

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
			String expiresAfterErrorMessage = model.dateValidation(view.getStockFilterDpAfterDateText(),
					view.getStockFilterDpAfterDateValuePresent());
			String expiresBeforeErrorMessage = model.dateValidation(view.getStockFilterDpBeforeDateText(),
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

				System.out.println(view.getStockFilter().getTfMinQunaity().getText());
				if (view.getStockFilterDpAfterDateValuePresent() != null) {

					whereClause = whereClause + "tbl_stock_iteration.expiereDate > \""
							+ model.formatDate(view.getStockFilterDpAfterDateText()) + "\" And ";

				}

				if (view.getStockFilterDpBeforeDateValuePresent()!=null) {

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
			whereClause = whereClause + "tbl_budget.startDate <= \"" + view.getBudgetFilterStartsBeforeDateText() + "\" And ";
		}
		if(!view.getBudgetFilterStartsAfterDateText().equals("")) {
			whereClause = whereClause + "tbl_budget.startDate >= \"" + view.getBudgetFilterStartsAfterDateText() + "\" And ";
		}
		if(!view.getBudgetFilterEndsBeforeDateText().equals("")) {
			whereClause = whereClause + "tbl_budget.endDate <= \"" + view.getBudgetFilterEndsBeforeDateText() + "\" And ";
		}
		if(!view.getBudgetFilterEndsAfterDateText().equals("")) {
			whereClause = whereClause + "tbl_budget.endDate >= \"" + view.getBudgetFilterEndsAfterDateText() + "\" And ";
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

	public void resetStockDetailsPage() {
		view.resetStockDetailsPage(model.getObservableStorgaeLocationListNameOnly());

	}

	private void loadBudgetListPage() {
		view.BudgetListLoad(model.getObservableListBudgetList());

	}

	private class EHHomeBtnBudget implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			loadBudgetListPage();

		}

	}

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
			} 
			// need to check if it is the selected budget name so it doesn't error out if from edit
			if (model.doesBudgetNameAlreadyExist(view.getBudgetDetailsInputtedName())&& model.getSelectedBudget() == null) {
				masterError = "name already taken";
				issueTitle = "issue with name";
			}else if(model.doesBudgetNameAlreadyExistAndIsntId(view.getBudgetDetailsInputtedName())&&model.getSelectedBudget() != null) {
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
				Alert budgetError = model.makeAlert(issueTitle, masterError);
				budgetError.show();
			}
		}

	}
	
	
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
				
				model.createAccount(view.getAccountDetailsUserName(), view.getAccountDetailsUserPassword(), adminStatus);
				model.addSelectedAccount();
				}else {
					
					model.updateAccount(view.getAccountDetailsUserName(), view.getAccountDetailsUserPassword(), adminStatus);
				}
				loadAccountListPage();
			}else {
			Alert accountErrorMessage = model.makeAlert(issueFrom, masterError);
					accountErrorMessage.show();
			}
			
		
		}

	}
	
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

	private void loadAccountListPage() {
		view.accountListLoad(model.getObservableListAccountList());

	}

	private class EHHomeBtnAccount implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			loadAccountListPage();

		}

	}

	private void loadStorgaeLocationListPage() {

		view.storgaeLocationListLoad(model.getObservableListStringStorgaeLocationsList());

	}

	private class EHHomeBtnStorage implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			loadStorgaeLocationListPage();

		}

	}

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
			}
		}

	}
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
	
	
	
	
	private class EHDishDetailsBtnAdd implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
		
			
			String issueFrom = "";
			String masterError = "";
			
			String nameError = model.stringMustBePresetValidation(view.getDishDetailsDishName());
			String ingredientNameError = model.stringMustBePresetValidation(view.getDishDetailsIngrdeintName());
			String quanityError = model.doubleMustBePresetValidation(view.getDishDetailsQuanity());
			String unitError = model.stringMustBePresetValidation(view.getDishDetailsUnit());
			String costError = model.doubleMustBePresetValidation(view.getDishDetailsEstimateCost());
			 
			
			
			
			if(!nameError.equals("")) {
				issueFrom = "dish name";
				masterError = nameError;
			} else if(!ingredientNameError.equals("")) {
				issueFrom = "ingredeint name";
				masterError = ingredientNameError;
			}else if(!quanityError.equals("")) {
				issueFrom = "quanity";
				masterError = quanityError;
			}else if(!unitError.equals("")) {
				issueFrom = "unit";
				masterError = unitError;
			}else if(!costError.equals("")) {
				issueFrom = "cost";
				masterError = costError;
			} else if(model.doseDishNameAlreadyExist(view.getDishDetailsDishName())) {
				
				
				issueFrom = "dish name";
				masterError = "name already taken";
			}
			
			
			if(masterError.equals("")) {
			
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
			}else {
				Alert dishDetailsErrorMessage = model.makeAlert(issueFrom, masterError);
				dishDetailsErrorMessage.show();
			}
			
			
			

		}

	}
	
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
			}else {
				
			
				Alert dishDetailsErrorMessage = model.makeAlert("selection issue", masterIssue);
				dishDetailsErrorMessage.show();
			}
		}

	}
	
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
				
				view.setDishDetailsUserInput(name, quanity, quanityType, cost);
				
				model.selectedDishIngrednitnRemove(view.getDishDetailsSelectedIndex()-1);
				view.setDishDetailsList(model.getSelectedDishList());
			}else {
				
			
				Alert dishDetailsErrorMessage = model.makeAlert("selection issue", masterIssue);
				dishDetailsErrorMessage.show();
			}
		}

	}
	
	// menu / dish
	private class EHMenuDetailsBtnFind implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			String errorMessage = model.stringPresentIsOptionalValidation(view.getMenuDetailsFindUserInput());
			if (errorMessage.equals("")) {
				view.setMenuDetailsDishList(model.getAllDishesThatAreLike(view.getMenuDetailsFindUserInput()));
				
			} else {
				Alert menuDetailsFindErrorMessage = model.makeAlert("issue with find", errorMessage);
				menuDetailsFindErrorMessage.show();
			}

		}
	}
	 // menu
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
				model.setSelectedMenu(view.getMenuSettingName(), view.getMenuSettingSelectedBudgetOption());
				view.MenuDetailsLoad();
			}else {
				Alert menuSettingErrorMessage = model.makeAlert(issueFrom, masterError);
						menuSettingErrorMessage.show();
			}

		}
	}
	
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
			}
			
			
			if(masterErrorMessage.equals("")) {
			//if no errors does this part
				
				
				model.addDishToSelectedMenu(view.getMenuDetailsDishListSelectedItemValueIdOnly());
				
				
				view.setMenuDetailsMenuListItems(model.getSelectedMenuDishes());
				
				model.resetMenuDetailList();
				view.setMenuDetailsDishList(model.getNotSelectedDishesAsString());
				
				
			}else {
			
				//so they have to give it a name, the selected menu is made in the seating save
				Alert noMenuMadeError = model.makeAlert(issueFrom,masterErrorMessage);
				noMenuMadeError.show();
			}
			

		}
	}
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
			}
			

		}
	}
	private class EHMenuDetailsBtnDeleteDishPermentlyFromList implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			String issueFrom ="";
			String masterErrorMessage ="";
			if(view.getMenuDetailsDishListSelectedItemIndex() == -1) {
				issueFrom = "dish list";
				masterErrorMessage = "no item selected";
			}
			
			
			
			
			
			
			
			
			
			if (masterErrorMessage.equals("")) {

				

				view.getDeleteConfirmationPage()
						.setTxtConfirmMessage("Are you sure you wan to delete " + view.getMenuDetailsDishListSelectedItemValueIdOnly() + "?");
				model.setDeleteFrom("MenuDetails");
				view.deleteConfirmationLoad();
			} else {
				model.makeAlert(issueFrom, masterErrorMessage).show();

			}
			
			
			
			
			
			
		}
	}
	// need a way to know if update or add
	private class EHDishDetailsBtnSave implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
		
			if(view.getDishDetailsListSize() < 2) {
				model.makeAlert("data to be saved", "not enough to be saved").show();
			}else {
				// if have data to be save it does this part.
				
				
				
				
				
				model.saveDishDetails();
				view.MenuDetailsLoad();
				
				
			}
			

		}
	}
	
	
	private class EHOutputBtnMenuFromList implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event)  {
			String issueFrom = "";
			String masterErrorMessage = "";
			if(view.getMenuDetailsMenuListSize() == 0) {
				issueFrom = "menu list";
				masterErrorMessage = "no data to output";
			}
		
			if(masterErrorMessage.equals("")) {
			
				File chosenLocation = new FileChooser().showSaveDialog(null);
				try {
					PrintWriter pw = new PrintWriter(chosenLocation);
					
					pw.write("menu name = " + model.getSelectedMenu().getName() + "\n");
					
					model.getSelectedMenuDishsAsString().forEach((String i) -> {
						
						pw.print("dish name = " + i + "\n");
						
					});
					//need else it wont write it
					 pw.flush();
					
				
					
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} 
			
			
			
			
			
		}
	}
	
	
	
	
	
	
}

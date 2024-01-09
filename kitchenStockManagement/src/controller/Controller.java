package controller;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
		// view.getStockListPage().setObservableList(setStockListContent());
		view.setStockListBtnFindEventHandler(new EHStockListBtnFind());
		view.setStockListBtnEditEventHandler(new EHStockListBtnEdit());

		view.setStockDetailsBtnSaveEventHandler(new EHStockDetailsBtnSave());
		view.setStockDetailsBtnCancelEventHandler(new EHStockListLaod());
		view.setStockDetailsBtnLoadFromFileEventHandler(new EHStockDetailsBtnLoadFromFile());

		view.setStockFilterBtnApply(new EHStockFilterBtnApply());

		view.setMenuListBtnFilterEventHandler(new EHMenuBtnFilter());
		view.setMenuListBtnAddEventHandler(new EHMenuListBtnAdd());

		view.setMenuDetailsBtnSettingEventHandler(new EHMenuDetailsBtnSetting());
		view.setMenuDetailsBtnOutputEventHandler(new EHMenuDetailsBtnOutput());
		view.setMenuDetailsBtnFilterEventHandler(new EHDishesBtnFilter());
		view.setMenuDetailsBtnAddEventHandler(new EHMenudetailsBtnAdd());

		view.setBudgetListBtnAddEventHandler(new EHBudgetBtnAdd());
		view.setBudgetListBtnFilterEventHandler(new EHBudgetBtnFilter());
		view.setBudgetListBtnFindEventHandler(new EHBudgetListBtnFind());

		view.setBudgetDetailsBtnSaveEventHandler(new EHBudgetDetailsBtnSave());

		view.setStorgaeLocationListBtnAddEventHandler(new EHStorageBtnAdd());
		view.setStorgaeLocationListBtnFilterEventHandler(new EHStorageBtnFilter());

		view.setAccountListBtnAddEventHandler(new EHAccountBtnAdd());
		view.setAccountListBtnFilterEventHandler(new EHAccountBtnFilter());

		view.setDeleteConfirmationBtnConfirmEventHandler(new EHStockDeleteBtnConfirm());
		view.setDeleteConfirmationBtnCancelEventHandler(new EHStockListLaod());

		view.setAllPaneMenu(new EHHomeLoad(), new EHLogout());
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
					view.homePageMenuLoad();
				}
			}

		}
	}

	private class EHHomePageMenuLoad implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.menuListLoad();
		}

	}

	private class EHMenuListBtnAdd implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
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

				view.deleteConfirmationLoad();
			} else {
				view.setStockListError("No data selected");

			}
		}

	}

	private class EHMenudetailsBtnAdd implements EventHandler<ActionEvent> {

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
			view.budgetDetailsLoad();

		}

	}

	private class EHStorageBtnAdd implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.StorgaeLocationDetailsLoad();

		}

	}

	private class EHAccountBtnAdd implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.accountDetailsLoad();

		}

	}

	private class EHStorageBtnFilter implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.getStockStorageLocationFilter();

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
			view.menuSettingsLoad();

		}

	}

	private class EHHomeLoad implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			view.homePageMenuLoad();

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

			model.selectAStock(view.getSelectedStockId());
			model.deleteStockType();
			view.stockListLoad(model.getObservableListStringStockList());

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

			model.addBudget(view.getBudgetDetailsInputtedName(), view.getBudgetDetailsInputtedAmount(),
					view.getBudgetDetailsInputtedStartDate(), view.getBudgetDetailsInputtedEndDate());
			loadBudgetListPage();

		}

	}

	private class EHBudgetListBtnFind implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			ObservableList<String> dataToBeDisplayed = FXCollections.observableArrayList(
					model.getDatabase().getBudgetsThatsLike(view.getBudgetListPage().getTfFindValue()));

			view.getBudgetListPage().setObservableList(dataToBeDisplayed);
			view.BudgetListLoad(model.getBudgetThatsLike(view.getBudgetTfFind()));

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

}

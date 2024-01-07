package model;

public class Budget {
	private String budgetId;
	private String startDate;
	private String endDate;
	private Double amount;
	
	public Budget(String budgetId, Double amount, String startDate, String endDate) {
		this.budgetId = budgetId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
	}
	/**
	 * not standard format, in format for the listview
	 */
	@Override
	public String toString() {
		return "budget id = " + budgetId + ", amount = " + amount.toString() + ", start date = " + startDate + ", end date = "+ endDate;
	}
	
	public String getBudgetId() {
		return budgetId;
	}
	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public Double getAmount() {
		return amount;
	}
	
}

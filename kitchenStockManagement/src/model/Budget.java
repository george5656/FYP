package model;
/**
 * 
 * budget object is used to represent an budget using the stock managemnet system
 * @author Student
 *
 */
public class Budget {
	private String budgetId;
	private String startDate;
	private String endDate;
	private Double amount;
	/**
	 * default constructor
	 * @param budgetId = String
	 * @param amount = double
	 * @param startDate = String
	 * @param endDate = String
	 */
	public Budget(String budgetId, Double amount, String startDate, String endDate) {
		this.budgetId = budgetId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
	}
	
	/**
	 * not standard format, in format for the listview
	 * @return String
	 */
	@Override
	public String toString() {
		return "budget id = " + budgetId + ", amount = " + amount.toString() + ", start date = " + startDate + ", end date = "+ endDate;
	}
	/**
	 * gets the value in the budgetId variable
	 * @return String
	 */
	public String getBudgetId() {
		return budgetId;
	}
	/**
	 * gets the value in the startDate variable
	 * @return String
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * gets the value in the endDate variable
	 * @return String
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * gets the value in the amount variable
	 * @return Double
	 */
	public Double getAmount() {
		return amount;
	}
	
}

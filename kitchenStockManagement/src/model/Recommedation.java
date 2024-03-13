package model;

public class Recommedation {
	private int id;

	private String recommendation;

	/**
	 * constructor
	 * 
	 * @param id           = Int
	 * @param recomedation = string
	 */
	public Recommedation(int id, String recomedation) {
		this.id = id;
		this.recommendation = recomedation;
	}

	/**
	 * get the value held in id
	 * 
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * gets the value held in recommedation.
	 * 
	 * @return String
	 */
	public String getRecommedation() {
		return recommendation;
	}

}

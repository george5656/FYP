package model;

public class Recommedation {
private int id;
private String recommendation;
	public Recommedation(int id, String recomedation ){
		this.id = id;
		this.recommendation = recomedation;  
	}
	
	
	
	public int getId(){
		return id;
	}
	public String getRecommedation() {
		return recommendation;
	}
	
	
 

}

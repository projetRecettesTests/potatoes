package recetteTests.projet.potatoes;

import java.util.Map;
import java.util.TreeMap;

public class Potato {

	private Map<Integer,String> stateList = new TreeMap<>();
	private int state;
	
	public Potato() {
		this.stateList.put(1, "Healthy");
		this.stateList.put(2, "Contaminated");
		this.stateList.put(3, "Contagious");
		this.stateList.put(4, "Dead");
		this.state = 1;
	}


	public void changeState(){
		if (this.getState() < 4){
			this.setState(this.getState() + 1);
		}
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public boolean isHealthy() {
		return this.getState() == 1;
	}
	
	public boolean isContaminated() {
		return this.getState() == 2;
	}
	
	public boolean isContagious() {
		return this.getState() == 3;
	}
	
	public boolean isDead() {
		return this.getState() == 4;
	}

	@Override
	public String toString() {
		return stateList.get(state);
	}
	
	

}

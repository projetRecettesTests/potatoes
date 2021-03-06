package recetteTests.projet.potatoes;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Potato {
	
	public final static int DEFAULT_SEED = 0;

	private int state;
	private int contaminationPower;
	private static long seed = DEFAULT_SEED;
	
	private Map<Integer,String> stateList = new TreeMap<>();	
	
	private Random randomizer = new Random();
	
	public Potato() {
		this.stateList.put(1, "Healthy");
		this.stateList.put(2, "Contaminated");
		this.stateList.put(3, "Contagious");
		this.stateList.put(4, "Dead");
		this.state = 1;
		
		if(seed != DEFAULT_SEED) {
			randomizer.setSeed(seed);
		}
		
		this.contaminationPower = randomizer.nextInt(3) + 1;
	}


	public void changeState(){
		if (!this.isDead()){
			if(this.isContagious() && this.contaminationPower > 0){
				this.contaminationPower -- ;
			} else {
				this.setState(this.getState() + 1);
			}
		}
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public static void setSeed(long s) {
		seed = s;
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

	public int getContaminationPower(){
		return this.contaminationPower;
	}

	@Override
	public String toString() {
		return stateList.get(state);
	}
}

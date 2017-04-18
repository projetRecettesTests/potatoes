package potatoes;

public class ContaminatedState implements IPotatoeState {

	@Override
	public void changeState(PotatoeContext context) {
		System.out.println("Potatoe is in contaminated state");
		context.setState(this);
	}

	public String toString() {
		return "Contaminated State";
	}

}

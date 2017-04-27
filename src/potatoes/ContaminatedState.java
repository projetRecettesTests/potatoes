package potatoes;

public class ContaminatedState implements IPotatoState {

	@Override
	public void changeState(PotatoContext context) {
		System.out.println("Potato is in contaminated state");
		context.setState(this);
	}

	public String toString() {
		return "Contaminated State";
	}

}

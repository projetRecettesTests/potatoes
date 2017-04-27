package potatoes;

public class HealthyState implements IPotatoState {

	@Override
	public void changeState(PotatoContext context) {
		System.out.println("Potato is in healthy state");
		context.setState(this);
	}

	public String toString() {
		return "Healthy State";
	}

}

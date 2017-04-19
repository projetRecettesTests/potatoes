package potatoes;

public class HealthyState implements IPotatoeState {

	@Override
	public void changeState(PotatoeContext context) {
		System.out.println("Potatoe is in healthy state");
		context.setState(this);
	}

	public String toString() {
		return "Healthy State";
	}

}

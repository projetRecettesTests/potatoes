package potatoes;

public class PotatoeContext {

	public IPotatoeState state;

	public PotatoeContext() {
		this.state = null;
	}

	public IPotatoeState getState() {
		return state;
	}

	public void setState(IPotatoeState state) {
		this.state = state;
	}



}

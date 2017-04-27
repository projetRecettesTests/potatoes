package potatoes;

public class PotatoContext {

	public IPotatoState state;

	public PotatoContext() {
		this.state = null;
	}

	public IPotatoState getState() {
		return state;
	}

	public void setState(IPotatoState state) {
		this.state = state;
	}



}

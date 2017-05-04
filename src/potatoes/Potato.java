package potatoes;

public class Potato {

	private PotatoContext context;

	public Potato() {
		this.context = new PotatoContext();
	}

	public PotatoContext getContext() {
		return context;
	}

	@Override
	public String toString() {
		return "Patate placée";
	}

}

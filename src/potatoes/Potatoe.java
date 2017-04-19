package potatoes;

public class Potatoe {

	private PotatoeContext context;

	public Potatoe() {
		this.context = new PotatoeContext();
	}

	public PotatoeContext getContext() {
		return context;
	}

	@Override
	public String toString() {
		return "Patate placée";
	}

}

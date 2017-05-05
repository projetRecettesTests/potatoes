package recetteTests.projet.potatoes;

public class ContagiousState implements IPotatoState {

	@Override
	public void changeState(PotatoContext context) {
		System.out.println("Potato is in contagious state");
		context.setState(this);
	}

	public String toString() {
		return "Contagious State";
	}

}

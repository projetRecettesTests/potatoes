package recetteTests.projet.potatoes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PlotShould {

	private final static int MOUSE_X = 84;
	private final static int MOUSE_Y = 82;
	private final static int FIELD_SEED = 5;
	
	private Game game;
	private Field field;
	private Plot plot;


	@Before
	public void setUp() throws Exception {
		Field.setSeed(FIELD_SEED);
		this.game = new Game();
		this.field = new Field(game);
		this.plot = this.field.getSelectedPlot(MOUSE_X, MOUSE_Y);
	}

	@Test
	public void haveNeighbors() {
		assertEquals(false, plot.getNeighbors().isEmpty());
	}

	@Test
	public void allowToDigWhenNotDigged() {
		assertEquals(true, plot.dig());
	}

	@Test
	public void notAllowToDigWhenAlreadyDigged() {
		this.plot.dig();
		assertEquals(false, plot.dig());
	}
}

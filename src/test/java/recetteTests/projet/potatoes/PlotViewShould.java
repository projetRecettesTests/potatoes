package recetteTests.projet.potatoes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PlotViewShould {

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
	public void beGreenWhenNotDigged() {
		assertEquals(game.color(0, 153, 38), this.plot.getColor());
	}

	@Test
	public void changeColorWhenDiggedOnHealthyPotato() {
		this.plot.dig();
		assertEquals(game.color(79, 36, 5), this.plot.getColor());
	}

	@Test
	public void changeColorWhenDiggedOnContaminatedPotato() {
		this.plot.getPotato().setState(2);
		this.plot.dig();
		assertEquals(game.color(249, 94, 4), this.plot.getColor());
	}

	@Test
	public void changeColorWhenDiggedOnContagiousPotato() {
		this.plot.getPotato().setState(3);
		this.plot.dig();
		assertEquals(game.color(237, 14, 2), this.plot.getColor());
	}
}

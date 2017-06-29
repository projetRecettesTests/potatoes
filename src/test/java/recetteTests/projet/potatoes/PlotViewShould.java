package recetteTests.projet.potatoes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PlotViewShould {

	Game game;
	Field field;
	Plot plot;


	int mouseX = 84;
	int mouseY = 82;

	@Before
	public void setUp() throws Exception {
		Field.setSeed(5);
		this.game = new Game();
		this.field = new Field(game);
		this.plot = this.field.getSelectedPlot(mouseX, mouseY);
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

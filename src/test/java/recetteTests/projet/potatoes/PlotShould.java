package recetteTests.projet.potatoes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PlotShould {

	Game game;
	Field field;
	Plot plot;
	Potato potato;

	int mouseX = 84;
	int mouseY = 82;

	@Before
	public void setUp() throws Exception {
		Field.setSeed(5);
		Potato.setSeed(1);
		this.game = new Game();
		this.field = new Field(game);
		this.plot = this.field.getSelectedPlot(mouseX, mouseY);
		this.potato = this.plot.getPotato();
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

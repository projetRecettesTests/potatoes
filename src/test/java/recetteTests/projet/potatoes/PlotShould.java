package recetteTests.projet.potatoes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PlotShould {

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

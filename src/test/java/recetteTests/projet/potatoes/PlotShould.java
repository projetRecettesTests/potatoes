package recetteTests.projet.potatoes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PlotShould {
	
	Game game;
	Field field;
	int mouseX = 1000;
	int mouseY = 350;

	@Before
	public void setUp() throws Exception {
		this.game = new Game();
		this.field = new Field(game);
	}
	
	@Test
	public void haveNeighbors() {
		assertEquals(false, this.field.getSelectedPlot(mouseX, mouseY).getNeighbors().isEmpty());
	}

}

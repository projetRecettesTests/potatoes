package recetteTests.projet.potatoes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FieldShould {
	
	Game game;
	Field field;
	
	@Before
	public void setup() {
		Field.setSeed(5);
		this.game = new Game(); 
		this.field = new Field(game);
	}
	
	@Test
	public void shouldHavePlots() {
		assertEquals(true, field.getPlots().length > 0);
	}

}

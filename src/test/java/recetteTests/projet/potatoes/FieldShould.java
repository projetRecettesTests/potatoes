package recetteTests.projet.potatoes;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class FieldShould {
	
	Game game;
	Field field;
	int mouseX = 84;
	int mouseY = 82;
	
	@Before
	public void setup() {
		Field.setSeed(5);
		game = new Game(); 
		field = new Field(game);
	}
	
	@Test
	public void havePlots() {
		assertEquals(true, field.getPlots().length > 0);
	}
	
	@Test
	public void haveOneContaminatedPotatoOnCreate() {
		assertEquals(true, field.unhealthyPlots.size() == 1);
	}
	
	@Test
	public void killPlayerIfDigsOnContaminatingPotato() {
		// Prepare to capture output
		PrintStream originalOut = System.out;
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		String separator = System.getProperty("line.separator");
		
		// Perform test
		field.getSelectedPlot(mouseX, mouseY).getPotato().setState(3);
		field.digPlot(mouseX, mouseY);
		assertEquals("You're DEAD motherfucker !" + separator, os.toString());
		
		System.setOut(originalOut);
		
	}

}

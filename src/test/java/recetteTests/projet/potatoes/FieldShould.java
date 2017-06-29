package recetteTests.projet.potatoes;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class FieldShould {
	
	private final static int MOUSE_X = 84;
	private final static int MOUSE_Y = 82;
	private final static int FIELD_SEED = 5;
	private final static String SEPARATOR = System.getProperty("line.separator");
	
	private Game game;
	private Field field;
	
	@Before
	public void setup() {
		Field.setSeed(FIELD_SEED);
		game = new Game(); 
		field = new Field(game);
	}
	
	@Test
	public void havePlots() {
		assertEquals(true, field.getPlots().length > 0);
	}
	
	@Test
	public void haveOneContaminatedPotatoOnCreate() {
		assertEquals(true, field.getUnhealthyPlots().size() == 1);
	}
	
	@Test
	public void killPlayerIfDigsOnContaminatingPotato() {
		// Prepare to capture output
		PrintStream originalOut = System.out;
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		// Perform test
		field.getSelectedPlot(MOUSE_X, MOUSE_Y).getPotato().setState(3);
		field.digPlot(MOUSE_X, MOUSE_Y);
		assertEquals("You're DEAD motherfucker !" + SEPARATOR, os.toString());
		
		System.setOut(originalOut);
		
	}

}

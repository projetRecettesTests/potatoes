package recetteTests.projet.potatoes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GameShould {
	
	private final static int MOUSE_X = 84;
	private final static int MOUSE_Y = 82;
	private final static int FIELD_SEED = 5;
	private final static int POTATO_SEED = 1;
	
	private Game g ;
	
	@Before
	public void setup() {
		
		Field.setSeed(FIELD_SEED);	
		Potato.setSeed(POTATO_SEED);
		g = new Game();
		g.setup();
		g.mouseButton = Game.LEFT;
	}
	
	@Test
	public void loopWhenClickOnHealthydPotato()
	{
		g.mouseX = MOUSE_X;
		g.mouseY = MOUSE_Y;
		g.mousePressed();
		assertEquals(true, g.isLooping());
	}

// TODO Réparer le tests (cassé depuis l'ajout de la boite de dialogue "T'es mort")
//	@Test
//	public void notLoopWhenClickOnContaminatedPotato()
//	{
//		g.mouseX = 84;
//		g.mouseY = 82;
//		g.mousePressed();
//		g.mouseX = 760; //24
//		g.mouseY = 580; //18
//		g.mousePressed();
//		assertEquals(false, g.isLooping());
//	}
	
	@Test
	public void digWhenClickOnNotDiggedPlot() 
	{
		g.mouseX = MOUSE_X;
		g.mouseY = MOUSE_Y;
		g.mousePressed();
		assertEquals(true, g.field.getSelectedPlot(g.mouseX, g.mouseY).isDigged());
	}	
}

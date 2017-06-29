package recetteTests.projet.potatoes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GameShould {
	
	Game g ;
	Plot fisrtContaminatedPlot;
	
	@Before
	public void setup() {
		
		Field.setSeed(5);	
		Potato.setSeed(1);
		g = new Game();
		g.setup();
		g.mouseButton = Game.LEFT;
		fisrtContaminatedPlot = g.field.unhealthyPlots.get(0); // 18 - 24
	}
	
	@Test
	public void loopWhenClickOnHealthydPotato()
	{
		g.mouseX = 84;
		g.mouseY = 82;
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
		g.mouseX = 84;
		g.mouseY = 82;
		g.mousePressed();
		assertEquals(true, g.field.getSelectedPlot(g.mouseX, g.mouseY).isDigged());
	}
	//contaminateWhenClickOnNotDigged	
}

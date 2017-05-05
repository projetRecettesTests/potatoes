package potatoes;

import static org.junit.Assert.*;

import java.awt.Robot;
import java.awt.event.InputEvent;

import org.junit.Before;
import org.junit.Test;

import processing.core.PApplet;

public class GameTest {
	Game gamejh;
	Robot rbt;
	int x = 610;
	int y = 310;

	@Before
	public void setUp() throws Exception {
		gamejh = new Game();
//		gamejh.settings();
//		gamejh.setup();
//		gamejh.draw();
		Game.main(gamejh.getClass());
		rbt = new Robot();
	}

	@Test
	public void digTest() {
		gamejh.getField().getPlots();
//		assertEquals(false, game.field.getSelectedPlot(x, y).isDigged());
//		SimClk(rbt);
//		assertEquals(true, game.field.getSelectedPlot(x, y).isDigged());
		//fail("Not yet implemented");
	}
	
	void SimClk(Robot rbt) {		 
		  rbt.mouseMove(x, y);
		  rbt.mousePress(InputEvent.BUTTON1_MASK); 
		  rbt.mouseRelease(InputEvent.BUTTON1_MASK);
		}

}

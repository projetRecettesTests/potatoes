//package recetteTests.projet.potatoes;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Before;
//import org.junit.Test;
//
//public class PlotShould {
//	
//	Game game;
//	Field field;
//	Plot plot;
//	Potato potato;
//	
//	HealthyState healthyState;
//	ContaminatedState contaminatedState;
//	ContagiousState contagiousState;
//	
//	int mouseX = 1000;
//	int mouseY = 350;
//
//	@Before
//	public void setUp() throws Exception {
//		this.game = new Game();
//		this.field = new Field(game);
//		this.plot = this.field.getSelectedPlot(mouseX, mouseY);
//		this.potato =this.plot.getPotato(); 
//		
//		healthyState = new HealthyState();
//		contaminatedState = new ContaminatedState();
//		contagiousState = new ContagiousState();
//	}
//	
//	@Test
//	public void haveNeighbors() {
//		assertEquals(false, plot.getNeighbors().isEmpty());
//	}
//	
//	@Test
//	public void changeColorWhenDiggedOnHealthyPotato() {
//		healthyState.changeState(potato.getContext());
//		this.field.digPlot(mouseX, mouseY);
//		assertEquals(game.color(79, 36, 5), this.plot.getColor());
//	}
//	
//	@Test
//	public void changeColorWhenDiggedOnContaminatedPotato() {
//		contaminatedState.changeState(potato.getContext());
//		this.field.digPlot(mouseX, mouseY);
//		assertEquals(game.color(249, 94, 4), this.plot.getColor());
//	}
//	
//	@Test
//	public void changeColorWhenDiggedOnContagiousPotato() {
//		contagiousState.changeState(potato.getContext());
//		this.field.digPlot(mouseX, mouseY);
//		assertEquals(game.color(237, 14, 2), this.plot.getColor());
//	}
//	
//	
//
//}

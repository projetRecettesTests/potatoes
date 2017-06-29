package recetteTests.projet.potatoes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PotatoShould {
	Potato potato;
	
	@Before
	public void setUp() throws Exception {
		this.potato = new Potato();
		Potato.setSeed(1);
	}
	
	@Test
	public void beHealthyWhenCreated() {
		assertEquals("Healthy", this.potato.toString());
	}
	
	@Test
	public void changeStateFromHealthyToContaminated() {
		this.potato.changeState();
		assertEquals("Contaminated", this.potato.toString());
	}
	
	@Test
	public void changeStateFromContaminatedToContagious() {
		this.potato.setState(2);
		this.potato.changeState();
		assertEquals("Contagious", this.potato.toString());
	}
	
	@Test
	public void changeStateFromContagiousToDeadWhenContaminationPowerEqualsZero() {
		this.potato.setState(3);
		assertEquals("Contagious", this.potato.toString());
		assertEquals(1, this.potato.getContaminationPower());
		this.potato.changeState();
		assertEquals("Contagious", this.potato.toString());
		assertEquals(0, this.potato.getContaminationPower());
		this.potato.changeState();
		assertEquals("Dead", this.potato.toString());
	}
	
	@Test
	public void stayDead() {
		this.potato.setState(4);
		this.potato.changeState();
		assertEquals("Dead", this.potato.toString());
	}
	
}

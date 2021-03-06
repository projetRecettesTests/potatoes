package recetteTests.projet.potatoes;

import processing.core.PApplet;


public class Game extends PApplet {

	public final static int WIDTH = 1250;
	public final static int HEIGHT = 800;

	public Field field;

	public static void main(String[] args) {
		PApplet.main("recetteTests.projet.potatoes.Game");
	}

	@Override
	public void settings(){
		size(WIDTH, HEIGHT);
    }

	@Override
    public void setup(){
    	field = new Field(this);
    }

	@Override
    public void draw(){
		background(0x404040);
		field.display();

    }

	@Override
	public void mousePressed() {

		if (mouseButton == LEFT) {
			field.digPlot(mouseX, mouseY);
		} else if (mouseButton == RIGHT) {

		}
	}
}

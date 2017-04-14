package potatoes;

import processing.core.PApplet;


public class Game extends PApplet {

	public final static int WIDTH = 1250;
	public final static int HEIGHT = 800;

	Field field;


	public static void main(String[] args) {
		PApplet.main("potatoes.Game");
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


}

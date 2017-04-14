package potatoes;

import processing.core.PApplet;

public class Plot {

	public final static int PLOT_SIZE = 30;
	//public final int REG_COLOR = color(255);

	PApplet parent;

	private int x;
	private int y;
	private int color;

	public Plot(int x, int y, PApplet parent) {
		this.x = x;
		this.y = y;
		this.parent = parent;

	}

	public void display() {
		System.out.println("Pouet");
		parent.fill(parent.color(0, 153, 38));
		parent.rect(x,y,PLOT_SIZE,PLOT_SIZE);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}

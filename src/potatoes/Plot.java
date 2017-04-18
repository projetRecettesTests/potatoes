package potatoes;

import processing.core.PApplet;
import processing.core.PConstants;

public class Plot {

	public final static int PLOT_SIZE = 30;
	//public final int REG_COLOR = color(255);

	PApplet parent;
	Potatoe potatoe;

	private int x;
	private int y;
	private int color;

	public Plot(int x, int y, PApplet parent) {
		this.x = x;
		this.y = y;
		this.parent = parent;

		color = parent.color(0, 153, 38);

	}

	public void display() {
		parent.fill(color);
		parent.rectMode(PConstants.CENTER);
		parent.rect(x,y,PLOT_SIZE,PLOT_SIZE);
	}

	boolean inBounds(int posX, int posY) {

		if (posX >= x - PLOT_SIZE / 2 && posX <= x + PLOT_SIZE / 2) {
			if (posY >= y - PLOT_SIZE / 2 && posY <= y + PLOT_SIZE / 2) {
				color = parent.color(25, 255, 38);
				return true;
			}
		}

		return false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Potatoe getPotatoe() {
		return potatoe;
	}

	public void setPotatoe(Potatoe potatoe) {
		this.potatoe = potatoe;
	}



}

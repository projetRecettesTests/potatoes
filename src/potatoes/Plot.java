package potatoes;

import processing.core.PApplet;
import processing.core.PConstants;

public class Plot {

	public final static int PLOT_SIZE = 30;
	//public final int REG_COLOR = color(255);

	PApplet parent;
	Potato potato;

	private int x;
	private int y;
	private int color;

	public Plot(int x, int y, PApplet parent) {
		this.x = x;
		this.y = y;
		this.parent = parent;
		this.potato = new Potato();

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
				changeColor(parent.color(25, 255, 38));
				return true;
			}
		}

		return false;
	}

	public void checkPotato(){
		if (this.potato.getContext().getState().toString() ==  "Healthy State"){
			changeColor(parent.color(79, 36, 5));
		}
		else if (this.potato.getContext().getState().toString() ==  "Contaminated State"){
			changeColor(parent.color(249, 94, 4));
		}
		else if (this.potato.getContext().getState().toString() ==  "Contagious State"){
			changeColor(parent.color(237, 14, 2));
		}
	}

	public void changeColor(int color) {
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Potato getPotato() {
		return potato;
	}

	public void setPotato(Potato potato) {
		this.potato = potato;
	}



}

package recetteTests.projet.potatoes;

import java.util.List;

import processing.core.PApplet;
import processing.core.PConstants;

public class Plot {

	public final static int PLOT_SIZE = 30;
	//public final int REG_COLOR = color(255);

	PApplet parent;
	Potato potato;

	private int row;
	private int col;
	private int x;
	private int y;
	private int color;

	private boolean isDigged;

	List<Plot> Neighbors;

	public Plot(int row, int col, int x, int y, PApplet parent) {
		this.row = row;
		this.col = col;
		this.x = x;
		this.y = y;
		this.parent = parent;
		this.potato = new Potato();
		this.isDigged = false;

		color = parent.color(0, 153, 38);
	}

	public void display() {
		parent.fill(color);
		parent.rectMode(PConstants.CENTER);
		parent.rect(x,y,PLOT_SIZE,PLOT_SIZE);
		this.checkPotato();
	}

	boolean inBounds(int posX, int posY) {

		if (posX >= x - PLOT_SIZE / 2 && posX <= x + PLOT_SIZE / 2) {
			if (posY >= y - PLOT_SIZE / 2 && posY <= y + PLOT_SIZE / 2) {
				return true;
			}
		}

		return false;
	}

	public void checkPotato(){
		//if (this.isDigged){
			switch (this.potato.getState()){
			case 1 :
				setColor(parent.color(79, 36, 5));
				break;
			case 2 :
				setColor(parent.color(249, 94, 4));
				break;
			case 3 :
				setColor(parent.color(237, 14, 2));
			case 4 :
				setColor(parent.color(0, 0, 0));
			}

		//}
		System.out.println(this.potato.toString());
	}

	public boolean dig() {
		if(!this.isDigged) {
			this.setDigged(true);
			this.checkPotato();
			return true;
		}
		return false;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public Potato getPotato() {
		return potato;
	}

	public void setPotato(Potato potato) {
		this.potato = potato;
	}

	public boolean isDigged() {
		return this.isDigged;
	}

	public void setDigged(boolean isDigged) {
		this.isDigged = isDigged;
	}

	public List<Plot> getNeighbors() {
		return Neighbors;
	}

	public void setNeighbors(List<Plot> neighbors) {
		Neighbors = neighbors;
	}


}

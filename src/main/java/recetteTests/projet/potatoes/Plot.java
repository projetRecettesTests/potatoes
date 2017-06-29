package recetteTests.projet.potatoes;

import java.util.List;

import processing.core.PApplet;

public class Plot {

	public final static int PLOT_SIZE = 30;
	//public final int REG_COLOR = color(255);

	PApplet parent;
	Potato potato;
	
	private PlotView plotView;

	private int row;
	private int col;
	private int x;
	private int y;

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
		this.plotView = new PlotView(this.parent, parent.color(0, 153, 38), this.x, this.y, this.PLOT_SIZE);
	}

	public void display() {
		this.plotView.displayPlot();
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
		if (this.isDigged){
			switch (this.potato.getState()){
			case 1 :
				plotView.setColor(parent.color(79, 36, 5));
				break;
			case 2 :
				plotView.setColor(parent.color(249, 94, 4));
				break;
			case 3 :
				plotView.setColor(parent.color(237, 14, 2));
				break;
			case 4 :
				plotView.setColor(parent.color(0, 0, 0));
				break;
			}

		}
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
		return this.plotView.getColor();
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

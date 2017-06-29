package recetteTests.projet.potatoes;

import processing.core.PApplet;
import processing.core.PConstants;

public class PlotView {

	private PApplet parent;
	
	private int color;
	private int x;
	private int y;
	private int plotSize;

	public PlotView(PApplet parent, int color, int x, int y, int plotSize) {
		this.parent = parent;
		this.color = color;
		this.x = x;
		this.y = y;
		this.plotSize = plotSize;
	}

	public void displayPlot() {
		// TODO Auto-generated method stub
		parent.fill(color);
		parent.rectMode(PConstants.CENTER);
		parent.rect(x,y,plotSize,plotSize);
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public int getColor() {
		return this.color;
	}
}

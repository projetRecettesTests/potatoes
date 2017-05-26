package recetteTests.projet.potatoes;

import processing.core.PApplet;
import processing.core.PConstants;

public class PlotView {

	private PApplet parent;
	private int color;
	private int x;
	private int y;
	private int PLOT_SIZE;
	
	

	public PlotView(PApplet parent, int color, int x, int y, int pLOT_SIZE) {
		this.parent = parent;
		this.color = color;
		this.x = x;
		this.y = y;
		PLOT_SIZE = pLOT_SIZE;
	}



	public void displayPlot() {
		// TODO Auto-generated method stub
		parent.fill(color);
		parent.rectMode(PConstants.CENTER);
		parent.rect(x,y,PLOT_SIZE,PLOT_SIZE);
	}
	
	

}

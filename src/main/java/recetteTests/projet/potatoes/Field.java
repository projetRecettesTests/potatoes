package recetteTests.projet.potatoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import processing.core.PApplet;

public class Field {

	public final static int ROWS = 20;
	public final static int COLS = 40;
	public final static int PLOT_SIZE = 30;
	public final static int MARGIN = 40;

	PApplet parent;
	Plot[][] plots;
	List<Plot> contaminatedPlots;

	HealthyState healthyState = new HealthyState();
	ContaminatedState contaminatedState = new ContaminatedState();

	Random r = new Random();

	public Field(PApplet parent) {
		this.parent = parent;
		generateField();
	}

	private void generateField() {
		plots = new Plot[ROWS][COLS];
		
		contaminatedPlots = new ArrayList<>();

		int randX = r.nextInt((COLS - 2) - 1) + 2;
		int randY = r.nextInt((ROWS - 2) - 1) + 2;

		System.out.println(randX + " " + randY);

		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				int x = c * PLOT_SIZE + MARGIN; // cols at
												// x=40,70,100,130,150,190,220,250,280,310
				int y = r * PLOT_SIZE + MARGIN; // rows at
												// y=60,90,120,150,180,210,240,270,300,330
				plots[r][c] = new Plot(r, c, x, y, parent);

				if(c == randX && r == randY) {
					contaminatedState.changeState(plots[r][c].getPotato().getContext());
					contaminatedPlots.add(plots[r][c]);
				}
				else {
					healthyState.changeState(plots[r][c].getPotato().getContext());
				}

			}
		}
		
		for(int i = 0 ; i < ROWS ; i++) {
			for(int j = 0 ; j < COLS ; j++){
				this.findPlotNeighbors(plots[i][j]);
			}
		}		
	}

	public void display() {
		for(int i = 0 ; i < ROWS ; i++) {
			for(int j = 0 ; j < COLS ; j++){
				plots[i][j].display();
			}
		}
	}

	public void digPlot(int mouseX, int mouseY) {
		Plot selectedPlot = getSelectedPlot(mouseX, mouseY);
		if (selectedPlot != null){
			if(selectedPlot.dig()) {
//				System.out.println("x : " + selectedPlot.getX() + " y : " + selectedPlot.getY()
//				+ " : " + getPotatoState(selectedPlot));
				this.contaminate();
			}
			
		}
	}
	
	public void contaminate(){
		List<Plot> neighbors;
		for(Plot contaminatedPlot : contaminatedPlots){
			neighbors = contaminatedPlot.getNeighbors();
			for(Plot neighbor : neighbors){
				contaminatedState.changeState(neighbor.getPotato().getContext());
			}
		}
	}

	public Plot getSelectedPlot(int mouseX, int mouseY) {
		Plot selectedPlot = null;
		for(int i = 0 ; i < ROWS ; i++) {
			for(int j = 0 ; j < COLS ; j++){
				if (plots[i][j].inBounds(mouseX, mouseY)) {
					selectedPlot = plots[i][j];
				}
			}
		}
		return selectedPlot;
	}
	
	public String getPotatoState(Plot plot) {
		return plot.getPotato().getContext().getState().toString();
	}

	public static int getCols() {
		return COLS;
	}

	public Plot[][] getPlots() {
		return plots;
	}
	
	public void findPlotNeighbors(Plot plot){	
		List<Plot> neigbhors = new ArrayList<>();
		
		for(int i = plot.getRow() - 1  ; i <= plot.getRow()+1 && i < ROWS && i >= 0 ; i++){
			for(int j = plot.getCol() - 1  ; j <= plot.getCol()+1 && j < COLS && j >= 0 ; j++){
				neigbhors.add(plots[i][j]);
			}
		}
		plot.setNeighbors(neigbhors);	
	}

}

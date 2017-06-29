package recetteTests.projet.potatoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import static javax.swing.JOptionPane.*;

import processing.core.PApplet;

public class Field {

	private final static int ROWS = 20;
	private final static int COLS = 40;
	private final static int PLOT_SIZE = 30;
	private final static int MARGIN = 40;
	private final static int DEFAULT_SEED = 40;

	private static long seed = DEFAULT_SEED;
	
	private PApplet parent;
	private Plot[][] plots;
	
	private List<Plot> unhealthyPlots;

	private Random randomizer = new Random();

	public Field(PApplet parent) {
		this.parent = parent;
		
		if(seed != DEFAULT_SEED) {
			randomizer.setSeed(seed);
		}
		
		generateField();
	}

	public void generateField() {
		plots = new Plot[ROWS][COLS];

		setUnhealthyPlots(new ArrayList<>());
		
		int randX = randomizer.nextInt((COLS - 2) - 1) + 2;
		int randY = randomizer.nextInt((ROWS - 2) - 1) + 2;

		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				int x = c * PLOT_SIZE + MARGIN; // cols at
												// x=40,70,100,130,150,190,220,250,280,310
				int y = r * PLOT_SIZE + MARGIN; // rows at
												// y=60,90,120,150,180,210,240,270,300,330
				plots[r][c] = new Plot(r, c, x, y, parent);

				if(c == randX && r == randY) {
					putFirstContaminatedPotato(plots[r][c]);
				}

			}
		}

		for(int i = 0 ; i < ROWS ; i++) {
			for(int j = 0 ; j < COLS ; j++){
				this.findPlotNeighbors(plots[i][j]);
			}
		}
	}

	public void putFirstContaminatedPotato(Plot plot) {
		plot.getPotato().changeState();
		getUnhealthyPlots().add(plot);

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
				this.contaminate();
				if(selectedPlot.getPotato().isContagious()) {
					this.digAllPlots();
					showMessageDialog(null, "Oh oh, cette pomme de terre a une drôle de tête... \n"
							+ "Elle n'a vraiment pas l'air en forme, je me demande ce que... \n"
							+ "AIE ! Elle m'a mordu ! AAH NOOON, A L'AIDE ! AAARG !",
						    "T'es mort", ERROR_MESSAGE);
					System.out.println("You're DEAD motherfucker !");
				}
			}

		}
	}

	public void contaminate(){
		findContaminatedPotatoes();
		boolean ok;
		List<Plot> neighbors;

		for(Plot unhealthyPlot : getUnhealthyPlots()){
			if(unhealthyPlot.getPotato().isContagious()) {
				ok = false;
				neighbors = unhealthyPlot.getNeighbors();
				Collections.shuffle(neighbors);
				int i = 0;
				while(!ok && i < neighbors.size()-1) {
					Plot neighbor = neighbors.get(i);
					if(neighbor.getPotato().isHealthy() && !neighbor.isDigged()) {
						ok = true;
						neighbor.getPotato().changeState();
					}
					i++;
				}
			}
			if (!unhealthyPlot.isDigged()){
				unhealthyPlot.getPotato().changeState();			
			}

		}
	}
	
	public void findContaminatedPotatoes() {
		getUnhealthyPlots().clear();
		for(int i = 0 ; i < ROWS ; i++) {
			for(int j = 0 ; j < COLS ; j++){
				if (!plots[i][j].getPotato().isHealthy()) {
					getUnhealthyPlots().add(plots[i][j]);
				}
			}
		}
	}

	public void findPlotNeighbors(Plot plot){
		List<Plot> neigbhors = new ArrayList<>();

		for(int i = plot.getRow() - 1  ; i <= plot.getRow()+1 && i < ROWS && i >= 0 ; i++){
			for(int j = plot.getCol() - 1  ; j <= plot.getCol()+1 && j < COLS && j >= 0 ; j++){
				if (!(i == plot.getRow() && j == plot.getCol())){
					neigbhors.add(plots[i][j]);
				}
			}
		}
		plot.setNeighbors(neigbhors);
	}

	public void digAllPlots(){
		for(int i = 0 ; i < ROWS ; i++) {
			for(int j = 0 ; j < COLS ; j++){
				plots[i][j].dig();
			}
		}
	}

	public static int getCols() {
		return COLS;
	}

	public Plot[][] getPlots() {
		return plots;
	}
	
	
	public static void setSeed(long s) {
		seed = s;
	}

	public List<Plot> getUnhealthyPlots() {
		return unhealthyPlots;
	}

	public void setUnhealthyPlots(List<Plot> unhealthyPlots) {
		this.unhealthyPlots = unhealthyPlots;
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
}

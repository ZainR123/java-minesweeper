package cw2a;

import java.awt.Color;
import java.util.Random;

public class Board {
	int HEIGHT = Psyzr2Main.HEIGHT;
    int WIDTH = Psyzr2Main.WIDTH;
    int NUM_MINES = Psyzr2Main.NUM_MINES;

    BoardSquareButton[][] array = new BoardSquareButton[WIDTH][HEIGHT];
    
	public BoardSquareButton getButton(int x, int y) {
		return array[x-1][y-1];
	}
	public void storeButton(int x, int y, BoardSquareButton button) {
		array[x-1][y-1] = button;
	}
	public void intialiseAll() {
		for(int x = 0; x < WIDTH; x++) {
			for(int y = 0; y < HEIGHT; y++) {
				array[x][y].initialise();
			}
		}
	}
	public void createMines(int NUM_MINES) {
		int minesPlaced = 0;
	    Random random = new Random();
	    while(minesPlaced < NUM_MINES) {
	    	int x = random.nextInt(WIDTH);
	    	int y = random.nextInt(HEIGHT);
	    	if(array[x][y].getMine() != true) {
	    		array[x][y].setMine(true);
	    		minesPlaced ++;
	    	}
	    }
	 }
	public void finished() {
		for(int x = 0; x < WIDTH; x++) {
			for(int y = 0; y < HEIGHT; y++) {
				if(array[x][y].getMine() && array[x][y].getPotentialMine() == true) {
				    array[x][y].setBackground(Color.orange);
				    array[x][y].setText("X");
				}
				if(array[x][y].getMine() == true && array[x][y].getPotentialMine() == false) {
				    array[x][y].setBackground(Color.red);
				    array[x][y].setText("X");
				}
				if(array[x][y].getMine() == false && array[x][y].getPotentialMine() == true) {
					array[x][y].setBackground(Color.red);
					countSurroundings(x,y);
				}
			}
		}
	}
	public boolean hasWon() {
		int counter = 0;
		
		for(int x = 0; x < WIDTH; x++) {
			for(int y = 0; y < HEIGHT; y++) {
				if(array[x][y].getInvestigated() == true && (array[x][y].getMine() == false)) {
					counter++;
				}
			}
		}
		int limit = (HEIGHT * WIDTH) - NUM_MINES;
		if(counter == limit) {
			return true;
		}
		else 
			return false;
		
	}
	public int countSurroundings(int x, int y) {
		int surroundingMines = 0;
		if(y-1 >= 0) {
			if(x-1 >= 0 && array[x-1][y-1].getMine() == true)
				surroundingMines++;
			if(array[x][y-1].getMine() == true)
				surroundingMines++;
			if(x+1 < WIDTH && array[x+1][y-1].getMine() == true)
				surroundingMines++;
		}
		
		if(x-1 >= 0 && array[x-1][y].getMine() == true)
			surroundingMines++;
		if(x+1 < WIDTH && array[x+1][y].getMine() == true)
			surroundingMines++;
		
		if(y+1 < HEIGHT) {
			if(x-1 >= 0 && array[x-1][y+1].getMine() == true)
				surroundingMines++;
			if(array[x][y+1].getMine() == true)
				surroundingMines++;
			if(x+1 < WIDTH && array[x+1][y+1].getMine() == true)
				surroundingMines++;
		}
		return surroundingMines;
		

	}
}
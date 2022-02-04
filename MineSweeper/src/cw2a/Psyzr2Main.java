package cw2a;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Psyzr2Main implements ActionListener{
	
	final static int WIDTH = 5, HEIGHT = 20, NUM_MINES = 5;
	Board game = new Board();

	public static void main(String[] args) {
		new Psyzr2Main();
	}
		
	public Psyzr2Main() {
		
		JFrame frame = new JFrame("Minesweeper");
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setLayout(new GridLayout(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Board game = new Board();
		for (int i = 0 ; i < WIDTH ; i++){
            for(int xset = 1; xset<=WIDTH; xset++) {
                for(int yset = 1; yset<=HEIGHT; yset++) {
                    game.storeButton(xset,yset,new BoardSquareButton(70,70,Color.GRAY,xset,yset));
                }             
            }
        }
		game.createMines(NUM_MINES);
	}

	
	public void createGUI() {
		frame.setSize(1200, 40*HEIGHT);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		grid.setLayout(new GridLayout(WIDTH, HEIGHT));
		for(int x = 0; x < WIDTH; x++) {
			for(int y = 0; y < HEIGHT; y++) {
				game.array[x][y] = new BoardSquareButton(y, y, null, y, y);
				game.array[x][y].addActionListener(this);
				grid.add(game.array[x][y]);
			}
		}
		frame.add(grid, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
		
	@Override
	public void actionPerformed(ActionEvent event) {
		Board game = new Board();
		if(event.getSource().equals(game.hasWon() == true)) {
			game.finished();
		}
		else {
			for (int x = 0; x < game.array.length; x++) {
				for(int y = 0; y <game.array[0].length; y++) {
					if(event.getSource().equals(game.array[x][y])) {
						if (game.countSurroundings(x, y) > 0) {
							game.array[x][y].setForeground(Color.red);
							game.array[x][y].setText("X");
							game.finished();
						}
						else {
							game.array[x][y].setText(game.countSurroundings(x, y) + "");
							game.array[x][y].setEnabled(false);
						}
					}
				}
			}
		}
	}
}

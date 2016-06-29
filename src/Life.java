/* Life.java
 * Author: Alyssa Lagimoniere
 * Submission Date: 2/27/15
 * 
 * Purpose: To populate the grid with random values and execute
 * Conway's Game of Life.
 * 
 * Statement of Academic Honesty: 
 * 
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with 
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing
 * or posting of source code for this project is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia. 
 */

import java.util.Random;
public class Life {

	public static void main(String[] args) {

		//Declare and define variables
		int gridSize = 200;
		int cellSize = 3;
		Grid grid = new Grid(gridSize, cellSize, "The Game of Life");
		grid.setDelay(0);
		int row = 0;
		int col = 0;
		int aliveColor = 1;
		int deadColor = 0;
		grid.update();
		
		//White line practice
		for (col = 25; col < 75; col++) {
				grid.setPos(10,col,1);
			}
		grid.update();
		grid.clearGrid();
		
		//Populate with random integers
		Random r = new Random();
		for (row = 0; row <= gridSize - 1; row++) {
			for (col = 0; col <= gridSize - 1; col++) {
				if (r.nextInt(100) > 49) {
					grid.setPos(row,col,aliveColor);
				} else {
					grid.setPos(row,col,deadColor);
				} 
			}
		}
		
		//Initialize grid
		grid.update();
		grid.initialize();
		
		//Retrieve the value of cell
		
		//Find neighbors
		
		//Play game
		/*if(cell == 1) {
            if(alives < 2) {
                    newArr[x][y] = 0;
            } else if(alives == 2 || alives == 3) {
                    newArr[x][y] = 1;
            } else if(alives > 3) {
                    newArr[x][y] = 0;
            }
    } else if(cell == 0 && alives == 3) {
            newArr[x][y] = 1; */
    
		while (true) {
			for (row = 0; row <= gridSize - 1; row++) {
				for (col = 0; col <= gridSize - 1; col++) {
					int val = grid.getPos(row,col);
					int n = grid.matchingNeighbors(row,col,aliveColor);
					if (val == aliveColor) {
						if (n == 2 || n == 3) {
							grid.setPos(row,col,aliveColor);
						} else {
							grid.setPos(row,col,deadColor);
						}
					} else if (val == deadColor && n == 3) {
						grid.setPos(row,col,aliveColor);
					}
				}
			} 
			grid.update();
		}
		
	}
}
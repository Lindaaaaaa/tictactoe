package tictaictoe;

import java.awt.Color;
import java.awt.Graphics;

public class Board {
  public static final int ROWS=3;
  public static final int COLS=3;
	
  Cell[][] cells;
  int currentRow;
  int currentCol;
  
  public  Board(){
	  cells =new Cell[ROWS][COLS];
	  int i,j;
	  for(i=0; i<ROWS; i++){
		  for(j=0;j<COLS;j++){
			  Cell singleCell= new Cell(i,j);
			  cells[i][j]=singleCell;
			
		  }
	  }
  }
  /**return true if no empty cell and no one wins the game*/
  public Boolean isDraw(){
	  int i,j;
	  for(i=0; i<ROWS; i++){
		  for(j=0;j<COLS;j++){
			  if(cells[i][j].content==Seed.EMPTY){
				  return false;
			  }
		  }
	  }
		  return true;
	  
  }
  
  
  /** initialize or reinitialize the contents of the game board*/
  public void init(){
	  int i,j;
	  for(i=0; i<ROWS; i++){
		  for(j=0;j<COLS;j++){
			  cells[i][j].clear();
		  }
	  }
  }
  
  /** Return true if the player with "theSeed" has won after placing at
  (currentRow, currentCol) */ 
  public Boolean hasWon(Seed s,int seedRow,int seedCol){
	  return (cells[seedRow][0].content == s        // 3-in-the-row
              && cells[seedRow][1].content == s
              && cells[seedRow][2].content == s
         || cells[0][seedCol].content == s      // 3-in-the-column
              && cells[1][seedCol].content == s
              && cells[2][seedCol].content == s
         || currentRow == seedCol          // 3-in-the-diagonal
              && cells[0][0].content == s
              && cells[1][1].content == s
              && cells[2][2].content == s
         || seedRow + seedCol == 2    // 3-in-the-opposite-diagonal
              && cells[0][2].content == s
              && cells[1][1].content == s
              && cells[2][0].content == s);
     }
	
  
  /** Paint itself*/

  public void paint(Graphics g) {
      // Draw the grid-lines
      g.setColor(Color.GRAY);
      for (int row = 1; row < Game.ROWS; ++row) {
         g.fillRoundRect(0, Game.CELL_SIZE * row - Game.GRID_WIDHT_HALF,
               Game.CANVAS_WIDTH - 1, Game.GRID_WIDTH,
               Game.GRID_WIDTH, Game.GRID_WIDTH);
      }
      for (int col = 1; col < Game.COLS; ++col) {
         g.fillRoundRect(Game.CELL_SIZE * col - Game.GRID_WIDHT_HALF, 0,
               Game.GRID_WIDTH, Game.CANVAS_HEIGHT - 1,
               Game.GRID_WIDTH, Game.GRID_WIDTH);
      }
 
      // Draw all the cells
      for (int row = 0; row < Game.ROWS; ++row) {
         for (int col = 0; col < Game.COLS; ++col) {
            cells[row][col].paint(g);  // ask the cell to paint itself
         }
      }
   }
}
  

package tictaictoe;

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
			  cells[i][j].paint();
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
	  if(hasWon(Seed.CIRCLE)||hasWon(Seed.CROSS)){
		  return false;
	  }
	  else
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
  public Boolean hasWon(Seed s){
	  return (cells[currentRow][0].content == s        // 3-in-the-row
              && cells[currentRow][1].content == s
              && cells[currentRow][2].content == s
         || cells[0][currentCol].content == s      // 3-in-the-column
              && cells[1][currentCol].content == s
              && cells[2][currentCol].content == s
         || currentRow == currentCol            // 3-in-the-diagonal
              && cells[0][0].content == s
              && cells[1][1].content == s
              && cells[2][2].content == s
         || currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
              && cells[0][2].content == s
              && cells[1][1].content == s
              && cells[2][0].content == s);
     }
	
  
  /** Paint itself*/

	  public void paint() {
	      for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	            cells[row][col].paint();   // each cell paints itself
	            if (col < COLS - 1) System.out.print("|");
	         }
	         System.out.println();
	         if (row < ROWS - 1) {
	            System.out.println("-----------");
	         }
	      }
	   }
}
  

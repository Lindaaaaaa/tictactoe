package tictaictoe;
import java.util.Scanner;



public class Game  {
   private Board board;           
   private GameState currentState; 
   private Seed currentPlayer;  
   private static Scanner in = new Scanner(System.in);  // input Scanner
 
   /** Constructor to setup the game */
   public Game() {
      board = new Board();  // allocate game-board
 
      // Initialize the game-board and current status
      board.init();  
      currentPlayer = Seed.CROSS;      
      currentState = GameState.PLAYING; 
      // Play the game once. Players CROSS and NOUGHT move alternately.
      do {
         playerMove(currentPlayer); // update the content, currentRow and currentCol
         board.paint();             // ask the board to paint itself
         updateGame(currentPlayer); // update currentState
         // Print message if game-over
         if (currentState == GameState.CROSS_WON) {
            System.out.println("'X' won! Bye!");
         } else if (currentState == GameState.CIRCILE_WON) {
            System.out.println("'O' won! Bye!");
         } else if (currentState == GameState.DRAW) {
            System.out.println("It's Draw! Bye!");
         }
         // Switch player
         currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.CIRCLE : Seed.CROSS;
      } while (currentState == GameState.PLAYING);  // repeat until game-over
   }
 
 
 
   /** The player with "theSeed" makes one move, with input validation.
       Update Cell's content, Board's currentRow and currentCol. */
   public void playerMove(Seed theSeed) {
      boolean validInput = false;  // for validating input
      do {
         if (theSeed == Seed.CROSS) {
            System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
         } else {
            System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
         }
         int row = in.nextInt() - 1;
         int col = in.nextInt() - 1;
         if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS
               && board.cells[row][col].content == Seed.EMPTY) {
            board.cells[row][col].content = theSeed;
            board.currentRow = row;
            board.currentCol = col;
            validInput = true; // input okay, exit loop
         } else {
            System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                  + ") is not valid. Try again...");
         }
      } while (!validInput);   // repeat until input is valid
   }
 
   /** Update the currentState after the player with "theSeed" has moved */
   public void updateGame(Seed theSeed) {
      if (board.hasWon(theSeed)) {  // check for win
         currentState = (theSeed == Seed.CROSS) ? GameState.CROSS_WON : GameState.CIRCILE_WON;
      } else if (board.isDraw()) {  // check for draw
         currentState = GameState.DRAW;
      }
      // Otherwise, no change to current state (still GameState.PLAYING).
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
      new Game();  // Let the constructor do the job
   }
}
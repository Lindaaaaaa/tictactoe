package tictaictoe;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Cell {
 Seed content;
 int row;
 int col;
 


public  Cell(int row, int col){
	 this.content= Seed.EMPTY;
	 this.row=row;
	 this.col=col;
 }
 
 /** Clear the cell content to Empty.*/
 public void clear(){
	 content=Seed.EMPTY;
 }
 
 /**Paint itself
 * @param g */

	 public void paint(Graphics g) {
	      // Use Graphics2D which allows us to set the pen's stroke
	      Graphics2D g2d = (Graphics2D)g;
	      g2d.setStroke(new BasicStroke(Game.SYMBOL_STROKE_WIDTH,
	            BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Graphics2D only
	      // Draw the Seed if it is not empty
	      int x1 = col * Game.CELL_SIZE + Game.CELL_PADDING;
	      int y1 = row * Game.CELL_SIZE + Game.CELL_PADDING;
	      if (content == Seed.CROSS) {
	         g2d.setColor(Color.RED);
	         int x2 = (col + 1) * Game.CELL_SIZE - Game.CELL_PADDING;
	         int y2 = (row + 1) * Game.CELL_SIZE - Game.CELL_PADDING;
	         g2d.drawLine(x1, y1, x2, y2);
	         g2d.drawLine(x2, y1, x1, y2);
	      } else if (content == Seed.CIRCLE) {
	         g2d.setColor(Color.BLUE);
	         g2d.drawOval(x1, y1, Game.SYMBOL_SIZE, Game.SYMBOL_SIZE);
	      }
	   }
 }


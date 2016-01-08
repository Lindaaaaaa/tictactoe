package tictaictoe;

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
 
 /**Paint itself*/
 public void paint(){
	 switch(content){
	 case CROSS: System.out.print(" X ");
	 break;
	 case CIRCLE:System.out.print(" O ");
	 break;
	 case EMPTY:System.out.print("   ");
	 break;
	 }
 }
}

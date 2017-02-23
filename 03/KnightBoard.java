import java.util.*;
public class KnightBoard{

    private int[][] board;
    ArrayList<Integer> ListOfRows = new ArrayList<Integer>();    

    //===========================================================================
    ArrayList<Integer> PossibleRows =  new ArrayList<Integer>();
    ArrayList<Integer> PossibleCols =  new ArrayList<Integer>();

    //==================================================================

    public KnightBoard(int startingRows,int startingCols){
	board = new int[startingRows][startingCols];
	ListOfRows.add(-2);
	ListOfRows.add(-1);
	ListOfRows.add(1);
	ListOfRows.add(2);
    }

    public String toString(){ //blank if you never called solve or when there is no solution
	String ans="";
	for (int row = 0; row < board.length; row ++){
	    for (int col = 0; col < board[0].length; col++){
		ans += board[row][col];
	    }
	}
	return ans;
    }
    
    public void solve(){
	solveH(0,0,1);
    }

    private boolean solveH(int row ,int col, int level){ // level is the # of the knight
	if (level > row*col) return true;
	if (board[row][col] == 0){
	    board[row][col] = level;
	    //check all moves
	    //if any true, return true
	    if (
	    
	}
	return false;
    }
	
    public void findSpots(int row,int col){
	int change;
	for (int i: ListOfRows){
	    if (row - i >= 0 && row + i < board.length){
		if (i%2 == 0) change = 1;
		else change = 2;
		if (col-change >= 0){
		    PossibleRows.add(i);
		    PossibleCols.add(0-change);
		}
		if (col + change < board[0].length){
		    PossibleRows.add(i);
		    PossibleCols.add(change);
		}
	    }
	}
    }

    public static void main(String args[]){
	
    }

}

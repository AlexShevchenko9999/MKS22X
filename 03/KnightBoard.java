import java.util.*;
public class KnightBoard{

    private int[][] board;  
    private int[] ROWS= {-2,-2,-1,-1,1,1,2,2};
    private int[] COLS= {-1,1,-2,2,-2,2,-1,1};
    private int max;
    
    //============================================================================================
    ArrayList<Integer> PossibleRows = new ArrayList<Integer>();
    ArrayList<Integer> PossibleCols = new ArrayList<Integer>();

    //============================================================================================
    public KnightBoard(int startingRows,int startingCols){
	board = new int[startingRows][startingCols];
	max = startingRows * startingCols;
    }

    //============================================================================================

    public String toString(){ //blank if you never called solve or when there is no solution
	String ans="";
	for (int row = 0; row < board.length; row ++){
	    for (int col = 0; col < board[0].length; col++){
		if (board[row][col]/10 == 0) ans += " " + board[row][col] + " " ;
		else ans += board[row][col] + " " ;
	    }
	    ans += "\n";
	}
	return ans;
    }
    
    //============================================================================================ 
    public void solve(){
	solveH(2,2,1);
    }

    private boolean solveH(int row ,int col, int level){ // level is the # of the knight
	if (level > max)return true;
	if (board[row][col] == 0){
	    board[row][col] = level;
	    int ary[][] = findSpots(row, col);
	    for (int i = 0; i < ary[0].length; i ++){
		if (ary[0][i] != -1 && ary[1][i] != -1){
		    if (solveH(ary[0][i], ary[1][i], level+1)) return true;
		}
	    }
	    board[row][col] = 0;
	}
	return false;
    }
	
    //============================================================================================ 
    public int[][] findSpots(int row,int col){
	int[][] ans = new int[2][8];
	for (int place = 0; place < 8; place++){
	    if (row + ROWS[place] >= 0 &&
		row + ROWS[place] < board.length && 
		col + COLS[place] >= 0 &&
		col + COLS[place] < board[0].length
		){
		ans[0][place] = row + ROWS[place];
		ans[1][place] = col + COLS[place];
	    }
	    else { 
		ans[0][place] = -1;
		ans[1][place] = -1;
	    }
	}
	return ans;
    }
    
    private static void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }
    

    //============================================================================================ 
    public static void main(String args[]){
	KnightBoard K = new KnightBoard(5,5);
	K.solve();
	//K.findSpots(1,2);
	System.out.println(K);
    }

}

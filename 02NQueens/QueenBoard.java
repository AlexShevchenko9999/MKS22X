public class QueenBoard{
    private int[][]board;
    private int solutionCount=-1;
    
    public QueenBoard(int size){
	board = new int[size][size];
	for (int row = 0; row < board.length; row++){
	    for (int col = 0; col < board.length; col++){
		board[row][col] = 0;
	    }
	}
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public boolean solve()
    {
	return solveH(0);
    }

    private boolean solveH(int row){
	if (row >= board.length)return true;
	/*if (start < board.length && hasSpot(row,start)!=-1){
	    addQueen(row, hasSpot(row,start));
	    return solveH(row +1,0);
	    
	}else if(row > 0 && findQueen(row-1)!=-1){
	    int placeholder = findQueen(row-1);
	    removeQueen(row -1, placeholder);
	    return solveH(row-1,placeholder+1);
	    }*/
	for (int col = 0; col <  board.length; col ++){
	    if (board[row][col] == 0){
		addQueen(row,col);
		if (solveH(row+1)) return true;
		else removeQueen(row,col);
	    }
	}
	return false;
    }

    private void addQueen(int row, int col){
	board[row][col] = -1;
	for (int i = 1; i <= board.length; i++){
	    if ((i-1)!=col) board[row][i-1] += 1;
	    if ((i-1)!=row) board[i-1][col] += 1;
	    if (row+i < board.length && col+i < board.length) board[row+i][col+i] += 1;
	    if (row-i >= 0 && col-i >= 0) board[row-i][col-i] += 1;
	    if (row+i < board.length && col-i >= 0) board[row+i][col-i] += 1;
            if (row-i >= 0 && col+i < board.length) board[row-i][col+i] +=1;
	}
    }

    private void removeQueen(int row, int col){
	board[row][col] = 0;
	for (int i = 1;i <= board.length; i++){
	    if ((i-1)!=col) board[row][i-1] -= 1;
	    if ((i-1)!=row) board[i-1][col] -= 1;
	    if (row+i < board.length && col+i < board.length) board[row+i][col+i] -= 1;
	    if (row-i >= 0 && col-i >= 0) board[row-i][col-i] -= 1;
	    if (row+i < board.length && col-i >= 0) board[row+i][col-i] -= 1;
	    if (row-i >= 0 && col+i < board.length) board[row-i][col+i] -=1;
	}
    }
    /*
    private int findQueen(int row){
	for (int col = 0; col < board.length; col ++){
	    if (board[row][col] == -1){
                return col;
            }
        }
        return -1;
    }

    private int hasSpot(int row, int start){
	for (int i = start; i < board.length; i ++){
	    if (board[row][i] == 0){
		return i;
	    }
	}
	return -1;
	}

    
    */
    private void clear(){
	for (int row = 0; row < board.length; row ++){
	    for (int col = 0; col < board.length; col ++){
		board[row][col] = 0;
	    }
	}
    }
    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public void countSolutions(){
	solutionCount = 0;
	countH(0);
    }
    
    public void countH(int row){
	if (row >= board.length){
	    solutionCount+=1;
	    return;
	}
	for (int col = 0; col <  board.length; col ++){
            if (board[row][col] == 0){
                addQueen(row,col);
                countH(row+1); 
		removeQueen(row,col);
	    }
        }
    }
        
    public int getSolutionCount(){
	return solutionCount;
    }

    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
	String ans = "";
	for (int row = 0; row < board.length; row ++){
	    for (int col = 0; col < board.length; col ++){
		ans += board[row][col] + "  ";
	    }
	    ans+="\n";
	}
	return ans;
    }

    public static void main(String []args){
	for(int i = 1 ;i < 10; i++){
	    QueenBoard q = new QueenBoard(i);
	    q.solve();
	    System.out.println(q);
	    q.clear();
	    q.countSolutions();
	    System.out.println(q.getSolutionCount());
	}
	                                                                                                                                       
    }
}
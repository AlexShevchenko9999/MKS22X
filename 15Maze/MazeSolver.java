public MazeSolver{
    
    private Maze board;
    private boolean animate;//spelled bolean wrong oops

    public MazeSolver(String filename) {  
	this(filename,false); 
    } 

    public MazeSolver(String filename, boolean animate){
	board = new Maze(filename);
	this.animate = animate;
    }


    public String toString(){
	if (animated) {
	    return board.toString(75);
	}
	return board.toString();
    }


    public void solve(){  
	solve(1);
    }

    
    public void solve(int style){
	
	boolean aStar = false;
	Frontier rest;

	if(x == 0) rest = new StackFrontier();	
	else if(x == 1) rest = new QueueFrontier();
	else if(x == 2) rest = new FrontierPriorityQueue();
	else if(x == 3){
	    rest = new FrontierPriorityQueue();
	    aStar = true;
	} else throw new IllegalArgumentException();
	
	rest.add(board.getStart());

	while (rest.size() > 0){
	    Location current = rest.next();
	    if (current.getDistToGoal() == 0){
		board.set(current.getRow(),current.getCol(), 'E');
		while (current.getPrev() != null){
		    current = current.getPrev;
		    board.set(current.getRow(),current.getCol(),'.');
		}
		board.set(current.getRow(),current.getCol(),'S');
		return;
	    }
	}

	if(board.get(current.getRow() + 1, current.getCol()) == ' '){
	    int r = current.getRow() + 1;
	    int c = current.getCol();
	    rest.add(new Location(r, c, current, distance(r, c, board.getStart()), distance(r, c, board.getEnd()), aStar));
	    board.set(r ,c ,'?');
	}    
	if(board.get(current.getRow() - 1, current.getCol()) == ' '){
	    int r = current.getRow() - 1;
	    int c = current.getCol();
	    rest.add(new Location(r, c, current, distance(r, c, board.getStart()), distance(r, c, board.getEnd()), aStar));
	    board.set(r ,c ,'?');
	}    
	if(board.get(current.getRow(), current.getCol() + 1) == ' '){
	    int r = current.getRow();
	    int c = current.getCol() + 1;
	    rest.add(new Location(r, c, current, distance(r, c, board.getStart()), distance(r, c, board.getEnd()), aStar));
	    board.set(r ,c ,'?');
	}    
	if(board.get(current.getRow(), current.getCol() - 1) == ' '){
	    int r = current.getRow();
	    int c = current.getCol() - 1;
	    rest.add(new Location(r, c, current, distance(r, c, board.getStart()), distance(r, c, board.getEnd()), aStar));
	    board.set(r ,c ,'?');
	}
	

    }

    private int distance(int row, int col, Location L){
	return Math.abs(L.getRow() - row) + Math.abs(L.getCol() - col);
    }

    private int distance(Location one, Location two){
	return Math.abs(two.getRow() - one.getRow()) + Math.abs(two.getCol() - one.getCol()); 
    }
    
}